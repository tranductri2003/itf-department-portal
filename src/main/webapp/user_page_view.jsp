<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import="model.bean.User" %>
<%@ page import="model.bean.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="media/asset/logo.ico">

	<title>ITF-Department-Portal</title>
	<link href="user_page_view.css" rel="stylesheet">
	<link href="list_post_view.css" rel="stylesheet">
	<link href="bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
	<link href="list-post.css" rel="stylesheet">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

	<style>
		.form-container {
			display: flex;
			justify-content: flex-end; /* Aligns items to the start of the container */
			align-items: center;    /* Centers items vertically */
		}
	</style>
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
			<%
				User user = (User) session.getAttribute("user");
			%>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<form method="post" action="PostManagementServlet?action=search" class="my-2 my-lg-0">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search..." name="searchValue">
						<div class="input-group-append">
							<button type="submit" class="btn btn-outline-secondary">
								<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
									 stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-2">
									<circle cx="10.5" cy="10.5" r="7.5"></circle>
									<line x1="21" y1="21" x2="15.8" y2="15.8"></line>
								</svg>
							</button>
						</div>
					</div>
				</form>
				<span style="width: 10px;"></span>

				<% if (user != null) { %>
				<a class="btn btn-sm btn-outline-secondary" href="PostManagementServlet?action=viewUserPosts&userId=<%= user.getId() %>"> <%= user.getFullName() %> </a>
				<span style="width: 10px;"></span>
				<a class="btn btn-sm btn-outline-secondary" href="AuthenticationManagementServlet?action=logout" method="POST">Sign Out</a>
				<% } else { %>
				<a class="btn btn-sm btn-outline-secondary" href="login_view.jsp">Sign In</a>
				<span style="width: 10px;"></span>
				<a class="btn btn-sm btn-outline-secondary" href="register_view.jsp">Sign Up</a>
				<% } %>
			</div>
		</div>
		<div class="nav-scroller py-1 mb-2">
			<nav class="nav d-flex justify-content-between">
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewHome">HOME</a>
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewIntroduction">GIỚI THIỆU</a>
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewTuyenSinh">TUYỂN SINH</a>
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewDaoTao">ĐÀO TẠO</a>
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewNCKH">NGHIÊN CỨU KHOA HỌC</a>
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewHopTac">HỢP TÁC</a>
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewSinhVien">SINH VIÊN</a>
				<a class="p-2 text-muted" href="PostManagementServlet?action=viewCuuSinhVien">CỰU SINH VIÊN</a>
			</nav>
		</div>
		<hr class="border-bottom">
	</header>
