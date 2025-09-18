package part02;

public class ValidationsTest {
	public static void main(String[] args) {
		ValidationsTC01();
		ValidationsTC02();
		ValidationsTC03();
		ValidationsTC04();
		ValidationsTC05();
		ValidationsTC06();
		ValidationsTC07();
		ValidationsTC08();
		ValidationsTC09();
		ValidationsTC10();
		ValidationsTC11();
		ValidationsTC12();
	}

	public static void ValidationsTC01() {
	    System.out.println("Test ValidationsTC01 - Testing validateName with a valid name");
	    System.out.println("Expected result - The name should be validated successfully, returning true.");

	    String name = "ArtifactName";
	    boolean result = Validations.validateName(name);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC02() {
	    System.out.println("Test ValidationsTC02 - Testing validateName with an empty string");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String name = "";
	    boolean result = Validations.validateName(name);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC03() {
	    System.out.println("Test ValidationsTC03 - Testing validateName with null input");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String name = null;
	    boolean result = Validations.validateName(name);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC04() {
	    System.out.println("Test ValidationsTC04 - Testing validateName with special characters");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String name = "Artifact@123!";
	    boolean result = Validations.validateName(name);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC05() {
	    System.out.println("Test ValidationsTC05 - Testing validateName with an integer string");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String name = "12345";
	    boolean result = Validations.validateName(name);

	    System.out.println("Validation Result: " + result);
	}
	public static void ValidationsTC06() {
	    System.out.println("Test ValidationsTC06 - Testing Length of name 39 characters, 40 and 41");
	    System.out.println("Expected result - The description should be validated successfully, returning true.\n");

	    String name = "123456789 123456789 123456789 123456789";
	    boolean result = Validations.validateName(name);
	    System.out.println("Validation Result of 39: " + result + "\n");
	    name = "123456789 123456789 123456789 123456789 ";
	    result = Validations.validateName(name);
	    System.out.println("Validation Result of 40: " + result + "\n");
	    name = "123456789 123456789 123456789 123456789 1";
	    result = Validations.validateName(name);
	    System.out.println("Validation Result of 41: " + result);
	}

	public static void ValidationsTC07() {
	    System.out.println("Test ValidationsTC07 - Testing validateDescription with a valid description");
	    System.out.println("Expected result - The description should be validated successfully, returning true.");

	    String description = "This is a valid description.";
	    boolean result = Validations.validateDescription(description);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC08() {
	    System.out.println("Test ValidationsTC08 - Testing validateDescription with null input");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String description = null;
	    boolean result = Validations.validateDescription(description);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC09() {
	    System.out.println("Test ValidationsTC09 - Testing validateDescription with an empty string");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String description = " ";
	    boolean result = Validations.validateDescription(description);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC10() {
	    System.out.println("Test ValidationsTC10 - Testing validateDescription with special characters");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String description = "Description with @#$%^& special characters.";
	    boolean result = Validations.validateDescription(description);

	    System.out.println("Validation Result: " + result);
	}

	public static void ValidationsTC11() {
	    System.out.println("Test ValidationsTC11 - Testing validateDescription with an integer string");
	    System.out.println("Expected result - The validation should fail, returning false, and an appropriate message should be displayed.");

	    String description = "12345";
	    boolean result = Validations.validateDescription(description);

	    System.out.println("Validation Result: " + result);
	}
	public static void ValidationsTC12() {
	    System.out.println("Test ValidationsTC12 - Testing Length of description 81 characters, 80 and 79");
	    System.out.println("Expected result - The description should be validated successfully, returning true.\n");

	    String name = "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 1";
	    boolean result = Validations.validateName(name);
	    System.out.println("Validation Result of 81: " + result + "\n");
	    name = "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ";
	    result = Validations.validateName(name);
	    System.out.println("Validation Result of 80: " + result + "\n");
	    name = "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789";
	    result = Validations.validateName(name);
	    System.out.println("Validation Result of 79: " + result);
	}
}
