package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.shopping.dao.OrderDetailDao;
import com.shopping.dao.OrderDetailDaoImplement;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class OrderDetailServiceImplement implements OrderDetailService {

    static OrderDetailDao orderDetailDao;
    static {
        orderDetailDao = new OrderDetailDaoImplement();
    }

    @Override
    public void orderdetailcreate(File ordd1) throws FileNotFoundException, IOException, SQLException {
        orderDetailDao.orderdetailcreate(ordd1);
    }

    @Override
    public void orderdetaildelete(int id) throws SQLException {
        orderDetailDao.orderdetaildelete(id);
    }

    @Override
    public void orderdetailupdate(int odidu, int odo, int odp, int odq, double odpr, double oda) throws SQLException {
        orderDetailDao.orderdetailupdate(odidu, odo, odp, odq, odpr, oda);
    }

//    @Override
//    public List<OrderDetail> orderdetailall() throws SQLException {
//        return null;
//    }

    @Override
    public void orderddetaildisplay() throws SQLException {
        orderDetailDao.orderddetaildisplay();
    }

    @Override
    public void orderdetailbyid(int id) throws SQLException {
        orderDetailDao.orderdetailbyid(id);
    }
}
