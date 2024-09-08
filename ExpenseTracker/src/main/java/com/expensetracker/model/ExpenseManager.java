package com.expensetracker.model;


import java.io.*;
import java.util.*;

public class ExpenseManager {
    private static final String FILE_NAME = "D:/eclipse/ExpenseTracker/expenses.txt";

 \
    public void addExpense(Expense expense) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(expense.getDate() + "," + expense.getCategory() + "," + expense.getAmount() + "," + expense.getUsername());
            writer.newLine();
        }
    }

    public List<Expense> getExpensesForUser(String username) throws IOException {
        List<Expense> userExpenses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[3].equals(username)) {
                    userExpenses.add(new Expense(data[0], data[1], Double.parseDouble(data[2]), data[3]));
                }
            }
        }

        return userExpenses;
    }


    public Map<String, Double> getCategorySummation(String username) throws IOException {
        Map<String, Double> categorySummation = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
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

        return categorySummation;
    }

 
    public void deleteExpense(String username, String date, String category) throws IOException {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("tempExpenses.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (!(data[0].equals(date) && data[1].equals(category) && data[3].equals(username))) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }


        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
        }
    }
}

