package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kdata.project.dto.CustomerDTO;
import kdata.project.util.DBUtil;

public class CustomerDAO {

   //�̱� �� ����---------------------------------
      private static CustomerDAO dao = new CustomerDAO();
      
      public static CustomerDAO getInstance() {
         return dao;
      }
      
      
    //----------------------------------------
      // ȸ������
      public static int insert(CustomerDTO customer) {
            System.out.println("UserDAO insert()");
            Connection con = null;
            PreparedStatement pstmt = null;
            int result = 0;
            try {
            con = DBUtil.getConnection();
            
            String sql = "insert into customer values(?,?,?,DEFAULT,?,?,?)";
            pstmt = con.prepareStatement(sql);
            System.out.println("PreparedStatement ����");

            //4. SQL�� ����

            pstmt.setString(1, customer.getCus_id());
            pstmt.setString(2, customer.getCus_pw());
            pstmt.setString(3,customer.getCus_name());

            pstmt.setString(4, customer.getCus_addr());
            pstmt.setString(5,customer.getCus_call());
            pstmt.setString(6,customer.getCus_gender());
            result = pstmt.executeUpdate();
            }
            catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               System.out.println("�ߺ��� ���� �ֽ��ϴ�.");
            }
            finally {
            DBUtil.close(pstmt, con);
            }
            
            return result;
      }
      
      //id �ߺ�Ȯ��
      public int idCheck(String id){
            Connection con=null;
            PreparedStatement pst=null;
            ResultSet rs=null;
            
            int result=0;
            try {
               con=DBUtil.getConnection();
               String sql="select * "
                        + "from customer where cus_id=?";
               pst=con.prepareStatement(sql);
               pst.setString(1,id);
               rs=pst.executeQuery();
                     
               // �ߺ���
               if(rs.next()){
                  result=1;
                  }
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               } finally{
                  DBUtil.close(pst, con,rs);
               }
            return result;
         }     
      
      //�α��� �ߺ� üũ
         public int login(String id , String pw) throws SQLException {
            ResultSet rs = null;
            PreparedStatement pstmt = null;
            Connection con = null;
         
            try {
               
               String sql = "select * from CUSTOMER  where CUS_ID =? and CUS_PW =?";
               
               con = DBUtil.getConnection();
               pstmt = con.prepareStatement(sql);
               
               pstmt.setString(1, id);
               pstmt.setString(2, pw);
               rs = pstmt.executeQuery();
               
               
               if(rs.next())  // �α��� ������ 0 ��ȯ
                  return 0;
               else          // �α��� ���н� 1 ��ȯ
                   return 1;
                  
                   
                   
               
            
            }finally {
               DBUtil.close(pstmt, con, rs);
               
            }
         }
}