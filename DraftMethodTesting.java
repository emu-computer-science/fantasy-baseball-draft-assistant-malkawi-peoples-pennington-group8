import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DraftMethodTesting {

	@Test
	void testOverallMethods() {
		DraftSystem dS = new DraftSystem();
		
		
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
		
		
	
	}
	
	@Test
	void testDraftMethods() {
		DraftSystem dS = new DraftSystem();
		
		dS.iDraft("Hamilton", 'C');
		dS.iDraft("Bannon", 'R');
		dS.iDraft("Gallo", 'J');
		
		dS.iDraft("Gordon", 'N');
		
		
		dS.iDraft("Gausman", 'K');
		dS.iDraft("Eflin", 'Z');
		dS.iDraft("Gray", 'S');
		dS.iDraft("Bibee", 'T');
		dS.iDraft("Abreu", 'B');
		
		dS.iDraft("Gausman", 'K');
		dS.iDraft("Brito", 'J');
		
		dS.iDraft("Bannon", 'R');
		
		dS.oDraft("Cowser", 'C', 'A');
		
		dS.oDraft("Bride", 'J', 'B');
		dS.oDraft("Hamilton", 'D', 'B');
		dS.oDraft("Hummel", 'C', 'B');
		
		dS.oDraft("Blanco", 'D', 'C');
		dS.oDraft("Capel", 'C', 'C');
		
		dS.oDraft("Capel", 'C', 'D');
		dS.oDraft("Dalbec", 'B', 'D');
		
		dS.stars('A');
		dS.team('A');
		dS.team('B');
		dS.team('C');
		dS.team('D');
		
	}
	
}
