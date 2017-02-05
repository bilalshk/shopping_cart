package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.UserDao;
import com.shopping.dao.UserDaoImplement;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class UserServiceImplement implements UserService {

    static UserDao userDao;
    static {
        userDao = new UserDaoImplement();
    }

    @Override
    public void usercreate(File user1) throws FileNotFoundException, IOException, SQLException {
        userDao.usercreate(user1);
    }

    @Override
    public void userdelete(int id) throws SQLException {
        userDao.userdelete(id);
    }

    @Override
    public void userupdate(int id, String un, String fn, String ln, String add) throws SQLException {
        userDao.userupdate(id,un,fn,ln,add);
    }

    @Override
    public void userdisplay() throws SQLException{
        userDao.userdisplay();
    }

    @Override
    public void useriddisplay(int id) throws SQLException {
        userDao.useriddisplay(id);
    }
}
