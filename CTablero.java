/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ARMANDO
 */
public class CTablero implements InterfaceGame{
 
 public  CPacman               Pacman; 
 public  ArrayList <CMuro>     cuadritos;
 public  ArrayList <CBomba>    bombas; 
 public  ArrayList <CMoneda>   coins; 
 public  ArrayList <CFantasma> fantasmitas;
 public  boolean               isBomba = false;
 
 private int iMatrizObj [][] = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                 {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 4, 4, 4, 1},
                                 {1, 0, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 1},
                                 {1, 0, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 2, 0, 0, 0, 0, 0, 0, 4, 4, 4, 1},
                                 {1, 2, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1},
                                 {1, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 2, 1, 4, 4, 2, 4, 4, 4, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 2, 0, 1, 4, 1, 4, 4, 4, 4, 4, 1, 1, 1, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 0, 1, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 1, 1, 1, 1, 4, 4, 1},
                                 {1, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 4, 1, 4, 4, 4, 1, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                               };
 
 public CTablero()
 {
    Pacman      = new CPacman();
    cuadritos   = new ArrayList<>();
    bombas      = new ArrayList<>();
    coins       = new ArrayList<>();   
    fantasmitas = new ArrayList<>();
    
     int nMuros = 0;
     int nGhost = 0;
     int nCoins = 0;
    
    for(int i=0; i < 23; i++)
    {
        for(int j=0; j < 23; j++)
        {
           switch(iMatrizObj[i][j])
           {
               case 1:
//                   Es muro
                   cuadritos.add(nMuros,new CMuro(j*25,i*25) );
                   nMuros++;
                   break;
               case 2:
//                   Es un ghost
                    fantasmitas.add(nGhost,new CFantasma( this.getRandomColor(), j*25, i*25));
                    nGhost++;
                   break;
               case 3:
//                   Es pacman
                     Pacman.setX(j*25);
                     Pacman.setY(i*25);
                     Pacman.setDireccion( IZQ );
                   break;
               case 4:
//                   Es moneda
                     coins.add(nCoins,new CMoneda(j*25,i*25));
                     nCoins++;
                   break;
           }
        }
    }
 }
    
    public Color getRandomColor()
    {
        Color c = Color.BLACK;
        
        Random rnd = new Random();
        
        switch (rnd.nextInt(6))
        {
            case 0:
                c = Color.BLACK;
                break;
            case 1:
                 c = Color.BLUE;
                break;
            case 2:
                 c = Color.GREEN;
                break;
            case 3:
                 c = Color.PINK;
                break;
            case 4:
                 c = Color.RED;
                break;
            case 5:
                 c = Color.WHITE;
                break;
                  
        }
        
        return c;
    }
    
    public int getObject(int iFila, int iCol)
    {
      return  iMatrizObj [iFila][iCol];   
    }
    
    public void setObject(int obj,int iFila, int iCol)
    {
        iMatrizObj [iFila][iCol] = obj; 
    }
    
    public void moverPacman()
    {
      iMatrizObj [ Pacman.getY() ][ Pacman.getX() ] = 0;  
      Pacman.moverElemento( Pacman.getDireccion() );
      iMatrizObj [ Pacman.getY() ][ Pacman.getX() ] = 3;  
    }
    
    private void moverGhost(int iPos)
    {
      iMatrizObj [ fantasmitas.get(iPos).getY() ][fantasmitas.get(iPos).getX()] = 0;
      fantasmitas.get(iPos).moverElemento( fantasmitas.get(iPos).getDireccion() );
      iMatrizObj [ fantasmitas.get(iPos).getY() ][fantasmitas.get(iPos).getX()] = 2;
    }
    
    
    public void moverFantasmas(int iTiempo)
    {
            for(int i = 0; i < fantasmitas.size(); i++)
            {
                switch(fantasmitas.get(i).getDireccion())
                {
                    case PAR:
                        
                           if( iMatrizObj[ fantasmitas.get(i).getY() - 1 ][ fantasmitas.get(i).getX() ] != 1 && iTiempo < 10)
                           {
                             moverGhost(i);  
                           }
                           else
                           {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                           }
                               
                        break;
                        
                    case PAB:
                           
                          if(iMatrizObj[ fantasmitas.get(i).getY() + 1][fantasmitas.get(i).getX()] != 1 && iTiempo < 10)
                          {
                             moverGhost(i);   
                          }
                          else
                          {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                          }
                        
                        break;
                    case IZQ:
                         
                          if(iMatrizObj[ fantasmitas.get(i).getY()][fantasmitas.get(i).getX() - 1] != 1 && iTiempo < 10)
                          {
                             moverGhost(i);   
                          }
                          else
                          {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                          }
                        break;
                        
                    case DER:
                        
                        if(iMatrizObj[ fantasmitas.get(i).getY() ][fantasmitas.get(i).getX() + 1] != 1 && iTiempo < 10)
                          {
                             moverGhost(i);   
                          }
                          else
                          {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                          }
                        
                        break;
                }
                
                
                    for(int m=0; m < bombas.size(); m++)
                    {
                             if( fantasmitas.get(i).getX() == bombas.get(m).getX() && fantasmitas.get(i).getY() == bombas.get(m).getY())
                            {

                                iMatrizObj [fantasmitas.get(i).getY()][ fantasmitas.get(i).getX()] = 0;

                                fantasmitas.remove(i);
                                bombas.remove(m); 

                            }
                    }  
            }    
    }
    
     public boolean isPlaying()
     {
          boolean bFinish = false;
          
          
          
            for(int i=0;i < fantasmitas.size() ;i++)
            {
                  if( fantasmitas.get(i).getX() == Pacman.getX() &&  fantasmitas.get(i).getY() == Pacman.getY())
                  {
                     bFinish = true;
                  }
             
            }
            
          
          
          return bFinish;
     }
     
    public void setRandomDirectionGhosts()
    {
      for(int i = 0;i <  fantasmitas.size() ; i++)
      {  
        fantasmitas.get(i).setDireccion( this.getRandomDirection() );
      }
    }
           
    public boolean esGanador()
    {  
//        si se acaban las monedas ganas
        checkCoins();
        return coins.isEmpty();
    } 

    
    public void checkCoins()
    {
       for(int i=0; i < coins.size() ;i++)
       {
            if( Pacman.getX() == coins.get(i).getX() && Pacman.getY() == coins.get(i).getY())
            {
                coins.remove(i);//libera la memoria y elimina el objeto
            }
       } 
    }
    
    public int getRandomDirection()
    {
         Random rnd = new Random();
         return (rnd.nextInt(4)+1);
    }

    @Override
    public void moverElemento(int iEstado) {
//        No se utiliza 
    }
    
}
