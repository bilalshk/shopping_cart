package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public interface UserService {

    public void usercreate(File user1) throws FileNotFoundException, IOException, SQLException;
    public void userdelete(int id) throws SQLException;
    public void userupdate(int id, String un, String fn, String ln, String add) throws SQLException;
    public void userdisplay() throws SQLException;
    public void useriddisplay(int id) throws SQLException;

}
