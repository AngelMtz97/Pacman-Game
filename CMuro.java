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
public class CMuro extends CGameObjects{

    
    CMuro(int iX, int iY)
    {
        super.iPosX = iX;
        super.iPosY = iY;
    }
    
    @Override
    public void paintElements(Graphics g) {
//       Un simple rectangulo cafe redondeado 
        g.setColor(new Color(185, 122, 87));
        g.fillRoundRect(iPosX, iPosY, 25, 25, 6, 6);
        g.setColor(Color.black);
        g.drawRoundRect(iPosX, iPosY, 25, 25, 6, 6);
    }
    
}
