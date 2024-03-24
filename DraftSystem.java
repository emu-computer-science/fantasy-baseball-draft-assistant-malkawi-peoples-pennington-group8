import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DraftSystem {
	private ArrayList<BaseBallPlayer> baseBallPlayers;
	
	private ArrayList<BaseBallPlayer> team1,team2,team3,team4;
	
	public DraftSystem() {
		//initialize empty arrayLists for teams
		team1 = new ArrayList<>();
		team2 = new ArrayList<>();
		team3 = new ArrayList<>();
		team4 = new ArrayList<>();
		
		//to do:parse the file so that it cuts up the contents into seperate string looking for a (char num num) sequence
		//To Do: Read the PlayerList.txt file into baseBallPlayers
		/*
		try {
			Scanner fileReader = new Scanner(new File("PlayerList.txt"));
			while(fileReader.hasNextLine()) {
				System.out.println(fileReader.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		
		
	}
	
	
	public void draftPlayerToTeam() {
		System.out.println("This will draft players to team eventually");
	}
	public void printTeam() {
		System.out.println("This will print teams eventually");
	}
	public void printStars() {
		System.out.println("This will eventually print teams in drafted order");
	}
	public void overall() {
		System.out.println("This will print players eventually");
	}
	public void pOverall() {
		System.out.println("This will print pitchers eventually");
	}
	public void evalFun() {
		System.out.println("This will set the evaluation funaction for overall() eventually");
	}
	public void pEvalFun() {
		System.out.println("This will set the evaluation function for pOverall() eventually");
	}
}
