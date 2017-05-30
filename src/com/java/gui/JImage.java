package com.java.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MortyMerr on 25.05.2017.
 */
class JImage extends JPanel {
    private Image img_;
    private int width, height;

    JImage(Image img, int width, int height) {
        this.width = width;
        this.height = height;
        setImage(img);
    }

    void setImage(Image img){
        img_ = img;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img_, 0, 0, width, height, this);
    }
}
