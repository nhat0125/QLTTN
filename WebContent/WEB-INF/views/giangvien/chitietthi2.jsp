<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/views/giangvien/header.jsp"%>

	<main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
	<div class="container-fluid py-4">
	<div class="card mb-4">
            <div class="card-header pb-0">
              <h6>DANH SÁCH CÁC LƯỢT THI</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Mã sinh viên</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Họ và tên</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Môn thi</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Điểm</th>
                      <th class="text-center text-uppercase text-xs font-weight-bolder opacity-10" scope="col">Ngày thi</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="ctt" items="${dsctt}">
						<tr class="text-secondary">
							<td class="text-center text-secondary font-weight-bold text-s">${ctt.maTaiKhoan}</td>
							<td class="text-center text-secondary font-weight-bold text-s">${ctt.hoTen}</td>
							<td class="text-center text-secondary font-weight-bold text-s">${ctt.tenMonHoc}</td>
							<td class="text-center text-secondary font-weight-bold text-s">${ctt.diem}</td>
							<td class="text-center text-secondary font-weight-bold text-s">${ctt.getNgayThi()}</td>
						</tr>
					</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          </div>
          
         </main>

 <%@include file="/WEB-INF/views/giangvien/footer.jsp"%>