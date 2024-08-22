package com.intern;

import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = getUserAnswer(scanner, options.length);

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was option " + (question.getCorrectAnswer() + 1) + ".\n");
            }
        }

        System.out.println("Quiz Over! Your final score is: " + score + "/" + questions.size());
        scanner.close();
    }

    private int getUserAnswer(Scanner scanner, int numOptions) {
        int userAnswer = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your answer (1-" + numOptions + "): ");
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt() - 1;
                if (userAnswer >= 0 && userAnswer < numOptions) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between 1 and " + numOptions + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        return userAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestion(new Question("Which of the following is a valid declaration of an abstract class in Java?", 
                new String[]{"abstract class MyClass {}", "class MyClass abstract {}", "abstract MyClass class {}", "MyClass abstract class {}"}, 
                0));            
            quiz.addQuestion(new Question("What will be the output of the following code?\n" +
                "int[] arr = {1, 2, 3, 4};\n" +
                "System.out.println(arr[2]);", 
                new String[]{"2", "3", "4", "IndexOutOfBoundsException"}, 
                1));           
            quiz.addQuestion(new Question("Which keyword is used to prevent a method from being overridden?", 
                new String[]{"static", "final", "abstract", "synchronized"}, 
                1));
            quiz.addQuestion(new Question("What is the output of the following code?\n" +
                "String str = \"Hello World\";\n" +
                "System.out.println(str.charAt(1));", 
                new String[]{"H", "e", "l", "o"}, 
                1));
            quiz.addQuestion(new Question("Which of the following is a thread-safe collection in Java?", 
                new String[]{"ArrayList", "HashSet", "Hashtable", "LinkedList"}, 
                2));
        quiz.start();
    }
}

