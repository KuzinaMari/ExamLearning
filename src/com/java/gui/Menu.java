package com.java.gui;

import com.java.gui.TestRes.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MortyMerr on 25.05.2017.
 */
public class Menu extends JFrame{
    private JButton конспектButton;
    private JButton тестButton;
    private JButton экзаменButton;
    private JPanel main;

    public Menu() {
        super();
        setTitle("Меню");
        setContentPane(main);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        конспектButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conspect form = new Conspect();
                form.setVisible(true);
            }
        });
        тестButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Test form = new Test();
                form.setVisible(true);
            }
        });
        экзаменButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exam form = new Exam();
                form.setVisible(true);
            }
        });
    }
}
