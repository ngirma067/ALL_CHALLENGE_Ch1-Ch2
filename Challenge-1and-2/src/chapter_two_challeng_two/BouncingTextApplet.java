
package chapter_two_challeng_two;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

 
public class BouncingTextApplet extends Applet implements Runnable {
    
    private Thread animationThread;
    private int xPosition = 0;      // Current x-coordinate of text
    private int yPosition = 80;     // Fixed y-coordinate of text (increased for better visibility)
    private String displayText = "Java Archaeologist";
    private int appletWidth;
    private boolean running = false;
    private int direction = 1; // 1 for right, -1 for left
    
   
    @Override
    public void init() {
         this.setSize(600, 200); // Increased width
        this.setBackground(Color.green);
        
         appletWidth = this.getWidth();
        
         displayText = "Nati G";
        
        System.out.println("Applet initialized successfully! Width: " + appletWidth);
    }
    
     
    @Override
    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
            running = true;
            System.out.println("Animation thread started!");
        }
    }
    
    
    @Override
    public void stop() {
        if (animationThread != null) {
            running = false;
            animationThread = null;
            System.out.println("Animation thread stopped!");
        }
    }
    
   
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        
        while (running && animationThread == currentThread) {
            try {
                 xPosition += (5 * direction);
                
                 if (xPosition > appletWidth - 200) { 
                    direction = -1; // Move left
                } else if (xPosition < 0) {
                    direction = 1;  
                }
                
                 repaint();
                
                 Thread.sleep(100);
                
            } catch (InterruptedException e) {
                System.out.println("Animation thread interrupted: " + e.getMessage());
                break;
            }
        }
    }
    
     
    @Override
    public void paint(Graphics g) {
         g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 100)); // Increased font size
        
         g.drawString(displayText, xPosition, yPosition);
        
         g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Applet is running! Position: " + xPosition, 20, 120);
        g.drawString("Use: appletviewer BouncingTextApplet.html", 20, 140);
        
         g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
    }
    
 
    @Override
    public void destroy() {
        System.out.println("Applet destroyed - cleaning up resources");
    }
}


