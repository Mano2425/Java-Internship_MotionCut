<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Link Shortener</title>
</head>
<body>
    <h2>Link Shortener</h2>
    <form action="shorten" method="post">
        <label for="longUrl">Enter URL to shorten:</label><br>
        <input type="text" id="longUrl" name="longUrl"><br>
        <input type="submit" value="Shorten URL">
    </form>
    <br>
    <h2>Expand Shortened URL</h2>
    <form action="expand" method="post">
        <label for="shortUrl">Enter shortened URL:</label><br>
        <input type="text" id="shortUrl" name="shortUrl"><br>
        <input type="submit" value="Expand URL">
    </form>
</body>
</html>
