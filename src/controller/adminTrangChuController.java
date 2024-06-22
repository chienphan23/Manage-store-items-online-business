package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.adminBean;
import bo.adminBo;
import bo.hangHoabo;

/**
 * Servlet implementation class adminTrangChuController
 */
@WebServlet("/adminTrangChuController")
public class adminTrangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminTrangChuController() {
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
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			if (session.getAttribute("dnAdmin") == null) {
				response.sendRedirect("adminDangNhapController");
			}
			adminBean adBean = (adminBean) session.getAttribute("dnAdmin");
			request.setAttribute("admin", adBean);
			hangHoabo hbo = new hangHoabo();
			request.setAttribute("tongHang", hbo.getAllHangHoabo());

			String sua = request.getParameter("txtSua");
			if (sua != null) {
				request.setAttribute("checkSua", "ok");
			}
			String huy = request.getParameter("txtHuy");
			if (huy != null) {
				request.setAttribute("checkSua", null);
			}
			String taiKhoan = request.getParameter("taiKhoan");
			String txtHoTen = request.getParameter("txtHoTen");
			String txtEmail = request.getParameter("txtEmail");
			String txtDiaChi = request.getParameter("txtDiaChi");
			String txtSoDienThoai = request.getParameter("txtSoDienThoai");
			String txtSoTaiKhoan = request.getParameter("txtSoTaiKhoan");
			if (txtHoTen != null && txtEmail != null && txtDiaChi != null && txtSoDienThoai != null
					&& txtSoTaiKhoan != null) {

				adminBo admin = new adminBo();
				admin.SuaThongTin(taiKhoan, txtHoTen, txtSoDienThoai, txtSoTaiKhoan, txtDiaChi, txtEmail);
				adminBean ad = (adminBean) session.getAttribute("dnAdmin");
				session.removeAttribute("dnAdmin");
				session.setAttribute("dnAdmin", admin.dangNhap(ad.getTaiKhoan(), ad.getMatKhau()));
				response.sendRedirect("adminTrangChuController");
			}

			RequestDispatcher rd = request.getRequestDispatcher("adminTrangChu.jsp");
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
