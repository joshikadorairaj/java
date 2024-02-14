<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Student Form</title>
</head>
<body>

    <h2>Add Student Form</h2>

    <form:form method="POST" modelAttribute="student" action="${pageContext.request.contextPath}/students/add">
        <label for="student_name">Name:</label>
        <form:input path="student_name" id="student_name" /> <br />

        <label for="student_Dept">Department:</label>
        <form:input path="student_Dept" id="student_Dept" /> <br />

        <input type="submit" value="Add Student" />
    </form:form>

</body>
</html>
