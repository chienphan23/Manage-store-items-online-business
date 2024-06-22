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
            <a href="#" class="navbar-brand" style="color: white !important;font-weight: bold;">Xin Chào</a>
            <button type="button" class="navbar-toggler text-white" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" style="color: #fff !improtant;">
                <span class="navbar-toggler-icon text-white" ></span>
            </button>
           
            </div>
        </div>
    </nav>
</div>



	<div class="container-fluid" style="text-align: center">
	<h1 style="text-align: center;margin: 20px">Đăng nhập Admin</h1>
	
	<div class="row">
	<div class="col-lg-4"></div>
	<div class="col-lg-4" style="text-align: left">
		<form action="adminDangNhapController" method="post">
		<lable >Tên tài khoản: </lable><br>
		<input type="text" name="txttendn" style="width: 100%; margin: 10px 0;"><br>
		<lable>Mật khẩu: </lable><br>
		<input type="password" name="txtpass" style="width: 100%; margin: 10px 0;"><br>
		<%if(request.getAttribute("thongtin") != null){ %>
		<div style="color: red">Bạn đã nhập sai tài khoản hoặc mật khẩu vui lòng thử lại</div>
		<%} %>
		<a href="dangNhapController" class="text-primary">Đăng nhập với tư cách khách hàng</a>
		<div style="text-align: center" >
			<input type="submit" class="btn btn-dark" style="width: 100%;margin-top: 10px" value="LOG IN">
			</div>
		</form>
	</div>
	<div class="col-lg-4"></div>
	</div>
	
	
	
	</div>
</body>
</html>