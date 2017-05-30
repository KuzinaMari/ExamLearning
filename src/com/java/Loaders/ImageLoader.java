package com.java.Loaders;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by MortyMerr on 25.05.2017.
 */
public class ImageLoader {
    private static ImageLoader instance;
    private ImageLoader(){
        loadImages();
    }

    private ArrayList<Image> images;

    private void loadImages(){
        images = new ArrayList<>();
        Integer counter = 0;
        File tmp;
        while((tmp = new File("src/images/image" + counter.toString() + ".jpg")).exists()){
            try {
                images.add(ImageIO.read(tmp));
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }

    public static ImageLoader getInstanse(){
        if(instance == null){
            instance = new ImageLoader();
        }
        return instance;
    }

    public Image getImage(int index){
        return images.get(index);
    }

    public int getSize(){
        return images.size();
    }
}
