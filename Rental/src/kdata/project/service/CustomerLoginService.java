package kdata.project.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kdata.project.dao.CustomerDAO;
import kdata.project.dto.CustomerDTO;

public class CustomerLoginService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      NextPage nextpage = null;
          try {
      
          HttpSession session = request.getSession();
          String id = request.getParameter("id");
          String pw =request.getParameter("pw");
          int result;
          
         // 2. DB Ã³¸®
         // CustomerDTO user = new CustomerDTO();
            
            
               result = CustomerDAO.getInstance().login(id, pw);
               
                if(result == 0)
                {
                  
                   session.setAttribute("id", id);
                   System.out.println(id);
                   try {
                     response.sendRedirect("./home.jsp");
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
                } else {
                  try {
                     response.sendRedirect("customer/login.jsp");
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }
                }
            
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            
         return nextpage;

   }

}