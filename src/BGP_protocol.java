


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
public class BGP_protocol extends JFrame {
    boolean v1 = false;          //to set the visibility for nodes on panel 2
    boolean v2 = false;
    boolean v3 = false;
    boolean v4 = false;
    boolean v5 = false;
    boolean v6 = false;
    int i,j;
    int NO_PARENT = -1;
    int check_as;
    
    int temp_value;
    int dist[] = new int[10];
    int as_path[] = new int[10];
    int as_path_index;
    String[][][] dup_row = new String[10][10][10];
    boolean ed[][] = new boolean[10][10];
    int ed_int[][] = new int[10][10];
    int x_value;    // First node value of edge
    int y_value;   // Second value of edge
    int node;         // value of no. of nodes
    int edg;            //value of  no. of edge
    int as;
    int node_size;
    Integer[] as_node_list = new Integer[10];
    Integer[] node_selector_list = new Integer[10];
    Integer[] node_list = new Integer[10];
    Integer[] speaker_node = new Integer[10];
    Integer[] as_selector_list = new Integer[10];
    Integer[] node_per_as_list = new Integer[10];
	int vert[][];
	int count=1;
	int rip_x;  //variable to store input in RIP protocol
 	int rip_y;
 	int num_edge;
 	JScrollPane jp;
	boolean visited[] = new boolean[10];
	Integer[][] ospf_row = new Integer[15][15];
	int ospf_source;
	  int neigh[] = new int[10];
	  int add_count=1;
	  int as_value;
	  int node_value=1;
      Integer bgp_data[][]  = new Integer[10][10];
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
      SpinnerModel n_num = new SpinnerNumberModel(0, 0, 6, 1);
  	SpinnerModel as_num = new SpinnerNumberModel(0, 0, 6, 1);
      String row[][] = {{"1",""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};           //routing table values
	String row1[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String row2[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String row3[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String row4[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String row5[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String dups_row[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};           //duplicate table to initialise the vlaues
	String dups_row1[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String dups_row2[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String dups_row3[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String dups_row4[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
	String dups_row5[][] = {{"1", ""},{"2", ""},{"3", ""},{"4", ""},{"5", ""},{"6", ""}};
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
	  public void paint(Graphics g) {
	    	// TODO Auto-generated method stub
	    	 int x_dis = screenSize.width/2;
	    	 x_dis/=2;
	    	super.paintComponents(g);
	    	g.setColor(Color.GREEN);
	    	for(int i=1;i<=6;i++)
	    	{
	    		if(i==1) {g.setColor(Color.BLUE);}
	    		if(i==2) {g.setColor(Color.RED);}
	    		if(i==3) {g.setColor(Color.PINK);}
	    		if(i==4) {g.setColor(Color.CYAN);}
	    		if(i==5) {g.setColor(Color.MAGENTA);}
	    		if(i==6) {g.setColor(Color.YELLOW);}
	    		if(speaker_node[i]!=999)
	    		{
	    			if(speaker_node[i]==1)
	    	    	{
	    				g.drawOval(screenSize.width/2+x_dis, 100, 20, 20);
	    	            g.fillOval(screenSize.width/2+x_dis, 100, 20, 20);
	    	            //p2.add(new JLabel("1")).setBounds(screenSize.width/2+20, 100+20, 10, 10);
	    	            String text = "1";
	    	            FontMetrics fm = g.getFontMetrics();
	    	            double textWidth = fm.getStringBounds(text, g).getWidth();
	    	            g.setColor(Color.BLACK);
	    	            g.drawString(text, (int) (screenSize.width/2+x_dis+10 - textWidth/2),
	    	                               (int) (110 + fm.getMaxAscent() / 2));
	    	           // g.drawOval(screenSize.width/2+x_dis+50, 100, 20, 20);
//	    	            g.drawChars('A',screenSize.width/2+x_dis+20, 100, 10, 10);
	    	           // g.drawChars(arg0, arg1, arg2, arg3, arg4);
	    	    	}
	    	    	if(speaker_node[i]==2)
	    	        {
	    	    		g.drawOval(screenSize.width/2+x_dis-100, 200, 20, 20);
	    	            g.fillOval(screenSize.width/2+x_dis-100, 200, 20, 20);
	    	            String text = "2";
	    	            FontMetrics fm = g.getFontMetrics();
	    	            double textWidth = fm.getStringBounds(text, g).getWidth();
	    	            g.setColor(Color.BLACK);
	    	            g.drawString(text, (int) (screenSize.width/2+x_dis-100+10 - textWidth/2),
	    	                               (int) (210 + fm.getMaxAscent() / 2));
	    	        }
	    	    	if(speaker_node[i]==3)
	    	        {
	    	    		
	    	    		g.drawOval(screenSize.width/2+x_dis+100, 200, 20, 20);
	    	            g.fillOval(screenSize.width/2+x_dis+100, 200, 20, 20);
	    	            String text = "3";
	    	            FontMetrics fm = g.getFontMetrics();
	    	            double textWidth = fm.getStringBounds(text, g).getWidth();
	    	            g.setColor(Color.BLACK);
	    	            g.drawString(text, (int) (screenSize.width/2+x_dis+100+10 - textWidth/2),
	    	                               (int) (210 + fm.getMaxAscent() / 2));
	    	        }
	    	    	if(speaker_node[i]==4)
	    	        {
	    	    		g.drawOval(screenSize.width/2+x_dis-100, 300, 20, 20);
	    	            g.fillOval(screenSize.width/2+x_dis-100, 300, 20, 20);
	    	            String text = "4";
	    	            FontMetrics fm = g.getFontMetrics();
	    	            double textWidth = fm.getStringBounds(text, g).getWidth();
	    	            g.setColor(Color.BLACK);
	    	            g.drawString(text, (int) (screenSize.width/2+x_dis-100+10 - textWidth/2),
	    	                               (int) (310 + fm.getMaxAscent() / 2));
	    	        }
	    	    	if(speaker_node[i]==5)
	    	        {
	    	    		
	    	    		g.drawOval(screenSize.width/2+x_dis+100, 300, 20, 20);
	    	            g.fillOval(screenSize.width/2+x_dis+100, 300, 20, 20);
	    	            String text = "5";
	    	            FontMetrics fm = g.getFontMetrics();
	    	            double textWidth = fm.getStringBounds(text, g).getWidth();
	    	            g.setColor(Color.BLACK);
	    	            g.drawString(text, (int) (screenSize.width/2+x_dis+100+10 - textWidth/2),
	    	                               (int) (310 + fm.getMaxAscent() / 2));
	    	        }
	    	    	if(speaker_node[i]==6)
	    	        {
	    	     		g.drawOval(screenSize.width/2+x_dis, 400, 20, 20);
	    	             g.fillOval(screenSize.width/2+x_dis, 400, 20, 20);
	    	             String text = "6";
	    	             FontMetrics fm = g.getFontMetrics();
	    	             double textWidth = fm.getStringBounds(text, g).getWidth();
	    	             g.setColor(Color.BLACK);
	    	             g.drawString(text, (int) (screenSize.width/2+x_dis+10 - textWidth/2),
	    	                                (int) (410 + fm.getMaxAscent() / 2));
	    	        }
	    		}
	    	}
	    	g.setColor(Color.YELLOW);
	    	if(ed[1][2]||ed[2][1])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis-100, 200);
//	    		row[1][1]=String.valueOf(1);
//	    	    row1[0][1]=String.valueOf(1);
	    	}
	    	if(ed[1][3]||ed[3][1])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis+100, 200);
//	    		row[2][1]=String.valueOf(1);
//	    	    row2[0][1]=String.valueOf(1);
	    	}
	    	if(ed[1][4]||ed[4][1])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis-100, 300);
	    	}
	    	if(ed[1][5]||ed[5][1])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis+100, 300);
	    	}
	    	if(ed[1][6]||ed[6][1])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis, 100,screenSize.width/2+x_dis, 400);
	    	}
	    	if(ed[2][3]||ed[3][2])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis-100, 200, screenSize.width/2+x_dis+100, 200);
	    	}
	    	if(ed[2][4]||ed[4][2])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis-100, 200, screenSize.width/2+x_dis-100, 300);
	    	}
	    	if(ed[2][5]||ed[5][2])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis-100, 200, screenSize.width/2+x_dis+100, 300);
	    	}
	    	if(ed[2][6]||ed[6][2])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis, 100,screenSize.width/2+x_dis, 400);
	    	}
	    	if(ed[3][4]||ed[4][3])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis+100, 200, screenSize.width/2+x_dis-100, 300);
	    	}
	    	if(ed[3][5]||ed[5][3])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis+100, 200,screenSize.width/2+x_dis+100, 300);
	    	}
	    	if(ed[3][6]||ed[6][3])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis+100, 200,screenSize.width/2+x_dis, 400);
	    	}
	    	if(ed[4][5]||ed[5][4])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis-100, 300, screenSize.width/2+x_dis+100, 300);
	    	}
	    	if(ed[4][6]||ed[6][4])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis-100, 300, screenSize.width/2+x_dis, 400);
	    	}
	    	if(ed[5][6]||ed[6][5])
	    	{
	    		g.drawLine(screenSize.width/2+x_dis+100, 300, screenSize.width/2+x_dis, 400);
	    	}
	    
	  }
	
    BGP_protocol()
    {
    	   for(int i=1;i<=6;i++)
			   {
				   for(int j=1;j<=6;j++)
				   {
					  // System.out.println(bgp_data[i][j]);
					   bgp_data[i][j]=999;
					   ed[i][j]=false;
					   ed_int[i][j]=0;
				   }
			   }
    	
    	   for(int i=1;i<=6;i++)
			{
			
				speaker_node[i]=999;
			}
    	   

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
    	
    	SpinnerModel v_num = new SpinnerNumberModel(0, 0, 12, 1);
    	SpinnerListModel x = new SpinnerListModel(as_node_list);
    	SpinnerListModel y = new SpinnerListModel(as_node_list);
    	JSpinner spin = new JSpinner(n_num);
    	JSpinner spin2 = new JSpinner(as_num);
    	JMenuBar mb = new JMenuBar();
    	JMenuItem as1 = new JMenuItem("AS1 - BLUE ");
    	JMenuItem as2 = new JMenuItem("AS2 - RED ");
    	JMenuItem as3 = new JMenuItem("AS3 - PINK ");
    	JMenuItem as4 = new JMenuItem("AS4 - CYAN ");
    	JMenuItem as5 = new JMenuItem("AS5 - MAGNETA ");
    	JMenuItem as6 = new JMenuItem("AS6 - YELLOW ");
    	JMenu help  = new JMenu("AS COLOR REFERNCE");
    	JSpinner as_edge = new JSpinner(v_num);
    	JSpinner xspin = new JSpinner(x);
    	JSpinner yspin = new JSpinner(y);
    	
    	JButton  next = new JButton("NEXT");   //to draw the value of edges
    	JButton  submit = new JButton("SUBMIT");
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
        
    	help.add(as1);
    	help.add(as2);
    	help.add(as3);
    	help.add(as4);
    	help.add(as5);
    	help.add(as6);
    	mb.add(help);
    	setJMenuBar(mb);
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
     	p1.add(as_detail);
     	p1.add(as_lists);
    	p1.add(node_detail_label);
    	p1.add(node_per_as);
    	p1.add(node_add);
    	p1.add(node_selectors);
    	p1.add(add);
    	p1.add(next_submit);
    	p1.add(num_node4);
     	p1.add(as_edge);
     	p1.add(num_node3);
     	p1.add(xspin);
     	p1.add(yspin);
     	p1.add(next);
     	p1.add(submit);
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
    	next_submit.setEnabled(false);
    	submit.setVisible(false);
    	
    next_submit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			add.setEnabled(true);
			add_count=1;
			node_value=1;
			int temp_as = (int) as_list.getValue();
        	delete_selected_as(temp_as);
        	int temp_node_per_as = (int) node_per_as.getValue();
        	for(int i=1;i<=temp_node_per_as;i++)
        	{delete_selected_node_per_as(temp_value);temp_value--;}
        	as_lists.setValue(null);
        	node_per_as.setValue(null);
			speaker_node[temp_as]=bgp_data[temp_as][1];
			for(int i=1;i<=6;i++)
			{
				//System.out.println(speaker_node[i]);
			}
		  repaint();	
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
			int temps_as = (int) as_list.getValue();
			bgp_data[temps_as][node_value]=temp_selected_node;
			node_value++;
			node_selector.setValue(null);
			/*for(int i=1;i<=6;i++)
			   {
				   for(int j=1;j<=6;j++)
				   {
					   System.out.println(bgp_data[i][j]);
				   }
			   }*/
			
			
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
			        	next_submit.setEnabled(true);
			        	
			        	
			    	}
			        add_count++;
				}
			
		}
	});
    	
    	 next.addActionListener(new ActionListener() {             //writing the function for next button
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				num_edge=(int) as_edge.getValue();
 				if(count<=num_edge)
 				{
 			    	x_value = (Integer) xspin.getValue();
 			        y_value = (Integer) yspin.getValue();
 			       ed_int[x_value][y_value]=1;
 			      ed_int[y_value][x_value]=1;   
 			        x_value = speaker_node[x_value];
 			        y_value = speaker_node[y_value];
 			       ed[x_value][y_value]=true;
					ed[y_value][x_value]=true;
 			    
 			      repaint();
 			        if(count==num_edge)
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
 			        if(count>num_edge)
 			        {
 			        	submit.setVisible(true);
 			        }
 				}
 				
  			}
 		});
     
    	//Adding routing tables to JFrame
    	//row[1][1]= String.valueOf(555);
		String col[] = {"NETWORK","PATH"};
		/*col[0]="cost";*/
	     JTable tb = new JTable(row,col);
		jp = new JScrollPane(tb);
		tb.setToolTipText("TABLE FOR SPEAKER NODE 1");
		jp.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));

	    JTable tb1 = new JTable(row1,col);
		JScrollPane jp1 = new JScrollPane(tb1);
		tb1.setToolTipText("TABLE FOR SPEAKER NODE 2");
		jp1.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		//jp.setBounds(400,500,40,50);
		
		JTable tb2 = new JTable(row2,col);
		JScrollPane jp2 = new JScrollPane(tb2);
		tb2.setToolTipText("TABLE FOR SPEAKER NODE 3");
		jp2.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
			//jp.setBounds(400,500,40,50);
		
		//p3.add(jp2);
        add(new Label("hello"));
        JTable tb3 = new JTable(row3,col);
		JScrollPane jp3 = new JScrollPane(tb3);
		tb3.setToolTipText("TABLE FOR SPEAKER NODE 4");
		jp3.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		
		JTable tb4 = new JTable(row4,col);
		JScrollPane jp4 = new JScrollPane(tb4);
		tb4.setToolTipText("TABLE FOR SPEAKER NODE 5");
		jp4.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		
		JTable tb5 = new JTable(row5,col);
		JScrollPane jp5 = new JScrollPane(tb5);
		tb5.setToolTipText("TABLE FOR SPEAKER NODE 6");
		jp5.setPreferredSize(new Dimension(screenSize.width/7+25,screenSize.height/2-100));
		p3.add(jp);
		p3.add(jp1);
		p3.add(jp2);
		p3.add(jp3);
		p3.add(jp4);
		p3.add(jp5);
		jp.setVisible(false);
		jp1.setVisible(false);
		jp2.setVisible(false);
		jp3.setVisible(false);
		jp4.setVisible(false);
		jp5.setVisible(false);
		p3.setVisible(false);
	   
		//scrollPane.setBorder(BorderFactory.createTitledBorder("HEllo"));
    	
    	setExtendedState(MAXIMIZED_BOTH);  // setting Jframe to full size
    	setVisible(true);
        submit.addActionListener(new ActionListener() {            //function for reset button
 			
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				// TODO Auto-generated method stub
     			   
     				for(int i=1;i<=6;i++)
     			   {
     				   for(int j=1;j<=6;j++)
     				   {
     					 //  System.out.println(bgp_data[i][j]);
     					   //bgp_data[i][j]=999;
     				   }
     			   }
     			    /* n_num.setValue(0);
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
     	    	    spin2.setEnabled(true);*/
     				p3.setVisible(true);
     				row[0][1] = String.valueOf(1); 
     				
     				for(int i=1;i<=(int)as_num.getValue();i++)
     				{
     					/*for(int j=1;j<=(int)as_num.getValue();j++)
     					{
     						System.out.print(ed_int[i][j]);
     					}*/
     					if(speaker_node[i]!=999)
     					{
     						
     						if(speaker_node[i]==1) {
     						
     							for(int j=0;j<6;j++) {
     								row[j][1]="AS"+String.valueOf(i);
     							}
     							jp.setVisible(true);
     							for(int m=1;m<=(int)n_num.getValue();m++)
     								{
     								 if(bgp_data[i][m]!=999)
     								 {
     									 
     									 
     									 check_as=bgp_data[i][m];
     									 row[check_as-1][1]+="(SAME AS)";
     								 }
     								 
     								 int flag=0;
     								 for(int n=1;n<=(int)n_num.getValue();n++)
     								 {
     									 if(m==bgp_data[i][n])
     								 {
     									
     									 //dijsktra(ed_int,temp_source,temp_dest);
                                         flag=1;     								
     									
     								 }
     									 
     								 }
     							 if(flag==0)
     								 {
     								   
     									 int temp_source = i;
     									 int temp_dest = as_index(m);
     									 //System.out.println(temp_dest);
     									 //System.out.println(temp_dest);
     									dikstra(temp_source);
     									int temp_trav=temp_dest;
     									as_path_index=0;
     									while(temp_trav!=temp_source)
     									{
     										//System.out.println(neigh[temp_trav]);
     										as_path_index++;
     										as_path[as_path_index]=neigh[temp_trav];
     									    
     									temp_trav=neigh[temp_trav];
     									}
     									for(int qw=as_path_index-1;qw>=1;qw--)
     									{
     										//System.out.println( as_path[qw]);
     										row[m-1][1]+="-AS"+String.valueOf( as_path[qw]);
     									}
     									row[m-1][1]+="-AS"+String.valueOf(temp_dest);
     								
     								 }
     								 
     								 }
     						  
     						}
     						if(speaker_node[i]==2) {
         						
     							for(int j=0;j<6;j++) {
     								row1[j][1]="AS"+String.valueOf(i);
     							}
     							jp1.setVisible(true);
     							for(int m=1;m<=(int)n_num.getValue();m++)
     								{
     								 if(bgp_data[i][m]!=999)
     								 {
     									 
     									 
     									 check_as=bgp_data[i][m];
     									 row1[check_as-1][1]+="(SAME AS)";
     								 }
     								 
     								 int flag=0;
     								 for(int n=1;n<=(int)n_num.getValue();n++)
     								 {
     									 if(m==bgp_data[i][n])
     								 {
     									
     									 //dijsktra(ed_int,temp_source,temp_dest);
                                         flag=1;     								
     									
     								 }
     									 
     								 }
     							 if(flag==0)
     								 {
     								   
     									 int temp_source = i;
     									 int temp_dest = as_index(m);
     									 //System.out.println(temp_dest);
     									 //System.out.println(temp_dest);
     									dikstra(temp_source);
     									int temp_trav=temp_dest;
     									as_path_index=0;
     									while(temp_trav!=temp_source)
     									{
     										//System.out.println(neigh[temp_trav]);
     										as_path_index++;
     										as_path[as_path_index]=neigh[temp_trav];
     									    
     									temp_trav=neigh[temp_trav];
     									}
     									for(int qw=as_path_index-1;qw>=1;qw--)
     									{
     										//System.out.println( as_path[qw]);
     										row1[m-1][1]+="-AS"+String.valueOf( as_path[qw]);
     									}
     									row1[m-1][1]+="-AS"+String.valueOf(temp_dest);
     								
     								 }
     								 
     								 }
     						  
     						}
                            if(speaker_node[i]==3) {
         						
     							for(int j=0;j<6;j++) {
     								row2[j][1]="AS"+String.valueOf(i);
     							}
     							jp2.setVisible(true);
     							for(int m=1;m<=(int)n_num.getValue();m++)
     								{
     								 if(bgp_data[i][m]!=999)
     								 {
     									 
     									 
     									 check_as=bgp_data[i][m];
     									 row2[check_as-1][1]+="(SAME AS)";
     								 }
     								 
     								 int flag=0;
     								 for(int n=1;n<=(int)n_num.getValue();n++)
     								 {
     									 if(m==bgp_data[i][n])
     								 {
     									
     									 //dijsktra(ed_int,temp_source,temp_dest);
                                         flag=1;     								
     									
     								 }
     									 
     								 }
     							 if(flag==0)
     								 {
     								   
     									 int temp_source = i;
     									 int temp_dest = as_index(m);
     									 //System.out.println(temp_dest);
     									 //System.out.println(temp_dest);
     									dikstra(temp_source);
     									int temp_trav=temp_dest;
     									as_path_index=0;
     									while(temp_trav!=temp_source)
     									{
     										//System.out.println(neigh[temp_trav]);
     										as_path_index++;
     										as_path[as_path_index]=neigh[temp_trav];
     									    
     									temp_trav=neigh[temp_trav];
     									}
     									for(int qw=as_path_index-1;qw>=1;qw--)
     									{
     										//System.out.println( as_path[qw]);
     										row2[m-1][1]+="-AS"+String.valueOf( as_path[qw]);
     									}
     									row2[m-1][1]+="-AS"+String.valueOf(temp_dest);
     								
     								 }
     								 
     								 }
     						  
     						}
                         if(speaker_node[i]==4) {
         						
     							for(int j=0;j<6;j++) {
     								row3[j][1]="AS"+String.valueOf(i);
     							}
     							jp3.setVisible(true);
     							for(int m=1;m<=(int)n_num.getValue();m++)
     								{
     								 if(bgp_data[i][m]!=999)
     								 {
     									 
     									 
     									 check_as=bgp_data[i][m];
     									 row3[check_as-1][1]+="(SAME AS)";
     								 }
     								 
     								 int flag=0;
     								 for(int n=1;n<=(int)n_num.getValue();n++)
     								 {
     									 if(m==bgp_data[i][n])
     								 {
     									
     									 //dijsktra(ed_int,temp_source,temp_dest);
                                         flag=1;     								
     									
     								 }
     									 
     								 }
     							 if(flag==0)
     								 {
     								   
     									 int temp_source = i;
     									 int temp_dest = as_index(m);
     									 //System.out.println(temp_dest);
     									 //System.out.println(temp_dest);
     									dikstra(temp_source);
     									int temp_trav=temp_dest;
     									as_path_index=0;
     									while(temp_trav!=temp_source)
     									{
     										//System.out.println(neigh[temp_trav]);
     										as_path_index++;
     										as_path[as_path_index]=neigh[temp_trav];
     									    
     									temp_trav=neigh[temp_trav];
     									}
     									for(int qw=as_path_index-1;qw>=1;qw--)
     									{
     										//System.out.println( as_path[qw]);
     										row3[m-1][1]+="-AS"+String.valueOf( as_path[qw]);
     									}
     									row3[m-1][1]+="-AS"+String.valueOf(temp_dest);
     								
     								 }
     								 
     								 }
     						  
     						}
                         if(speaker_node[i]==5) {
      						
  							for(int j=0;j<6;j++) {
  								row4[j][1]="AS"+String.valueOf(i);
  							}
  							jp4.setVisible(true);
  							for(int m=1;m<=(int)n_num.getValue();m++)
  								{
  								 if(bgp_data[i][m]!=999)
  								 {
  									 
  									 
  									 check_as=bgp_data[i][m];
  									 row4[check_as-1][1]+="(SAME AS)";
  								 }
  								 
  								 int flag=0;
  								 for(int n=1;n<=(int)n_num.getValue();n++)
  								 {
  									 if(m==bgp_data[i][n])
  								 {
  									
  									 //dijsktra(ed_int,temp_source,temp_dest);
                                      flag=1;     								
  									
  								 }
  									 
  								 }
  							 if(flag==0)
  								 {
  								   
  									 int temp_source = i;
  									 int temp_dest = as_index(m);
  									 //System.out.println(temp_dest);
  									 //System.out.println(temp_dest);
  									dikstra(temp_source);
  									int temp_trav=temp_dest;
  									as_path_index=0;
  									while(temp_trav!=temp_source)
  									{
  										//System.out.println(neigh[temp_trav]);
  										as_path_index++;
  										as_path[as_path_index]=neigh[temp_trav];
  									    
  									temp_trav=neigh[temp_trav];
  									}
  									for(int qw=as_path_index-1;qw>=1;qw--)
  									{
  										//System.out.println( as_path[qw]);
  										row4[m-1][1]+="-AS"+String.valueOf( as_path[qw]);
  									}
  									row4[m-1][1]+="-AS"+String.valueOf(temp_dest);
  								
  								 }
  								 
  								 }
  						  
  						}
                         if(speaker_node[i]==6) {
      						
  							for(int j=0;j<6;j++) {
  								row5[j][1]="AS"+String.valueOf(i);
  							}
  							jp5.setVisible(true);
  							for(int m=1;m<=(int)n_num.getValue();m++)
  								{
  								 if(bgp_data[i][m]!=999)
  								 {
  									 
  									 
  									 check_as=bgp_data[i][m];
  									 row5[check_as-1][1]+="(SAME AS)";
  								 }
  								 
  								 int flag=0;
  								 for(int n=1;n<=(int)n_num.getValue();n++)
  								 {
  									 if(m==bgp_data[i][n])
  								 {
  									
  									 //dijsktra(ed_int,temp_source,temp_dest);
                                      flag=1;     								
  									
  								 }
  									 
  								 }
  							 if(flag==0)
  								 {
  								   
  									 int temp_source = i;
  									 int temp_dest = as_index(m);
  									 //System.out.println(temp_dest);
  									 //System.out.println(temp_dest);
  									dikstra(temp_source);
  									int temp_trav=temp_dest;
  									as_path_index=0;
  									while(temp_trav!=temp_source)
  									{
  										//System.out.println(neigh[temp_trav]);
  										as_path_index++;
  										as_path[as_path_index]=neigh[temp_trav];
  									    
  									temp_trav=neigh[temp_trav];
  									}
  									for(int qw=as_path_index-1;qw>=1;qw--)
  									{
  										//System.out.println( as_path[qw]);
  										row5[m-1][1]+="-AS"+String.valueOf( as_path[qw]);
  									}
  									row5[m-1][1]+="-AS"+String.valueOf(temp_dest);
  								
  								 }
  								 
  								 }
  						  
  						}
     					}
     				
     					
     				}
     				
     			}
     		});
    
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
    public int as_index(int x)
    {
    	int temp=0;
    	for(int i=1;i<=(int)as_num.getValue();i++)
    	{
    		for(int j=1;j<=(int)n_num.getValue();j++)
    		if(bgp_data[i][j]==x)
    		{
    			temp=i;
    		}
    	}
    	return temp;
    }
    public int minValue(int dist[])
    {
    	
    	 int minVal = 999;
    	 int temp=0;
    	//index_node = ospf_source;
    	//if(visited[ospf_source]==true) {minVal=999;}
    	for(i=1;i<=(int)as_num.getValue();i++)
    	{
    		//System.out.println("dist" + visited[i]);
    		if(minVal>dist[i]&&visited[i]==false)
    			
    			
    		{
    			//System.out.println("hello");
    			minVal = dist[i];
    			temp = i;
    		}
    		
    	}
    	//System.out.println(index_node);	
    	
    	visited[temp]=true;
    	
    	return temp;
    }
    public void dikstra(int temp_source)
    {
    	
    	for(i=1;i<=(int)as_num.getValue();i++)
			{
				dist[i]=999;
			}
			dist[temp_source]=0;
			for(i=1;i<=(int)as_num.getValue();i++)
			{
				visited[i]=false;
			}
			for(int k=1;k<=(Integer)as_num.getValue();k++)
				
			{
		      int min_index = minValue(dist); 
		      //System.out.println(min_index);	 
		      int mm;
		      for(mm=1;mm<=(int)as_num.getValue();mm++)
		      {
		    	
		    	if(ed_int[min_index][mm]==1 && visited[mm]==false)
		    	{
		    		if(dist[min_index]+ed_int[min_index][mm]<=dist[mm])
		    		{
	    			    dist[mm]=dist[min_index]+ed_int[min_index][mm];
		    			neigh[mm]=min_index;
                    
		    			
		    			 
		    			
		    		}
		    	}
		    	
		      }
		      
			   
			}
		/*	for(int z=1;z<=(int)as_num.getValue();z++)
			{
				System.out.println(neigh[z]);
			}*/
    
    	
    }
    

     
    public static void main(String[] args) {
		new BGP_protocol();
		/*ospf_Frame = new ospf_Module();*/
	}
 
}
