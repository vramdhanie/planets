package tt.edu.sbcs.planets;

import java.awt.*;
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
        paint = new LinearGradientPaint((float)x, (float)y, (float)(x + size), (float)(y + size), new float[]{0.1f, 0.9f}, new Color[]{Color.WHITE, new Color((float)Math.random(), (float)Math.random(), (float)Math.random())});
    }

    public void setPosition(){
        double cx = PlanetFrame.WIDTH / 2;
        double cy = PlanetFrame.HEIGHT / 2;
        x = cx + getDistance() * Math.cos(getAngle());
        y = cy + getDistance() * Math.sin(getAngle());
    }

    public void move(){
        setAngle(getAngle() + 1);
        setPosition();
    }

    public void draw(Graphics2D g2){
        g2.setPaint(paint);
        g2.fill(new Ellipse2D.Double(x, y, size, size));
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
