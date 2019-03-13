import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Application {
	
	private static final long serialVersionUID = -1442798787354930462L;
	private PaperManager manager;
	
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9; 
	
	Application(){
		
		PaperManager manager = new PaperManager();
		
		new Window(WIDTH, HEIGHT,"Paper Manager",manager);
		 
		 System.out.println("Application Started");
	}

	public static void main(String[] args) {
		
		new Application();

	}

	
}
