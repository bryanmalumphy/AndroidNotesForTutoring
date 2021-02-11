package com.example.quiztest.Model;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private String title;

    Quiz(ArrayList<Question> questions, String title) {
        this.questions = questions;
        this.title = title;
    }
}
