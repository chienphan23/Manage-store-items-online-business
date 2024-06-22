package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.hangHoabo;
import bo.kieuLoaiBo;
import bo.loaibo;

/**
 * Servlet implementation class hangHoaController
 */
@WebServlet("/hangHoaController")
public class hangHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public hangHoaController() {
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
			hangHoabo hbo = new hangHoabo();
			loaibo lbo = new loaibo();
			kieuLoaiBo klBo = new kieuLoaiBo();
			request.setAttribute("dshh", hbo.getAllHangHoabo()); // danh sach hang hoa

			String search = request.getParameter("txtSearch");
			if (search != null) {
				request.setAttribute("dshh", hbo.search(search)); // danh sach theo tim kiem
			}

			String txtML = request.getParameter("txtML");
			if (txtML != null) {
				request.setAttribute("dshh", hbo.dsFilter(Long.parseLong(txtML))); // danh sach hang hoa theo ma loai
			}

			request.setAttribute("dsl", lbo.getdsLoai());// danh sach loai

			request.setAttribute("dskl", klBo.dsKieuLoai()); // danh sach kieu loai

			String maKieuLoai = request.getParameter("maKieuLoai");
			if (maKieuLoai != null) {
				request.setAttribute("dshh", hbo.dsKieuLoaiFilter(Long.parseLong(maKieuLoai)));// danh sach hang hoa
																								// theo kieu loai
			}
			String txtgia = request.getParameter("txtgia");
			if (txtgia != null) {
				request.setAttribute("dshh", hbo.dsGiaFilter(Long.parseLong(txtgia)));// danh sach hang theo gia
			}

			RequestDispatcher rd = request.getRequestDispatcher("htBanHang.jsp");
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
