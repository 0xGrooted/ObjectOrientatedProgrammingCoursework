package part03;

import java.util.ArrayList;
import java.util.Scanner;

import console.Console;

import javax.swing.ImageIcon;


public class QUBMediaMuseum  {
	   /*
	    * Create the array lists which will have all of the artifacts, exhibits and annual plan for the 
	    * museum. 
	    */
	   private static ArrayList < Artifacts > artifacts = new ArrayList < > (); // Create the ArrayList which will hold all of the Artifacts
	   private static ArrayList < Exhibits > exhibit = new ArrayList < > (); // Create the ArrayList which will hold all of the Exhibits
	   private static AnnualPlan annualPlan = new AnnualPlan(0);
	   private static ArrayList<AnnualPlan> annualPlans = new ArrayList<>();
	   
	   private static ImageIcon[] images;

	   public static void initializeImages() {
		    // Dynamically adjust the size based on the number of artifacts
		    images = new ImageIcon[artifacts.size()];

		    // Load images into the array
		    for (int i = 0; i < artifacts.size(); i++) {
		        // Construct the path to the image based on the artifact ID
		        String imagePath = "/images/" + artifacts.get(i).getId() + ".png"; // Assuming it's in the 'bin' or classpath

		        // Use getResource to load the image from the classpath
		        java.net.URL imgURL = QUBMediaMuseum.class.getResource(imagePath);

		        // Check if the image is found
		        if (imgURL != null) {
		            // If the image is found, create an ImageIcon from the URL
		            images[i] = new ImageIcon(imgURL);
		            console.println("Image loaded successfully for Artifact ID " + artifacts.get(i).getId());
		        } else {
		            // If no image exists for the artifact, leave the slot empty (null)
		            images[i] = null;
		            console.println("No image found for Artifact ID " + artifacts.get(i).getId());
		        }
		    }
		}



	// ImageIcon to hold the museum image
	   private static ImageIcon museumImage;
	   public static Console console = new Console(true);
	   
	   private static int currentImageIndex = 0;
	   private static int firstNum = 0;
	   private static int lastNum = 0;


