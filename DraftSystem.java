import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class DraftSystem {
	private ArrayList<BaseBallPlayer> baseBallPlayers;
	private ArrayList<Pitcher> pitchers;

	private PlayerTeam teamA, teamB, teamC, teamD;

	public DraftSystem() {
		// initialize empty arrayLists for teams
		teamA = new PlayerTeam('A');
		teamB = new PlayerTeam('B');
		teamC = new PlayerTeam('C');
		teamD = new PlayerTeam('D');

		// to do:parse the file so that it cuts up the contents into seperate string
		// looking for a (char num num) sequence
		// To Do: Read the PlayerList.txt file into baseBallPlayers
		pitchers = new ArrayList<>();
		baseBallPlayers = new ArrayList<>();
		String fullPlayerList = "";
		try {
			// baseball player file
			Scanner fileReader = new Scanner(new File("PlayerList.txt"));
			while (fileReader.hasNextLine()) {
				fullPlayerList += fileReader.nextLine();

			}
			// System.out.println(fullPlayerList);

			String[] playerStrings = fullPlayerList.split("(?<=[a-zA-Z]{3}\\d{2})");

			for (String playerInfo : playerStrings) {
				baseBallPlayers.add(new BaseBallPlayer(playerInfo));
			}

			// pitcher file
			fileReader = new Scanner(new File("PitcherList.txt"));
			fullPlayerList = "";
			while (fileReader.hasNextLine()) {
				fullPlayerList += fileReader.nextLine();

			}
			// System.out.println(fullPlayerList);

			playerStrings = fullPlayerList.split("(?<=[a-zA-Z]{3}\\d{2})");

			for (String pitcherInfo : playerStrings) {
				pitchers.add(new Pitcher(pitcherInfo));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error creating Draft");
			e.printStackTrace();
		}

	}

	// To Do: Check if the position of wanted player is already in team
	public void iDraft(String lastName, char firstInitial) {
		boolean playerFound = false;
		
		for (BaseBallPlayer player : baseBallPlayers) {
			String playerLast = player.getLastName();
			char playerFirstInitial = player.getFirstName().charAt(0);

			if (lastName.equalsIgnoreCase(playerLast) && Character.toUpperCase(firstInitial) == playerFirstInitial) {
				if (player.getIsDrafted()) {
					System.out.println("Player already drafted");
				} else {
					teamA.addToTeam(player);
					System.out.println(player.getLastName() + "has been drafted to team A");
				}
				playerFound = true;
				break;

			}
		}
		//if player is not found in baseBallPlayers, look through pitchers
		if(playerFound == false) {
			
			for (Pitcher player : pitchers) {
				String playerLast = player.getLastName();
				char playerFirstInitial = player.getFirstName().charAt(0);

				if (lastName.equalsIgnoreCase(playerLast)
						&& Character.toUpperCase(firstInitial) == playerFirstInitial) {
					if (player.getIsDrafted()) {
						System.out.println("Player already drafted");
					} else {
						teamA.addToTeam(player);
						System.out.println(player.getLastName() + "has been drafted to team A");
					}
					playerFound = true;
					break;

				}
			}
		}
		
		if(playerFound == false) {
			System.out.println("Could not find player");
		}

	}

	public void oDraft(String lastName, char firstInitial, char teamName) {
		boolean playerFound = false;
		PlayerTeam tempTeamVariable = null;
		switch (Character.toUpperCase(teamName)) {
		case 'A':
			tempTeamVariable = teamA;
			break;
		case 'B':
			tempTeamVariable = teamB;
			break;
		case 'C':
			tempTeamVariable = teamC;
			break;
		case 'D':
			tempTeamVariable = teamD;
			break;
		}

		
		for (BaseBallPlayer player : baseBallPlayers) {
			String playerLast = player.getLastName();
			char playerFirstInitial = player.getFirstName().charAt(0);

			if (lastName.equalsIgnoreCase(playerLast) && Character.toUpperCase(firstInitial) == playerFirstInitial) {
				if (player.getIsDrafted()) {
					System.out.println("Player already drafted");
				} else {
					tempTeamVariable.addToTeam(player);
					System.out.println(player.getLastName() + "has been drafted to team A");
				}
				playerFound = true;
				break;

			}
		}
		//if player is not found in baseBallPlayers, look through pitchers
		if(playerFound == false) {
			
			for (Pitcher player : pitchers) {
				String playerLast = player.getLastName();
				char playerFirstInitial = player.getFirstName().charAt(0);

				if (lastName.equalsIgnoreCase(playerLast)
						&& Character.toUpperCase(firstInitial) == playerFirstInitial) {
					if (player.getIsDrafted()) {
						System.out.println("Player already drafted");
					} else {
						tempTeamVariable.addToTeam(player);
						System.out.println(player.getLastName() + "has been drafted to team A");
					}
					playerFound = true;
					break;

				}
			}
		}
		

	}

	public void oDraft() {
		System.out.println("This will draft players to teams eventually");
	}

	public void team(char teamName) {
		switch (Character.toUpperCase(teamName)) {
		case 'A':
			teamA.printTeam();
			break;
		case 'B':
			teamB.printTeam();
			break;
		case 'C':
			teamC.printTeam();
			break;
		case 'D':
			teamD.printTeam();
			break;
		}
	}

	public void stars(char teamName) {
		switch (Character.toUpperCase(teamName)) {
		case 'A':
			teamA.printStars();
			break;
		case 'B':
			teamB.printStars();
			break;
		case 'C':
			teamC.printStars();
			break;
		case 'D':
			teamD.printStars();
			break;
		}
		
		System.out.println("This will eventually print teams in drafted order");
	}

	public void overall(String position) {
		// print all players if empty -- if not, print only if positions are the same
		// Sort by batting average (TEMPORAY)
		ArrayList<BaseBallPlayer> tempList = baseBallPlayers;

		tempList.sort(Comparator.comparingDouble(player -> player.getBA()));

		if (position.isEmpty()) {
			for (BaseBallPlayer player : tempList) {
				System.out.println(player.toString() + player.getBA());
			}
		} else {
			for (BaseBallPlayer player : tempList) {
				if (position.equalsIgnoreCase(player.getPosition())) {
					System.out.println(player.toString() + player.getBA());
				}

			}
		}
		System.out.println("This will print players eventually");
	}

	public void pOverall() {
		// only printing top 50 pitchers
		ArrayList<Pitcher> tempList = pitchers;

		tempList.sort(Comparator.comparingDouble(player -> ((Pitcher) player).getSO()).reversed());

		int count = 0;
		for (Pitcher player : tempList) {
			if (count == 50) {
				break;
			}
			System.out.println(player.toString() + player.getSO());
			count++;

		}

		System.out.println("This will print players eventually");
	}

	public void evalFun() {
		System.out.println("This will set the evaluation funaction for overall() eventually");
	}

	public void pEvalFun() {
		System.out.println("This will set the evaluation function for pOverall() eventually");
	}
}
