import org.apache.commons.jexl3.*;
public class Pitcher {
	private String firstName;
	private String lastName;
	private boolean isDrafted;
	private String playerPosition = "P";
	//maybe a hashset instead or something ??
	private String teamName;
	
	
	private double sO,iP, h,r, hR;
	
	private double evalResult;
	
	public Pitcher(String playerInfo) {
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
		
		//strike-outs
		sO = Double.parseDouble(info[21]);
		evalResult = sO;
		//innings pitched
		iP = Double.parseDouble(info[14]);
		//hits allowed
		h = Double.parseDouble(info[15]);
		//runs allowed
		r = Double.parseDouble(info[16]);
		//home runs allowed
		hR = Double.parseDouble(info[18]);
		
		teamName = info[3];	
		
		
		
		//System.out.println(firstName + "  " + lastName + "  " + teamName + "  " + playerPosition + "   "+ bA);
		//System.out.println();
			
		
	}

	
	public String toString() {
		return (firstName + "        " + lastName + "        " + teamName + "        " + playerPosition + "        " + evalResult);
	}
	
	
	public void setIsDrafted() {
		isDrafted = true;
	}
	
	public String getPosition() {
		return playerPosition;
	}


	public String getFirstName() {
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


	public double getSO() {
		// TODO Auto-generated method stub
		return sO;
	}
	public double getIP() {
		// TODO Auto-generated method stub
		return iP;
	}
	public double getH() {
		// TODO Auto-generated method stub
		return h;
	}
	public double getR() {
		// TODO Auto-generated method stub
		return r;
	}
	public double getHR() {
		// TODO Auto-generated method stub
		return hR;
	}


	public double evaluate(String expression) {
		try {
			JexlEngine jexl = new JexlBuilder().create();

			JexlContext context = new MapContext();
			context.set("sO", sO);
			context.set("iP", iP);
			context.set("h", h);
			context.set("r", r);
			context.set("hR", hR);

			JexlExpression jexlExpression = jexl.createExpression(expression);
			Object result = jexlExpression.evaluate(context);

			evalResult = (Double) result;
			return (Double) result;
		}catch(Exception e) {
			throw e;
		}
	}
}
