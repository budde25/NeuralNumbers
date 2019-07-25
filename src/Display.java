import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class Display extends JFrame {
    private Digit digit;

    public Display(Digit digit){
        this.digit = digit;

        setSize(new Dimension(new Dimension(560, 560)));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void paint(java.awt.Graphics g) {
        int scale = 20;

        for (int i = 0; i < 784; i++) {
            int number = 255 - turnBlack(digit.getValues(i));
            g.setColor(new Color(number, number, number));
            g.fillRect( (i % 28) * scale, i == 0 ? 0 : (i / 28) * scale, scale, scale);
        }

        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        g.setColor(Color.magenta);
        g.drawString("" + digit.getNumber(), 10, 60);
    }

    private int turnBlack(int number) {
        if (number > 0) return 255;
        else return 0;
    }
}
