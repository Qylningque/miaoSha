package top.linco.miaosha.redis;

public class MiaoshaUserKey extends BasePrefix {

    private static final int TOKEN_EXPIRE = 3600*24*2;

    public MiaoshaUserKey(int aExpireSeconds, String aPrefix) {
        super(aExpireSeconds, aPrefix);
    }

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
}
