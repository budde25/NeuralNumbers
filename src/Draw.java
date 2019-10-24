import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;

public class Draw extends PApplet {
    @Override
    public void settings() {
        size(560, 560);
    }

    public void setup() {
        background(255);
    }

    public void draw() {
        strokeWeight(40);
        stroke(0);
        if (mousePressed){
            line(mouseX,mouseY,pmouseX,pmouseY);
        }

    }

    @Override
    public void exit() {
        parseDrawing();
    }

    public void parseDrawing() {
        loadPixels();
        int[] img = pixels;
        int[][] pix = new int[560][560];

        for (int i = 0; i < img.length; i++){
            pix[i/pix.length][i%pix.length] = img[i];
        }

        String num = "0,";

        for (int i = 0; i < 28; i++){
            for(int j =0; j< 28; j++) {
                boolean isBlack = false;
                for (int k = 0; k < 20; k++){
                    for (int l = 0; l < 20; l++){

                        if (pix[(i * 20)+k][(j * 20) + l] != -1)
                            isBlack =true;
                    }
                }
                if (isBlack)
                    num += "255,";
                else
                    num += "0,";

            }
        }
        Digit digit = new Digit(num);
        Display d = new Display(digit);
        Main.in(digit);

    }
}
