<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link rel="icon" href="media/asset/logo.ico">

    <title>ITF-Department-Portal</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <link href="list-post.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
    <link href="login.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-2">
                <img src="media/asset/logo.jpg" alt="Logo" width="100" height="100" margin-right="0px">
            </div>
            <div class="col-6 text-center">
                <a class="blog-header-logo text-dark" href="#">TRƯỜNG ĐẠI HỌC BÁCH KHOA</a>
                <br>
                <a class="blog-header-logo text-dark" href="#">KHOA CÔNG NGHỆ THÔNG TIN</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search...">
                    <div class="input-group-append">
                        <a class="text-muted" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                                 stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3">
                                <circle cx="10.5" cy="10.5" r="7.5"></circle>
                                <line x1="21" y1="21" x2="15.8" y2="15.8"></line>
                            </svg>
                        </a>
                    </div>
                </div>
                <span style="width: 10px;"></span> <!-- Khoảng cách giữa Search field và Sign In -->
                <a class="btn btn-sm btn-outline-secondary" href="#">Sign In</a>
                <span style="width: 10px;"></span> <!-- Khoảng cách giữa Sign In và Sign Up -->
                <a class="btn btn-sm btn-outline-secondary" href="#">Sign Up</a>
            </div>
        </div>
        <div class="nav-scroller py-1 mb-2">
            <nav class="nav d-flex justify-content-between">
                <a class="p-2 text-muted" href="#">HOME</a>
                <a class="p-2 text-muted" href="#">GIỚI THIỆU</a>
                <a class="p-2 text-muted" href="#">TUYỂN SINH</a>
                <a class="p-2 text-muted" href="#">ĐÀO TẠO</a>
                <a class="p-2 text-muted" href="#">NGHIÊN CỨU KHOA HỌC</a>
                <a class="p-2 text-muted" href="#">HỢP TÁC</a>
                <a class="p-2 text-muted" href="#">SINH VIÊN</a>
                <a class="p-2 text-muted" href="#">CỰU SINH VIÊN</a>
            </nav>
        </div>
    </header>

</div>
<section class="vh-100">
	  <div class="container-fluid h-custom">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-md-9 col-lg-6 col-xl-5">
	        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
	          class="img-fluid" alt="Sample image">
	      </div>
	      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1" >
	        <form action="LoginServlet" method="POST">
	
	          <div class="d-flex flex-row mb-4">
	           	  <i class="fas fa-user fa-lg me-2 fa-fw" style="padding:18px 30px 2.5px 2.5px"></i>
		          <div class="form-outline flex-fill mb-0">
		            <input type="email" id="username" class="form-control form-control-lg"
		              placeholder="Nhập tài khoản" />
		            <label class="form-label" for="username">Tài khoản</label>
		          </div>
			  </div>
	          <!-- Password input -->
	          <div class="d-flex flex-row mb-4">
	           	  <i class="fas fa-lock fa-lg me-2 fa-fw" style="padding:18px 30px 2.5px 2.5px"></i>
		          <div class="form-outline flex-fill mb-0">
		            <input type="password" id="password" class="form-control form-control-lg"
		              placeholder="Nhập mật khẩu" />
		            <label class="form-label" for="password">Mật khẩu</label>
		          </div>
	          </div>
	
	          <div class="text-center text-lg-start mt-4 pt-2">
	            <input type="submit" id="login" value="Đăng nhập" class="btn btn-primary btn-lg"
	              style="padding-left: 2.5rem; padding-right: 2.5rem; background-color: gray; border: 1px solid gray;">
	            <p class="small fw-bold mt-2 pt-1 mb-0">Bạn chưa có tài khoản? <a href="#!"
	                class="link-danger">Đăng ký</a></p>
	          </div>
	
	        </form>
	      </div>
	    </div>
	  </div>
</section>
<footer class="blog-footer">
    <div class="mt-5">
        <p class="copyright">© 2023 Bản quyền Trường Đại học Bách khoa - Đại học Đà Nẵng</p>
    </div>
    </p>
</footer>
</body>
</html>
