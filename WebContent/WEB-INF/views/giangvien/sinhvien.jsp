<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/giangvien/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg">
<div class="container-fluid py-4">
<div class="row">
        <div class="col-12">
        <div class="card mb-4">
        <div class="card-body">
        <form:form modelAttribute="sinhvien" action="../giangvien/tsxsv.htm">
        <div class="row">
        	<div class="col-md-2">
					<label>Mã sinh viên</label>
					<form:input path="maTaiKhoan" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập mã sinh viên" />
					<form:errors path="maTaiKhoan"></form:errors>
			</div>
			<div class="col-md-2">
					<label>Họ</label>
					<form:input path="ho" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập họ" />
					<form:errors path="ho"></form:errors>
			</div>
			<div class="col-md-2">
					<label>Tên</label>
					<form:input path="ten" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập tên" />
					<form:errors path="ten"></form:errors>
			</div>
			<div class="col-md-2">
					<label>Email</label>
					<form:input path="email" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập Email" />
					<form:errors path="email"></form:errors>
			</div>
			<div class="col-md-2">
					<label>Mật khẩu</label>
					<form:input path="matKhau" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập mật khẩu" />
					<form:errors path="matKhau"></form:errors>
			</div>
			
			</div>
			<div class="col-md-12">
					&nbsp;
				</div>
			<button name="${btnTrangThai}" class="btn btn-success">Lưu</button>
			<p5 class="text-success">${success}</p5>
			<p5 class="text-danger">${error}</p5>
		</form:form>
		</div>
		</div>
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>DANH SÁCH SINH VIÊN</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10">Mã sinh viên</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10">Họ</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10">Tên</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10">Email</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10"> Chức năng</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="sv" items="${dssinhvien}">
						<tr class="text-center text-secondary">
							<td>${sv.maTaiKhoan}</td>
							<td>${sv.ho}</td>
							<td>${sv.ten}</td>
							<td>${sv.email}</td>
							<td class="align-middle">
                        		<a href="../giangvien/${sv.maTaiKhoan}.htm?linkEdit2" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
          							Chỉnh sửa
                        		</a>
                        		|
                        		<a href="../giangvien/${sv.maTaiKhoan}.htm?linkDelete2" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
          							Xóa
                        		</a>
                      </td>
						</tr>
					</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
      </main>

<%@include file="/WEB-INF/views/giangvien/footer.jsp"%>
