package tt.edu.sbcs.planets;

import javax.swing.*;
import java.awt.*;

public class PlanetFrame extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    JPanel panel;

    public PlanetFrame(){
        super("Planets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        panel = new PlanetPanel();
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new PlanetFrame();
    }
}
