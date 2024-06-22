<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="bean.gioHangBean"%>
<%@page import="bean.kieuLoaiBean"%>
<%@page import="bean.khachHangBean"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.hangHoaBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop quần áo</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>  
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!--   <link rel="stylesheet" href="htBanHang.css">  --> 

<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<style>
.hover-div:hover{
	border: 1px solid #dcdcdc !important;
	box-shadow: 5px 5px 5px 5px #dcdcdc !important;
	
}

.hover-div:hover p {
	animation-name: opacityfont;
	animation-duration: 3.5s;
}


.hover-div{
	box-sizing: border-box;
	margin: 5px 0;
	padding-top: 4px;
	padding-bottom: 4px;
	border-radius: 8px;
	
}
a {
	text-decoration: none;
	color: white;	
}
.text {
   overflow: hidden;
   display: -webkit-box;
   -webkit-line-clamp: 2; /* number of lines to show */
           line-clamp: 2; 
   -webkit-box-orient: vertical;
}

@keyframes opacityfont{
	from{
		opacity: 0.6;
		
	}
	to {
		opacity: 1;
		
	}
}

   @media only screen and (max-width: 768px) {
  	.ul-none{
  		display: none !important;
  	}
  	
  }



</style>


</head>
<body>
<% ArrayList<gioHangBean> dsSum = (ArrayList<gioHangBean>) session.getAttribute("dsgio");
	Locale localeVN = new Locale("vi", "VN");
	NumberFormat vn = NumberFormat.getInstance(localeVN);
	int sum = 0;
	if(dsSum != null){
		sum = dsSum.size();
	}
%>
<div class="m-4 navbar-header-css" style="margin: 0 !important;color: white !important">
    <nav class="navbar navbar-expand-lg navbar-light bg-light " style="background-color: black !important;color: white !important">
        <div class="container-fluid text-white" style="color: white !important">
            <a href="hangHoaController" class="navbar-brand" style="color: white !important;font-weight: bold;">Trang chủ</a>
            <button type="button" class="navbar-toggler text-white" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" style="color: #fff !improtant;">
                <span class="navbar-toggler-icon text-white" ></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse" >
                <div class="navbar-nav mr-auto" >
                    
                    
                    <div >
						  <a href="hangHoaController?txtML=1" 
						  class="nav-item nav-link text-white btn btn-outline-secondary">
						    Áo
						  </a>
						  
					</div>
                    <div >
						  <a href="hangHoaController?txtML=2" 
						  class="nav-item nav-link text-white btn btn-outline-secondary">
						    Quần
						  </a>
						  
					</div>
					 <a href="gioController" class="nav-item nav-link text-white btn btn-outline-secondary"  style="display: flex;justify-content: center;align-items: center"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart3" viewBox="0 0 16 16">
  <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
</svg> Giỏ hàng (<%=sum %>)</a>
					<%if(session.getAttribute("dn") != null){ %>
                   
                    <a href="lichSuController" class="nav-item nav-link text-white btn btn-outline-secondary">Lịch sử mua hàng</a>
                    <%} %>
                </div>
                <!-- Tìm kiếm -->
                <form class="form-inline my-2 my-lg-0 ms-auto " style="display: flex;background: white;border-radius: 6px;" action="hangHoaController" method="post" >
     				 <input class="form-control mr-sm-2 " type="search" placeholder="Search" aria-label="Search" name="txtSearch">
      				<button class="btn btn-outline-secondary my-2 my-sm-0 border-left" type="submit" value="Search" style="border-bottom-left-radius: 0 !important;border-top-left-radius: 0 !important;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
