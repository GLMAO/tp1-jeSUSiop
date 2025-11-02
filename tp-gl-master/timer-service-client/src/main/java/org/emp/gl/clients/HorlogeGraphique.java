package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


public class HorlogeGraphique extends JFrame implements TimerChangeListener {

    private final JLabel labelHeure = new JLabel();
    private final JLabel labelDate = new JLabel();
    private final TimerService timerService;

    public HorlogeGraphique(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);

        // --- Configuration de la fenêtre ---
        setTitle("Horloge Digitale");
        setSize(420, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // --- Création du panneau principal avec fond dégradé ---
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(25, 25, 112),
                        getWidth(), getHeight(), new Color(0, 0, 0));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Label heure ---
        labelHeure.setFont(new Font("Digital-7 Mono", Font.BOLD, 60));
        labelHeure.setForeground(new Color(0, 255, 0));
        labelHeure.setHorizontalAlignment(SwingConstants.CENTER);

        // --- Label date ---
        labelDate.setFont(new Font("SansSerif", Font.PLAIN, 20));
        labelDate.setForeground(Color.LIGHT_GRAY);
        labelDate.setHorizontalAlignment(SwingConstants.CENTER);

        // --- Ajout au panneau ---
        panel.add(labelHeure, BorderLayout.CENTER);
        panel.add(labelDate, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        updateAffichage();
    }

    private void updateAffichage() {
        String heureStr = String.format("%02d:%02d:%02d",
                timerService.getHeures(),
                timerService.getMinutes(),
                timerService.getSecondes());

        String dateStr = java.time.LocalDate.now().toString();

        labelHeure.setText(heureStr);
        labelDate.setText(dateStr);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case TimerChangeListener.SECONDE_PROP:
            case TimerChangeListener.MINUTE_PROP:
            case TimerChangeListener.HEURE_PROP:
                SwingUtilities.invokeLater(this::updateAffichage);
                break;
        }
    }

    // --- Point d'entrée ---
   
}
