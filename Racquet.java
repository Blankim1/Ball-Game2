/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author qianjiahui
 */
public class Racquet 
{
    private int x = 0;
    private int y = 450;
    private int xSpeed = 0; 
    private int width = 60;
    private int height = 10;
    private Game2 game;
    
    public Racquet(Game2 game)
    {
        this.game = game;
    }
    
    public void move()
    {
        if((x + xSpeed > 0) && (x + xSpeed < game.getWidth() - width))
        {
            x = x + xSpeed;
        }
    }
    
    public void paint(Graphics2D g)
    {
        g.fillRect(x, y, width, height);
    }
    
    public void keyReleased(KeyEvent e)
    {
        xSpeed = 0;
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            xSpeed = -2;
        }
    
    
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            xSpeed = 2;
        }
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }
    
    public int getTopY()
    {
        return y;
    }
    
    
}
