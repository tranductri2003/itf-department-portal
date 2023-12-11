<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="media/asset/logo.ico">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
  <title>ITF-Department-Portal</title>

  <!-- Bootstrap core CSS -->
  <link href="bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
  <link href="list-post.css" rel="stylesheet">
</head>
<body>
<% if (request.getAttribute("errorMessage") != null) { %>
<div class="alert alert-danger" role="alert">
  <%= request.getAttribute("errorMessage") %>
</div>
<% } %>

<section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Đăng ký tài khoản</p>

                <form class="mx-1 mx-md-4" action="AuthenticationManagementServlet?action=register" method="POST">

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-user fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="username" name="username" class="form-control" required />
                      <label class="form-label" for="username">Tài khoản</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-lock fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="password" id="password" name="password" class="form-control" required />
                      <label class="form-label" for="password">Mật khẩu</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-envelope fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="email" id="email" name="email" class="form-control" required />
                      <label class="form-label" for="email">Email của bạn</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-id-card fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="full_name" name="full_name" class="form-control" required />
                      <label class="form-label" for="full_name">Họ và tên</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-phone fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="phone_number" name="phone_number" class="form-control" required />
                      <label class="form-label" for="phone_number">Số điện thoại</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-map-marker-alt fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="address" name="address" class="form-control" required/>
                      <label class="form-label" for="address">Địa chỉ</label>
                    </div>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <input type="submit" value="Đăng ký" class="btn btn-primary btn-lg" style="background-color: gray; border: 1px solid gray;">
                  </div>

                </form>

              </div>
              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                     class="img-fluid" alt="Sample image">

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>

