package com.expensetracker.model;

public class Expense {
    private String date;
    private String category;
    private double amount;
    private String username;

    public Expense(String date, String category, double amount, String username) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.username = username;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Expense [date=" + date + ", category=" + category + ", amount=" + amount + ", username=" + username
				+ "]";
	}

}


