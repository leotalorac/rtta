/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Menu extends JPanel implements MouseListener {
    private Timer timer;


    public Menu(){

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //background
        Image Start = loadImage("img/splash.png");
        Image[] buttons = new Image[3];
        buttons[0] = this.loadImage("img/boton-start.png");
        buttons[1] = this.loadImage("img/boton-score.png");
        buttons[2] = this.loadImage("img/boton-exit.png");
        //draw background
        g.drawImage(Start,0,0,null);
        //draw burttons
        int x =580;
        int y = 480;
        for (int i =0;i<3;i++){
            g.drawImage(buttons[i],x,y,131,55,null);
            y+=65;
        }

    }

    //load a image function
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
