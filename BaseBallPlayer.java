
public class BaseBallPlayer {
	private String firstName;
	private String lastName;
	private boolean isDrafted;
	private String playerPosition;
	//maybe a hashset instead or something ??
	private String teamName;
	
	private double rK,age,g,pA,aB,r,h,b2,b3,hR,rBI,sB,cS,bB,sO,bA,oBP,sLG,oPS,oPSPlus,tB,gDP,hBP,sH,sF,iBB, position;
	
	public BaseBallPlayer(String playerInfo) {
		String[] info = playerInfo.split(",");
		
		//fill blank stats with 0's
		for(int i = 9; i < info.length; i++) {
			if(info[i].isEmpty() || info[i].isBlank()) {
				info[i] = "0";
			}
			//System.out.print(info[i] + " ");
			
		}
		//System.out.println();
		
		String[] nameSplit = info[1].split("(?=(?<!^)[A-Z])");
		if(nameSplit.length == 3) {
			firstName = nameSplit[0] + nameSplit[1];
		}else {
			firstName = nameSplit[0];
		}
		
		
		lastName = nameSplit[nameSplit.length-1];
		
		//check if end of last name has a non letter, if so, remove it.
		if(lastName.contains("#") || lastName.contains("*")) {
			lastName = lastName.substring(0, lastName.length() - 1);
		}
		
		bA = Double.parseDouble(info[17]);
		
		teamName = info[3];	
		
		//find first position of an int and change it into correct playerPosition
		playerPosition = info[28];
		for(int i = 0; i < playerPosition.length(); i++) {
			if(Character.isDigit(playerPosition.charAt(i))) {
				findPosition(playerPosition.charAt(i));
				break;
			}
		}
		
		//System.out.println(firstName + "  " + lastName + "  " + teamName + "  " + playerPosition + "   "+ bA);
		//System.out.println();
			
		
	}

	
	public String toString() {
		return (firstName + "        " + lastName + "        " + teamName + "        " + playerPosition + "        ");
	}
	private void findPosition(char posNum) {
		// TODO Auto-generated method stub
		switch(posNum) {
		case '1' :
			playerPosition = "P";
			break;
		case '2' :
			playerPosition = "C";
			break;
		case '3' :
			playerPosition = "1B";
			break;
		case '4' :
			playerPosition = "2B";
			break;
		case '5' :
			playerPosition = "3B";
			break;
		case '6' :
			playerPosition = "SS";
			break;
		case '7' :
			playerPosition = "LF";
			break;
		case '8' :
			playerPosition = "CF";
			break;
		case '9' :
			playerPosition = "RF";
			break;
		}
	}

	
	public void setIsDrafted() {
		isDrafted = true;
	}
	public Double getBA() {
		return bA;
	}
	public String getPosition() {
		return playerPosition;
	}


	public String tempPlayer() {
		// TODO Auto-generated method stub
		return firstName;
	}


	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}


	public boolean getIsDrafted() {
		// TODO Auto-generated method stub
		return isDrafted;
	}


	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
}
