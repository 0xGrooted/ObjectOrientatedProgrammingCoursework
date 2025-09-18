package part02;

import java.util.ArrayList;

public class RouteTest {
    public static void main(String[] args) {
    	RouteTC01();
    	RouteTC02();
    	RouteTC03();
    	RouteTC04();
    	RouteTC05();
    }
	public static void RouteTC01() {
	    System.out.println("Test RouteTC01 - Testing the creation of a Route instance with valid parameters");
	    System.out.println("Expected result - The route's artifact and sign should be correctly displayed.");

	    Artifacts artifact = new Artifacts(1, "Ancient Map", ArtifactType.DIGITAL, 5, "An old map of the region.");
	    Route route = new Route(artifact, "Follow the trail to the left.");

	    System.out.println("Route Details: " + route.toString());
	}

	public static void RouteTC02() {
	    System.out.println("Test RouteTC02 - Testing the creation of a Route instance with a null artifact");
	    System.out.println("Expected result - The route's artifact should be null but the sign should be correctly displayed.");

	    Route route = new Route(null, "Proceed to the marked location.");

	    System.out.println("Route Details: " + (route.getArtifact() == null ? "Artifact: null" : "Artifact: " + route.getArtifact().getName()));
	    System.out.println("Sign: " + route.getSign());
	}

	public static void RouteTC03() {
	    System.out.println("Test RouteTC03 - Testing the creation of a Route instance with an empty sign");
	    System.out.println("Expected result - The route's sign should display as empty.");

	    Artifacts artifact = new Artifacts(2, "Historic Sword", ArtifactType.INTERACTIVE, 3, "A ceremonial sword from ancient times.");
	    Route route = new Route(artifact, "");

	    System.out.println("Route Details: " + route.toString());
	}

	public static void RouteTC04() {
	    System.out.println("Test RouteTC04 - Testing the static method addRoute to add a valid Route to a list");
	    System.out.println("Expected result - The route should be added to the list, and the list size should increase by 1.");

	    ArrayList<Route> routes = new ArrayList<>();
	    Artifacts artifact = new Artifacts(3, "Golden Coin", ArtifactType.INTERACTIVE, 1, "A rare golden coin from the Roman Empire.");
	    Route route = new Route(artifact, "Turn right at the next fork.");

	    Route.addRoute(routes, route);

	    System.out.println("Routes List Size: " + routes.size());
	    System.out.println("First Route Details: " + routes.get(0).toString());
	}

	public static void RouteTC05() {
	    System.out.println("Test RouteTC05 - Testing the static method addRoute to add a null Route to a list");
	    System.out.println("Expected result - The null Route should not be added, and the list size should remain unchanged.");

	    ArrayList<Route> routes = new ArrayList<>();

	    Route.addRoute(routes, null);

	    System.out.println("Routes List Size: " + routes.size());
	}
}

