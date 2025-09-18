package part02;

import java.util.ArrayList;

public class Route {
    private Artifacts artifact;  // The artifact for this step
    private String sign;  // The description or "sign" for the step

    /** 
     * Constructor to create the route with an artifact and sign
     * 
     * @param artifact - A single artifact to be added to the route
     * @param sign - The description of the route being taken
     */
    public Route(Artifacts artifact, String sign) {
        this.artifact = artifact;
        this.sign = sign;
    }

    /** 
     * Getter for the artifact
     * 
     * @return The artifact inside the route
     */
    public Artifacts getArtifact() {
        return artifact;
    }

    /** Getter for the Sign
     * 
     * @return
     */
    public String getSign() {
        return sign;
    }
    /**
 	* Returns the Artifact name with the description of the route
    */
    public String toString() {
        return artifact.getName() + ": " + sign;
    }
    /**
     * Method to add an route to the ArrayList of routes
     * @param routes - ArrayList which contains all of the routes
     * @param route - The instance of the route to be added.
     */
    public static void addRoute(ArrayList<Route> routes, Route route) {
        routes.add(route);
    }
    
}
