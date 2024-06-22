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

import bean.CTHDViewBean;
import bean.adminXacNhanBean;
import bean.adminXacNhanHoaDonBean;
import bo.adminXacNhanBo;
import bo.adminXacNhanHoaDonBo;

/**
 * Servlet implementation class adminXacNhanController
 */
@WebServlet("/adminXacNhanController")
public class adminXacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminXacNhanController() {
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

			String checkFromCTHDJSP = request.getParameter("checkFromCTHDJSP");
			String maHoaDonChiTiet = request.getParameter("maHoaDonChiTiet");
			if (checkFromCTHDJSP != null) {

				adminXacNhanBo adBo = new adminXacNhanBo();
				String macthd = request.getParameter("maChiTiet");
				String mahd = request.getParameter("maHoaDon");
				String soLuongMua = request.getParameter("soLuongMua");
				String maHang = request.getParameter("maHang");
				if (macthd != null) {
					adBo.xacNhanChiTietHoaDon(Long.parseLong(macthd), Long.parseLong(mahd), Long.parseLong(soLuongMua),
							Long.parseLong(maHang));
				}
				adBo.getDSXN();
				ArrayList<adminXacNhanBean> dsXN = adBo.dsXN;
				request.setAttribute("dsXN", dsXN);
				response.sendRedirect("adminXacNhanController");

			}

			String cthd = request.getParameter("cthd");
			if (cthd != null) {
				adminXacNhanBo adBo = new adminXacNhanBo();
				String macthd = request.getParameter("maChiTiet");
				String mahd = request.getParameter("maHoaDon");
				String soLuongMua = request.getParameter("soLuongMua");
				String maHang = request.getParameter("maHang");
				if (macthd != null) {
					adBo.xacNhanChiTietHoaDon(Long.parseLong(macthd), Long.parseLong(mahd), Long.parseLong(soLuongMua),
							Long.parseLong(maHang));
				}
				adBo.getDSXN();
				ArrayList<adminXacNhanBean> dsXN = adBo.dsXN;

				request.setAttribute("dsXN", dsXN);

				RequestDispatcher rd = request.getRequestDispatcher("adminXacNhan2.jsp");// ds chi tiết hóa đơn
				rd.forward(request, response);
			} else {
				adminXacNhanHoaDonBo adHDBo = new adminXacNhanHoaDonBo();
				String maHoaDonFull = request.getParameter("maHoaDonFull");
				if (maHoaDonFull != null) {
					ArrayList<CTHDViewBean> dsCTHD = new ArrayList<CTHDViewBean>();
					dsCTHD = adHDBo.getChiTietHoaDon(Long.parseLong(maHoaDonFull));
					for (CTHDViewBean ct : dsCTHD) {
						adHDBo.updateSoLuongKhiXacNhan(ct.getSoLuongMua(), ct.getMaHang());
					}
					adHDBo.XacNhanHoaDon(Long.parseLong(maHoaDonFull));
				}
				adHDBo.getDSXNHD();
				ArrayList<adminXacNhanHoaDonBean> dsXNHD = adHDBo.dsXNHD;
				request.setAttribute("dsXNHD", dsXNHD);
				adHDBo.getDSDaXacNhan();
				ArrayList<adminXacNhanHoaDonBean> dsDXN = adHDBo.dsDXN;
				request.setAttribute("dsDXN", dsDXN);

				RequestDispatcher rd = request.getRequestDispatcher("adminXacNhan.jsp");// ds hoa don
				rd.forward(request, response);
			}

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
