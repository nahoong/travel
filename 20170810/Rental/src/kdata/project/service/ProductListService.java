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
       


       
      // 3. DB ��� ó��
      // 4. �̵��� ���� ������ ó��
       if(list.size() != 0)
       {
      	 if(catg.equals("aa")){
          request.setAttribute("list", list);
          nextpage.setPageName("./list/list1.jsp");
          nextpage.setRedirect(false); //true �����̷�Ʈ ���  false forword���
      	 }
      	 else if(catg.equals("bb"))
      	 {
      		 request.setAttribute("list", list);
               nextpage.setPageName("./list/list2.jsp");
               nextpage.setRedirect(false); //true �����̷�Ʈ ���  false forword��� 
      	 }
      	 else if(catg.equals("cc"))
      	 {
      		 request.setAttribute("list", list);
               nextpage.setPageName("./list/list3.jsp");
               nextpage.setRedirect(false); //true �����̷�Ʈ ���  false forword��� 
      	 }
       }
      else
      {
         request.setAttribute("errorMsg", "����Ʈ ���⿡ �����߽��ϴ�.");
         nextpage.setPageName("./errors/error.jsp");
         nextpage.setRedirect(false);
      }
      return nextpage;
   }

}