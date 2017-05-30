package com.java.Loaders;

import com.java.Questions.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by MortyMerr on 25.05.2017.
 */
public class QuestionLoader {
    private static QuestionLoader instance;
    private ArrayList<Question> questions;

    private QuestionLoader() {
        loadQuestion();
    }

    private void loadQuestion() {
        questions = new ArrayList<>();
        try (BufferedReader fin = new BufferedReader(new FileReader(new File("src/questions/qst.txt")))) {
            String tmp;
            while ((tmp = fin.readLine()) != null) {
                questions.add(new Question(tmp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return questions.size();
    }

    public Question get(int index) {
        return questions.get(index);
    }

    public static QuestionLoader getIntance() {
        if (instance == null) {
            instance = new QuestionLoader();
        }
        return instance;
    }
}
