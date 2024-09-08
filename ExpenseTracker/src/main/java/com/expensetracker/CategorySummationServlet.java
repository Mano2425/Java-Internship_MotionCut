package com.expensetracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/categorySummary")
public class CategorySummationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        Map<String, Double> categorySummation = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("D:/eclipse/ExpenseTracker/expenses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[3].equals(username)) {
                    String category = data[1];
                    double amount = Double.parseDouble(data[2]);
                    categorySummation.put(category, categorySummation.getOrDefault(category, 0.0) + amount);
                }
            }
        }

        request.setAttribute("categorySummation", categorySummation);
        request.getRequestDispatcher("categorySummary.jsp").forward(request, response);
    }
}


