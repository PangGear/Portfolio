<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>     
<c:import url="/include/top.jsp"/>
<style>
.td1 {
 text-align : center; 
}
</style>

<section>
<br>
<div align="center">

<h2> 회원 목록 보기 </h2>

<table border=1  width=640>
<tr align="center">
	<td>번호</td>
	<td>회원번호</td>
	<td>이름</td>
	<td>전화번호</td>
	<td>등급</td>
</tr>         
<c:forEach  items="${li}" var="m"  varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>${m.username}</td>
		<td>${m.name}</td>
		<td>${m.tel}</td>
		<td>${m.role}</td>
	</tr>
</c:forEach>
</table>

<form action=MemberList.do>

<select name = ch1>
 <c:forEach items="${MemberConditionMap}" var="m" >
 <option value="${m.value}"> ${m.key} </option>
 </c:forEach>
</select>

<input  type=text name=ch2 >
<input  type=submit  value="검색하기" >
</form>

</div>
<br/>
</section>
<c:import url="/include/bottom.jsp" />