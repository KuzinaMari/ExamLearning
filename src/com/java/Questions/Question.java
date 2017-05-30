package com.java.Questions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MortyMerr on 25.05.2017.
 */
public class Question {
    private String qst_;
    private ArrayList<String> answers_;
    private int correct;

    public String getQst_() {
        return qst_;
    }

    public ArrayList<String> getAnswers_() {
        return answers_;
    }

    public int getCorrect(){
        return correct;
    }

    public Question(){
    }

    public Question(String qst){
        String[] splitResult = qst.split("[/]");
        qst_ = splitResult[0];
        answers_ =  new ArrayList<>(Arrays.asList(splitResult));
        answers_.remove(0);
        correct = Integer.valueOf(answers_.get(answers_.size() - 1));
        answers_.remove(answers_.size() - 1);
    }
}
