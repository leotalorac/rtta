/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Screen  extends JFrame implements ActionListener{
    private Scene game = new Scene();
    private Menu menu = new Menu(this);
    public boolean b =false ;

    public Screen(int i){
        if(i==1){
            //this.removeAll();
            this.add(menu);
        }else{
            this.add(game);
        }
        setResizable(false);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(b){
            //this.removeAll();
            this.add(menu);
        }else{
            this.add(game);
        }
    }
}
