package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachHangBean;
import bo.khachHangbo;

/**
 * Servlet implementation class taiKhoanController
 */
@WebServlet("/taiKhoanController")
public class taiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public taiKhoanController() {
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

			String txtmakh = request.getParameter("txtmakh");
			String txtmkc = request.getParameter("txtmkc");
			String txtmkm = request.getParameter("txtmkm");
			khachHangbo khbo = new khachHangbo();
			if (txtmakh != null && txtmkc != null && txtmkm != null) {// doi mat khau
				khbo.doimk(Long.parseLong(txtmakh), txtmkc, txtmkm);
				request.setAttribute("thanhcong", "Đổi mật khẩu thành công");

			}

			String txtAnh = request.getParameter("txtAnh");
			if (txtAnh != null) {

			}

			String check = request.getParameter("check");
			if (check != null) {
				request.setAttribute("checked", "ok");
			}

			String maKHSua = request.getParameter("maKHSua");
			String hoTen = request.getParameter("txthoten");
			String diaChi = request.getParameter("txtdiachi");
			String sdt = request.getParameter("txtsdt");

			if (maKHSua != null && hoTen != null && diaChi != null && sdt != null) {// doi thong tin

				khbo.doiThongTinBo(Long.parseLong(maKHSua), hoTen, diaChi, sdt);
				System.out.println("alo");
				HttpSession session = request.getSession();
				khachHangBean kh = (khachHangBean) session.getAttribute("dn");
				String tk = kh.getTaiKhoan();
				String mk = kh.getMatKhau();
				session.removeAttribute("dn");
				session.setAttribute("dn", khbo.ktDangNhap(tk, mk));
			}

			RequestDispatcher rd = request.getRequestDispatcher("htTaiKhoan.jsp");
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
