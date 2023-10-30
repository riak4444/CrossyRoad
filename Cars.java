import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Cars{
    private int x1, x2, x3, nextCarX1, nextCarX2, nextCarX3, y1, y2, y3, w, h, speed1, speed2, speed3;
    ImageIcon carImageIcon1, carImageIcon2, carImageIcon3, carImageIcon4, carImageIcon5, carImageIcon6, carImageIcon7, carImageIcon8, carImageIcon9;
    Image carImage1, carImage2, carImage3, carImage4, carImage5, carImage6, carImage7, carImage8, carImage9;
    
    public Cars(){
        x1 = (int)(Math.random() * 950) + -400;
        x2 = (int)(Math.random() * 950) + -400;
        x3 = (int)(Math.random() * 950) + 100;
        nextCarX1 = x1 + 154 + ((int)(Math.random() * 100) + 300);
        nextCarX2 = x2 + 154 + ((int)(Math.random() * 100) + 300);
        nextCarX3 = x3 - 154 - ((int)(Math.random() * 100) + 300);
        y1 = 458;
        y2= 533;
        y3 = 608;
        w = 154;
        h = 60;
        speed1 = (int)(Math.random() * 1) + 3;
        speed2 = (int)(Math.random() * 1) + 1;
        speed3 = (int)(Math.random() * 1) + 2;
        
        carImageIcon1 = new ImageIcon(Player.class.getResource("CRcar_green_right.png"));        
        carImage1 = carImageIcon1.getImage();
        carImageIcon2 = new ImageIcon(Player.class.getResource("CRcar_pink_right.png"));        
        carImage2 = carImageIcon2.getImage();
        carImageIcon3 = new ImageIcon(Player.class.getResource("CRcar_purple_right.png"));        
        carImage3 = carImageIcon3.getImage();
        carImageIcon4 = new ImageIcon(Player.class.getResource("CRcar_white_right.png"));        
        carImage4 = carImageIcon4.getImage();
        carImageIcon5 = new ImageIcon(Player.class.getResource("CRcar_yellow_right.png"));        
        carImage5 = carImageIcon5.getImage();
        
        carImageIcon6 = new ImageIcon(Player.class.getResource("CRcar_red_left.png"));        
        carImage6 = carImageIcon6.getImage();
        carImageIcon7 = new ImageIcon(Player.class.getResource("CRcar_pink_left.png"));        
        carImage7 = carImageIcon7.getImage();
        carImageIcon8 = new ImageIcon(Player.class.getResource("CRcar_green_left.png"));        
        carImage8 = carImageIcon8.getImage();
    }
    
    public void drawCars(Graphics g){
        g.drawImage(carImage4, x1, y1, w, h, null);
        g. drawImage(carImage3, x2, y2, w, h, null);
        g.drawImage(carImage6, x3, y3, w, h, null);
        
        g.drawImage(carImage5, nextCarX1, y1, w, h, null);
        g.drawImage(carImage2, nextCarX2, y2, w, h, null);
        g.drawImage(carImage8, nextCarX3, y3, w, h, null);
    }
    
    public void moveCars(){
        x1 += speed1;
        x2 += speed2;
        x3 -= speed3;
        nextCarX1 += speed1;
        nextCarX2 += speed2;
        nextCarX3 -= speed3;
        
        if(x1 > 804){
            x1 = -250;
        }
        if(nextCarX1 > 804){
            nextCarX1 = -250;
        }
        if(x2 > 804){
            x2 = -250;
        }
        if(nextCarX2 > 804){
            nextCarX2 = -250;
        }
        if(x3 < -154){
            x3 = 750;
        }
        if(nextCarX3 < -154){
            nextCarX3 = 750;
        }
    }
    
    public int getX1(){
        return x1;
    }    
    public int getX2(){
        return x2;
    }    
    public int getX3(){
        return x3;
    }    
    public int getNextCarX1(){
        return nextCarX1;
    }    
    public int getNextCarX2(){
        return nextCarX2;
    }    
    public int getNextCarX3(){
        return nextCarX3;
    }
        
    public int getY1(){
        return y1;
    }
    public int getY2(){
        return y2;
    }
    public int getY3(){
        return y3;
    }
    
    public int getW(){
        return w;
    }
        
    public int getH(){
        return h;
    }
}