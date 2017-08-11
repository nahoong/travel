package kdata.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CustomerService {
	public abstract NextPage execute(HttpServletRequest request, HttpServletResponse response);
}
