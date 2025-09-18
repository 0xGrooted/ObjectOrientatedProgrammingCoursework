package part02;

import java.util.ArrayList;

public class AnnualPlanTest {

    public static void annPlanTC01() {
        System.out.println("annPlanTC01 - Testing construction of an Annual Plan");
        System.out.println("Expected result - The annual plan should be initialized with 3 halls and 12 months.");
        System.out.println("All months should then be outputted in the format 'Month x: No exhibit schedule', x should be >0 and<13 '");
        AnnualPlan plan = new AnnualPlan(0);
        plan.displayHallExhibits(1); plan.displayHallExhibits(2);plan.displayHallExhibits(3);
    }
    public static void annPlanTC02() {
        System.out.println("annPlanTC02 - Testing displayHallExhibits(hallNumber) with an invalid hall number [Boundary Values]");
        System.out.println("Expected result - The annual plan should be initialized with 3 halls and 12 months.");
        System.out.println("The month with the hall number > 3 and < 1  should not be displayed an error message should appear 'Invalid hall Number', the rest should appear.");
        AnnualPlan plan = new AnnualPlan(0);
        System.out.println("Greater than 3; \n");
        plan.displayHallExhibits(2);plan.displayHallExhibits(3);plan.displayHallExhibits(4);
        System.out.println("\nLess than 1; \n");
        plan.displayHallExhibits(0);plan.displayHallExhibits(1);plan.displayHallExhibits(2);
    }

    public static void annPlanTC03() {
        System.out.println("annPlanTC03 - Testing addExhibit with valid parameters passed into the DisplayHallExhibits().");
        System.out.println("Expected result - The exhibit 'Mona Lisa' should be added to Hall 1, Month 1. and should then be outputted");
        
        AnnualPlan plan = new AnnualPlan(0);
        
        ArrayList<Artifacts> artifacts = new ArrayList<>();
        artifacts.add(new Artifacts(34, "Interactive Digital Sculpture", ArtifactType.INTERACTIVE, 2, "A digital sculpture that users can modify and interact with using technology."));
        artifacts.add(new Artifacts(35, "Tactile Ancient Artefacts", ArtifactType.TACTILE, 1000, "A collection of tactile replicas of ancient artefacts for sensory exploration."));
        artifacts.add(new Artifacts(36, "Digital Street Art", ArtifactType.DIGITAL, 1, "Digital art inspired by street art, displayed on virtual walls."));
        Exhibits exhibit = new Exhibits(1, "Mona Lisa", "A collection of classic paintings from the Renaissance period.", new ArrayList<Artifacts>());
        exhibit.getArtifacts().add(artifacts.get(0));  
        exhibit.getArtifacts().add(artifacts.get(1));  
        exhibit.getArtifacts().add(artifacts.get(2));  
        
        plan.addExhibit(1, 0, exhibit);  
        plan.displayHallExhibits(1);  
    }

    public static void annPlanTC04() {
        System.out.println("annPlanTC04 - Testing addExhibit with an invalid hall number passed into the parameter");
        System.out.println("Expected result - An error message should be printed indicating an invalid hall number.");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit = new Exhibits(1, "Mona Lisa", "Famous painting by Leonardo da Vinci.", new ArrayList<>());
        int invalidHallNumber = 4;
        plan.addExhibit(invalidHallNumber, 0, exhibit);  
        plan.displayHallExhibits(1);  
    }

    public static void annPlanTC05() {
        System.out.println("annPlanTC05 - Testing addExhibit with an invalid month index.");
        System.out.println("Expected result - An error message should be printed indicating to the user an invalid month index has been passed in");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit = new Exhibits(1, "Starry Night", "Famous painting by Vincent van Gogh.", new ArrayList<>());
        int invalidMonth = 13;
        plan.addExhibit(1, invalidMonth, exhibit);
        plan.displayHallExhibits(1);  
    }


    public static void annPlanTC06() {
        System.out.println("annPlanTC06 - Testing getExhibit with valid parameters passed in");
        System.out.println("Expected result - The exhibit 'Mona Lisa' should be retrieved from Hall 1, Month 1.");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit = new Exhibits(1, "Mona Lisa", "Famous painting by Leonardo da Vinci.", new ArrayList<>());
        plan.addExhibit(1, 0, exhibit);
        Exhibits retrievedExhibit = plan.getExhibit(1, 0);  
        System.out.println("Retrieved exhibit: " + (retrievedExhibit != null ? retrievedExhibit.getName() : "No exhibit found"));
    }

    public static void annPlanTC07() {
        System.out.println("annPlanTC07 - Testing getExhibit with invalid paramters passed in.");
        System.out.println("Expected result - An error message should be printed to the user.");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit = new Exhibits(1, "The Persistence of Memory", "Famous surreal painting by Salvador Dali.", new ArrayList<>());
        plan.addExhibit(2, 2, exhibit);
        
        Exhibits retrievedExhibit = plan.getExhibit(4, 0);
        System.out.println("Retrieved exhibit: " + (retrievedExhibit != null ? retrievedExhibit.getName() : "No exhibit found"));
    }

    public static void annPlanTC08() {
        System.out.println("annPlanTC08 - Testing displayHallExhibits with valid hall number");
        System.out.println("Expected result - The exhibit in Hall 2, Month 3 should be displayed.");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit = new Exhibits(2, "Starry Night", "Famous painting by Vincent van Gogh.", new ArrayList<>());
        plan.addExhibit(2, 2, exhibit);
        plan.displayHallExhibits(2); 
    }

