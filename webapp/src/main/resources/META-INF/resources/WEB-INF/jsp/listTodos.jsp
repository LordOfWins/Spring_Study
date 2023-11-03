<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="webjars\bootstrap\5.3.0\css\bootstrap.min.css"
          rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<div id="container">
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="todos" type="com.springstudy.webapp.todo.Todo"--%>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.isDone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add" class="btn btn-success">Add Todo</a>
</div>
<script src="webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.4\jquery.min.js"></script>
</body>
</html>