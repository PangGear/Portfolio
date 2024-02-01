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
<table border="1">
<tr align="center">
<td width="50">번호</td>
<td width="150">제목</td>
<td width="100">작성자</td>
<td width="170">등록일</td>
</tr>
<c:forEach items="${li}" var="m">
<tr>
	<td>${m.id}</td>
	<td><a href="getBoard.do?id=${m.id}">${m.title}</a></td>
	<td>${m.reg_id}</td>
	<td>${m.reg_dt}</td>
</tr>
</c:forEach>
</table>
</div>
</section>
<c:import url="/WEB-INF/view/include/bottom.jsp" />