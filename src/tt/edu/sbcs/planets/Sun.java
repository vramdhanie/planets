package tt.edu.sbcs.planets;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by vincent on 02/02/2017.
 */
public class Sun implements Serializable{
    Shape shape;
    public Sun(){
        shape = new Ellipse2D.Double(PlanetFrame.WIDTH / 2 - 50, PlanetFrame.HEIGHT / 2 - 50, 100, 100);
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.YELLOW);
        g2.fill(shape);
    }
}
