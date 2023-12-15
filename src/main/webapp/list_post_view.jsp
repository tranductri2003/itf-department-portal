<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.bean.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="model.bean.User" %>
<%@ page import="jakarta.ws.rs.POST" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="media/asset/logo.ico">

    <title>ITF-Department-Portal</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <link href="list-post.css" rel="stylesheet">
</head>

<body>
<%
    List<Post> listPost = (List<Post>) request.getAttribute("listPost");
%>
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


    <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
        <div class="row">
            <div class="col-md-6">
                <!-- Hình ở đây -->
                <% if (!listPost.isEmpty()) { %>
                <img src="<%= (listPost.get(0).getImage()==null || listPost.get(0).getImage().equals("")) ? Post.DEFAULT_POST:listPost.get(0).getImage() %>" alt="Description of the image" class="img-fluid rounded">
                <% } %>
            </div>
            <div class="col-md-6">
                <!-- Nội dung văn bản ở đây -->
                <% if (!listPost.isEmpty()) { %>
                <h1 class="display-4 font-italic"><%= listPost.get(0).getTitle() %></h1>
                <p class="blog-post-meta"><%=listPost.get(0).getNumViews()%> Lượt xem
                <p class="blog-post-meta"><%=listPost.get(0).getDate()%> by <a href="PostManagementServlet?action=viewUserPosts&userId=<%= listPost.get(0).getAuthor() %>"><%= listPost.get(0).getAuthor() %></a></p>
                <p class="lead my-3"><%= listPost.get(0).getExcerpt() %></p>
                <a href="PostManagementServlet?action=detailPost&id=<%= listPost.get(0).getId() %>" class="text-white font-weight-bold">
                    Continue reading...
                </a>                <% } %>
            </div>
        </div>
    </div>

    <div class="row mb-2">
        <div class="row mb-2">
            <% for (int i = 1; i < Math.min(listPost.size(), 3); i++) { %>
            <div class="col-md-6">
                <div class="card flex-md-row mb-4 box-shadow h-md-450">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-primary">Lastest Post</strong>
                        <h3 class="mb-0">
                            <a class="text-dark" href="#"><%= listPost.get(i).getTitle() %></a>
                        </h3>
                        <p class="blog-post-meta"><%=listPost.get(i).getNumViews()%> Lượt xem
                        <p class="blog-post-meta"><%=listPost.get(i).getDate()%> by <a href="PostManagementServlet?action=viewUserPosts&userId=<%=listPost.get(i).getAuthor()%>"><%= listPost.get(i).getAuthor() %></a></p>
                        <%
                            String excerpt = listPost.get(i).getExcerpt();
                            int maxWords = 10;

                            // Kiểm tra xem có đủ từ không
                            if (excerpt.split("\\s+").length > maxWords) {
                                // Cắt chuỗi văn bản và giữ lại chỉ số từ 1 đến 200
                                String[] words = excerpt.split("\\s+");
                                excerpt = String.join(" ", Arrays.copyOfRange(words, 0, maxWords));
                                excerpt += "..."; // Thêm dấu chấm cuối cùng để chỉ ra là có thêm phần tiếp theo
                            }
                        %>
                        <p class="card-text mb-auto"><%= excerpt %></p>
                        <a href="PostManagementServlet?action=detailPost&id=<%= listPost.get(i).getId() %>">Continue reading</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-md-block" src="<%= (listPost.get(i).getImage()==null || listPost.get(i).getImage().equals("") ) ? Post.DEFAULT_POST:listPost.get(i).getImage() %>" alt="Description of the image" width="250" height="200">
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Các bài viết khác
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
            </div><!-- /.blog-post -->
            <% } %>

            <nav class="blog-pagination">
                <a class="btn btn-outline-primary" href="#">Về đầu trang</a>
            </nav>
        </div>
<!-- /.blog-main -->

        <aside class="col-md-4 blog-sidebar">
            <div class="p-3 mb-3 bg-light rounded">
                <h4 class="font-italic">Thông tin liên hệ</h4>
                <p>
                    Khoa Công nghệ thông tin, Đại học Bách Khoa, Đại học Đà Nẵng</em><br>
                    54 Nguyễn Lương Bằng, Q. Liên Chiểu, Tp Đà Nẵng<br>
                    <em>+84 236 3736949</em><br>
                    <em>cntt@dut.udn.vn</em>
                </p>
            </div>

            <div class="p-3">
                <h4 class="font-italic">Mục lục</h4>
                <ol class="list-unstyled mb-0">
                    <li><a href="PostManagementServlet?action=viewHome">HOME</a></li>
                    <li><a href="PostManagementServlet?action=viewIntroduction">GIỚI THIỆU</a></li>
                    <li><a href="PostManagementServlet?action=viewTuyenSinh">TUYỂN SINH</a></li>
                    <li><a href="PostManagementServlet?action=viewDaoTao">ĐÀO TẠO</a></li>
                    <li><a href="PostManagementServlet?action=viewNCKH">NGHIÊN CỨU KHOA HỌC</a></li>
                    <li><a href="PostManagementServlet?action=viewHopTac">HỢP TÁC</a></li>
                    <li><a href="PostManagementServlet?action=viewSinhVien">SINH VIÊN</a></li>
                    <li><a href="PostManagementServlet?action=viewCuuSinhVien">CỰU SINH VIÊN</a></li>
                </ol>
            </div>

            <div class="p-3">
                <h4 class="font-italic">About Us</h4>
                <ol class="list-unstyled">
                    <li><a href="https://github.com/tranductri2003/ITF-Department-Portal">GitHub</a></li>
                    <li><a href="https://www.facebook.com/phamnguyenanhphat/">Facebook Phát</a></li>
                    <li><a href="https://www.facebook.com/profile.php?id=100011751662203">Facebook Tuấn</a></li>
                    <li><a href="https://www.facebook.com/tranductri2003/">Facebook Trí</a></li>

                </ol>
            </div>
        </aside><!-- /.blog-sidebar -->

    </div><!-- /.row -->

</main><!-- /.container -->

<footer class="blog-footer">
    <div class="mt-5">
        <p class="copyright">© 2023 Bản quyền Trường Đại học Bách khoa - Đại học Đà Nẵng</p>
    </div>
    </p>
</footer>

<!-- Bootstrap core JavaScript
  ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../../../assets/js/vendor/popper.min.js"></script>
<script src="../../../../dist/js/bootstrap.min.js"></script>
<script src="../../../../assets/js/vendor/holder.min.js"></script>
<script>
    Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
    });
</script>
</body>

</html>