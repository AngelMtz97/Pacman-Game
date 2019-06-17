/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ARMANDO
 */
public class CBomba extends CGameObjects
{
    CBomba(int iX,int iY)
    {
        super.iPosX = iX;
        super.iPosY = iY;
    }
    
    public void setX(int posX)
    {
       super.iPosX = posX;
    }
    
    public void setY(int posY)
    {
       super.iPosY = posY; 
    }
    
    public int getX()
    {
       return (iPosX/25);
    }
    
    public int getY()
    {
       return (iPosY/25);
    }

    @Override
    public void paintElements(Graphics g)
    {
        
//      Un circulo negro
        g.setColor(Color.BLACK);
        g.fillOval(iPosX, iPosY, 12, 12); 
    }
    
}
