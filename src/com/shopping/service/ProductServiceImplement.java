package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.shopping.dao.ProductDao;
import com.shopping.dao.ProductDaoImplement;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class ProductServiceImplement implements ProductService {

    static ProductDao productDao;
    static {
        productDao = new ProductDaoImplement();
    }

    @Override
    public void productcreate(File prod1) throws FileNotFoundException, IOException, SQLException {
        productDao.productcreate(prod1);
    }

    @Override
    public void productdelete(int id) throws SQLException {
        productDao.productdelete(id);
    }

    @Override
    public void productupdate(int id, String pn, String pc, Double pp, int ps) throws SQLException {
        productDao.productupdate(id, pn, pc, pp, ps);
    }

    @Override
    public void productdisplay() throws SQLException {
        productDao.productdisplay();
    }

    @Override
    public void productiddisplay(int id) throws SQLException {
        productDao.productiddisplay(id);
    }
}
