/*
 * Welcome to the Arena
 * Here we set up games of Matchsticks, from one game to about 2,147,483,647 games just in case you wanted to play 
 * until the heat death of the universe.
 */
import java.util.Scanner;

public class Arena {
	
	public static boolean yesNo (String answer) {
		answer = answer.toLowerCase();
		
		if (answer.equals("yes") || answer.equals("y")) {
			return true;
		} 
		
		return false;		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean sentinel = true;

		do {
			System.out.println("Welcome to the Arena, We have a lovey game of Match Sticks awaiting your (Or Thousands!!!)");

			System.out.println("How many games whould you like to play?");
			int numberOfGames = scan.nextInt();

			System.out.println("Who is playing today? User, Smart, Random");
			System.out.println("Player One is?");
			String playerOne = scan.next();

			System.out.println("Player Two is?");
			String playerTwo = scan.next();

			Game game = new Game();

			game.play(playerOne, playerTwo, numberOfGames);
			
			System.out.println("Again? <Yes, No>");
			String answer = scan.next();
			sentinel = yesNo(answer);
			
		} while (sentinel == true);
	}
}
