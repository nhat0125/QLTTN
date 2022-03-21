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
        <form:form modelAttribute="cauhoi" action="../giangvien/tsxch.htm">
        <div class="row">
			<div class="col-md-12">
					<label class="font-weight-bold">Nội dung</label>
					<form:input path="noiDung" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập nội dung câu hỏi" />
					<form:errors path="noiDung"></form:errors>
			</div>
			<div class="col-md-6">
					<label class="font-weight-bold">Phương án A</label>
					<form:input path="a" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập phương án A" />
					<form:errors path="a"></form:errors>		
			</div>
			<div class="col-md-6">
					<label class="font-weight-bold">Phương án B</label>
					<form:input path="b" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập phương án B" />
					<form:errors path="b"></form:errors>		
			</div>
			<div class="col-md-6">
					<label class="font-weight-bold">Phương án C</label>
					<form:input path="c" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập phương án C" />
					<form:errors path="c"></form:errors>		
			</div>
			<div class="col-md-6">
					<label class="font-weight-bold">Phương án D</label>
					<form:input path="d" type="text" class="form-control"
						id="exampleFormControlInput1" placeholder="Nhập phương án D" />
					<form:errors path="d"></form:errors>		
			</div>
			<div class="col-md-6">
					<label class="font-weight-bold">Đáp án</label>
					<form:select path="dapAn" items="${dapAn}" class="form-control"
						aria-label=".form-select-lg example">

					</form:select>
			</div>
			<div class="col-md-6">
					<label class="font-weight-bold">Môn học</label>
					<form:select path="maMonHoc" items="${monHoc}"
						itemValue="maMonHoc" itemLabel="tenMonHoc" class="form-control"
						aria-label=".form-select-lg example">
					</form:select>
			</div> 
			</div>
			<div class="col-md-12">
					&nbsp;
			</div>
			<button name="${btnTrangThai}" class="btn btn-success">Lưu</button>
		</form:form>
		</div>
		</div>
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>DANH SÁCH CÂU HỎI</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Mã câu hỏi</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Nội dung</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Chức năng</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="ch" items="${dscauhoi}">
						<tr class="text-secondary">
							<td class="text-center">${ch.idCH}</td>
							<td >${ch.noiDung}</td>
							<td class="align-middle">
                        		<a href="../giangvien/${ch.idCH}.htm?linkEdit3" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
          							Chỉnh sửa
                        		</a>
                        		|
                        		<a href="../giangvien/${ch.idCH}.htm?linkDelete3" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
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