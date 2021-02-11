package com.example.quiztest.Model;

import java.util.ArrayList;

public class Question {
    ArrayList<String> answers;
    int correctAnswerIndex;

    Question(ArrayList<String> answers, int correctAnswerIndex) {
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
