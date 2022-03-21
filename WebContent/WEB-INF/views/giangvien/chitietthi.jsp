<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/views/giangvien/header.jsp"%>

<main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
	<div class="container-fluid">
	<div class="row">
	<div div class="card-body">
		<div div class="card-header">
			<h3>Chọn môn học để xem các lượt thi</h3>
			<form:form class="row g-3" modelAttribute="MHOC"
				action="../giangvien/chitietthi2.htm">
				<div class="form-inline col-10">
					<form:select path="maMonHoc" items="${monhoc}" itemValue="maMonHoc"
						itemLabel="tenMonHoc" class="form-control"
						aria-label=".form-select-lg example">
					</form:select>
					<div class="col-md-6">
						&nbsp;
					</div>
					<div class="col-6">
						<button name="btnSearch" class="btn btn-success">Xem</button>
					</div>
				</div>

			</form:form>
			<div class="col-md-6">
						&nbsp;
					</div>
			<p5 class="text-danger">${message}</p5>
		</div>
	</div>
</div>
</div>
</main>
	
 <%@include file="/WEB-INF/views/giangvien/footer.jsp"%>