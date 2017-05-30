/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import javax.swing.*;


public class Main {
    public static void main(String [] args){
        Screen frame = new Screen(2);
        frame.setTitle("Running through the Ages");
        frame.setSize(1280,720);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
