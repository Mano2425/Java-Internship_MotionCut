package com.expensetracker;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expensetracker.model.Expense;

@WebServlet("/listExpenses")
public class ListExpensesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        List<Expense> userExpenses = new ArrayList<>();

      
        try (BufferedReader reader = new BufferedReader(new FileReader("D:/eclipse/ExpenseTracker/expenses.txt"))) {
            String line;
            System.out.println("file is Reading");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[3].equals(username)) {
                    userExpenses.add(new Expense(data[0], data[1], Double.parseDouble(data[2]), data[3]));
                }
                
            }
            System.out.println(userExpenses);
        }

        request.setAttribute("userExpenses", userExpenses);
        request.getRequestDispatcher("listExpenses.jsp").forward(request, response);
    }
}

