/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_meianly.salsa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sam
 */
public class ConnectionUtil {
    
    private static Connection koneksi_meianly;

    public static Connection getConnection() {
        if (koneksi_meianly == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/meianly_music_store";
                String user = "root";
                String password = "";

                koneksi_meianly = DriverManager.getConnection(url, user, password);
                System.out.println("CONNECTED");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return koneksi_meianly;
    }
}