package com.shopping.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import com.shopping.domain.OrderDetail;
import com.shopping.util.DBConnection;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class OrderDetailDaoImplement implements OrderDetailDao{

    Connection con = DBConnection.getConnection();


    @Override
    public void orderdetailcreate(File ordd2) throws FileNotFoundException, IOException, SQLException {
        String qry = "insert into order_detail (order_id, product_id, quantity, price, amount) values (?,?,?,?,?)";
        File orderread = ordd2;
        FileReader fr = new FileReader(orderread);
        BufferedReader br = new BufferedReader(fr);

        String u;
        int i = 0;
        String[] str = new String[4];

        while ((u = br.readLine()) != null) {
            str[i] = u;
            i++;
        }

        for (String s : str
                ) {
            String[] s2 = s.split(",");
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, s2[0]);
            ps.setString(2, s2[1]);
            ps.setString(3, s2[2]);
            ps.setString(4, s2[3]);
            ps.setString(5, s2[3]);
            ps.executeUpdate();
            ps.close();
        }

        System.out.println();
        System.out.println("Inserted into order details successfully");
        System.out.println();

    }

    @Override
    public void orderdetaildelete(int id) throws SQLException {

        String deleteqry = "delete from order_detail where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted order detail " + id + " from order details successfully");
        System.out.println();
        ps.close();

    }

    @Override
    public void orderdetailupdate(int odidu, int odo, int odp, int odq, double odpr, double oda) throws SQLException {

        String updateqry = "update order_detail set order_id=?, product_id=?, quantity=?, price=?, amount=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setInt(1, odo);
        ps.setInt(2, odp);
        ps.setInt(3, odq);
        ps.setDouble(4, odpr);
        ps.setDouble(5, oda);
        ps.setInt(6, odidu);
        ps.executeUpdate();

        System.out.println("Updated user " + odidu + " successfull");
        System.out.println();
        ps.close();

    }

//    @Override
//    public List<OrderDetail> orderdetailall() throws SQLException {
//        return null;
//    }

    @Override
    public void orderddetaildisplay() throws SQLException {

        Statement stmt = null;
        String dispqry = "select * from order_detail";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry);

        System.out.println("Display all the order detail table");

        while (rs.next()) {
            int odid1 = rs.getInt(1);
            int odo1 = rs.getInt(2);
            int odp1 = rs.getInt(3);
            int odq1 = rs.getInt(4);
            double odpr1 = rs.getDouble(5);
            double oda1 = rs.getDouble(6);

            System.out.println();
            System.out.println("Order Detail Id: " + odid1 + "\tOrder ID: " + odo1 + "\tProduct ID: " + odp1 + "\tQuantity: " + odq1 + "\tPrice: " + odpr1 + "\tAmount: " +oda1);

        }
        rs.close();
        stmt.close();

    }

    @Override
    public void orderdetailbyid(int id) throws SQLException {

        Statement stmt = null;
        String dispqry = "select * from order_detail where id = " +id;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry);

        System.out.println();
        System.out.println("Displaying order details of orderid " + id);

        while (rs.next()) {
            int odid2 = rs.getInt(1);
            int odo2 = rs.getInt(2);
            int odp2 = rs.getInt(3);
            int odq2 = rs.getInt(4);
            double odpr2 = rs.getDouble(5);
            double oda2 = rs.getDouble(6);

            System.out.println();
            System.out.println("Order Detail Id: " + odid2 + "\tOrder ID: " + odo2 + "\tProduct ID: " + odp2 + "\tQuantity: " + odq2 + "\tPrice: " + odpr2 + "\tAmount: " +oda2);

        }
        rs.close();
        stmt.close();
    }
}
