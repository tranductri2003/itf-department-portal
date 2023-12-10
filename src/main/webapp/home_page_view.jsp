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
    <link href="home-page.css" rel="stylesheet">
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
        <div class="col-md-6 px-0">
            <h1 class="display-4 font-italic">Tiêu đề bài viết nhiều view nhất</h1>
            <p class="lead my-3">Exceprt bài viết nhiều view nhất</p>
            <p class="lead mb-0"><a href="#" class="text-white font-weight-bold">Continue reading...</a></p>
        </div>
    </div>

    <div class="row mb-2">
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-primary">Title category</strong>
                    <h3 class="mb-0">
                        <a class="text-dark" href="#">Tiêu đề Bài viết nhiều view</a>
                    </h3>
                    <div class="mb-1 text-muted">Ngày</div>
                    <p class="card-text mb-auto">Nội Dung</p>
                    <a href="#">Continue reading</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block" src="media/asset/ronaldo.jpg" alt="Description of the image" width="250" height="200">
            </div>
        </div>
        <div class="col-md-6">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-success">Title category</strong>
                    <h3 class="mb-0">
                        <a class="text-dark" href="#">Tiêu đề Bài viết nhiều view</a>
                    </h3>
                    <div class="mb-1 text-muted">Ngày</div>
                    <p class="card-text mb-auto">Nội Dung</p>
                    <a href="#">Continue reading</a>
                </div>
                <img class="card-img-right flex-auto d-none d-md-block" data-src="holder.js/200x250?theme=thumb"
                     alt="Card image cap">
            </div>
        </div>
    </div>
</div>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <h3 class="pb-3 mb-4 font-italic border-bottom">
                Các bài viết khác
            </h3>

            <div class="blog-post">
                <h2 class="blog-post-title">Các bài viết ít view hơn</h2>
                <p class="blog-post-meta">Ngày giờ by <a href="#">Tác giả</a></p>

                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic
                    typography, images, and code are all supported.</p>
                <hr>
                <p>Cum sociis natoque penatibus et magnis <a href="#">dis parturient montes</a>, nascetur ridiculus mus.
                    Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est
                    at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>
                <blockquote>
                    <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu
                        leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </blockquote>
                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum.
                    Aenean lacinia bibendum nulla sed consectetur.</p>
            </div><!-- /.blog-post -->

            <div class="blog-post">
                <h2 class="blog-post-title">Các bài viết ít view hơn</h2>
                <p class="blog-post-meta">Ngày giờ by <a href="#">Tác giả</a></p>

                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic
                    typography, images, and code are all supported.</p>
                <hr>
                <p>Cum sociis natoque penatibus et magnis <a href="#">dis parturient montes</a>, nascetur ridiculus mus.
                    Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est
                    at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>
                <blockquote>
                    <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu
                        leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </blockquote>
                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum.
                    Aenean lacinia bibendum nulla sed consectetur.</p>
            </div><!-- /.blog-post -->

            <div class="blog-post">
                <h2 class="blog-post-title">Các bài viết ít view hơn</h2>
                <p class="blog-post-meta">Ngày giờ by <a href="#">Tác giả</a></p>

                <p>This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic
                    typography, images, and code are all supported.</p>
                <hr>
                <p>Cum sociis natoque penatibus et magnis <a href="#">dis parturient montes</a>, nascetur ridiculus mus.
                    Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est
                    at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>
                <blockquote>
                    <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu
                        leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </blockquote>
                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum.
                    Aenean lacinia bibendum nulla sed consectetur.</p>
            </div><!-- /.blog-post -->



            <nav class="blog-pagination">
                <a class="btn btn-outline-primary" href="#">Về đầu trang</a>
            </nav>

        </div><!-- /.blog-main -->

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
                    <li><a href="#">HOME</a></li>
                    <li><a href="#">GIỚI THIỆU</a></li>
                    <li><a href="#">TUYỂN SINH</a></li>
                    <li><a href="#">ĐÀO TẠO</a></li>
                    <li><a href="#">NGHIÊN CỨU KHOA HỌC</a></li>
                    <li><a href="#">HỢP TÁC</a></li>
                    <li><a href="#">SINH VIÊN</a></li>
                    <li><a href="#">CỰU SINH VIÊN</a></li>
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