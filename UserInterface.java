import java.util.Scanner;

public class UserInterface {
	private DraftSystem fantasyDraft;

	public UserInterface() {
		fantasyDraft = new DraftSystem();
		showPrompt();
	}

	private void showPrompt() {
		Scanner scnr = new Scanner(System.in);
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("Enter A Command: ");
			String userInput = scnr.nextLine();
			switch (userInput.toLowerCase()) {
				case "exit":
					exit();
					break;

				case "help":
					showCommands();
					break;

				case "idraft":
					System.out.print("Enter last name: ");
					String lastName = scnr.nextLine().trim();
					System.out.print("Enter a character: ");
					String input = scnr.nextLine().trim();
					if (input.length() > 0) {
						char playerFirstInitial = input.charAt(0);
						fantasyDraft.iDraft(lastName, playerFirstInitial);
					} else {
						System.out.println("Initial was not provided.");
					}
					break;
				
				case "odraft":
					System.out.print("Enter last name: ");
					String lastName2 = scnr.nextLine().trim();
					
					System.out.print("Enter the first initial: ");
					String initialInput = scnr.nextLine().trim();
					if (initialInput.length() == 0) {
						System.out.println("First initial was not provided.");
						break;
					}
					char firstInitial = initialInput.charAt(0);
	
					System.out.print("Enter team name A, B, C, D: ");
					String teamNameInput = scnr.nextLine().trim().toUpperCase();
					if (teamNameInput.length() == 0 || (teamNameInput.charAt(0) != 'A' && teamNameInput.charAt(0) != 'B' && teamNameInput.charAt(0) != 'C' && teamNameInput.charAt(0) != 'D')) {
						System.out.println("Invalid team name provided. Must be A, B, C, D.");
						break;
					}
					char teamName = teamNameInput.charAt(0);
	
					fantasyDraft.oDraft(lastName2, firstInitial, teamName);
					break;

				case "overall":
					fantasyDraft.overall(userInput);
					break;

				case "poverall":
					fantasyDraft.pOverall();
					break;

				case "stars":
					fantasyDraft.stars('c');
					break;

				default:
					System.out.println("Invalid Command: Type \"help\" to see possible commands");
			
			}
		}
	}
	
	private void executeCommand(FantasyDraft command) {
		return;
	}

	private void exit() {
		//ask user if they want to save first
		System.exit(0);
	}
	private void showCommands() {
		System.out.println("Available Commands: exit, help, overall, poverall, stars");
	}
}

