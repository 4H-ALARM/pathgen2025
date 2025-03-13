package pathgen;

import java.io.IOException;
import java.io.OutputStreamWriter;

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

    public static String pointString(Point p)
    {
        if(p == null)
            return "null";
        else
            return p.toJsonString();
    }
    public void writeToJson(OutputStreamWriter file) throws IOException
    {
        file.write ("{ \n" + 
            "\"anchor\": " +
            anchor.toJsonString());
        file.write(",\n\"prevControl\": " + pointString(prevControl));
        file.write(",\n\"nextControl\": " + pointString(nextControl));
        String ending = """
                ,
                "isLocked": false,
                "linkedName": null
                }
                """;
        file.write(ending); 
    }
    Point anchor; 
    Point prevControl;
    Point nextControl;
}


