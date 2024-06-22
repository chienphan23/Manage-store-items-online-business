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
 * Servlet implementation class dangKyController
 */
@WebServlet("/dangKyController")
public class dangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangKyController() {
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
			request.setCharacterEncoding("utf-8");// gửi dữ liệu lên kiểu unicode
			response.setCharacterEncoding("utf-8");// nhận dữ liệu về kiểu unicode

			String hoTen = request.getParameter("txthoten");
			String diaChi = request.getParameter("txtdiachi");
			String sdt = request.getParameter("txtsdt");
			String tendn = request.getParameter("txttendn");
			String pass = request.getParameter("txtpass");
			String anh = null;
			if (hoTen != null && diaChi != null && sdt != null && tendn != null && pass != null) {
				khachHangbo khbo = new khachHangbo();
				int kq;
				kq = khbo.dangKyBo(hoTen, tendn, pass, diaChi, sdt, anh);
				if (kq != 0) {
					HttpSession session = request.getSession();
					session.removeAttribute("dn");

					session.setAttribute("dn", khbo.ktDangNhap(tendn, pass));
					response.sendRedirect("hangHoaController");
				} else {
					request.setAttribute("thongbao", "Tài khoản đã tồn tại");
				}

			}

			RequestDispatcher rd = request.getRequestDispatcher("dangKy.jsp");
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
