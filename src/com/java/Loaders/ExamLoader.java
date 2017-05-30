package com.java.Loaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by MortyMerr on 30.05.2017.
 */
public class ExamLoader {
    private static ExamLoader instance;
    String[] questions, answers;

    private  ExamLoader() {
        loadQuestion();
    }

    private void loadQuestion() {
        try (BufferedReader fin = new BufferedReader(new FileReader(new File("src/examquestions/quest.txt")))) {
            String big = "";
            String tmp;
            while ((tmp = fin.readLine()) != null) {
                big += tmp;
            }
            questions = big.split("[|]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader fin = new BufferedReader(new FileReader(new File("src/examanswers/answer.txt")))) {
            String big = "";
            String tmp;
            while ((tmp = fin.readLine()) != null) {
                big += tmp;
            }
            answers = big.split("!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return questions.length;
    }

    public String getQuestion(int index){
        return questions[index];
    }

    public String getAnswer(int index){
        return answers[index];
    }

    public static ExamLoader getIntance() {
        if (instance == null) {
            instance = new ExamLoader();
        }
        return instance;
    }
}
