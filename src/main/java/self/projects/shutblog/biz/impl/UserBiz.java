package self.projects.shutblog.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.projects.shutblog.biz.IUserBiz;
import self.projects.shutblog.entity.UserEntity;
import self.projects.shutblog.mapper.UserMapper;

@Service
public class UserBiz implements IUserBiz {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int userRegist(UserEntity userEntity) {
        try {
            return userMapper.save(userEntity);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int updateUserBaseInfo(UserEntity userEntity) {
        try {
            return userMapper.updateWholeObject(userEntity);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int changePwd(int userId, String oldPwd, String newPwd) {
        UserEntity userEntity = userMapper.quaryById(userId);
        try {
            if (!userMapper.quaryPwdByEmail(userEntity.getEmail()).equals(oldPwd))
                return -1; //如果前端输入的原密码与数据库中的原密码不符，则拒绝修改
            else return userMapper.changePwd(userId, newPwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -2; //数据库更新错误
        }
    }

    @Override
    public int login(String email, String pwd) {
        String truePwd = userMapper.quaryPwdByEmail(email);
        if (pwd.equals(truePwd))
            return 1;
        else return -1;
    }

    @Override
    public UserEntity getUserInfo(int userId) {
        return userMapper.quaryById(userId);
    }

    @Override
    public int getUserIdByEmail(String email) {
        return userMapper.quaryIdByEmail(email);
    }
}
