package kdata.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**DB ���� ���� �����ϴ� Ŭ����
 * Connection ����, ����
 * @author cse
 *
 */
public class DBUtil {
   private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
   private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
   private static final String CON_USERID = "rental";
   private static final String CON_USERPASSWORD = "1234";
   
   //static { ���� �ȿ������� �ѹ��� ����ǰ� �������� �ȵȴ�. }
   static {

      try{
         Class.forName(DRIVER_NAME);
         System.out.println("JDBC ����̹� �ε� ����");
      }
      catch (ClassNotFoundException e) {
         e.printStackTrace();
         System.out.println("JDBC ����̹� �ε� ����");
      }
      
   }
   /**
    * �����ͺ��̽� ���� �����ϴ� �޼ҵ�
    * @return Connection ������ ���̽� ���� ���� ��ü ��ȯ
    * @throws SQLException 
    */
   public static Connection getConnection() throws SQLException {

      return DriverManager.getConnection(CON_URL, CON_USERID, CON_USERPASSWORD);
   }
   public static void close(PreparedStatement pstmt, Connection con) {
      if(pstmt != null)
         try {
            pstmt.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
      if(con != null)
         try {
            con.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
   }
   public static void close(PreparedStatement pstmt, Connection con, ResultSet rs) {
      if(rs != null)
         try {
            rs.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
      if(pstmt != null)
         try {
            pstmt.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
      if(con != null)
         try {
            con.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
   }

}