package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdata.project.dto.CustomerDTO;
import kdata.project.dto.ProductDTO;
import kdata.project.util.DBUtil;

public class ProductDAO {
   //싱글 턴 패턴---------------------------------
   private static ProductDAO dao = new ProductDAO();
   
   public static ProductDAO getInstance() {
      return dao;
   }
   
   public  int insert(ProductDTO product) {
      
      Connection con = null;
      PreparedStatement pstmt = null;
      int result = 0;
      try {
      con = DBUtil.getConnection();
      String sql = "insert into product  values(SEQ.nextval,?,?,?,?,?,?)";
      pstmt = con.prepareStatement(sql);
      System.out.println("PreparedStatement 성공");

      //4. SQL문 전송

        pstmt.setString(1, product.getProd_name());
        pstmt.setString(2, product.getProd_class());
        pstmt.setString(3, product.getFilename());
        pstmt.setInt(4, product.getProd_price());
        pstmt.setString(5, product.getProd_place());
        pstmt.setString(6, product.getCus_id());
       
      result = pstmt.executeUpdate();
      }
      catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         System.out.println("중복된 값이 있습니다.");
      }
      finally {
      DBUtil.close(pstmt, con);
      }
      
      return result;
}
   
   
   // 회원상세정보
   public  List<ProductDTO> selectAll() throws SQLException {
      ResultSet rs = null;
      PreparedStatement pstmt = null;
      Connection con = null;
      List<ProductDTO> list = new ArrayList<>();
      try {
         con = DBUtil.getConnection();
         String sql = "select * from product order by TO_NUMBER(prod_num) desc";
         pstmt = con.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next())
         {
             list.add(new ProductDTO(rs.getString("prod_name"),rs.getInt("prod_price"),rs.getString("prod_place"),rs.getString("cus_id"),rs.getString("prod_pic"), rs.getString("prod_class"),rs.getString("prod_num")));   
         }
      }finally {
         DBUtil.close(pstmt, con, rs);
         
      }
      return list;

   }
   
}