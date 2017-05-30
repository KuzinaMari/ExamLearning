package com.java.gui.TestRes;

import com.java.Loaders.QuestionLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by MortyMerr on 26.05.2017.
 */
public class Test extends JFrame {
    private ButtonGroup group;
    private ArrayList<JRadioButton> buttonAnswers;
    private int counter = 0;
    private JTextArea question = new JTextArea();
    private JPanel panel1;
    private JButton accept = new JButton("Next");
    private ArrayList<Integer> stat = new ArrayList<>();

    private void setQuestion() {
        question.setText(QuestionLoader.getIntance().get(counter).getQst_());
        group = new ButtonGroup();
        ArrayList<String> answers = QuestionLoader.getIntance().get(counter).getAnswers_();
        for (int i = 0; i < answers.size(); i++) {
            buttonAnswers.get(i).setText(answers.get(i));
        }
    }

    public Test() {
        setTitle("Тест");
        question.setEditable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        buttonAnswers = new ArrayList<>(4);
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            JRadioButton button = new JRadioButton();
            buttonAnswers.add(button);
            add(button, c);
            group.add(button);
        }
        setQuestion();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 300;      //make this component tall
        c.gridwidth = 7;
        c.gridy = 1;
        add(question, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;      //make this component tall
        c.gridwidth = 6;
        c.gridy = 2;
        add(accept, c);

        setSize(500, 450);
        setLocationRelativeTo(null);

        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < buttonAnswers.size(); i++) {
                    if (buttonAnswers.get(i).isSelected()) {
                        stat.add(i);
                    }
                }
                if (counter < QuestionLoader.getIntance().getSize() - 1) {
                    counter++;
                    setQuestion();
                } else {
                    TestResults form = new TestResults(stat);
                    form.setVisible(true);
                    dispose();
                }
            }
        });
    }
}
