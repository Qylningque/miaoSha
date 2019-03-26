package top.linco.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.linco.miaosha.domain.User;
import top.linco.miaosha.redis.RedisService;
import top.linco.miaosha.redis.UserKey;
import top.linco.miaosha.result.Result;
import top.linco.miaosha.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello~";
    }
    /**
     * Thymeleaf页面模板测试
     */
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","linco");
        return "test";
    }
    /**
     * 数据库连接测试
     */
    @RequestMapping("/db/testGet")
    @ResponseBody
    public Result<User> testGet(){
        User user = userService.getById(1);
        return Result.success(user);
    }
    /**
     * 测试数据库事务
     */
    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> tx(){
        boolean flag = userService.tx();
        return Result.success(flag);
    }
    /**
     * 测试redis
     */
    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> testRedisGet(){
        User user = redisService.get(UserKey.getById,""+2,User.class);
        return Result.success(user);
    }

    /**
     * 测试redis
     */
    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<User> testRedisSet(){
        User user = new User();
        user.setId(3);
        user.setName("333");
        boolean flag = redisService.set(UserKey.getById,""+2,user);
        if (flag){
            User user2 = redisService.get(UserKey.getById,""+2,User.class);
            return Result.success(user2);
        }
        return Result.success(null);
    }
}
