<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="row">

        <div class="col-8 offset-2">
            <h1>Edit game</h1>

            <c:choose>
                <c:when test="${gameNotFound}">
                    <div class="alert alert-danger" role="alert">
                        Game not found
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="card mt-3 text-black">
                        <img src="https://pic.clubic.com/v1/images/1827867/raw.webp?hash=4206f879bacdefcb832b70a7c083aac820e990c1">
                        <div class="card-body">

                            <form method="post" action="/games/edit?id=${gameEdit.id}">
                                <div class="mb-3">
                                    <label class="form-label" for="gameName">Name :</label>
                                    <input id="gameName" class="form-control" type="text" name="gameName"
                                           value="${gameEdit.name}">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="gameDescription">Description :</label>
                                    <textarea id="gameDescription" class="form-control"
                                              name="gameDescription">${gameEdit.description}</textarea>
                                </div>
                                <div class="text-end">
                                    <button class="btn btn-success">Edit</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </c:otherwise>

            </c:choose>
        </div>
    </div>
</div>

</body>
</html>
