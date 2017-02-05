package com.shopping.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public interface OrderDao {

    public void ordercreate(File ord2) throws FileNotFoundException, IOException, SQLException, ParseException;
    public void orderdelete(int id) throws SQLException;
    public void orderupdate(int id, String odate, Double oamt, int ouid) throws SQLException;
//    public List<Order> orderall() throws SQLException;
    public void orderdisplay() throws SQLException;
    public void orderbyid(int id) throws SQLException;

}
