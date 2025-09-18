package part03;

import javax.swing.*;
import java.io.File;

public class FileUpload {

    // Method to upload a file via JFileChooser (GUI)
    public static File uploadFile() {
        // Create a JFileChooser instance
        JFileChooser fileChooser = new JFileChooser();

        // Set the dialog title
        fileChooser.setDialogTitle("Select a File to Upload");

        // Open the file chooser dialog
        int result = fileChooser.showOpenDialog(null);

        // Check if the user selected a file (not canceled)
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File selected: " + selectedFile.getAbsolutePath());

            // Return the selected file
            return selectedFile;
        } else {
            System.out.println("No file selected.");
            return null;
        }
    }
}