    public static void annPlanTC09() {
        System.out.println("annPlanTC09 - Testing displayMonthExhibits testing boundary values of the month index as the parameter");
        System.out.println("Expected result - All exhibits for Month 1 across all halls should be displayed.");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit1 = new Exhibits(1, "Mona Lisa", "Famous painting by Leonardo da Vinci.", new ArrayList<>());
        Exhibits exhibit2 = new Exhibits(2, "The Persistence of Memory", "Famous surreal painting by Salvador Dali.", new ArrayList<>());
        plan.addExhibit(1, 1, exhibit1);  
        plan.addExhibit(2, 1, exhibit2);  
        plan.displayMonthExhibits(0);  plan.displayMonthExhibits(-1); plan.displayMonthExhibits(1);
    }

    public static void annPlanTC10() {
        System.out.println("annPlanTC10 - Testing adding an exhibit to the last month.");
        System.out.println("Expected result - The exhibit 'The Kiss' should be added to the last month of Hall 3.");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit = new Exhibits(3, "The Kiss", "A famous painting by Gustav Klimt.", new ArrayList<>());
        plan.addExhibit(3, 11, exhibit);  
        plan.displayHallExhibits(3);  
    }

    public static void annPlanTC11() {
        System.out.println("annPlanTC11 - Testing adding exhibit to the first month.");
        System.out.println("Expected result - The exhibit 'The Scream' should be added to the first month of Hall 1.");
        
        AnnualPlan plan = new AnnualPlan(0);
        Exhibits exhibit = new Exhibits(1, "The Scream", "Famous painting by Edvard Munch.", new ArrayList<>());
        plan.addExhibit(1, 0, exhibit);  
        plan.displayHallExhibits(1); 
    }
    public static void annPlanTC12() {
	    System.out.println("annPlanTC12 - Testing removing an exhibit from an empty hall and month.");
	    System.out.println("Expected result - The system should indicate no exhibit is scheduled in this hall and month.");
	    
	    AnnualPlan plan = new AnnualPlan(0);
	    plan.removeExhibitFromSchedule(plan);
	}
 public static void annPlanTC13() {
	    System.out.println("annPlanTC13 - Testing adding an exhibit to a month already containing an exhibit.");
	    System.out.println("Expected result - The exhibit should be overwritten");
	    
	    AnnualPlan plan = new AnnualPlan(0);
	    Exhibits exhibit1 = new Exhibits(1, "Mona Lisa", "Famous painting by Leonardo da Vinci.", new ArrayList<>());
	    plan.addExhibit(1, 0, exhibit1);  
	    Exhibits exhibit2 = new Exhibits(1, "The Persistence of Memory", "Famous surreal painting by Salvador Dali.", new ArrayList<>());
	    plan.addExhibit(1, 0, exhibit2); 
	    plan.displayHallExhibits(1);  
	}
 public static void annPlanTC14() {
	    System.out.println("annPlanTC14 - Testing adding a null exhibit to a hall and month.");
	    System.out.println("Expected result - The system should reject the null exhibit and display an error message.");
	    
	    AnnualPlan plan = new AnnualPlan(0);
	    plan.addExhibit(1, 0, null);  
	    plan.displayHallExhibits(1);  
	}
 public static void annPlanTC15() {
	    System.out.println("annPlanTC15 - Testing invalid user input for hall number and month.");
	    System.out.println("Expected result - The system should reject non-numeric input and prompt the user again.");
	    
	    AnnualPlan plan = new AnnualPlan(0);
	    AnnualPlan.addExhibitToSchedule(plan, new ArrayList<Exhibits>());
	}
 public static void annPlanTC16() {
	    System.out.println("annPlanTC16 - Testing invalid hall number and month index (negative or zero).");
	    System.out.println("Expected result - The system should print an error message for invalid negative or zero inputs.");
	    
	    AnnualPlan plan = new AnnualPlan(0);
	    plan.addExhibit(-1, 0, new Exhibits(1, "Starry Night", "Famous painting by Vincent van Gogh.", new ArrayList<>()));
	    plan.addExhibit(0, 0, new Exhibits(1, "Starry Night", "Famous painting by Vincent van Gogh.", new ArrayList<>()));
	    plan.addExhibit(1, -1, new Exhibits(1, "Starry Night", "Famous painting by Vincent van Gogh.", new ArrayList<>()));
	    plan.addExhibit(1, 12, new Exhibits(1, "Starry Night", "Famous painting by Vincent van Gogh.", new ArrayList<>()));
	    plan.displayHallExhibits(1); 
	}

 public static void annPlanTC17() {
	    System.out.println("annPlanTC17 - Testing whether an exhibit can be removed from the annual plan with valid parameters passed in");
	    System.out.println("Expected result - The system should print a message saying exhibit removed from schedule");
	    
	    AnnualPlan plan = new AnnualPlan(0);
	    plan.addExhibit(1, 1, new Exhibits(1, "Starry Night", "Famous painting by Vincent van Gogh.", new ArrayList<>()));
	    plan.displayHallExhibits(1); 
	    plan.removeExhibitFromSchedule(plan);
	    plan.displayHallExhibits(1); 
	}
 public static void annPlanTC18() {
	 System.out.println("annPlanTC18 - Testing the creation of a new annual plans year will go to the next year");
	    System.out.println("Expected result - The system should print a message saying the next annual plans name is 2025 when the user adds it");
	    
	    QUBMuseum.manageAnnualSchedule();
 }
 

    public static void main(String[] args) {
    	annPlanTC01();
    	annPlanTC02();
    	annPlanTC03();
    	annPlanTC04();
    	annPlanTC05();
    	annPlanTC06();
        annPlanTC07();
        annPlanTC08();
        annPlanTC09();
        annPlanTC10();
        annPlanTC11();
        annPlanTC12();
        annPlanTC13();
        annPlanTC14();
        annPlanTC15();
        annPlanTC16();
    	annPlanTC17();
        annPlanTC18();
    	}
}

