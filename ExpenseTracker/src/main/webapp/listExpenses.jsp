<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Expenses</title>
    <style>
        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2 style="text-align:center;">Expense List for ${username}</h2>

<c:if test="${not empty userExpenses}">
    <table>
        <thead>
            <tr>
                <th>Date</th>
                <th>Category</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="expense" items="${userExpenses}">
                <tr>
                    <td>${expense.date}</td>
                    <td>${expense.category}</td>
                    <td>${expense.amount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty userExpenses}">
    <p style="text-align:center;">No expenses found for the current user.</p>
</c:if>

    <p><a href="categorySummary.jsp">View category-wise summary</a></p>
<a href="addExpense.jsp" style="display: block; text-align: center;">Add New Expense</a>

</body>
</html>
