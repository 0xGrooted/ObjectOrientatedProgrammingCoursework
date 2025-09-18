package part03;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Artifacts {
    private int id;                // Unique identifier for the artifact
    private String name;              // Name of the artifact 
    private ArtifactType type;        // The type of the artifact | ArtifcatType enum
    private int engagementTime;       // Integer - engagement time | how long visitors will interact (mins) 
    private String description;		 // interacting with it.
    private ImageIcon image;  // Field to store the artifact's image
    private static final int DEFAULT_ID_PREFIX = 100000;  // The First invalid ID which should be assigned
    private static int lastGeneratedInvalidId = DEFAULT_ID_PREFIX;  // Track last invalid ID used

    
 /**
  * Constructor for the Artifacts class, uses set methods within to ensure that the parameters passed in all are valid
  * @param ID - Passed in to set the ID
  * @param Name - Passed in to set the Name
  * @param type - Passed in to set the Type
  * @param EngagementTime - Passed in to set the engagement Time
  * @param Description
  */
    public Artifacts(int ID, String Name, ArtifactType type, int EngagementTime, String Description) {
        setId(ID);
        setName(Name);
        setType(type);
        setEngagementTime(EngagementTime);
        setDescription(Description);
    }
    /**
     * Getter for the ID
     * @return The ID
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID, will only be set if it is > 0
     * 	If it is not valid then the static final Integer will be incremented and will be the ID
     * @param id
     */
    public void setId(int id) {
        if (id <= 0) {
            this.id = lastGeneratedInvalidId++;
            QUBMediaMuseum.console.println("Invalid ID provided. Assigning a new unique ID: " + this.id);
        } else {
            this.id = id;
        }
    }
 // Getter for ImageIcon
    public ImageIcon getImage() {
        return image;
    }

    // Setter for ImageIcon
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    

   /**
    * Get the name of an Artifact
    * @return The name of the artifact
    */
    public String getName() {
        return name;
    }
    /**
     * Method to set the name, must pass validation in order to be set or else it will be changed to Unknown Artifact
     * @param name - String passed in which will either be set or forgotten
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 2) {
            this.name = "Unknown Artifact";
        } else if (name.length() > 200) { 
            this.name = "N/A";
        } else if (name.matches(".*[<>].*") || name.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            this.name = "Unknown Artifact";  
        } else {
            this.name = name.trim();
        }
    }
    /**
     * Type setter
     * @return The type of an Artifact
     */
    public ArtifactType getType() {
        return type;
    }
    /**
     * Set type if it passes validation
     * @param type - Passed in other to go through validation
     */
    public void setType(ArtifactType type) {
        if (type == null) {
            this.type = ArtifactType.OTHER;
        }
        this.type = type;
    }
    /**
     * Get the engagement time of an Artifact
     * @return the engagement time
     */
    public int getEngagementTime() {
        return engagementTime;
    }
    /**
     * Set the engagement time if it is valid and has passed validations
     * @param engagementTime -  set engagement time 
     */
    public void setEngagementTime(int engagementTime) {
        if (engagementTime == 0 || engagementTime < 0 ) {
            this.engagementTime = 1;
        }
        else if (engagementTime > 30) {
        	this.engagementTime = 30;
        }
        else {
        this.engagementTime = engagementTime;
        }
    }
    /**
     * Description getter 
     * @return Description of an Artifact
     */
    public String getDescription() {
        return description;
    }
    /**
     * Artifact Description setter
     * @param description - description to be set to an Artifact
     */
    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty() || description.length() < 2) {
            this.description = "N/A";
        }
        else if (description.length() > 200) {
            this.description = description.substring(0, 200);
        }
        else if (description.matches(".*[<>+=\\}\\{\\[\\]#$%^&*()].*")) {
            this.description = "N/A";
        }
        else {
            this.description = description.trim();
        }
    }
    /**
     * Displays detailed information about the artifact including name, ID, type, engagement time, and description.
     */
    public void displayArtifactDetails() {
        String Name = "Name: " + name;
        String ArtifactID = "Artifact ID: " + id;
        String Type = "Type: " + type.getTypeName();
        String engagement = "Engagement Time: " + engagementTime + " minutes";
        String Description = "Description: " + description;

        int length = engagement.length();
        String line = "-".repeat(length);

        QUBMediaMuseum.console.println(line + "\n" + Name + "\n\n" + ArtifactID + "\n" + Type + "\n" 
        + engagement + "\n" + Description + "\n");
    }

    /**
     * Displays basic information about the artifact including only name and description.
     */
    public void displaySimpleArtifactDetails() {
        String Description = "Descrption: " + description;
        String Name = "Name: " + name;

        int length = Description.length();
        String line = "-".repeat(length);

        QUBMediaMuseum.console.println(line + "\n" + Name + "\n" + Description + "\n");
    }

    /**
     * Returns the next available unique ID for an artifact.
     * @param artifacts The list of existing artifacts.
     * @return The next unique ID.
     */
    public static int nextID(ArrayList<Artifacts> artifacts) {
        int nextID = artifacts.size() + 1;

        for (int i = 0; i < artifacts.size() - 1; i++) {
            if (artifacts.get(i + 1).getId() - artifacts.get(i).getId() > 1) {
                return nextID = artifacts.get(i).getId() + 1;
            }
        }
        return nextID;
    }

    /**
     * Sorts a list of artifacts alphabetically by their name using the bubble sort algorithm.
     * @param list The list of artifacts to be sorted.
     */
    public static void bubbleSort(ArrayList<Artifacts> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).getName().compareTo(list.get(j + 1).getName()) > 0) {
                    Artifacts temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /**
     * Displays all artifacts in the provided list.
     * @param artifacts The list of artifacts to be displayed.
     */
    public static void displayArtifacts(ArrayList<Artifacts> artifacts) {
        for (int i = 0; i < artifacts.size(); i++) {
            artifacts.get(i).displayArtifactDetails();
        }
    }

    /**
     * Searches for artifacts whose name contains the provided string and displays them.
     * @param str The string to search for within the artifact names.
     * @param artifacts The list of artifacts to search within.
     */
    public static void searchPartName(String str, ArrayList<Artifacts> artifacts) {
        boolean found = false;
        if (str.equals("") || str.equals(" ")) {
            QUBMediaMuseum.console.println("Invalid search criteria no spaces unless there is an actual space between names");
        } else {
            for (int i = 0; i < artifacts.size(); i++) {
                if (artifacts.get(i).name.contains(str)) {
                    artifacts.get(i).displayArtifactDetails();
                    found = true;
                }
            }
            if (!found) {
                QUBMediaMuseum.console.println("No artifact found with the part name");
            }
        }
    }

    /**
     * Searches for artifacts whose name exactly matches the provided string and displays them.
     * @param str The exact name of the artifact to search for.
     * @param artifacts The list of artifacts to search within.
     */
    public static void searchName(String str, ArrayList<Artifacts> artifacts) {
        boolean found = false;
        if (str.equals("") || str.equals(" ")) {
            QUBMediaMuseum.console.println("Invalid search criteria no spaces unless there is an actual space between names");
        } else {
            for (int i = 0; i < artifacts.size(); i++) {
                if (artifacts.get(i).name.equalsIgnoreCase(str)) {
                    artifacts.get(i).displayArtifactDetails();
                    found = true;
                }
            }
            if (!found) {
                QUBMediaMuseum.console.println("No artifact found with the name: " + str);
            }
        }
    }

    /**
     * Searches for artifacts by their ID and displays them.
     * @param id The ID of the artifact to search for.
     * @param artifacts The list of artifacts to search within.
     */
    public static void searchID(int id, ArrayList<Artifacts> artifacts) {
        for (int i = 0; i < artifacts.size(); i++) {
            if (artifacts.get(i).id == id) {
                artifacts.get(i).displayArtifactDetails();
            }
        }
    }

    /**
     * Searches for artifacts by their type and displays them.
     * @param type The type of the artifact to search for.
     * @param artifacts The list of artifacts to search within.
     */
    public static void searchType(ArtifactType type, ArrayList<Artifacts> artifacts) {
        for (int i = 0; i < artifacts.size(); i++) {
            if (artifacts.get(i).type == type) {
                artifacts.get(i).displayArtifactDetails();
            }
        }
    }

    /**
     * Sorts a list of artifacts by their ID using the bubble sort algorithm.
     * @param artifacts The list of artifacts to be sorted.
     */
    public static void sortArtifactsbyID(ArrayList<Artifacts> artifacts) {
        for (int i = 0; i < artifacts.size() - 1; i++) {
            for (int j = 0; j < artifacts.size() - i - 1; j++) {
                if (artifacts.get(j).getId() > artifacts.get(j + 1).getId()) {
                    Artifacts temp = artifacts.get(j);
                    artifacts.set(j, artifacts.get(j + 1));
                    artifacts.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Deletes an artifact from the list based on its ID after confirmation from the user.
     * @param artifacts The list of artifacts from which an artifact will be deleted.
     */
    public static void deleteArtifact(ArrayList<Artifacts> artifacts) {
    	// Sort the artifacts by ID in order to easily identify which artifact is to be deleted
        Artifacts.sortArtifactsbyID(artifacts);
        // After sorting we then display these to the user
        Artifacts.displayArtifacts(artifacts);
        int id = 0;
        // Ask the user to input the Artifact ID they wish to delete
        boolean repeat = true;
        while (repeat) {
            try {
                QUBMediaMuseum.console.print("Please enter the ID of the artifact you wish to delete: ");
  	        	String str = QUBMediaMuseum.console.readLn();
  	            id = Integer.parseInt(str);
                // First verify whether the Artifact actually exists from the current Array list of Artifacts
                boolean foundID = false;
                for (Artifacts artifact : artifacts) {
                    if (artifact.getId() == id) {
                        repeat = false;
                        foundID = true;
                    }
                }
                if (!foundID) {
                    QUBMediaMuseum.console.println("ID entered does not exist");
                }
            } catch (Exception E) {
                QUBMediaMuseum.console.println("Please only enter the number of an ID which exists");
                QUBMediaMuseum.console.readLn();
            }
        }
        // In order to ensure the user actually wishes to delete the Artifact we ask the user to type DELETE in all capital letters
        repeat = true;
        while (repeat) {
            try {
                QUBMediaMuseum.console.print("Please type 'DELETE' to delete artifact " + id + ": ");
                String deleteAttempt = QUBMediaMuseum.console.readLn();
                // If user successfully does so then artifact is deleted
                // IF user doesn't then stop the deletion
                if (deleteAttempt.equals("DELETE")) {
                    artifacts.remove(id - 1);
                    QUBMediaMuseum.console.println("Artifact " + id + " Removed successfully.");
                    repeat = false;
                }
            } catch (Exception E) {
                QUBMediaMuseum.console.println("An error has occurred please try again");
            }
        }
    }

    /**
     * Adds a new artifact to the list after validating input from the user.
     * @param artifacts The list of artifacts to which the new artifact will be added.
     */
    public static void addArtifact(ArrayList<Artifacts> artifacts) {
    	// Sort Artifacts by ID, will allow for the next ID to be found quicker as the ArrayList has been sorted in the desired way
        Artifacts.sortArtifactsbyID(artifacts);
        // Follow format of declaring all variables as null values prior to entering each while loop to get the user input
        boolean Repeat = true; // This is re used for every while loop, it is set to true before each to ensure looping
        String name = "";
        String Description = "";
        ArtifactType type2 = ArtifactType.findFromNumber(5);
        int engTime = 0;
        QUBMediaMuseum.console.println("Add an Artifact...");
        // Allow the user to input a name for the Artifact
        while (Repeat) {
            QUBMediaMuseum.console.print("Artifacts name: ");
            try {
                name = QUBMediaMuseum.console.readLn().trim();
                if (Validations.validateName(name)) {
                    Repeat = false;
                }
            } catch (Exception e) {
                QUBMediaMuseum.console.println("An unexpected error occurred. Please try again.");
                QUBMediaMuseum.console.readLn();
            }
        }
        // Allow the user to input an Artifact Type for the Artifact, first the Types will be displayed with a number beside them and then
        // the user will be asked to pick a number from 1 -5 corresponding to these.
        ArtifactType.displayTypesWithNumbers();
        Repeat = true;
        while (Repeat) {
            try {
                QUBMediaMuseum.console.print("Artifacts Type: ");
  	        	String str = QUBMediaMuseum.console.readLn();
  	            int type = Integer.parseInt(str);

                if (type < 0 || type > 5) {
                    QUBMediaMuseum.console.println("Please only select from the list above by number");
                } else {
                    type2 = ArtifactType.findFromNumber(type);
                    if (type2 == null) {
                        QUBMediaMuseum.console.println("Invalid artifact type selection. Operation canceled.");
                    }
                    Repeat = false;
                }
            } catch (Exception e) {
                QUBMediaMuseum.console.println("An unexpected error has occurred! Please try again.");
                QUBMediaMuseum.console.readLn();
            }
        }
        // Allow the user to input an engagement time for the Artifact
        Repeat = true;
        while (Repeat) {
            try {
                QUBMediaMuseum.console.print("Enter Artifacts engagement time: ");
  	        	String str = QUBMediaMuseum.console.readLn();
  	            engTime = Integer.parseInt(str);

                if (engTime == 0) {
                    QUBMediaMuseum.console.println("Time must be more than 0 minutes");
                } else {
                    Repeat = false;
                }
            } catch (Exception e) {
                QUBMediaMuseum.console.println("Please only enter valid positive integer numbers");
                QUBMediaMuseum.console.readLn();
            }
        }
        // Allow the user to input a description
        Repeat = true;
        while (Repeat) {
            QUBMediaMuseum.console.print("Please enter the artifact's description: ");
            try {
                Description = QUBMediaMuseum.console.readLn().trim();
                if (Validations.validateDescription(Description)) {
                    Repeat = false;
                }
            } catch (Exception e) {
                QUBMediaMuseum.console.println("Error in description, try again.");
                QUBMediaMuseum.console.readLn();
            }
        }
        // After all of the variables have been correctly given and passed validation the System can then add these to the ArrayList artifacts
        artifacts.add(new Artifacts(Artifacts.nextID(artifacts), name, type2, engTime, Description));
    }

    /**
     * Updates the details of an artifact in the list. The user selects an artifact ID to update
     * The user has the option to keep the Artifact the same in this by simply clicking enter when asked for the following fields;
     * - Name
     * - Description
     * - Artifact Type
     * - Engagement time
     * @param artifacts The list of artifacts.
     */
    public static void updateArtifact(ArrayList<Artifacts> artifacts) {
    	// Display all of the Artifacts for the user to pick from
        Artifacts.displayArtifacts(artifacts);
        // Default all of the Variables to be updated
        boolean Repeat = true;
        String name = "";
        String Description = "";
        ArtifactType type2 = ArtifactType.findFromNumber(5); // Selects the type as other
        int engTime = 0;
        Artifacts artifactToUpdate = null;
        // Create a while loop for allowing the user to select an Artifact ID, will loop until the user successfully picks a valid Artifact ID
        while (Repeat) {
            try {
                QUBMediaMuseum.console.print("\nPlease enter the ID of the Artifact you wish to change: ");
  	        	String str = QUBMediaMuseum.console.readLn();
  	            int id = Integer.parseInt(str);

                boolean foundID = false;
                for (Artifacts artifact : artifacts) {
                    if (artifact.getId() == id) {
                        artifactToUpdate = artifact;
                        Repeat = false;
                        foundID = true;
                    }
                }
                if (!foundID) {
                    QUBMediaMuseum.console.println("ID entered does not exist");
                }
            } catch (Exception E) {
                QUBMediaMuseum.console.println("Please only enter the number of an ID which exists");
                QUBMediaMuseum.console.readLn(); 
            }
        }
        // Artifact Has been selected now we allow the user to actually update the Artifact with all the fields necessary.
        // Beginning with Name
        QUBMediaMuseum.console.println("Updating artifact: ");
        Repeat = true;
        while (Repeat) {
            QUBMediaMuseum.console.print("Enter the new name for the artifact or press enter to keep the same name: ");
            name = QUBMediaMuseum.console.readLn().trim();
            if (name.isEmpty()) {
                name = artifactToUpdate.getName(); // The Name for the Artifact being updated will remain the same
                Repeat = false;
                // Validate the name using the Validations class
            } else if (Validations.validateName(name) == true) {
                Repeat = false;
            }
        }

        // Next allow the user to update the Type, begin with displaying all of the types for the user to pick from.
        // A number will appear beside each type to allow for a more robust system, validating a number is far more secure.
        ArtifactType.displayTypesWithNumbers();
        Repeat = true;
        while (Repeat) {
            try {
                QUBMediaMuseum.console.print("Enter new type (or press enter to keep existing type): ");
                String typeInput = QUBMediaMuseum.console.readLn().trim();
                if (typeInput.isEmpty()) {
                    type2 = artifactToUpdate.getType(); // The Type for the Artifact being updated will remain the same
                    Repeat = false;
                } else {
                    int type = Integer.parseInt(typeInput);
                    if (type >= 0 && type <= 5) {
                        type2 = ArtifactType.findFromNumber(type);
                        Repeat = false;
                    } else {
                        QUBMediaMuseum.console.println("Invalid type number");
                    }
                }
            } catch (Exception e) {
                QUBMediaMuseum.console.println("Invalid input, please try again.");
                QUBMediaMuseum.console.readLn(); 
            }
        }

        // Allow user to update the Description
        Repeat = true;
        while (Repeat) {
            QUBMediaMuseum.console.print("Enter the new description (or press enter to keep existing description): ");
            Description = QUBMediaMuseum.console.readLn().trim();
            if (Description.isEmpty()) {
                Description = artifactToUpdate.getDescription(); // The Description for the Artifact being updated will remain the same
                Repeat = false;
            } else if (Validations.validateDescription(Description)) {
                Repeat = false;
            }
        }
        // Finally allow the user to update the engagement time
        Repeat = true;
        while (Repeat) {
            try {
                QUBMediaMuseum.console.print("Enter the new engagement time (or press enter to keep the same time): ");
                String timeInput = QUBMediaMuseum.console.readLn();

                if (timeInput.trim().isEmpty()) {
                    engTime = artifactToUpdate.getEngagementTime(); 
                    Repeat = false;
                } else {
                    int inputTime = Integer.parseInt(timeInput);

                    if (inputTime <= 0) {
                        QUBMediaMuseum.console.println("Engagement time must be positive. Please try again.");
                    }
                    else if (inputTime > 30) {
                        QUBMediaMuseum.console.println("Engagement time must be less than 30 (minutes). Please try again.");
                    }else {
                        engTime = inputTime;
                        Repeat = false;
                    }
                }
            } catch (NumberFormatException e) {
                QUBMediaMuseum.console.println("Invalid input. Please enter a valid number or press Enter to keep the existing time.");
            }
        }
        artifactToUpdate.setName(name);
        artifactToUpdate.setType(type2);
        artifactToUpdate.setDescription(Description);
        artifactToUpdate.setEngagementTime(engTime);

        QUBMediaMuseum.console.println("Artifact updated successfully!");
    }
    /**
     * View Artifacts, user can search for ID, Type and full or part name. 
     * @param artifacts - The array List containing all of the Artifacts to be searched through
     * @param exhibit - The array list of all the exhibits
     */
    public static void viewArtifacts(ArrayList<Artifacts> artifacts, ArrayList<Exhibits> exhibit) {
        // Loop to ensure we continue this menu until the user inputs a valid integer.
        boolean RepeatLoop = true;

        while (RepeatLoop == true) {
            // Display menu options for the user to choose from.
            QUBMediaMuseum.console.print("1: Search for an Artifact by name\n2: Search for an Artifact by ID\n3: Search for part of an Artifacts name" +
                "\n4: Search for an Artifact by Type\n5: View all Artifacts\n6: Back to main menu\nPlease enter your choice: ");
            try {
                // Get user input for menu selection
  	        	String str = QUBMediaMuseum.console.readLn();
  	            int selection = Integer.parseInt(str);
                switch (selection) {
                    // Case for exact match search by name
                    case 1:
                        QUBMediaMuseum.console.print("Please enter the name you wish to search for: ");
                        String search = QUBMediaMuseum.console.readLn().trim(); 
                        Artifacts.searchName(search, artifacts); 
                        break;
                    // Case for searching by Artifact ID
                    case 2:
                        QUBMediaMuseum.console.print("Please enter the ID you wish to search for: ");
          	        	String str1 = QUBMediaMuseum.console.readLn();
          	            int id = Integer.parseInt(str1);
                        QUBMediaMuseum.console.readLn(); // Consume the newline character
                        Artifacts.searchID(id, artifacts);
                        break;
                    // Case for searching part of an Artifact's name
                    case 3:
                        QUBMediaMuseum.console.print("Please enter the part of the name you wish to search for: ");
                        String partialName = QUBMediaMuseum.console.readLn();
                        Artifacts.searchPartName(partialName, artifacts);
                        break;
                    // Case for searching by Artifact Type
                    case 4:
                        ArtifactType.displayTypesWithNumbers(); // Display the artifact types for selection
                        QUBMediaMuseum.console.print("\nPlease enter the number of the Exhibit Type you wish to select: ");
                        try {
              	        	String str3 = QUBMediaMuseum.console.readLn();
              	            int typeID = Integer.parseInt(str3);
                            QUBMediaMuseum.console.readLn(); // Consume the newline character
                            ArtifactType type = ArtifactType.findFromNumber(typeID); // Get the selected artifact type
                            Exhibits.searchType(type, exhibit); // Search exhibits by the selected type
                        } catch (Exception e) {
                            QUBMediaMuseum.console.println("Invalid selection. Please try again.");
                            QUBMediaMuseum.console.readLn(); // Consume the incorrect input
                        }
                        break;
                    // Case for displaying all artifacts
                    case 5:
                        Artifacts.displayArtifacts(artifacts);
                        break;
                    // Case for going back to the artifact menu
                    case 6:
                        QUBMediaMuseum.console.println("Returning to the Artifact Menu...");
                        RepeatLoop = false; // Exit the loop to go back
                        break;
                    // Default case for invalid selection
                    default:
                        QUBMediaMuseum.console.println("Please only enter a number between 1 and 6.");
                        break;
                }
            } catch (Exception e) {
                // Catch any input errors and prompt the user to enter a valid number
                QUBMediaMuseum.console.println("Invalid input. Please enter a number between 1 and 6.");
                QUBMediaMuseum.console.readLn(); // Consume the invalid input
            }
        }
    }

}
    
   
