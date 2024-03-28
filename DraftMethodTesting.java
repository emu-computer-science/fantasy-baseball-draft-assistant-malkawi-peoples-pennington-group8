import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DraftMethodTesting {

	@Test
	void testDraftMethods() {
		DraftSystem dS = new DraftSystem();
		
		dS.oDraft();
		dS.overall("P");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("C");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("1B");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("2B");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("3B");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("SS");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("LF");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("CF");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		dS.overall("RF");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println();
		
		
		
		dS.pOverall();
		dS.evalFun();
		dS.pEvalFun();
		dS.printStars();
		dS.printTeam();
		
	
	}
	
}
