package org.emp.gl.clients ; 

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService ; 


public class Horloge implements TimerChangeListener{

    String name; 
    TimerService timerService ; 


    public Horloge (String name,TimerService timerService) {
        this.name = name ; 
        this.timerService = timerService ;
        timerService.addTimeChangeListener(this);

        System.out.println ("Horloge "+name+" initialized!") ;
    }

    public void afficherHeure () {
        if (timerService != null)
            System.out.println (name + " affiche " + 
                                timerService.getHeures() +":"+
                                timerService.getMinutes()+":"+
                                timerService.getSecondes()) ;
    }
   @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(propertyName)) {
            int h = timerService.getHeures();
            int m = timerService.getMinutes();
            int s = timerService.getSecondes();
            System.out.printf(name + " affiche : %02d:%02d:%02d%n", h, m, s);
        }
    }

}
