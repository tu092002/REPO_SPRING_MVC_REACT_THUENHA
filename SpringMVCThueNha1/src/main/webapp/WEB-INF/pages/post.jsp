<%-- 
    Document   : post
    Created on : Aug 15, 2023, 11:40:49 AM
    Author     : nitro 5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>post</title>
</head>
<h1 class="text-center text-danger">Quản lí Post</h1>
<p class="text-center text-danger">${message}</p>


<table class="table">

    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th></th>
                <th>Tên bài post</th>
                <th>Gía</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${posts}" var="p">
                <tr>
                    <td>
                        <img src="${p.imgPost}" alt="${p.titlePost}" width="120" />
                    </td>
                    <td>${p.idPost}</td>
                    <td>${p.titlePost}</td>
                    <td>${p.addressPost} </td>
                    <td>
            <se:authorize access="hasRole('ROLE_ADMIN')">
                <c:url value="/api/post/${p.idPost}/status" var="api" />
                <button class="btn btn-info" onclick="updateStatusPostJS('${apiDel}')">Duyệt Bài</button>


                <c:url value="/api/post/${p.idPost}" var="apiDel" />
                <button class="btn btn-danger" onclick="deletePost('${apiDel}')">Xóa</button>
            </se:authorize>
            </td>
            </tr>
        </c:forEach>
        </tbody>
        <script src="<c:url value="/js/main.js" />"></script>

    </table>