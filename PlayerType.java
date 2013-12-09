/*
 * Here is class PlayerType 
 * Its responsible for keeping track of what player the players are. Doesn't do much other then let me set the player 
 * and get what a player is, nice and simple.
 */
public class PlayerType {

	public enum Player {
		USER, RANDOM, SMART
	}

	private Player type = Player.RANDOM;

	public void setPlayer(String yarn) {
		if (yarn.equals("USER")) {
			type = Player.USER;
		} else if (yarn.equals("SMART")) {
			type = Player.SMART;
		} else {
			type = Player.RANDOM;
		}
	}

	public Player getPlayer() {
		if (type == Player.USER) {
			return Player.USER;
		} else if (type == Player.SMART) {
			return Player.SMART;
		} else {
			return Player.RANDOM;
		}
	}
}
