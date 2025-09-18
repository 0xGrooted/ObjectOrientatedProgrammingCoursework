package part02;

import java.util.ArrayList;
import java.util.Scanner;

public class AnnualPlan {
    private ArrayList<ArrayList<Exhibits>> halls; // List of halls, each with a list of monthly exhibits
    private static Scanner myObj = new Scanner(System.in); // Instantiate the scanner so the user can input into the console
    private static final int MONTH = 12;
    private static final int HALL = 3;
    
    private String yearName; // Variable to store the year name of each annual plan

    private static final int START_YEAR = 2024; // start at 2024, and continue upwards for each instance created
    
    /** Construct the Annual Plan must pass in the number of halls and number of months and create the array list of halls with null values
     * 
     * @param numberOfHalls - The number of halls the user wishes to create (will be an arrayList which has an array list of exhibits inside
     * @param numberOfMonths - The number of months the user wishes to have in the annual plan (generally but not exclusive to 12)
     */
    public AnnualPlan(int yearOffset) {
    	// For every instance of an annual plan I would like it to start at 2024, and continue, this adds the year offset to this to ensure
    	// it is increasing by the correct amount of years.
        this.yearName = "Year " + (START_YEAR + yearOffset);
        halls = new ArrayList<>();
        for (int i = 0; i < HALL; i++) {
            ArrayList<Exhibits> hall = new ArrayList<>();
            for (int j = 0; j < MONTH; j++) {
                hall.add(null); 
            }
            halls.add(hall);
        }
    }
    
    public String getYearName() {
        return yearName;
    }
    	

    /** Add an exhibit to a specific hall for a selected month
     * @param int hallNumber - The hall number the user wishes to add an exhibit to
     * @param int monthIndex - The month the user wishes the exhibit to go under within the hall
     * @param Exhbits exhibit ( ArrayList ) - The exhibit the user wishes to add to the exhibit
    **/
    public boolean addExhibit(int hallIndex, int monthIndex, Exhibits exhibit) {
        // Check if the hall index and month index are within the bounds
        if (hallIndex >= 0 && hallIndex < halls.size() && monthIndex >= 0 && monthIndex < 12) {
            // Assuming the halls list has enough capacity to store exhibits for each month
            halls.get(hallIndex).set(monthIndex, exhibit);
            return true;  // Exhibit added successfully
        } else {
            return false;  // Invalid hall or month index
        }
    }

    /** Get the exhibit within a desired hall number in a certain month
     * 
     * @param hallNumber - The hall number the user wishes to find the exhibit under
     * @param monthIndex -  The month the user wishes to find the exhibit under
     * @return -  Returns the exhibit from the desired month and hall number
     */
    public Exhibits getExhibit(int hallNumber, int monthIndex) {
        if (hallNumber < 1 || hallNumber > halls.size()) {
            System.out.println("Invalid hall number. Please enter a hall number between 1 and " + halls.size() + ".");
            return null; 
        }
        if (monthIndex < 0 || monthIndex >= halls.get(hallNumber - 1).size()) {
            System.out.println("Invalid month index. Please enter a valid month between 1 and " + halls.get(hallNumber - 1).size() + ".");
            return null; 
        }
        return halls.get(hallNumber - 1).get(monthIndex);
    }


    /** Display all of the exhibits in each month within the desired hall number
     * 
     * @param hallNumber - The hall number the user wishes to see if there is an exhibit or not
     */
    public void displayHallExhibits(int hallNumber) {
    	// Ensure the hall Number entered is valid
        if (hallNumber < 1 || hallNumber > halls.size()) {
            System.out.println("Invalid hall number.");
            return;
        }
        // If user has entered a valid hall number then 
        ArrayList<Exhibits> hallExhibits = halls.get(hallNumber - 1);
        System.out.println("Exhibits for Hall " + hallNumber + ":");
        for (int i = 0; i < hallExhibits.size(); i++) {
            Exhibits exhibit = hallExhibits.get(i);
            if (exhibit != null) {
                System.out.println("Month " + (i + 1) + ": " + exhibit.getName());
            } else {
                System.out.println("Month " + (i + 1) + ": No exhibit scheduled");
            }
        }
    }

    /** Display all exhibits scheduled for a particular month across all halls
     * 
     * @param monthIndex
     */
    public void displayMonthExhibits(int monthIndex) {
        if (monthIndex < 0 || monthIndex >= halls.get(0).size()) {
            System.out.println("Invalid month index.");
            return;
        }

        System.out.println("Exhibits scheduled for Month " + (monthIndex + 1) + ":");
        for (int hall = 0; hall < halls.size(); hall++) {
            Exhibits exhibit = halls.get(hall).get(monthIndex);
            if (exhibit != null) {
                System.out.println("Hall " + (hall + 1) + ": " + exhibit.getName());
            } else {
                System.out.println("Hall " + (hall + 1) + ": No exhibit scheduled");
            }
        }
    }
    /** Add an exhibit to the annual schedule, get the hall number and month desired, then get the user to add the exhibit desired.
     * 
     * @param annualPlan - The annualPlan instance should be called in to view the available halls
     * @param exhibit - the exhibits which the user wishes to select from should also be passed in
     */
    public static void addExhibitToSchedule(AnnualPlan annualPlan, ArrayList<Exhibits> exhibits) {
        int hallNumber = 0;
        int month = 0;
        int exhibitID = -1;

        // Step 1: Ask for hall number
        while (true) {
            System.out.print("Enter the hall number (1-3): ");
            hallNumber = myObj.nextInt();
            if (hallNumber >= 1 && hallNumber <= 3) {
                break;  // Valid hall number
            } else {
                System.out.println("Invalid hall number. Please enter a number between 1 and 3.");
            }
        }

        // Step 2: Ask for month number
        while (true) {
            System.out.print("Enter the month (1-12): ");
            month = myObj.nextInt();
            if (month >= 1 && month <= 12) {
                break;  // Valid month number
            } else {
                System.out.println("Invalid month. Please enter a number between 1 and 12.");
            }
        }

        // Step 3: Display available exhibits
        System.out.println("Available Exhibits:");
        for (Exhibits exhibit : exhibits) {
            exhibit.simpleExhibitDetails();
        }

        // Step 4: Ask for the Exhibit ID
        System.out.print("Enter the Exhibit ID to add: ");
        exhibitID = myObj.nextInt();

        // Step 5: Find the exhibit by ID
        Exhibits selectedExhibit = null;
        for (Exhibits exhibit : exhibits) {
            if (exhibit.getID() == exhibitID) {
                selectedExhibit = exhibit;
                break;
            }
        }
        annualPlan.addExhibit(hallNumber - 1, month - 1, selectedExhibit);
        System.out.println("Exhibit added successfully");
        } 

    


