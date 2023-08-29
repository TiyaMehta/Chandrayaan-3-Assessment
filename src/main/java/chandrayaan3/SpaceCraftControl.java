package chandrayaan3;


public class SpaceCraftControl {
	
	int coord[];
	char initial_direction;
	char commands[];
	static int i;
	public int[] enterCoordinates(int x, int y, int z) {
		coord = new int[3];
		coord[0] = x;
		coord[1] = y;
		coord[2] = z;
		return coord;
	}
	
	public char initialDirection(String direction) {
		initial_direction = direction.toUpperCase().charAt(0);
		//System.out.println("Initial Direction:" + initial_direction);
		return initial_direction;
	}
	
	public char commands(String str) {
		commands = new char[10];
		commands[i]=str.charAt(0);
		//System.out.println(i + " " + commands[i]);
		i++;
		return commands[i-1];
	}
}
