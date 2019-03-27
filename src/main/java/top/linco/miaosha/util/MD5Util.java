package top.linco.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 实现MD5加密
 */
public class MD5Util {

    //自定义固定salt
    private static final String salt = "1a2b3c4d";

    /**
     * 用户密码加密
     * @param str
     * @param saltDB
     * @return
     */
    public static String inputPassToDBPass(String str,String saltDB){
        String formPass = inputPassFormPass(str);
        String dbPass = formPassToDBPass(formPass,saltDB);
        return dbPass;
    }

    /**
     * 第一层md5加密:固定盐
     * @param inputPass
     * @return
     */
    public static String inputPassFormPass(String inputPass){
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    /**
     * 第二层md5加密:第一次加密后的密文+随机盐
     * @param formPass
     * @param saltRadom
     * @return
     */
    public static String formPassToDBPass(String formPass,String saltRadom){
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    /**
     * md5加密
     * @param str
     * @return
     */
    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

/*    public static void main(String[] args) {
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }*/

}
