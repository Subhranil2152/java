import java.sql.*;
import java.io.*;

public class Jdbc1 {
  public static void main(String[] args) {
    try {
      // Load the MySQL JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver"); 

      // Database URL, username, and password
      String url = "jdbc:mysql://localhost:3306/Binod Grocery Store 1"; 
      String username = "root";
      String password = "Bob2152@";

      // Establishing a connection
      Connection con = DriverManager.getConnection(url, username, password);

      if (con.isClosed()) {
        System.out.println("Connection closed");
      } else {
        System.out.println("Connection created");
      }

      //insert JDBC

      /*
      //query 1 CREATING TABLE
      String q="create table table1(tId int(20) primary key auto_increment,tName varchar(200) not null,tCity varchar(200))";
      
      
      //cretae statement
      Statement stmt=con.createStatement();
      stmt.executeUpdate(q);
      System.out.println("Table created...");
*/

/*
      //Insert data Dynamic Query
      String q1="insert into table1(tName,tCity) values(?,?)";
      //get Prepeared Statement object 
      PreparedStatement pstmt=con.prepareStatement(q1);

      //set the values  
      //STATIC VALUES
      //pstmt.setString(1,"Subhranil");
     // pstmt.setString(2,"Kolkata");
      //pstmt.setString(1,"Bob");
      //pstmt.setString(2,"Kolkata");

      //DYNAMIC VALUES
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter name");
      String name=br.readLine();
      System.out.println("Enter city");
      String city=br.readLine();
      pstmt.setString(1,name);
      pstmt.setString(2,city);




      pstmt.executeUpdate();//not passing query cuz already passed in prepeared statment
      System.out.println("Inserted..");


*/

//Inserting images to DATABASE
/* 
String q="insert into images(pic) values(?)";

PreparedStatement pstmt = con.prepareStatement(q);

FileInputStream fis=new FileInputStream("/home/subhranil/Downloads/pic.jpeg");
pstmt.setBinaryStream(1,fis,fis.available());//fis.availabl() is used for allocationg byte availablility
pstmt.executeUpdate();
System.out.println("Success..");
*/

//UPDATE DATA

/* 
String q="update table1 set tName=?,tCity=? where tId=?";
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter name: ");
String name=br.readLine();
System.out.println("enter city: ");
String city=br.readLine();
System.out.println("enter id: ");
int id=Integer.parseInt(br.readLine());
PreparedStatement pstmt=con.prepareStatement(q);
pstmt.setString(1,name);
pstmt.setString(2,city);
pstmt.setInt(3,id);
pstmt.executeUpdate();
System.out.println("Updated...");
*/

//SELECT QUERY 

String q="select * from table1";
Statement stmt=con.createStatement();
ResultSet set=stmt.executeQuery(q);
while(set.next())//execuletes till no rowas left
{
int id=set.getInt(1);
String name=set.getString(2);
String city=set.getString(3);
System.out.println(id+" "+name+" "+city);
}









      // Close the connection
      con.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
