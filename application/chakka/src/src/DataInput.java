package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataInput {

	
	DataInput() throws ClassNotFoundException, SQLException{
	String username  = "root";  
	String password  = "chakka";
	String querry    = "CREATE DATABASE CHAKKA";
	String querryDrop= "DROP DATABASE CHAKKA";
	String querry0   = "USE CHAKKA";
	String querry0a  = "CREATE TABLE BUS (BUS_ID VARCHAR(9) NOT NULL, DESTINATION NVARCHAR(25) NOT NULL, ARRIVAL_TIME TIME NOT NULL, FARE FLOAT(5,2) NOT NULL, ROUTE NVARCHAR(50), PRIMARY KEY (BUS_ID,ARRIVAL_TIME)) CHARACTER SET utf8 COLLATE utf8_unicode_ci;";
	String querry1   = "INSERT INTO BUS VALUES('KL010001','തമ്പാനൂര്‍ ','10:10','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry1a  = "INSERT INTO BUS VALUES('KL010001','തമ്പാനൂര്‍ ','13:00','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry1b  = "INSERT INTO BUS VALUES('KL010001','തമ്പാനൂര്‍ ','16:30','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry1c  = "INSERT INTO BUS VALUES('KL010001','തമ്പാനൂര്‍ ','18:15','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry2   = "INSERT INTO BUS VALUES('KL010002','തമ്പാനൂര്‍ ','11:00','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry2a  = "INSERT INTO BUS VALUES('KL010002','തമ്പാനൂര്‍ ','13:15','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry2b  = "INSERT INTO BUS VALUES('KL010002','തമ്പാനൂര്‍ ','15:30','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry2c  = "INSERT INTO BUS VALUES('KL010002','തമ്പാനൂര്‍ ','17:45','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry3   = "INSERT INTO BUS VALUES('KL020001','ആറ്റിങ്ങല്‍ ','10:00','10.50','കാര്യവട്ടം');";
	String querry3a  = "INSERT INTO BUS VALUES('KL020001','ആറ്റിങ്ങല്‍ ','11:00','10.50','കാര്യവട്ടം');";
	String querry3b  = "INSERT INTO BUS VALUES('KL020001','ആറ്റിങ്ങല്‍ ','14:00','10.50','കാര്യവട്ടം');";
	String querry3c  = "INSERT INTO BUS VALUES('KL020001','ആറ്റിങ്ങല്‍ ','16:00','10.50','കാര്യവട്ടം');";
	String querry4   = "INSERT INTO BUS VALUES('KL020002','ആറ്റിങ്ങല്‍ ','12:00','19.50','കുളത്തൂർ');";
	String querry4a  = "INSERT INTO BUS VALUES('KL020002','ആറ്റിങ്ങല്‍ ','13:00','19.50','കുളത്തൂർ');";
	String querry4b  = "INSERT INTO BUS VALUES('KL020002','ആറ്റിങ്ങല്‍ ','15:00','19.50','കുളത്തൂർ');";
	String querry4c  = "INSERT INTO BUS VALUES('KL020002','ആറ്റിങ്ങല്‍ ','18:00','19.50','കുളത്തൂർ');";
	String querry5   = "INSERT INTO BUS VALUES('KL030001','കിഴക്കേകോട്ട','10:00','11.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry5a  = "INSERT INTO BUS VALUES('KL030001','കിഴക്കേകോട്ട','11:00','11.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry5b  = "INSERT INTO BUS VALUES('KL030001','കിഴക്കേകോട്ട','12:00','11.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry5c  = "INSERT INTO BUS VALUES('KL030001','കിഴക്കേകോട്ട','13:00','11.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry5d  = "INSERT INTO BUS VALUES('KL030001','കിഴക്കേകോട്ട','15:00','11.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പാളയം');";
	String querry6   = "INSERT INTO BUS VALUES('KL030002','കിഴക്കേകോട്ട','11:30','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry6a  = "INSERT INTO BUS VALUES('KL030002','കിഴക്കേകോട്ട','13:35','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry6b  = "INSERT INTO BUS VALUES('KL030002','കിഴക്കേകോട്ട','15:30','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry6c  = "INSERT INTO BUS VALUES('KL030002','കിഴക്കേകോട്ട','16:45','12.00','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry6d  = "INSERT INTO BUS VALUES('KL030002','കിഴക്കേകോട്ട','18:00','10.50','കേശവദാസപുരം,പട്ടം,പാളയം');";
	String querry7   = "INSERT INTO BUS VALUES('KL040001','പേരൂര്‍കട','10:00','9.50','മെടിക്കല്‍കോളേജ്,പട്ടം');";
	String querry7a  = "INSERT INTO BUS VALUES('KL040001','പേരൂര്‍കട','12:00','8.50','മെടിക്കല്‍കോളേജ്,പട്ടം');";
	String querry7b  = "INSERT INTO BUS VALUES('KL040001','പേരൂര്‍കട','14:00','9.50','മെടിക്കല്‍കോളേജ്,പട്ടം');";
	String querry7c  = "INSERT INTO BUS VALUES('KL040001','പേരൂര്‍കട','16:00','8.50','മെടിക്കല്‍കോളേജ്,പട്ടം');";
	String querry8   = "INSERT INTO BUS VALUES('KL040002','പേരൂര്‍കട','11:00','7.50','ഉള്ളൂർ,കേശവദാസപുരം,വെഞ്ഞാറമൂട്');";
	String querry8a  = "INSERT INTO BUS VALUES('KL040002','പേരൂര്‍കട','13:00','7.50','ഉള്ളൂർ,കേശവദാസപുരം,വെഞ്ഞാറമൂട്');";
	String querry8b  = "INSERT INTO BUS VALUES('KL040002','പേരൂര്‍കട','1500','7.50','ഉള്ളൂർ,കേശവദാസപുരം,വെഞ്ഞാറമൂട്');";
	String querry8c  = "INSERT INTO BUS VALUES('KL040002','പേരൂര്‍കട','17:00','7.50','ഉള്ളൂർ,കേശവദാസപുരം,വെഞ്ഞാറമൂട്');";
	String querry9   = "INSERT INTO BUS VALUES('KL050001','കാട്ടാകട','11:20','20.50','പട്ടം,.പേരൂര്‍കട,വെഞ്ഞാറമൂട്');";
	String querry9a  = "INSERT INTO BUS VALUES('KL050001','കാട്ടാകട','13:37','20.50','പട്ടം,.പേരൂര്‍കട,വെഞ്ഞാറമൂട്');";
	String querry9b  = "INSERT INTO BUS VALUES('KL050001','കാട്ടാകട','15:57','20.50','പട്ടം,.പേരൂര്‍കട,വെഞ്ഞാറമൂട്');";
	String querry9c  = "INSERT INTO BUS VALUES('KL050001','കാട്ടാകട','16:40','20.50','പട്ടം,.പേരൂര്‍കട,വെഞ്ഞാറമൂട്');";
	String querry10  = "INSERT INTO BUS VALUES('KL050002','കാട്ടാകട','10:13','10.50','പട്ടം,പാളയം,തമ്പാനൂര്‍ ');";
	String querry10a = "INSERT INTO BUS VALUES('KL050002','കാട്ടാകട','12:27','10.50','പട്ടം,പാളയം,തമ്പാനൂര്‍ ');";
	String querry10b = "INSERT INTO BUS VALUES('KL050002','കാട്ടാകട','13:17','10.50','പട്ടം,പാളയം,തമ്പാനൂര്‍ ');";
	String querry10c = "INSERT INTO BUS VALUES('KL050002','കാട്ടാകട','18:50','10.50','പട്ടം,പാളയം,തമ്പാനൂര്‍ ');";
	String querry11  = "INSERT INTO BUS VALUES('KL050003','കാട്ടാകട','11:10','15.50','പട്ടം,പാളയം,കിഴക്കേകോട്ട');";
	String querry11a = "INSERT INTO BUS VALUES('KL050003','കാട്ടാകട','14:38','13.50','പട്ടം,പാളയം,കിഴക്കേകോട്ട');";
	String querry11b = "INSERT INTO BUS VALUES('KL050003','കാട്ടാകട','16:42','19.50','പട്ടം,പാളയം,കിഴക്കേകോട്ട');";
	String querry11c = "INSERT INTO BUS VALUES('KL050003','കാട്ടാകട','17:00','18.50','പട്ടം,പാളയം,കിഴക്കേകോട്ട');";
	String querry12  = "INSERT INTO BUS VALUES('KL060001','വെഞ്ഞാറമൂട്','10:40','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പേരൂര്‍കട');";
	String querry12a = "INSERT INTO BUS VALUES('KL060001','വെഞ്ഞാറമൂട്','11:20','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പേരൂര്‍കട');";
	String querry12b = "INSERT INTO BUS VALUES('KL060001','വെഞ്ഞാറമൂട്','15:30','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പേരൂര്‍കട');";
	String querry12c = "INSERT INTO BUS VALUES('KL060001','വെഞ്ഞാറമൂട്','16:20','10.50','മെടിക്കല്‍കോളേജ്,പട്ടം,പേരൂര്‍കട');";
	String querry13  = "INSERT INTO BUS VALUES('KL070001','മെടിക്കല്‍കോളേജ്','10:00','5.50','ഉള്ളൂർ');";
	String querry13a = "INSERT INTO BUS VALUES('KL070001','മെടിക്കല്‍കോളേജ്','13:00','5.50','ഉള്ളൂർ');";
	String querry13b = "INSERT INTO BUS VALUES('KL070001','മെടിക്കല്‍കോളേജ്','15:00','5.50','ഉള്ളൂർ');";
	String querry13c = "INSERT INTO BUS VALUES('KL070001','മെടിക്കല്‍കോളേജ്','18:00','5.50','ഉള്ളൂർ');";
	String querry14  = "INSERT INTO BUS VALUES('KL070002','മെടിക്കല്‍കോളേജ്','11:00','7.50','ഉള്ളൂർ,കേശവദാസപുരം,പട്ടം');";
	String querry14a = "INSERT INTO BUS VALUES('KL070002','മെടിക്കല്‍കോളേജ്','12:00','7.50','ഉള്ളൂർ,കേശവദാസപുരം,പട്ടം');";
	String querry14b = "INSERT INTO BUS VALUES('KL070002','മെടിക്കല്‍കോളേജ്','14:00','7.50','ഉള്ളൂർ,കേശവദാസപുരം,പട്ടം');";
	String querry14c = "INSERT INTO BUS VALUES('KL070002','മെടിക്കല്‍കോളേജ്','16:00','7.50','ഉള്ളൂർ,കേശവദാസപുരം,പട്ടം');";
	
	String url = "jdbc:mysql://localhost:3306/CHAKKA?useUnicode=yes&characterEncoding=UTF-8";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,username,password);
	Statement stmt = con.createStatement();
	try {
		stmt.executeUpdate(querry);
	} catch (Exception e) {
		stmt.executeUpdate(querryDrop);
		stmt.executeUpdate(querry);
	}
	stmt.executeUpdate(querry0);
	stmt.executeUpdate(querry0a);
	stmt.executeUpdate(querry1);
	stmt.executeUpdate(querry1a);
	stmt.executeUpdate(querry1b);
	stmt.executeUpdate(querry1c);
	stmt.executeUpdate(querry2);
	stmt.executeUpdate(querry2a);
	stmt.executeUpdate(querry2b);
	stmt.executeUpdate(querry2c);
	stmt.executeUpdate(querry3);
	stmt.executeUpdate(querry3a);
	stmt.executeUpdate(querry3b);
	stmt.executeUpdate(querry3c);
	stmt.executeUpdate(querry4);
	stmt.executeUpdate(querry4a);
	stmt.executeUpdate(querry4b);
	stmt.executeUpdate(querry4c);
	stmt.executeUpdate(querry5);
	stmt.executeUpdate(querry5a);
	stmt.executeUpdate(querry5b);
	stmt.executeUpdate(querry5c);
	stmt.executeUpdate(querry5d);
	stmt.executeUpdate(querry6);
	stmt.executeUpdate(querry6a);
	stmt.executeUpdate(querry6b);
	stmt.executeUpdate(querry6c);
	stmt.executeUpdate(querry6d);
	stmt.executeUpdate(querry7);
	stmt.executeUpdate(querry7a);
	stmt.executeUpdate(querry7b);
	stmt.executeUpdate(querry7c);
	stmt.executeUpdate(querry8);
	stmt.executeUpdate(querry8a);
	stmt.executeUpdate(querry8b);
	stmt.executeUpdate(querry8c);
	stmt.executeUpdate(querry9);
	stmt.executeUpdate(querry9a);
	stmt.executeUpdate(querry9b);
	stmt.executeUpdate(querry9c);
	stmt.executeUpdate(querry10);
	stmt.executeUpdate(querry10a);
	stmt.executeUpdate(querry10b);
	stmt.executeUpdate(querry10c);
	stmt.executeUpdate(querry11);
	stmt.executeUpdate(querry11a);
	stmt.executeUpdate(querry11b);
	stmt.executeUpdate(querry11c);
	stmt.executeUpdate(querry12);
	stmt.executeUpdate(querry12a);
	stmt.executeUpdate(querry12b);
	stmt.executeUpdate(querry12c);
	stmt.executeUpdate(querry13);
	stmt.executeUpdate(querry13a);
	stmt.executeUpdate(querry13b);
	stmt.executeUpdate(querry13c);
	stmt.executeUpdate(querry14);
	stmt.executeUpdate(querry14a);
	stmt.executeUpdate(querry14b);
	stmt.executeUpdate(querry14c);
	stmt.close();
	con.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		@SuppressWarnings("unused")
		DataInput demo = new DataInput();
		
	}

}
