package part02;

import java.util.ArrayList;

public class ExhibitsTest {
	 public static void main(String[] args) {
		 /**
		 ExhibTC01();
		 ExhibTC02();
		 ExhibTC03();
		 ExhibTC04();
		 ExhibTC05();
		 ExhibTC06();
		 ExhibTC07();
		 ExhibTC08();
		 ExhibTC09();
		 ExhibTC10();
		 ExhibTC11();
		 ExhibTC12();
		 ExhibTC13();
		 ExhibTC15();
		 ExhibTC16();
		 
		 ExhibTC17();
		 ExhibTC18();
		 ExhibTC19();
		 **/
		 ExhibTC20();
	 }
	 

	 public static void ExhibTC01() {
		    System.out.println("Test ExhibTC01 - Testing the creation of an Exhibits instance with valid parameters");
		    System.out.println("Expected result - All of the exhibit details should be displayed correctly.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Ancient Vase", ArtifactType.PAINTING, 10, "A beautiful ancient vase."));

		    Exhibits exhibit = new Exhibits(1, "Ancient Artifacts", "A collection of ancient artifacts", artifactsList);
		    exhibit.displayExhibitDetails();
		}

		public static void ExhibTC02() {
		    System.out.println("Test ExhibTC02 - Testing the creation of an Exhibits instance with null artifacts list");
		    System.out.println("Expected result - Artifacts list should be empty, but the exhibit details should still be displayed.");

		    Exhibits exhibit = new Exhibits(2, "Modern Art", "A collection of modern art", null);
		    exhibit.displayExhibitDetails();
		}

		public static void ExhibTC03() {
		    System.out.println("Test ExhibTC03 - Testing the creation of an Exhibits instance with invalid exhibit name");
		    System.out.println("Expected result - The exhibit name should default to 'Unknown Exhibit' because the provided name is invalid.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Modern Painting", ArtifactType.PAINTING, 20, "A contemporary artwork."));

		    Exhibits exhibit = new Exhibits(3, " ", "A collection of modern art", artifactsList);
		    exhibit.displayExhibitDetails();
		}

		public static void ExhibTC04() {
		    System.out.println("Test ExhibTC04 - Testing the creation of an Exhibits instance with invalid description");
		    System.out.println("Expected result - The exhibit description should default to 'N/A' when an invalid description is provided.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Ancient Vase", ArtifactType.PAINTING, 15, "A beautiful ancient vase."));

		    Exhibits exhibit = new Exhibits(4, "Ancient Artifacts", " ", artifactsList);
		    exhibit.displayExhibitDetails();
		}

		public static void ExhibTC05() {
		    System.out.println("Test ExhibTC05 - Testing the creation of an Exhibits instance with invalid ID");
		    System.out.println("Expected result - The exhibit ID should be set to a non-negative value. Invalid ID should trigger a validation message.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Ancient Vase", ArtifactType.PAINTING, 15, "A beautiful ancient vase."));

		    Exhibits exhibit = new Exhibits(-1, "Ancient Artifacts", "A collection of ancient artifacts", artifactsList);
		    exhibit.displayExhibitDetails();  // ID should be set to 0 due to validation
		}
		

		public static void ExhibTC06() {
		    System.out.println("Test ExhibTC06 - Testing the addition of new artifacts to an exhibit");
		    System.out.println("Expected result - The exhibit should successfully add new artifacts, and the updated list should be displayed.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Ancient Vase", ArtifactType.PAINTING, 15, "A beautiful ancient vase."));

		    Exhibits exhibit = new Exhibits(6, "Ancient Artifacts", "A collection of ancient artifacts", artifactsList);
		    exhibit.addArtifact(new Artifacts(2, "Roman Sword", ArtifactType.SCULPTURE, 25, "A sharp Roman sword."));
		    exhibit.displayExhibitDetails();
		}

		public static void ExhibTC07() {
		    System.out.println("Test ExhibTC07 - Testing the functionality of calculating the total engagement time for an exhibit");
		    System.out.println("Expected result - The total engagement time should be calculated based on the sum of all artifact engagement times.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Ancient Vase", ArtifactType.PAINTING, 15, "A beautiful ancient vase."));
		    artifactsList.add(new Artifacts(2, "Roman Statue", ArtifactType.SCULPTURE, 10, "An ancient Roman sculpture."));

		    Exhibits exhibit = new Exhibits(7, "Ancient Artifacts", "A collection of ancient artifacts", artifactsList);
		    int totalEngagementTime = exhibit.getTotalEngagementTime();
		    System.out.println("Total Engagement Time for the exhibit: " + totalEngagementTime + " minutes");
		}

		public static void ExhibTC08() {
		    System.out.println("Test ExhibTC08 - Testing the functionality of displaying exhibit details with an empty artifacts list");
		    System.out.println("Expected result - The exhibit details should be displayed, but the list of artifacts should be empty.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    Exhibits exhibit = new Exhibits(8, "Empty Exhibit", "An exhibit with no artifacts", artifactsList);
		    exhibit.displayExhibitDetails();
		}

		public static void ExhibTC09() {
		    System.out.println("Test ExhibTC09 - Testing null artifact scenario.");
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(null);  // Adding a null artifact
		    Exhibits exhibit = new Exhibits(101, "Art of the Future", "A collection of futuristic artwork", artifacts);

		    exhibit.displayExhibitDetails(); // This should handle the null artifact gracefully
		}

		public static void ExhibTC10() {
		    System.out.println("Test ExhibTC10 - Testing whether nextID method works correctly in finding the next available ID");
		    System.out.println("Expected result - The next ID should be calculated based on the current list of exhibits.");

		    ArrayList<Exhibits> exhibitsList = new ArrayList<>();

		    // Create separate artifact lists for each exhibit
		    ArrayList<Artifacts> artifacts1 = new ArrayList<>();
		    artifacts1.add(new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 520, "A famous painting by Leonardo da Vinci."));

		    ArrayList<Artifacts> artifacts2 = new ArrayList<>();
		    artifacts2.add(new Artifacts(2, "The Thinker", ArtifactType.SCULPTURE, 300, "A famous sculpture by Auguste Rodin."));

		    // Add exhibits with separate artifact lists
		    exhibitsList.add(new Exhibits(1, "Ancient Artifacts", "A collection of ancient artifacts", artifacts1));
		    exhibitsList.add(new Exhibits(3, "Modern Art", "A collection of modern art", artifacts2));

		    // Calculate and display the next available ID
		    int nextId = Exhibits.nextID(exhibitsList);
		    System.out.println("Next available ID: " + nextId);  // Should return 2
		}

		public static void ExhibTC11() {
		    System.out.println("Test ExhibTC11 - Testing the searchByID method to find an exhibit by ID");
		    System.out.println("Expected result - The exhibit with the specified ID should be displayed, or an error message if not found.");

		    ArrayList<Exhibits> exhibitsList = new ArrayList<>();
		    Exhibits exhibit1 = new Exhibits(1, "Ancient Artifacts", "A collection of ancient artifacts", new ArrayList<>());
		    Exhibits exhibit2 = new Exhibits(2, "Modern Art", "A collection of modern art", new ArrayList<>());
		    exhibitsList.add(exhibit1);
		    exhibitsList.add(exhibit2);

		    Exhibits result = Exhibits.searchByID(1, exhibitsList);
		    if (result != null) {
		        result.displayExhibitDetails();
		    }

		    result = Exhibits.searchByID(3, exhibitsList);
		    if (result == null) {
		        System.out.println("Exhibit with ID 3 not found.");
		    }
		}

		public static void ExhibTC12() {
		    System.out.println("Test ExhibTC12 - Testing the searchPartName method to search for exhibits containing a part of a name");
		    System.out.println("Expected result - All exhibits with a name containing the specified part should be displayed.");

		    ArrayList<Exhibits> exhibitsList = new ArrayList<>();
		    Exhibits exhibit1 = new Exhibits(1, "Ancient Artifacts", "A collection of ancient artifacts", new ArrayList<>());
		    Exhibits exhibit2 = new Exhibits(2, "Modern Art", "A collection of modern art", new ArrayList<>());
		    Exhibits exhibit3 = new Exhibits(3, "Ancient Sculptures", "A collection of ancient sculptures", new ArrayList<>());
		    exhibitsList.add(exhibit1);
		    exhibitsList.add(exhibit2);
		    exhibitsList.add(exhibit3);

		    Exhibits.searchPartName("Ancient", exhibitsList);
		}

		public static void ExhibTC13() {
		    System.out.println("Test ExhibTC13 - Testing the searchName method to search for exhibits with an exact name");
		    System.out.println("Expected result - Only the exhibit with the exact name should be displayed.");

		    ArrayList<Exhibits> exhibitsList = new ArrayList<>();
		    Exhibits exhibit1 = new Exhibits(1, "Ancient Artifacts", "A collection of ancient artifacts", new ArrayList<>());
		    Exhibits exhibit2 = new Exhibits(2, "Modern Art", "A collection of modern art", new ArrayList<>());
		    exhibitsList.add(exhibit1);
		    exhibitsList.add(exhibit2);

		    Exhibits.searchName("Ancient Artifacts", exhibitsList); // Should show exhibit1 only
		}
		public static void ExhibTC14() {
		    System.out.println("Test ExhibTC14 - Testing the removal of an artifact from an exhibit");
		    System.out.println("Expected result - The artifact should be successfully removed from the exhibit, and the updated list should be displayed.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    Artifacts artifact1 = new Artifacts(1, "Ancient Vase", ArtifactType.PAINTING, 15, "A beautiful ancient vase.");
		    Artifacts artifact2 = new Artifacts(2, "Roman Sword", ArtifactType.SCULPTURE, 20, "A sharp Roman sword.");

		    artifactsList.add(artifact1);
		    artifactsList.add(artifact2);

		    Exhibits exhibit = new Exhibits(101, "Ancient Artifacts", "A collection of ancient artifacts", artifactsList);
		    
		    System.out.println("Before removing artifact:");
		    exhibit.displayExhibitDetails();

		    exhibit.removeArtifact(artifact1);  // Remove one artifact

		    System.out.println("After removing artifact:");
		    exhibit.displayExhibitDetails();  // Display updated list of artifacts
		}


		public static void ExhibTC15() {
		    System.out.println("Test ExhibTC15 - Testing searchByArtifactType with empty list.");

		    ArrayList<Artifacts> artifacts = new ArrayList<>();

		    ArtifactType type = ArtifactType.PAINTING;
		    Artifacts.searchType(type, artifacts);
		}

		public static void ExhibTC16() {
		    System.out.println("Test ExhibTC16 - Testing displayRoutes method with routes assigned.");

		    ArrayList<Exhibits> exhibit = new ArrayList<>();
		    ArrayList<Artifacts> artifacts = new ArrayList<>();

		    artifacts.add(new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 520, "A famous painting by Leonardo da Vinci."));
		    artifacts.add(new Artifacts(2, "The Thinker", ArtifactType.SCULPTURE, 300, "A famous sculpture by Auguste Rodin."));
		    artifacts.add(new Artifacts(3, "The Persistence of Memory", ArtifactType.PAINTING, 180, "A surrealist painting by Salvador Dalí."));

		    exhibit.add(new Exhibits(1, "Renaissance Art Exhibit", "A collection of classic paintings from the Renaissance period.", new ArrayList<Artifacts>()));

		    exhibit.get(0).getArtifacts().add(artifacts.get(0));  
		    exhibit.get(0).getArtifacts().add(artifacts.get(1));  
		    exhibit.get(0).getArtifacts().add(artifacts.get(2)); 

		    exhibit.get(0).addRouteStep(new Route(artifacts.get(0), "View Mona Lisa - A famous painting by Leonardo da Vinci."));
		    exhibit.get(0).addRouteStep(new Route(artifacts.get(1), "View The Thinker - A sculpture by Auguste Rodin."));
		    exhibit.get(0).addRouteStep(new Route(artifacts.get(2), "View The Persistence of Memory - A surrealist painting by Salvador Dalí."));

		    exhibit.get(0).displayRoutes();
		}

		public static void ExhibTC17() {
		    System.out.println("Test ExhibTC17 - Testing displayRoutes with no routes assigned.");

		    Exhibits exhibit = new Exhibits(102, "History of Art", "A timeline of art movements", new ArrayList<>());
		    exhibit.displayRoutes();
		}
		public static void ExhibTC18() {
		    System.out.println("Test ExhibTC18 - Testing the removal of routes from an exhibit.");
		    System.out.println("Expected result: The route should be successfully removed from the exhibit.");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    Artifacts artifact = new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 520, "A famous painting by Leonardo da Vinci.");

		    Exhibits exhibit = new Exhibits(101, "Renaissance Art", "A collection of paintings from the Renaissance period", artifactsList);
		    exhibit.addRouteStep(new Route(artifact, "View Mona Lisa"));
		    exhibit.addRouteStep(new Route(artifact, "View Mona Lisa")); 

		    exhibit.removeRoute(artifact);  
		    exhibit.displayRoutes();  
		}
		public static void ExhibTC19() {
		    System.out.println("Test ExhibTC19 - Testing the addition of Artifacts with a variety of sub tests");
		    System.out.println("Expected result: Add one Artifact with artifact ID");
		    
		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    ArrayList<Exhibits> exhibit = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 520, "A famous painting by Leonardo da Vinci."));
		    Exhibits.AddExhibit(exhibit, artifactsList);
		    


		}
		public static void ExhibTC20() {
		    System.out.println("Test ExhibTC20 - Testing the updating of an exhibit with a variety of parameters passed in");
		    System.out.println("Expected result: The artifact should be updated successfuly");

		    ArrayList<Artifacts> artifactsList = new ArrayList<>();
		    ArrayList<Exhibits> exhibit = new ArrayList<>();
		    artifactsList.add(new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 10, "A famous painting by Leonardo da Vinci."));
		    exhibit.add(new Exhibits(1, "Renaissance Art Exhibit", "A collection of classic paintings from the Renaissance period.", artifactsList));
		    Exhibits.updateExhibit(exhibit, artifactsList);
		    Exhibits.displayAllExhibits(exhibit);
		}
		


	    


}




