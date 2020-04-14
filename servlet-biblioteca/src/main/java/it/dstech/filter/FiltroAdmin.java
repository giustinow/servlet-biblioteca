package it.dstech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "filtroAdmin", urlPatterns = "/admin/*")
public class FiltroAdmin implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("siamo nel filtro admin");
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession sessione = ((HttpServletRequest) request).getSession();
		String email = (String) sessione.getAttribute("email");
		if(email != null) {
			System.out.println("sessione admin esistente");
			chain.doFilter(request, response);
		}else {
			System.out.println("sessione insesistente");
			resp.sendRedirect("/servlet-biblioteca/home");
		}
	}

	@Override
	public void destroy() {
	}

}
