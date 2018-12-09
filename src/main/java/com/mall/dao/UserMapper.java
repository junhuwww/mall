package com.mall.dao;

import com.mall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);

    int checkEmail(String email);

    User selectLogin(@Param("username") String username , @Param("password") String password);

    String selectQuestionByUsername(String username);

    int checkAnswer(@Param("username")String username, @Param("question")String question, @Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username , @Param("password") String newPassword);

    int checkPassword(@Param("userId") Integer userId , @Param("oldPassword") String oldPassword);

    int checkEmailByUserId(@Param("userId") Integer userId , @Param("email") String email);

}