package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.shopping.domain.Order;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public interface ProductService {

    public void productcreate(File prod1) throws FileNotFoundException, IOException, SQLException;
    public void productdelete(int id) throws SQLException;
    public void productupdate(int id, String pn, String pc, Double pp, int ps) throws SQLException;
    public void productdisplay() throws SQLException;
    public void productiddisplay(int id) throws SQLException;

}