</svg></button>
   			</form>
                
                <div class="navbar-nav ms-auto">
                    <!-- <button href="#" class="nav-item nav-link btn btn-outline-dark text-white border border-white "  value="Đăng nhập">Đăng nhập</button> -->
  <%if(session.getAttribute("dn") == null){ %>
  <a href="dangNhapController" class="btn btn-outline-dark text-white border border-white" style="display: flex;justify-content: center;align-items: center"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
</svg>Đăng nhập</a>

<a href="dangKyController" class="btn btn-outline-dark text-white border border-white" style="display: flex;justify-content: center;align-items: center"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg>Đăng Ký</a>   
                         
         
      <%}else{ 
    	  khachHangBean kh =(khachHangBean) session.getAttribute("dn");
      %>
      <p class="text-white" style="margin: 0 5px 0 0; line-height: 41.6px !important;text-align: center"> Xin chào <%=kh.getHoTen() %></p>
      <button href="#" class="nav-item nav-link btn btn-outline-dark text-white border border-white " value="Đăng nhập">
      <a href="taiKhoanController" style="display: flex;justify-content: center;align-items: center"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill-gear" viewBox="0 0 16 16">
  <path d="M11 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm-9 8c0 1 1 1 1 1h5.256A4.493 4.493 0 0 1 8 12.5a4.49 4.49 0 0 1 1.544-3.393C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4Zm9.886-3.54c.18-.613 1.048-.613 1.229 0l.043.148a.64.64 0 0 0 .921.382l.136-.074c.561-.306 1.175.308.87.869l-.075.136a.64.64 0 0 0 .382.92l.149.045c.612.18.612 1.048 0 1.229l-.15.043a.64.64 0 0 0-.38.921l.074.136c.305.561-.309 1.175-.87.87l-.136-.075a.64.64 0 0 0-.92.382l-.045.149c-.18.612-1.048.612-1.229 0l-.043-.15a.64.64 0 0 0-.921-.38l-.136.074c-.561.305-1.175-.309-.87-.87l.075-.136a.64.64 0 0 0-.382-.92l-.148-.045c-.613-.18-.613-1.048 0-1.229l.148-.043a.64.64 0 0 0 .382-.921l-.074-.136c-.306-.561.308-1.175.869-.87l.136.075a.64.64 0 0 0 .92-.382l.045-.148ZM14 12.5a1.5 1.5 0 1 0-3 0 1.5 1.5 0 0 0 3 0Z"/>
</svg> Tài khoản </a></button>
      <button  href="#" class="nav-item nav-link btn btn-outline-dark text-white border border-white " value="Đăng nhập"> <a href="dangXuatController"  style="display: flex;justify-content: center;align-items: center"><svg style="margin-right: 4px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg>Đăng xuất</a></button>
      
      <%} %>    
                </div>
            </div>
        </div>
    </nav>
</div>



	<div class="container-fluid">
	
	
	
	
	
	
	<div class="row" style="margin: 20px 0;">
	<div class="col-lg-2 col-md-2 ul-none">	
	<ul class="list-group ul-none">
	<%ArrayList<loaibean> dsl = (ArrayList<loaibean>) request.getAttribute("dsl");
	ArrayList<kieuLoaiBean> dskl = (ArrayList<kieuLoaiBean>) request.getAttribute("dskl");
	for(loaibean l : dsl){
	%>
	<li class="list-group-item " ><a href="hangHoaController?txtML=<%=l.getMaLoai() %>" style="text-decoration: none;color: black;font-weight: 600">
	<%=l.getTenloai() %></a> 
		<ul class="list-group ul-none">
		<%for(kieuLoaiBean kl : dskl){ 
			if(kl.getMaLoai() == l.getMaLoai()){
		%>
		
			<li class="list-group-item"><a href="hangHoaController?maKieuLoai=<%= kl.getMaKieuLoai()%>" class="text-black">
			<%= kl.getTenKieuLoai() %></a></li>
			
			<%}} %>
		</ul>
	</li>
	<%} %>
	<li class="list-group-item " >
		<a href="#" style="text-decoration: none;color: black;font-weight: 600;cursor: default;">
	Lọc theo giá</a> 
	<%for(int i = 1 ; i < 4 ; i++){ %>
	<ul class="list-group ul-none">
	<li class="list-group-item"><a href="hangHoaController?txtgia=<%=i *100000 %>" class="text-black">
		Dưới	<%=i %>00 vnđ</a></li>
	<%} %>
	</ul>
	</li>
	</ul>
	</div>
	<div class="col-lg-8 col-md-10 col-12 row" >
	
	
	
 	<% ArrayList<hangHoaBean> dshh =(ArrayList<hangHoaBean>) request.getAttribute("dshh");
		for(hangHoaBean h : dshh){
	%>
		<div class="col-lg-3 col-md-4 col-6 hover-effect  hover-div">
			<a href="chiTietHangHoaController?txtMaHang=<%=h.getMaHang() %>" class="text-black">
			<img src="<%= h.getAnh() %>" class="img-thumbnail hover-img">
			<p style="font-weight: 600" class="text"><%= h.getTenHang() %></p>
			<p>Giá: &nbsp<%= vn.format(h.getGia()) %> <span style="font-size: 12px">VNĐ</span></p>
			<p>Số lượng còn:  &nbsp <%= h.getSoLuong() %></p>
			</a>
		</div>
	<%} %> 
	</div>
	<div class="col-lg-2"></div>
	</div>
	</div>
	
	
	
	
</body>
</html>