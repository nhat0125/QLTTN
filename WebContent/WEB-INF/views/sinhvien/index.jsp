<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Xin chào</title>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet" />
<!-- Nucleo Icons -->
<link href="../resources/assets/css/nucleo-icons.css" rel="stylesheet" />
<link href="../resources/assets/css/nucleo-svg.css" rel="stylesheet" />
<!-- Font Awesome Icons -->
<script src="https://kit.fontawesome.com/42d5adcbca.js"
	crossorigin="anonymous"></script>
<link href="../resources/assets/css/nucleo-svg.css" rel="stylesheet" />
<!-- CSS Files -->
<link id="pagestyle"
	href="../resources/assets/css/soft-ui-dashboard.css?v=1.0.3"
	rel="stylesheet" />
</head>
<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
				<div class="card-header">
					<div class="row">
						<div class="col-md-11">
							<h1 class="h8 text-gray-900 mb-1">Xin chào ${tensinhvien}</h1>
						</div>
						<div class="col-md-1">
							<a class="btn btn-danger"
								href="../log/logout.htm"
								role="button">THOÁT </a>
						</div>
					</div>
					</div>
					<hr>
					<div class="card-header">

						<form:form class="form-inline"
							action="../sinhvien/thi.htm"
							modelAttribute="mh">
							<div class="row">
								<div class="form-group mb-2">
									<h4>Chọn môn thi:<h4>
								</div>
								<div class="col-md-4">
									<form:select path="maMonHoc" items="${monhoc}"
										itemValue="maMonHoc" itemLabel="tenMonHoc"
										class="form-control" aria-label=".form-select-lg example">
									</form:select>
								</div>
								<div class="col-md-7">
									<button class="btn btn-success mb-2">BẮT ĐẦU LUYỆN THI</button>
								</div>

								<p class="text-danger">${message}</p>
							</div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>