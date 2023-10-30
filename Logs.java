import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Logs{
    int x1, x2, y1, y2, w1, w2, h, speed;
    ImageIcon logImageIcon;
    Image logImage;
    
    public Logs(){
        x1 = (int)(Math.random() * 350) + 150;
        x2 = (int)(Math.random() * 350) + 150;
        y1 =75;
        y2 = 150;
        w1 = (int)(Math.random() * 55) + 175;
        w2 = (int)(Math.random() * 55) + 175;
        h = 75;
        speed = 2;
        
        logImageIcon = new ImageIcon(Player.class.getResource("CRlog.png"));        
        logImage = logImageIcon.getImage();
    }
    
    public void drawLogs(Graphics g){
        g.drawImage(logImage, x1, y1, w1, h, null);
        g.drawImage(logImage, x2, y2, w2, h, null);
    }
    
    public void moveLogs(){
        x1 += speed;
        x2 -= speed;
        
        if(x1 > 650){
            x1 = -50-w1;
        }
        if(x2+w2 < 0){
            x2 = 650+w2;
        }    
    }
    
    public int getX1(){
        return x1;
    }
    
    public int getX2(){
        return x2;
    }
    
    public int getY1(){
        return y1;
    }
    
    public int getY2(){
        return y2;
    }
    
    public int getW1(){
        return w1;
    }
    
    public int getW2(){
        return w2;
    }
    
    public int getH(){
        return h;
    }
    
    public int getSpeed(){
        return speed;
    }
}