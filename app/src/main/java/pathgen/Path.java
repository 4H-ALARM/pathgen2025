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
            wp.writeToJson(file);

        }

        file.write("]\n");
        String fileEnd = """
                ,
                "rotationTargets": [],
  "constraintZones": [],
  "pointTowardsZones": [],
  "eventMarkers": [],
  "globalConstraints": {
    "maxVelocity": 3.0,
    "maxAcceleration": 3.0,
    "maxAngularVelocity": 540.0,
    "maxAngularAcceleration": 720.0,
    "nominalVoltage": 12.0,
    "unlimited": false
  },
  "goalEndState": {
    "velocity": 0,
    "rotation": 0.0
  },
  "reversed": false,
  "folder": null,
  "idealStartingState": {
    "velocity": 0,
    "rotation": 0.0
  },
  "useDefaultConstraints": false
    }
                """;
        
                file.write(fileEnd);
        file.close();

    }
    Waypoint[] waypoints;
    double rotationStart;
    double rotationEnd;
}
