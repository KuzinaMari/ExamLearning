package com.java.gui;

import com.java.Loaders.ExamLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by MortyMerr on 26.05.2017.
 */
public class Exam extends JFrame {
    private TextArea question = new TextArea("", 3 , 100 , TextArea.SCROLLBARS_VERTICAL_ONLY),
            answer = new TextArea(),
            correctAnswer = new TextArea("", 3 , 80 , TextArea.SCROLLBARS_VERTICAL_ONLY);
    private JButton ok = new JButton("Проверить");

    private void setQuestion() {
        Random r = new Random();
        int qstIndex = r.nextInt(ExamLoader.getIntance().getSize());
        question.setText(ExamLoader.getIntance().getQuestion(qstIndex));
        correctAnswer.setText(ExamLoader.getIntance().getAnswer(qstIndex));
    }

    Exam() {
        setQuestion();
        setTitle("Экзамен");
        question.setEditable(false);
        correctAnswer.setEditable(false);
        correctAnswer.setVisible(false);
//        question.setLineWrap(true);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.ipady = 50;      //make this component tall
        c.gridwidth = 7;
        add(question, c);

        c.ipady = 20;      //make this component tall
        c.gridy = 1;
        add(answer, c);

        c.gridy = 2;
        add(correctAnswer, c);

        c.gridy = 3;
        add(ok, c);

        setSize(500, 500);
        setLocationRelativeTo(null);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer.setEditable(false);
                correctAnswer.setVisible(true);
                setSize(500, 700);
                revalidate();
                repaint();
            }
        });
    }
}
