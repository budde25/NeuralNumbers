import javax.swing.*;

public class Gui extends JFrame{
    private JPanel Main;
    private JButton startTraining;
    private JCheckBox shuffle;
    private JButton stopTraining;
    private JProgressBar trainingProgress;

    public Gui() {
        JFrame jFrame = new JFrame("Neural Numbers");
        jFrame.setContentPane(Main);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui();
            }
        });
    }
}
