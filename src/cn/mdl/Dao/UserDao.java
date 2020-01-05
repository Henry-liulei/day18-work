package cn.mdl.Dao;

import cn.mdl.Pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int insertUser(User user) throws SQLException;

    User selectLogin(String username,String password) throws SQLException;

    List<User> selectAll()throws Exception;

    User selectUser(String username)throws Exception;

    Integer delUser(String id)throws  Exception;
}
