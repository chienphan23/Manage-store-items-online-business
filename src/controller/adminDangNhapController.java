package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.adminBo;

/**
 * Servlet implementation class adminDangNhapController
 */
@WebServlet("/adminDangNhapController")
public class adminDangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminDangNhapController() {
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
			adminBo admin = new adminBo();

			if (tendn != null && mk != null) {
				if (admin.dangNhap(tendn, mk) != null) {

					session.setAttribute("dnAdmin", admin.dangNhap(tendn, mk));

					response.sendRedirect("adminTrangChuController");
				} else {
					request.setAttribute("thongtin", "Bạn đã nhập sai tài khoản hoặc mật khẩu");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("adminDangNhap.jsp");
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
