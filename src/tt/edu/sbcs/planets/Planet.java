package tt.edu.sbcs.planets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.NoninvertibleTransformException;

/**
 * Parametric equation for a circle:
 * x = cx + r * cos(a)
 * y = cy + r * sin(a)
 */
public class Planet implements Serializable{
    private double distance;
    private double size;
    private double angle;
    double x;
    double y;
    transient Paint paint;
    Shape shape;
    double speed;
    Shape orbit;
    transient Timer timer;

    public Planet(){
        this(100);
    }
    public Planet(double distance){
        this(distance, 10);
    }
    public Planet(double distance, double size){
        this(distance, size, 0);
    }
    public Planet(double distance, double size, double angle){
        this.setDistance(distance);
        this.setSize(size);
        this.setAngle(angle);
        setPosition();
        speed = Math.random() * 0.01;
        paint = new LinearGradientPaint(
            0, 0, (float)size, (float)size,
            new float[]{0.1f, 0.9f}, 
            new Color[]{
                Color.WHITE, 
                new Color(
                    (float)Math.random(), 
                    (float)Math.random(), 
                    (float)Math.random()
                )});
        shape = new Ellipse2D.Double(0, 0, size, size);
        orbit = new Ellipse2D.Double(
                (PlanetFrame.WIDTH/2) - distance,
                (PlanetFrame.HEIGHT/2) - distance,
                distance * 2,
                distance * 2);

        timer = new Timer(16, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                //System.out.println(this);
            }
        });


    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }


    public void setPosition(){
        double cx = PlanetFrame.WIDTH / 2;
        double cy = PlanetFrame.HEIGHT / 2;
        x = cx + getDistance() * Math.cos(getAngle());
        y = cy + getDistance() * Math.sin(getAngle());
    }

    public void move(){
        setAngle(getAngle() + speed);
        setPosition();
    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.WHITE);
        g2.draw(orbit);
        AffineTransform af = new AffineTransform();
        af.translate(x - (size/2), y - (size/2));
        g2.transform(af);
        g2.setPaint(paint);
        g2.fill(shape);
        try {
            g2.transform(af.createInverse());
        } catch (NoninvertibleTransformException e) {
            e.printStackTrace();
        }
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String toString(){
        return String.format("Position=(%.2f, %.2f);Size=%.2f", x, y, size);
    }
}
