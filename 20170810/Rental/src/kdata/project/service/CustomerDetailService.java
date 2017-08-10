package kdata.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.ProductDAO;
import kdata.project.dto.ProductDTO;

public class CustomerDetailService implements CustomerService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	      NextPage nextpage = new NextPage();

	      
	      System.out.println("CustomerdetailService");
	      System.out.println(request.getParameter("name"));
	      System.out.println(request.getParameter("class"));
	      System.out.println(request.getParameter("filename"));
	      System.out.println(request.getParameter("price"));
	      System.out.println(request.getParameter("place"));
	      ProductDTO product = new ProductDTO();
	     
	      product.setProd_name(request.getParameter("name"));
	      product.setProd_class(request.getParameter("class"));
	      product.setFilename(request.getParameter("filename"));
	      product.setProd_price(Integer.parseInt(request.getParameter("price")));
	      product.setProd_place(request.getParameter("place"));
	      product.setProd_num(request.getParameter("num"));
	     

	      


	       


	       
	      // 3. DB ��� ó��
	      // 4. �̵��� ���� ������ ó��
	       if(product.getProd_name().length()>0)
	       {
	          request.setAttribute("product", product);
	          nextpage.setPageName("./board/view.jsp");
	          nextpage.setRedirect(false); //true �����̷�Ʈ ���  false forword���     	
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
