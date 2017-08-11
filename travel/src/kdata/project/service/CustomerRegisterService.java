package kdata.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.CustomerDAO;
import kdata.project.dto.CustomerDTO;

public class CustomerRegisterService implements CustomerService {

	@Override
    public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
       // TODO Auto-generated method stub
       
       NextPage nextpage = new NextPage();
       
       // TODO Auto-generated method stub
       // 1. 요청 파라미터 처리
       //
       String id =   request.getParameter("id");
       String pw =   request.getParameter("pw");
       String name =   request.getParameter("name");
       String gender = request.getParameter("gender");
       String add1 = request.getParameter("add1");
       String add2 = request.getParameter("add2");
       String call1 = request.getParameter("call1");
       String call2 = request.getParameter("call2");
       String call3 = request.getParameter("call3");
       String add = add1 +" "+ add2;
       String call = call1 + call2+ call3;
       // 2. DB 처리
       CustomerDTO user = new CustomerDTO();
       user.setCus_id(id);
       user.setCus_pw(pw);
       user.setCus_name(name);
       user.setCus_gender(gender);
       user.setCus_call(call);
       user.setCus_addr(add);
       
       int result = CustomerDAO.getInstance().insert(user);
       
       
       // 3. DB 결과 처리
       /*   if(result >0)
             System.out.println("회원가입이 되었습니다.");
          else
             System.out.println("회원가입이 되지 않았습니다..");
       */
       // 4. 이동할 다음 페이지 처리
       if(result !=0)
       {
          nextpage.setPageName("./customer/login.jsp");
          nextpage.setRedirect(true);
       }
       else
       {
          request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
          nextpage.setPageName("./errors/error.jsp");
          nextpage.setRedirect(false);
       }
       return nextpage;
    
    }

}
