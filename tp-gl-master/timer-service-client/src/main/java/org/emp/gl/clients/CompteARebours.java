package org.emp.gl.clients ; 

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService ; 

public class CompteARebours implements TimerChangeListener {
    private TimerService timerService ;
    private int secondesRestantes ;
    String name;
    
    public CompteARebours (TimerService timerService, int secondes, String name) {
        this.name = name;
        this.timerService = timerService ;
        this.secondesRestantes = secondes ;
        timerService.addTimeChangeListener(this) ;
    }
    
    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(propertyName)) {
            if (secondesRestantes > 0) {
                secondesRestantes-- ;
                int h = secondesRestantes / 3600 ;
                int m = (secondesRestantes % 3600) / 60 ;
                int s = secondesRestantes % 60 ;
                System.out.printf("Compte à rebours : %02d:%02d:%02d%n", h, m, s) ;
            } else {
                System.out.println("Compte à rebours terminé !") ;
                timerService.removeTimeChangeListener(this) ;
            }
        }
    }
}