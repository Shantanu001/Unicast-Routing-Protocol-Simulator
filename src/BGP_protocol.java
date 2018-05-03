


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Arrays;
public class BGP_protocol extends JFrame {
    boolean v1 = false;          //to set the visibility for nodes on panel 2
    boolean v2 = false;
    boolean v3 = false;
    boolean v4 = false;
    boolean v5 = false;
    boolean v6 = false;
    int i,j;
    int temp_value;
    String[][][] dup_row = new String[10][10][10];
    boolean ed[][] = new boolean[10][10];
    int x_value;    // First node value of edge
    int y_value;   // Second value of edge
    int node;         // value of no. of nodes
    int edg;            //value of  no. of edge
    int as;
    int node_size;
    Integer[] as_node_list = new Integer[10];
    Integer[] node_selector_list = new Integer[10];
    Integer[] node_list = new Integer[10];

    Integer[] as_selector_list = new Integer[10];
    Integer[] node_per_as_list = new Integer[10];
	int vert[][];
	int count=1;
	int rip_x;  //variable to store input in RIP protocol
 	int rip_y;
 	JScrollPane jp;
	boolean visited[] = new boolean[10];
	Integer[][] ospf_row = new Integer[15][15];
	int ospf_source;
	  int neigh[] = new int[10];
	  int add_count=1;

