import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.script.ScriptException;

import java.io.*;



public class DraftSystem {
	private ArrayList<BaseBallPlayer> baseBallPlayers;
	private ArrayList<Pitcher> pitchers;

	private PlayerTeam teamA, teamB, teamC, teamD;
	private PlayerTeam currentTeamPicking;
	
	

	public DraftSystem() {
		
		// initialize empty arrayLists for teams

		teamA = new PlayerTeam('A');
		teamB = new PlayerTeam('B');
		teamC = new PlayerTeam('C');
		teamD = new PlayerTeam('D');

		currentTeamPicking = teamA;
		
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
			
			//sort the baseballPlayer array by bA
			evalFun("bA");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error creating Draft");
			e.printStackTrace();
		}

	}

	// To Do: Check if the position of wanted player is already in team
	public void iDraft(String lastName, char firstInitial) {

		boolean playerFound = false;
		boolean playerDrafted = false;

		
			for (BaseBallPlayer player : baseBallPlayers) {
				String playerLast = player.getLastName();
				char playerFirstInitial = player.getFirstName().charAt(0);

				if (lastName.equalsIgnoreCase(playerLast)
						&& Character.toUpperCase(firstInitial) == playerFirstInitial) {
					if (player.getIsDrafted()) {
						System.out.println("Player already drafted");
					} else {
						playerDrafted = true;
						teamA.addToTeam(player);

						System.out.println(player.getLastName() + " has been drafted to team A");
					}
					playerFound = true;
					break;

				}
			}
			// if player is not found in baseBallPlayers, look through pitchers
			if (playerFound == false) {

				for (Pitcher player : pitchers) {
					String playerLast = player.getLastName();
					char playerFirstInitial = player.getFirstName().charAt(0);

					if (lastName.equalsIgnoreCase(playerLast)
							&& Character.toUpperCase(firstInitial) == playerFirstInitial) {
						if (player.getIsDrafted()) {
							System.out.println("Player already drafted");
						}else {
							teamA.addToTeam(player);
							System.out.println(player.getLastName() + " has been drafted to team A");
						}
						playerFound = true;
						break;

					}

				}
			}
			if ( teamA.getPitcherAmount() == 5) {
				System.out.println("teamA has max pitchers");
			}

			if (playerFound == false) {
				System.out.println("Could not find player");
			}
			

		 

	}

	public void oDraft(String lastName, char firstInitial, char teamName) {
		boolean playerFound = false;
		boolean playerDrafted = false;
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

		if (tempTeamVariable != currentTeamPicking) {
			System.out.println("It is team " + currentTeamPicking.getTeamName() + " turn to pick");
		} else {
			for (BaseBallPlayer player : baseBallPlayers) {
				String playerLast = player.getLastName();
				char playerFirstInitial = player.getFirstName().charAt(0);

				if (lastName.equalsIgnoreCase(playerLast)
						&& Character.toUpperCase(firstInitial) == playerFirstInitial) {
					// check if that player is already drafted
					if (player.getIsDrafted()) {
						System.out.println("Player already drafted");
					} else if (tempTeamVariable.isPositionInTeam(player.getPosition())) { // check if team already has
																							// that position
						System.out.println("Position already in team -- Not drafted");
					} else {
						playerDrafted = true;
						tempTeamVariable.addToTeam(player);
						System.out.println(
								player.getLastName() + " has been drafted to team " + tempTeamVariable.getTeamName());
					}
					playerFound = true;
					break;

				}
			}
			// if player is not found in baseBallPlayers, look through pitchers
			if (playerFound == false && tempTeamVariable.getPitcherAmount() < 5) {

				for (Pitcher player : pitchers) {
					String playerLast = player.getLastName();
					char playerFirstInitial = player.getFirstName().charAt(0);

					if (lastName.equalsIgnoreCase(playerLast)
							&& Character.toUpperCase(firstInitial) == playerFirstInitial) {
						if (player.getIsDrafted()) {
							System.out.println("Player already drafted");
						} else {
							playerDrafted = true;
							tempTeamVariable.addToTeam(player);
							System.out.println(player.getLastName() + "has been drafted to team A");
						}
						playerFound = true;
						break;

					}
				}
			} else if (tempTeamVariable.getPitcherAmount() == 5) {
				System.out.println("Team" + tempTeamVariable.getTeamName() + " has max pitchers");
			}
			if (!playerFound) {
				System.out.println("Couldnt Find Player");
			}
			if (playerDrafted) {
				switch (tempTeamVariable.getTeamName()) {
				case 'A':
					currentTeamPicking = teamB;
					break;
				case 'B':
					currentTeamPicking = teamC;
					break;
				case 'C':
					currentTeamPicking = teamD;
					break;
				case 'D':
					currentTeamPicking = teamA;
					break;
				}
			}

		}

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
		
		

		if (position.isEmpty()) {
			for (BaseBallPlayer player : baseBallPlayers) {
				if (player.getIsDrafted() == false && currentTeamPicking.isPositionInTeam(player.getPosition())) {
					System.out.println(player.toString());
				}

			}
		} else {

			for (BaseBallPlayer player : baseBallPlayers) {
				if (position.equalsIgnoreCase(player.getPosition())) {
					if (player.getIsDrafted() == false) {
						System.out.println(player.toString());
					}

				}

			}

		}
		System.out.println("This will print players eventually");
	}

	public void pOverall() {
		if (currentTeamPicking.getPitcherAmount() < 5) {
			// only printing top 50 pitchers
			ArrayList<Pitcher> tempList = pitchers;

			tempList.sort(Comparator.comparingDouble(player -> ((Pitcher) player).getIP()).reversed());

			int count = 0;
			for (Pitcher player : tempList) {
				if (count == 50) {

					break;
				}
				if (player.getIsDrafted() == false) {
					System.out.println(player.toString() + player.getIP());
				}
				count++;

			}
		} else {
			System.out.println("Team" + currentTeamPicking.getTeamName() + " has max pitchers");
		}

	}

	
	public void evalFun(String evalExpression) {
		
		
		Comparator<BaseBallPlayer> teamSorter = (p1, p2) ->{
			try {
				double result1 = p1.evaluate(evalExpression);
				double result2 = p2.evaluate(evalExpression);
				
				//System.out.println("BaseBall Players Successfully sorted");
				return Double.compare(result1, result2);
		
			}catch(Exception e) {
				System.out.println("Invalid expression -- setting to bA");
				e.printStackTrace();
				
				return Double.compare(p1.getBA(),p2.getBA());
			}			
		};
		baseBallPlayers.sort(teamSorter.reversed());
		System.out.println("This will set the evaluation funaction for overall() eventually");
	}

	public void pEvalFun() {
		System.out.println("This will set the evaluation function for pOverall() eventually");
	}
}
