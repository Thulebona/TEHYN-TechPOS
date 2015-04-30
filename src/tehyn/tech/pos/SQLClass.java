/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tehyn.tech.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Yongama
 */
public class SQLClass {
    
    protected Connection conn;
    public ResultSet rs;
    protected PreparedStatement pst;
    
    public SQLClass(){
    }
    public SQLClass(String URL, String driver, String user, String password){
        //To Connect with any other Database
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(URL,user,password);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public SQLClass(String name){
        try{
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName(driver);
            String db = "jdbc:odbc:"+name;
            this.conn = DriverManager.getConnection(db);
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error In Connection To Your Database "
                + "\nPlease Check your Adminstrative tools -> DataSource ODBC");
        }
    }
    
    public void executeQuery(String sql){
        try{
            pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Command \n"+e);
        }
    }
    public void execute(String sql){
        try{
            pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Command\n"+e);
        }
    }
    
}
