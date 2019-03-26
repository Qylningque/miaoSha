package top.linco.miaosha.redis;

/**
 * key的前缀接口
 */
public interface KeyPrefix {

    public int expireSeconds();//有效期

    public String getPrefix();

}
