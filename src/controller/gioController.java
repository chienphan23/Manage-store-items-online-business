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

import bean.gioHangBean;
import bean.hangHoaBean;
import bo.gioHangBo;
import bo.hangHoabo;

/**
 * Servlet implementation class gioController
 */
@WebServlet("/gioController")
public class gioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gioController() {
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
			HttpSession session = request.getSession();

			String size = request.getParameter("options");

			String maHang = request.getParameter("maHang");
			String tenHang = request.getParameter("tenHang");
			String gia = request.getParameter("gia");

			String anh = null;
			if (maHang != null) {
				hangHoabo h = new hangHoabo();
				hangHoaBean a = h.getOneHangHoaBo(Long.parseLong(maHang));
				anh = a.getAnh();
			}

			if (maHang != null && tenHang != null && gia != null && anh != null && size != null) {
				ArrayList<gioHangBean> ds = null;
				gioHangBo gbo = null;
				if (session.getAttribute("gbo") == null) {
					gbo = new gioHangBo();
					session.setAttribute("gbo", gbo);
					ds = gbo.dsgio;
					session.setAttribute("dsgio", ds);
				}
				gbo = (gioHangBo) session.getAttribute("gbo");
				gbo.ThemHang(Long.parseLong(maHang), tenHang, Long.parseLong(gia), 1, anh, Long.parseLong(size));
				ds = gbo.dsgio;
				session.setAttribute("dsgio", ds);
				response.sendRedirect("gioController");
			}

			String soLuongSua = request.getParameter("txtsuasoluong");
			String mh = request.getParameter("maHangSua");
			if (soLuongSua != null && mh != null) {
				gioHangBo gbo = (gioHangBo) session.getAttribute("gbo");
				gbo.Sua(Long.parseLong(mh), Long.parseLong(soLuongSua)); // sua so luong
				session.setAttribute("gbo", gbo);
				ArrayList<gioHangBean> ds = gbo.dsgio;
				session.setAttribute("dsgio", ds);
			}

			String xoa = request.getParameter("txtxoa");
			if (xoa != null && mh != null) {
				gioHangBo gbo = (gioHangBo) session.getAttribute("gbo");
				gbo.Xoa(Long.parseLong(mh)); // xoa hang
				session.setAttribute("gbo", gbo);
				ArrayList<gioHangBean> ds = gbo.dsgio;
				session.setAttribute("dsgio", ds);
			}

			String[] checkBox = request.getParameterValues("txtcheckbox");
			String xoaChon = request.getParameter("txtxoachon");

			if (xoaChon != null && checkBox != null) { // xoa chon
				System.out.println(checkBox.length);
				gioHangBo gbo = (gioHangBo) session.getAttribute("gbo");
				for (String check : checkBox) {
					gbo.Xoa(Long.parseLong(check));
				}
				ArrayList<gioHangBean> ds = gbo.dsgio;
				session.setAttribute("dsgio", ds);
			}

			String xoaAll = request.getParameter("txtxoaAll"); // xoa tat ca
			if (xoaAll != null) {
				gioHangBo gbo = (gioHangBo) session.getAttribute("gbo");
				gbo.xoaAll();
				ArrayList<gioHangBean> ds = gbo.dsgio;
				session.setAttribute("dsgio", ds);
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
