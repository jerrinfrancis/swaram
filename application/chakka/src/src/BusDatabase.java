package src;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JFrame;

public class BusDatabase {
	public String row[][] = {{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null}};
	public void BusTiming(String place) {
		try {		
			int i = 0;
			String username = "root";  
			System.out.println(place);
			String password = "chakka";
			String tablename = "BUS";
			Date date = new Date();
			@SuppressWarnings("deprecation")
			int hour = date.getHours();
			hour = 10;
			@SuppressWarnings("deprecation")
			int mint = date.getMinutes();
			String time = hour + ":" + mint;
			hour = hour+6;
			String end = hour + ":" + mint;
			String querry1 = "SELECT BUS_ID,ARRIVAL_TIME,FARE,ROUTE FROM " +tablename + " WHERE DESTINATION LIKE '%" + place + "%' OR ROUTE LIKE '%" + place + "%' AND (ARRIVAL_TIME BETWEEN '" + time + "' AND '" +end + "') ORDER BY ARRIVAL_TIME;";
			String url = "jdbc:mysql://localhost:3306/CHAKKA?useUnicode=yes&characterEncoding=UTF-8";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querry1);
			while (rs.next()&&i<13){
				row[i][0] = rs.getString(1);
				row[i][1] = rs.getString(2);
				row[i][2] = rs.getString(3);
				row[i][3] = rs.getString(4);
				i++;
				System.out.print(row[i-1][0] + " ");
				System.out.print(row[i-1][1] + " ");
				System.out.print(row[i-1][2] + " ");
				System.out.print(row[i-1][3]);
				System.out.println();
			}
			rs.close();
			stmt.close();
			con.close();
		}catch (Exception ex) {
			System.out.println(ex);
		}

	}


}
