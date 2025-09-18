package part02;

import java.util.ArrayList;

public class ArtifactsTest {
	 public static void main(String[] args) {
	        ArtifactTC01();
	        ArtifactTC02();
	        ArtifactTC03();
	        ArtifactTC04();
	        ArtifactTC05();
	        ArtifactTC06();
	        ArtifactTC07();
	        ArtifactTC08();
	        ArtifactTC09();
	        ArtifactTC10();
	        ArtifactTC12();
	        ArtifactTC13();
	        ArtifactTC14();
	        ArtifactTC15();
	        ArtifactTC16();
	        ArtifactTC17();
	        ArtifactTC18();
	        ArtifactTC19();
	        ArtifactTC20();
	        ArtifactTC21();
	        ArtifactTC22();
	        ArtifactTC23();
	        ArtifactTC24();
	        ArtifactTC25();
	        ArtifactTC26();
	        ArtifactTC27();
	        ArtifactTC28();
	        ArtifactTC29();
	        ArtifactTC31();
	        ArtifactTC34();
	        ArtifactTC35();
		

	 }
	 public static void ArtifactTC01() {
		    System.out.println("Test ArtifactTC01 - Testing whether the displayArtifactDetails works with a valid Artifact instance created");
		    System.out.println("Expected result - All of the Artifact's details are outputted the same as how they were inputted");

		    Artifacts art = new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 20, "A famous painting by Leonardo da Vinci.");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC02() {
		    System.out.println("Test ArtifactTC02 - Testing whether the creation of an Artifacts Instance works with an invalid Description (Just Spaces)");
		    System.out.println("Expected result - All of the Artifact's details are outputted, description changes to N/A");

		    Artifacts art = new Artifacts(1, "Mona", ArtifactType.OTHER, 3, "                      ");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC03() {
		    System.out.println("Test ArtifactTC03 - Testing whether the creation of an Artifacts Instance works with an invalid Engagement Time");
		    System.out.println("Expected result - All of the Artifact's details are outputted, and invalid engagement time defaults to 1");

		    Artifacts art = new Artifacts(1, "Mona", ArtifactType.PAINTING, -1, "A famous painting by Leonardo da Vinci.");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC04() {
		    System.out.println("Test ArtifactTC04 - Testing whether the creation of an Artifacts Instance works with an invalid Name");
		    System.out.println("Expected result - All of the Artifact's details are outputted, and invalid name defaults to 'Unknown Artifact'");

		    Artifacts art = new Artifacts(1, " ", ArtifactType.PAINTING, 5, "A famous painting by Leonardo da Vinci.");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC05() {
		    System.out.println("Test ArtifactTC05 - Testing whether the creation of an Artifacts Instance works with an extremely long Description (> 200 characters)");
		    System.out.println("Expected result - All of the Artifact's details are outputted, and the description is truncated to 200 characters");

		    String longDescription = "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 "
		            + "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 1";

		    Artifacts art = new Artifacts(1, "Mona", ArtifactType.SCULPTURE, 10, longDescription);
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC06() {
		    System.out.println("Test ArtifactTC06 - Testing whether the creation of an Artifacts Instance works with an extremely long but valid Description (200 characters)");
		    System.out.println("Expected result - All of the Artifact's details are outputted, and the description is truncated to 200 characters");

		    String longDescription = "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 "
		            + "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ";

		    Artifacts art = new Artifacts(1, "Mona", ArtifactType.SCULPTURE, 10, longDescription);
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC07() {
		    System.out.println("Test ArtifactTC07 - Testing whether the Artifacts instance will be created with unreasonable special characters in the description");
		    System.out.println("Expected result - All of the Artifact's details are outputted, and the description is changed to N/A");

		    String longDescription = "This is my description^<>}{[]";

		    Artifacts art = new Artifacts(1, "Mona", ArtifactType.SCULPTURE, 10, longDescription);
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC08() {
		    System.out.println("Test ArtifactTC08 - Testing whether the creation of an Artifacts Instance with engagement Time of 2 is allowed");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with Engagement Time = 2");

		    Artifacts art = new Artifacts(1, "Venus de Milo", ArtifactType.SCULPTURE, 1, "A famous ancient Greek sculpture.");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC09() {
		    System.out.println("Test ArtifactTC09 - Testing whether the creation of an Artifacts Instance with a name containing special characters is allowed");
		    System.out.println("Expected result - All of the Artifact's details are outputted, and Name defaults to 'Unknown Artifact'");

		    Artifacts art = new Artifacts(2, "mark@#$%^&*", ArtifactType.INTERACTIVE, 15, "A historic document with no clear title.");
		    art.displayArtifactDetails();
		}


		public static void ArtifactTC10() {
		    System.out.println("Test ArtifactTC10 - Testing whether the creation of an Artifacts Instance works with a very long invalid Name (81 characters)");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with the Name displayed as Artifact Unknown");
		    String name = "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 1";
		    Artifacts art = new Artifacts(7, name, ArtifactType.INTERACTIVE, 8, "A mysterious document labeled with just the letter X.");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC11() {
		    System.out.println("Test ArtifactTC11 - Testing whether the creation of an Artifacts Instance works with an engagement time of 30 mins");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with the engagement time shown as 30");
		    Artifacts art = new Artifacts(7, "Mona Lisa", ArtifactType.INTERACTIVE, 30, "A mysterious document labeled with just the letter X.");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC12() {
		    System.out.println("Test ArtifactTC12 - Testing whether the creation of an Artifacts Instance works with an engagement time of 31 mins");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with the engagement time shown as 30");
		    Artifacts art = new Artifacts(7, "Mona Lisa", ArtifactType.INTERACTIVE, 30, "A mysterious document labeled with just the letter X.");
		    art.displayArtifactDetails();
		}
		
		public static void ArtifactTC13() {
		    System.out.println("Test ArtifactTC13 - Testing whether the creation of an Artifacts Instance works with a very short valid Name (1 character)");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with the Name displayed as entered");

		    Artifacts art = new Artifacts(7, "X", ArtifactType.INTERACTIVE, 8, "A mysterious document labeled with just the letter X.");
		    art.displayArtifactDetails();
		}
		public static void ArtifactTC14() {
		    System.out.println("Test ArtifactTC14 - Testing whether the creation of an Artifacts Instance works with a name with 1 number");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with the Name displayed as entered");

		    Artifacts art = new Artifacts(7, "1", ArtifactType.INTERACTIVE, 8, "A mysterious document labeled with just the letter X.");
		    art.displayArtifactDetails();
		}

		public static void ArtifactTC15() {
		    System.out.println("Test ArtifactTC15 - Testing whether the creation of an Artifacts Instance works with a very long but valid Name (80 characters)");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with the Name displayed as entered");
		    String name = "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ";
		    Artifacts art = new Artifacts(7, name, ArtifactType.INTERACTIVE, 8, "A mysterious document labeled with just the letter X.");
		    art.displayArtifactDetails();
		}
		
		/** ----------------------------------------
		*   End of Artifacts Instance creation tests
		**/ 
		public static void ArtifactTC16() {
		    System.out.println("Test ArtifactTC16 - Testing artifact deletion by valid ID.");
		    System.out.println("Expected result - The artifact is removed from the list, and a success message is displayed.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Artifact 1", ArtifactType.SCULPTURE, 10, "Description 1"));
		    artifacts.add(new Artifacts(2, "Artifact 2", ArtifactType.PAINTING, 15, "Description 2"));
		    
		    Artifacts.deleteArtifact(artifacts);
		    System.out.println("Remaining Artifacts after Deletion:");
		    Artifacts.displayArtifacts(artifacts);
		}

		public static void ArtifactTC17() {
		    System.out.println("Test ArtifactTC17 - Testing whether the displayArtifactDetails works with an ID of zero");
		    System.out.println("Expected result - All of the Artifact's details are outputted, with ID = 0");
		    ArrayList<Artifacts> art = new ArrayList<>();
		     art.add(new Artifacts(0, "Terracotta Army", ArtifactType.SCULPTURE, 50, "An ancient collection of Chinese sculptures."));
		     art.get(0).displayArtifactDetails();
		}

		public static void ArtifactTC18() {
		    System.out.println("Test ArtifactTC18 - Testing whether the creation of two Artifacts Instances works with an ID below zero");
		    System.out.println("Expected result - All of the Artifact's details are outputted, and ID defaults to 10000 and 10001");

		    ArrayList<Artifacts> art = new ArrayList<>();
		     art.add(new Artifacts(0, "Terracotta Army", ArtifactType.SCULPTURE, 50, "An ancient collection of Chinese sculptures."));
		     art.add(new Artifacts(0, "Football Sculpture", ArtifactType.SCULPTURE, 50, "An ancient football."));
		     for(int i= 0;i<art.size();i++) {
		    	 art.get(i).displayArtifactDetails();
		     }
		}
		public static void ArtifactTC19() {
		    System.out.println("Test ArtifactTC19 - Testing search by exact artifact name.");
		    System.out.println("Expected result - Only the artifact with the exact name is displayed.");

		    // Create a list of artifacts
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 520, "A famous painting by Leonardo da Vinci."));
		    artifacts.add(new Artifacts(2, "Starry Night", ArtifactType.PAINTING, 600, "A painting by Vincent van Gogh."));
		    artifacts.add(new Artifacts(3, "The Thinker", ArtifactType.SCULPTURE, 100, "A famous sculpture by Auguste Rodin."));

		    // Search for an artifact by exact name "Mona Lisa"
		    String searchName = "Mona Lisa";
		    Artifacts.searchName(searchName, artifacts);
		}


		

		public static void ArtifactTC20() {
		    System.out.println("Test ArtifactTC20 - Testing search by ID for an artifact that does not exist.");
		    System.out.println("Expected result - A message indicating that the artifact with the specified ID is not found.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 520, "A famous painting by Leonardo da Vinci."));
		    artifacts.add(new Artifacts(2, "The Thinker", ArtifactType.SCULPTURE, 100, "A famous sculpture by Auguste Rodin."));
		    int ID = 100;
		    Artifacts.searchID(ID, artifacts);
		}

		public static void ArtifactTC21() {
		    System.out.println("Test ArtifactTC21 - Testing whether the displaySimpleArtifactDetails works");
		    System.out.println("Expected result - The artifact's name & description are outputted");

		    Artifacts art = new Artifacts(1, "Mona", ArtifactType.PAINTING, 1, "A famous painting by Leonardo da Vinci.");
		    art.displaySimpleArtifactDetails();
		}
		/**
		 * Testing updating an artifact
		 * Since the method requires user input, we will conduct multiple tests across this one calling of the method
		 */
		public static void ArtifactTC22() {

		    System.out.println("Test ArtifactTC22 - Testing updating an Artifact with multiple tests.\nSub Test 1 - Testing boundary values of ID");
		    System.out.println("Expected result - A message saying 'ID entered does not exist' should be displayed.");
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts); 
		    artifacts.get(0).displayArtifactDetails();
		    
		    System.out.println("Sub Test 2 - Special characters, length>80 & numbers only entered & testing the return (keep name the same)");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");
		    ArrayList<Artifacts> artifacts2 = new ArrayList<>();
		    artifacts2.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts2); 
		    artifacts2.get(0).displayArtifactDetails();
		    System.out.println("Sub Test 3 - Selecting the Artifact Type, Boundary Values;");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");
		    ArrayList<Artifacts> artifacts3 = new ArrayList<>();
		    artifacts3.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts3); 
		    artifacts3.get(0).displayArtifactDetails();
		    
		    System.out.println("Sub Test 4 - Special characters, length>80 & numbers only entered & testing the return (keep description the same)");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");
		    ArrayList<Artifacts> artifacts4 = new ArrayList<>();
		    artifacts4.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts4); 
		    artifacts4.get(0).displayArtifactDetails();
		    System.out.println("Sub Test 5 - <0 >30, letters and special characters and the return (keep description the same)");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");

		    ArrayList<Artifacts> artifacts5 = new ArrayList<>();
		    artifacts5.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts5); 
		    artifacts5.get(0).displayArtifactDetails();
		}

		public static void ArtifactTC23() {
		    System.out.println("Test ArtifactTC23 - Testing the search for an Artifact by name (exact)");
		    System.out.println("Expected result - Artifacts with matching names should be displayed.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    artifacts.add(new Artifacts(2, "Renaissance Painting", ArtifactType.PAINTING, 20, "A beautiful Renaissance painting."));
		    
		    String searchName = "Ancient Vase";
		    Artifacts.searchName(searchName, artifacts);
		}

		public static void ArtifactTC24() {
		    System.out.println("Test ArtifactTC24 - Testing the search for an Artifact by ID");
		    System.out.println("Expected result - The artifact with the matching ID should be displayed.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    artifacts.add(new Artifacts(2, "Renaissance Painting", ArtifactType.PAINTING, 20, "A beautiful Renaissance painting."));
		    
		    int searchID = 2;
		    Artifacts.searchID(searchID, artifacts);
		}

		public static void ArtifactTC25() {
		    System.out.println("Test ArtifactTC25 - Testing the search for part of an Artifact's name");
		    System.out.println("Expected result - Artifacts containing the search term in their name should be displayed.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    artifacts.add(new Artifacts(2, "Renaissance Painting", ArtifactType.PAINTING, 20, "A beautiful Renaissance painting."));
		    
		    String partialSearchName = "Ancient";
		    Artifacts.searchPartName(partialSearchName, artifacts);
		}

		public static void ArtifactTC26() {
		    System.out.println("Test ArtifactTC26 - Testing the search for an Artifact by Type");
		    System.out.println("Expected result - All artifacts of the selected type should be displayed.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    artifacts.add(new Artifacts(2, "Renaissance Painting", ArtifactType.PAINTING, 20, "A beautiful Renaissance painting."));
		    
		    ArtifactType selectedType = ArtifactType.SCULPTURE;
		    Artifacts.searchType(selectedType, artifacts);
		}
		/**
		 * End of searching for Artifacts
		 */

		public static void ArtifactTC27() {
		    System.out.println("Test ArtifactTC27 - Testing viewing all artifacts");
		    System.out.println("Expected result - All artifacts in the list should be displayed.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    artifacts.add(new Artifacts(2, "Renaissance Painting", ArtifactType.PAINTING, 20, "A beautiful Renaissance painting."));
		    
		    Artifacts.displayArtifacts(artifacts); 
		}

		public static void ArtifactTC28() {
		    System.out.println("Test ArtifactTC28 - Testing artifact deletion by valid ID.");
		    System.out.println("Expected result - The artifact is removed from the list, and a success message is displayed.");

		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Artifact 1", ArtifactType.SCULPTURE, 10, "Description 1"));
		    artifacts.add(new Artifacts(2, "Artifact 2", ArtifactType.PAINTING, 15, "Description 2"));

		    Artifacts.deleteArtifact(artifacts);
		    System.out.println("Remaining Artifacts:");
		    Artifacts.displayArtifacts(artifacts);
		}

		public static void ArtifactTC29() {
		    System.out.println("Test ArtifactTC29 - Testing artifact addition with valid details.");
		    System.out.println("Expected result - A new artifact is added to the list and displayed with correct details.");

		    ArrayList<Artifacts> artifacts = new ArrayList<>();

		    Artifacts.addArtifact(artifacts);
		    System.out.println("Added Artifacts:");
		    Artifacts.displayArtifacts(artifacts);
		}

		public static void ArtifactTC31() {
		    System.out.println("Test ArtifactTC31 - Testing view all artifacts functionality.");
		    System.out.println("Expected result - All artifacts in the list are displayed.");

		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Artifact 1", ArtifactType.SCULPTURE, 10, "Description 1"));
		    artifacts.add(new Artifacts(2, "Artifact 2", ArtifactType.PAINTING, 15, "Description 2"));

		    Artifacts.displayArtifacts(artifacts);
		}

		public static void ArtifactTC34() {
		    System.out.println("Test ArtifactTC34 - Testing sorting of Artifacts by ID");
		    System.out.println("Expected result - The artifacts should be sorted in ascending order of their IDs.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(5, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    artifacts.add(new Artifacts(2, "Renaissance Painting", ArtifactType.PAINTING, 20, "A beautiful Renaissance painting."));
		    artifacts.add(new Artifacts(3, "Medieval Sword", ArtifactType.SCULPTURE, 15, "A sword from the medieval times."));
		    artifacts.add(new Artifacts(1, "Prehistoric Bone", ArtifactType.SCULPTURE, 5, "A bone from prehistoric times."));
		    
		    Artifacts.sortArtifactsbyID(artifacts);
		    Artifacts.displayArtifacts(artifacts);
		}

		public static void ArtifactTC35() {
		    System.out.println("Test ArtifactTC35 - Testing Artifact deletion with an invalid ID");
		    System.out.println("Expected result - A message saying 'ID entered does not exist' should be displayed.");
		    
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    artifacts.add(new Artifacts(2, "Renaissance Painting", ArtifactType.PAINTING, 20, "A beautiful Renaissance painting."));
		    
		    int invalidID = 10; 
		    System.out.println("Testing Deletion:");
		    Artifacts.deleteArtifact(artifacts); 
		}
		public static void ArtifactTC36() {

		    System.out.println("Test ArtifactTC36 - Testing creating an Artifact with multiple tests.\nSub Test 1 - Testing boundary values of ID");
		    System.out.println("Expected result - A message saying 'ID entered does not exist' should be displayed.");
		    ArrayList<Artifacts> artifacts = new ArrayList<>();
		    artifacts.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts); 
		    artifacts.get(0).displayArtifactDetails();
		    
		    System.out.println("Sub Test 2 - Special characters, length>80 & numbers only entered & testing the return (keep name the same)");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");
		    ArrayList<Artifacts> artifacts2 = new ArrayList<>();
		    artifacts2.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts2); 
		    artifacts2.get(0).displayArtifactDetails();
		    System.out.println("Sub Test 3 - Selecting the Artifact Type, Boundary Values;");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");
		    ArrayList<Artifacts> artifacts3 = new ArrayList<>();
		    artifacts3.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts3); 
		    artifacts3.get(0).displayArtifactDetails();
		    
		    System.out.println("Sub Test 4 - Special characters, length>80 & numbers only entered & testing the return (keep description the same)");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");
		    ArrayList<Artifacts> artifacts4 = new ArrayList<>();
		    artifacts4.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts4); 
		    artifacts4.get(0).displayArtifactDetails();
		    System.out.println("Sub Test 5 - <0 >30, letters and special characters and the return (keep description the same)");
		    System.out.println("Expected result - A message should be outputted for each telling the user there is an invalid, when the final test it occurs it should move on");

		    ArrayList<Artifacts> artifacts5 = new ArrayList<>();
		    artifacts5.add(new Artifacts(1, "Ancient Vase", ArtifactType.SCULPTURE, 10, "An ancient vase from Egypt."));
		    
		    Artifacts.updateArtifact(artifacts5); 
		    artifacts5.get(0).displayArtifactDetails();
		}









	
	
	
	

}
