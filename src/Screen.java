/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import javax.swing.*;


public class Screen  extends JFrame{
    public Screen(int i){
        if(i==1){
            Menu m = new Menu(this);
            this.add(m);
        }else{
            Scene s = new Scene();
            this.add(s);
        }
        setResizable(false);
        pack();
    }
}
