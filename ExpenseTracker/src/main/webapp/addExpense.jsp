<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Tracker</title>
</head>
<body>
<form action="addExpense" method="post">
    <input type="date" name="date" required />
    <input type="text" name="category" placeholder="Category" required />
    <input type="number" step="0.01" name="amount" placeholder="Amount" required />
    <input type="submit" value="Add Expense" />
</form>

</body>
</html>