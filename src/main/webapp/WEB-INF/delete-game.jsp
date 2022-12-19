<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<form action="/games/delete" method="post">
    <label for="gameId">Game Id</label>
    <input id="gameId" type="number" name="idGame">
    <button>Delete</button>
</form>

</body>
</html>
