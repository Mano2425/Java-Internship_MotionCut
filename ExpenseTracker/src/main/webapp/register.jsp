<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Register</h1>

    <c:if test="${param.error != null}">
        <p style="color: red;">Registration failed. Please try again.</p>
    </c:if>

    <form action="register" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Register">
    </form>

    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>