	   public static void main(String[] args) {
		   
			
			// Set the width and height for the console
			console.setSize(800, 600);
			console.setVisible(true);
			museumImage = new ImageIcon(QUBMediaMuseum.class.getResource("/images/museum.png"));
			showLoadingScreen("Loading QUB Media Museum...", 5);
			 
			 displayMuseumImage();
			 
			 
		   // Create instances from all of the arrayLists above^
		   createArtifacts();
		   createExhibits();
		   createAnnualPlan();
		   
		  // Create an instance of the menu, this will appear when the system is run
	      Menu mainMenu = new Menu("QUB Museum", Resources.mainOptions);
	      int choice = 0;
	      boolean quit = false;
	      do {
	         choice = mainMenu.getUserChoice();
	         quit = processChoice(choice);
	      } while (!quit);

	      console.println("All done - Goodbye!");
	   }

	   
	     private static void createArtifacts() {
	   artifacts.add(new Artifacts(1, "Mona Lisa", ArtifactType.PAINTING, 520, "A famous painting by Leonardo da Vinci."));
	   artifacts.add(new Artifacts(2, "The Starry Night", ArtifactType.PAINTING, 130, "A famous painting by Vincent van Gogh."));
	   artifacts.add(new Artifacts(3, "David", ArtifactType.SCULPTURE, 500, "A marble statue created by Michelangelo."));
	   artifacts.add(new Artifacts(4, "The Thinker", ArtifactType.SCULPTURE, 120, "A sculpture by Auguste Rodin."));
	   artifacts.add(new Artifacts(5, "The Persistence of Memory", ArtifactType.PAINTING, 90, "A surrealist painting by Salvador Dalí."));
	   artifacts.add(new Artifacts(6, "Girl with a Pearl Earring", ArtifactType.PAINTING, 350, "A famous painting by Johannes Vermeer."));
	   artifacts.add(new Artifacts(7, "Virtual Reality Space", ArtifactType.DIGITAL, 5, "An interactive digital artwork that explores virtual spaces."));
	   artifacts.add(new Artifacts(8, "Mona Lisa Reimagined (Digital)", ArtifactType.DIGITAL, 2, "A digital reinterpretation of the famous Mona Lisa."));
	   artifacts.add(new Artifacts(9, "Interactive Digital Landscape", ArtifactType.INTERACTIVE, 1, "An interactive art piece where users can alter the digital landscape."));
	   artifacts.add(new Artifacts(10, "Tactile Sculpture for Blind", ArtifactType.TACTILE, 10, "A sculpture designed for tactile exploration by the visually impaired."));
	   artifacts.add(new Artifacts(11, "Birth of Venus", ArtifactType.PAINTING, 550, "A famous painting by Sandro Botticelli."));
	   artifacts.add(new Artifacts(12, "The Kiss", ArtifactType.SCULPTURE, 110, "A famous sculpture by Auguste Rodin depicting a passionate embrace."));
	   artifacts.add(new Artifacts(13, "The Digital Dawn", ArtifactType.DIGITAL, 3, "A digital art piece illustrating the rise of the digital era."));
	   artifacts.add(new Artifacts(14, "Interactive Touch Painting", ArtifactType.INTERACTIVE, 0, "An interactive painting that responds to touch and changes shape."));
	   artifacts.add(new Artifacts(15, "The Discus Thrower", ArtifactType.SCULPTURE, 2300, "A marble sculpture from Ancient Greece."));
	   artifacts.add(new Artifacts(16, "Night Watch", ArtifactType.PAINTING, 380, "A famous painting by Rembrandt depicting a group of guards."));
	   artifacts.add(new Artifacts(17, "Digital Art from AI", ArtifactType.DIGITAL, 1, "An art piece generated by an artificial intelligence algorithm."));
	   artifacts.add(new Artifacts(18, "Tactile Art for the Blind", ArtifactType.TACTILE, 5, "A tactile artwork designed to be felt by the blind, enhancing sensory experience."));
	   artifacts.add(new Artifacts(19, "Taj Mahal Replica Sculpture", ArtifactType.SCULPTURE, 400, "A tactile sculpture replica of the Taj Mahal."));
	   artifacts.add(new Artifacts(20, "La Guernica", ArtifactType.PAINTING, 85, "A large painting by Pablo Picasso depicting the Spanish Civil War."));
	   artifacts.add(new Artifacts(21, "The Creation of Adam", ArtifactType.PAINTING, 530, "A fresco by Michelangelo in the Sistine Chapel."));
	   artifacts.add(new Artifacts(22, "Digital Graffiti Art", ArtifactType.DIGITAL, 2, "An evolving digital graffiti art piece where people can add their own mark."));
	   artifacts.add(new Artifacts(23, "Sculpture of Liberty", ArtifactType.SCULPTURE, 135, "A replica sculpture of the Statue of Liberty."));
	   artifacts.add(new Artifacts(24, "Interactive Music Visualization", ArtifactType.INTERACTIVE, 1, "An art piece where visualizations change based on the music being played."));
	   artifacts.add(new Artifacts(25, "Abstract Painting #4", ArtifactType.PAINTING, 50, "An abstract painting by a modern artist."));
	   artifacts.add(new Artifacts(26, "The Birth of Venus (Revised)", ArtifactType.PAINTING, 550, "A modern reinterpretation of the classic painting by Botticelli."));
	   artifacts.add(new Artifacts(27, "Virtual Reality Ocean", ArtifactType.DIGITAL, 3, "A digital interactive ocean landscape in virtual reality."));
	   artifacts.add(new Artifacts(28, "Tactile Maze Sculpture", ArtifactType.TACTILE, 5, "A sculpture in the shape of a maze, designed to be navigated by touch."));
	   artifacts.add(new Artifacts(29, "Cycladic Figure", ArtifactType.SCULPTURE, 4500, "An ancient Greek sculpture from the Cycladic islands."));
	   artifacts.add(new Artifacts(30, "Interactive Light Sculpture", ArtifactType.INTERACTIVE, 0, "An artwork made with interactive lights that change when touched."));
	   artifacts.add(new Artifacts(31, "The Scream", ArtifactType.PAINTING, 130, "A famous painting by Edvard Munch that expresses anxiety and existential dread."));
	   artifacts.add(new Artifacts(32, "Digital Neon Art", ArtifactType.DIGITAL, 4, "A vibrant digital artwork inspired by neon lights and modern design."));
	   artifacts.add(new Artifacts(33, "Bust of Nefertiti", ArtifactType.SCULPTURE, 3400, "A sculpture of the ancient Egyptian queen Nefertiti."));
	   artifacts.add(new Artifacts(34, "Interactive Digital Sculpture", ArtifactType.INTERACTIVE, 2, "A digital sculpture that users can modify and interact with using technology."));
	   artifacts.add(new Artifacts(35, "Tactile Ancient Artefacts", ArtifactType.TACTILE, 1000, "A collection of tactile replicas of ancient artefacts for sensory exploration."));
	   artifacts.add(new Artifacts(36, "Digital Street Art", ArtifactType.DIGITAL, 1, "Digital art inspired by street art, displayed on virtual walls."));
   }
   private static void createExhibits() {
	   // Create instances of Exhibits
		// Creating 12 exhibits and adding 3 artifacts to each one.

		   exhibit.add(new Exhibits(1, "Renaissance Art Exhibit", "A collection of classic paintings from the Renaissance period.", new ArrayList<Artifacts>()));
		   exhibit.get(0).getArtifacts().add(artifacts.get(1));  // Mona Lisa
		   exhibit.get(0).getArtifacts().add(artifacts.get(3));  // The Thinker
		   exhibit.get(0).getArtifacts().add(artifacts.get(5));  // The Persistence of Memory

		   exhibit.add(new Exhibits(2, "Modern Art and Digital", "Exploring the fusion of modern art and digital technology.", new ArrayList<Artifacts>()));
		   exhibit.get(1).getArtifacts().add(artifacts.get(7));  // Virtual Reality Space
		   exhibit.get(1).getArtifacts().add(artifacts.get(13)); // Digital Art from AI
		   exhibit.get(1).getArtifacts().add(artifacts.get(19)); // La Guernica

		   exhibit.add(new Exhibits(3, "Interactive Art Experience", "An exhibit where visitors can interact with the artwork.", new ArrayList<Artifacts>()));
		   exhibit.get(2).getArtifacts().add(artifacts.get(14)); // Interactive Touch Painting
		   exhibit.get(2).getArtifacts().add(artifacts.get(24)); // Interactive Music Visualization
		   exhibit.get(2).getArtifacts().add(artifacts.get(34)); // Interactive Digital Sculpture

		   exhibit.add(new Exhibits(4, "Tactile Art for the Visually Impaired", "A tactile art exhibit designed to be experienced by touch.", new ArrayList<Artifacts>()));
		   exhibit.get(3).getArtifacts().add(artifacts.get(10)); // Tactile Sculpture for Blind
		   exhibit.get(3).getArtifacts().add(artifacts.get(18)); // Tactile Art for the Blind
		   exhibit.get(3).getArtifacts().add(artifacts.get(25)); // Tactile Ancient Artefacts

		   exhibit.add(new Exhibits(5, "Famous Sculptures", "A display of some of the world's most famous sculptures.", new ArrayList<Artifacts>()));
		   exhibit.get(4).getArtifacts().add(artifacts.get(3));  // The Thinker
		   exhibit.get(4).getArtifacts().add(artifacts.get(15)); // The Discus Thrower
		   exhibit.get(4).getArtifacts().add(artifacts.get(33)); // Bust of Nefertiti

		   exhibit.add(new Exhibits(6, "Surrealism Exhibit", "Delving into the world of surrealism through art.", new ArrayList<Artifacts>()));
		   exhibit.get(5).getArtifacts().add(artifacts.get(5));  // The Persistence of Memory
		   exhibit.get(5).getArtifacts().add(artifacts.get(12)); // The Kiss
		   exhibit.get(5).getArtifacts().add(artifacts.get(27)); // Virtual Reality Ocean

		   exhibit.add(new Exhibits(7, "Ancient Artifacts", "Explore artifacts from ancient civilizations around the world.", new ArrayList<Artifacts>()));
		   exhibit.get(6).getArtifacts().add(artifacts.get(19)); // La Guernica
		   exhibit.get(6).getArtifacts().add(artifacts.get(9));  // The Digital Dawn
		   exhibit.get(6).getArtifacts().add(artifacts.get(33)); // Bust of Nefertiti

		   exhibit.add(new Exhibits(8, "Digital Revolution", "The evolution of art through digital media.", new ArrayList<Artifacts>()));
		   exhibit.get(7).getArtifacts().add(artifacts.get(7));  // Virtual Reality Space
		   exhibit.get(7).getArtifacts().add(artifacts.get(13)); // Digital Art from AI
		   exhibit.get(7).getArtifacts().add(artifacts.get(22)); // Digital Graffiti Art

		   exhibit.add(new Exhibits(9, "Classical Art", "Classical works of art from history's great masters.", new ArrayList<Artifacts>()));
		   exhibit.get(8).getArtifacts().add(artifacts.get(1));  // Mona Lisa
		   exhibit.get(8).getArtifacts().add(artifacts.get(15)); // The Discus Thrower
		   exhibit.get(8).getArtifacts().add(artifacts.get(25)); // Tactile Ancient Artefacts

		   exhibit.add(new Exhibits(10, "Pop Art and Modernism", "A look at the bold and vibrant art styles of the modern world.", new ArrayList<Artifacts>()));
		   exhibit.get(9).getArtifacts().add(artifacts.get(5));  // The Persistence of Memory
		   exhibit.get(9).getArtifacts().add(artifacts.get(23)); // Sculpture of Liberty
		   exhibit.get(9).getArtifacts().add(artifacts.get(32)); // Digital Neon Art

		   exhibit.add(new Exhibits(11, "Interactive Sculptures", "A collection of sculptures that visitors can engage with.", new ArrayList<Artifacts>()));
		   exhibit.get(10).getArtifacts().add(artifacts.get(14)); // Interactive Touch Painting
		   exhibit.get(10).getArtifacts().add(artifacts.get(24)); // Interactive Music Visualization
		   exhibit.get(10).getArtifacts().add(artifacts.get(34)); // Interactive Digital Sculpture

		   exhibit.add(new Exhibits(12, "Virtual Art Space", "Art and digital media come together in this immersive exhibit.", new ArrayList<Artifacts>()));
		   exhibit.get(11).getArtifacts().add(artifacts.get(7));  // Virtual Reality Space
		   exhibit.get(11).getArtifacts().add(artifacts.get(19)); // La Guernica
		   exhibit.get(11).getArtifacts().add(artifacts.get(27)); // Virtual Reality Ocean
		   
		// Add Route Steps to Exhibit 1
		   exhibit.get(0).addRouteStep(new Route(artifacts.get(1), "View Mona Lisa - A famous painting by Leonardo da Vinci."));
		   exhibit.get(0).addRouteStep(new Route(artifacts.get(3), "View The Thinker - A sculpture by Auguste Rodin."));
		   exhibit.get(0).addRouteStep(new Route(artifacts.get(5), "View The Persistence of Memory - A surrealist painting by Salvador Dalí."));

		   // Add Route Steps to Exhibit 2
		   exhibit.get(1).addRouteStep(new Route(artifacts.get(7), "View Virtual Reality Space - A digital artwork experience."));
		   exhibit.get(1).addRouteStep(new Route(artifacts.get(13), "View Digital Art from AI - A display of AI-created art."));
		   exhibit.get(1).addRouteStep(new Route(artifacts.get(19), "View La Guernica - A powerful political piece by Picasso."));

		   // Add Route Steps to Exhibit 3
		   exhibit.get(2).addRouteStep(new Route(artifacts.get(14), "View Interactive Touch Painting - Engage with a digital painting through touch."));
		   exhibit.get(2).addRouteStep(new Route(artifacts.get(24), "View Interactive Music Visualization - Experience music through visual art."));
		   exhibit.get(2).addRouteStep(new Route(artifacts.get(34), "View Interactive Digital Sculpture - Interact with digital sculptures in real time."));

		   // Add Route Steps to Exhibit 4
		   exhibit.get(3).addRouteStep(new Route(artifacts.get(10), "View Tactile Sculpture for Blind - Experience art by touch."));
		   exhibit.get(3).addRouteStep(new Route(artifacts.get(18), "View Tactile Art for the Blind - Artwork designed for tactile exploration."));
		   exhibit.get(3).addRouteStep(new Route(artifacts.get(25), "View Tactile Ancient Artefacts - Ancient sculptures to explore by touch."));

		   // Add Route Steps to Exhibit 5
		   exhibit.get(4).addRouteStep(new Route(artifacts.get(3), "View The Thinker - A famous sculpture by Auguste Rodin."));
		   exhibit.get(4).addRouteStep(new Route(artifacts.get(15), "View The Discus Thrower - A famous ancient Greek sculpture."));
		   exhibit.get(4).addRouteStep(new Route(artifacts.get(33), "View Bust of Nefertiti - A renowned sculpture of the ancient Egyptian queen."));

		   // Add Route Steps to Exhibit 6
		   exhibit.get(5).addRouteStep(new Route(artifacts.get(5), "View The Persistence of Memory - A surrealist painting by Salvador Dalí."));
		   exhibit.get(5).addRouteStep(new Route(artifacts.get(12), "View The Kiss - A painting by Gustav Klimt, full of emotion."));
		   exhibit.get(5).addRouteStep(new Route(artifacts.get(27), "View Virtual Reality Ocean - A VR artwork depicting the ocean."));

		   // Add Route Steps to Exhibit 7
		   exhibit.get(6).addRouteStep(new Route(artifacts.get(19), "View La Guernica - Picasso's anti-war masterpiece."));
		   exhibit.get(6).addRouteStep(new Route(artifacts.get(9), "View The Digital Dawn - A futuristic digital artwork."));
		   exhibit.get(6).addRouteStep(new Route(artifacts.get(33), "View Bust of Nefertiti - The famous Egyptian sculpture."));

		   // Add Route Steps to Exhibit 8
		   exhibit.get(7).addRouteStep(new Route(artifacts.get(7), "View Virtual Reality Space - A digital art experience."));
		   exhibit.get(7).addRouteStep(new Route(artifacts.get(13), "View Digital Art from AI - Artificial intelligence-generated art."));
		   exhibit.get(7).addRouteStep(new Route(artifacts.get(22), "View Digital Graffiti Art - A modern take on graffiti in digital form."));

		   // Add Route Steps to Exhibit 9
		   exhibit.get(8).addRouteStep(new Route(artifacts.get(1), "View Mona Lisa - A timeless portrait by Leonardo da Vinci."));
		   exhibit.get(8).addRouteStep(new Route(artifacts.get(15), "View The Discus Thrower - A classic example of ancient Greek art."));
		   exhibit.get(8).addRouteStep(new Route(artifacts.get(25), "View Tactile Ancient Artefacts - Artifacts designed to be felt rather than seen."));

		   // Add Route Steps to Exhibit 10
		   exhibit.get(9).addRouteStep(new Route(artifacts.get(5), "View The Persistence of Memory - A surrealist painting by Salvador Dalí."));
		   exhibit.get(9).addRouteStep(new Route(artifacts.get(23), "View Sculpture of Liberty - A symbolic sculpture of freedom."));
		   exhibit.get(9).addRouteStep(new Route(artifacts.get(32), "View Digital Neon Art - A vibrant, glowing digital artwork."));

		   // Add Route Steps to Exhibit 11
		   exhibit.get(10).addRouteStep(new Route(artifacts.get(14), "View Interactive Touch Painting - A digital painting you can touch and change."));
		   exhibit.get(10).addRouteStep(new Route(artifacts.get(24), "View Interactive Music Visualization - Visualize music in a dynamic art form."));
		   exhibit.get(10).addRouteStep(new Route(artifacts.get(34), "View Interactive Digital Sculpture - An art piece that responds to your interactions."));

		   // Add Route Steps to Exhibit 12
		   exhibit.get(11).addRouteStep(new Route(artifacts.get(7), "View Virtual Reality Space - Immerse yourself in a virtual world."));
		   exhibit.get(11).addRouteStep(new Route(artifacts.get(19), "View La Guernica - Picasso's protest against war."));
		   exhibit.get(11).addRouteStep(new Route(artifacts.get(27), "View Virtual Reality Ocean - A deep-sea immersive VR experience."));

   }
   private static void createAnnualPlan() {
	   // Populate Annual Plan with some exhibits
	   
	// Assuming annualPlan is an instance of a class that has the addExhibit method
	   annualPlan.addExhibit(1, 0, exhibit.get(0));  // Hall 1, January - Renaissance Art Exhibit
	   annualPlan.addExhibit(1, 1, exhibit.get(1));  // Hall 1, February - Modern Art and Digital
	   annualPlan.addExhibit(1, 2, exhibit.get(2));  // Hall 1, March - Interactive Art Experience
	   annualPlan.addExhibit(1, 3, exhibit.get(3));  // Hall 1, April - Tactile Art for the Visually Impaired
	   annualPlan.addExhibit(1, 4, exhibit.get(4));  // Hall 1, May - Famous Sculptures
	   annualPlan.addExhibit(1, 5, exhibit.get(5));  // Hall 1, June - Surrealism Exhibit
	   annualPlan.addExhibit(2, 6, exhibit.get(6));  // Hall 2, July - Ancient Artifacts
	   annualPlan.addExhibit(2, 7, exhibit.get(7));  // Hall 2, August - Digital Revolution
	   annualPlan.addExhibit(2, 8, exhibit.get(8));  // Hall 2, September - Classical Art
	   annualPlan.addExhibit(2, 9, exhibit.get(9));  // Hall 2, October - Pop Art and Modernism
	   annualPlan.addExhibit(3, 10, exhibit.get(10)); // Hall 3, November - Interactive Sculptures
	   annualPlan.addExhibit(3, 11, exhibit.get(11)); // Hall 3, December - Virtual Art Space
	   annualPlans.add(annualPlan);

   }
   // method to handle the input from the menu system and also move the user to the corresponding menu they select
   private static boolean processChoice(int choice) {
      boolean quit = false;
      switch (choice) {
      case 1:
         manageArtifacts();
         break;
      case 2:
         manageExhibits();
         break;
      case 3:
         manageAnnualSchedule();
         break;
      case 4:
    	  QUBMediaMuseum.console.dispose();
         quit = true;
         break;
      default:
         console.println("Invalid choice. Please try again.");
         break;
      }
      return quit;
   }
   
