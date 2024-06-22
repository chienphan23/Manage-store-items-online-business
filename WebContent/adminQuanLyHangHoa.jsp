<%@page import="bean.adminBean"%>
<%@page import="bean.sizeBean"%>
<%@page import="bean.kieuLoaiBean"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.chiTietHangHoaBean"%>
<%@page import="bean.hangHoaBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</head>
<body>





<div class="m-4 navbar-header-css" style="margin: 0 !important;color: white !important">
    <nav class="navbar navbar-expand-lg navbar-light bg-light " style="background-color: black !important;color: white !important">
        <div class="container-fluid text-white" style="color: white !important">
            <a href="adminTrangChuController" class="navbar-brand" style="color: white !important;font-weight: bold;">Trang chủ</a>
            <button type="button" class="navbar-toggler text-white" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" style="color: #fff !improtant;">
                <span class="navbar-toggler-icon text-white" ></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse" >
                <div class="navbar-nav mr-auto" >
                    
                    
                    <div >
						  <a href="adminQuanLyHangHoa" 
						  class="nav-item nav-link text-white btn btn-outline-secondary">
						    Quản lý hàng hoá
						  </a>
						  
					</div>
                    <div >
						  <a href="adminXacNhanController" 
						  class="nav-item nav-link text-white btn btn-outline-secondary">
						   Quản lý hóa đơn
						  </a>
						  
					</div>
					 <a href="adminThongKeController" class="nav-item nav-link text-white btn btn-outline-secondary"
					   style="display: flex;justify-content: center;align-items: center"> Thống kê báo cáo </a>
					
                </div>
                
             
                <div class="navbar-nav ms-auto">
                    <!-- <button href="#" class="nav-item nav-link btn btn-outline-dark text-white border border-white "  value="Đăng nhập">Đăng nhập</button> -->
  <%if(session.getAttribute("dnAdmin") == null){ %>
  <a href="adminDangNhapController" class="btn btn-outline-dark text-white border border-white" style="display: flex;justify-content: center;align-items: center"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
</svg>Đăng nhập</a>

<a href="dangKyController" class="btn btn-outline-dark text-white border border-white" style="display: flex;justify-content: center;align-items: center"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg>Đăng Ký</a>   
                         
         
      <%}else{ 
    	  adminBean admin =(adminBean) session.getAttribute("dnAdmin");
      %>
      <p class="text-white" style="margin: 0 5px 0 0; line-height: 41.6px !important;text-align: center"> Xin chào <%=admin.getHoTenAdmin() %></p>
     
      <button  href="#" class="nav-item nav-link btn btn-outline-dark text-white border border-white " value="Đăng nhập"> <a href="adminDangXuatController"  style="display: flex;justify-content: center;align-items: center;color: white;"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg>Đăng xuất</a></button>
      
      <%} %>    
                </div>
            </div>
        </div>
    </nav>
</div>






<div style="text-align: center;margin: 20px"><h1>Quản lý hàng hóa</h1></div>



