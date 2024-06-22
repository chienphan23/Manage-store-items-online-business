package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.gioHangBean;
import bean.khachHangBean;
import bo.chiTietHoaDonBo;
import bo.gioHangBo;
import bo.hoadonBo;

/**
 * Servlet implementation class xacNhanController
 */
@WebServlet("/xacNhanController")
public class xacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xacNhanController() {
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
			khachHangBean kh = (khachHangBean) session.getAttribute("dn");
			String maHang = request.getParameter("maHang");
			String soLuongMua = request.getParameter("soLuongMua");
			String tenSize = request.getParameter("txtSize");
			if (tenSize != null) {

				switch (Integer.parseInt(tenSize)) {
				case 1:
					tenSize = "M";
					break;
				case 2:
					tenSize = "L";
					break;
				case 3:
					tenSize = "XL";
					break;
				case 4:
					tenSize = "XXL";
					break;
				default:
					tenSize = "M";
				}
			}

			Date a = new Date();
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
			String aa = f.format(a);
			Date nm = f.parse(aa);

			if (kh != null && maHang != null && soLuongMua != null) {
				hoadonBo hdBo = new hoadonBo();
				chiTietHoaDonBo ctBo = new chiTietHoaDonBo();
				gioHangBo gbo = (gioHangBo) session.getAttribute("gbo");
				hdBo.ThemHD(kh.getMaKhachHang(), nm, false);
				long mahd = hdBo.getMaHoaDon();
				ctBo.ThemCTHD(Long.parseLong(maHang), Long.parseLong(soLuongMua), mahd, tenSize, false);
				gbo.Xoa(Long.parseLong(maHang));
				session.setAttribute("gbo", gbo);
				session.setAttribute("dsgio", gbo.dsgio);
			}

			String checkAll = request.getParameter("checkAll");
			if (checkAll != null && session.getAttribute("gbo") != null && kh != null) {
				hoadonBo hdBo = new hoadonBo();
				chiTietHoaDonBo ctBo = new chiTietHoaDonBo();
				gioHangBo gbo = (gioHangBo) session.getAttribute("gbo");
				hdBo.ThemHD(kh.getMaKhachHang(), nm, false);
				long mahd = hdBo.getMaHoaDon();
				ArrayList<gioHangBean> dsgio = (ArrayList<gioHangBean>) session.getAttribute("dsgio");
				String tenSizeParse = "M";
				for (gioHangBean g : dsgio) {

					switch ((int) g.getSize()) {
					case 1:
						tenSizeParse = "M";
						break;
					case 2:
						tenSizeParse = "L";
						break;
					case 3:
						tenSizeParse = "XL";
						break;
					case 4:
						tenSizeParse = "XXL";
						break;
					default:
						tenSizeParse = "M";
					}

					ctBo.ThemCTHD(g.getMaHang(), g.getSoLuongMua(), mahd, tenSizeParse, false);

				}
				session.removeAttribute("gbo");
				session.removeAttribute("dsgio");
				request.setAttribute("thanhToan", "ok");
				response.sendRedirect("xacNhanController");
			}

			RequestDispatcher rd = request.getRequestDispatcher("htgio.jsp");
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
