/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ARMANDO
 */
public class CPanelPrincipal extends JPanel implements Runnable,KeyListener,InterfaceGame
{
    private CTablero  tablero = new CTablero();
    public boolean    isPause = false;
    private Thread    hilo;
    private int       iCont;
    
     public CPanelPrincipal()
     {
    //    this.addKeyListener(this); //escuchador de las teclas
        hilo = new Thread(this);
        setFocusable(true);
     }
     
     public void iniciar()
     {
        iCont = 0; 
        hilo.start();
     }
     
     public void pausar()
     {
        hilo.suspend();
     }
    
     public void continuar()
     {
        hilo.resume();
     }
    
    public void detener()
    {
        hilo.stop();
    }
    
    @Override
    public void run() 
    {
      try
      {
          tablero.setRandomDirectionGhosts();
          
         while( !tablero.isPlaying() && !tablero.esGanador())
         {
          Thread.sleep(250);
          tablero.moverFantasmas(iCont);
          
          if(iCont == 10)
          {
            iCont = 0;
          }
          
           switch(tablero.Pacman.getDireccion())
           {
                 case IZQ: 
                        if((tablero.getObject( tablero.Pacman.getY() , tablero.Pacman.getX()-1))!= 1){
                           tablero.moverPacman();
                        }
                     break;   
                 case DER:
                         if((tablero.getObject( tablero.Pacman.getY() , tablero.Pacman.getX()+1))!= 1){
                           tablero.moverPacman();
                         }
                     break;
                 case PAR:
                         if((tablero.getObject( tablero.Pacman.getY()-1,tablero.Pacman.getX()))!= 1){
                           tablero.moverPacman();
                         }
                     break;
                 case PAB: 
                         if((tablero.getObject( tablero.Pacman.getY()+1, tablero.Pacman.getX() ))!= 1){ 
                           tablero.moverPacman();
                         }
                     break;
             }
           
             repaint();
             iCont++;
         }
         
          if( tablero.esGanador() && !tablero.isPlaying())
          {
               JOptionPane.showMessageDialog(this, "! Felicidades ganaste !", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
          }
          else{
               JOptionPane.showMessageDialog(this, "! Perdiste !", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
          }
    
          
      }catch(InterruptedException | HeadlessException e)
      {
            JOptionPane.showMessageDialog(this,"Ha ocurrido un Error: "+e.getMessage(),"Advertencia",JOptionPane.ERROR_MESSAGE);
      }
      
    }
    
    @Override
     public void paintComponent(Graphics g)
     {
//         fondo blanco
         g.setColor(Color.white);
         g.fillRect(0, 0, getWidth(), getHeight());
         
//         Se pintan los elementos
        for(CFantasma fantasmita : tablero.fantasmitas) 
        {
            fantasmita.paintElements(g);
        }
         
        for (CMuro cuadrito : tablero.cuadritos) 
        {
            cuadrito.paintElements(g);
        }
         
        for (int i=0; i < tablero.coins.size();i++) {
           tablero.coins.get(i).paintElements(g);
        }
         
        
        for(int s=0; s<tablero.bombas.size();s++)
        {
                
               tablero.bombas.get(s).paintElements(g);   
        }
           
           
        
         
          tablero.Pacman.paintElements(g);
     }

    @Override
    public void keyTyped(KeyEvent arg0) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) 
    {
        int key = arg0.getKeyCode();
        
        switch(key)
        {
            case KeyEvent.VK_LEFT:  tablero.Pacman.setDireccion(IZQ); break;
            case KeyEvent.VK_RIGHT: tablero.Pacman.setDireccion(DER); break;  
            case KeyEvent.VK_UP:    tablero.Pacman.setDireccion(PAR);  break;
            case KeyEvent.VK_DOWN:  tablero.Pacman.setDireccion(PAB);  break;
            case KeyEvent.VK_SPACE: 
                       
                     if(isPause == false)
                       { 
                           pausar(); 
                           isPause = true; 
                       }
                       else
                       { 
                           continuar(); 
                           isPause = false;
                       } 
                       break;
            case KeyEvent.VK_ESCAPE: 
                             detener(); 
                             System.exit(1); 
                             break;  
            case KeyEvent.VK_X: 
                // Aqui le cambie
           
                   if( tablero.bombas.size()<3)
                   {
                     
                           tablero.setObject(5, tablero.Pacman.getY(), tablero.Pacman.getX());
                           tablero.bombas.add(new CBomba(tablero.Pacman.getX()*25 , tablero.Pacman.getY()*25));
                          
                   }
             
          
             break;    
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    @Override
    public void moverElemento(int iEstado) {
    }
    
}
