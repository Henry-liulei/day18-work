package cn.mdl.Dao.DaoImpl;

import cn.mdl.Dao.UserDao;
import cn.mdl.Pojo.User;
import cn.mdl.Utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner qr=new QueryRunner(C3P0Utils.getDateSource());
    @Override
    public int insertUser(User user) throws SQLException {
        String sql="insert into user values(null,?,?,?,?,?,?,?)";
        Object[] users=new Object[]{
          user.getUserName(),user.getUserPwd(),user.getSex(),user.getChk(),
          user.getSel(),user.getAddress(),user.getBirthday()
        };
        int i = qr.update(sql, users);
        return i;
    }

    @Override
    public User selectLogin(String username, String password) throws SQLException {
        String sql="select * from user where userName=? and userPwd=?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), username, password);
        return user;
    }

    @Override
    public List<User> selectAll() throws Exception {
        String sql="select * from user";
        List<User> userList = qr.query(sql, new BeanListHandler<User>(User.class));
        return userList;
    }

    @Override
    public User selectUser(String username) throws Exception {
        String sql="select * from user where userName=?";
        User user = qr.query(sql, new BeanHandler<User>(User.class),username);
        return user;
    }

    @Override
    public Integer delUser(String id) throws Exception {
        String sql="delete from user where id=?";
        int i = qr.update(sql, id);
        return i;
    }
}
