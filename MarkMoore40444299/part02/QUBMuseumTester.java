package part02;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class QUBMuseumTester {
	
	   private static QUBMuseum qubMuseum;
	   
	   // Eclipse only allowing if surrounded with try catch...
	   public static void main(String[] args) {
		   
	   
		   try {
				manageArtifacts();
			} catch (Exception e) {
				e.printStackTrace();
			}
		   
		   
	   }
	    public void setup() {
	        qubMuseum = new QUBMuseum(); // Initialize the QUBMuseum object before each test
	    }
	    public static void manageArtifacts() throws Exception {
	        // Use reflection to access private fields and methods
	        Method Method = QUBMuseum.class.getDeclaredMethod("manageArtifacts");
	        Method.setAccessible(true); // Make the private method accessible

	        // Get the private `artifacts` field
	        Field artifactsField = QUBMuseum.class.getDeclaredField("artifacts");
	        artifactsField.setAccessible(true); // Make the private field accessible

	        // Invoke the addArtifact method
	        Method.invoke(qubMuseum);
	    }
	    
}

