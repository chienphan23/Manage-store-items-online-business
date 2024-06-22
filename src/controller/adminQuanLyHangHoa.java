package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.chiTietHangHoaBean;
import bo.hangHoabo;
import bo.kieuLoaiBo;
import bo.loaibo;
import bo.sizeBo;

/**
 * Servlet implementation class adminQuanLyHangHoa
 */
@WebServlet("/adminQuanLyHangHoa")
public class adminQuanLyHangHoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminQuanLyHangHoa() {
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
			if (session.getAttribute("dnAdmin") == null) {
				response.sendRedirect("adminDangNhapController");
			}

			request.setCharacterEncoding("utf-8");// gửi dữ liệu lên kiểu unicode
			response.setCharacterEncoding("utf-8");// nhận dữ liệu về kiểu unicode
			hangHoabo hbo = new hangHoabo();
			request.setAttribute("dshh", hbo.getAllHangHoabo());

			loaibo lbo1 = new loaibo();
			request.setAttribute("dsMaLoai1", lbo1.getdsLoai());

			sizeBo sBo = new sizeBo();
			request.setAttribute("dsSize", sBo.getDSSize());

			String maLoai = request.getParameter("maLoai");
			if (maLoai != null) {
				loaibo lbo = new loaibo();
				request.setAttribute("dsLoai", lbo.getLoaiTheoMaLoai(Long.parseLong(maLoai)));
				kieuLoaiBo klbo = new kieuLoaiBo();
				request.setAttribute("dsKieuLoai", klbo.dsKieuLoaiTheoMaLoai(Long.parseLong(maLoai)));
				request.setAttribute("check", "ok");
				request.setAttribute("checkSua", null);
			}
			String maLoaiSua = request.getParameter("maLoaiSua");
			String maHangInput = request.getParameter("maHangSua");

			if (maLoaiSua != null && maHangInput != null) {
				loaibo lbo = new loaibo();
				request.setAttribute("dsLoai2", lbo.getLoaiTheoMaLoai(Long.parseLong(maLoaiSua)));
				kieuLoaiBo klbo = new kieuLoaiBo();
				request.setAttribute("dsKieuLoai2", klbo.dsKieuLoaiTheoMaLoai(Long.parseLong(maLoaiSua)));
				request.setAttribute("checkSua", "ok");
				request.setAttribute("check", null);
				hangHoabo hhbo = new hangHoabo();
				request.setAttribute("hangHoa", hhbo.getOneHangHoaBo(Long.parseLong(maHangInput)));
				request.setAttribute("dsCTHangHoa", hhbo.getChiTietHangHoaBo(Long.parseLong(maHangInput)));

			}

			String maHang = request.getParameter("maHang");
			if (maHang != null) {
				hangHoabo hh = new hangHoabo();

				ArrayList<chiTietHangHoaBean> dsCT = hh.getChiTietHangHoaBo(Long.parseLong(maHang));
				request.setAttribute("maHangChon", maHang);
				request.setAttribute("dsCTHang", dsCT);
			}

			RequestDispatcher rd = request.getRequestDispatcher("adminQuanLyHangHoa.jsp");
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