   private static void addArtifact() {
      Artifacts.addArtifact(artifacts);
   }
   
   private static void updateArtifact() {
      Artifacts.updateArtifact(artifacts);
   }

   private static void deleteArtifact() {
      Artifacts.deleteArtifact(artifacts);
   }
   
   public static void viewArtifacts() {
	   Artifacts.viewArtifacts(artifacts,exhibit);
   }

   private static void manageExhibits() {
      console.println("Managing Exhibits...");
      boolean RepeatLoop = true;
      while (RepeatLoop == true) {
         try {
            console.print("1: Add an Exhibit\n2: Update an existing exhibit\n3: Delete an exisitng exhibit\n4: View all exhibits\n" +
               "5: Back to Main Menu\nEnter your choice: ");
            String str = QUBMediaMuseum.console.readLn();
            int Selection = Integer.parseInt(str);

            if (Selection == 1) {
               AddExhibit();
            } else if (Selection == 2) {
               updateExhibit();
            } else if (Selection == 3) {
               deleteExhibit();
            } else if (Selection == 4) {
            	viewExhibits();
            } else if (Selection == 5) {
               break;
            }
         } catch (Exception E) {
            console.println("Please only enter a number 1 - 5\n");
            console.readLn();
         }
      }
   }
   private static void AddExhibit() {
	    Exhibits.AddExhibit(exhibit, artifacts);
	}
   private static void updateExhibit() {
	    Exhibits.updateExhibit(exhibit, artifacts);
	}

