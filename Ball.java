/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Graphics2D;
import java.awt.Rectangle;


/**
 *
 * @author qianjiahui
 */
public class Ball
{
    private int x = 0;
    private int y = 0;
    private int diameter = 30;
    private int xSpeed = 1;
    private int ySpeed = 1;
    private Game2 game;
    
    public Ball(Game2 game)
    {
        this.game = game;
        
    }
    
    public void move()
    {
        //x = x + 1;
        //y = y + 1;
        
        if(x + xSpeed < 0) //Left border
        {
            xSpeed = Math.abs(xSpeed);
        }
        
        if(x + xSpeed > game.getWidth() - diameter) // Right border
        {
            xSpeed = -xSpeed;
        }
        
        if(y + ySpeed < 0) // Top border
        {
            ySpeed = Math.abs(ySpeed);
        }
        
        /*if(y + ySpeed > game.getHeight() - diameter) // Bottom border
        {
            ySpeed = -ySpeed;
        }*/
        
        if(collision() == true)
        {
            ySpeed = -ySpeed;
            y = game.getRacquet().getTopY() - diameter;
        }
        
        if(y + ySpeed > game.getHeight() - diameter)
        {
            game.gameOver();
        }
        
        x = x + xSpeed;
        y = y + ySpeed;
        
    }
    
    public void paint(Graphics2D g)
    {
        g.fillOval(x, y, diameter, diameter);
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, diameter, diameter);
    }
    
    private boolean collision()
    {
        Rectangle recquetRect = game.getRacquet().getBounds();
        Rectangle ballRect = this.getBounds();
        
        boolean collision = ballRect.intersects(recquetRect);
        
        return collision;
    }
}
