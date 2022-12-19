<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet" type="text/css">
</head>

<body class="text-center">
<%--<c:if test="${loginFail}">--%>
<%--    <div class="alert alert-danger" role="alert">Bad credentials</div>--%>
<%--</c:if>--%>


<p>Nb Login Hit : ${applicationScope['nbLoginHit']}</p>

<div class="login">
    <form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
        <img class="mb-4" src="https://img.icons8.com/laces/64/FFFFFF/user.png"/>
        <h1 class="content_header-title mb-3 font-weight-normal">Please sign in</h1>
        <input class="form-control" type="text" name="username" required autofocus>
        <input class="form-control" type="password" name="password" required>
        <button class="btn btn-lg btn-primary d-block float-end" type="submit">
            <span class="me-4"></span>
            Sign in
            <span class="spinner-grow spinner-grow-sm invisible"></span>
        </button>
    </form>
</div>

<script></script>

</body>
</html>
