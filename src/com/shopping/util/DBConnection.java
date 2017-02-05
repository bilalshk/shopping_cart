package com.shopping.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by bilalshaikh on 1/25/17.
 */
public class DBConnection {
    public static Connection getConnection(){
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection con = null;
        try{
            fis = new FileInputStream("db.properties");
            props.load(fis);
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            con = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
        }
        catch (IOException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
