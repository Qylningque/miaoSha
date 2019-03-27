package top.linco.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.linco.miaosha.dao.MiaoShaUserDao;
import top.linco.miaosha.domain.MiaoShaUser;
import top.linco.miaosha.exception.GlobalException;
import top.linco.miaosha.result.CodeMsg;
import top.linco.miaosha.util.MD5Util;
import top.linco.miaosha.vo.LoginVo;

@Service
public class MiaoShaUserService {

    @Autowired
    MiaoShaUserDao miaoShaUserDao;

    public MiaoShaUser getById(Long id){
        return miaoShaUserDao.getById(id);
    }

    public boolean login(LoginVo loginVo) {
        if (loginVo == null){
            throw new  GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPassword = loginVo.getPassword();
        //判断手机号码是否存在
        MiaoShaUser miaoShaUser = getById(Long.parseLong(mobile));
        if (miaoShaUser == null){
            throw new  GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPassword = miaoShaUser.getPassword();
        String dbSalt = miaoShaUser.getSalt();
        String calcPassword = MD5Util.formPassToDBPass(formPassword,dbSalt);
        if(!calcPassword.equals(dbPassword)){
            throw new  GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        return true;
    }
}
