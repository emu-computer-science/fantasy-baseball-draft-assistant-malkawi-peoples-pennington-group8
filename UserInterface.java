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
	private void exit() {
		//ask user if they want to save first
		System.exit(0);
	}
	private void showCommands() {
		System.out.println("Available Commands: exit");
	}
}
