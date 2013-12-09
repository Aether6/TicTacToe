/*
 * The player Class
 * It contains the logic of each players type and return how many sticks are to be taken
 */
import java.util.Random;
import java.util.Scanner;

public class Player {

	public int user(int totalSticks) {

		Scanner scan = new Scanner(System.in);
		System.out.println("There are " + totalSticks
				+ " left. How many do you want to take?");
		int take = scan.nextInt();

		while (take > 3 || take < 0) {
			System.out
					.println("Out of range please enter a number between One and Three.");
			take = scan.nextInt();
		}
		
		return take;
	}

	public int random(int totalSticks) {
		Random rand = new Random();
		int take = rand.nextInt(3) + 1;
		return take;
	}
	
	public int smart(int totalSticks) {
		int orginal = totalSticks;
		
		if (totalSticks > 6) {
			totalSticks = totalSticks -3;
		} else if (totalSticks == 6) {
			totalSticks--;
		} else if (totalSticks == 5) {
			totalSticks--;
		} else if (totalSticks == 4) {
			totalSticks = totalSticks - 3;
		} else if (totalSticks == 3) {
			totalSticks = totalSticks - 2;
		} else if (totalSticks == 2) {
			totalSticks--;
		} else {
			totalSticks--;
		}
		
		return orginal - totalSticks;
	}
}
