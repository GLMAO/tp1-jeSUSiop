package org.emp.gl.core.launcher;

import javax.swing.UIManager;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge ;
import org.emp.gl.clients.HorlogeGraphique;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        TimerService timerService = new DummyTimeServiceImpl();
        org.emp.gl.time.service.impl.DummyTimeServiceImpl service =
                new org.emp.gl.time.service.impl.DummyTimeServiceImpl();
                try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        new HorlogeGraphique(service);
        

        //testDuTimeService(timerService);
    }

    private static void testDuTimeService(TimerService timerService) {
       // Horloge horloge = new Horloge("Num 1",timerService) ;
       // Horloge horloge2 = new Horloge("Num 2",timerService) ;
        CompteARebours compteARebours = new CompteARebours(timerService,10,"Compte A Rebours ") ;
        CompteARebours compteARebours1 = new CompteARebours(timerService,15,"Compte A Rebours1 ") ;
        CompteARebours compteARebours2 = new CompteARebours(timerService,20,"Compte A Rebours 2") ;
        CompteARebours compteARebours3 = new CompteARebours(timerService,12,"Compte A Rebours 3") ;
        CompteARebours compteARebours4 = new CompteARebours(timerService,13,"Compte A Rebours 4") ;
        CompteARebours compteARebours5 = new CompteARebours(timerService,14,"Compte A Rebours 5") ;
        CompteARebours compteARebours6 = new CompteARebours(timerService,17,"Compte A Rebours 6") ;
        CompteARebours compteARebours7 = new CompteARebours(timerService,18,"Compte A Rebours 7") ;
        CompteARebours compteARebours8 = new CompteARebours(timerService,11,"Compte A Rebours 8") ;
        CompteARebours compteARebours9 = new CompteARebours(timerService,16,"Compte A Rebours 9") ;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
