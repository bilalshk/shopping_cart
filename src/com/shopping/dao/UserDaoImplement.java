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
import java.util.ArrayList;
import java.util.List;

import com.shopping.util.DBConnection;

/**
 * Created by bilalshaikh on 2/2/17.
 */
public class UserDaoImplement implements UserDao {

    static Connection con = DBConnection.getConnection();

    @Override
    public void usercreate(File user2) throws FileNotFoundException, IOException, SQLException {

        String insertqry = "insert into user (user_name, first_name, last_name, address) values (?,?,?,?)";

        File userread = user2;
        FileReader fr = new FileReader(userread);
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
        System.out.println("Inserted into user successfully");
        System.out.println();
    }

    @Override
    public void userdelete(int id) throws SQLException {

        String deleteqry = "delete from user where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted user " + id + " from user successfully");
        System.out.println();
        ps.close();

    }

    @Override
    public void userupdate(int id, String un, String fn, String ln, String add) throws SQLException {

        String updateqry = "update user set user_name=?, first_name=?, last_name=?, address=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setString(1, un);
        ps.setString(2, fn);
        ps.setString(3, ln);
        ps.setString(4, add);
        ps.setInt(5, id);
        ps.executeUpdate();

        System.out.println("Updated user " + id + " successfull");
        System.out.println();
        ps.close();

    }

    @Override
    public void userdisplay() throws SQLException {

        Statement stmt = null;
        String dispqry = "select * from user";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry);

        System.out.println("Display all the user table");

        while (rs.next()) {
            int id = rs.getInt(1);
            String un = rs.getString(2);
            String fn = rs.getString(3);
            String ln = rs.getString(4);
            String add = rs.getString(5);

            System.out.println();
            System.out.println("User Id: " + id + "\tUser Name: " + un + "\tFirst Name: fn" + fn + "\tLast Name: " + ln + "\tAddress: " + add);

        }
        rs.close();
        stmt.close();

    }

    @Override
    public void useriddisplay(int id) throws SQLException {

        Statement stmt = null;
        String dispqry1 = "select * from user where id =" + id;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(dispqry1);

        System.out.println();
        System.out.println("Displaying user details of userid " + id);

        while (rs.next()) {
            int id1 = rs.getInt(1);
            String un1 = rs.getString(2);
            String fn1 = rs.getString(3);
            String ln1 = rs.getString(4);
            String add1 = rs.getString(5);

            System.out.println();
            System.out.println("User Id: " + id1 + "\tUser Name: " + un1 + "\tFirst Name: " + fn1 + "\tLast Name: " + ln1 + "\tAddress: " + add1);

        }
        rs.close();
        stmt.close();
    }

}
