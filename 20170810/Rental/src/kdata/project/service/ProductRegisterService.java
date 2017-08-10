package kdata.project.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kdata.project.dao.ProductDAO;
import kdata.project.dto.ProductDTO;



public class ProductRegisterService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
NextPage nextpage = new NextPage();
      
HttpSession session = request.getSession();

      
      String path = request.getServletContext().getRealPath("profile");
      System.out.println(path);
      MultipartRequest multi = null;
      try {
          multi = new MultipartRequest(request, path, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      //1. 요청 파라미터 처리 ->이 방식은 파일 업로드 기능이 있을시 이 방식으로 사용
      String prod_class = multi.getParameter("prod_class");
      String prod_name =   multi.getParameter("prod_name");
      int prod_price =   Integer.parseInt(multi.getParameter("prod_price"));
      String prod_place =   multi.getParameter("prod_place");
      String fileSystemName = multi.getFilesystemName("file");
      
      String id = (String)session.getAttribute("id");
      System.out.println(prod_class);
   
   
      
      
      /*// 1. 요청 파라미터 처리
      //
      String id =   request.getParameter("id");
      String pw =   request.getParameter("pw");
      String name =   request.getParameter("name");*/
      
      // 2. DB 처리
      ProductDTO user = new ProductDTO();
      user.setProd_class(prod_class);
      user.setProd_name(prod_name);
      user.setProd_price(prod_price);
      user.setProd_place(prod_place);
      user.setFilename(fileSystemName);
      user.setCus_id(id);
      int result = ProductDAO.getInstance().insert(user);
      
      
      // 3. DB 결과 처리
         if(result >0)
            System.out.println("제품이 등록 되었습니다.");
         else
            System.out.println("제품이 등록 되지 않았습니다..");
      
      // 4. 이동할 다음 페이지 처리
         List<ProductDTO> list = new ArrayList<>();
          try {
            list = ProductDAO.getInstance().selectAll();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
          
         // 3. DB 결과 처리
         // 4. 이동할 다음 페이지 처리
         if(list.size() != 0)
         {
        	 if(prod_class.equals("나들이")){
            request.setAttribute("list", list);
            nextpage.setPageName("../list/list1.jsp");
            nextpage.setRedirect(false); //true 리다이렉트 방식  false forword방식
        	 }
        	 else if(prod_class.equals("산악"))
        	 {
        		 request.setAttribute("list", list);
                 nextpage.setPageName("../list/list2.jsp");
                 nextpage.setRedirect(false); //true 리다이렉트 방식  false forword방식 
        	 }
        	 else if(prod_class.equals("레이싱"))
        	 {
        		 request.setAttribute("list", list);
                 nextpage.setPageName("../list/list3.jsp");
                 nextpage.setRedirect(false); //true 리다이렉트 방식  false forword방식 
        	 }
         }
         else
         {
            request.setAttribute("errorMsg", "리스트 보기에 실패했습니다.");
            nextpage.setPageName("./errors/error.jsp");
            nextpage.setRedirect(false);
         }
      return nextpage;
   
      
   }

}