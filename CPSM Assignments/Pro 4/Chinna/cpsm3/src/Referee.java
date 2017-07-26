
public class Referee implements Runnable
{
	private final Game sharedObject;
	
	public Referee(Game sharedObject)
	{
		this.sharedObject = sharedObject;
		
	}
	public void run()
	{
		
				try {
					sharedObject.monitor();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
						
		
	}
}
