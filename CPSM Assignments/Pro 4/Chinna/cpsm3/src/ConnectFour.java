import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectFour {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Game sharedObject = new TheGame();
		executorService.execute(new Referee(sharedObject));
		executorService.execute(new Player('B',sharedObject));
		executorService.execute(new Player('R',sharedObject));
		executorService.shutdown();
		
	}

}
