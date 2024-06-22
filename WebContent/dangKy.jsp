
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

@keyframes opacityfont{
	from{
		opacity: 0.6;
		
	}
	to {
		opacity: 1;
		
	}
}



</style>


</head>
<body>
<div class="m-4 navbar-header-css" style="margin: 0 !important;color: white !important">
    <nav class="navbar navbar-expand-lg navbar-light bg-light " style="background-color: black !important;color: white !important">
        <div class="container-fluid text-white" style="color: white !important">
            <a href="hangHoaController" class="navbar-brand" style="color: white !important;font-weight: bold;">Trang chủ</a>
            <button type="button" class="navbar-toggler text-white" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" style="color: #fff !improtant;">
                <span class="navbar-toggler-icon text-white" ></span>
            </button>
           
            </div>
        </div>
    </nav>
</div>



	<div class="container-fluid" style="text-align: center">
	<h1 style="text-align: center;margin: 20px">Đăng Ký</h1>
	
	<div class="row">
	<div class="col-lg-4"></div>
	<div class="col-lg-4" style="text-align: left">
		<form action="dangKyController" method="post">
		<lable >Họ Tên: </lable><br>
		<input type="text" name="txthoten" style="width: 100%; margin: 10px 0;"><br>
		<lable >Địa chỉ: </lable><br>
		<input type="text" name="txtdiachi" style="width: 100%; margin: 10px 0;"><br>
		<lable >Số điện thoại: </lable><br>
		<input type="text" name="txtsdt" style="width: 100%; margin: 10px 0;"><br>
		<lable >Tên tài khoản: </lable><br>
		<input type="text" name="txttendn" style="width: 100%; margin: 10px 0;"><br>
		<lable>Mật khẩu: </lable><br>
		<input type="password" name="txtpass" style="width: 100%; margin: 10px 0;"><br>
		
		<% String thongbao =(String) request.getAttribute("thongbao");
		if(thongbao != null){
		%>
		<div style="color: red;">Tài khoản đã tồn tại</div>
		<%} %>
		
		
		<div style="text-align: center" >
			<input type="submit" class="btn btn-dark" style="width: 100%;margin-top: 10px" value="Đăng ký">
			</div>
		</form>
	</div>
	<div class="col-lg-4"></div>
	</div>
	
	
	
	</div>
	
	
	
	
</body>
</html>