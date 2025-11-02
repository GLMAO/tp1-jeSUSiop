package org.emp.gl.clients ; 

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService ; 

public class CompteARebours implements TimerChangeListener {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
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
    public void propertyChange(PropertyChangeEvent evt){
        
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            if (secondesRestantes > 0) {
                secondesRestantes--;
                System.out.println("secondesRestantes: " + secondesRestantes);

                if (secondesRestantes== 0) {
                    System.out.println("Fin du compte à rebours !");
                    timerService.removeTimeChangeListener(this);
                }
            }
        }

        
    }
}