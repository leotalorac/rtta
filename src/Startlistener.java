/**
 * Created by lotalorafox on 5/29/2017.
 */
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.event.*;
public class Startlistener implements ActionListener{
    JFrame frame;

    public Startlistener(JFrame f){
        frame =f;
    }


    @Override
    public void actionPerformed(ActionEvent event){
        frame.removeAll();
        frame = new Screen(2);
    }

}
