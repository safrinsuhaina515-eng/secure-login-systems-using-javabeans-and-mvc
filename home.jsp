<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h2>Welcome to the server</h2>
<p>Hello, ${sessionScope.user.fullName}.</p>
<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>
</body>
</html>
