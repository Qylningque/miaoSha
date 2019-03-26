package top.linco.miaosha.redis;

public class UserKey extends BasePrefix {

    public UserKey(String aPreFix) {
        super(aPreFix);
    }
    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
