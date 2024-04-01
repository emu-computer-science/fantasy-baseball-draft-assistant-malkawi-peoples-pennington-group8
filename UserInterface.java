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
			if(userInput.equalsIgnoreCase("exit")) {
				exit();
			}else if(userInput.equalsIgnoreCase("help")){
				showCommands();
			}else {
				System.out.println("Invalid Command: Type \"help\" to see possible commands");
			}
		}
		
		
	}
	private boolean parseCommand(String userInput) {
		if (userInput.toUpperCase().startsWith("IDRAFT ")) {
            String playerName = userInput.substring(7).replace("\"", "");
            fantasyDraft.iDraft(playerName, 'A');
        } else if (userInput.toUpperCase().startsWith("ODRAFT ")) {
            String[] parts = userInput.split(" ");
            if (parts.length < 3) {
                System.out.println("Invalid command format for ODRAFT.");
                return false;
			}
		}
		return true;
	}

	private void executeCommand(FantasyDraft command) {
		return;
	}

	private void exit() {
		//ask user if they want to save first
		System.exit(0);
	}
	private void showCommands() {
		System.out.println("Available Commands: exit");
	}
}
