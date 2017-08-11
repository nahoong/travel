package kdata.project.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerLogoutService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      HttpSession session = request.getSession();
      
      if(session!=null){
         session.invalidate();
         try {
            response.sendRedirect("./home.jsp");
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return null;
   }

}