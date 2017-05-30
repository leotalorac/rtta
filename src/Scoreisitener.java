import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.io.BufferedInputStream;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by lotalorafox on 5/30/2017.
 */
public class Scoreisitener implements ActionListener {

    String name;
    String score;
    File f;
    JTextField t;

    public Scoreisitener (JTextField jt){
        f = new File("data/scores.txt");
        t = jt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
