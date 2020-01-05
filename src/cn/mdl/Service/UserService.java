package cn.mdl.Service;

import cn.mdl.Pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    boolean addUser(User user) throws SQLException;

    boolean selectLogin(String username,String password) throws SQLException;

    List<User> findAll() throws Exception;

    boolean findUser(String username) throws Exception;

    boolean delUser(String id)throws  Exception;
}
