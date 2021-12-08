package com.firstsample.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoprojectApplication {
	public static Connection conn1;
	public static List<Integer> columns = new ArrayList<>();

	public static Connection connect_db()
    {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\jaika\\Desktop\\javaexample.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("----");
			String sql = "SELECT * FROM values_table"; 
			Statement stmt  = conn.createStatement();  
			ResultSet rs    = stmt.executeQuery(sql);  
        	while (rs.next()) {  
				columns.add(rs.getInt("Category_id"));
            }  
            return conn;
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return conn;
        }
    }

	public static void main(String[] args) {
		conn1 = connect_db();
		SpringApplication.run(DemoprojectApplication.class, args);
	}

}
