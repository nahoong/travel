package kdata.project.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.CustomerDAO;

public class CustomerIdCheckService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      int result=0;
         String id=request.getParameter("id");
         result=CustomerDAO.getInstance().idCheck(id);
         
         System.out.println(result);
         
         PrintWriter out=null;
         try {
            out = response.getWriter();
            out.print(result); //Ŭ���̾�Ʈ�� ��� ����� ��������
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         return null;
   }

}