<div style="margin: 20px">
	 <%
	 ArrayList<loaibean> dsLoai1 = (ArrayList<loaibean>) request.getAttribute("dsMaLoai1");
	 	for(loaibean l : dsLoai1){
	 %>
	<a href="adminQuanLyHangHoa?maLoai=<%=l.getMaLoai() %>" class="btn btn-dark">Nhập <%=l.getTenloai() %></a>
	<%} %>
	</div>
	<%if(request.getAttribute("check")!= null && request.getAttribute("checkSua")== null){ %>
	<div class="row"><br>
	<div class="col-lg-3"></div>
	<form action="adminThemHangController" method="post" enctype="multipart/form-data" class="col-lg-6">
	<% loaibean Loai =(loaibean) request.getAttribute("dsLoai");  %>
	<div><h1>Thêm <%=Loai.getTenloai() %></h1></div>
	<input name="txtMaLoai" value=<%= Loai.getMaLoai()%> style="display: none" type="text">
  <div class="form-row">
    <div class="form-group ">
      <label >Tên hàng</label>
      <input type="text" class="form-control"  placeholder="Tên hàng" name="txtTenHang">
    </div>
    <div class="form-group ">
      <label >giá</label>
      <input type="number" class="form-control"  placeholder="Gía" name="txtGia">
    </div>
  </div>
  <div class="form-group ">
    <label >số lượng</label>
    <input type="number" class="form-control" placeholder="Số lượng"  name="txtSoLuong">
  </div>
  <div class="form-group ">
    <label >ảnh </label>
    <input type="file" class="form-control"  placeholder="Apartment, studio, or floor" name="txtfile">
  </div>
  <div class="form-row">
    
    
   <div class="form-group ">
    <% ArrayList<kieuLoaiBean> dsKieuLoai = (ArrayList<kieuLoaiBean>) request.getAttribute("dsKieuLoai"); %>
      <label >Kiểu loại</label>
      
      <select  class="form-control " name="txtKieuLoai">
      <%for(kieuLoaiBean kl : dsKieuLoai) {%>
        <option value="<%= kl.getMaKieuLoai()%>"><%= kl.getTenKieuLoai()%></option>
        <%} %>
      </select>
    </div>
    <div class="form-group ">
      <label >Size</label>
     
     
       <% ArrayList<sizeBean> dsSize = (ArrayList<sizeBean>) request.getAttribute("dsSize");
    		  for(sizeBean s : dsSize){
       %>
        <input type="checkbox" name="txtSize" value=<%=s.getMaSize() %> ><p style="display: inline;"><%=s.getTenSize() %></p>
       <%} %>
    
    </div>
   
  </div>

  <button type="submit" class="btn btn-primary">Thêm hàng</button>
</form>
<div class="col-lg-3"></div>
</div><br>
<%} %>



