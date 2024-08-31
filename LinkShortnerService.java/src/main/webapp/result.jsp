<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Link Shortener Result</title>
</head>
<body>
    <h2>Result</h2>
    <p>Your Shortened URL: <%= request.getAttribute("shortUrl") != null ? request.getAttribute("shortUrl") : "N/A" %></p>
    <p>Your Original URL: <%= request.getAttribute("longUrl") != null ? request.getAttribute("longUrl") : "N/A" %></p>
    <a href="index.jsp">Go Back</a>
</body>
</html>
