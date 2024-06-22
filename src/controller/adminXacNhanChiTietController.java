package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.adminXacNhanHoaDonBo;

/**
 * Servlet implementation class adminXacNhanChiTietController
 */
@WebServlet("/adminXacNhanChiTietController")
public class adminXacNhanChiTietController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminXacNhanChiTietController() {
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
			String maHoaDonChiTiet = request.getParameter("maHoaDonChiTiet");
			if (maHoaDonChiTiet != null) {
				adminXacNhanHoaDonBo adHDBo = new adminXacNhanHoaDonBo();
				request.setAttribute("cthd", adHDBo.getChiTietHoaDon(Long.parseLong(maHoaDonChiTiet)));
			}
			RequestDispatcher rd = request.getRequestDispatcher("adminChiTietHoaDonXacNhan.jsp");
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
