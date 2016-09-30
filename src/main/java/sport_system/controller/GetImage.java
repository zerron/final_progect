package sport_system.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport_system.model.SportBean;
import sport_system.model.SportJDBC;

/**
 * Servlet implementation class GetImage
 */ 
@WebServlet("/sport_system/controller/GetImage")
            
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			SportBean bb = null;
			String no = request.getParameter("no");
			int ino = -1;
			if (no != null) {
				try {
					ino = Integer.parseInt(no);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					ino = -1;
				}
				SportJDBC bj = new SportJDBC();
				bj.setSportId(ino);
				bb = bj.getSport();
			}
			
			String mimeType = null;
			if (bb == null) {
				is = getServletContext().getResourceAsStream(
						"/images/NoImage.gif");
				mimeType = "image/gif";
			} else {
				Blob blob = bb.getPICTURE();
				if (blob == null){
					is = getServletContext().getResourceAsStream(
							"/images/NoImage.gif");
					mimeType = "image/gif";
				} else {
				   is = blob.getBinaryStream();
				   mimeType = getServletContext().getMimeType(bb.getBlobFileName());
				}
			}
			response.setContentType(mimeType);
			os = response.getOutputStream();
			int len = 0 ; 
			byte[] b = new byte[8192];
			while ( ( len = is.read(b) )!= -1){
				os.write(b, 0, len);
			}
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} finally {
			if (is != null){
				is.close();
			}
			if (os != null){
				os.close();
			}
		}
	}

}
