package top.linco.miaosha.redis;

public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;//过期时间

    private String preFix;//前缀

    public BasePrefix(String aPreFix){//0代表永不过期
        this(0,aPreFix);
    }

    public BasePrefix( int aExpireSeconds, String aPrefix) {
        this.expireSeconds = aExpireSeconds;
        this.preFix = aPrefix;
    }
    @Override
    public int expireSeconds() {//默认0代表永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":"+ preFix;
    }
}
