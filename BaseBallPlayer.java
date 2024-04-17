import java.io.Serializable;

import org.apache.commons.jexl3.*;

public class BaseBallPlayer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2569908526390664687L;
	private String firstName;
	private String lastName;
	private boolean isDrafted;
	private String playerPosition;
	//maybe a hashset instead or something ??
	private String teamName;
	private double bA, hR, r, h, sO;
	
	private double evalResult;
	
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
		
		//Runs
		r = Double.parseDouble(info[7]);
		//hits
		h = Double.parseDouble(info[8]);
		//home Runs
		hR = Double.parseDouble(info[11]);
		//batting average
		bA = Double.parseDouble(info[17]);
		evalResult = bA;
		//strike-outs
		sO = Double.parseDouble(info[16]);
		
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
		return (firstName + "        " + lastName + "        " + teamName + "        " + playerPosition + "        " + evalResult);
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

	public Double evaluate(String expression) throws Exception{
		try {
			JexlEngine jexl = new JexlBuilder().create();

			JexlContext context = new MapContext();
			context.set("bA", bA);
			context.set("hR", hR);
			context.set("r", r);
			context.set("h", h);
			context.set("sO", sO);

			JexlExpression jexlExpression = jexl.createExpression(expression);
			Object result = jexlExpression.evaluate(context);

			evalResult = (Double) result;
			return (Double) result;
		}catch(Exception e) {
			throw e;
		}
		
		/*
		String[] elements = expression.split(" ");
		Double value1;
		Double value2;
		
		//1 or 3 elements valid
		if(elements.length == 1 || elements.length == 3) {
			if(elements.length == 3) {
				switch(elements[0].toLowerCase()) {
				case "ba":
					break;
				case "hr":
					break;
				case "r":
					break;
				case "h":
					break;
				case "so":
					break;
				default:
					value1 = Double.parseDouble(expression[0]);
				
				}
			}
		}
		*/
		
	}
	
	public void setIsDrafted() {
		isDrafted = true;
	}
	public Double getBA() {
		return bA;
	}
	public Double getH() {
		return h;
	}
	public Double getR() {
		return r;
	}
	public Double getHR() {
		return hR;
	}
	public Double getSO() {
		return sO;
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
