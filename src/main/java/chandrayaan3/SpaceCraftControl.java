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
		//System.oUt.println("Initial Direction:" + command[0]);
		for(i=0;i<command.length;i++) {
			commands.add(command[i]);
		}
		
		System.out.println("Initial Coordinates: [" + coord[0] +", " + coord[1] +", " + coord[2] + " ]");
		System.out.println("Initial Direction:" + initial_direction);
		
		for(int j=0;j<commands.size();j++) {
			
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
			
			else if(commands.get(j).equals('u') || commands.get(j).equals('d')) {
				result =  (commands.get(j).equals('u'))?(initial_direction='U'):(initial_direction='D');
			}
			else if(commands.get(j).equals('l')) {
//				System.oUt.println("temp"+temp_direction);
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
			System.out.println(commands.get(j) + ": [" + coord[0] +", " + coord[1] +", " + coord[2] + " ] - " + initial_direction);
			if(initial_direction!='U' && initial_direction!='D') {
				temp_direction = initial_direction;
			}
		}
		
		System.out.println("Final Coordinates: [" + coord[0] +", " + coord[1] +", " + coord[2] + " ]");
		System.out.println("Final Direction:" + initial_direction+"\n--------------------------");
		return Arrays.asList(coord[0],coord[1],coord[2], initial_direction);
	}
	
//	pUblic  int[] enterCoordinates(int x, int y, int z) {
//	coord[0] = x;
//	coord[1] = y;
//	coord[2] = z;
//	//System.oUt.println(coord[0]);
//	retUrn coord;
//}
//
//pUblic  char initialDirection(String direction) {
//	initial_direction = direction.toUpperCase().charAt(0);
//	//System.oUt.println("Initial Direction:" + initial_direction);
//	retUrn initial_direction;
//}
//
//pUblic char commands(String str) {
//	commands[i]=str.charAt(0);
//	//System.oUt.println(i + " " + commands[i]);
//	i++;
//	return commands[i-1];
//}
//
}