   private static void deleteExhibit() {
      Exhibits.deleteExhibit(exhibit);
   }
   public static void viewExhibits() {
	   Exhibits.searchExhibits(exhibit, artifacts);
	}
   private static void initializeYears() {
       // Start by adding the first year (2024)
       AnnualPlan firstYear = new AnnualPlan(0);
       annualPlans.add(firstYear);
   }

   private static void createNewYear() {
       // Calculate the new year based on the existing years in the list
       int newYearOffset = annualPlans.size(); // Offset determines the new year based on how many years exist
       AnnualPlan newAnnualPlan = new AnnualPlan(newYearOffset);
       annualPlans.add(newAnnualPlan);
       console.println("New year (" + newAnnualPlan.getYearName() + ") created successfully!");
   }
   

   private static void manageAnnualSchedule() {
	    console.println("Managing Annual Schedule...");
	    boolean loop = true;

	    while (loop) {
	        // Display available years for the user
	        console.println("Which Year would you like to use?");
	        console.println("Available Years:");
	        for (int i = 0; i < annualPlans.size(); i++) {
	            console.println((i + 1) + ": " + annualPlans.get(i).getYearName());
	        }
	        console.println((annualPlans.size() + 1) + ": Create a new year");
	        console.println((annualPlans.size() + 2) + ": Go Back to Main Menu");  // Option to go back to the main menu

	        console.print("Enter your choice: ");
	        
	        String str = QUBMediaMuseum.console.readLn();
            int choice = Integer.parseInt(str);

	        if (choice >= 1 && choice <= annualPlans.size()) {
	            // If user selects an existing year
	            AnnualPlan selectedYear = annualPlans.get(choice - 1);
	            manageExhibitsInYear(selectedYear);
	        } else if (choice == annualPlans.size() + 1) {
	            // If user wants to create a new year
	            createNewYear();
	        } else if (choice == annualPlans.size() + 2) {
	            // Go back to the main menu
	            loop = false;
	            console.println("Returning to the main menu...");
	        } else {
	            console.println("Invalid choice. Please try again.");
	        }
	    }
	}


