

public class Application {
	
	private static final long serialVersionUID = -1442798787354930462L;
	
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9; 
	
	Application(){
		
		 new Window(WIDTH, HEIGHT,"Paper Manager",this);
		 System.out.println("Application Started");
	}

	public static void main(String[] args) {
		
		new Application();

	}

}
