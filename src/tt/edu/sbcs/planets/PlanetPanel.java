package tt.edu.sbcs.planets;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class PlanetPanel extends JPanel {

    List<Planet> planets;
    Timer timer;
    public final static int NUMBER_PLANETS = 8;

    public PlanetPanel(){
        super();
        setBackground(Color.BLACK);

        planets = new ArrayList<>();
        float dist = 100;
        for(int i = 0; i < NUMBER_PLANETS; i++) {
            planets.add(new Planet(dist, (Math.random() * 30) + 10, (Math.random() * 360)));
            dist += (Math.random() * 10) + 50;
        }

        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar() == KeyEvent.VK_S){
                    timer.start();
                }

                if(e.getKeyChar() == KeyEvent.VK_D){
                    timer.stop();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        planets.stream().forEach(p->p.draw((Graphics2D) g));
    }
}
