/*
 * 
 * @author Chase Nielson
 * Plays a game of MatchSticks, It only supports two players right now.
 *
 */
public class Game {
	
	public String numToPrint(int number) {
		String words;
		switch (number) {
			case 1:
				words = "One";
			case 2:
				words = "Two";
			case 3:
				words = "Three";
			case 4:
				words = "Four";
			case 5:
				words = "Five";
			case 6:
				words = "Six";
			case 7:
				words = "Seven";
			case 8:
				words = "Eight";
			case 9:
				words = "Nine";
			default:
				words = "???";
		}

		return words;
	}

	public void play(String playerOne, String playerTwo, int numberOfGames) {

		int playerOneWins = 0;
		int playerTwoWins = 0;

		Player matchStickPlayer = new Player();

		PlayerType player1 = new PlayerType();
		PlayerType player2 = new PlayerType();

		playerOne = playerOne.toUpperCase();
		playerTwo = playerTwo.toUpperCase();

		player1.setPlayer(playerOne);
		player2.setPlayer(playerTwo);

		System.out.println("Here We GOOOOO!");

		do {
			int totalSticks = 15;

			do {
				int orginal = totalSticks;
				if (player1.getPlayer() == PlayerType.Player.USER) {
					System.out.println("");
					for (int i = totalSticks; i > 0; i--) {
						System.out.print("|");
					}
					System.out.println("");
					
					System.out.println("Player one, how many matchsticks would you like to take?");
					totalSticks = totalSticks - matchStickPlayer.user(totalSticks);
					if (totalSticks <= 0) {
						playerTwoWins++;
					}

				} else if (player1.getPlayer() == PlayerType.Player.SMART) {
					totalSticks = totalSticks - matchStickPlayer.smart(totalSticks);
					if (totalSticks <= 0) {
						playerTwoWins++;
					}

				} else {
					totalSticks = totalSticks - matchStickPlayer.random(totalSticks);
					if (totalSticks <= 0) {
						playerTwoWins++;
					}
				}
				
				if (player2.getPlayer() == PlayerType.Player.USER) {
					System.out.print("Player One took " + (numToPrint(orginal - totalSticks)));
					if ((orginal - totalSticks) == 1) {
						System.out.print("Stick");
					} else {
						System.out.print("Sticks");
					}
				}
				
				if (totalSticks > 0) {
					orginal = totalSticks;
					
					if (player2.getPlayer() == PlayerType.Player.USER) {
						totalSticks = totalSticks - matchStickPlayer.user(totalSticks);
						
						System.out.println("");
						for (int i = totalSticks; i > 0; i--) {
							System.out.print("|");
						}
						System.out.println("");
						
						if (totalSticks <= 0) {
							playerOneWins++;
						}

					} else if (player2.getPlayer() == PlayerType.Player.SMART) {
						totalSticks = totalSticks - matchStickPlayer.smart(totalSticks);
						if (totalSticks <= 0) {
							playerOneWins++;
						}

					} else {
						totalSticks = totalSticks - matchStickPlayer.random(totalSticks);
						if (totalSticks <= 0) {
							playerOneWins++;
							
						}
					}
					
					if (player1.getPlayer() == PlayerType.Player.USER) {
						System.out.print("Player Two took " + (numToPrint(orginal - totalSticks)));
						if ((orginal - totalSticks) == 1) {
							System.out.print("Stick");
						} else {
							System.out.print("Sticks");
						}
					}
				}

 			} while (totalSticks > 0);
			numberOfGames--;
		} while (numberOfGames > 0);
		
		System.out.println("Player One Won: " + playerOneWins + " Games");
		System.out.println("Player two Won: " + playerTwoWins + " Games");
		
	}
}
