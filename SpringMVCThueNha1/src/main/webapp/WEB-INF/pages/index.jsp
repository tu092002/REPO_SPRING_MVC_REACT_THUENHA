<%-- 
    Document   : index
    Created on : Aug 15, 2023, 9:46:23 AM
    Author     : nitro 5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
    </head>

    <body>

        <h1 class = "text-center text-danger"> QUAN LI USER </h1>

        <a href="<c:url value="/user"/>" class="btn btn-info">Thêm User</a>
        <ul class="pagination mt-2">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <c:forEach begin = "1" end="${page}" var = "p">
                    <c:url value="/" var = "pageAction">
                        <c:param name="page" value="${p}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageAction}">${p}</a></li>

            </c:forEach>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>img</th>
                    <th>hoten</th>
                    <th>username</th>
                    <th>address</th>
                    <th>role</th>
                    <th>phone</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.idUser}</td>
                        <td>
                            <img src="${u.avatar}" placeholder="${u.hoten}" width="120"/>
                        </td>
                        <td>${u.hoten}</td>
                        <td>${u.username}</td>
                        <td>${u.address}</td>
                        <td>${u.role}</td>
                        <td>${u.phone}</td>
                        <td>
                            <c:url value="/user/${u.idUser}" var="api" />
                            <a href="${api}" class="btn btn-info" onclick="alert('hello')">Cập nhật</a>



                            <c:url value="/api/user/${u.idUser}" var="apiDel" />
                            <button class="btn btn-danger" onclick="deleteUser('${apiDel}')">Xóa</button>
                        </td>
                    </tr>
                </c:forEach>


            </tbody>
        </table>
    </body>

    <script src="<c:url value="/js/main.js" />"></script>


</html>