   private static void manageExhibitsInYear(AnnualPlan annualPlan) {
       boolean loop = true;

       while (loop) {
           console.println("Managing Exhibits in " + annualPlan.getYearName() + "...");
           console.print("1: Add Exhibit to Schedule\n2: View Schedule\n3: Remove Exhibit from Schedule\n4: Delete the annual plan \n5: Exit\nEnter your choice: ");
           String str = QUBMediaMuseum.console.readLn();
           int choice = Integer.parseInt(str);

           switch (choice) {
               case 1:
                   AnnualPlan.addExhibitToSchedule(annualPlan, exhibit);
                   break;
               case 2:
                   AnnualPlan.viewSchedule(annualPlan);
                   break;
               case 3:
                   AnnualPlan.removeExhibitFromSchedule(annualPlan);
                   break;
               case 4:
            	   AnnualPlan.deleteAnnualPlan(annualPlan, annualPlans);
            	   loop = false;
                   break;
               case 5: 
            	   loop = false;
            	   break;
               default:
                   console.println("Invalid choice. Please try again.");
           }
       }
   }



   private static void addExhibitToSchedule() {
      AnnualPlan.addExhibitToSchedule(annualPlan, exhibit);
   }

   private static void viewSchedule() {
	   AnnualPlan.viewSchedule(annualPlan);
	}


