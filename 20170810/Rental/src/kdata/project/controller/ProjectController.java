package kdata.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.CustomerService;
import kdata.project.service.NextPage;

/**
 * Servlet implementation class ProjectController
 */
@WebServlet(value="*.product",
initParams= {@WebInitParam(name="url",value="/kdata/project/util/url.properties")})
public class ProjectController extends HttpServlet {

   //<URL, ServiceClassName>
      private Map<String,CustomerService> map = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see Servlet#init(ServletConfig)
    */
   public void init(ServletConfig config) throws ServletException {
      // TODO Auto-generated method stub
        String url = config.getInitParameter("url");
        Properties prop = new Properties();
         try {
            prop.load(getClass().getResourceAsStream(url));
          
              
               Iterator<Object> it = prop.keySet().iterator();
               
               while(it.hasNext()){
                   String key = (String) it.next();
                   //Ŭ���� �ε�
                   Class clazz = Class.forName(prop.getProperty(key));
                     //��ü ����
                     CustomerService service=(CustomerService)clazz.newInstance();
                  //System.out.println(prop.get(it.next()));
                  
                  map.put(key, service);
               }
               
         } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("error!");
            e.printStackTrace();
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
   }
     private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      //response.getWriter().append("Served at: ").append(request.getContextPath());
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");  // ���������ؾߴ�
      String url = request.getRequestURI();
      int cmdIdx = url.lastIndexOf("/")+1;
      String cmd = url.substring(cmdIdx);
    
    
      CustomerService service = map.get(cmd);
      NextPage nextPage=null;
        
        nextPage=service.execute(request, response);
         
        // 2. ���� ������ �̵� ------------------------
               if(nextPage==null){
                  System.out.println("NULL�� ��ȯ������!");
               }
               else{
                  if(nextPage.isRedirect()==true){
                     response.sendRedirect(nextPage.getPageName());
                  }
                  else
                     request.getRequestDispatcher(nextPage.getPageName()).forward(request,response);
               }   
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      doGet(request, response);
   }

}