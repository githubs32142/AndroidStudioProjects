package com.wather.andrzej.jdbc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Admin on 08.12.2017.
 */

public class DAOConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DAOConf.JDBC_DRIVER);
            conn = DriverManager.getConnection(DAOConf.URL, DAOConf.LOGIN, DAOConf.PASSWORD);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                System.out.println("Błąd");
            }
        }
        return conn;
    }
}
