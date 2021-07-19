package self.projects.shutblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import self.projects.shutblog.biz.IUserBiz;
import self.projects.shutblog.entity.UserEntity;
import self.projects.shutblog.util.Result;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public @ResponseBody Result userRegist(@RequestBody UserEntity userEntity) {
        int res = userBiz.userRegist(userEntity);
        if (1 == res) return Result.ok("注册成功");
        else return Result.error("注册失败，请重试或者联系客服人员");
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.PUT)
    public @ResponseBody Result updateUserInfo(@RequestBody UserEntity userEntity) {
        int res = userBiz.updateUserBaseInfo(userEntity);
        if (1 == res) return Result.ok("修改成功");
        else return Result.error("修改失败，请重试或者联系客服人员");
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.PUT)
    public @ResponseBody Result changePwd(@RequestParam int userId, @RequestParam String oldPwd, @RequestParam String newPwd) {
        int res = userBiz.changePwd(userId, oldPwd, newPwd);
        if (1 == res) return Result.ok("密码修改成功");
        else if (-1 == res) return Result.error("原密码输入错误，请重试");
        else return Result.error("密码修改失败，请重试或者联系客服人员");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody Result login(@RequestParam String email, @RequestParam String pwd) {
        int res = userBiz.login(email, pwd);
        if (1 == res) return Result.ok("登录成功");
        else if (-1 == res) return Result.error("用户名密码错误，请重试");
        return Result.error("出错了");
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public @ResponseBody UserEntity getUserInfo(int userId) {
        return userBiz.getUserInfo(userId);
    }

    @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
    public @ResponseBody int getUserIdByEmail(@RequestParam String email) { return userBiz.getUserIdByEmail(email); }
}
