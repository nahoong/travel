package kdata.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.ProductDAO;
import kdata.project.dto.ProductDTO;



public class ProductListService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      NextPage nextpage = new NextPage();
      
      String catg = request.getParameter("type");
      System.out.println(catg);
      System.out.println("ProductListService");
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
      	 if(catg.equals("aa")){
          request.setAttribute("list", list);
          nextpage.setPageName("./list/list1.jsp");
          nextpage.setRedirect(false); //true 리다이렉트 방식  false forword방식
      	 }
      	 else if(catg.equals("bb"))
      	 {
      		 request.setAttribute("list", list);
               nextpage.setPageName("./list/list2.jsp");
               nextpage.setRedirect(false); //true 리다이렉트 방식  false forword방식 
      	 }
      	 else if(catg.equals("cc"))
      	 {
      		 request.setAttribute("list", list);
               nextpage.setPageName("./list/list3.jsp");
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