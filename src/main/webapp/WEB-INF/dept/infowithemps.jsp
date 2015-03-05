<%@page import="webapp.model.Emp"%>
<%@page import="java.util.List"%>
<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>infowithemps.jsp</title>
</head>
<body>
<hr>
<h1> 부서 정보(info with emps) </h1>
<hr>
deptno = ${requestScope.dept.deptno } <br>
dname  = ${requestScope.dept.dname } <br>
Loc    = ${requestScope.dept.loc } <br>
<hr>
<%
	Dept dept = (Dept)request.getAttribute("dept");
	List<Emp> list = dept.getEmps();
	
	for(Emp e : list){
		out.println(e.getEmpno() + " " + e.getEname() +"<br>");
	}

%>



</body>
</html>