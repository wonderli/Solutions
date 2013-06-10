import java.sql.*;
public class Jdbc{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/wiki";
    static final String USER = "root";
    static final String PASS = "uiop";
    public static void main(String args[]){
        Connection conn = null;
        Statement stmt = null;
        try{
            //Class.forName(JDBC_DRIVER).newInstance();
            Class.forName(JDBC_DRIVER);
            System.out.println("Connection to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from Employee";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String lastName = rs.getString("LastName");
                int departmentID = rs.getInt("DepartmentID");
                System.out.print("LastName : " + lastName);
                System.out.println(", DepartmentID: " + departmentID);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Bye~");
    }
}
