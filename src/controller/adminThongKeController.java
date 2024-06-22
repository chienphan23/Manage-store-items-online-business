package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.adminThongKeBo;

/**
 * Servlet implementation class adminThongKeController
 */
@WebServlet("/adminThongKeController")
public class adminThongKeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminThongKeController() {
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

			LocalDateTime localDate = LocalDateTime.now();
			int year = localDate.getYear();
			String namInput = request.getParameter("txtNam");
			int namInputINT = 0;

			if (namInput == null) {
				namInputINT = year;
			} else {
				namInputINT = Integer.parseInt(namInput);
			}
			request.setAttribute("namDuocChon", namInputINT);

			ArrayList<Integer> dsNam = new ArrayList<Integer>();
			for (int i = 0; i <= 2; i++) {
				dsNam.add(year);
				year--;
			}
			request.setAttribute("dsNam", dsNam);

			adminThongKeBo adBo = new adminThongKeBo();
			ArrayList<Long> dsTien = new ArrayList<Long>();
			ArrayList<Long> dsSoLuong = new ArrayList<Long>();
			for (int i = 1; i <= 12; i++) {
				dsTien.add(adBo.ThongKeTheoThang(i, namInputINT));
				dsSoLuong.add(adBo.ThongSoLuongTheoThang(i, namInputINT));
			}
			request.setAttribute("dsTien", dsTien);
			request.setAttribute("dsSoLuong", dsSoLuong);

			RequestDispatcher rd = request.getRequestDispatcher("adminThongKe.jsp");
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
