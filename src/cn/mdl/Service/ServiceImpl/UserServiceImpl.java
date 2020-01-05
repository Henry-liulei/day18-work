package cn.mdl.Service.ServiceImpl;

import cn.mdl.Dao.DaoImpl.UserDaoImpl;
import cn.mdl.Dao.UserDao;
import cn.mdl.Pojo.User;
import cn.mdl.Service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public boolean addUser(User user) throws SQLException {
        return userDao.insertUser(user)>0?true:false;
    }

    @Override
    public boolean selectLogin(String username, String password) throws SQLException {
        return userDao.selectLogin(username,password)!=null?true:false;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> users = userDao.selectAll();
        return users;
    }

    @Override
    public boolean findUser(String username) throws Exception {
        return userDao.selectUser(username)!=null?false:true;
    }

    @Override
    public boolean delUser(String id) throws Exception {
        return userDao.delUser(id)>0?true:false;
    }

}