   private static void removeExhibitFromSchedule() {
	   AnnualPlan.removeExhibitFromSchedule(annualPlan);
   }

	   private static void loadImages(int firstNum, int lastNum) {
		    // Adjust the images array size based on the range
		    images = new ImageIcon[lastNum - firstNum + 1];

		    // Loop over the artifacts in the selected range
		    for (int i = 0; i < images.length; i++) {  // Loop through the images array
		        int artifactId = firstNum + i;  // Calculate artifact ID based on the range
		        Artifacts artifact = artifacts.get(artifactId - 1);  // Access the artifact (1-based to 0-based)

		        // Construct the image path based on the artifact ID
		        String imagePath = "/images/" + artifactId + ".png";
		        
		        try {
		            // Try to load the image
		            images[i] = new ImageIcon(QUBMediaMuseum.class.getResource(imagePath));
		        } catch (Exception e) {
		            // If the image doesn't exist, set the default "NoImage" image
		            images[i] = new ImageIcon(QUBMediaMuseum.class.getResource("/images/NoImage.png"));
		        }
		    }
		}

	   // Method to display the current image

	   private static void displayImage() {
		    if (images != null && images.length > 0 && images[currentImageIndex] != null) {
		        console.println("Displaying image " + (currentImageIndex + 1) + " of " + images.length);
		        console.println(images[currentImageIndex]);  // This would display the image in your GUI

		        // Correct artifactId calculation to ensure it starts from 'firstNum'
		        int artifactId = firstNum + currentImageIndex;  
		        Artifacts artifact = artifacts.get(artifactId - 1);  
		        
		        // Display artifact details
		        console.println("Artifact ID: " + artifact.getId());
		        console.println("Name: " + artifact.getName());
		        console.println("Description: " + artifact.getDescription());
		    } else {
		        console.println("No image available for this artifact.");
		    }
		}


