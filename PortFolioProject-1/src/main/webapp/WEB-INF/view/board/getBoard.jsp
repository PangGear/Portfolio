<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:import url="/WEB-INF/view/include/top.jsp" />
<section>
<br>
<div align="center">
<h1>게시판 목록</h1>
</div>
<br>

<div align="center">
<form action="boardUpdate.do?id=${m.id}">
	<table border="1">
		<tr align="center">
		<td width="50">ID</td>
		<td><input type="text" value="${m.id}" readonly></td>
		</tr>
		<tr align="center">
		<td width="50">제목</td>
		<td><input type="text" name="title" value="${m.title}"></td>
		</tr>
		<tr align="center">
		<td width="50">내용</td>
		<td><textarea name="content">${m.content}</textarea></td>
		</tr>
		<tr align="center">
		<td width="50">작성자</td>
		<td><input type="text"value="${m.reg_id}" readonly></td>
		</tr>
		<tr align="center">
		<td width="50">등록일시</td>
		<td><input type="text" value="${m.reg_dt}" readonly></td>
		</tr>
		<tr align="center">
		<td width="100">수정일시</td>
		<td><input type="text" value="${m.upd_dt}" readonly></td>
		</tr>
		<tr><td colspan="2" align="center"><input type="submit" value="Update"/></td></tr>
	</table>
</form>
</div>
</section>
<c:import url="/WEB-INF/view/include/bottom.jsp" />