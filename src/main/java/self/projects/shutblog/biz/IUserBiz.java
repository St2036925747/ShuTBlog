package self.projects.shutblog.biz;

import self.projects.shutblog.entity.UserEntity;

public interface IUserBiz {
    int userRegist(UserEntity userEntity);
    int updateUserBaseInfo(UserEntity userEntity);
    int changePwd(int userId, String oldPwd, String newPwd);
    int login(String email, String pwd);
    UserEntity getUserInfo(int userId);
    int getUserIdByEmail(String email);
}
