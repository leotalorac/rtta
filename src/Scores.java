import javax.swing.*;
import java.awt.*;

/**
 * Created by lotalorafox on 5/30/2017.
 */


public class Scores extends JPanel {
    public Scores(){

    }
    @Override
    protected void paintComponent(Graphics g){
        Image background = this.loadImage("img/fondo-cielo.png");
        g.drawImage(background,0,0,null);




    }


    //load imaga function
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}

