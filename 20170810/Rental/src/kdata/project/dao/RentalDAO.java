package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kdata.project.dto.RentalDTO;
import kdata.project.util.DBUtil;

public class RentalDAO {

   // 싱글턴 패턴-------------------------------------------------
   private static RentalDAO dao = new RentalDAO();
   
   private RentalDAO() {
      
   }
   
   public static RentalDAO getInstance() {
      return dao;
   }
   //-------------------------------------------------------------
   
   // 댓글 쓰기
   public int insertComments(RentalDTO dto ,String id,String num) {
      System.out.println("3. RentalDAO insertComments()");
      
      Connection con = null;
      PreparedStatement pstmt = null;
      int result = 0;
      int result2 = 0;


      
      try {
         //2. 데이터베이스 서버 연결
         con = DBUtil.getConnection();
         //3,4. Statement 객체 생성
         //INSERT INTO RENTAL VALUES(렌탈번호, 시작일, 종료일, 대여내용 ,아이디);
         String sql = "insert into rental values(seq.nextval,?,?,?,?)";

         pstmt = con.prepareStatement(sql);
         
         
         pstmt.setString(1, dto.getRent_startday());
         pstmt.setString(2, dto.getRent_endday());
         pstmt.setString(3, dto.getRent_context());
         pstmt.setString(4, dto.getCus_id());
         
         //5.
         result = pstmt.executeUpdate();
         
         
         String sql2 = "insert into rental_product values(SEQ.NEXTVAL-1, ?, ?)";
         pstmt = con.prepareStatement(sql2);
         pstmt.setString(1,num); //여기!!!!!!!!!! 프로덕트 넘버 이어받아서 넣는 자리입니다!!!!!!!!!!!!!!!!!!!!!
         pstmt.setString(2,id);
         result2 = pstmt.executeUpdate();
         
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         //6.
         DBUtil.close(pstmt, con);
      }
      return result;
   }
   
   // 댓글 리스트
   // 댓글 리스트
   public List<RentalDTO> selectComments(String num) {
      System.out.println("3. CommentsDAO selectAll()");   
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      List<RentalDTO> list = new ArrayList<>();
      
      try {
         //2. 데이터베이스 서버 연결
         con = DBUtil.getConnection();
         //3,4. Statement 객체 생성
         String sql = "select r.rent_num, r.cus_id, r.rent_startday, r.rent_endday, r.rent_context from rental r, rental_product rp where prod_num=? and r.rent_num=rp.rent_num order by r.rent_num";
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, num);   //여기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 해당 product number 넣는 자리임!!!!!!!!!!!!!!!!!!!
         
         
         //5.
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            RentalDTO dto = new RentalDTO(rs.getInt("rent_num"),rs.getString("cus_id"), rs.getString("rent_startday"),rs.getString("rent_endday"),rs.getString("rent_context"));
            list.add(dto);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         //6.
         DBUtil.close(pstmt, con, rs);
         System.out.println("오류입니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
      
      return list;
   }
   
   // 댓글 삭제
   public int deleteComments(int rentNum) {
      System.out.println("3. CommentsDAO delete()");   
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      int result = 0;
      int result2 = 0;
      
      try {
         //2. 데이터베이스 서버 연결
         con = DBUtil.getConnection();
         //3,4. Statement 객체 생성
         String sql = "delete from rental_product where rent_num = ?";
         pstmt = con.prepareStatement(sql);
         
         pstmt.setInt(1, rentNum);
         
         //5.
         result = pstmt.executeUpdate();
         
         
         String sql2 = "delete from rental where rent_num=?";
         pstmt = con.prepareStatement(sql2);
         pstmt.setInt(1, rentNum);
         result2 = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         //6.
         DBUtil.close(pstmt, con, rs);
      }
      
      return result;
   }
}