    /** View the entire schedule of the annual plan
     * 
     * @param annualPlan - pass in the instance of an annual plan
     */
     public static void viewSchedule(AnnualPlan annualPlan) {
  	    System.out.println("View Schedule...");
  	    System.out.println("Enter the month number (1-12): ");
  	    int monthNumber = -1;
  	    while (monthNumber < 1 || monthNumber > 12) {
  	        try {
  	            monthNumber = myObj.nextInt();
  	            if (monthNumber < 1 || monthNumber > 12) {
  	                System.out.println("Invalid month. Please enter a number between 1 and 12.");
  	            }
  	        } catch (Exception e) {
  	            System.out.println("Invalid input. Please enter a valid number.");
  	            myObj.nextLine(); 
  	        }
  	    }

  	    int monthIndex = monthNumber - 1;
  	    annualPlan.displayMonthExhibits(monthIndex);
  	}

     /** Remove an exhibit from the schedule, get the user to input the hall number and month desired
      * 
      * @param annualPlan - pass in the instance of the annual plan
      */
     public static void removeExhibitFromSchedule(AnnualPlan annualPlan) {
         System.out.println("Remove Exhibit from Schedule...");

         // Get Year Input
         int year = -1;
         while (true) {
             try {
                 System.out.print("Enter the year (e.g., 2024): ");
                 String yearInput = myObj.nextLine().trim(); 
                 if (yearInput.isEmpty()) {
                     System.out.println("Error: Year cannot be empty. Please enter a valid year.");
                     continue;
                 }
                 year = Integer.parseInt(yearInput); 
                 break;
             } catch (Exception e) {
                 System.out.println("Error: Invalid year. Please enter a valid year.");
             }
         }
         int hallNumber = -1;
         while (true) {
             try {
                 System.out.print("Enter the hall number (1-3): ");
                 String hallInput = myObj.nextLine().trim();
                 if (hallInput.isEmpty()) {
                     System.out.println("Error: Hall number cannot be empty. Please enter a hall number between 1 and 3.");
                     continue;
                 }
                 hallNumber = Integer.parseInt(hallInput);
                 if (hallNumber < 1 || hallNumber > 3) {
                     System.out.println("Error: Invalid hall number. Please enter a hall number between 1 and 3.");
                     continue; 
                 }
                 break; 
             } catch (Exception e) {
                 System.out.println("Error: Invalid input. Please enter a valid number for hall.");
                 myObj.nextLine();
             }
         }
         int month = -1;
         while (true) {
             try {
                 System.out.print("Enter the month (1-12): ");
                 String monthInput = myObj.nextLine().trim();
                 if (monthInput.isEmpty()) {
                     System.out.println("Error: Month cannot be empty. Please enter a month number between 1 and 12.");
                     continue; 
                 }
                 month = Integer.parseInt(monthInput);
                 if (month < 1 || month > 12) {
                     System.out.println("Error: Invalid month number. Please enter a valid month between 1 and 12.");
                     continue; 
                 }
                 break; 
             } catch (Exception e) {
                 System.out.println("Error: Invalid input. Please enter a valid number for month.");
                 myObj.nextLine(); 
             }
         }
         Exhibits exhibit = annualPlan.getExhibit(hallNumber, month - 1);
         if (exhibit == null) {
             System.out.println("No exhibit is scheduled in this hall and month for the year " + annualPlan.getYearName() + ".");
         } else {
             annualPlan.addExhibit(hallNumber, month - 1, null); 
             System.out.println("Exhibit removed from the schedule for " + annualPlan.getYearName() + ".");
         }
     }
     /**
      * Deletes a specified annual plan from the list after confirming the user's input.
      * The user is prompted to confirm the deletion by spelling out "DELETE".
      * 
      * @param annualPlan The annual plan to be deleted.
      * @param annualPlans The list of annual plans from which the specified plan will be removed.
      */
     public static void deleteAnnualPlan(AnnualPlan annualPlan, ArrayList<AnnualPlan> annualPlans) {
         // Ask the user to confirm deletion by typing "DELETE"
         System.out.print("Are you sure you want to delete the annual plan for " + annualPlan.getYearName() + "? Type 'DELETE' to confirm: ");
         
         String userConfirmation = myObj.nextLine().trim();
         
         // Check if the user typed 'DELETE'
         if ("DELETE".equalsIgnoreCase(userConfirmation)) {
             // Remove the annual plan from the list
             annualPlans.remove(annualPlan);
             System.out.println("Annual plan for " + annualPlan.getYearName() + " has been deleted.");
         } else {
             System.out.println("Deletion cancelled. The annual plan for " + annualPlan.getYearName() + " was not deleted.");
         }
     }

}
