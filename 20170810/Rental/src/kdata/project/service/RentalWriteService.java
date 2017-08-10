package kdata.project.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kdata.project.dao.RentalDAO;
import kdata.project.dto.RentalDTO;

public class RentalWriteService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      System.out.println("RentalWriteService");
        HttpSession session = request.getSession();
        
      String cus_id = (String) session.getAttribute("id"); //���̵� �������� �޾ƿ;���.. ��������
      String rent_startday = request.getParameter("startday");
      String rent_endday = request.getParameter("endday");
      String rent_context = request.getParameter("context");

      
      //1. ��û �Ķ���� ó��
      //2. DB ó��

      RentalDTO dto = new RentalDTO();
      int insertresult = 0;
      List<RentalDTO> selectresult = null;
      
      dto.setRent_startday(rent_startday);
      dto.setRent_endday(rent_endday);
      dto.setRent_context(rent_context);
      dto.setCus_id(cus_id);
      String num= request.getParameter("num");
      String id= request.getParameter("id");
      System.out.println("2. CommentsDAO.getInstance().insert();");
      insertresult = RentalDAO.getInstance().insertComments(dto,id,num);
      
      System.out.println("2. CommentsDAO.getInstance().selectAll();");
      selectresult = RentalDAO.getInstance().selectComments(num);
      System.out.println("selectresult : "+selectresult);
      
      //3. DB ��� ó��
      //request.setAttribute("selectresult", selectresult);
      
      System.out.println("JSON--------------------");
      JSONArray array = new JSONArray();
      
      for (RentalDTO c : selectresult) {
         JSONObject obj = new JSONObject();
         obj.put("id", c.getCus_id());
         obj.put("startday", c.getRent_startday());
         obj.put("endday", c.getRent_endday());
         obj.put("context", c.getRent_context());
         array.add(obj);
      }
      
      System.out.println(array);
      
      response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
           out = response.getWriter();
           out.print(array);
        } catch (IOException e) {
           e.printStackTrace();
        }
      
/*      //4. �̵��� ���� ������ ó��
      NextPage nextPage = new NextPage();

      if(insertresult != 0 ) {
         //��� �Է� ����
         nextPage.setPageName("./board/view.jsp");
         nextPage.setRedirect(false);
      }
      //��� �Է� ����
      else {
         request.setAttribute("errorMsg", "��� �Է¿� �����߽��ϴ�.");
         nextPage.setPageName("./errors/error.jsp");
         nextPage.setRedirect(false);
      }
      
      return nextPage;*/
      return null;
   }

}