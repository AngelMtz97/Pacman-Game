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
public class CPacman extends CGameObjects implements InterfaceGame {
    
    private int     iDireccion;
    private boolean isOpen=true;
    
    CPacman(int iX,int iY,int iDir)
    {
        super.iPosX=iX;
        super.iPosY=iY;
        iDireccion=iDir;
    }
    
    CPacman()
    {
        super.iPosX=0;
        super.iPosY=0;
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
    
    public void setDireccion(int iDir)
    {
        iDireccion=iDir;
    }
    
    public int getDireccion()
    {
        return iDireccion;
    }
    
    @Override
    public void paintElements(Graphics g) 
    {
        
     switch(iDireccion)
     {
         case DER: 
             if(isOpen)
             {
                g.setColor(Color.ORANGE); g.fillArc(iPosX, iPosY, 25, 25, 45, 275); isOpen=false;
             }
             else
             {
                g.setColor(Color.ORANGE); g.fillArc(iPosX, iPosY, 25, 25, 0, 360); isOpen=true;
             }
                g.setColor(Color.black); g.fillOval(iPosX+8, iPosY+4, 4, 4);
             break;
             
         case IZQ:
             if(isOpen)
             {
                  g.setColor(Color.ORANGE);  g.fillArc(iPosX, iPosY, 25, 25, 225, 275); isOpen=false;
             }
             else
             {
                  g.setColor(Color.ORANGE); g.fillArc(iPosX, iPosY, 25, 25, 0, 360); isOpen=true;
             }
             g.setColor(Color.black); g.fillOval(iPosX+8, iPosY+4, 4, 4);
             break;
         case PAR:
             if(isOpen){
                g.setColor(Color.ORANGE);  g.fillArc(iPosX, iPosY, 25, 25, 135, 270); isOpen=false;  
             }else{
                  g.setColor(Color.ORANGE); g.fillArc(iPosX, iPosY, 25, 25, 0, 360); isOpen=true;
             }
              g.setColor(Color.black); g.fillOval(iPosX+4, iPosY+8, 4, 4);
             break;
      
         case PAB: 
             if(isOpen){
                g.setColor(Color.ORANGE);  g.fillArc(iPosX, iPosY, 25, 25, 315, 270); isOpen=false;  
             }else{
                  g.setColor(Color.ORANGE); g.fillArc(iPosX, iPosY, 25, 25, 0, 360); isOpen=true;
             }
              g.setColor(Color.black); g.fillOval(iPosX+4, iPosY+8, 4, 4);
             break;
     }   
    }

    @Override
    public void moverElemento(int iEstado) {

     switch (iEstado)
     {
         case PAB:
              this.iPosY +=25;
             break;
         case PAR:
              this.iPosY -=25;
              break;
         case IZQ:
             this.iPosX -=25;
              break;
         case DER:
             this.iPosX += 25;
              break;
             
     }
    
    }
    
}
