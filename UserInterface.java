import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
				
				case "evalfun":
					System.out.println("Variables for non-pitchers: bA, hR, r, h, sO --- No Division");
			        System.out.print("Enter for non-pitchers: ");
			        String evalExpression = scnr.nextLine().trim();
			        if (evalExpression.isEmpty()) {
			            System.out.println("expression was not provided.");
			            break;
			        }
			        fantasyDraft.evalFun(evalExpression);
			        System.out.println("Non-pitchers sorted successfully using the given expression.");
			        break;

			    	case "pevalfun":
			    		System.out.println("Variables for pitchers: sO,iP, h,r, hR --- No Division");
				        System.out.print("Enter for pitchers: ");
				        String evalExpressionForPitchers = scnr.nextLine().trim();
				        if (evalExpressionForPitchers.isEmpty()) {
				            System.out.println("expression was not provided.");
				            break;
				        }
				        fantasyDraft.pEvalFun(evalExpressionForPitchers);
				        System.out.println("Pitchers sorted successfully");
				        break;
				
			    	case "overall":
					System.out.print("Enter player position or leave blank: ");
					userInput = scnr.nextLine().trim();
					System.out.println(userInput);
					fantasyDraft.overall(userInput);
					break;

				case "poverall":
					fantasyDraft.pOverall();
					break;

				case "stars":
					System.out.print("Enter a team letter: ");
					char teamChar1 = scnr.nextLine().charAt(0);
					fantasyDraft.stars(teamChar1);
					break;
				case "team":
					System.out.print("Enter a team letter: ");
					char teamChar2 = scnr.nextLine().charAt(0);
					fantasyDraft.team(teamChar2);
					break;
				case "save":
					save();
					break;
				case "restore":
					restore();
					break;
				default:
					System.out.println("Invalid Command: Type \"help\" to see possible commands");
			
			}
		}
	}
	
	private void executeCommand(FantasyDraft command) {
		return;
	}
	public void save() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter name of file to save Draft to: ");
		String input = in.nextLine();
	
		try {
			FileOutputStream fos = new FileOutputStream(input);
		    ObjectOutputStream oos = new ObjectOutputStream(fos); 

		  oos.writeObject(fantasyDraft);
		  System.out.println("Draft has been saved to " + input);
		}catch(Exception e) {
			System.out.println("Error while saving Draft");
		}
	}
	public void restore() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter name of file collection is saved at: ");
		String input = in.nextLine();
		try {
			FileInputStream fis = new FileInputStream(input);
		    ObjectInputStream ois = new ObjectInputStream(fis); 

		    fantasyDraft = (DraftSystem)ois.readObject();
		  System.out.println("fantasyDraft has been restored from " + input);
		}catch(Exception e) {
			System.out.println("Error while restoring Draft");
		}
	}
	private void exit() {
		//ask user if they want to save first
		System.exit(0);
	}
	private void showCommands() {
		System.out.println("Available Commands: exit, help, overall, poverall, stars, team, iDraft, oDraft, evalfun, pevalfun, save, restore");
	}
}
