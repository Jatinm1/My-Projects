package db;
import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
    public static Connection c;
    public static Statement st;
    public static Statement m;
//    public static Statement ntoo;
    public static Statement oton;
    public static Statement htol;
    public static Statement ltoh;
    static{
        try{
            c = DriverManager.getConnection("jdbc:mysql:localhost:3306?useSSL=false","your username", "your password");
            
            
            st = c.createStatement();
            m = c.createStatement();
            
            oton = c.createStatement();
            htol = c.createStatement();
            ltoh = c.createStatement();
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
