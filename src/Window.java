
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;



public class Window extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -8255319694373975038L;
	private PaperManager manager;
	
	
	final static String WELCOME_PANEL = "Card with welcome message";
	final static String ADD_PANEL_1 = "Card with add form for Journal Paper";
	final static String ADD_PANEL_2 = "Card with add form for Conferense Paper";
	final static String EDIT_PANEL = "Card with edit form";
	final static String DELETE_PANEL = "Card with delete form";
	final static String SEARCH_PANEL = "Card with search form";
	
	ImageIcon search_icon = new ImageIcon("res/search_icon_20.png","Search Icon");
	ImageIcon add_icon = new ImageIcon("res/add_icon_20.png","Search Icon");
	
	JPanel mainPanel,menuPanel,contentPanel;
	JPanel card_welcome, card_add_1, card_add_2, card_search;
	JPanel card_search_west,card_search_center;
	JTextField tf_name_of_article, tf_name_of_author, tf_name_of_journal, tf_number_of_pages, tf_date, tf_volume, tf_page ;
	JTextField tf_name_of_article_2, tf_name_of_author_2, tf_name_of_conference_2,tf_number_of_pages_2, tf_date_2, tf_city_2;
	JTextField tf_search;
	
	JButton btn_sumbit_1 , btn_sumbit_2 , btn_search;
	
	CardLayout card_layout = new CardLayout();
	GridBagConstraints c = new GridBagConstraints();
	
	GridBagConstraints c_search_cetner = new GridBagConstraints();
	
	JMenuBar menuBar;
	JMenu menu_add, menu_separator, menu_search;
	JMenuItem menu_add_item1, menu_add_item2, menu_search_item;
	
	JComboBox  comboboxSearch;
	JTable searchTable;
	
	
	
	
	//Constructor of Window
	public Window(int width, int height, String title, PaperManager manager) {
		
				this.manager = manager;
				
				JFrame frame = new JFrame(title);
				frame.setSize(width,height);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);	
				frame.setVisible(true);
			
				
				
				
				/* Creating the components*/
				
				mainPanel = new JPanel(new BorderLayout());
				menuPanel = new JPanel(new BorderLayout());
				contentPanel = new JPanel(card_layout);
				
				mainPanel.add(menuPanel, BorderLayout.NORTH);
				mainPanel.add(contentPanel, BorderLayout.CENTER);
				
				frame.add(mainPanel);
				
			
				
				card_welcome = new JPanel();
				card_add_1 = new JPanel( new GridBagLayout());
				card_add_2 = new JPanel( new GridBagLayout());
				
				card_search = new JPanel(new BorderLayout());
				
				
					
				
				card_welcome.setBackground(Color.GRAY);
				//card_add_1.setBackground(Color.GREEN);
				//card_add_2.setBackground(Color.YELLOW);
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
				menu_search_item = new JMenuItem("Search paper");
				
				
				/*Adding the componnets */
				
				menu_add.add(menu_add_item1);
				menu_add.add(menu_add_item2);
				menu_search.add(menu_search_item);
				
				menuBar.add(menu_add);
				menuBar.add(menu_separator);
				menuBar.add(menu_search);
				
				menu_add_item1.addActionListener(this);
				menu_add_item2.addActionListener(this);
				menu_search_item.addActionListener(this);

				
				menuPanel.add(menuBar, BorderLayout.LINE_START);

				
				contentPanel.add(card_welcome, WELCOME_PANEL);
				contentPanel.add(card_add_1, ADD_PANEL_1);
				contentPanel.add(card_add_2, ADD_PANEL_2);
				contentPanel.add(card_search, SEARCH_PANEL);
				card_layout.show(contentPanel, WELCOME_PANEL); //Setting the default Panel
				
				/* Card1 , Add journal Paper*/
				
				getJPanel_journalPaper();
				getJPanel_conferencePaper();
				getJPanel_searchPaper();
				
					
		
	}//end of Constructor



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
        else if (action.equals("Search paper")) {
            System.out.println("Search Button pressed!");
            card_layout.show(contentPanel, SEARCH_PANEL);
            
        }
        else if (action.equals("btn_sumbit_1")) {
            System.out.println("Sumbit Button pressed!");
            
            String str_name_of_article = tf_name_of_article.getText();
            String str_name_of_author = tf_name_of_author.getText();
            String str_name_of_journal = tf_name_of_journal.getText();
            String str_number_of_pages = tf_number_of_pages.getText();
            String str_date = tf_date.getText();
            String str_volume = tf_volume.getText();
            String str_page = tf_page.getText();
            
          
            	
           manager.addObject(new PaperJournal(str_name_of_article, str_name_of_author, str_name_of_journal,
           		Integer.valueOf(str_number_of_pages),str_date,
           		Integer.valueOf(str_volume), Integer.valueOf(str_page)));
           
            	
           manager.listAllObject();
            
        }
        else if (action.equals("btn_sumbit_2")) {
            System.out.println("Sumbit Button pressed!");
            
            String str_name_of_article = tf_name_of_article_2.getText();
            String str_name_of_author = tf_name_of_author_2.getText();
            String str_name_ofconference = tf_name_of_conference_2.getText();
            String str_number_of_pages = tf_number_of_pages_2.getText();
            String str_date = tf_date_2.getText();
            String str_city = tf_city_2.getText();
            
        }
	}
	
	private JPanel getJPanel_searchPaper() {

		GridBagConstraints c_search_west = new GridBagConstraints();
		
		
		card_search_west = new JPanel();
		card_search_center = new JPanel();
		
		card_search_west.setLayout(new GridBagLayout());
		//card_search_center.setLayout(new FlowLayout());
		
		card_search_west.setBackground(Color.GREEN);
		card_search_center.setBackground(Color.YELLOW);
		
		/* Creating the card_search_west*/
		
		String[] str_comboboxSearch = { "Show ALL","Name of Article", "Name of Author"};
		
		comboboxSearch = new JComboBox(str_comboboxSearch);
		comboboxSearch.setSelectedIndex(0);
		comboboxSearch.addActionListener(this);
		
		tf_search = new JTextField(16);
		btn_search = new JButton("Search");
		btn_search.setActionCommand("btn_search");
		btn_search.addActionListener(this);
		
		
		c_search_west.ipadx = 0;
		c_search_west.anchor = GridBagConstraints.LINE_START;
		c_search_west.insets = new Insets(6,6,6,6);  
		c_search_west.gridx = 0;
		c_search_west.gridy = 0;
		card_search_west.add(new JLabel("Search By"),c_search_west);
		c_search_west.gridx = 1;
		c_search_west.gridy = 0;
		card_search_west.add(comboboxSearch,c_search_west);
		c_search_west.gridwidth = 2;
		c_search_west.gridx = 0;
		c_search_west.gridy = 1;
		card_search_west.add(tf_search,c_search_west);
		c_search_west.insets = new Insets(6,30,6,6);
		c_search_west.ipadx = 50;
		c_search_west.gridx = 0;
		c_search_west.gridy = 2;
		card_search_west.add(btn_search,c_search_west);
		
		/* Creating the card_search center*/

		/*String[] columnNames = {"ID",
                "Article Name",
                "Type",
                "Details"};
		
		Object[][] data = {
				{"Hello"," World","Hello","Show more"},
				{"Okey","Bey","Hello"," World"}
		};
		
		searchTable = new JTable(data, columnNames);

		searchTable.setEnabled(false); */
		
		
		//card_search_center.add(searchTable.getTableHeader());
		//card_search_center.add(searchTable);
		
		JButtonTableExample search_table = new JButtonTableExample();
		
		
		card_search_center.setLayout(new BorderLayout());
		/*
		card_search_center.add(searchTable.getTableHeader(), BorderLayout.PAGE_START);
		card_search_center.add(searchTable, BorderLayout.CENTER);
		*/
		card_search_center.add(search_table.getJScrollPaneTable());

		
		
		/* Merging them together*/
		
		card_search.add(card_search_west, BorderLayout.WEST);
		card_search.add(card_search_center, BorderLayout.CENTER);
		
		return card_search;
	}
	
	private JPanel getJPanel_conferencePaper() {

		
		tf_name_of_article_2 = new JTextField(15);
		tf_name_of_author_2 = new JTextField(15);
		tf_name_of_conference_2 = new JTextField(15);
		tf_date_2 = new JTextField("12/3/2019",6);
		tf_city_2 = new JTextField(8);
		
		
		btn_sumbit_2 = new JButton("Sumbit");
		btn_sumbit_2.setActionCommand("btn_sumbit_2");
		btn_sumbit_2.addActionListener(this);
		
		c.ipadx = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(6,6,6,6);  
		c.gridx = 0;
		c.gridy = 0;
		card_add_2.add(new JLabel("Name of article"),c);
		c.gridx = 1;
		c.gridy = 0;
		card_add_2.add(tf_name_of_article_2,c);
		c.gridx = 0;
		c.gridy = 1;
		card_add_2.add(new JLabel("Name of author"),c);
		c.gridx = 1;
		c.gridy = 1;
		card_add_2.add(tf_name_of_author_2,c);
		c.gridx = 0;
		c.gridy = 2;
		card_add_2.add( new JLabel("Name of Conference"),c);
		c.gridx = 1;
		c.gridy = 2;
		card_add_2.add(tf_name_of_conference_2,c);
		c.gridx = 0;
		c.gridy = 3;
		card_add_2.add(new JLabel("Date of Conference"),c);
		c.gridx = 1;
		c.gridy = 3;
		card_add_2.add(tf_date_2,c);
		c.gridx = 0;
		c.gridy = 4;
		card_add_2.add(new JLabel("City"),c);
		c.gridx = 1;
		c.gridy = 4;
		card_add_2.add(tf_city_2,c);
		
		
		c.ipadx = 50;
		c.gridx = 1;
		c.gridy = 5;
		card_add_2.add(btn_sumbit_2,c);
		
		return card_add_2;
	}
	
	
	private JPanel getJPanel_journalPaper() {
		
		tf_name_of_article = new JTextField(15);
		tf_name_of_author = new JTextField(15);
		tf_name_of_journal = new JTextField(15);
		tf_number_of_pages = new JTextField(3);
		tf_date = new JTextField("12/3/2019",6);
		tf_volume = new JTextField(3);
		tf_page = new JTextField(3);
		
		btn_sumbit_1 = new JButton("Sumbit");
		btn_sumbit_1.setActionCommand("btn_sumbit_1");
		btn_sumbit_1.addActionListener(this);
		
		c.ipadx = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(6,6,6,6);  
		c.gridx = 0;
		c.gridy = 0;
		card_add_1.add(new JLabel("Name of article"),c);
		c.gridx = 1;
		c.gridy = 0;
		card_add_1.add(tf_name_of_article,c);
		c.gridx = 0;
		c.gridy = 1;
		card_add_1.add(new JLabel("Name of author"),c);
		c.gridx = 1;
		c.gridy = 1;
		card_add_1.add(tf_name_of_author,c);
		c.gridx = 0;
		c.gridy = 2;
		card_add_1.add( new JLabel("Name of Journal"),c);
		c.gridx = 1;
		c.gridy = 2;
		card_add_1.add(tf_name_of_journal,c);
		c.gridx = 0;
		c.gridy = 3;
		card_add_1.add(new JLabel("Amount of pages"),c);
		c.gridx = 1;
		c.gridy = 3;
		card_add_1.add(tf_number_of_pages,c);
		c.gridx = 0;
		c.gridy = 4;
		card_add_1.add(new JLabel("Publish's Date"),c);
		c.gridx = 1;
		c.gridy = 4;
		card_add_1.add(tf_date,c);
		c.gridx = 0;
		c.gridy = 5;
		card_add_1.add(new JLabel("Volume"),c);
		c.gridx = 1;
		c.gridy = 5;
		card_add_1.add(tf_volume,c);
		c.gridx = 0;
		c.gridy = 6;
		card_add_1.add( new JLabel("Article's page"),c);
		c.gridx = 1;
		c.gridy = 6;
		card_add_1.add(tf_page,c);
		
		c.ipadx = 50;
		c.gridx = 1;
		c.gridy = 7;
		card_add_1.add(btn_sumbit_1,c);
		
		return card_add_1;
	}
	
	
}//end of class Window
