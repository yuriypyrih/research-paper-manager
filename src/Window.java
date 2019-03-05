
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -8255319694373975038L;
	
	
	
	final static String WELCOME_PANEL = "Card with welcome message";
	final static String ADD_PANEL_1 = "Card with add form for Journal Paper";
	final static String ADD_PANEL_2 = "Card with add form for Conferense Paper";
	final static String EDIT_PANEL = "Card with edit form";
	final static String DELETE_PANEL = "Card with delete form";
	final static String SEARCH_PANEL = "Card with search form";
	
	ImageIcon search_icon = new ImageIcon("res/search_icon_20.png","Search Icon");
	ImageIcon add_icon = new ImageIcon("res/add_icon_20.png","Search Icon");
	
	JPanel mainPanel,menuPanel,contentPanel;
	JPanel card_welcome, card_add_1, card_add_2, card_edit, card_delete, card_search;
	//JButton btn_add_1, btn_add_2, btn_edit, btn_delete, btn_search;
	
	CardLayout card_layout = new CardLayout();

	JMenuBar menuBar;
	JMenu menu_add, menu_separator, menu_search;
	JMenuItem menu_add_item1, menu_add_item2;
	
	
	//Constructor of Window
	public Window(int width, int height, String title, Application application) {
		
		//SwingUtilities.invokeLater(new Runnable() {
			
			//public void run() {
				
				JFrame frame = new JFrame(title);
				frame.setSize(width,height);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);
				//frame.add(application);
				
				frame.setVisible(true);
				//application.start();
				
				
				mainPanel = new JPanel(new BorderLayout());
				menuPanel = new JPanel(new BorderLayout());
				contentPanel = new JPanel(card_layout);
				
			
				
				card_welcome = new JPanel();
				card_add_1 = new JPanel();
				card_add_2 = new JPanel();
				//card_delete = new JPanel();
				card_search = new JPanel();
				
				card_welcome.setBackground(Color.GRAY);
				card_add_1.setBackground(Color.GREEN);
				card_add_2.setBackground(Color.YELLOW);
				//card_delete.setBackground(Color.RED);
				card_search.setBackground(Color.BLUE);
				
				menuBar = new JMenuBar();
				
				menu_add = new JMenu("ADD");
				menu_add.setIcon(add_icon);
				menu_separator = new JMenu("|");
				menu_separator.setEnabled(false);
				menu_search = new JMenu("SEARCH");
				menu_search.setIcon(search_icon);
				
				menu_add_item1 = new JMenuItem("Journal paper");
				menu_add_item2 = new JMenuItem("Conferense paper");
				
				menu_add.add(menu_add_item1);
				menu_add.add(menu_add_item2);
				
				menuBar.add(menu_add);
				menuBar.add(menu_separator);
				menuBar.add(menu_search);
			
				
				//btn_add_1 = new JButton("Add");
				//btn_edit = new JButton("Edit");
				//btn_delete = new JButton("Delete");
				//btn_search = new JButton("Search");
				
				menu_add_item1.addActionListener(this);
				menu_add_item2.addActionListener(this);
				menu_search.addActionListener(this);
				//btn_delete.addActionListener(this);
				//btn_search.addActionListener(this);
				
				menuPanel.add(menuBar, BorderLayout.LINE_START);
				//menuPanel.add(btn_add);
				//menuPanel.add(btn_edit);
				//menuPanel.add(btn_delete);
				//menuPanel.add(btn_search);
				
				contentPanel.add(card_welcome, WELCOME_PANEL);
				contentPanel.add(card_add_1, ADD_PANEL_1);
				contentPanel.add(card_add_2, ADD_PANEL_2);
				contentPanel.add(card_search, SEARCH_PANEL);
				card_layout.show(contentPanel, WELCOME_PANEL); //Setting the default Panel
				
				
				
				
				
				mainPanel.add(menuPanel, BorderLayout.NORTH);
				mainPanel.add(contentPanel, BorderLayout.CENTER);
				
				frame.add(mainPanel);
			//}
		//});
		
		
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		String action = arg0.getActionCommand();
		
        if (action.equals("Journal paper")) {
            System.out.println("Add Button pressed!");
            card_layout.show(contentPanel, ADD_PANEL_1);
            
        }
        else if (action.equals("Conferense paper")) {
            System.out.println("Add Button pressed!");
            card_layout.show(contentPanel, ADD_PANEL_2);
            
        }
        else if (action.equals("Search Paper")) {
            System.out.println("Search Button pressed!");
            card_layout.show(contentPanel, SEARCH_PANEL);
            
        }
      
	}
	
	
}//end of class Window
