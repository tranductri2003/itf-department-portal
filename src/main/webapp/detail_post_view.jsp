<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        <hr class="border-bottom">
    </header>


    <div class="jumbotron p-3 p-md-5 text-white rounded bg-dark">
        <div class="row">
            <div class="col-md-6">
                <!-- Hình ở đây -->
                <img src="media/asset/ronaldo.jpg" alt="Description of the image" class="img-fluid rounded">
            </div>
            <div class="col-md-6">
                <!-- Nội dung văn bản ở đây -->
                <h1 class="display-4 font-italic">Tiêu đề bài viết nhiều view nhất</h1>
                <p class="blog-post-meta">Ngày giờ by <a href="#">Tác giả</a></p>
                <p class="lead my-3">Exceprt bài viết nhiều view nhất</p>
            </div>
        </div>
    </div>
</div>

<main role="main" class="container">
    <p>Nội dung các bài viết</p>
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