 //	int ospf_source; //getting the value of source node
/* 	String row[][] = new row[10][10];
 	String row1[][] = new row[10][10];
 	String row2[][] = new row[10][10];
 	String row3[][] = new row[10][10];
 	String row4[][] = new row[10][10];
 	String row5[][] = new row[10][10];*/
/* 	for(int m=0;m<6;m++)
 	{
 		for(int z=0;z<6;z++)
 		{
 			row[i][j]=
 		}
 	}*/
	String row[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};           //routing table values
	String row1[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String row2[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String row3[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String row4[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String row5[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String dups_row[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};           //duplicate table to initialise the vlaues
	String dups_row1[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String dups_row2[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String dups_row3[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String dups_row4[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	String dups_row5[][] = {{"1","999",""},{"2","999",""},{"3","999",""},{"4","999",""},{"5","999",""},{"6","999",""}};
	JPanel p2;
    JPanel p3;
    JTable node_a,node_b,node_c,node_d,node_e,node_f; //initialising tables for routing table;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JTextField input1 = new JTextField();        //Inputs and buttons for Rip protocol frame
	JTextField input2 = new JTextField();
	JLabel input1_label = new JLabel("TARGET TABLE");
	JLabel input2_label = new JLabel("REFRENCE TABLE");
	JButton cal = new JButton("CALCULATE");
	JButton fin  = new JButton ("FINAL");
	JButton close = new JButton ("EXIT");
   
    BGP_protocol()
    {

       // node = new Integer("0");
       // Initialising objects for 3 panels
    	p2 = new JPanel();
        p3 = new JPanel(new FlowLayout());
     	
    	
    	
    	JPanel p1 = new JPanel();
    	

/*       JLabel num_node = new JLabel("Enter number of nodes"); 
       JTextField input_node = new JTextField(0);
       SpinnerModel n_num = new SpinnerNumberModel(0, 0, 6, 1);
       SpinnerModel v_num = new SpinnerNumberModel(0, 0, 12, 1);
       JSpinner spin = new JSpinner(n_num);
   	   JSpinner spin2 = new JSpinner(v_num);
       JLabel num_as = new JLabel("Enter number of Autonomous Systems"); 
       JTextField input_as = new JTextField();
       //get month names
       JLabel edge_as = new JLabel("Enter edges between Autonomous Systems");
       SpinnerListModel xspin_model = new SpinnerListModel(as_node_list);
       JSpinner xspin = new JSpinner(xspin_model);
       SpinnerListModel yspin_model = new SpinnerListModel(as_node_list);
       JSpinner yspin = new JSpinner(yspin_model);*/
       p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));   
    	JLabel num_node = new JLabel("ENTER THE NUMBER OF NODES");//Creating interface for taking input in panel(p1)
    	JLabel num_node2 = new JLabel("ENTER THE NUMBER OF AUTONOMOUS SYSTEM");
    	JLabel num_node4 = new JLabel("ENTER THE NUMBER OF EDGES BETWEEN AUTONOMOUS SYSTEM");
    	JLabel num_node3 = new JLabel("ENTER THE VALUE OF EDGES BETWEEN AUTONOMOUS SYSTEM");
    	SpinnerModel n_num = new SpinnerNumberModel(0, 0, 6, 1);
    	SpinnerModel as_num = new SpinnerNumberModel(0, 0, 6, 1);
    	SpinnerModel v_num = new SpinnerNumberModel(0, 0, 12, 1);
    	SpinnerListModel x = new SpinnerListModel(as_node_list);
    	SpinnerListModel y = new SpinnerListModel(as_node_list);
    	JSpinner spin = new JSpinner(n_num);
    	JSpinner spin2 = new JSpinner(as_num);
    	JSpinner as_edge = new JSpinner(v_num);
    	JSpinner xspin = new JSpinner(x);
    	JSpinner yspin = new JSpinner(y);
    	
    	JButton  next = new JButton("NEXT");   //to draw the value of edges
    	JButton  reset = new JButton("RESET");
    	JLabel as_detail = new JLabel("Select Autonomous System");
    	SpinnerListModel as_list = new SpinnerListModel(as_selector_list);
    	JSpinner as_lists = new JSpinner(as_list);
    	JLabel node_detail_label = new JLabel("Select number of nodes for above Autonomous System");
    	SpinnerListModel node_as = new SpinnerListModel(node_per_as_list);
    	JSpinner node_per_as = new JSpinner(node_as);
    	JLabel node_add = new JLabel("Add nodes for the given Autonomous System");
    	SpinnerListModel node_selector = new SpinnerListModel(node_selector_list);
    	JSpinner node_selectors = new JSpinner(node_selector);
    	JButton  add = new JButton("ADD");
    	JButton  next_submit = new JButton("NEXT");
    	((JSpinner.DefaultEditor)spin.getEditor()).getTextField().setEditable(false);//Disabling spinner from getting edited
    	((JSpinner.DefaultEditor)spin2.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)xspin.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)yspin.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)as_edge.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)as_lists.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)node_per_as.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)node_selectors.getEditor()).getTextField().setEditable(false);
        
       
   /*     p1.add(num_node);
        p1.add(spin);
        p1.add(num_as);
        p1.add(spin2);
        p1.add(edge_as);
        p1.add(xspin);
        p1.add(yspin);*/
        
    	p1.add(num_node);
     	p1.add(spin);
     	p1.add(num_node2);
     	p1.add(spin2);
     	p1.add(num_node4);
     	p1.add(as_edge);
     	p1.add(num_node3);
     	p1.add(xspin);
     	p1.add(yspin);
     	p1.add(next);
     	p1.add(reset);
     	p1.add(as_detail);
     	p1.add(as_lists);
    	p1.add(node_detail_label);
    	p1.add(node_per_as);
    	p1.add(node_add);
    	p1.add(node_selectors);
    	p1.add(add);
    	p1.add(next_submit);
        //p1.add(); constraints);
    
    
    	
    
    	                                                            //setting the size and position for all the three panels
    	p1.setBounds(0,0,screenSize.width/2, screenSize.height/2);
        p2.setBounds(screenSize.width/2,0, screenSize.width/2, screenSize.height/2);
        p2.setBackground(Color.BLACK);
        p3.setBounds(0,screenSize.height/2,screenSize.width,screenSize.height/2);
        p3.setBackground(Color.LIGHT_GRAY);
    	 
        add(p1);  //adding panels to Jframe
    	add(p2);
    	add(p3);
    next_submit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			add.setEnabled(true);
			add_count=1;
			int temp_as = (int) as_list.getValue();
        	delete_selected_as(temp_as);
        	int temp_node_per_as = (int) node_per_as.getValue();
        	for(int i=1;i<=temp_node_per_as;i++)
        	{delete_selected_node_per_as(temp_value);temp_value--;}
        	as_lists.setValue(null);
        	node_per_as.setValue(null);
			
			
		}
	});
    	
	n_num.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
			    node_size = (int) n_num.getValue();	
			    temp_value = (int) n_num.getValue();
			    for(int i=1;i<=node_size;i++) {node_list[i]=i;node_selector_list[i]=i;node_per_as_list[i]=i;}
			}
		});
    	
	as_num.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
			    as = (Integer)as_num.getValue();	  
			    for(int i=1;i<=as;i++) {as_node_list[i]=i;as_selector_list[i]=i;}
			}
		});
	v_num.addChangeListener(new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
		    edg = (Integer)as_num.getValue();	  
		}
	});
	  add.addActionListener(new ActionListener() {
		
		  
		  
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			int temp_selected_node = (int)node_selector.getValue();
			delete_selected_node(temp_selected_node );
			node_selector.setValue(null);
			if(add_count<=(int) node_as.getValue()	)
				{
			    	
			       
			        repaint();
			        if(add_count==(int) node_as.getValue()	)
			        {
			        	/*xspin.setEnabled(false);
	                    yspin.setEnabled(false);
	                    next.setText("END");
			    	    next.setEnabled(false);
			    	    as_edge.setEnabled(false);
			    	    spin.setEnabled(false);
			    	    spin2.setEnabled(false);*/
			        
			        	
			        /*	delete_selected_node_per_as(1);*/
			        	add.setEnabled(false);
			        	
			        	
			    	}
			        add_count++;
				}
			
		}
	});
    	
    	 next.addActionListener(new ActionListener() {             //writing the function for next button
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				if(count<=edg)
 				{
 			    	x_value = (Integer) xspin.getValue();
 			        y_value = (Integer) yspin.getValue();
 			       
 			        repaint();
 			        if(count==edg)
 			        {
 			        	xspin.setEnabled(false);
 	                    yspin.setEnabled(false);
 	                    next.setText("END");
 			    	    next.setEnabled(false);
 			    	    as_edge.setEnabled(false);
 			    	    spin.setEnabled(false);
 			    	    spin2.setEnabled(false);
 			    	}
 			        count++;
 				}
  			}
 		});
         reset.addActionListener(new ActionListener() {            //function for reset button
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 			   
 			
 			     n_num.setValue(0);
 			     v_num.setValue(0);
 			     as_num.setValue(0);
 			     edg=0;
 			     xspin.setValue(null);
 			    yspin.setValue(null);
 			    next.setText("NEXT");
 		    	next.setEnabled(true);
 		    	count=1;	
 		    	xspin.setEnabled(true);
 		    	yspin.setEnabled(true);
 		    	spin.setEnabled(true);
 	    	    spin2.setEnabled(true);
 			}
 		});
    	//Adding routing tables to JFrame
    	//row[1][1]= String.valueOf(555);
		String col[] = {"Dest","Hop count","Next Hop"};
		/*col[0]="cost";*/
	     JTable tb = new JTable(row,col);
		jp = new JScrollPane(tb);
		tb.setToolTipText("TABLE FOR NODE A");
		jp.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));

	    JTable tb1 = new JTable(row1,col);
		JScrollPane jp1 = new JScrollPane(tb1);
		jp1.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		//jp.setBounds(400,500,40,50);
		
		JTable tb2 = new JTable(row2,col);
		JScrollPane jp2 = new JScrollPane(tb2);
		jp2.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
			//jp.setBounds(400,500,40,50);
		
		//p3.add(jp2);
        add(new Label("hello"));
        JTable tb3 = new JTable(row3,col);
		JScrollPane jp3 = new JScrollPane(tb3);
		jp3.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		
		JTable tb4 = new JTable(row4,col);
		JScrollPane jp4 = new JScrollPane(tb4);
		jp4.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		
		JTable tb5 = new JTable(row5,col);
		JScrollPane jp5 = new JScrollPane(tb5);
		jp5.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		p3.add(jp);
		p3.add(jp1);
		p3.add(jp2);
		p3.add(jp3);
		p3.add(jp4);
		p3.add(jp5);
		p3.setVisible(false);
	   
		//scrollPane.setBorder(BorderFactory.createTitledBorder("HEllo"));
    	
    	setExtendedState(MAXIMIZED_BOTH);  // setting Jframe to full size
    	setVisible(true);
    
    }
	public  void delete_selected_node(int x)
	    {
	        // Search x in array
	        int i;
	        for (i=1; i<=node_selector_list.length; i++)
	            if (node_selector_list[i] == x)
	                break;
	  
	        // If x found in array
	        if (i <node_selector_list.length)
	        {
	            // reduce size of array and move all
	            // elements on space ahead
	            for (int j=i; j<node_selector_list.length-1; j++)
	                node_selector_list[j] = node_selector_list[j+1];
	        }
	  
	    }
	public  void delete_selected_as(int x)
    {
        // Search x in array
        int i;
        for (i=1; i<=as_selector_list.length; i++)
            if (as_selector_list[i] == x)
                break;
  
        // If x found in array
        if (i <as_selector_list.length)
        {
            // reduce size of array and move all
            // elements on space ahead
            for (int j=i; j<as_selector_list.length-1; j++)
            	as_selector_list[j] = as_selector_list[j+1];
        }
  
    }
	public  void delete_selected_node_per_as(int x)
    {
        // Search x in array
        int i;
        for (i=1; i<=node_per_as_list.length; i++)
            if (node_per_as_list[i] == x)
                break;
  
        // If x found in array
        if (i <node_per_as_list.length)
        {
            // reduce size of array and move all
            // elements on space ahead
            for (int j=i; j<node_per_as_list.length-1; j++)
            	node_per_as_list[j] = node_per_as_list[j+1];
        }
  
    }

	
    public void changeName(JTable table,int col_index,String col_name)
    {
    	table.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
    }

     
    public static void main(String[] args) {
		new BGP_protocol();
		/*ospf_Frame = new ospf_Module();*/
	}
 
}
