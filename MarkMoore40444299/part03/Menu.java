package part03;

public class Menu {
    private String items[];
    private String title;

    public Menu(String title, String data[]) {
        this.title = title;
        this.items = data;
    }

    private void display() {
        // Display the menu title
        QUBMediaMuseum.console.println(title);

        // Print a separator line under the title (same length as the title)
        for (int count = 0; count < title.length(); count++) {
            QUBMediaMuseum.console.print("+");
        }
        QUBMediaMuseum.console.println(); // New line after the separator

        // Display the menu items
        for (int option = 1; option <= items.length; option++) {
            QUBMediaMuseum.console.println(option + ". " + items[option - 1]);
        }
        QUBMediaMuseum.console.println(); // New line for readability
    }

    public int getUserChoice() {
        boolean validChoice = false; // To check if the user made a valid choice
        int value = 0;

        // Keep displaying the menu and asking for input until a valid choice is entered
        do {
            display();  // Show the menu
            QUBMediaMuseum.console.print("Enter Selection: ");

            try {
                String input = QUBMediaMuseum.console.readLn();
                value = Integer.parseInt(input);

                // Check if the input value is within valid range
                if (value >= 1 && value <= items.length) {
                    validChoice = true;  // Valid choice, break out of the loop
                } else {
                    QUBMediaMuseum.console.println("Invalid input. Please select a valid option (1-" + items.length + ").");
                }
            } catch (NumberFormatException ex) {
                // Handle case where input is not an integer
                QUBMediaMuseum.console.println("Invalid input. Please enter a number between 1 and " + items.length + ".");
            }
        } while (!validChoice);  // Keep asking for input until valid

        return value;  // Return the valid choice
    }
}



