
public class Player implements Runnable {
	
	private char player; 
	private final Game sharedObject;
	
	public Player(char player,Game sharedObject)
	{
		this.player =player;
		this.sharedObject = sharedObject;
	}
	public void run()
	{
		
		try {
			sharedObject.playGame(player);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
			
	}
	
}
