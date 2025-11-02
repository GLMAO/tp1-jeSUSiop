package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge ;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        TimerService timerService = new DummyTimeServiceImpl();

        testDuTimeService(timerService);
    }

    private static void testDuTimeService(TimerService timerService) {
        Horloge horloge = new Horloge("Num 1",timerService) ;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
