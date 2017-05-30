package com.java.gui;

import com.java.Loaders.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MortyMerr on 25.05.2017.
 */
public class Conspect extends JFrame {
    private JPanel panel1;
    private JButton right = new JButton(">"),
            left = new JButton("<");
    private int imgIndex = 0;
    private JImage img;
    Conspect() {
        setTitle("Конспект");
        setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        img = new JImage(ImageLoader.getInstanse().getImage(imgIndex), (int)(screenSize.width), (int)(screenSize.height));
        add(right, BorderLayout.EAST);//Компонент располагается вдоль правой границы окна. В остальном его расположение аналогично западному компоненту
        add(left, BorderLayout.WEST);//Компонент располагается вдоль левой границы окна и растягивается на всю его высоту; при этом учитываются размеры северных и южных компонентов, имеющих приоритет
        add(img, BorderLayout.CENTER); //Компонент помещается в центр окна, занимая максимально возможное пространство
        setLocationRelativeTo(null);
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imgIndex < ImageLoader.getInstanse().getSize() - 1) {
                    imgIndex++;
                    img.setImage(ImageLoader.getInstanse().getImage(imgIndex));
                    repaint();
                }
            }
        });
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imgIndex > 0) {
                    imgIndex--;
                    img.setImage(ImageLoader.getInstanse().getImage(imgIndex));
                    repaint();
                }
            }
        });
    }
}
