<%@page import="bean.adminBean"%>
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
<style>
@media (max-width: 780px){
	.media2{
		display: block;
	}
	.media1{
		display: none;
	}
}
@media (min-width: 780px){
	.media2{
		display: none;
	}
	.media1{
		display: block;
	}
}
</style>
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






<div class="container">

<% ArrayList<Integer> dsNam = (ArrayList<Integer>) request.getAttribute("dsNam");
int namDuocChon = (int) request.getAttribute("namDuocChon");
%>

<div style="text-align: center; margin: 20px 0"><h1>Thống kê doanh thu theo năm <%= namDuocChon %></h1></div>


<div>
<div class="dropdown">
  <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" style="margin: 20px 0">
    Chọn năm
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
  <%for(int i : dsNam){ %>
    <li> <a class="dropdown-item" href="adminThongKeController?txtNam=<%= i%>">năm <%= i%></a></li>
  <%} %>
  </ul>
</div>
   
  
</div>	
<% ArrayList<Long> dsTien = (ArrayList<Long>) request.getAttribute("dsTien");
 ArrayList<Long> dsSoLuong = (ArrayList<Long>) request.getAttribute("dsSoLuong");

 %>

 <div class="media1">
 <div style="text-align: center; margin: 20px 0"><h2>Thống kê doanh thu theo tháng</h2></div>
 
 <table class="table table-dark ">
  <thead class="thead-dark">
    <tr >
       <%for(int i = 0 ; i < 12 ; i++) {
  %>
     <th > Tháng <%=i+1 %></th>
     <%} %> 
    </tr>
  </thead>
  <tbody>
 
    <tr>
     
      <%for(long s : dsTien) {%>
      <td ><%=s %></td>
     <%} %>
      
    </tr>
 
  </tbody>
</table>


 <div style="text-align: center; margin: 20px 0"><h2>Thống kê Số hàng bán được theo tháng</h2></div>
<table class="table table-dark">
  <thead>
    <tr>
       <%for(int i = 0 ; i < 12 ; i++) {
  %>
     <th scope="col"> Tháng <%=i+1 %></th>
     <%} %> 
    </tr>
  </thead>
  <tbody>
 
    <tr>
     
      <%for(long s : dsSoLuong) {%>
      <td><%=s %></td>
     <%} %>
      
    </tr>
 
  </tbody>
</table>

</div>






</div>


<div class="media2">
<table class="table table-dark table-striped">
  <thead>
  <tr>
  	<th>Tháng</th>
  	<th>Doanh thu</th>
  	<th>Số lượng hàng bán</th>
  </tr>
 
  </thead>
  
  <tbody>
   <%for(int i = 0 ; i < 12 ; i++) {
  %>
     <tr> 
     <td>Tháng <%=i+1 %></td>
     <td><%= dsTien.get(i) %></td>
     <td><%=dsSoLuong.get(i) %></td>
     </tr>
    
     <%} %> 
  </tbody>
</table>
</div>



</div>

 




 
</body>
</html>