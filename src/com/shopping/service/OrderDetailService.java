package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.shopping.domain.OrderDetail;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public interface OrderDetailService {

    public void orderdetailcreate(File ordd1) throws FileNotFoundException, IOException, SQLException;
    public void orderdetaildelete(int id) throws SQLException;
    public void orderdetailupdate(int odidu, int odo, int odp, int odq, double odpr, double oda) throws SQLException;
//    public List<OrderDetail> orderdetailall() throws SQLException;
    public void orderddetaildisplay() throws SQLException;
    public void orderdetailbyid(int id) throws SQLException;


}
