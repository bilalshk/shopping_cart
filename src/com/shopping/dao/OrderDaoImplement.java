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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.shopping.util.DBConnection;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class OrderDaoImplement implements OrderDao {

    Connection con = DBConnection.getConnection();

    @Override
    public void ordercreate(File ord2) throws FileNotFoundException, IOException, SQLException, ParseException {

        String insertqry = "insert into orders (order_date, amount, user_id) values (?,?,?)";

        File orderread = ord2;
        FileReader fr = new FileReader(orderread);
        BufferedReader br = new BufferedReader(fr);

        String u;
        int i = 0;
        String[] str = new String[3];

        while ((u = br.readLine()) != null) {
            str[i] = u;
            i++;
        }

        for (String s : str
                ) {
            String[] s2 = s.split(",");

            PreparedStatement ps = con.prepareStatement(insertqry);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(s2[0]);
            ps.setDate(1,new java.sql.Date(date.getTime()));
            ps.setString(2, s2[1]);
            ps.setString(3, s2[2]);
            ps.executeUpdate();
            ps.close();

        }
        System.out.println();
        System.out.println("Inserted into order successfully");
        System.out.println();
    }

    @Override
    public void orderdelete(int id) throws SQLException {

        String deleteqry = "delete from orders where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted order " + id + " from order successfully");
        System.out.println();
        ps.close();

    }

    @Override
    public void orderupdate(int id, String odate, Double oamt, int ouid) throws SQLException {

        String updateqry = "update orders set order_date=?, amount=?, user_id=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setString(1, odate);
        ps.setDouble(2, oamt);
        ps.setInt(3, ouid);
        ps.setInt(4, id);
        ps.executeUpdate();

        System.out.println("Updated user " + id + " successfull");
        System.out.println();
        ps.close();

    }

//    @Override
//    public List<Order> orderall() throws SQLException {
//        return null;
//    }
//
    @Override
    public void orderdisplay() throws SQLException {

        Statement stmt = null;
        String dispqry = "select * from orders";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry);

        System.out.println("Display all the order table");

        while (rs.next()) {
            int oid = rs.getInt(1);
            Date od = rs.getDate(2);
            Double oamt = rs.getDouble(3);
            int ouid = rs.getInt(4);

            System.out.println();
            System.out.println("Order Id: " + oid + "\tOrder Date: " + od + "\tOrder Amount: " + oamt + "\tUser Id: " + ouid);

        }
        rs.close();
        stmt.close();

    }

    @Override
    public void orderbyid(int id) throws SQLException {

        Statement stmt = null;
        String dispqry = "select * from orders where id = " +id;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry);

        System.out.println();
        System.out.println("Displaying order details of orderid " + id);

        while (rs.next()) {
            int oid1 = rs.getInt(1);
            Date od1 = rs.getDate(2);
            Double oamt1 = rs.getDouble(3);
            int ouid1 = rs.getInt(4);

            System.out.println();
            System.out.println("Order Id: " + oid1 + "\tOrder Date: " + od1 + "\tOrder Amount: " + oamt1 + "\tUser Id: " + ouid1);

        }
        rs.close();
        stmt.close();
    }
}
