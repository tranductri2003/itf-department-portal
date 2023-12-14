<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.bean.Category" %>
<%@ page import="java.util.Date" %>
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

<%
	Post post = (Post) request.getAttribute("post"); 
	List<Category> categoryList = (List<Category>) request.getAttribute("categoryList"); 
%>


<section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-10 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Cập nhật bài đăng</p>

                <form class="mx-1 mx-md-4" action="PostManagementServlet?action=update" method="POST" enctype="multipart/form-data">

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-folder fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <select id="category" name="category" class="form-control" required>
	                    <%
	                    	for (int i = 0; i < categoryList.size(); i++) {
	                   	%>
	                   		<option value=<%= categoryList.get(i).getId()%> 
	                   		<% if (post.getCategory() == categoryList.get(i).getId()) { %> selected <% } %>><%= categoryList.get(i).getTitle() %></option>
	                   	<%
	                    	}
	                    %>
                	  </select>
                      <% System.out.println(post.getCategory()); %>
                      <label class="form-label" for="category">Thể loại</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-file-alt fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="title" name="title" value="<%= post.getTitle() %>" class="form-control" required />
                      <% System.out.println(post.getTitle()); %>
                      <label class="form-label" for="title">Tiêu đề</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-image fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <!-- Display the image using the default URL or user-selected file -->
						<img id="previewImage" src="<%= post.getImage() %>" alt="Preview" class="img-fluid" style="max-width: 100%; max-height: 200px;" />
						
						<!-- File input to allow the user to select a new image -->
						<input type="file" id="image" name="image" accept="image/*" class="form-control" onchange="previewFile()" />
						
						<script>
						  // Function to update the image preview when the user selects a new file
						  function previewFile() {
						    var preview = document.getElementById('previewImage');
						    var fileInput = document.getElementById('image');
						    var file = fileInput.files[0];
						
						    if (file) {
						      var reader = new FileReader();
						      reader.onloadend = function () {
						        preview.src = reader.result;
						      };
						      reader.readAsDataURL(file);
						    } else {
						      // If no file is selected, reset to the default image URL
						      preview.src = '<%= post.getImage() %>';
						    }
						  }
						</script>
                      <label class="form-label" for="image">Hình ảnh</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-quote-left fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <textarea id="excerpt" name="excerpt" rows="5" class="form-control" required /><%= post.getExcerpt() %></textarea>
                      <label class="form-label" for="excerpt">Đoạn trích</label>
                    </div>
                  </div>

                  <div class="d-flex flex-row mb-4">
                    <i class="fas fa-file-alt fa-lg me-2 fa-fw" style="padding:10px 30px 2.5px 2.5px"></i>
                    <div class="form-outline flex-fill mb-0">
                      <textarea id="content" name="content" rows="15" class="form-control" required /><%= post.getContent() %></textarea>
                      <label class="form-label" for="content">Nội dung</label>
                    </div>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                  	<input type="hidden" id="id" name="id" value=<%= post.getId() %>>
                    <input type="submit" value="Cập nhật" class="btn btn-primary btn-lg" style="background-color: gray; border: 1px solid gray;">
                  </div>

                </form>

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

