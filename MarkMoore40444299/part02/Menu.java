package part02;

import java.util.Scanner;

public class Menu {
	private String items[];
	private String title;
	private Scanner input;

	public Menu(String title, String data[]) {
		this.title = title;
		this.items = data;
		this.input = new Scanner(System.in);
	}

	private void display() {
		System.out.println(title);
		for (int count = 0; count < title.length(); count++) {
			System.out.print("+");
		}
		System.out.println();
		for (int option = 1; option <= items.length; option++) {
			System.out.println(option + ". " + items[option - 1]);
		}
		System.out.println();
	}

	public int getUserChoice() {
		boolean validChoice = false; // To check if the user made a valid choice
        int value = 0;

        // Keep displaying the menu and asking for input until a valid choice is entered
        do {
            display();  // Show the menu
            System.out.print("Enter Selection: ");

            try {
                value = input.nextInt();  // Try reading the input as an integer
                if (value >= 1 && value <= items.length) {  // Check if it's within valid range
                    validChoice = true;  // Valid choice, break out of the loop
                } else {
                    System.out.println("Invalid input. Please select a valid option (1-" + items.length + ").");
                }
            } catch (Exception ex) {
                input.nextLine();  // Clear the buffer
                System.out.println("Invalid input. Please enter a number between 1 and " + items.length + ".");
            }
        } while (!validChoice);  // Keep asking for input until valid

        return value;
	}
}
