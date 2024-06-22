package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.khachHangbo;

/**
 * Servlet implementation class dangNhapController
 */
@WebServlet("/dangNhapController")
public class dangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangNhapController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String tendn = request.getParameter("txttendn");
			String mk = request.getParameter("txtpass");
			khachHangbo khbo = new khachHangbo();
			if (tendn != null && mk != null) {

				if (khbo.ktDangNhap(tendn, mk) != null) {
					session.setAttribute("dn", khbo.ktDangNhap(tendn, mk));
					response.sendRedirect("hangHoaController");
				} else {
					request.setAttribute("thongbao", "alo");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("dangNhap.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