<div style="margin: 20px">
	 <%
	 ArrayList<loaibean> dsLoai2 = (ArrayList<loaibean>) request.getAttribute("dsMaLoai1");
	 hangHoaBean hangHoa = (hangHoaBean) request.getAttribute("hangHoa");
	 ArrayList<chiTietHangHoaBean> dsCTHH = (ArrayList<chiTietHangHoaBean>) request.getAttribute("dsCTHangHoa");
	%>
	</div>
	<%if(request.getAttribute("checkSua")!= null && request.getAttribute("check")== null && hangHoa != null){ %>
	<div class="row"><br>
	<div class="col-lg-3"></div>
	<form action="adminSuaHangHoaController" method="post" enctype="multipart/form-data" class="col-lg-6">
	<% loaibean Loai1 =(loaibean) request.getAttribute("dsLoai2");  %>
	<div><h1>Sửa hàng</h1></div>
	<input name="txtMaHang" value=<%= hangHoa.getMaHang()%> style="display: none" type="text">
	<input name="txtMaLoai" value=<%= Loai1.getMaLoai()%> style="display: none" type="text">
	<input name ="txtAnh" value=<%=hangHoa.getAnh() %> style="display: none">
  <div class="form-row">
    <div class="form-group ">
      <label >Tên hàng</label>
      <input type="text" class="form-control"  placeholder="Email" name="txtTenHang" value="<%= hangHoa.getTenHang()%>">
    </div>
    <div class="form-group ">
      <label >giá</label>
      <input type="type" class="form-control"  placeholder="Password" name="txtGia" value="<%= hangHoa.getGia()%>">
    </div>
  </div>
  <div class="form-group ">
    <label >số lượng</label>
    <input type="text" class="form-control" placeholder="1234 Main St" name="txtSoLuong" value="<%=hangHoa.getSoLuong()%>">
  </div>
  <div class="form-group ">
    <label >ảnh </label>
    <div class="col-lg-12" style="text-align: center">
    <img src="<%= hangHoa.getAnh()%>" style="width: 50%">
    </div>
    <input type="file" class="form-control"  placeholder="Apartment, studio, or floor" name="txtfile">
  </div>
  <div class="form-row">
    
    
   <div class="form-group ">
    <% ArrayList<kieuLoaiBean> dsKieuLoai1 = (ArrayList<kieuLoaiBean>) request.getAttribute("dsKieuLoai2"); %>
      <label >Kiểu loại</label>
      
      <select  class="form-control" name="txtKieuLoai">
      <%for(kieuLoaiBean kl : dsKieuLoai1) {%>
        <option value="<%= kl.getMaKieuLoai()%>" <%= (kl.getMaKieuLoai() == hangHoa.getMaKieu() ? "" : "selected") %>><%= kl.getTenKieuLoai()%></option>
        <%} %>
      </select>
    </div>
    <div class="form-group ">
      <label >Size</label><br>
     
     <div class="row">
       <% ArrayList<sizeBean> dsSize = (ArrayList<sizeBean>) request.getAttribute("dsSize");
    		  for(sizeBean s : dsSize){
    			 
    				  
    			  
       %>
       <div class="col-lg-3">
        <input  type="checkbox" name="txtSize" value=<%=s.getMaSize() %> style="margin-right: 4px" 
       <% for(chiTietHangHoaBean ct : dsCTHH){
    	   if(ct.getMaSize() == s.getMaSize()){
    	   %>
    	   Checked
       <%}} %>
        >
        <p style="display: inline;"><%=s.getTenSize() %></p>
        </div>
       <%} %>
    </div>
    </div>
   
  </div>

  <button type="submit" class="btn btn-primary">Sửa hàng</button>
</form>
<div class="col-lg-3"></div>
</div><br>











<%} %>

 <%if(request.getAttribute("dsCTHang") != null){ 
    		%>
			   <table class="table tableChiTiet" >
			  <thead class="table-dark">
			    <th>Mã hàng</th>
			    <th>Size</th>
			    <th>Xử lý</th>
			    
			  </thead>
			  <tbody>
    		<% 
		ArrayList<chiTietHangHoaBean> dsCT = (ArrayList<chiTietHangHoaBean>)request.getAttribute("dsCTHang");
		String maHangChon = (String) request.getAttribute("maHangChon");

		for(chiTietHangHoaBean ct : dsCT){
			
	%>	<tr>
		<td><%=ct.getMaHang() %></td>
    	<td><%=ct.getTenSize() %></td>
    	<td><a class="btn btn-dark" href="adminXoaSuaHangHoaController?txtXoaChiTiet=<%= ct.getMaHang()%>&txtMaSize=<%=ct.getMaSize()%>">Xóa chi tiết</a></td>
		<tr>
	<% }%>
	    </tr>
  </tbody>
</table>
	<%}%> 
	
	
	<table class="table">
  <thead class="table-dark">
    <th>Mã hàng</th>
    <th>Ảnh</th>
    <th>Tên hàng</th>
    <th>Ngày nhập hàng</th>
    <th>Số lượng tồn</th>
    <th>Giá</th>
    <th>Xử lý</th>
  </thead>
  <tbody>
   <% ArrayList<hangHoaBean> dshh = (ArrayList<hangHoaBean>) request.getAttribute("dshh");
    	for(hangHoaBean h : dshh){
    %>	<tr>
    	<td><%=h.getMaHang() %></td>
    	<td><img src="<%=h.getAnh()%>" style="height: 80px; width: 80px"></td>
    	<td class="col-lg-4"><%=h.getTenHang() %></td>
    	<td><%=h.getNgayNhap() %></td>
    	<td><%=h.getSoLuong() %></td>
    	<td><%=h.getGia() %></td>
    	<td><a class="btn btn-dark" href="adminQuanLyHangHoa?maHang=<%= h.getMaHang()%>">Chi tiết </a>
    	<a class="btn btn-dark" href="adminXoaSuaHangHoaController?txtXoa=<%= h.getMaHang()%>">Xóa </a>
    	<%-- <a class="btn btn-dark"
    	 href="adminXoaSuaHangHoaController?txtSua=<%= h.getMaHang()%>&tenHang=<%= h.getTenHang()%>&gia<%=h.getGia()%>&soLuong=<%=h.getSoLuong()%>&maLoai=<%=h.getMaLoai()%>&kieuLoai=<%=h.getMaKieu()%>">Sửa </a> --%>
    	<a href="adminQuanLyHangHoa?maHangSua=<%=h.getMaHang() %>&maLoaiSua=<%=h.getMaLoai() %>" class="btn btn-dark">Sửa hàng</a>
    	</td>
																					   
    <%} %>
    </tr>
  </tbody>
</table>
	
	
</body>
</html>