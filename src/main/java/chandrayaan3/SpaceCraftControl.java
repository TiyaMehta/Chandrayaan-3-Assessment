/*
 * ==>KEY:
  D-down direction and d - downward direction command
  U-Up direction and u - Upward direction command
*/
package chandrayaan3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SpaceCraftControl {
	
	 int coord[] = new int[3];
	 char initial_direction;
	 static char temp_direction;
	 Vector commands = new Vector();
	 int i;

	public List<Serializable> translateCommand(int[] coord, char initial_direction, char[] command) {
		int result=0;
		this.coord = coord;
		this.initial_direction = initial_direction;
		
		//add all commands to the vector array
		for(i=0;i<command.length;i++) {
			commands.add(command[i]);
		}
		
		//print initial coordinates
		System.out.println("Initial Coordinates: [" + coord[0] +", " + coord[1] +", " + coord[2] + " ]");
		System.out.println("Initial Direction:" + initial_direction);
		
		//iterate through all the input commands
		for(int j=0;j<commands.size();j++) {
			
			//command is to move forward or backward
			if(commands.get(j).equals('f') || commands.get(j).equals('b')) {
				if(initial_direction=='E' || initial_direction=='W') {
					 result =  (commands.get(j).equals('f'))?(++coord[0]):(--coord[0]);
				}
				else if(initial_direction=='N' || initial_direction=='S') {
					 result =  (commands.get(j).equals('f'))?(++coord[1]):(--coord[1]);
				}
				else if(initial_direction=='U' || initial_direction=='D') {
					
					 result =  (commands.get(j).equals('f'))?(++coord[2]):(--coord[2]);
				}
				else {
					break;
				}
			}
			//command is to turn upward or downward
			else if(commands.get(j).equals('u') || commands.get(j).equals('d')) {
				result =  (commands.get(j).equals('u'))?(initial_direction='U'):(initial_direction='D');
			}
			//command is for left turn
			else if(commands.get(j).equals('l')) {

				if(initial_direction=='N') {
					initial_direction = 'W';
				}
				else if(initial_direction=='W') {
					initial_direction = 'S';
				}
				else if(initial_direction=='S') {
					initial_direction='E';
				}
				else if(initial_direction=='E') {
					initial_direction='N';
				}
				if(initial_direction=='U') {
					if(temp_direction=='N') {
						initial_direction = 'W';
					}
					else if(temp_direction=='W') {
						initial_direction = 'S';
					}
					else if(temp_direction=='S') {
						initial_direction='E';
					}
					else if(temp_direction=='E') {
						initial_direction='N';
					}
				}
				if(initial_direction=='D') {
					if(temp_direction=='N') {
						initial_direction = 'E';
					}
					else if(temp_direction=='E') {
						initial_direction = 'S';
					}
					else if(temp_direction=='S') {
						initial_direction='W';
					}
					else if(temp_direction=='W') {
						initial_direction='N';
					}
				}
			}
			//command is for right turn
			else if (commands.get(j).equals('r')) {
				if(initial_direction=='N') {
					initial_direction = 'E';
				}
				else if(initial_direction=='E') {
					initial_direction = 'S';
				}
				else if(initial_direction=='S') {
					initial_direction='W';
				}
				else if(initial_direction=='W') {
					initial_direction='N';
				}
				if(initial_direction=='U') {
					if(temp_direction=='N') {
						initial_direction = 'E';
					}
					else if(temp_direction=='E') {
						initial_direction = 'S';
					}
					else if(temp_direction=='S') {
						initial_direction='W';
					}
					else if(temp_direction=='W') {
						initial_direction='N';
					}
				}
				if(initial_direction=='D') {
					if(temp_direction=='N') {
						initial_direction = 'W';
					}
					else if(temp_direction=='W') {
						initial_direction = 'S';
					}
					else if(temp_direction=='S') {
						initial_direction='E';
					}
					else if(temp_direction=='E') {
						initial_direction='N';
					}
				}
			 }	
			//print intermediate steps
			System.out.println(commands.get(j) + ": [" + coord[0] +", " + coord[1] +", " + coord[2] + " ] - " + initial_direction);
			//store previous direction if next direction is U/D
			if(initial_direction!='U' && initial_direction!='D') {
				temp_direction = initial_direction;
			}
			
		}
		
		//check for coordinates within galatic boundries(257 to -257)
		if(coord[0]< -256 || coord[0]>256 || coord[1]< -256 || coord[1] > 256 || coord[2]< -256 || coord[2] > 256) {
			System.out.println("out of galactic boundries");
			return Arrays.asList("out of bound");
		}
		
		//print final coordinates
		System.out.println("Final Coordinates: [" + coord[0] +", " + coord[1] +", " + coord[2] + " ]");
		System.out.println("Final Direction:" + initial_direction+"\n--------------------------");
		//return final coordinates to test case
		return Arrays.asList(coord[0],coord[1],coord[2], initial_direction);
	}
	
	//scientist input for initial coordinates
	public  int[] enterCoordinates(int x, int y, int z) {
	coord[0] = x;
	coord[1] = y;
	coord[2] = z;
	//System.out.println(coord[0]);
	return coord;
	}

	//scientist input for initial direction
	public  char initialDirection(String direction) {
	initial_direction = direction.toUpperCase().charAt(0);
	return initial_direction;
	}

	//scientist input for commands
	public Object commands(String str) {
	commands.add(str.charAt(0));
	//System.out.println(i + " " + commands.get(i));
	i++;
	return commands.get(i-1);
	}
}
