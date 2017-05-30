/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Scene extends JPanel implements ActionListener{
    Timer timer;
    //character sprite counter
    int chscounter =0;
    //character sprite jump
    int chscounterj =0;
    //score
    int xcounter=0;
    //action boolean
    boolean jumpstar = false;
    //cordenate variables
    //jump
    int xj = 175;
    int yj=385;
    boolean up = true;
    int xf;
    int yf;
    //keyboard
    TAdapter key = new TAdapter();


    public Scene(){
        //key input

        addKeyListener(key);
        setFocusable(true);
        //init timer
        timer = new Timer(25, (ActionListener) this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //inicialice cordenate variables

        //floor
        xf = 0;
        yf = 440;
        //jump

        //load background
        Image background = this.loadImage("img/fondo-cielo.png");
        Image clouds = this.loadImage("img/fondo-nubes.png");
        //load floorSprites
        Image[] floorSprites = new Image[4];
        floorSprites[0] = this.loadImage("img/piso-inicio.png");
        floorSprites[1] = this.loadImage("img/piso-01.png");
        floorSprites[2] = this.loadImage("img/piso-02.png");
        floorSprites[3] = this.loadImage("img/piso-final.png");
        //draw backgorud
        g.drawImage(background,0,0,null);
        g.drawImage(clouds,0,0,null);
        //draw floor
        for (int j=0;j<4;j++){
            g.drawImage(floorSprites[j],xf,yf,150,250,null);
            xf+=150;
        }
        //load character
        Image[] chSprites = new Image[11];
        Image[] chSpritesJump = new Image[11];
        chSprites[0] = this.loadImage("img/templerun/Idle__000.png");
        //load character sprites run
        for (int i=1;i<10;i++){
            String number = Integer.toString(i-1);
            chSprites[i] = this.loadImage("img/templerun/Run__00" +number +".png");
        }
        //overcycle
        chSprites[10] = this.loadImage("img/templerun/Run__009.png");
        //load character sprites jump
        for (int i=1;i<10;i++){
            String number = Integer.toString(i);
            chSpritesJump[i] = this.loadImage("img/templerun/Jump__00" +number +".png");
        }
        //overcicle jump
        chSpritesJump[10] = this.loadImage("img/templerun/Jump__00" +"9" +".png");

        //draw character
        jumpstar=key.jump;
        if(jumpstar){
            g.drawImage(chSpritesJump[chscounter],xj,yj,111,170,null);
        }else{
            g.drawImage(chSprites[chscounter],175,385,111,170,null);
        }



    }

    //load a image function
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //character run

        if(xcounter%4==0){
            if(jumpstar){
                if(xcounter%4==0) {
                    if (up) {
                        yj = yj - 40;
                        if (yj < 250) {
                            up = false;
                        }
                    } else {
                        yj += 40;
                        if (yj > 385) {
                            up = true;
                            jumpstar =false;
                            key.jump=jumpstar;
                        }
                    }
                    chscounter++;
                    if(chscounter >9){
                        chscounter=1;
                    }else{
                        chscounter++;
                    }
                }
            }else{
                chscounter++;
                if(chscounter >9){
                    chscounter=1;
                }else{
                    chscounter++;
                }
            }

        }
        //big counter
            xcounter++;
        repaint();
    }

}

class TAdapter extends KeyAdapter {

    public boolean jump;
    @Override
    public void keyReleased(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == 32){
            jump=true;
        }
    }


}
