package tt.edu.sbcs.planets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

/**
 * Parametric equation for a circle:
 * x = cx + r * cos(a)
 * y = cy + r * sin(a)
 */
public class Planet {
    private double distance;
    private double size;
    private double angle;
    double x;
    double y;
    Paint paint;
    Shape shape;

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

        Timer timer = new Timer(16, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                //System.out.println(this);
            }
        });
        timer.start();

    }

    public void setPosition(){
        double cx = PlanetFrame.WIDTH / 2;
        double cy = PlanetFrame.HEIGHT / 2;
        x = cx + getDistance() * Math.cos(getAngle());
        y = cy + getDistance() * Math.sin(getAngle());
    }

    public void move(){
        setAngle(getAngle() + 0.01);
        setPosition();
    }

    public void draw(Graphics2D g2){
        g2.translate(x, y);
        g2.setPaint(paint);
        g2.fill(shape);
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
