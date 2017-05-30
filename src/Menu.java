/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;

public class Menu extends JPanel implements ActionListener,MouseListener {
    private Timer timer;
    boolean star =true;

    Screen f;
    Scene game = new Scene();
    public boolean b = true;


    public Menu(JFrame k){
        f = (Screen)k;
        setFocusable(true);
        //init timer
        this.addMouseListener(this);
        timer = new Timer(25, (ActionListener) this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(b){
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
        }}else{
            game.paintComponent(g);
        }
    }

    public Rectangle getBoundsStart(){
        return new Rectangle(580, 480, 131, 55);
    }
    public Rectangle getBoundsScores(){
        return new Rectangle(580, 545, 131, 55);
    }
    public Rectangle getBoundsExit(){
        return new Rectangle(580, 610, 131, 55);
    }

    //load a image function
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point mo = e.getPoint();
        if(getBoundsStart().contains(mo)){
            System.out.println("Start");
            f.removeAll();
            f.add(new Scene());

        }
        if(getBoundsScores().contains(mo)){
            System.out.println("Scores");

        }
        if(getBoundsExit().contains(mo)){
            System.out.println("Exit");
            f.dispose();
        }
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
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


}
