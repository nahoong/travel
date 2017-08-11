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

import kdata.project.service.NextPage;
import kdata.project.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet(value="*.customer",
	initParams= {@WebInitParam(name="url",value="/kdata/project/util/url.properties")})
public class CustomerController extends HttpServlet {
	
	//<URL, ServiceClassName>
	private Map<String,CustomerService> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String url = config.getInitParameter("url");
		System.out.println("[1]"+url);
		
		Properties prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream(url));
			System.out.println("[2]"+prop);
				
				Iterator<Object> it = prop.keySet().iterator();
				
				while(it.hasNext()){
					 String key = (String) it.next();
					 //클래스 로딩
					 Class clazz = Class.forName(prop.getProperty(key));
			         //객체 생성
			         CustomerService service=(CustomerService)clazz.newInstance();
					//System.out.println(prop.get(it.next()));
					
					map.put(key, service);
				}
				System.out.println("[3]"+map);
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
		
		super.init(config);
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		int cmdIdx = url.lastIndexOf("/")+1;
		String cmd = url.substring(cmdIdx);
		System.out.println("[4]"+cmd);
		
		System.out.println("[5]"+map.get(cmd));
		CustomerService service = map.get(cmd);
		NextPage nextPage=null;
	     
	     nextPage=service.execute(request, response);
	      
	     // 2. 다음 페이지 이동 ------------------------
	            if(nextPage==null){
	               System.out.println("NULL을 반환하지마!");
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