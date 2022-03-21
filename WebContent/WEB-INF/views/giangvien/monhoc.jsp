<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/giangvien/header.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
<div class="container-fluid py-4">
<div class="row">
        <div class="col-12">
        <div class="card mb-4">
        <div class="card-body">
        <form:form modelAttribute="monhoc" action="../giangvien/tsxmh.htm">
        <div class="row">
			<div class="col-md-6">
					<label class="font-weight-bold">Mã môn học</label>
					<form:input path="maMonHoc" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập mã môn học" />
					<form:errors path="maMonHoc"></form:errors>
			</div>
			<div class="col-md-6">
					<label class="font-weight-bold">Tên môn học</label>
					<form:input path="tenMonHoc" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập nội tên môn học" />
					<form:errors path="tenMonHoc"></form:errors>
			</div>
			<div class="col-md-12">
					&nbsp;
			</div>
		</div>
			<button name="${btnTrangThai}" class="btn btn-success">Lưu</button>
		</form:form>
		</div>
		</div>
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>DANH SÁCH MÔN HỌC</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Mã môn học</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Tên môn học</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Chức năng</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="mh" items="${dsmonhoc}">
						<tr class="text-secondary">
							<td class="text-secondary text-s">${mh.maMonHoc}</td>
							<td class="text-secondary text-s">${mh.tenMonHoc}</td>
							<td class="text-center align-middle">
                        		<a href="../giangvien/${mh.maMonHoc}.htm?linkEdit4" class="text-center text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
          							Chỉnh sửa
                        		</a>
                        		|
                        		<a href="../giangvien/${mh.maMonHoc}.htm?linkDelete4" class="text-center text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
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