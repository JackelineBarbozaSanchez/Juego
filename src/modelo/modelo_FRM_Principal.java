/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Vista.FRM_FondoPricipal;
import Vista.Registro_FRM_Principal;
import static java.lang.Thread.sleep;

/**
 *
 * @author Jaki
 */
public class modelo_FRM_Principal  extends Thread{
    FRM_FondoPricipal ventanafondoPrincipal;
    Registro_FRM_Principal regitro;
    int velocidad;
    boolean vivo;
    int puntos;
    public modelo_FRM_Principal(FRM_FondoPricipal fondoPrincipal,Registro_FRM_Principal registro)
    {
        velocidad = 7;
         ventanafondoPrincipal=fondoPrincipal;
         regitro=registro;
        
      
    }
     public int contar()
    {
        puntos= ventanafondoPrincipal.contarPuntos() ;
        return puntos;
    }
     
    
     public void run()
    {
        while(true)
        {
            try 
            {
               sleep(300);
              
               ventanafondoPrincipal.moverFondo();
               comprobarPersonaje();
               ventanafondoPrincipal.moverObstaculo();
               ventanafondoPrincipal.comprobarColision();
               ventanafondoPrincipal.puntosEnAsenso();
               
              
            } catch (Exception e) 
            {
                System.out.println("hubo un error en el hilo de ejemplo");
            }
                       
        }
    }
     
      public void comprobarPersonaje()
      {
                if (ventanafondoPrincipal.estado.equals("subiendo"))
                {
                   ventanafondoPrincipal.subirPersonaje();
                }
                if (ventanafondoPrincipal.estado.equals("bajando"))
                {
                    ventanafondoPrincipal.bajarPersonaje();
                }
                if(ventanafondoPrincipal.personaje.getY()<=80)
                {
                   ventanafondoPrincipal.estado="bajando";
                }
                if(ventanafondoPrincipal.personaje.getY()>=200)
                {
                    ventanafondoPrincipal.estado="enelpiso";
                }
            }
      
      public int getVelocidad() 
     {
        return velocidad;
     }
      
   

      
}//fin de clase 
