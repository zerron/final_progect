package member_system.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = { "/*" }, 
             dispatcherTypes = { DispatcherType.REQUEST }
          )

public class DisableCacheFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		if (req instanceof HttpServletRequest
				&& resp instanceof HttpServletResponse) {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			// Notifies cache to obtain a new copy of the page from the
			// origin server
			response.setHeader("Cache-Control", "no-cache");

			// informs cache not to store the content it receives under any
			// circumstance
			response.setHeader("Cache-Control", "no-store");

			// Causes the proxy cache to see the page as "stale",
			// 0 means the expiry date is 1970/01/01 00:00:00 GMT
			response.setDateHeader("Expires", 0);

			// HTTP 1.0 backward compatibility
			response.setHeader("Pragma", "no-cache");

			chain.doFilter(request, response);

		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}
}
