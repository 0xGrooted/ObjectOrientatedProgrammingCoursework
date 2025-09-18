package part01;

public enum ArtifactType {
    PAINTING("Painting"),
    SCULPTURE("Sculpture"),
    DIGITAL("Digital"),
    INTERACTIVE("Interactive"),
    TACTILE("Tactile"),
    OTHER("Other");
	

    private String typeName;

    ArtifactType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
    // method to display all of the display types but with a number beside it
    public static void displayTypesWithNumbers() {   
    	ArtifactType[] type = ArtifactType.values();
    	
        for(int i =0;i<ArtifactType.values().length;i++) {
        	System.out.println((i) + ": " + type[i].getTypeName());
        }
    }
    // need to convert users input from number to actual
    public static ArtifactType findFromNumber(int id) {
    	// create a temporary array to compare to
    	ArtifactType[] types = ArtifactType.values();
    	// if id is greater than the size of types then return false
    	if(id > ArtifactType.values().length) {return types[5];}
    	else {
        return types[id]; 
    	}
    }
    
}
