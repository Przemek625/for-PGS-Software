/**
 * Created by Przemek on 2016-04-21.
 */
/**
 * Created by Przemek on 2016-04-20.
 */
import  java.awt.*;
import javax.swing.*;


/**
 * I hope there won't be problem with GUI.
 * On my PC it works just fine. If anny problems
 * occurs, please contact me.
 */

/**
 * This class is just responsible for
 * running the program.
 */

public class MainClass {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                JFrame frame = new JFrame();
                frame.add(new MyPanel());
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("Wizard for PGS Software");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.pack();

            }
        });
    }
}

