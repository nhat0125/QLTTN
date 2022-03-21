<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Kết quả thi</title>
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
					<div class="card text-white mb-3"
						style="max-width: 80rem;">
						<div class="card-body">
							<div class="form-group d-flex justify-content-center visible">
								<h3 class="card-title">KẾT QUẢ CỦA BẠN: ${diem} ĐIỂM</h3>
							</div>
						</div>
					</div>
					<div class="card-body">
							<div class="card-header">
								<h4>Chi tiết:</h4>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 1: ${nd0}</p>
								<div class="form-check">
									<p>${a0}</p>
									<p class="text-success">${a0d}</p>
									<p class="text-danger">${a0s}</p>
								</div>
								<div class="form-check">
									<p>${b0}</p>
									<p class="text-success">${b0d}</p>
									<p class="text-danger">${b0s}</p>
								</div>
								<div class="form-check">
									<p>${c0}</p>
									<p class="text-success">${c0d}</p>
									<p class="text-danger">${c0s}</p>
								</div>
								<div class="form-check">
									<p>${d0}</p>
									<p class="text-success">${d0d}</p>
									<p class="text-danger">${d0s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 2: ${nd1}</p>
								<div class="form-check">
									<p>${a1}</p>
									<p class="text-success">${a1d}</p>
									<p class="text-danger">${a1s}</p>
								</div>
								<div class="form-check">
									<p>${b1}</p>
									<p class="text-success">${b1d}</p>
									<p class="text-danger">${b1s}</p>
								</div>
								<div class="form-check">
									<p>${c1}</p>
									<p class="text-success">${c1d}</p>
									<p class="text-danger">${c1s}</p>
								</div>
								<div class="form-check">
									<p>${d1}</p>
									<p class="text-success">${d1d}</p>
									<p class="text-danger">${d1s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 3: ${nd2}</p>
								<div class="form-check">
									<p>${a2}</p>
									<p class="text-success">${a2d}</p>
									<p class="text-danger">${a2s}</p>
								</div>
								<div class="form-check">
									<p>${b2}</p>
									<p class="text-success">${b2d}</p>
									<p class="text-danger">${b2s}</p>
								</div>
								<div class="form-check">
									<p>${c2}</p>
									<p class="text-success">${c2d}</p>
									<p class="text-danger">${c2s}</p>
								</div>
								<div class="form-check">
									<p>${d2}</p>
									<p class="text-success">${d2d}</p>
									<p class="text-danger">${d2s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 4: ${nd3}</p>
								<div class="form-check">
									<p>${a3}</p>
									<p class="text-success">${a3d}</p>
									<p class="text-danger">${a3s}</p>
								</div>
								<div class="form-check">
									<p>${b3}</p>
									<p class="text-success">${b3d}</p>
									<p class="text-danger">${b3s}</p>
								</div>
								<div class="form-check">
									<p>${c3}</p>
									<p class="text-success">${c3d}</p>
									<p class="text-danger">${c3s}</p>
								</div>
								<div class="form-check">
									<p>${d3}</p>
									<p class="text-success">${d3d}</p>
									<p class="text-danger">${d3s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 5: ${nd4}</p>
								<div class="form-check">
									<p>${a4}</p>
									<p class="text-success">${a4d}</p>
									<p class="text-danger">${a4s}</p>
								</div>
								<div class="form-check">
									<p>${b4}</p>
									<p class="text-success">${b4d}</p>
									<p class="text-danger">${b4s}</p>
								</div>
								<div class="form-check">
									<p>${c4}</p>
									<p class="text-success">${c4d}</p>
									<p class="text-danger">${c4s}</p>
								</div>
								<div class="form-check">
									<p>${d4}</p>
									<p class="text-success">${d4d}</p>
									<p class="text-danger">${d4s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 6: ${nd5}</p>
								<div class="form-check">
									<p>${a5}</p>
									<p class="text-success">${a5d}</p>
									<p class="text-danger">${a5s}</p>
								</div>
								<div class="form-check">
									<p>${b5}</p>
									<p class="text-success">${b5d}</p>
									<p class="text-danger">${b5s}</p>
								</div>
								<div class="form-check">
									<p>${c5}</p>
									<p class="text-success">${c5d}</p>
									<p class="text-danger">${c5s}</p>
								</div>
								<div class="form-check">
									<p>${d5}</p>
									<p class="text-success">${d5d}</p>
									<p class="text-danger">${d5s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 7: ${nd6}</p>
								<div class="form-check">
									<p>${a6}</p>
									<p class="text-success">${a6d}</p>
									<p class="text-danger">${a6s}</p>
								</div>
								<div class="form-check">
									<p>${b6}</p>
									<p class="text-success">${b6d}</p>
									<p class="text-danger">${b6s}</p>
								</div>
								<div class="form-check">
									<p>${c6}</p>
									<p class="text-success">${c6d}</p>
									<p class="text-danger">${c6s}</p>
								</div>
								<div class="form-check">
									<p>${d6}</p>
									<p class="text-success">${d6d}</p>
									<p class="text-danger">${d6s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 8: ${nd7}</p>
								<div class="form-check">
									<p>${a7}</p>
									<p class="text-success">${a7d}</p>
									<p class="text-danger">${a7s}</p>
								</div>
								<div class="form-check">
									<p>${b7}</p>
									<p class="text-success">${b7d}</p>
									<p class="text-danger">${b7s}</p>
								</div>
								<div class="form-check">
									<p>${c7}</p>
									<p class="text-success">${c7d}</p>
									<p class="text-danger">${c7s}</p>
								</div>
								<div class="form-check">
									<p>${d7}</p>
									<p class="text-success">${d7d}</p>
									<p class="text-danger">${d7s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 9: ${nd8}</p>
								<div class="form-check">
									<p>${a8}</p>
									<p class="text-success">${a8d}</p>
									<p class="text-danger">${a8s}</p>
								</div>
								<div class="form-check">
									<p>${b8}</p>
									<p class="text-success">${b8d}</p>
									<p class="text-danger">${b8s}</p>
								</div>
								<div class="form-check">
									<p>${c8}</p>
									<p class="text-success">${c8d}</p>
									<p class="text-danger">${c8s}</p>
								</div>
								<div class="form-check">
									<p>${d8}</p>
									<p class="text-success">${d8d}</p>
									<p class="text-danger">${d8s}</p>
								</div>
							</div>
							<div class="card-header">
								<p class="font-weight-bold">Câu 10: ${nd9}</p>
								<div class="form-check">
									<p>${a9}</p>
									<p class="text-success">${a9d}</p>
									<p class="text-danger">${a9s}</p>
								</div>
								<div class="form-check">
									<p>${b9}</p>
									<p class="text-success">${b9d}</p>
									<p class="text-danger">${b9s}</p>
								</div>
								<div class="form-check">
									<p>${c9}</p>
									<p class="text-success">${c9d}</p>
									<p class="text-danger">${c9s}</p>
								</div>
								<div class="form-check">
									<p>${d9}</p>
									<p class="text-success">${d9d}</p>
									<p class="text-danger">${d9s}</p>
								</div>
							</div>
							<div class="card-header">
								<form action="../sinhvien/thilai.htm">
									<div class="form-group d-flex justify-content-center visible">
										<button class="btn btn-danger btn-lg">Thi lại</button>
									</div>
								</form>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>