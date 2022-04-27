package com.sendmail.dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {
    private static Singleton uniqueInstance;
  
  
    public static Singleton getInstance(){
        if (uniqueInstance == null){
        	uniqueInstance = new Singleton(); 
        }
        return uniqueInstance;
    }
        public Connection getConnection() {
        	Connection conn = null;
        	try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://192.168.43.29:3306/fmail_db","fmail_user","123456789");
                System.out.println("Connection Successfully to Mysql");
            }
            catch (Exception e) {
                System.out.println("Erreur de drivers JDBC : "+e.getMessage());
                e.printStackTrace();
            }
            return conn;
        }
        
}
