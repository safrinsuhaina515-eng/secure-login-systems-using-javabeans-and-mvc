<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h2>Welcome to the page</h2>
<p>Hi ${sessionScope.user.fullName}, you are now logged in.</p>
<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>
</body>
</html>
