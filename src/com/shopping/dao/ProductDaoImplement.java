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

import com.shopping.util.DBConnection;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class ProductDaoImplement implements ProductDao {

    static Connection con = DBConnection.getConnection();

    @Override
    public void productcreate(File prod2) throws FileNotFoundException, IOException, SQLException {

        String insertqry = "insert into product (name, code, price, stock) values (?,?,?,?)";

        File prodread = prod2;
        FileReader fr = new FileReader(prodread);
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
            ps.setString(1, s2[0]);
            ps.setString(2, s2[1]);
            ps.setString(3, s2[2]);
            ps.setString(4, s2[3]);
            ps.executeUpdate();
            ps.close();

        }
        System.out.println();
        System.out.println("Inserted into product successfully");
        System.out.println();
    }

    @Override
    public void productdelete(int id) throws SQLException {

        String deleteqry = "delete from product where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted product " + id + " from product successfully");
        System.out.println();
        ps.close();

    }

    @Override
    public void productupdate(int id, String pn, String pc, Double pp, int ps) throws SQLException {

        String updateqry = "update product set name=?, code=?, price=?, stock=? where id = ?";

        PreparedStatement ps1 = con.prepareStatement(updateqry);
        ps1.setString(1, pn);
        ps1.setString(2, pc);
        ps1.setDouble(3, pp);
        ps1.setInt(4, ps);
        ps1.setInt(5, id);
        ps1.executeUpdate();

        System.out.println();
        System.out.println("Updated product " + id + " successfull");
        System.out.println();
        ps1.close();

    }

    @Override
    public void productdisplay() throws SQLException {

        Statement stmt = null;
        String dispqry = "select * from product";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry);

        System.out.println("Display all the product table");

        while (rs.next()) {
            int pid = rs.getInt(1);
            String pn = rs.getString(2);
            String pc = rs.getString(3);
            Double pp = rs.getDouble(4);
            int ps = rs.getInt(5);

            System.out.println();
            System.out.println("Product Id: " + pid + "\tProduct Name: " + pn + "\tProduct Code: " + pc + "\tProduct Price: " + pp + "\tProduct Stock: " + ps);

        }
        rs.close();
        stmt.close();

    }

    @Override
    public void productiddisplay(int id) throws SQLException {

        Statement stmt = null;
        String dispqry1 = "select * from product where id =" + id;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry1);

        System.out.println();
        System.out.println("Displaying product details of productid " + id);

        while (rs.next()) {
            int pid1 = rs.getInt(1);
            String pn1 = rs.getString(2);
            String pc1 = rs.getString(3);
            Double pp1 = rs.getDouble(4);
            int ps1 = rs.getInt(5);

            System.out.println();
            System.out.println("Product Id: " + pid1 + "\tProduct Name: " + pn1 + "\tProduct Code: " + pc1 + "\tProduct Price: " + pp1 + "\tProduct Stock: " + ps1);

        }
        rs.close();
        stmt.close();
    }
}
