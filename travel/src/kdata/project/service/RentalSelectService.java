package kdata.project.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kdata.project.dao.RentalDAO;
import kdata.project.dto.ProductDTO;
import kdata.project.dto.RentalDTO;

public class RentalSelectService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      System.out.println("RentalSelectService");
   
      HttpSession session = request.getSession();
      String id = request.getParameter("id");
      //1. 요청 파라미터 처리
      //2. DB 처리

      List<RentalDTO> selectresult = null;
/*      String cus_id = "test"; //아이디 세션으로 받아와야함.. 어케하지
      String rent_startday = request.getParameter("startday");
      String rent_endday = request.getParameter("endday");
      String rent_context = request.getParameter("context");*/
/*      RentalDTO dto = new RentalDTO();
      dto.setRent_startday(rent_startday);
      dto.setRent_endday(rent_endday);
      dto.setRent_context(rent_context);
      dto.setCus_id(cus_id);*/
      System.out.println("여기를 주목하세요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      String num= request.getParameter("num");
      System.out.println("2. CommentsDAO.getInstance().selectAll();");
      selectresult = RentalDAO.getInstance().selectComments(num);
      System.out.println("selectresult : "+selectresult);
      
      
      //3. DB 결과 처리
      
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
      
      System.out.println("ggg" + array);
      
      response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
           out = response.getWriter();
           out.print(array);
        } catch (IOException e) {
           e.printStackTrace();
        }
      
      return null;
   }

}