package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.shopping.dao.OrderDao;
import com.shopping.dao.OrderDaoImplement;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class OrderServiceImplement implements OrderService {

    static OrderDao orderDao;
    static {
        orderDao = new OrderDaoImplement();
    }
    @Override
    public void ordercreate(File ord1) throws FileNotFoundException, IOException, SQLException, ParseException {
        orderDao.ordercreate(ord1);
    }

    @Override
    public void orderdelete(int id) throws SQLException {
        orderDao.orderdelete(id);

    }

    @Override
    public void orderupdate(int id, String odate, Double oamt, int ouid) throws SQLException {
        orderDao.orderupdate(id, odate, oamt, ouid);
    }

//    @Override
//    public List<Order> orderall() throws SQLException {
//        return null;
//    }
//

    @Override
    public void orderdisplay() throws SQLException {
        orderDao.orderdisplay();
    }

    @Override
    public void orderbyid(int id) throws SQLException {
        orderDao.orderbyid(id);
    }
}
