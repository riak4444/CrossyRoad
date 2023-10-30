import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player{
    //instance variables
    private int x, y, w, h; // player coordinates and diameter
    boolean moveRight, moveLeft, moveUp, moveDown;
    ImageIcon playerImageIcon;
    Image playerImage;
    double speed;
      
    //Default Constructor
    public Player(){
        //initializing instance variables
        x = 301;
        y = 683;
        w = 49;
        h = 60;
        speed = 4.0;
        
        playerImageIcon = new ImageIcon(Player.class.getResource("CRchicken_forward.png"));        
        playerImage = playerImageIcon.getImage();
    }
    
    /*public void getPlayersCoordinates() {
        
    }
    
    public void movePlayer(int key){
        
        if(key == 37) {
            
        } else if ( key == 38 ) { 
            
        } 
        else if ( key == 39) {
        
        } 
        else if (key == 40) {
        
        }
        
    }*/
            
    public void movePlayer(Logs log){
        if(detectCollisionLog1(log)){
            x += log.getSpeed();
        }
        
        if(detectCollisionLog2(log)){
            x -= log.getSpeed();
        }
        
        if(moveDown){
            y -= speed;
        }
        else if(moveUp){
            y += speed;
        }
        else if(moveLeft){
            x -= speed;
        }
        else if(moveRight){
            x += speed;
        }
        
        if(x < 0) {
            x = 0;
        }
        if(y < 0) {
            y = 0;
        }
        if(x+w > 650) {
            x = 650-w;
        }
        if(y+h > 750) {
            y = 750-h;
        }
    }
    
    public void keyPressed(KeyEvent e){
        //moving the player
        int key = e.getKeyCode();
        
        if(key == 38){
            moveDown = true;
        }
        else if(key == 39){
            moveRight = true;
        }
        else if(key == 40){
            moveUp = true;
        }
        else if(key == 37){
            moveLeft = true;
        }
    }
    
    public void keyReleased(KeyEvent e){
        //moving the player
        int key = e.getKeyCode();
        
        if(key == 38){
            moveDown= false;
        }
        else if(key == 39){
            moveRight = false;
        }
        else if(key == 40){
            moveUp = false;
        }
        else if(key == 37){
            moveLeft = false;
        }
    }
    
    //All your UI drawing goes in here
    public void drawPlayer(Graphics g){
        // making the player
        g.drawImage(playerImage, x, y, w, h, null);
    }
    
    public int getCenterX(){
        return x + (w/2);
    }
    
    public int getCenterY(){
        return y + (h/2);
    }
    
    public boolean detectCollisionTrain(Train train){
        int tX = train.getX();
        int tY = train.getY();
        int tW = train.getW();
        int tH = train.getH();
        boolean collide = false;
        
        if(x+w > tX && x < tX+tW && y < tY+tH && y+h > tY){
            return true;
        }
        
        return collide;
    }
    
    public boolean detectCollisionCar1(Cars car){
        int c1X = car.getX1();
        int c1Y = car.getY1();
        int c1W = car.getW();
        int c1H = car.getH();
        boolean collide = false;
        
        if(x+w > c1X && x < c1X+c1W && y < c1Y+c1H && y+h > c1Y){
            return true;
        }
        
        return collide;
    }
    
    public boolean detectCollisionCar2(Cars car){
        int c2X = car.getX2();
        int c2Y = car.getY2();
        int c2W = car.getW();
        int c2H = car.getH();
        boolean collide = false;
        
        if(x+w > c2X && x < c2X+c2W && y < c2Y+c2H && y+h > c2Y){
            return true;
        }
        
        return collide;
    }
    
    public boolean detectCollisionCar3(Cars car){
        int centerY = getCenterY();
        int c3X = car.getX3();
        int c3Y = car.getY3();
        int c3W = car.getW();
        int c3H = car.getH();
        boolean collide = false;
        
        if(x+w > c3X && x < c3X+c3W && centerY-15 < c3Y+c3H && y+h > c3Y){
            return true;
        }
        
        return collide;
    }
    
    public boolean detectCollisionCar4(Cars car){
        int c4X = car.getNextCarX1();
        int c4Y = car.getY1();
        int c4W = car.getW();
        int c4H = car.getH();
        boolean collide = false;
        
        if(x+w > c4X && x < c4X+c4W && y < c4Y+c4H && y+h > c4Y){
            return true;
        }
        
        return collide;
    }
    
    public boolean detectCollisionCar5(Cars car){
        int c5X = car.getNextCarX2();
        int c5Y = car.getY2();
        int c5W = car.getW();
        int c5H = car.getH();
        boolean collide = false;
        
        if(x+w > c5X && x < c5X+c5W && y < c5Y+c5H && y+h > c5Y){
            return true;
        }
        
        return collide;
    }
    
    public boolean detectCollisionCar6(Cars car){
        int centerY = getCenterY();
        int c6X = car.getNextCarX3();
        int c6Y = car.getY3();
        int c6W = car.getW();
        int c6H = car.getH();
        boolean collide = false;
        
        if(x+w > c6X && x < c6X+c6W && centerY-15 < c6Y+c6H && y+h > c6Y){
            return true;
        }
        
        return collide;
    }
    
    public boolean detectCollisionLog1(Logs log){
        int centerX, centerY, log1X, log1Y, log1W, logH;
        centerX = getCenterX();
        centerY = getCenterY();
        log1X = log.getX1();
        log1Y = log.getY1();
        log1W = log.getW1();
        logH = log.getH();
        boolean collide = false;
        
        if(centerY > log1Y && centerY-15 < (log1Y+logH)){
            if((centerX+8) > log1X && (centerX-8) < (log1X+log1W)){
                //System.out.println("centerX=" + centerX + ", lX1=" + lX1 + ", lW1=" + lW1 + ", lX1+lW1=" + (lX1+lW1));
                return true;
            }
        }
        
        return collide;
    }
    
    public boolean detectCollisionLog2(Logs log){
        int centerX, centerY, log2X, log2Y, log2W, logH;
        centerX = getCenterX();
        centerY = getCenterY();
        log2X = log.getX2();
        log2Y = log.getY2();
        log2W = log.getW2();
        logH = log.getH();
        boolean collide = false;
        
        if(centerY+15 > log2Y && centerY < (log2Y+logH)){
            if((centerX+8) > log2X && (centerX-8) < (log2X+log2W)){
                //System.out.println("centerX=" + centerX + ", log2X=" + log2X + ", log2W=" + log2W + ", log2X+log2W=" + (log2X+log2W));
                return true;
            }
        }
        
        return collide;
    }
    
    public boolean detectCollisionWater(Logs log){
        int centerX, centerY, lX1, lY1, lW1, lH;
        centerX = getCenterX();
        centerY = getCenterY();
        lX1 = log.getX1();
        lY1 = log.getY1();
        lW1 = log.getW1();
        lH = log.getH();
        boolean inWater = false;
        
        if(centerY > 75 && centerY < 225){
            if(!(detectCollisionLog1(log) || detectCollisionLog2(log))){
                inWater = true;
            }
        }
        
        return inWater;
    }
    
    public boolean playerWon(){
        int centerY = getCenterY();
        if(y+h-10 <= 75){
            return true;
        }
        
        return false;
    }
    
    public boolean playerLost(Logs log, Train train, Cars car){        
        if(detectCollisionWater(log)){
            return true;
        }
        if(detectCollisionTrain(train)){
            return true;
        }
        if(detectCollisionCar1(car) || detectCollisionCar2(car) || detectCollisionCar3(car) || detectCollisionCar4(car) || detectCollisionCar5(car) || detectCollisionCar6(car)){
            return true;
        }
        
        return false;
    }
    
    public void setX(int paramX){
         x = paramX;
     }
    
    public void setY(int paramY){
         y = paramY;
     }
}