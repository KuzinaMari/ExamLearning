package com.java.gui.TestRes;

import com.java.Loaders.QuestionLoader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Created by MortyMerr on 26.05.2017.
 */
public class TestResults extends JFrame {
    private JPanel panel1;
    private JTable results;

    TestResults(ArrayList<Integer> stat){
        String col[] = {"№", "Right Answer", "YourAnswer", "Check"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for(int i = 0; i < stat.size(); i++){
            int correctAnswer = QuestionLoader.getIntance().get(i).getCorrect();
            Object[] data = {i, correctAnswer, stat.get(i), (correctAnswer == stat.get(i))};
            tableModel.addRow(data);
        }
        results = new JTable(tableModel);
        results.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane( results);
        add(scrollPane);

        setSize(500, 450);
        setLocationRelativeTo(null);
    }
}
