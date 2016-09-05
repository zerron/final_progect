package member_system.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member_system.model.MemberBean;

@WebFilter(	urlPatterns = { "/*" }, 
		   	initParams = { @WebInitParam(name = "url_1", value = "/member_system/ModifyInfo.jsp"),
		   				   @WebInitParam(name = "url_2", value = "/member_system/ModifyPWD.jsp"),
		   				   @WebInitParam(name = "url_3", value = "/member_system/Logout.jsp")}
			)
public class LoginFilter implements Filter {
	Collection<String> url = new ArrayList<String>();

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession();
			String servletPath = req.getServletPath();
			System.out.println("Servlet path: " + servletPath);

			if (mustLogin(servletPath)) {
				if (checkLogin(req)) {
					System.out.println("Login purview: need to login, already login.");
					System.out.println("---------------------------------------------------------");
					chain.doFilter(request, response);
				} else {
					session.setAttribute("target", req.getContextPath() + req.getServletPath());
					System.out.println("Login purview: need to login, not login yet. (" + req.getServletPath() + ")");
					System.out.println("----------------------------------------------------------");
					RequestDispatcher rd = req.getRequestDispatcher("/member_system/Login.jsp");
					rd.forward(req, res);
				}
			} else {
				System.out.println("Login purview: not need to login.");
				System.out.println("----------------------------------------------------------");
				chain.doFilter(request, response);
			}
		} else {
			throw new ServletException("Request/Response Type Error");
		}
	}

	private boolean mustLogin(String servletPath) {
		boolean login = false;
		for (String sURL : url) {
			if (sURL.endsWith("*")) {
				sURL = sURL.substring(0, sURL.length() - 1);
				if (servletPath.startsWith(sURL)) {
					login = true;
					break;
				}
			} else {
				if (servletPath.equals(sURL)) {
					login = true;
					break;
				}
			}
		}
		return login;
	}

	private boolean checkLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberBean loginToken = (MemberBean) session.getAttribute("Login");
		if (loginToken == null) {
			return false;
		} else {
			return true;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			url.add(fConfig.getInitParameter(name));
		}
	}

}