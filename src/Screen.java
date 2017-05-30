/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import javax.swing.*;


public class Screen  extends JFrame{
    public Screen(){
        /*Menu m = new Menu();
        this.add(m);*/
        Scene s = new Scene();
        this.add(s);
        setResizable(false);
        pack();
    }
}
