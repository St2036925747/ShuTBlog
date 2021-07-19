package self.projects.shutblog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import self.projects.shutblog.entity.UserEntity;

@Mapper
public interface UserMapper {
    int save(@Param("userEntity") UserEntity userEntity) throws Exception;
    //将需要修改的信息封装成对象，再进行更新。注意：不允许用它修改密码。
    int updateWholeObject(@Param("userEntity") UserEntity userEntity) throws Exception;
    int changePwd(@Param("userId") int userId, @Param("newPwd") String newPwd) throws Exception;
    int updateNickname(@Param("userId") int userId, @Param("newNickname") String newNickname);
    int updateRealName(@Param("userId") int userId, @Param("newRealName") String newRealName);
    int updateSex(@Param("userId") int userId, @Param("newSex") String newSex);
    int updatePhone(@Param("userId") int userId, @Param("newPhone") String newPhone);
    int updateAddress(@Param("userId") int userId, @Param("newAddress") String newAddress);
    UserEntity quaryById(int userId);
    String quaryPwdByEmail(String email);
    int quaryIdByEmail(String email);
}
