package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.adminQuanLyHangHoaBo;

/**
 * Servlet implementation class adminThemMatHangController
 */
@WebServlet("/adminThemHangController")
public class adminThemHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminThemHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * try { request.setCharacterEncoding("utf-8");// gửi dữ liệu lên kiểu unicode
		 * response.setCharacterEncoding("utf-8");// nhận dữ liệu về kiểu unicode
		 * 
		 * String txtTenHang = request.getParameter("txtTenHang"); String txtGia =
		 * request.getParameter("txtGia"); String txtSoLuong =
		 * request.getParameter("txtSoLuong"); String txtMauSac =
		 * request.getParameter("txtMauSac");
		 * 
		 * String txtMLoai = request.getParameter("txtMaLoai"); String[] txtSize =
		 * request.getParameterValues("txtSize"); if (txtTenHang != null && txtGia !=
		 * null && txtSoLuong != null && txtTenHang != null && txtSize != null) {
		 * Giaybean giay = new Giaybean(txtTenHang, Long.parseLong(txtGia),
		 * Long.parseLong(txtMLoai), txtMauSac, null, Long.parseLong(txtSoLuong));
		 * AdminQuanLyMatHangbo adminQLMHbo = new AdminQuanLyMatHangbo(); long maGiay =
		 * adminQLMHbo.ThemMatHang(giay); for (String size : txtSize) {
		 * adminQLMHbo.ThemChiTietSize(Integer.parseInt(size), maGiay); } }
		 * response.sendRedirect("adminQuanLyMatHangController"); } catch (Exception e)
		 * { // TODO: handle exception }
		 */

		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "AnhThem";
		response.getWriter().println(dirUrl1);

		try {
			request.setCharacterEncoding("utf-8");// gửi dữ liệu lên kiểu unicode
			response.setCharacterEncoding("utf-8");// nhận dữ liệu về kiểu unicode
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			String anh = null;

			String tenAnh = null;
			String txtTenHang = null;
			String txtGia = null;
			String txtSoLuong = null;
			String txtMaLoai = null;
			String txtKieuLoai = null;
			String txtSize = null;
			ArrayList<Long> dsSize = new ArrayList<Long>();

			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "AnhThem";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file

						System.out.println("byte: " + file.length());

						try {
							fileItem.write(file);// lưu file
							anh = nameimg;
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();

					if (tentk.equals("txtTenHang")) {
						response.getWriter().println(fileItem.getString());
						txtTenHang = fileItem.getString("UTF-8");
					}
					if (tentk.equals("txtGia")) {
						response.getWriter().println(fileItem.getString());
						txtGia = fileItem.getString("UTF-8");
					}
					if (tentk.equals("txtSoLuong")) {
						response.getWriter().println(fileItem.getString());
						txtSoLuong = fileItem.getString("UTF-8");
					}
					if (tentk.equals("txtMaLoai")) {
						response.getWriter().println(fileItem.getString());
						txtMaLoai = fileItem.getString();
					}

					if (tentk.equals("txtKieuLoai")) {
						response.getWriter().println(fileItem.getString());
						txtKieuLoai = fileItem.getString();
					}

					if (tentk.equals("txtSize")) {
						response.getWriter().println(fileItem.getString());
						txtSize = fileItem.getString();
						dsSize.add(Long.parseLong(txtSize));
						System.out.println(txtSize);

					}
				}

			}
			try {
				System.out.println("ALO123:" + txtKieuLoai);
				String tenAnh1 = "AnhThem\\" + anh;
				adminQuanLyHangHoaBo QLHHBo = new adminQuanLyHangHoaBo();
				System.out.println("tenHang:" + txtTenHang);
				System.out.println("txtGia:" + txtGia);
				System.out.println("txtSoLuong:" + txtSoLuong);
				System.out.println("txtMaLoai:" + txtMaLoai);
				System.out.println("txtKieuLoai:" + txtKieuLoai);
				if (txtTenHang != null && txtGia != null && txtSoLuong != null && txtMaLoai != null
						&& txtKieuLoai != null) {

					QLHHBo.ThemHang(txtTenHang, Long.parseLong(txtGia), Long.parseLong(txtSoLuong), tenAnh1,
							Long.parseLong(txtMaLoai), Long.parseLong(txtKieuLoai));

					long maHang = 0;

					maHang = QLHHBo.GetMaHang();

					for (long l : dsSize) {
						QLHHBo.ThemChiTietHang(maHang, l);

					}
				}
				response.sendRedirect("adminQuanLyHangHoa");
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
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