/**
 * Created by lotalorafox on 5/29/2017.
 */
import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.lang.*;

public class Scene extends JPanel implements ActionListener{
    Timer timer;
    Font font;
    Font nFont;
    //character sprite counter
    int chscounter =0;
    //character sprite jump
    int chscounterj =0;
    //score
    int icoaunter=0;
    int xcounter=0;
    int ibigcounter=0;
    //action boolean
    boolean jumpstar = false;
    boolean run = true;
    boolean dead = false;
    boolean floorfinish =true;
    boolean createfloor = true;
    boolean colition = false;
    boolean ifStart1 = true;
    //cordenate variables
    //jump
    int xj = 175;
    int yj=385;
    int yd=385;
    //jump up
    boolean up = true;
    //floor
    Image[] f;
    Image[] f2;
    Image[] f3;
    int xf=0 ;
    int xf2=0;
    int xf3=0;
    int xm1=0;
    int xm2=0;
    int xm3=0;
    int yf =440;
    boolean s1=true,s2=true,s3=true;
    boolean crea = true;
    boolean crea2 = true;
    boolean crea3 = true;
    int cl = 0;
    //keyboard
    TAdapter key = new TAdapter();
    //fall
    Rectangle[] fall = new Rectangle[4];
    Rectangle character;

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
        String[] init = {"1","2","3","GO!"};
        //load background
        Image background = this.loadImage("img/fondo-cielo.png");
        Image clouds = this.loadImage("img/fondo-nubes.png");
        //load floorSprites
        Image[] floorSprites = new Image[4];
        floorSprites[0] = this.loadImage("img/piso-inicio.png");
        floorSprites[1] = this.loadImage("img/piso-01.png");
        floorSprites[2] = this.loadImage("img/piso-02.png");
        floorSprites[3] = this.loadImage("img/piso-final.png");
        //floor to paint

        //draw backgorud
        g.drawImage(background,0,0,null);
        g.drawImage(clouds,0,0,null);
        //draw score
        String score = Integer.toString(xcounter);
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("font/grobold.ttf"));
            Font currentFont = g.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 4.6F);
            g.setFont(newFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        //g.setFont(font);

        g.drawString("Score: "+score,950,50);
        //load character
        Image[] chSprites = new Image[11];
        Image[] chSpritesJump = new Image[11];
        Image[] chSpritesDead = new Image[11];
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
        //load character sprites dead
        for (int i=1;i<10;i++){
            String number = Integer.toString(i);
            chSpritesDead[i] = this.loadImage("img/templerun/Dead__00" +number +".png");
        }
        //overcicle jump
        chSpritesDead[10] = this.loadImage("img/templerun/Jump__00" +"9" +".png");
        //floor----------------------------------------------------------------------------------------------
        Rectangle r;
        //create aleatory floor
        //platform1
        if(crea) {
            f = this.createfloor(floorSprites);
            if(s1) {
                xf = xm1;
                r = new Rectangle(xf+(f.length*150),yf+80,170,200);
                fall[0] = r;
                s1=false;
            }else{
                xm1=xf3+250;
                //r = new Rectangle(xf3+25,yf+80,170,200);
                //fall[0] = r;
            }

            crea = false;
        }
        //g.drawRect(xf3+25,yf+80,170,200);
        xf=xm1;
        for (int j =0;j<f.length;j++){
            g.drawImage(f[j],xf,yf,150,250,null);
            xf+=150;
        }
        xm1-=20;
        //platform2
        if(crea2){
            f2 = this.createfloor(floorSprites);
            crea2 = false;
            xm2 =xf+250;
        }
        r = new Rectangle(xf+25,yf+80,170,200);
        fall[1] = r;
        //g.drawRect(xf+25,yf+80,170,200);
        xf2=xm2;
            for (int j =0;j<f2.length;j++){
                g.drawImage(f2[j],xf2,yf,150,250,null);
                xf2+=150;
            }
        xm2-=20;
        //platform3
        if(crea3){
            f3 = this.createfloor(floorSprites);
            xm3 =xf2+250;
            crea3 = false;
        }
        r = new Rectangle(xf2+25,yf+80,170,200);
        fall[2] = r;
        //g.drawRect(xf2+25,yf+80,170,200);
        System.out.println("x: " +(xf2+25)+ " y: "+(yf+80)+" -170"+"-200");
        xf3=xm3;
        for (int j =0;j<f3.length;j++){
            g.drawImage(f3[j],xf3,yf,150,250,null);
            xf3+=150;
        }
        r = new Rectangle(xf3+25,yf+80,170,200);
        fall[0] = r;
        //g.drawRect(xf3+25,yf+80,170,200);
        xm3-=20;
        if(xf<0){
            crea=true;
        }else if(xf2<0){
            crea2=true;
        }else if(xf3<0){
            crea3=true;
        }

        //character---------------------------------------------------------------------------------------
        //draw character and character movement
        if(!dead) {
            jumpstar = key.jump;
        }
        if(jumpstar){
            g.drawImage(chSpritesJump[chscounter],xj,yj,111,170,null);
            r = new Rectangle(xj,yj,101,160);
            character =r;
        }else if(run){
            g.drawImage(chSprites[chscounter],175,385,111,170,null);
            r = new Rectangle(175,385,101,160);
            character =r;
        }else if(dead){
            g.drawImage(chSpritesDead[chscounter],175,yd,111,170,null);
            yd+=10;
            if(chscounter>8){
                Font currentFont = g.getFont();
                Font newFont = currentFont.deriveFont(currentFont.getSize() * 3F);
                g.setColor(Color.red);
                g.setFont(newFont);
                g.drawString("You are dead!!",150,300);
                timer.stop();
            }
        }
        colition =true;
    }


    //create floor
    public Image[] createfloor(Image[] floorSprites){
        //create floor aleatory leg and movement
        Random rand = new Random();
        int leg = rand.nextInt((10 - 3) + 1) + 3;
        int paint;
        Image[] floorpaint = new Image[leg];

            floorpaint[0] = floorSprites[0];
            floorpaint[leg - 1] = floorSprites[3];
            for (int i = 1; i < leg - 1; i++) {
                paint = rand.nextInt((2 - 1) + 1) + 1;
                floorpaint[i] = floorSprites[paint];
            }
        return floorpaint;
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
        //colitions
        if(colition){
            checkCollisions();
        }
        repaint();
    }


    public void checkCollisions() {
        for (int i = 0; i < 3; i++) {
            if (character.intersects(fall[i])) {
                System.out.println(i);
                run = false;
                dead = true;
                System.out.println("dead");
            }
        }

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
