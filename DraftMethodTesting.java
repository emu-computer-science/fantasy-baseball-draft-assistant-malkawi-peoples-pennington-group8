import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DraftMethodTesting {

	@Test
	void testDraftMethods() {
		DraftSystem dS = new DraftSystem();
		
		dS.draftPlayerToTeam();
		dS.overall();
		dS.pOverall();
		dS.evalFun();
		dS.pEvalFun();
		dS.printStars();
		dS.printTeam();
		
	
	}
	
}
