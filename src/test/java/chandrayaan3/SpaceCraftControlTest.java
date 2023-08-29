package chandrayaan3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Chandrayaan-3")
class SpaceCraftControlTest {
	
	SpaceCraftControl scc;
	
	@BeforeEach
	void init() {
		scc = new SpaceCraftControl();
	}
	
	@Nested
	@DisplayName("Scientist Input")
	class UserInput{
		
		@Test
		@DisplayName("Galactic Coordinates")
		void testEnterCoordinates(){
			assertAll(
					() -> assertArrayEquals(new int[] {0,0,0},scc.enterCoordinates(0, 0, 0),()->"should accept start coordinates as zero")
//					,() -> assertArrayEquals(new int[] {9, 8, 78},scc.enterCoordinates(9, 8, 78),()->"should accept positive start coordinates"),
//					() -> assertArrayEquals(new int[] {-4, 8, 10},scc.enterCoordinates(-4, 8, 10),()->"should accept negative start coordinates")
					);
		}
		
		@Test
		@DisplayName("Initial Direction")
		void testIntialDirection() {
			assertAll(
					() -> assertEquals('N',scc.initialDirection("North") | scc.initialDirection("north"),()->"should be valid direction(N/S/W/E/U/D)")
//					,
//					() -> assertEquals('S',scc.initialDirection("South") | scc.initialDirection("south"),()->"should be valid direction(N/S/W/E/U/D)"),
//					() -> assertEquals('E',scc.initialDirection("East") | scc.initialDirection("east"), ()->"should be valid direction(N/S/W/E/U/D)"),
//					() -> assertEquals('W', scc.initialDirection("West") | scc.initialDirection("west"), ()->"should be valid direction(N/S/W/E/U/D)"),
//					() -> assertEquals('U',scc.initialDirection("Up") | scc.initialDirection("up"), ()->"should be valid direction(N/S/W/E/U/D)"),
//					() -> assertEquals('D',scc.initialDirection("Down") | scc.initialDirection("down"), ()->"should be valid direction(N/S/W/E/U/D)")
					);
		}
		
		@Test
		@DisplayName("Commands")
		void testCommands() {
//			assertEquals('f',scc.commands("forward"),()->"should be valid");
//			assertEquals('b',scc.commands("backward"),()->"should be valid");
//			assertEquals('u',scc.commands("up"),()->"should be valid");
//			assertEquals('d',scc.commands("down"),()->"should be valid");
//			assertEquals('l',scc.commands("left"),()->"should be valid");
//			assertEquals('r',scc.commands("right"),()->"should be valid");
		}
	}
	
	@Test
	@DisplayName("Translate Commands")
	void testTranlateCommands() {
		scc.translateCommand();
	}
	
}
