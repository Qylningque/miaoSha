package top.linco.miaosha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.linco.miaosha.result.Result;
import top.linco.miaosha.service.MiaoShaUserService;
import top.linco.miaosha.vo.LoginVo;

import javax.validation.Valid;

/**
 * 登录
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoShaUserService miaoShaUserService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo){
        log.info(loginVo.toString());
        miaoShaUserService.login(loginVo);
        return Result.success(true);
        /*
        HttpServletResponse response, @Valid LoginVo loginVo
        log.info(loginVo.toString());
        //登录
        User.login(response,loginVo);
        return Result.success(true);*/
    }
}
