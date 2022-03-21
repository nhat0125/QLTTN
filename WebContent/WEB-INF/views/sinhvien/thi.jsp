<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Thi</title>
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

			<div class="card o-hidden border-0 shadow-lg my-6">
				<!-- <div class="card-body p-0"> -->
					<div class="card-header">
						<form:form action="../sinhvien/thi.htm" modelAttribute="cauHoi">
							<div class="card text-white bg-info mb-3"
								style="max-width: 80rem;">
								<div class="card-body">
									<h3 class="card-title">Trắc nghiệm môn: ${tenmonhoc}</h3>
								</div>
							</div>
							<div class="card-header">
								<h5 class="font-weight-bold">Câu ${tt}: ${cauHoi.noiDung}</h5>
							</div>
							<div class="card-header">
								<div class="form-check">
									<form:radiobutton path="luaChon" value="A"/>
									<p2>${cauHoi.a}</p2>
								</div>
								<div class="form-check">
									<form:radiobutton path="luaChon" value="B"/>
									<p2>${cauHoi.b}</p2>
								</div>
								<div class="form-check">
									<form:radiobutton path="luaChon" value="C"/>
									<p2>${cauHoi.c}</p2>
								</div>
								<div class="form-check">
									<form:radiobutton path="luaChon" value="D"/>
									<p2>${cauHoi.d}</p2>
								</div>
							</div>
							<div class="card-body">
								<div class="form-group d-flex justify-content-center visible">
										<button class="btn btn-success">Xác nhận</button>
									</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>