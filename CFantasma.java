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
public class CFantasma extends CGameObjects implements InterfaceGame{

    private Color cColor;
    private int iDireccion;
    
    CFantasma(Color cFondo, int posX, int posY)
    {
        cColor = cFondo;
        super.iPosX = posX;
        super.iPosY = posY;
    }
    
    CFantasma()
    {
        
    }
    
    public void setDireccion(int iDir){
        iDireccion=iDir;
    }
    
    public int getDireccion(){
        return iDireccion;
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
        
//      Color del fantasma
        g.setColor(cColor);
//      Cabeza del fantasma  
        g.fillArc(iPosX, iPosY, 20, 20, 0, 180);
//      Cuerpo
        g.fillRect(iPosX+1, iPosY+10, 19, 10);
        g.setColor(Color.WHITE);
//        Ojos 
        g.fillOval(iPosX+2, iPosY+4, 7, 7);
        g.fillOval(iPosX+10, iPosY+4, 7, 7);
        
//      ojo negro   
        g.setColor(Color.black);
        g.fillOval(iPosX+4, iPosY+8, 3, 3);
        g.fillOval(iPosX+12,iPosY+8, 3, 3);
//      boca
        g.drawArc(iPosX+7, iPosY+15, 5, 5, 0, 180);
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
