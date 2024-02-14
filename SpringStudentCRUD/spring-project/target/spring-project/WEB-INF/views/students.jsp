<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>

    <a href="<c:url value='/students/add'/>">Add Student</a>

    <c:choose>
        <c:when test="${students != null}">
            <h3>List of Students</h3>
            <table cellpadding="5" cellspacing="5">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="s" items="${students}">
                        <tr>
                            <td>${s.student_id}</td>
                            <td>${s.student_name}</td>
                            <td>${s.student_Dept}</td>
                            <td><a href="<%=request.getContextPath()%>/students/update/${s.student_id}">Update</a>
                                &nbsp; <a href="<%=request.getContextPath()%>/students/delete/${s.student_id}"
                                    onclick="return confirm('Do you really want to delete?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            No Students found in the DB!
        </c:otherwise>
    </c:choose>

</body>
</html>
