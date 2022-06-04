<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
	
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <title>Thi trắc nghiệm</title>
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
  <!-- Nucleo Icons -->
  <link href="../resources/assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="../resources/assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <link href="../resources/assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link id="pagestyle" href="../resources/assets/css/soft-ui-dashboard.css?v=1.0.3" rel="stylesheet" />
</head>

<body class="">
  <div class="container position-sticky z-index-sticky top-0">
    <div class="row">
      <div class="col-12">
        <!-- End Navbar -->
      </div>
    </div>
  </div>
  <main class="main-content  mt-0">
    <section>
      <div class="page-header min-vh-75">
        <div class="container">
          <div class="row">
            <div class="col-xl-4 col-lg-5 col-md-6 d-flex flex-column mx-auto">
              <div class="card card-plain mt-8">
                <div class="card-header pb-0 text-left bg-transparent">
                  <h3 class="font-weight-bolder text-info text-gradient">Xin chào!</h3>
                  <p class="mb-0">Nhập tên đăng nhập và mật khẩu để đăng nhập</p>
                </div>
                <div class="card-body">
                  <form:form action="../log/login.htm" modelAttribute="taikhoan">
                    <label>Tên đăng nhập</label>
                    <div class="mb-3">
                      <form:input path="maTaiKhoan" class="form-control" placeholder="Nhập tên đăng nhập" aria-label="Email" aria-describedby="email-addon"/>
                      <form:errors path="maTaiKhoan"></form:errors>
                    </div>
                    <label>Mật khẩu</label>
                    <div class="mb-3">
                      <form:input type="password" path="matKhau" class="form-control" placeholder="Nhập mật khẩu" aria-label="Password" aria-describedby="password-addon"/>
                      <form:errors path="matKhau"></form:errors>
                    </div>
                    <div class="text-center">
                    	<%-- <h5>${message}</h5> --%>
                    	<h6 class="text-danger">${message}</h6>
                      <button class="btn bg-gradient-info w-100 mt-4 mb-0">ĐĂNG NHẬP</button>
                    </div>
                  </form:form>
                </div>
              </div>
            </div>
            <div class="col-md-7">
              <div class="oblique position-absolute top-0 h-100" >
                <div class="oblique-image bg-cover position-absolute fixed-top h-100 ms-n7" style="background-image:url('../resources/assets/img/curved-images/index.jpg'); margin-left: 5px"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
  
  <!--   Core JS Files   -->
  <script src="../resources/assets/js/core/popper.min.js"></script>
  <script src="../resources/assets/js/core/bootstrap.min.js"></script>
  <script src="../resources/assets/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="../resources/assets/js/plugins/smooth-scrollbar.min.js"></script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <!-- Github buttons -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../resources/assets/js/soft-ui-dashboard.min.js?v=1.0.3"></script>
</body>

</html>