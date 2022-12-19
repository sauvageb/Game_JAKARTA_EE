<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Game Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

    <div class="row">
        <div class="col-8 offset-2">
            <h1>Game Détail</h1>
            <div class="card mt-3 text-black">
                <img src="https://pic.clubic.com/v1/images/1827867/raw.webp?hash=4206f879bacdefcb832b70a7c083aac820e990c1">
                <div class="card-body">
                    <p class="card-title ws-bold">${game.name}</p>
                    <p class="card-text"> ${game.description}</p>
                    <form class="text-end m-0" method="post" action="${pageContext.request.contextPath}/games/delete">
                        <input type="hidden" value="${game.id}" name="idGame">
                        <button class="btn btn-danger">Delete</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

</body>
</html>
