package part03;

public class Validations {
	// Method to validate the artifact's name
	   public static boolean validateName(String name) {
	      // Check if the name is null or empty
	      if (name == null || name.trim().isEmpty()) {
	         QUBMediaMuseum.console.println("Name cannot be empty. Please try again.");
	         return false;
	      }

	      // Check for invalid characters using regex
	      if (name.matches(".*[!<>?+=}{}\\[\\]@#$%^&*()].*")) {
	         QUBMediaMuseum.console.println("Name cannot contain special characters like !, <, >, ?, +, =, }, {, [, ], @, #, $, %, ^, &, *.");
	         return false;
	      }
	      else if(isInteger(name)) {
	    	  QUBMediaMuseum.console.println("Name cannot be an integer please provide text with the name");
	    	  return false;
	      }
	      else if(name.length()>40) {
	    	  QUBMediaMuseum.console.println("Name cannot be more than 40 characters");
	    	  return false;
	      }

	      // If all checks pass, the name is valid
	      return true;
	   }
	   public static boolean validateDescription(String description) {
	       // Check if the description is empty or just spaces
	       if (description == null || description.trim().isEmpty()) {
	          QUBMediaMuseum.console.println("Description cannot be empty or just whitespace. Please try again.");
	          return false;
	       }

	       // Check if the description contains  !, ?, <, >, =, }, {, [, ], @, #, $, %, ^, &, *
	       if (description.matches(".*[!<>?+=}{\\[\\]@#$%^&*()].*")) {
	          QUBMediaMuseum.console.println("Description cannot contain special characters like !, <, >, ?, +, =, }, {, [, ], @, #, $, %, ^, &, *.");
	          return false;
	       }
	       else if(isInteger(description)) {
		    	  QUBMediaMuseum.console.println("Description cannot be an integer please provide text with the description");
		    	  return false;
		      }
	       else if(description.length()>80) {
		    	  QUBMediaMuseum.console.println("Description cannot be more than 80 characters");
		    	  return false;
		      }

	       // If all checks pass, the description is valid
	       return true;
	    }
	   public static boolean isInteger(String str) {
	        try {
	            Integer.parseInt(str);  
	            return true;             
	        } catch (NumberFormatException e) {
	            return false;            
	        }
	    }

}
	