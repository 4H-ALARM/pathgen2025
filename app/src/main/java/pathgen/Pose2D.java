package pathgen;

public class Pose2D {
    Pose2D(Point position, double rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    Pose2D(double x, double y, double rotation) {
        this(new Point(x, y), rotation);
    }
    Point position;
    double rotation;
}
