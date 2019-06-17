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
public class CMoneda extends CGameObjects{

    CMoneda(int X, int Y)
    {
        super.iPosX = X;
        super.iPosY = Y;
    }
    
    CMoneda()
    {
  
    }
    
    public void setX(int PosX)
    {
      super.iPosX = PosX;
    }
    
    public void setY(int PosY){
      super.iPosY = PosY;
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
    public void paintElements(Graphics g) {
       
//      Un circulo color naranja dentro de uno amarillo
        g.setColor(Color.yellow);
        g.fillOval(iPosX, iPosY, 12, 12);
        g.setColor(Color.orange);
        g.fillOval(iPosX+3, iPosY+3, 6, 6);
    }
    
}
