/**
 * Created by lotalorafox on 5/29/2017.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


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
    boolean floorfinish =true;
    boolean createfloor = true;
    //cordenate variables
    //jump
    int xj = 175;
    int yj=385;
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
        //draw floor on time
        /* erase the header variables and stay constands
        xf = 0;
        yf = 440;
        for (int j=0;j<4;j++){
            g.drawImage(floorSprites[j],xf,yf,150,250,null);
            xf+=150;
        }*/
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

        //floor----------------------------------------------------------------------------------------------
        //create aleatory floors
        if(crea) {
            f = this.createfloor(floorSprites);
            if(s1) {
                xf = xm1;
                s1=false;
            }else{
                xm1=xf3+250;
            }

            crea = false;
        }
        xf=xm1;
        //platform1
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
        xf3=xm3;
        for (int j =0;j<f3.length;j++){
            g.drawImage(f3[j],xf3,yf,150,250,null);
            xf3+=150;
        }
        xm3-=20;
        System.out.println("1: "+xf+" 2:" +xf2+" 3:"+xf3);



        if(xf<0){
            crea=true;
            System.out.println("1: " +crea);
        }else if(xf2<0){
            crea2=true;

            System.out.println("2: "+crea2);
        }else if(xf3<0){
            crea3=true;
            System.out.println("3: " +crea3);
        }




       




        //character---------------------------------------------------------------------------------------
        //draw character and character movement
        jumpstar=key.jump;
        if(jumpstar){
            g.drawImage(chSpritesJump[chscounter],xj,yj,111,170,null);
        }else{
            g.drawImage(chSprites[chscounter],175,385,111,170,null);
        }



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
