/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Graphics;

/**
 *
 * @author ARMANDO
 */
public abstract class CGameObjects {
    int iPosX;
    int iPosY;
    
    public abstract void paintElements(Graphics g);
}
