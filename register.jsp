<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
<h2>Register</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/register">
    <label>Full Name</label><br>
    <input type="text" name="fullName" required><br><br>

    <label>Email</label><br>
    <input type="email" name="email" required><br><br>

    <label>Username</label><br>
    <input type="text" name="username" required><br><br>

    <label>Password</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Create Account</button>
</form>

<p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a></p>
</body>
</html>
