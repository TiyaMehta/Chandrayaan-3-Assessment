/*
 * ==>KEY:
  D-down direction and d - downward direction command
  U-Up direction and u - Upward direction command
*/
package chandrayaan3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Chandrayaan-3 Commands")
class SpaceCraftControlTest {
	
	SpaceCraftControl scc;
	
	@BeforeEach
	void init() {
		scc = new SpaceCraftControl();
	}
	
	@Nested
	@DisplayName("Translate Earth Commands")
	class translateCommands{
		
		@Test
		@DisplayName("to move spacecraft forward")
		void testForward() {
			int initial_coords[] = {0,0,0};
			char initial_direction = 'N';
			char[] command = {'f'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertAll(
					() -> assertArrayEquals(new int[] {0,1,0},initial_coords,()->"should increment coordinate"),
					() -> assertEquals('N', obj.get(3),()->"should be correct direction")
					);
		}
		
		@Test
		@DisplayName("to move spacecraft backward")
		void testBackward() {
			int initial_coords[] = {0,0,0};
			char initial_direction = 'N';
			char[] command = {'b'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {0,-1,0},initial_coords, ()->"should decrement coordinate");
			assertEquals('N', obj.get(3),()->"should be correct direction");
		}
		
		@Test
		@DisplayName("to turn spacecraft right")
		void testRight() {
			int initial_coords[] = {0,0,0};
			char initial_direction = 'N';
			char[] command = {'r'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {0,0,0},initial_coords, ()-> "coordinates should remain unchanged");
			assertEquals('E', obj.get(3), ()-> "should have valid direction after turning 90 deg");
		}
		
		@Test
		@DisplayName("to turn spacecraft left")
		void testLeft() {
			int initial_coords[] = {0,0,0};
			char initial_direction = 'N';
			char[] command = {'l'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {0,0,0},initial_coords, ()-> "coordinates should remain unchanged");
			assertEquals('W', obj.get(3), ()-> "should have valid direction after turning 90 deg");
		}
		
		@Test
		@DisplayName("to turn spacecraft upward")
		void testUpward() {
			int initial_coords[] = {0,0,0};
			char initial_direction = 'N';
			char[] command = {'u'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {0,0,0},initial_coords, ()-> "coordinates should remain unchanged");
			assertEquals('U', obj.get(3), ()-> "should have valid direction after turning upward");
		}
		
		@Test
		@DisplayName("to turn spacecraft downward")
		void testDownward() {
			int initial_coords[] = {0,0,0};
			char initial_direction = 'N';
			char[] command = {'d'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {0,0,0},initial_coords, ()-> "coordinates should remain unchanged");
			assertEquals('D', obj.get(3), ()-> "should have valid direction after turning downward");
		}
		
		@Test
		@DisplayName("to turn spacecraft in different direction")
		void testDifferentDirection() {
			int initial_coords[] = {0,5,0};
			char initial_direction = 'E';
			char[] command = {'r'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {0,5,0},initial_coords,()->"coordinates should be unchanged");
			assertEquals('S', obj.get(3),()->"should have valid direction");
		}
		
		@Test
		@DisplayName("to move spacecraft using multiple commands")
		void testMultipleCommands() {
			int initial_coords[] = {0,0,0};
			char initial_direction = 'N';
			char[] command = {'f','r','u','b','l'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {0,1,-1},initial_coords,()->"should have valid final coordinates");
			assertEquals('N', obj.get(3),()->"should have valid final direction");
		}
		
		@Test
		@DisplayName("to move spacecraft with initial negative coordinates")
		void testNegativeCoordinates() {
			int initial_coords[] = {-5,2,0};
			char initial_direction = 'W';
			char[] command = {'b'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			initial_coords[0] = (int) obj.get(0);
			initial_coords[1] = (int) obj.get(1);
			initial_coords[2] = (int) obj.get(2);
			assertArrayEquals(new int[] {-6,2,0},initial_coords,()->"should have valid coordinates");
			assertEquals('W', obj.get(3),"should have unchanged direction");
		}
		
		@Test
		@DisplayName("to check for out of bounds galactic coordinates")
		void testOutofBounds() {
			int initial_coords[] = {-5,256,0};
			char initial_direction = 'N';
			char[] command = {'f'};
			
			List<Serializable> obj = scc.translateCommand(initial_coords,initial_direction,command);
			assertEquals("out of bound",obj.get(0));
			
		}
	}
	
	//test cases for input values taken from scientist(coordinates, direction, commands)
	@Nested
	@DisplayName("Scientist Input")
	class UserInput{
		
		@Test
		@DisplayName("Galactic Coordinates")
		void testEnterCoordinates(){
			assertAll(
					() -> assertArrayEquals(new int[] {0,0,0},scc.enterCoordinates(0, 0, 0),()->"should accept start coordinates as zero"),
					() -> assertArrayEquals(new int[] {9, 8, 78},scc.enterCoordinates(9, 8, 78),()->"should accept positive start coordinates"),
					() -> assertArrayEquals(new int[] {-4, 8, 10},scc.enterCoordinates(-4, 8, 10),()->"should accept negative start coordinates")
					);
		}
		
		@Test
		@DisplayName("Initial Direction")
		void testIntialDirection() {
			assertAll(
					() -> assertEquals('N',scc.initialDirection("North") | scc.initialDirection("north"),()->"should be valid direction(N/S/W/E/U/D)"),
					() -> assertEquals('S',scc.initialDirection("South") | scc.initialDirection("south"),()->"should be valid direction(N/S/W/E/U/D)"),
					() -> assertEquals('E',scc.initialDirection("East") | scc.initialDirection("east"), ()->"should be valid direction(N/S/W/E/U/D)"),
					() -> assertEquals('W', scc.initialDirection("West") | scc.initialDirection("west"), ()->"should be valid direction(N/S/W/E/U/D)"),
					() -> assertEquals('U',scc.initialDirection("Up") | scc.initialDirection("up"), ()->"should be valid direction(N/S/W/E/U/D)"),
					() -> assertEquals('D',scc.initialDirection("Down") | scc.initialDirection("down"), ()->"should be valid direction(N/S/W/E/U/D)")
					);
		}
		
		@Test
		@DisplayName("Commands")
		void testCommands() {
			assertEquals('f',scc.commands("forward"),()->"should be valid");
			assertEquals('b',scc.commands("backward"),()->"should be valid");
			assertEquals('u',scc.commands("up"),()->"should be valid");
			assertEquals('d',scc.commands("down"),()->"should be valid");
			assertEquals('l',scc.commands("left"),()->"should be valid");
			assertEquals('r',scc.commands("right"),()->"should be valid");
		}
   }	
}
