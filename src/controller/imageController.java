package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.khachHangbo;

/**
 * Servlet implementation class tam123
 */
@WebServlet("/imageController")
public class imageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public imageController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("utf-8");
		// response.setCharacterEncoding("utf-8");
		// response.setContentType("text/html; charset=utf-8");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "chienabc";
		response.getWriter().println(dirUrl1);

		try {
			String tenAnh = null;
			String makh = null;
			String tendn = null;
			String mk = null;
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "chienabc";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							/* response.getWriter().println(nameimg); */
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
							System.out.println(nameimg);
							tenAnh = nameimg;
							System.out.println("alo:" + nameimg);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtMaKH")) {
						response.getWriter().println(fileItem.getString());
						// response.getWriter().println(fileItem.getString("UTF-8"));
						makh = fileItem.getString();
						System.out.println("makh" + makh);
						System.out.println("makh" + fileItem.getString());
					}
					if (tentk.equals("txttendn")) {
						response.getWriter().println(fileItem.getString());
						// response.getWriter().println(fileItem.getString("UTF-8"));
						tendn = fileItem.getString();
					}
					if (tentk.equals("txtmk")) {
						response.getWriter().println(fileItem.getString());
						// response.getWriter().println(fileItem.getString("UTF-8"));
						mk = fileItem.getString();
					}
				}
			}
			khachHangbo khbo = new khachHangbo(); // chinh sua thong tin tai khoan
			String a = "chienabc\\" + tenAnh;
			try {
				khbo.doiAnhBo(Long.parseLong(makh), a);
				HttpSession session = request.getSession();
				session.removeAttribute("dn");
				session.setAttribute("dn", khbo.ktDangNhap(tendn, mk));
				response.sendRedirect("taiKhoanController");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
