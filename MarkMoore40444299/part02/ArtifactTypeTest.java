package part02;

public class ArtifactTypeTest {
	
	    public static void main(String[] args) {
	        ArtifactTypeTest.ArtifactTypeTC01();
	        ArtifactTypeTest.ArtifactTypeTC02();
	        ArtifactTypeTest.ArtifactTypeTC03();
	        ArtifactTypeTest.ArtifactTypeTC04();
	        ArtifactTypeTest.ArtifactTypeTC05();
	    }
	
    public static void ArtifactTypeTC01() {
        System.out.println("Test ArtifactTypeTC01 - Testing getTypeName method");
        System.out.println("Expected result - The type name should match the expected string for each art type.");

        System.out.println("Painting: " + ArtifactType.PAINTING.getTypeName()); 
        System.out.println("Sculpture: " + ArtifactType.SCULPTURE.getTypeName()); 
        System.out.println("Digital: " + ArtifactType.DIGITAL.getTypeName()); 
        System.out.println("Interactive: " + ArtifactType.INTERACTIVE.getTypeName()); 
        System.out.println("Tactile: " + ArtifactType.TACTILE.getTypeName()); 
        System.out.println("Other: " + ArtifactType.OTHER.getTypeName()); 
    }


    public static void ArtifactTypeTC02() {
        System.out.println("Test ArtifactTypeTC02 - Testing the displayTypesWithNumbers method");
        System.out.println("Expected result - Display all art types with corresponding numbers.");
        ArtifactType.displayTypesWithNumbers();
    }
    public static void ArtifactTypeTC03() {
        System.out.println("Test ArtifactTypeTC03 - Testing findFromNumber method with valid index values.");
        System.out.println("Expected result - Return correct art type for each index.");

        System.out.println("Type for ID 0: " + ArtifactType.findFromNumber(0)); 
        System.out.println("Type for ID 1: " + ArtifactType.findFromNumber(1)); 
        System.out.println("Type for ID 2: " + ArtifactType.findFromNumber(2)); 
        System.out.println("Type for ID 3: " + ArtifactType.findFromNumber(3)); 
        System.out.println("Type for ID 4: " + ArtifactType.findFromNumber(4)); 
        System.out.println("Type for ID 5: " + ArtifactType.findFromNumber(5)); 
    }


    public static void ArtifactTypeTC04() {
        System.out.println("Test ArtifactTypeTC04 - Testing findFromNumber method with invalid index (out of bounds).");
        System.out.println("Expected result - Return 'Other' when id is greater than or equal to the size of enum.");

        System.out.println("Type for ID 6: " + ArtifactType.findFromNumber(6)); 
    }

    public static void ArtifactTypeTC05() {
        System.out.println("Test ArtifactTypeTC05 - Testing findFromNumber method with a negative index.");
        System.out.println("Expected result - Return 'Other' when id is negative.");

        System.out.println("Type for ID -1: " + ArtifactType.findFromNumber(-1));
    }
}
