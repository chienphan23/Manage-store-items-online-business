package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.hangHoabo;

/**
 * Servlet implementation class chiTietHangHoaController
 */
@WebServlet("/chiTietHangHoaController")
public class chiTietHangHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public chiTietHangHoaController() {
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
			String txtMaHang = request.getParameter("txtMaHang");
			if (txtMaHang != null) {
				request.setAttribute("cthh", hbo.getOneHangHoaBo(Long.parseLong(txtMaHang)));
				request.setAttribute("dsCTHH", hbo.getChiTietHangHoaBo(Long.parseLong(txtMaHang)));
			}

			RequestDispatcher rd = request.getRequestDispatcher("htChiTietHangHoa.jsp");
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
