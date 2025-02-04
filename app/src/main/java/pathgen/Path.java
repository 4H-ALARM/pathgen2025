package pathgen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Path {
    public Path(Waypoint[] waypoints, double rotationStart, double rotationEnd) {
        this.waypoints = waypoints;
        this.rotationStart = rotationStart;
        this.rotationEnd = rotationEnd;
    }
    public void writeToJson (String filename) throws IOException {
        var file =  new FileWriter (filename); 
        file.write ("{ \n" +
        "\"version\": \"2025.0\", \n" +
        "\"waypoints\": [ \n" ); 
        boolean first = true; 
        for (Waypoint wp : waypoints) {
            if (first) { 
               first = false; 
            }
            else {
                file.write (","); 
            }
            file.write ("{ \n" + 
            "\"anchor\":  \n" +
            wp.anchor.toJsonString() + 
            ",\"prevControl\": "); 

        }
        
        

    }
    Waypoint[] waypoints;
    double rotationStart;
    double rotationEnd;
}
