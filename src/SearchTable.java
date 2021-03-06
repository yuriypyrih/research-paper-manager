//ICSD16157 YURIY PYRIH
//DISTRIBUTED SYSTEMS LAB_1

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class SearchTable {
	
	private JScrollPane scroll;
	private PaperManager manager;
	private DefaultTableModel default_model;
	private JTable table;
	private SEARCH Type;

	
	//private LinkedList<Object[][]> objectDataList = new LinkedList<Object[][]>();
	
	private String[] columnNames = {"ID",
            "Article Name",
            "Type",
            "Details"};
	
	
    public SearchTable( PaperManager manager, SEARCH Type ) {
       
    	this.manager = manager;
    	this.Type = Type;
   

    	default_model = new DefaultTableModel() {
        	@Override
            public boolean isCellEditable(int row, int column) {
              
               return true;
            }
        };
        
        
        
        refreshSearchTable();
        
		/*data = new Object[][]{
				{"Hello"," World","Hello","Show more"},
				{"Okey","Bey","Hello"," Show more"}
		};*/
		
		
       
       
        
    }

    public JScrollPane getJScrollPaneTable() {
    	return scroll;
    }
    
    
    
    public void refreshSearchTable(){
    	//manager.addObject(new PaperConference("Hello there", "haha", "Okey","something","Athens" ));
    	Object[][] data;
    	if(manager.getPaperObjectList(Type) != null) {
    		int list_size = manager.getPaperObjectList(Type).size();
        	int index = 0;
        	data = new Object[list_size][4];
        	
        	for(PaperObject object : manager.getPaperObjectList(Type) ) {
        		data[index][0] = object.getObjectDataTable()[0];
        		data[index][1] = object.getObjectDataTable()[1];
        		data[index][2] = object.getObjectDataTable()[2];
        		data[index][3] = object.getObjectDataTable()[3];
        		System.out.println( object.getObjectDataTable());
        		index++;
        	}
        	
    	}else {
    		data = new Object[0][4];
    	}
    	
    	
    	
    	 table = new JTable(data, columnNames);
    	 
    	 //DefaultTableModel model = (DefaultTableModel) table.getModel();
    	 
    	 
         table.getColumn("Details").setCellRenderer(new ButtonRenderer());
         table.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox(), manager, Type));
         
        
         
         
         System.out.println(table.getRowCount());

         scroll = new JScrollPane(table);

         table.setPreferredScrollableViewportSize(table.getPreferredSize());

         table.getColumnModel().getColumn(0).setPreferredWidth(100);
         
         
       
    }
}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;
    private int index;
    private PaperManager manager;
    private SEARCH Type;
    

    public ButtonEditor(JCheckBox checkBox, PaperManager manager, SEARCH Type) {
        super(checkBox);
     
        this.manager = manager;
        this.Type = Type;
        
        
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
   
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        index = row;
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(null, label + ": Additional Info\n" + manager.getPaperObjectList(Type).get(index).getDetails());
         
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}