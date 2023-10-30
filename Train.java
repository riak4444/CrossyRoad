import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Train{
    int x, y, w, h, speed;
    ImageIcon trainImageIcon;
    Image trainImage;
    
    public Train(){
        x = (int)(Math.random() * 700) + -1500;
        y = 308;
        w = 203;
        h = 60;
        speed = (int)(Math.random() * 3) + 5;
        
        trainImageIcon = new ImageIcon(Player.class.getResource("CRtrain.png"));        
        trainImage = trainImageIcon.getImage(); 
    }
    
    public void drawTrain(Graphics g){
        g.drawImage(trainImage, x, y, w, h, null);
    }
    
    public void moveTrain(){
        x += speed;
        if(x > 650){
            speed = (int)(Math.random() * 9) + 6;
            x = (int)(Math.random() * 700) + -1500;
        }
    }
    
    public int getX(){
        return x;
    }
        
    public int getY(){
        return y;
    }
    
    public int getW(){
            return w;
        }
        
    public int getH(){
        return h;
    }
}