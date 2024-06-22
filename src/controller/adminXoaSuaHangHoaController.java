package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.adminQuanLyHangHoaBo;

/**
 * Servlet implementation class adminXoaSuaHangHoaController
 */
@WebServlet("/adminXoaSuaHangHoaController")
public class adminXoaSuaHangHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminXoaSuaHangHoaController() {
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
			String xoaHang = request.getParameter("txtXoa");
			if (xoaHang != null) {
				adminQuanLyHangHoaBo adBo = new adminQuanLyHangHoaBo();
				adBo.XoaHang(Long.parseLong(xoaHang));
				response.sendRedirect("adminQuanLyHangHoa");
			}
			String xoaChiTietHang = request.getParameter("txtXoaChiTiet");
			String maSize = request.getParameter("txtMaSize");
			if (xoaChiTietHang != null) {
				adminQuanLyHangHoaBo adBo = new adminQuanLyHangHoaBo();
				adBo.XoaChiTietHang(Long.parseLong(xoaChiTietHang), Long.parseLong(maSize));
				request.setAttribute("maHang", Long.parseLong(xoaChiTietHang));
				response.sendRedirect("adminQuanLyHangHoa");
			}

//			String anh = null;
//			String tenAnh = null;
//			String txtTenHang = null;
//			String txtGia = null;
//			String txtSoLuong = null;
//			String txtMaLoai = null;
//			String txtKieuLoai = null;
//			String txtSize = null;

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
