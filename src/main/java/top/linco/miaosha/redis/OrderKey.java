package top.linco.miaosha.redis;

public class OrderKey extends BasePrefix {
    public OrderKey(int aExpireSeconds, String aPrefix) {
        super(aExpireSeconds, aPrefix);
    }
}
