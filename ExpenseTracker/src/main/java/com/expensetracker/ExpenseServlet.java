package com.expensetracker;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expensetracker.model.Expense;

@WebServlet("/addExpense")
public class ExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String category = request.getParameter("category");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String username = (String) request.getSession().getAttribute("username");

        Expense expense = new Expense(date, category, amount, username);
        

        File file =new File("D:/eclipse/ExpenseTracker/expenses.txt");
        if(file.canWrite()) {
        	System.out.println("file will writeable");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:/eclipse/ExpenseTracker/expenses.txt", true))) {
        	
        	System.out.println(expense);
        	System.out.println("Absolute path: " + file.getAbsolutePath());
        	
            writer.write(expense.getDate() + "," + expense.getCategory() + "," + expense.getAmount() + "," + expense.getUsername());
            System.out.println("writed Successfully");
            writer.newLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
        response.sendRedirect("listExpenses");
    }
}


