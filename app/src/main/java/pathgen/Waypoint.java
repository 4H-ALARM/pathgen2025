package pathgen;

public class Waypoint {
    public Waypoint( Point anchor, Point prevControl, Point nextControl) {
        this.anchor = anchor;
        this.prevControl = prevControl;
        this.nextControl = nextControl;
    }
    public Waypoint(Point anchor, double degrees, double preControlLength, double postControlLength) {
        this.anchor = anchor;
        if (preControlLength != 0) 
            this.prevControl = anchor.add(Point.fromVector(degrees - 180, preControlLength));
        if (postControlLength != 0)
            this.nextControl = anchor.add(Point.fromVector(degrees, postControlLength));

    }
    Point anchor; 
    Point prevControl;
    Point nextControl;
}


