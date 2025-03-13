package pathgen;

public class Point {
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point add (Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }
    /** 
     * creates a point from a given angle and length (degrees)
     */
    public static Point fromVector (double degrees, double length) {
        double radians = Math.toRadians(degrees);
        return new Point(Math.cos(radians) * length, Math.sin(radians) * length);
    }
    public String toJsonString () {
       return String.format("{\"x\": %f, \"y\": %f }" , x, y); 
        
    }
    double x;
    double y;
}
