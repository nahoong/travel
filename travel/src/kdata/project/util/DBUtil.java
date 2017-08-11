package kdata.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**DB 서버 연걸 관리하는 클래스
 * Connection 생성, 종료
 * @author cse
 *
 */
public class DBUtil {
   private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
   private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521";
   private static final String CON_USERID = "rental";
   private static final String CON_USERPASSWORD = "1234";
   
   //static { 여기 안에내용은 한번만 실행되고 다음부턴 안된다. }
   static {

      try{
         Class.forName(DRIVER_NAME);
         System.out.println("JDBC 드라이버 로드 성공");
      }
      catch (ClassNotFoundException e) {
         e.printStackTrace();
         System.out.println("JDBC 드라이버 로드 실패");
      }
      
   }
   /**
    * 데이터베이스 서버 연결하는 메소드
    * @return Connection 데이터 베이스 연결 정보 객체 반환
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