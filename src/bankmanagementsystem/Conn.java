
package bankmanagementsystem;

import java.sql.*;

public class Conn {
    /*
    this will be used for jdbc connection
    5 stages of connection
    ->register the driver
    ->create connection
    ->create statement
    ->execute query
    ->close connection
    */
    Connection c;
    Statement s;
    public Conn(){
        //exception handking for mysql as it is external
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","srabon","@lokloveR123");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println("e");
        }
    }
}
