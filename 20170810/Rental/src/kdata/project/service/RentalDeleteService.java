package kdata.project.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kdata.project.dao.RentalDAO;
import kdata.project.dto.RentalDTO;

public class RentalDeleteService implements CustomerService {

   @Override
   public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
      int commentNum =  Integer.parseInt(request.getParameter("commentNum"));
      
      //1. ��û �Ķ���� ó��
      //2. DB ó��
      int result = 0;

      System.out.println("2. CommentsDAO.getInstance().delete();");
      result = RentalDAO.getInstance().deleteComments(commentNum);
      String num= request.getParameter("num");
      if(result>0)
         System.out.println("����Ʈ ����");
      else
         System.out.println("����Ʈ ����");
      
      //-------------------------------selectall
      List<RentalDTO> selectresult = null;
      System.out.println("2. CommentsDAO.getInstance().selectAll();");
      selectresult = RentalDAO.getInstance().selectComments(num);
      System.out.println("JSON--------------------");
      JSONArray array = new JSONArray();
      
/*     for (RentalDTO c : selectresult) {
         JSONObject obj = new JSONObject();
         obj.put("commentNum", c.getCommentNum());
         obj.put("id", c.getId());
         obj.put("comments", c.getComments());
         //obj.put("writeDate", c.getWriteDate());
         //obj.put("num", String.valueOf(c.getWriteDate()));
         array.add(obj);*/
      
      
      System.out.println(array);
      
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