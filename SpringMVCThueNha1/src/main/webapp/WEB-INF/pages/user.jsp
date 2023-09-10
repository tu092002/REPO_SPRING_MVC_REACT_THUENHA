<%--
    dddDocument   : user
    Created on : Aug 15, 2023, 11:31:28 AM
    Author     : nitro 5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class = "text-center text-danger"> QUAN LI USER </h1>
<c:url value= "/user" var="action"/>
<form:form method = "post" action="${action}" modelAttribute="user" 
           enctype="multipart/form-data">
    <form:hidden path = "idUser" />
    <form:hidden path = "avatar" />
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" path="hoten" id="hoten" placeholder="họ tên" name="hoten" value="${user.hoten}">
        <label for="hoten">hoten</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" path="username" id="username" placeholder="username" name="username" value="${user.username}">
        <label for="username">username</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="password" class="form-control" path="password" id="password" placeholder="password" name="password" value="${user.password}">
        <label for="password">password</label>
    </div>
    <!--    <div class="form-floating mb-3 mt-3">
            <input type="text" class="form-control" path="avatar" id="file" placeholder="avatar" name="avatar" value="${user.avatar}">
            <label for="file">avatar</label>
        </div>-->
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" 
                    path="file" id="file"  />
        <label for="file">Ảnh sản phẩm</label>
        <c:if test="${user.avatar!= null}">
            <img src="${user.avatar}" width="120" />
        </c:if>
    </div>

    <div class="form-floating mb-3 mt-3">
        <input type="" class="form-control" path="address" id="address" placeholder="address" name="address" value="${user.address}">
        <label for="address">address</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <input type="number" class="form-control" path="phone" id="phone" placeholder="phone number" name="phone" value="${user.phone}">
        <label for="phone">phone</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="active" name="active" path="active">
            <c:forEach items="${listActive}" var="c">
                <c:choose>
                    <c:when test="${c == user.active}"><option value="${c}" selected>${c}</option></c:when>
                    <c:otherwise><option value="${c}">${c}</option></c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="active" class="form-label">Select list (ACTIVE):</label>

    </div>


    <div class="form-floating">
        <form:select class="form-select" id="role" name="role" path="role">
            <c:forEach items="${listRole}" var="c">
                <c:choose>
                    <c:when test="${c.equals(user.role)}"><option value="${c}" selected>${c}</option></c:when>
                    <c:otherwise><option value="${c}">${c}</option></c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>


        <label for="role" class="form-label">Select list (ROLE):</label>    
    </div>




    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${user.idUser != null}">Cập nhật sản phẩm</c:when>
                <c:otherwise>Thêm User</c:otherwise>
            </c:choose>
        </button>
    </div>

</form:form>