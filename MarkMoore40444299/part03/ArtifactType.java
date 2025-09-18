package part03;


public enum ArtifactType {
    PAINTING("Painting"), // Represents Artifacts with a painting as their type
    SCULPTURE("Sculpture"), // Represents Artifacts with a sculpture as their type
    DIGITAL("Digital"), // Represents Artifacts with Digital as their type
    INTERACTIVE("Interactive"), // Represents artifacts with interactive as their type
    TACTILE("Tactile"), // Represents Artifacts with tactile as their type
    OTHER("Other");
	

    private String typeName; // The name of the Type of Artifact
    /** Constructor of the Artifact Type, used to set the TypeName for each of the enumeration variables
     * 
     * @param typeName - Passed in to set the TypeName
     */
    ArtifactType(String typeName) {
        this.typeName = typeName;
    }
    /** Gets the name of the Artifact's type and returns it as a String
     * 
     * @return - String of the Artifact Type e.g PAINTING = "Painting"
     */
    public String getTypeName() {
        return typeName;
    }
    /** Displays each of the ArtifactTypes with a number beside them. E.g 1: Painting
     * 
     */
    public static void displayTypesWithNumbers() {   
    	ArtifactType[] type = ArtifactType.values();
    	
        for(int i =0;i<ArtifactType.values().length;i++) {
        	QUBMediaMuseum.console.println((i) + ": " + type[i].getTypeName());
        }
    }
    /** Finds the artifact Type corresponding to a given number.
     * 
     * @param id - The id of the artifact which the type needs to be found
     * @return The Artifact Type from the given ID
     */
    public static ArtifactType findFromNumber(int id) {
    	ArtifactType[] types = ArtifactType.values();
    	if(id > ArtifactType.values().length) {return types[5];}
    	else {
        return types[id]; 
    	}
    }
    
}
