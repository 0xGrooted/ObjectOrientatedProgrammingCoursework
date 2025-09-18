package part03;

import java.util.ArrayList;

public class Exhibits {
    private int id; // A unique ID to identify each exhibit
    private String name; // A name which resembles the Exhibits name
    private String description; // The description of the Exhibit
    private ArrayList<Artifacts> artifacts; // The ArrayList of artifacts which are in the Exhibit
    private ArrayList<Route> route;  // The ArrayList of routes within the exhibit
    
    /** A constructor for the Exhibits class - used to add the Exhibit prior to creating the route steps
     * 
     * @param id
     * @param name
     * @param description
     * @param artifactsToAdd
     */
    public Exhibits(int id, String name, String description, ArrayList<Artifacts> artifactsToAdd) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setArtifacts(artifactsToAdd);
        this.route = new ArrayList<>();
    }
    /** A constructor for the Exhibits class - used to add the routes to the exhibit
     * 
     * @param id - Identify the exhibit by a unique ID
     * @param name - The name of the exhibit
     * @param description - The description of the exhibit
     * @param artifactsToAdd - The artifact to add to the exhibit
     * @param routes - The routes within the exhibit
     */
    public Exhibits(int id, String name, String description, ArrayList<Artifacts> artifactsToAdd, ArrayList<Route> routes) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.artifacts = artifactsToAdd;
        this.route = routes;
    }

    /** Add route step to the arrayList Route
     * 
     * @param routes - The instance of the route should be passed in, each route will be added to overall routes ArrayList 
     */
    public void addRouteStep(Route routes) {
    	route.add(routes);
    }
    /** Remove a route from an associated Artifact ArrayList
     * 
     * @param artifact - Route to be removed
     */
    public void removeRoute(Artifacts artifact) {
        for (int i = 0; i < this.route.size(); i++) {
            if (this.route.get(i).getArtifact().equals(artifact)) {
                this.route.remove(i);
                break;
            }
        }
    }



		/** Method to add an artifact to the exhibit
		 * 
		 * @param artifact - The artifacts which will be added to the exhibit
		 */
	    public void addArtifact(Artifacts artifact) {
	        artifacts.add(artifact);
	    }

	    /** Removal of an Artifact 
	     * 
	     * @param artifact - The artifact Instance to be removed from the Exhibit
	     */
	    public void removeArtifact(Artifacts artifact) {
	        artifacts.remove(artifact);
	    }

	    /** Method to calculate the total engagement time of all of the artifacts of an exhibit
	     * 
	     * @return  - totalEngagementTime (the total time to spend at the Exhibit
	     */
	    public int getTotalEngagementTime() {
	        int totalEngagementTime = 0;
	        if (this.artifacts != null) {
	            for (Artifacts artifact : this.artifacts) {
	                if (artifact != null) {
	                    QUBMediaMuseum.console.println("Artifact: " + artifact.getName() + ", Engagement Time: " + artifact.getEngagementTime());
	                    totalEngagementTime += artifact.getEngagementTime();
	                } else {
	                    QUBMediaMuseum.console.println("Null artifact found in the exhibit!");
	                }
	            }
	        }
	        return totalEngagementTime;
	    }

	    /** Getter for exhibit ID
	     * 
	     * @return the ID of the Exhibit
	     */
	    public int getID() {
	        return id;
	    }

	    /** Setter for exhibit ID with validation ( >=0 )
	     * 
	     * @param id - the ID to be validated and set
	     */
	    public void setId(int id) {
	        if (id >= 0) {
	            this.id = id;
	        } else {
	            QUBMediaMuseum.console.println("Invalid ID. ID must be a non-negative integer.");
	        }
	    }

	    /** Getter for exhibit name
	     * 
	     * @return - Name
	     */
	    public String getName() {
	        return name;
	    }

	    /** Setter for exhibit name with validation ( not empty or null )
	     * 
	     * @param name - Name to be validated and either set or forgotten
	     */
	    public void setName(String name) {
	        if (name != null && !name.trim().isEmpty()) {
	            this.name = name;
	        } else {
	            QUBMediaMuseum.console.println("Invalid name. Name cannot be empty or null.");
	            this.name = "Unknown Exhibit";  
	        }
	    }

	    /** Getter for the Description of the Exhibit
	     * 
	     * @return - Description
	     */
	    public String getDescription() {
	        return description;
	    }

	    /** Setter for exhibit description with validation
	     * 
	     * @param description - Description to be validated and either set or removed
	     */
	    public void setDescription(String description) {
	        if (description != null && !description.trim().isEmpty()) {
	            this.description = description;
	        } else {
	            QUBMediaMuseum.console.println("Invalid description. Description cannot be empty or null.");
	            this.description = "N/A";  // Default description
	        }
	    }

	    /** Getter for the Artifact's ArrayList within the Exhibit 
	     * 
	     * @return - Artifacts within the Exhibit
	     */
	    public ArrayList<Artifacts> getArtifacts() {
	        return artifacts;
	    }

	    /** Setter for artifacts in the exhibit with validation
	     * 
	     * @param artifacts1 - set the Artifacts to have the passed in Artifacts instance
	     */
	    public void setArtifacts(ArrayList<Artifacts> artifacts1) {
	        if (artifacts1 != null) {  
	            this.artifacts = artifacts1;  
	        } else {
	            QUBMediaMuseum.console.println("Invalid artifact list. Setting artifacts to an empty list.");
	            this.artifacts = new ArrayList<Artifacts>();  
	        }
	    }
	    /** Method to display exhibit details
	     * 
	     */
	    public void displayExhibitDetails() {
	        QUBMediaMuseum.console.println("Exhibit ID: " + this.id);
	        QUBMediaMuseum.console.println("Exhibit Name: " + this.name);
	        QUBMediaMuseum.console.println("Description: " + this.description);
	        QUBMediaMuseum.console.println("Total Engagement Time: " + getTotalEngagementTime() + " minutes");
	        
	        if (this.artifacts != null) {
	            QUBMediaMuseum.console.println("Artifacts in this exhibit:");
	            for (Artifacts artifact : this.artifacts) {
	                if (artifact != null) {
	                    artifact.displaySimpleArtifactDetails();
	                } else {
	                    QUBMediaMuseum.console.println("Null artifact found in the exhibit!");
	                }
	            }
	        } else {
	            QUBMediaMuseum.console.println("No artifacts in this exhibit.");
	        }
	    }
	    /** Display Exhibit Details in a short format including only ID and Name
	     * 
	     */
	    public void simpleExhibitDetails() {
	    	QUBMediaMuseum.console.println("Exhibit ID: " + id);
	        QUBMediaMuseum.console.println("Exhibit Name: " + name);
	       
	    }
	    /** Find the next available ID in the Array List of exhibits passed in
	     * 
	     * @param exhibits - the Array List of the exhibits which will be compared with 
	     * @return - The next available ID (lowest possible id)
	     */
	    public static int nextID(ArrayList<Exhibits> exhibits) {
	    	int nextID =exhibits.size()+1;
	    	for(int i =0;i<exhibits.size()-1;i++) {
	    		if(exhibits.get(i+1).getID() - exhibits.get(i).getID() > 1) {
	    			return nextID = exhibits.get(i).getID() + 1;
	    		}
	    	}
			return nextID;
	    }
	    /** Display All of the exhibits in an ArrayList of exhibits
	     * 
	     * @param exhibit - The ArrayList to be looped through each exhibit will be displayed.
	     */
	    public static void displayAllExhibits(ArrayList<Exhibits>exhibit) {
	        for (int i = 0; i < exhibit.size(); i++) {
	           exhibit.get(i).displayExhibitDetails();
	        }
	     }
	    /** Search for part of an exhibits name i.e "Mona" will show "Mona Lisa"
	     * 
	     * @param str - The search query
	     * @param exhibit - the ArrayList which will be looked through to find a match for the name
	     */
	     public static void searchPartName(String str,ArrayList<Exhibits>exhibit) {
	     	for(int i =0;i<exhibit.size();i++) {
	     		if(exhibit.get(i).name.contains(str)) {
	     			exhibit.get(i).displayExhibitDetails();
	     		}
	     	}
	     }
	     /** Search for an exact match of a name, i.e "Mona Lisa" for "Mona Lisa"
	      * 
	      * @param str - The search query to be compared
	      * @param exhibit - The ArrayList which will be looked through to find an exact match for the Exhibits name
	      */
	     public static void searchName(String str, ArrayList<Exhibits>exhibit) {
	         boolean found = false;
	         for (int i = 0; i < exhibit.size(); i++) {
	             if (exhibit.get(i).name.equalsIgnoreCase(str)) {
	            	 exhibit.get(i).displayExhibitDetails();
	                 found = true;
	             }
	         }
	         if (!found) {
	             QUBMediaMuseum.console.println("No artifact found with the name: " + str);
	         }
	     }
	     /** Search for an ID within the Exhibit Array List, If found the details will be displayed
	      * 
	      * @param id - The ID to be found within the ArrayList
	      * @param exhibit - The ArrayList to be compared with the ID
	      */
	     public static Exhibits searchByID(int id, ArrayList<Exhibits> exhibit) {
	    	    for (Exhibits ex : exhibit) { 
	    	        if (ex.getID() == id) { 
	    	            ex.displayExhibitDetails(); 
	    	            return ex; 
	    	        }
	    	    }
	    	    QUBMediaMuseum.console.println("No exhibit found with the ID: " + id);
	    	    return null; 
	    	}
	     /** Search for an Artifact by it's type through the Exhibit's ArrayList
	      * 
	      * @param type - The type to be found.
	      * @param exhibits - the ArrayList to be compared with the Type.
	      */
	     public static void searchType(ArtifactType type, ArrayList<Exhibits> exhibits) {
	    	    boolean found = false;

	    	    for (Exhibits exhibit : exhibits) {
	    	        boolean hasType = false;

	    	        for (Artifacts artifact : exhibit.getArtifacts()) {
	    	            if (artifact.getType() == type) {
	    	                hasType = true;
	    	                break;
	    	            }
	    	        }
	    	        if (hasType) {
	    	            exhibit.displayExhibitDetails();
	    	            found = true;
	    	        }
	    	    }
	    	    if (!found) {
	    	        QUBMediaMuseum.console.println("No exhibits found containing artifacts of type: " + type);
	    	    }
	    	}

	     /** Bubble sort the exhibits ArrayList by comparing the names, will sort alphabetically
	      * 
	      * @param list
	      */
	     public static void bubbleSort(ArrayList<Exhibits>list) {
	    	 // Using a bubble sort method allow the list of exhibits to be sorted alphabetically
	         int n = list.size();
	         boolean swapped;
	         for (int i = 0; i < n - 1; i++) {
	             swapped = false;
	             for (int j = 0; j < n - 1 - i; j++) {
	                 if (list.get(j).getName().compareTo(list.get(j + 1).getName()) > 0) {
	                     Exhibits temp = list.get(j);
	                     list.set(j, list.get(j + 1));
	                     list.set(j + 1, temp);

	                     swapped = true;
	                 }
	             }
	             if (!swapped) break;
	         }
	     }
	     /** Method to display all route steps for the exhibit
	      * 
	      */
	     public void displayRoutes() {
	    	    if (route == null || route.isEmpty()) {
	    	        QUBMediaMuseum.console.println("No routes assigned for this exhibit.");
	    	        return;
	    	    }
	    	    QUBMediaMuseum.console.println("Routes for Exhibit: " + name);
	    	    for (int i = 0; i < route.size(); i++) {
	    	        Route routeStep = route.get(i);
	    	        QUBMediaMuseum.console.println("Route Number: " + (i + 1) + ", Sign: " + routeStep.getSign());
	    	    }
	    	}
	     /** Sort all of the Exhibits by ID [typically used in order to find the next available ID]
	      * 
	      * @param exhibit - The ArrayList to be sort
	      */
	     public static void sortExhibitsByID(ArrayList < Exhibits > exhibit) {
	         for (int i = 0; i < exhibit.size() - 1; i++) {
	            for (int j = 0; j < exhibit.size() - i - 1; j++) {
	               if (exhibit.get(j).getID() > exhibit.get(j + 1).getID()) {
	                  // Swap artifacts[j] and artifacts[j + 1]
	                  Exhibits temp = exhibit.get(j);
	                  exhibit.set(j, exhibit.get(j + 1));
	                  exhibit.set(j + 1, temp);
	               }
	            }
	         }

	      }
	     /** Add a new Exhibit to the ArrayList of exhibits, Will first ask for the name and description then ask the user to add the desired
	      * Artifacts they wish to have in the exhibit. Once complete the system will then ask the user to add route numbers and steps for each
	      * 
	      * @param exhibit - The overall ArrayList of Exhibits to be added to.
	      * @param artifacts - The overall ArrayList of Artifacts, used to find the Artifacts which can be added to the Exhibits ArrayList
	      */
	     public static void AddExhibit(ArrayList<Exhibits> exhibit, ArrayList<Artifacts> artifacts) {
	    	    QUBMediaMuseum.console.println("Adding an Exhibit...");
	    	    
	    	    // Collecting the exhibit's name
	    	    String name = "";
	    	    String Description = "";
	    	    boolean Repeat = true;
	    	    while (Repeat) {
	    	        QUBMediaMuseum.console.print("Please enter an Exhibit's name: ");
	    	        try {
	    	            name = QUBMediaMuseum.console.readLn().trim();
	    	            if (Validations.validateName(name)) {
	    	                Repeat = false;
	    	            } else {
	    	                QUBMediaMuseum.console.println("Invalid name. Please try again.");
	    	            }
	    	        } catch (Exception e) {
	    	            QUBMediaMuseum.console.println("An unexpected error occurred. Please try again.");
	    	            QUBMediaMuseum.console.readLn(); 
	    	        }
	    	    }

	    	    // Collecting the exhibit's description
	    	    Repeat = true;
	    	    while (Repeat) {
	    	        QUBMediaMuseum.console.print("Please enter an Exhibit's Description: ");
	    	        try {
	    	            Description = QUBMediaMuseum.console.readLn().trim(); 
	    	            if (Validations.validateDescription(Description)) {
	    	                Repeat = false;
	    	            } else {
	    	                QUBMediaMuseum.console.println("Invalid description. Please try again.");
	    	            }
	    	        } catch (Exception e) {
	    	            QUBMediaMuseum.console.println("An unexpected error occurred. Please try again.");
	    	            QUBMediaMuseum.console.readLn(); 
	    	        }
	    	    }

	    	    // Create list for artifacts to be added
	    	    ArrayList<Artifacts> artifactsToAdd = new ArrayList<>();
	    	    boolean loop = true;

	    	    // Main loop for adding artifacts
	    	    while (loop) {
	    	        try {
	    	            QUBMediaMuseum.console.print("1: View all Artifacts\n2: Add Artifact to Exhibit\n3: Finished Adding Artifacts\n4: Cancel Addition of an Added Artifact\nEnter your choice: ");
	      	        	String str4 = QUBMediaMuseum.console.readLn();
	      	            int choice = Integer.parseInt(str4);

	    	            if (choice == 1) {
	    	                Artifacts.displayArtifacts(artifacts); // Display all artifacts
	    	            } else if (choice == 2) {
	    	                QUBMediaMuseum.console.print("Please enter the Artifact ID to add (starting from 1): ");
	    	  	        	String str = QUBMediaMuseum.console.readLn();
	    	  	            int id = Integer.parseInt(str);
	    	                if (id >= 1 && id <= artifacts.size()) {
	    	                    artifactsToAdd.add(artifacts.get(id - 1)); // Add selected artifact
	    	                    QUBMediaMuseum.console.println("Artifact added to exhibit.");
	    	                } else {
	    	                    QUBMediaMuseum.console.println("Invalid ID. Please try again.");
	    	                }
	    	            } else if (choice == 3) {
	    	                loop = false; // Exit loop to finish adding artifacts
	    	            } else if (choice == 4) {
	    	                if (artifactsToAdd.isEmpty()) {
	    	                    QUBMediaMuseum.console.println("You have not added any artifacts to the exhibit.");
	    	                } else {
	    	                    removeArtifactFromExhibit(artifactsToAdd); // Method to remove artifacts
	    	                }
	    	            }
	    	        } catch (Exception e) {
	    	            QUBMediaMuseum.console.println("Invalid input. Please enter a valid number.");
	    	            QUBMediaMuseum.console.readLn(); // Clear input buffer
	    	        }
	    	    }

	    	    // After artifact selection loop
	    	    if (artifactsToAdd.isEmpty()) {
	    	        // If no artifacts were added, ask the user to add at least one artifact
	    	        QUBMediaMuseum.console.println("You must add at least one artifact to the exhibit before it can be created.");
	    	    } else {
	    	        // Proceed if artifacts were added
	    	        QUBMediaMuseum.console.println("Assigning route steps to each artifact...");
	    	        ArrayList<Route> routeSteps = new ArrayList<>();
	    	        boolean[] assigned = new boolean[artifactsToAdd.size()];

	    	        // Loop for assigning route steps to artifacts
	    	        for (int i = 0; i < artifactsToAdd.size(); i++) {
	    	            Artifacts artifact = artifactsToAdd.get(i);
	    	            boolean validAssignment = false;
	    	            int routeNumber = -1;

	    	            while (!validAssignment) {
	    	                try {
	    	                    QUBMediaMuseum.console.println("Assigning route for artifact: " + artifact.getName());
	    	                    QUBMediaMuseum.console.print("Enter the route step number (1-" + artifactsToAdd.size() + "): ");
	    	      	        	String str = QUBMediaMuseum.console.readLn();
	    	      	            routeNumber = Integer.parseInt(str);

	    	                    if (routeNumber >= 1 && routeNumber <= artifactsToAdd.size() && !assigned[routeNumber - 1]) {
	    	                        validAssignment = true;
	    	                        assigned[routeNumber - 1] = true;
	    	                        QUBMediaMuseum.console.print("Enter a description/sign for this route step: ");
	    	                        String routeDescription = QUBMediaMuseum.console.readLn().trim();
	    	                        Route newRoute = new Route(artifact, routeDescription);
	    	                        routeSteps.add(newRoute);
	    	                        QUBMediaMuseum.console.println("Route step " + routeNumber + " assigned to artifact: " + artifact.getName());
	    	                    } else {
	    	                        QUBMediaMuseum.console.println("Invalid route number or route step already assigned. Please try again.");
	    	                    }
	    	                } catch (Exception e) {
	    	                    QUBMediaMuseum.console.println("Invalid input. Please enter a valid route step.");
	    	                    QUBMediaMuseum.console.readLn();
	    	                }
	    	            }
	    	        }

	    	        // Create and add the new exhibit to the collection
	    	        int newID = Exhibits.nextID(exhibit); 
	    	        exhibit.add(new Exhibits(newID, name, Description, artifactsToAdd, routeSteps));
	    	        QUBMediaMuseum.console.println("Exhibit created successfully with route steps!");
	    	    }
	    	}


	     /** Update an existing Exhibit from the ArrayList of exhibits, Will first ask for a new name and description then ask the user to add the desired
	      * Artifacts they wish to have in the exhibit. Once complete the system will then ask the user to add route numbers and steps for each
	      * 
	      * @param exhibit - The overall ArrayList of Exhibits to be added to.
	      * @param artifacts - The overall ArrayList of Artifacts, used to find the Artifacts which can be added to the Exhibits ArrayList
	      */
	     public static void updateExhibit(ArrayList<Exhibits> exhibits, ArrayList<Artifacts> artifacts) {
	    	    Exhibits.sortExhibitsByID(exhibits);
	    	    Exhibits.displayAllExhibits(exhibits); // Assuming this method displays all exhibits

	    	    Exhibits exhibitToUpdate = null;
	    	    boolean repeat = true;

	    	    // Locate exhibit to update
	    	    while (repeat) {
	    	        try {
	    	            QUBMediaMuseum.console.print("\nPlease enter the ID of the Exhibit you wish to change: ");
	      	        	String str = QUBMediaMuseum.console.readLn();
	      	            int id = Integer.parseInt(str);

	    	            boolean foundID = false;
	    	            for (Exhibits exhibit : exhibits) {
	    	                if (exhibit.getID() == id) {
	    	                    exhibitToUpdate = exhibit;
	    	                    repeat = false;
	    	                    foundID = true;
	    	                }
	    	            }
	    	            if (!foundID) {
	    	                QUBMediaMuseum.console.println("ID entered does not exist.");
	    	            }
	    	        } catch (Exception e) {
	    	            QUBMediaMuseum.console.println("Please only enter the number of an ID which exists.");
	    	            QUBMediaMuseum.console.readLn(); // Clear invalid input
	    	        }
	    	    }

	    	    // Start editing the exhibit
	    	    QUBMediaMuseum.console.println("Editing exhibit: ");
	    	    repeat = true;
	    	    String name = "";
	    	    String description = "";

	    	    // Update name
	    	    while (repeat) {
	    	        QUBMediaMuseum.console.print("Enter the new name for the exhibit or press enter to keep the same name: ");
	    	        name = QUBMediaMuseum.console.readLn().trim();
	    	        if (name.isEmpty()) {
	    	            name = exhibitToUpdate.getName(); // Keep existing name
	    	            repeat = false;
	    	        } else if (Validations.validateName(name)) {
	    	            repeat = false;
	    	        }
	    	    }

	    	    // Update description
	    	    repeat = true;
	    	    while (repeat) {
	    	        QUBMediaMuseum.console.print("Enter the new description (or press enter to keep the existing description): ");
	    	        description = QUBMediaMuseum.console.readLn().trim();
	    	        if (description.isEmpty()) {
	    	            description = exhibitToUpdate.getDescription(); // Keep existing description
	    	            repeat = false;
	    	        } else if (Validations.validateDescription(description)) {
	    	            repeat = false;
	    	        }
	    	    }

	    	    // Update artifacts
	    	    QUBMediaMuseum.console.println("Modifying artifacts for the exhibit:");
	    	    repeat = true;
	    	    while (repeat) {
	    	        QUBMediaMuseum.console.println("1: View all Artifacts\n2: Add Artifact to Exhibit\n3: Remove Artifact from Exhibit\n4: Finish Editing Artifacts");
	    	        QUBMediaMuseum.console.print("Enter your choice: ");
	    	        try {
	      	        	String str4 = QUBMediaMuseum.console.readLn();
	      	            int choice = Integer.parseInt(str4);

	    	            switch (choice) {
	    	                case 1:
	    	                    // Display all artifacts
	    	                    Artifacts.displayArtifacts(artifacts); // Assuming this method exists
	    	                    break;

	    	                case 2:
	    	                    // Add artifact to the exhibit
	    	                    QUBMediaMuseum.console.print("Enter the Artifact ID to add: ");
	    	      	        	String str = QUBMediaMuseum.console.readLn();
	    	      	            int addArtifactID = Integer.parseInt(str);
	    	                    if (addArtifactID > 0 && addArtifactID <= artifacts.size()) {
	    	                        Artifacts artifactToAdd = artifacts.get(addArtifactID - 1);
	    	                        exhibitToUpdate.addArtifact(artifactToAdd);
	    	                        QUBMediaMuseum.console.println("Artifact added.");
	    	                    } else {
	    	                        QUBMediaMuseum.console.println("Invalid Artifact ID.");
	    	                    }
	    	                    break;

	    	                case 3:
	    	                    // Remove artifact from the exhibit
	    	                    if (exhibitToUpdate.getArtifacts().isEmpty()) {
	    	                        QUBMediaMuseum.console.println("No artifacts to remove.");
	    	                    } else {
	    	                        QUBMediaMuseum.console.println("Artifacts in this exhibit:");
	    	                        for (Artifacts artifact : exhibitToUpdate.getArtifacts()) {
	    	                            artifact.displaySimpleArtifactDetails();
	    	                        }

	    	                        QUBMediaMuseum.console.print("Enter the Artifact ID to remove: ");
	    	          	        	String str2 = QUBMediaMuseum.console.readLn();
	    	          	            int removeArtifactID = Integer.parseInt(str2);
	    	                        Artifacts artifactToRemove = artifacts.stream()
	    	                                .filter(a -> a.getId() == removeArtifactID)
	    	                                .findFirst()
	    	                                .orElse(null);

	    	                        if (artifactToRemove != null && exhibitToUpdate.getArtifacts().contains(artifactToRemove)) {
	    	                            exhibitToUpdate.removeArtifact(artifactToRemove);
	    	                            QUBMediaMuseum.console.println("Artifact removed.");
	    	                        } else {
	    	                            QUBMediaMuseum.console.println("Invalid Artifact ID or artifact not in this exhibit.");
	    	                        }
	    	                    }
	    	                    break;

	    	                case 4:
	    	                    // Finish artifact editing
	    	                    repeat = false;
	    	                    break;

	    	                default:
	    	                    QUBMediaMuseum.console.println("Invalid choice. Please try again.");
	    	            }
	    	        } catch (Exception e) {
	    	            QUBMediaMuseum.console.println("Invalid input. Please enter a valid option.");
	    	            QUBMediaMuseum.console.readLn(); // Clear invalid input
	    	        }
	    	    }

	    	    // Apply updates to the exhibit
	    	    exhibitToUpdate.setName(name);
	    	    exhibitToUpdate.setDescription(description);

	    	    QUBMediaMuseum.console.println("Exhibit updated successfully!");
	    	}



	     /** Delete an Existing Exhibit from the Arraylist of exhibits.
	      * 
	      * @param exhibit
	      * @param artifacts
	      */
	     public static void deleteExhibit(ArrayList<Exhibits> exhibit) {
	    	 // Sort the array List by each exhibits ID ascending order, to allow the user to easily select which artifact they wish to delete
	         Exhibits.sortExhibitsByID(exhibit);
	         QUBMediaMuseum.console.println("Deleting an Exhibit...");
	         for (int i = 0; i < exhibit.size(); i++) {
	            exhibit.get(i).simpleExhibitDetails();
	         }
	         // default set the ID to -1
	         // Ask the user to give the exhibit ID they wish to delete. IF the ID given is valid then ask the user to spell out delete 
	         // In call capitals to fully delete the artifact
	         int exhibitID = -1;
	         while (exhibitID < 0 || exhibitID >= exhibit.size()) {
	            try {
	               QUBMediaMuseum.console.print("Please enter the Exhibit ID you wish to delete: ");
	  	        	String str = QUBMediaMuseum.console.readLn();
	  	            exhibitID = Integer.parseInt(str) -1;
	               if (exhibitID < 0 || exhibitID > exhibit.size()) {
	                  QUBMediaMuseum.console.println("Invalid ID. Please try again.");
	               }
	            } catch (Exception e) {
	               QUBMediaMuseum.console.println("Please enter a valid number for the Exhibit ID.");
	               QUBMediaMuseum.console.readLn();
	            }
	         }
	         QUBMediaMuseum.console.print("Are you sure you want to delete this exhibit? (YES/NO): ");
	         String confirm = QUBMediaMuseum.console.readLn().trim();
	         if (confirm.equals("YES")) {
	            exhibit.remove(exhibitID);
	            QUBMediaMuseum.console.println("Exhibit deleted successfully.");
	         } else {
	            QUBMediaMuseum.console.println("Exhibit deletion canceled.");
	         }
	      }
	     /** Search for exhibits, includes menu and methods for searching for the exhibits.
	      * 
	      * @param exhibit - The overall ArrayList of Exhibits to be added to.
	      * @param artifacts - The overall ArrayList of Artifacts, used to find the Artifacts which can be added to the Exhibits ArrayList
	      */
	     
	     public static void searchExhibits(ArrayList<Exhibits> exhibit, ArrayList<Artifacts> artifacts) {
	    	    // Loop to ensure the menu continues until the user exits or selects a valid option
	    	    boolean RepeatLoop = true;

	    	    while (RepeatLoop) {
	    	        // Display menu options for the user
	    	        QUBMediaMuseum.console.print("1: Search for an Exhibit by name\n2: Search for an Exhibit by ID\n3: Search for part of an Exhibit’s name" +
	    	                "\n4: Search for an Exhibit by Type\n5: View all Exhibits\n6: View route of an Exhibit\n7: Back to main menu\nPlease enter your choice: ");
	    	        try {
	    	            // Get user input for menu selection
	      	        	String str4 = QUBMediaMuseum.console.readLn();
	      	            int selection = Integer.parseInt(str4);
	    	            switch (selection) {
	    	                // Case for searching exhibits by exact name
	    	                case 1:
	    	                    QUBMediaMuseum.console.print("Please enter the name you wish to search for: ");
	    	                    String search = QUBMediaMuseum.console.readLn().trim(); 
	    	                    Exhibits.searchName(search, exhibit); // Search and display matching exhibits by name
	    	                    break;

	    	                // Case for searching exhibits by ID
	    	                case 2:
	    	                    QUBMediaMuseum.console.print("Please enter the ID you wish to search for: ");
	    	      	        	String str = QUBMediaMuseum.console.readLn();
	    	      	            int id = Integer.parseInt(str);
	    	                    QUBMediaMuseum.console.readLn(); // Consume leftover newline character
	    	                    Exhibits.searchByID(id, exhibit); // Search and display matching exhibit by ID
	    	                    break;

	    	                // Case for searching exhibits by part of their name
	    	                case 3:
	    	                    QUBMediaMuseum.console.print("Please enter the part of the name you wish to search for: ");
	    	                    String partialName = QUBMediaMuseum.console.readLn();
	    	                    Exhibits.searchPartName(partialName, exhibit); // Search and display exhibits by partial name
	    	                    break;

	    	                // Case for searching exhibits by artifact type
	    	                case 4:
	    	                    try {
	    	                        ArtifactType.displayTypesWithNumbers(); // Display all artifact types
	    	                        QUBMediaMuseum.console.print("\nPlease enter the number of the Artifact Type you wish to select: ");
	    	          	        	String str3 = QUBMediaMuseum.console.readLn();
	    	          	            int typeID = Integer.parseInt(str3);
	    	                        ArtifactType type = ArtifactType.findFromNumber(typeID); // Get the artifact type
	    	                        Exhibits.searchType(type, exhibit); // Search and display exhibits of the selected type
	    	                    } catch (IllegalArgumentException e) {
	    	                        QUBMediaMuseum.console.println("Invalid selection. Please enter a valid number.");
	    	                    } catch (Exception e) {
	    	                        QUBMediaMuseum.console.println("An error occurred. Please try again.");
	    	                        QUBMediaMuseum.console.readLn(); // Consume incorrect input
	    	                    }
	    	                    break;

	    	                // Case for displaying all exhibits
	    	                case 5:
	    	                    Exhibits.displayAllExhibits(exhibit); // Display all exhibits in the list
	    	                    break;

	    	                // Case for viewing the route of a specific exhibit
	    	                case 6:
	    	                    QUBMediaMuseum.console.print("Enter the ID of the Exhibit to view its route: ");
	    	                    try {
	    	          	        	String str2 = QUBMediaMuseum.console.readLn();
	    	          	            int exhibitID = Integer.parseInt(str2);
	    	                        Exhibits exhibitToView = Exhibits.searchByID(exhibitID, exhibit); // Get the exhibit by ID
	    	                        if (exhibitToView != null) {
	    	                            exhibitToView.displayRoutes(); // Display the route of the found exhibit
	    	                        } else {
	    	                            QUBMediaMuseum.console.println("No Exhibit found with the given ID.");
	    	                        }
	    	                    } catch (Exception e) {
	    	                        QUBMediaMuseum.console.println("Invalid input. Please enter a valid Exhibit ID.");
	    	                        QUBMediaMuseum.console.readLn(); // Consume invalid input
	    	                    }
	    	                    break;

	    	                // Case for going back to the main menu
	    	                case 7:
	    	                    QUBMediaMuseum.console.println("Returning to main menu...");
	    	                    RepeatLoop = false; // Exit the loop to go back to the main menu
	    	                    break;

	    	                // Default case for invalid menu selections
	    	                default:
	    	                    QUBMediaMuseum.console.println("Please only enter a number between 1 and 7.");
	    	                    break;
	    	            }
	    	        } catch (Exception e) {
	    	            // Handle any exceptions due to invalid input
	    	            QUBMediaMuseum.console.println("Invalid input. Please enter a number between 1 and 7.");
	    	            QUBMediaMuseum.console.readLn(); // Consume the incorrect input
	    	        }
	    	    }
	    	}

	      /** Method to allow the user to delete an Artifact from the arraylist of artifacts held within the exhibit
	       * 
	       * @param artifacts - The ArrayList of artifacts which will be compared with to remove the Artifact
	       */
	      private static void removeArtifactFromExhibit(ArrayList < Artifacts > artifacts) {
	    	  // First validate whether the user has actually passed in an ArrayList which contains any artifacts
	          if (artifacts.isEmpty()) {
	             QUBMediaMuseum.console.println("You have not added any artifacts to the exhibit.");
	          } 
	          // Passed validation? then sort by ID and display them by ID, again for user simplicity
	          else {
	             Artifacts.sortArtifactsbyID(artifacts);
	             QUBMediaMuseum.console.println("Currently added artifacts:");
	             for (int i = 0; i < artifacts.size(); i++) {
	                QUBMediaMuseum.console.println((i + 1) + ": " + artifacts.get(i).getName());
	             }
	             // Ask the user to input the ID of the Artifact ID to remove an exhibit
	             QUBMediaMuseum.console.print("Please enter the Artifact ID you wish to remove from the exhibit: ");
	             try {
	   	        	String str = QUBMediaMuseum.console.readLn();
	  	            int idToRemove = Integer.parseInt(str);
	                QUBMediaMuseum.console.readLn(); 
	                // If the ID is valid then attempt to delete 
	                if (idToRemove >= 1 && idToRemove <= artifacts.size()) {
	                	artifacts.remove(idToRemove - 1); 
	                   QUBMediaMuseum.console.println("Artifact removed from the exhibit.");
	                } else {
	                   QUBMediaMuseum.console.println("Invalid ID. Please enter a number between 1 and " + artifacts.size());
	                }
	             } catch (Exception e) {
	                QUBMediaMuseum.console.println("Invalid input. Please enter a valid number.");
	                QUBMediaMuseum.console.readLn(); 
	             }
	          }
	       }
	      
}
