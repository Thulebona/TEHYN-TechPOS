
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Abdo
 */
public class SQL {
    
    protected Connection conn;
    public ResultSet rs;
    protected PreparedStatement pst;
    
    public SQL(String URL, String driver, String user, String password){
        //To Connect with any other Database
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(URL,user,password);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public SQL(String name){
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
