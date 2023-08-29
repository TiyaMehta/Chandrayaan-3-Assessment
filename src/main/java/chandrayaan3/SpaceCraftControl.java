package chandrayaan3;


public class SpaceCraftControl {
	
	static int coord[] = new int[3];
	static char initial_direction;
	static char commands[]= new char[10];
	static int i;
	public static int[] enterCoordinates(int x, int y, int z) {
		coord[0] = x;
		coord[1] = y;
		coord[2] = z;
		//System.out.println(coord[0]);
		return coord;
	}
	
	public static char initialDirection(String direction) {
		initial_direction = direction.toUpperCase().charAt(0);
		//System.out.println("Initial Direction:" + initial_direction);
		return initial_direction;
	}
	
	public static char commands(String str) {
		commands[i]=str.charAt(0);
		//System.out.println(i + " " + commands[i]);
		i++;
		return commands[i-1];
	}
	
	public static void translateCommand() {
		int result=0,k=0,count=0;
		coord = enterCoordinates(0,0,0);
		initial_direction = initialDirection("North");
		commands = new char[5];
		commands[0] = commands("f");
		commands[1] = commands("r");
		commands[2] = commands("u");
		commands[3] = commands("b");
		commands[4] = commands("l");
		
		System.out.println("Initial Coordinates: [" + coord[0] +", " + coord[1] +", " + coord[2] + " ]");
		System.out.println("Initial Direction:" + initial_direction);
		
		//System.out.println(commands[5]);
		for(int j=0;j<commands.length && commands[j]!=' ';j++) {
			
			if(commands[j]=='f' || commands[j]=='b') {
				if(initial_direction=='E' || initial_direction=='W') {
					
					 result =  (commands[j]=='f')?(++coord[0]):(--coord[0]);
				}
				else if(initial_direction=='N' || initial_direction=='S') {
					 result =  (commands[j]=='f')?(++coord[1]):(--coord[1]);
				}
				else if(initial_direction=='U' || initial_direction=='D') {
					
					 result =  (commands[j]=='f')?(++coord[2]):(--coord[2]);
				}
				else {
					break;
				}
			}
			else if(commands[j]=='u' || commands[j]=='d') {
				result =  (commands[j]=='u')?(initial_direction='U'):(initial_direction='D');
			}
			else if(commands[j]=='r' || commands[j]=='l') {
				
				if (commands[j] == 'l') {
	                count--;
	                if (count <= 0) {
						 
			            if (count % 4 == 0)
			            	initial_direction  = 'N';
			            else if (count % 4 == -1)
			            	initial_direction = 'W';
			            else if (count % 4 == -2)
			            	initial_direction = 'S';
			            else if (count % 4 == -3)
			            	initial_direction = 'E';
			        }
	                //System.out.println(count);
				}
	            else {
	                if (commands[j]  == 'r')
	                    count++;
	                if (count >= 0) {
						 
			            if (count % 4 == 0)
			            	initial_direction = 'N';
			            else if (count % 4 == 1)
			            	initial_direction = 'E';
			            else if (count % 4 == 2)
			            	initial_direction = 'S';
			            else if (count % 4 == 3)
			            	initial_direction = 'W';
			        }
	                
	            }
			}
			System.out.println(commands[j] + ": [" + coord[0] +", " + coord[1] +", " + coord[2] + " ] - " + initial_direction);
		}
		System.out.println("Final Coordinates: [" + coord[0] +", " + coord[1] +", " + coord[2] + " ]");
		System.out.println("Final Direction:" + initial_direction);
		
	}
}