</div>
<div class="container">
	<div class="row gutters">
		<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
			<% if (request.getAttribute("errorMessage") != null) { %>
			<div class="alert alert-danger" role="alert">
				<%= request.getAttribute("errorMessage") %>
			</div>
			<% } %>
			<%
				User userProfile = (User) request.getAttribute("author");
				if (userProfile != null) {
			%>

			<div class="card h-100">

				<div class="card-body">
					<div class="account-settings">
						<div class="user-profile">
							<%
								boolean isEditable = user != null && userProfile != null && user.getId().equals(userProfile.getId()) ;
							%>
							<div class="user-avatar">
								<% 
									String img = userProfile.getAvatar(); 
									if (img == null || img == "") {
										img = "https://bootdey.com/img/Content/avatar/avatar7.png";
									}
								%>
								<img src="<%=img %>" alt="Maxwell Admin">

							</div>

							<h4 class="user-name"><%= userProfile.getFullName() %></h4>
							<h6 class="user-email">Gmail: <%= userProfile.getEmail() %></h6>
							<h6 class="user-phoneNumber">SĐT: <%= userProfile.getPhoneNumber() %></h6>
							<h6 class="user-address">Địa chỉ: <%= userProfile.getAddress() %></h6>
							<%
								}
							%>

						</div>
						<div class="about">
							<h5>About</h5>
							<p><%= userProfile.getAbout() %></p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
			<%
				boolean isEditable = (user != null && userProfile != null && user.getId().equals(userProfile.getId())) || user.getRole().equals("AD") ;

			%>
			<div class="card h-100">
				<div class="card-body">
					<form action="UserManagementServlet?action=update&userId=<%= userProfile.getId() %>" method="post" enctype="multipart/form-data">
						<div class="row gutters">
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">

								<h6 class="mb-2 text-primary">Personal Details</h6>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="fullName">Full Name</label>
									<input type="text" class="form-control" id="fullName" name="fullName" placeholder="Họ và tên" value="<%= userProfile.getFullName() %>" <%= isEditable ? "" : "readonly" %> required>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="eMail">Email</label>
									<input type="email" class="form-control" id="eMail" name="eMail" placeholder="Email" value="<%= userProfile.getEmail() %>" <%= isEditable ? "" : "readonly" %> required>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="phone">Phone</label>
									<input type="text" class="form-control" id="phone" name="phone" placeholder="Số điện thoại" value="<%= userProfile.getPhoneNumber() %>" <%= isEditable ? "" : "readonly" %> required>
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="website">Address</label>
									<input type="text" class="form-control" id="Address" name="Address" placeholder="Địa chỉ" value="<%= userProfile.getAddress() %>" <%= isEditable ? "" : "readonly" %> required>
								</div>
							</div>
						</div>
						<div class="row gutters">
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
								<h6 class="mt-3 mb-2 text-primary">About Me</h6>
								<textarea class="form-control" id="about" name="about" rows="3" <%= isEditable ? "" : "readonly" %> ><%= userProfile != null ? userProfile.getAbout() : "" %></textarea>
								<% if (isEditable) { %>
								<div class="form-group">
									<h6 class="mt-3 mb-2 text-primary">Change Avatar</h6>
									<input type="file" id="image" name="image" accept="image/*" class="form-control">
								</div>
								<% } %>
							</div>
						</div>
						<div class="row gutters">
							<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
								<%
									User sessionUser = (User) session.getAttribute("user");
									User author = (User) request.getAttribute("author");

									if (sessionUser != null && (
											sessionUser.getId().equals(author.getId()) || // Kiểm tra ID giống nhau
													sessionUser.getRole().equals("AD") // Kiểm tra role là 'AD'
									)) {                                        // Hiển thị các nút button nếu ID của người dùng trong session và author giống nhau
								%>
								<div class="text-right">
									<button type="button" id="cancel" name="cancel" class="btn btn-secondary">Cancel</button>
									<button type="submit" id="update" name="update" class="btn btn-primary" >Update</button>
								</div>
								<%
									}
								%>
							</div>
						</div>
					</form>
					<form action="PostManagementServlet?action=insertForm" method="post">
					<button type="submit" id="ỉnsert" name="ỉnsert" class="btn btn-primary" >Tạo bài đăng mới</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>



<%-- POST --%>


<% List<Post> listPost = (List<Post>) request.getAttribute("listUserPost"); %>

<main role="main" class="container">
	<div class="row">
		<div class="col-md-8 blog-main">
			<h3 class="pb-3 mb-4 font-italic border-bottom">
				Các bài viết khác của tác giả
			</h3>

			<% for (int i = 3; i < listPost.size(); i++) { %>
			<div class="blog-post">
				<h2 class="blog-post-title"><%= listPost.get(i).getTitle() %></h2>
				<p class="blog-post-meta"><%=listPost.get(i).getNumViews()%> Lượt xem
				<p class="blog-post-meta"><%=listPost.get(i).getDate()%> by <a href="PostManagementServlet?action=viewUserPosts&userId=<%=listPost.get(i).getAuthor()%>"><%= listPost.get(i).getAuthor() %></a></p>

				<p><%= listPost.get(i).getExcerpt() %></p>
				<hr>
				<p>Nội dung các bài viết</p>
				<a href="PostManagementServlet?action=detailPost&id=<%= listPost.get(i).getId() %>">Continue reading</a>

				<!-- Kiểm tra điều kiện và hiển thị nút "Update" và "Delete" -->
				<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
					<%
						if (sessionUser != null && (
								sessionUser.getId().equals(author.getId()) || // Kiểm tra ID giống nhau
										sessionUser.getRole().equals("AD") // Kiểm tra role là 'AD'
						)) {
					%>
					<!-- Container cho các nút Update và Delete -->
					<div class="form-container">
						<form method="post" action="PostManagementServlet?action=updateForm&userId=<%= userProfile.getId()%>" style="margin-right: 10px;">
							<button type="submit" id="update<%= i %>" name="update" value="<%= listPost.get(i).getId() %>" class="btn btn-primary">Update</button>
						</form>
						<form method="post" action="PostManagementServlet?action=delete&userId=<%= userProfile.getId()%>">
							<button type="submit" id="delete<%= i %>" name="delete" value="<%= listPost.get(i).getId() %>" class="btn btn-danger">Delete</button>
						</form>
					</div>


					<%
						}
					%>
				</div>
			</div><!-- /.blog-post -->
			<% } %>

			<nav class="blog-pagination">
				<a class="btn btn-outline-primary" href="#">Về đầu trang</a>
			</nav>
		</div>
		<!-- /.blog-main -->
	</div><!-- /.row -->
</main><!-- /.container -->


</body>
</html>