//import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrossyRoad extends JComponent implements KeyListener, MouseListener{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private Player player;
    private Cars car;
    private Train train;
    private Logs log;
    private int score, triesLeft;
    boolean alive;
    ImageIcon playerLostImageIcon;
    Image playerLostImage;
    ImageIcon playerWinImageIcon;
    Image playerWinImage;
    
    //Default Constructor
    public CrossyRoad(){
        //initializing instance variables
        WIDTH = 650;
        HEIGHT = 750;
        
        //Setting up the GUI
        JFrame gui = new JFrame(); //This makes the gui box
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes sure program can close
        gui.setTitle("Crossy Road"); //This is the title of the game, you can change it
        gui.setPreferredSize(new Dimension(WIDTH + 5, HEIGHT + 30)); //Setting the size for gui
        gui.setResizable(false); //Makes it so the gui cant be resized
        gui.getContentPane().add(this); //Adding this class to the gui
        gui.pack(); //Packs everything together
        gui.setLocationRelativeTo(null); //Makes so the gui opens in the center of screen
        gui.setVisible(true); //Makes the gui visible
        gui.addKeyListener(this);
        gui.addMouseListener(this);
        
        player = new Player();
        car = new Cars();
        train = new Train();
        log = new Logs();
        
        score = 0;
        triesLeft = 5;
        alive = true;
        
        playerLostImageIcon = new ImageIcon(Player.class.getResource("CR_chicken_lose.png"));        
        playerLostImage = playerLostImageIcon.getImage();
        playerWinImageIcon = new ImageIcon(Player.class.getResource("CRchicken_win.png"));        
        playerWinImage = playerWinImageIcon.getImage();
    }
    
    //This method will acknowledge user input
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == 37 || key == 38 || key == 39 || key == 40){
            player.keyPressed(e);        
        }
    }
    
    //All your UI drawing goes in here
    public void paintComponent(Graphics g){
        // drawing the background
        g.setColor(Color.GREEN);
        g.fillRect(0, 675, 650, 75);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 450, 650, 225);
        
        /*g.setColor(Color.YELLOW);
        g.fillRect(0, 670, 650, 10);
        Font f = new Font("Arial", Font.BOLD, 15);
        g.setFont(f);
        g.setColor(Color.BLACK);
        g.drawString("BE CAREFUL OF PASSING CARS. BE CAREFUL OF PASSING CARS. BE CAREFUL OF PASSING CARS.", 5, 681);*/
        
        g.setColor(Color.GREEN);
        g.fillRect(0, 375, 650, 75);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 300, 650, 75);
        
        g.setColor(Color.GREEN);
        g.fillRect(0, 225, 650, 75);
        
        g.setColor(Color.CYAN);
        g.fillRect(0, 75, 650, 150);
        
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 650, 75);
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 520, 65, 10);
        g.fillRect(115, 520, 65, 10);
        g.fillRect(230, 520, 65, 10);
        g.fillRect(345, 520, 65, 10);
        g.fillRect(460, 520, 65, 10);
        g.fillRect(575, 520, 65, 10);
        
        g.fillRect(0, 595, 65, 10);
        g.fillRect(115, 595, 65, 10);
        g.fillRect(230, 595, 65, 10);
        g.fillRect(345, 595, 65, 10);
        g.fillRect(460, 595, 65, 10);
        g.fillRect(575, 595, 65, 10);
        
        g.setColor(Color.GRAY);
        g.fillRect(0, 300, 650, 8);
        g.fillRect(0, 367, 650, 8);
        
        g.fillRect(20, 290, 15, 95);
        g.fillRect(85, 290, 15, 95);
        g.fillRect(150, 290, 15, 95);
        g.fillRect(215, 290, 15, 95);
        g.fillRect(280, 290, 15, 95);
        g.fillRect(345, 290, 15, 95);
        g.fillRect(410, 290, 15, 95);
        g.fillRect(475, 290, 15, 95);
        g.fillRect(540, 290, 15, 95);
        g.fillRect(605, 290, 15, 95);
        g.fillRect(670, 290, 15, 95);
        g.fillRect(735, 290, 15, 95);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 250, 70);
        
        Font f = new Font("Arial", Font.BOLD, 30);
        g.setFont(f);
        g.setColor(Color.BLUE);
        g.drawString("SCORE:  " + score + "/3", 10, 25);
        g.drawString("TRIES LEFT: " + triesLeft, 10, 60);
        
        if(triesLeft == 1){
            g.setColor(Color.RED);
            g.drawString("TRIES LEFT: " + triesLeft, 10, 60);
        }
        
        // draw the moving objects
        if (log != null) log.drawLogs(g);
        if (player != null) player.drawPlayer(g);
        if (car != null) car.drawCars(g);
        if (train != null) train.drawTrain(g);
        
        if(player != null && player.playerWon()){
            f = new Font("Arial", Font.BOLD, 40);
            g.setFont(f);
            g.setColor(Color.PINK);
            g.drawString("You got a point.", 20, 120);
        }
        
        if(player != null && player.playerLost(log, train, car)){
            f = new Font("Arial", Font.BOLD, 50);
            g.setFont(f);
            if(player.detectCollisionWater(log)){
                g.setColor(Color.ORANGE);
                    g.drawString("SPLASH!", 40, 110);
            }
            if(player.detectCollisionCar1(car) || player.detectCollisionCar2(car) || player.detectCollisionCar3(car) || 
               player.detectCollisionCar4(car) || player.detectCollisionCar5(car) || player.detectCollisionCar6(car)){
                g.setColor(Color.MAGENTA);
                g.drawString("HONK!", 450, 530);
            }
            if(player.detectCollisionTrain(train)){
                g.setColor(Color.BLUE);
                    g.drawString("THUD!", 490, 300);
            }
        }
        
        if(score == 3){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 650, 750);
            
            f = new Font("Arial", Font.BOLD, 60);
            g.setFont(f);
            g.setColor(Color.BLUE);
            g.drawString("WINNER WINNER,", 50, 75);
            g.drawString("CHICKEN DINNER!!!", 36, 125);
            
            g.drawImage(playerWinImage, 200, 150, 198, 448, null);
            
            f = new Font("Arial", Font.BOLD, 30);
            g.setFont(f);
            g.drawString("Oh wait...", 10, 685);
        }
        
        if(triesLeft == 0){            
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 650, 750);
            
            f = new Font("Arial", Font.BOLD, 60);
            g.setFont(f);
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 100, 120);
            
            g.drawImage(playerLostImage, 200, 300, 218, 365, null);
        }
    }
    
    public void loop(){
        if(player.playerWon()){
            score += 1;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(CrossyRoad.class.getName()).log(Level.SEVERE, null, ex);
            }
            player.setX(301);
            player.setY(683);
        }
        if(player.playerLost(log, train, car)){            
            triesLeft -= 1;
            alive = false;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(CrossyRoad.class.getName()).log(Level.SEVERE, null, ex);
            }
            player.setX(301);
            player.setY(683);
            alive = true;
        }
        if(triesLeft == 0 || score == 3){
            alive = false;
        }
        
        if(alive){
            if(player != null) player.movePlayer(log);
            if(car != null) car.moveCars();
            if(train != null) train.moveTrain();
            if(log != null) log.moveLogs();
        }
        repaint();
    }
    
    //These methods are required by the compiler.
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e){
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == 37 || key == 38 || key == 39 || key == 40){
            player.keyReleased(e);
        }
    }
    
    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void start(final int ticks){
        Thread gThread = new Thread(){
            public void run(){
                while(true){
                    loop();
                    try{
                        if (log == null) return;
                        Thread.sleep(1000 / ticks);
                    }catch(Exception e){ 
                        e.printStackTrace();
                    }
                }
            }
        };
        gThread.start();
    }
    
    public static void main(String[] args){
        CrossyRoad g = new CrossyRoad();
        g.start(60);
    }
}