import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerTeam {
	private char teamName;
	// private ArrayList<BaseBallPlayer> players;
	private ArrayList<Pitcher> pitchers;
	private ArrayList<Object> playerPickOrder;
	
	private HashMap<String, BaseBallPlayer> players;

	private int amountOfPitchers;

	private HashMap<String, Boolean> isPosInTeam;

	public PlayerTeam(char teamName) {
		this.teamName = teamName;
		
		playerPickOrder = new ArrayList<>();
		
		pitchers = new ArrayList<>();
		players = new HashMap<>();

		isPosInTeam = new HashMap<>(Map.of("C", false, "1B", false, "2B", false, "3B", false, "SS", false, "LF", false,"RF", false, "CF", false));
		amountOfPitchers = 0;
	}

	public void addToTeam(BaseBallPlayer b) {
		if (!isPositionInTeam(b.getPosition())) {
			players.put(b.getPosition(), b);
			playerPickOrder.add(b);
			b.setIsDrafted();
			isPosInTeam.put(b.getPosition(), true);
						
		}
	}

	public void addToTeam(Pitcher p) {
		if (amountOfPitchers == 5) {
			System.out.println("Player " + teamName + " has five pitchers already, pitcher not added");
		} else {
			pitchers.add(p);
			playerPickOrder.add(p);
			p.setIsDrafted();
			
			amountOfPitchers++;
		}
	}

	public boolean isPositionInTeam(String pos) {
		if(pos.contains("D")) {
			return true;
		}else if(pos == "P") {
			if(amountOfPitchers == 5) {
				return true;
			}else {
				return false;
			}
				
		}
		//System.out.println(pos);
		return isPosInTeam.get(pos);
	}

	public void printTeam() {
		System.out.println("----------------------------------");
		System.out.println("Team " + teamName);
		System.out.println();
		// print players in order
		BaseBallPlayer tempPlayer = players.get("C");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		 tempPlayer = players.get("1B");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		 tempPlayer = players.get("2B");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		 tempPlayer = players.get("3B");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		 tempPlayer = players.get("SS");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		 tempPlayer = players.get("LF");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		 tempPlayer = players.get("CF");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		 tempPlayer = players.get("RF");
		if (tempPlayer != null) {
			System.out.println(tempPlayer.getPosition() + "   " + tempPlayer.getFirstName() + " " + tempPlayer.getLastName());
		}
		
		//print pitchers
		for (Pitcher pitcher : pitchers) {
			System.out.println(pitcher.getPosition() + "   " + pitcher.getFirstName() + " " + pitcher.getLastName());
		}
		// TODO Auto-generated method stub

		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
	}

	public void printStars() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------");
		System.out.println("Team " + teamName + " STARS");
		System.out.println();
		for(Object player : playerPickOrder) {
			if(player instanceof BaseBallPlayer) {
				System.out.println(((BaseBallPlayer) player).getPosition() + "   " + ((BaseBallPlayer) player).getFirstName() + " " + ((BaseBallPlayer) player).getLastName());
			}else {
				System.out.println(((Pitcher) player).getPosition() + "   " + ((Pitcher) player).getFirstName() + " " + ((Pitcher) player).getLastName());
			}
			//System.out.println(((BaseBallPlayer) player).getPosition() + "   " + ((BaseBallPlayer) player).getFirstName() + " " + ((BaseBallPlayer) player).getLastName());
		}
		System.out.println();
		System.out.println();
		System.out.println("------------------------------");
	

	}
	
	public char getTeamName() {
		return teamName;
	}
	public int getPitcherAmount() {
		return amountOfPitchers;
	}
}
