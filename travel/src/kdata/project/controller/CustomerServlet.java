package kdata.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.CustomerRegisterService;
import kdata.project.service.CustomerService;
import kdata.project.service.NextPage;

/**
 * Servlet implementation class CustomerServlet
 */
//@WebServlet("*.customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String uri = request.getRequestURI();
	      String path = request.getContextPath();
	      String cmd = uri.substring(path.length() +1);
	      CustomerService service = null;
	      NextPage nextPage = null;
	      //URI별 분기 --------------------------------------
	      if(cmd.equals("register.customer"))
	      {
	         System.out.println("회원가입");
	         service = new CustomerRegisterService();
	         nextPage = service.execute(request, response);
	      }
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
