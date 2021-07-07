/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author qianjiahui
 */
public class Game2 extends JPanel
{
    private Ball ball = new Ball(this);
    private Racquet racquet = new Racquet(this);
    
    public Game2()
    {
        KeyListener listener = new KeyListener()
        {
            public void keyPressed(KeyEvent e)
            {
                racquet.keyPressed(e);
            }
            
            public void keyReleased(KeyEvent e)
            {
                racquet.keyReleased(e);
            }
            
            public void keyTyped(KeyEvent e)
            {
                
            }
        };
        
        addKeyListener(listener);
        setFocusable(true);
    }
    
    private void animate()
    {
        ball.move();
        racquet.move();
    }
    
    public void paint(Graphics g)
            
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.PINK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        ball.paint(g2d);
        racquet.paint(g2d);
    }

    public static void main(String[] args) throws InterruptedException
    {
        JFrame frame = new JFrame("Main Tennis");
        Game2 game = new Game2();
        frame.add(game);
        frame.setSize(500, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true)
        {
            game.animate();
            game.repaint();
            Thread.sleep(10);
        }
    }
    
    public Racquet getRacquet()
    {
        return racquet;
    }
    
    public void gameOver()
    {
        JOptionPane.showMessageDialog(this, "Game Over", "game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
}