	   private static void nextImage() {
		    currentImageIndex++;  // Move to the next image

		    // If we reached the end of the array, loop back to the start
		    if (currentImageIndex >= images.length) {
		        currentImageIndex = 0;
		    }

		    displayImage();  // Display the next image
		}

		private static void previousImage() {
		    currentImageIndex--;  // Move to the previous image

		    // If we reached the beginning of the array, loop back to the end
		    if (currentImageIndex < 0) {
		        currentImageIndex = images.length - 1;
		    }

		    displayImage();  // Display the previous image
		}



		public static void ManageArtifactImages() {
		    console.print("Artifact Image manager...");
		    boolean RepeatLoop = true;
		    int selection;

		    // Initialize images once before entering the loop
		    initializeImages(); 

		    // Continue looping for user choices until they choose to exit (option 4)
		    while (RepeatLoop) {
		        try {
		            // Prompt the user for their choice
		            console.println("\n\n1: View A selected number of Artifacts\n2: Add an image to an Artifact\n3: Delete an Image from an artifact\n4: Go back to Artifact Menu\nPlease enter your choice: ");
		            String input = console.readLn();

		            // Try to parse the input as an integer
		            selection = Integer.parseInt(input);

		            // Handle different user choices based on the selection
		            if (selection == 1) {
		                viewImages();  // Implement this to show images
		            } else if (selection == 2) {
		                addImagePrompt(); // The user is adding an image
		            } else if (selection == 3) {
		            	deleteImagePrompt(); // Implement this to delete images
		            } else if (selection == 4) {
		                console.println("Exiting Artifact Image Manager and returning to the Artifact Menu...");
		                RepeatLoop = false; // Exit the loop and go back to the Artifact Menu
		            } else {
		                console.println("Invalid choice. Please enter a number between 1 and 4.");
		            }
		        } catch (NumberFormatException e) {
		            // Handle the case where the user enters a non-integer value
		            console.println("Invalid input. Please enter a valid number between 1 and 4.");
		        } catch (Exception e) {
		            // Catch any other exceptions
		            console.println("An unexpected error occurred: " + e.getMessage());
		        }
		    }
		}
		public static void deleteImagePrompt() {
		    // Displaying the instructions to the user for deleting an image
		    console.println("To Delete an image follow the process below;\n"
		    		+ "Start with locating the image you wish to delete you can use the view images to ensure you know which image you desire to delete"
		    		+ "\nNext will you need to locate the images folder, which is inside the src folder"
		    		+ "\nAfter going in to the folder look for the image with the name as the artifact id you wish to delete"
		    		+ "\nYou can then right click and delete the image");
		}




	   public static void addImagePrompt() {
		    console.println("To add an image first ensure the image is no more than 400x 400 in resolution in order to display it."
		    		+ "\n To add an image you must first go to your documents and search for the src file within this program.\n"
		    		+ "Next you will want to double click into images and then paste your image into the folder."
		    		+ "To ensure the image corresponds to the artifact please ensure the name is in this format\n"
		    		+ "{artifact id}.png ");
		}



	   






	   
	   public static void viewImages() {
		    initializeImages();  // Re-initialize and load images dynamically

		    // Prompt user for the first and last image numbers
		    while (true) {
		        console.print("Please select the starting image (1 - " + artifacts.size() + "): ");
		        String first = console.readLn();
		        try {
		            firstNum = Integer.parseInt(first);
		            if (firstNum >= 1 && firstNum <= artifacts.size()) {
		                break;
		            } else {
		                console.println("Invalid number. Please select a valid starting image.");
		            }
		        } catch (NumberFormatException e) {
		            console.println("Invalid input. Please enter a valid number.");
		        }
		    }

		    while (true) {
		        console.print("Please select the final image (" + firstNum + " - " + artifacts.size() + "): ");
		        String last = console.readLn();
		        try {
		            lastNum = Integer.parseInt(last);
		            if (lastNum >= firstNum && lastNum <= artifacts.size()) {
		                break;
		            } else {
		                console.println("Invalid number. Please select a valid ending image.");
		            }
		        } catch (NumberFormatException e) {
		            console.println("Invalid input. Please enter a valid number.");
		        }
		    }

		    loadImages(firstNum, lastNum);  // Load the images for the selected range

		    currentImageIndex = 0;  // Start at the first image
		    displayImage();

		    // Allow user to navigate through the images
		    Scanner scanner = new Scanner(System.in);
		    while (true) {
		        console.println("\nType 'N' to view the next image, 'P' for previous, or 'q' to quit.");
		        String userInput = console.readLn();

		        if (userInput.equalsIgnoreCase("N")) {
		            nextImage();  // Show the next image
		        } else if (userInput.equalsIgnoreCase("P")) {
		            previousImage();  // Show the previous image
		        } else if (userInput.equalsIgnoreCase("q")) {
		            console.println("Exiting image viewer...");
		            break;
		        }
		    }
		}
	   public static void showLoadingScreen(String message, int durationInSeconds) {
		    int totalSteps = 60; // Total steps for the loading bar
		    int sleepTime = (durationInSeconds * 100) / totalSteps; // Time for each step in milliseconds

		    // Clear the console
		    console.clear();
		    console.println(message);
		    console.println("\n"); // Add a blank line for the loading bar
		    // Start the loading animation
		    for (int i = 0; i <= totalSteps; i++) {
		        // Build the loading bar string
		        StringBuilder loadingBar = new StringBuilder("[");
		        for (int j = 0; j < totalSteps; j++) {
		            if (j < i) {
		                loadingBar.append("*"); // Filled part of the bar
		            } else {
		                loadingBar.append(" "); // Unfilled part of the bar
		            }
		        }
		        loadingBar.append("]"); // End of the bar

		        // Calculate and append the percentage
		        int percentage = (i * 100) / totalSteps;

		        // Clear the previous line and reprint the loading bar
		        console.clear();
		        console.println(message + "\n");
		        console.println(loadingBar.toString() + "\n\n		     		   " + percentage + "%");

		        // Pause for the step duration
		        try {
		            Thread.sleep(sleepTime); // Pause for the step duration
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		    
		    // Finish with a message
		    console.println("\nLoading complete!\n\n");
		}

		// Display the museum image in the console
	   public static void displayMuseumImage() {
	       if (museumImage != null) {
	           console.clear();
	           console.println(museumImage); // Display the image on the console
	           console.println("\n");		       }
	       else {
	           console.println("Museum image not found!");
	       }
	   }
	   private static void manageArtifacts() {
		    console.println("Managing Artifacts...");
		    boolean repeatLoop = true;

		    // Initialize images array here to avoid NullPointerException later
		    while (repeatLoop) {
		        int selection = -1; // Default to an invalid value to trigger input until correct
		        try {
		            console.print("\n\n1: Add a new Artifact\n2: Update an existing Artifact\n3: Delete an existing Artifact" +
		                    "\n4: Search for Artifacts\n5: Manage Artifacts Images\n6: Back to main menu\nPlease enter your choice: ");
		            String input = console.readLn(); // Read input from user
		            selection = Integer.parseInt(input); // Try parsing the input as an integer

		            if (selection < 1 || selection > 6) { // Validate the selection range
		                console.println("Invalid input. Please only enter a number between 1 and 6.");
		                continue; // If out of range, continue asking for input
		            }

		            // Handle valid selections
		            switch (selection) {
		                case 1:
		                    addArtifact(); // Call method to add a new artifact
		                    break;
		                case 2:
		                    updateArtifact(); // Call method to update an artifact
		                    break;
		                case 3:
		                    deleteArtifact(); // Call method to delete an artifact
		                    break;
		                case 4:
		                    viewArtifacts(); // Call method to view artifacts
		                    break;
		                case 5:
		                    ManageArtifactImages(); // Call method to manage artifact images
		                    break;
		                case 6:
		                    console.println("Returning to main menu...");
		                    repeatLoop = false; // Exit loop and return to main menu
		                    break;
		            }

		        } catch (NumberFormatException e) {
		            // Catch invalid input (non-integer value)
		            console.println("Invalid input. Please enter a number between 1 and 6.");
		        }
		    }
		}

}
