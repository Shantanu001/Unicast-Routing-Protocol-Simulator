import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainActivity extends JFrame {
    boolean v1 = false;          //to set the visibility for nodes on panel 2
    boolean v2 = false;
    boolean v3 = false;
    boolean v4 = false;
    boolean v5 = false;
    boolean v6 = false;
    int i,j;
    String[][][] dup_row = new String[10][10][10];
    boolean ed[][] = new boolean[10][10];
    int x_value;    // First node value of edge
    int y_value;   // Second value of edge
    int node;         // value of no. of nodes
    int edg;            //value of  no. of edge
	int vert[][];
	int count=1;
	int rip_x;  //variable to store input in RIP protocol
 	int rip_y;
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
    @Override                                   //Checking status of nodes and drawing them on panel 2
    public void paint(Graphics g) {
    	// TODO Auto-generated method stub
    	 int x_dis = screenSize.width/2;
    	 x_dis/=2;
    	super.paintComponents(g);
    	g.setColor(Color.GREEN);
    	if(v1)
    	{
    		g.drawOval(screenSize.width/2+x_dis, 100, 10, 10);
            g.fillOval(screenSize.width/2+x_dis, 100, 10, 10);
           // g.drawOval(screenSize.width/2+x_dis+50, 100, 20, 20);
//            g.drawChars('A',screenSize.width/2+x_dis+20, 100, 10, 10);
           // g.drawChars(arg0, arg1, arg2, arg3, arg4);
    	}
    	if(v2)
        {
    		g.drawOval(screenSize.width/2+x_dis-100, 200, 10, 10);
            g.fillOval(screenSize.width/2+x_dis-100, 200, 10, 10);
            //g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis-100, 200);
        }
    	if(v3)
        {
    		g.drawOval(screenSize.width/2+x_dis+100, 200, 10, 10);
            g.fillOval(screenSize.width/2+x_dis+100, 200, 10, 10);
        }
    	if(v4)
        {
    		g.drawOval(screenSize.width/2+x_dis-100, 300, 10, 10);
            g.fillOval(screenSize.width/2+x_dis-100, 300, 10, 10);
        }
    	if(v5)
        {
    		g.drawOval(screenSize.width/2+x_dis+100, 300, 10, 10);
            g.fillOval(screenSize.width/2+x_dis+100, 300, 10, 10);
        }
    	if(v6)
        {
    		g.drawOval(screenSize.width/2+x_dis, 400, 10, 10);
            g.fillOval(screenSize.width/2+x_dis, 400, 10, 10);
        }
    	if(ed[1][2]||ed[2][1])
    	{
    		g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis-100, 200);
//    		row[1][1]=String.valueOf(1);
//    	    row1[0][1]=String.valueOf(1);
    	}
    	if(ed[1][3]||ed[3][1])
    	{
    		g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis+100, 200);
//    		row[2][1]=String.valueOf(1);
//    	    row2[0][1]=String.valueOf(1);
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
    	/*if(ed1&&ed2)
    	{
    		g.drawLine(screenSize.width/2+x_dis, 100, screenSize.width/2+x_dis-100, 200);
    	}*/
    	
    	
    }
    MainActivity()
    {

       // node = new Integer("0");
       // Initialising objects for 3 panels
    	p2 = new JPanel();
        p3 = new JPanel(new FlowLayout());
     	
    	JMenuBar mb = new JMenuBar();  // Initialising menubar and their items
    	
    	
    	JMenu file = new JMenu("FILE");
    	JMenu protocol = new JMenu("PROTOCOL");
    	JMenu help  = new JMenu("HELP");
    	JMenu exit = new JMenu("EXIT");
    	JMenuItem rip = new JMenuItem("RIP");
    	JMenuItem bgp = new JMenuItem("BGP");
    	JMenuItem ospf = new JMenuItem("OSPF");
    	
    	JPanel p1 = new JPanel();
    	JLabel num_node = new JLabel("ENTER THE NUMBER OF NODES");//Creating interface for taking input in panel(p1)
    	JLabel num_node2 = new JLabel("ENTER THE NUMBER OF EDGES");
    	JLabel num_node3 = new JLabel("ENTER THE VALUE OF EDGES");
    	SpinnerModel n_num = new SpinnerNumberModel(0, 0, 6, 1);
    	SpinnerModel v_num = new SpinnerNumberModel(0, 0, 12, 1);
    	SpinnerModel x = new SpinnerNumberModel(0, 0, 6, 1);
    	SpinnerModel y = new SpinnerNumberModel(0, 0, 6, 1);
    	JSpinner spin = new JSpinner(n_num);
    	JSpinner spin2 = new JSpinner(v_num);
    	JSpinner xspin = new JSpinner(x);
    	JSpinner yspin = new JSpinner(y);
    	JButton  next = new JButton("NEXT");   //to draw the value of edges
    	JButton  reset = new JButton("RESET");
    	((JSpinner.DefaultEditor)spin.getEditor()).getTextField().setEditable(false);//Disabling spinner from getting edited
    	((JSpinner.DefaultEditor)spin2.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)xspin.getEditor()).getTextField().setEditable(false);
    	((JSpinner.DefaultEditor)yspin.getEditor()).getTextField().setEditable(false);
    	//spin.setLayout();
    	//num_node.setHorizontalAlignment(JLabel.CENTER);
    	//num_node.setSize(150,100);
    	//num_node.setBounds(0,0,50,50);
    	v_num.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
			    edg = (Integer)v_num.getValue();	  
			}
		});
    	n_num.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				 node =(Integer) n_num.getValue();              //Getting value of no. of nodes 
			//	System.out.println(node);
				 if(node==0)                           //Setting the visibility of nodes
					 
				 {
					 v1=false;
					 v2=false;
					 v3=false;
					 v4=false;
					 v5=false;
					 v6=false;
					 repaint();
				
				 }
				 else if(node==1)
				 
				 {
					 v1=true;
					 v2=false;
					 v3=false;
					 v4=false;
					 v5=false;
					 v6=false;
					 repaint();
				
				 }
			/*	 else
				 {
					 v1=false;
					 repaint();
				 }*/
				 else if(node==2)
				 {
					 v1=true;
					 v2=true;
					 v3=false;
					 v4=false;
					 v5=false;
					 v6=false;
					 repaint();
				 }
				/* else
				 {
					 v1=false;
					 v2=false;
					 repaint();
				 }*/
				 else if(node==3)
				 {
					 v1=true;
					 v2=true;
					 v3=true;
					 v4=false;
					 v5=false;
					 v6=false;
					 repaint();
				 }
				/* else
				 * 
				 * 
				 {
					 v1=false;
					 v2=false;
					 v3=false;
					 repaint();
				 }*/
				 else  if(node==4)
				 {
					 v1=true;
					 v2=true;
					 v3=true;
					 v4=true;
					 v5=false;
					 v6=false;
					 repaint();
				 }
				/* else
				 {
					 v1=false;
					 v2=false;
					 v3=false;
					 v4=false;
					 repaint();
				 }*/
				 if(node==5)
				 {
					 v1=true;
					 v2=true;
					 v3=true;
					 v4=true;
					 v5=true;
					 v6=false;
					 repaint();
				 }
				/* else
				 {
					 v1=false;
					 v2=false;
					 v3=false;
					 v4=false;
					 v5=false;
					 repaint();
				 }*/
				 else if(node==6)
				 {
					 v1=true;
					 v2=true;
					 v3=true;
					 v4=true;
					 v5=true;
					 v6=true;
					 repaint();
				 }
				/* else
				 {
					 v1=false;
					 v2=false;
					 v3=false;
					 v4=false;
					 v5=false;
					 v6=false;
					 repaint();
				 }*/
				 
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
			        ed[x_value][y_value]=true;
			        if(x_value==1)                                                             //Setting the values of initial routing table
			        {	
			        	row[y_value-1][1]=String.valueOf(1);
			        	row[y_value-1][2]=row[y_value-1][0];
			        	if(y_value==2) {row1[x_value-1][1]=String.valueOf(1);row1[x_value-1][2]=row1[x_value-1][0];}
			        	if(y_value==3) {row2[x_value-1][1]=String.valueOf(1);row2[x_value-1][2]=row2[x_value-1][0];}
			        	if(y_value==4) {row3[x_value-1][1]=String.valueOf(1);row3[x_value-1][2]=row3[x_value-1][0];}
			        	if(y_value==5) {row4[x_value-1][1]=String.valueOf(1);row4[x_value-1][2]=row4[x_value-1][0];}
			        	if(y_value==6) {row5[x_value-1][1]=String.valueOf(1);row5[x_value-1][2]=row5[x_value-1][0];}
			        }
			        if(x_value==2)
			        {	
			        	row1[y_value-1][1]=String.valueOf(1);row1[y_value-1][2]=row[y_value-1][0];
			        	if(y_value==1) {row[x_value-1][1]=String.valueOf(1);row[x_value-1][2]=row[x_value-1][0];}
			        	if(y_value==3) {row2[x_value-1][1]=String.valueOf(1);row2[x_value-1][2]=row2[x_value-1][0];}
			        	if(y_value==4) {row3[x_value-1][1]=String.valueOf(1);row3[x_value-1][2]=row3[x_value-1][0];}
			        	if(y_value==5) {row4[x_value-1][1]=String.valueOf(1);row4[x_value-1][2]=row4[x_value-1][0];}
			        	if(y_value==6) {row5[x_value-1][1]=String.valueOf(1);row5[x_value-1][2]=row5[x_value-1][0];}
			        }
			        if(x_value==3)
			        {	
			        	row2[y_value-1][1]=String.valueOf(1);row2[y_value-1][2]=row2[y_value-1][0];
			        	if(y_value==2) {row1[x_value-1][1]=String.valueOf(1);row1[x_value-1][2]=row1[x_value-1][0];}
			        	if(y_value==1) {row[x_value-1][1]=String.valueOf(1);row[x_value-1][2]=row[x_value-1][0];}
			        	if(y_value==4) {row3[x_value-1][1]=String.valueOf(1);row3[x_value-1][2]=row3[x_value-1][0];}
			        	if(y_value==5) {row4[x_value-1][1]=String.valueOf(1);row4[x_value-1][2]=row4[x_value-1][0];}
			        	if(y_value==6) {row5[x_value-1][1]=String.valueOf(1);row5[x_value-1][2]=row5[x_value-1][0];}
			        }
			        if(x_value==4)
			        	
			        	
			        	
			        {	
			        	row3[y_value-1][1]=String.valueOf(1);row3[y_value-1][2]=row3[y_value-1][0];
			        	if(y_value==2) {row1[x_value-1][1]=String.valueOf(1);row1[x_value-1][2]=row1[x_value-1][0];}
			        	if(y_value==3) {row2[x_value-1][1]=String.valueOf(1);row2[x_value-1][2]=row2[x_value-1][0];}
			        	if(y_value==1) {row[x_value-1][1]=String.valueOf(1);row[x_value-1][2]=row[x_value-1][0];}
			        	if(y_value==5) {row4[x_value-1][1]=String.valueOf(1);row4[x_value-1][2]=row4[x_value-1][0];}
			        	if(y_value==6) {row5[x_value-1][1]=String.valueOf(1);row5[x_value-1][2]=row5[x_value-1][0];}
			        }
			        if(x_value==5)
			        {	
			        	row4[y_value-1][1]=String.valueOf(1);row4[y_value-1][2]=row4[y_value-1][0];
			        	if(y_value==2) {row1[x_value-1][1]=String.valueOf(1);row1[x_value-1][2]=row1[x_value-1][0];}
			        	if(y_value==3) {row2[x_value-1][1]=String.valueOf(1);row2[x_value-1][2]=row2[x_value-1][0];}
			        	if(y_value==4) {row3[x_value-1][1]=String.valueOf(1);row3[x_value-1][2]=row1[x_value-1][0];}
			        	if(y_value==1) {row[x_value-1][1]=String.valueOf(1);row[x_value-1][2]=row[x_value-1][0];}
			        	if(y_value==6) {row5[x_value-1][1]=String.valueOf(1);row5[x_value-1][2]=row5[x_value-1][0];}
			        }
			        if(x_value==6)
			        {	
			        	row5[y_value-1][1]=String.valueOf(1);row5[y_value-1][2]=row5[y_value-1][0];
			        	if(y_value==2) {row1[x_value-1][1]=String.valueOf(1);row1[x_value-1][2]=row1[x_value-1][0];}
			        	if(y_value==3) {row2[x_value-1][1]=String.valueOf(1);row2[x_value-1][2]=row2[x_value-1][0];}
			        	if(y_value==4) {row3[x_value-1][1]=String.valueOf(1);row3[x_value-1][2]=row3[x_value-1][0];}
			        	if(y_value==5) {row4[x_value-1][1]=String.valueOf(1);row4[x_value-1][2]=row4[x_value-1][0];}
			        	if(y_value==1) {row[x_value-1][1]=String.valueOf(1);row[x_value-1][2]=row[x_value-1][0];}
			        }
			        repaint();
			        if(count==edg)
			        {
			        	xspin.setEnabled(false);
	                    yspin.setEnabled(false);
	                    next.setText("END");
			    	    next.setEnabled(false);
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
			   
			     v1 = false;          //to set the visibility for nodes on panel 2
			     v2 = false;
			     v3 = false;
			     v4 = false;
			     v5 = false;
			     v6 = false;
			     n_num.setValue(0);
			     v_num.setValue(0);
			     xspin.setValue(0);
			     yspin.setValue(0);
			    for(i=0;i<=6;i++) 
			    {
			    	for(j=0;j<=6;j++)
			    	{
			    		ed[i][j]=false;
			    	}
			    }
			    repaint();
			    next.setText("NEXT");
		    	next.setEnabled(true);
		    	count=1;	
		    	xspin.setEnabled(true);
		    	yspin.setEnabled(true);
		    	spin.setEnabled(true);
	    	    spin2.setEnabled(true);
			}
		});
        p1.setLayout(new GridBagLayout());                      //Setting layout in horizontal manner
    	GridBagConstraints gbc = new GridBagConstraints();
    	gbc.gridwidth = GridBagConstraints.REMAINDER;
    	gbc.fill = GridBagConstraints.HORIZONTAL;
        p1.add(num_node,gbc);
    	p1.add(spin,gbc);
    	p1.add(num_node2,gbc);
    	p1.add(spin2,gbc);
    	p1.add(num_node3,gbc);
    	p1.add(xspin,gbc);
    	p1.add(yspin,gbc);
        /*String NL = System.getProperty("line.separator");
    	p1.add(new Label(NL));
    	p1.add(new Label(NL));
    	next.setAlignmentX(CENTER_ALIGNMENT);*/
    	p1.add(next,gbc);
    	p1.add(reset,gbc);
    	
    	protocol.add(rip);protocol.add(bgp);protocol.add(ospf); // adding menuitems to protocol
    	mb.add(file); 
     	file.addSeparator();
     	mb.add(protocol);
     	protocol.addSeparator();
     	mb.add(help);
     	help.addSeparator();
    	mb.add(exit);
    	setJMenuBar(mb);
    	
    	                                                            //setting the size and position for all the three panels
    	p1.setBounds(0,0,screenSize.width/2, screenSize.height/2);
        p2.setBounds(screenSize.width/2,0, screenSize.width/2, screenSize.height/2);
        p2.setBackground(Color.BLACK);
        p3.setBounds(0,screenSize.height/2,screenSize.width,screenSize.height/2);
        p3.setBackground(Color.LIGHT_GRAY);
    	 
        add(p1);  //adding panels to Jframe
    	add(p2);
    	add(p3);
    	
    	//Adding routing tables to JFrame
    	//row[1][1]= String.valueOf(555);
		String col[] = {"Dest","Hop count","Next Hop"};
	     JTable tb = new JTable(row,col);
		JScrollPane jp = new JScrollPane(tb);
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
    
    	rip.addActionListener(new ActionListener() {   //Adding new window to for rip protocol
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			    
			/*	String row[][] = {{"1","a","A"},{"2","b","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"},{"3","c","B"}};
				String col[] = {"num","small","cap"};
			     JTable tb = new JTable(row,col);
				tb.setBounds(5,screenSize.height/2-100,screenSize.width/5,screenSize.height/2-100);
				JScrollPane jp = new JScrollPane(tb);
				p3.add(jp);*/
				
							
			    
			    
			    // Adding the components for RIP PROTOCOL FRAME
			    JFrame rip_cont = new JFrame("RIP PROTOCOL SIMULATOR");
			    //rip_cont.add(jp_a);
			    input1.setText(null);input2.setText(null);
				input1.setBounds(125, 50, 100, 30);
				input2.setBounds(125, 100, 100, 30);
				input1_label.setBounds(10,50,100,30);
				input2_label.setBounds(10,100,100,30);
				cal.setBounds(100, 200, 150, 30);
				cal.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						 rip_x = Integer.parseInt(input1.getText());     // To calculate the routing table after communicating with the specified routing table
						 rip_y = Integer.parseInt(input2.getText());
                         input1.setText(null);
                         input2.setText(null);
                        int val;
						if(rip_x==1)
						{
					
							if(rip_y==2) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row1[i][1])+Integer.parseInt(row[rip_y-1][1]))<(Integer.parseInt(row[i][1])))
									{
										val = Integer.parseInt(row1[i][1])+Integer.parseInt(row[rip_y-1][1]);
										row[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb.getModel().setValueAt(row[i][1], i,1 );
										tb.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==3) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row2[i][1])+Integer.parseInt(row[rip_y-1][1]))<(Integer.parseInt(row[i][1])))
									{
										val = Integer.parseInt(row2[i][1])+Integer.parseInt(row[rip_y-1][1]);
										row[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb.getModel().setValueAt(row[i][1], i,1 );
										tb.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==4) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row3[i][1])+Integer.parseInt(row[rip_y-1][1]))<(Integer.parseInt(row[i][1])))
									{
										val = Integer.parseInt(row3[i][1])+Integer.parseInt(row[rip_y-1][1]);
										row[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb.getModel().setValueAt(row[i][1], i,1 );
										tb.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==5) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row4[i][1])+Integer.parseInt(row[rip_y-1][1]))<(Integer.parseInt(row[i][1])))
									{
										val = Integer.parseInt(row4[i][1])+Integer.parseInt(row[rip_y-1][1]);
										row[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb.getModel().setValueAt(row[i][1], i,1 );
										tb.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==6) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row5[i][1])+Integer.parseInt(row[rip_y-1][1]))<(Integer.parseInt(row[i][1])))
									{
										val = Integer.parseInt(row5[i][1])+Integer.parseInt(row[rip_y-1][1]);
										row[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb.getModel().setValueAt(row[i][1], i,1 );
										tb.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
						}
						if(rip_x==2)
						{
					
							if(rip_y==1) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row[i][1])+Integer.parseInt(row1[rip_y-1][1]))<(Integer.parseInt(row1[i][1])))
									{
										val = Integer.parseInt(row[i][1])+Integer.parseInt(row1[rip_y-1][1]);
										row1[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb1.getModel().setValueAt(row1[i][1], i,1 );
										tb1.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==3) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row2[i][1])+Integer.parseInt(row1[rip_y-1][1]))<(Integer.parseInt(row1[i][1])))
									{
										val = Integer.parseInt(row2[i][1])+Integer.parseInt(row1[rip_y-1][1]);
										row1[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb1.getModel().setValueAt(row1[i][1], i,1 );
										tb1.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==4) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row3[i][1])+Integer.parseInt(row1[rip_y-1][1]))<(Integer.parseInt(row1[i][1])))
									{
										val = Integer.parseInt(row3[i][1])+Integer.parseInt(row1[rip_y-1][1]);
										row1[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb1.getModel().setValueAt(row1[i][1], i,1 );
										tb1.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==5) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row4[i][1])+Integer.parseInt(row1[rip_y-1][1]))<(Integer.parseInt(row1[i][1])))
									{
										val = Integer.parseInt(row4[i][1])+Integer.parseInt(row1[rip_y-1][1]);
										row1[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb1.getModel().setValueAt(row1[i][1], i,1 );
										tb1.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==6) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row5[i][1])+Integer.parseInt(row1[rip_y-1][1]))<(Integer.parseInt(row1[i][1])))
									{
										val = Integer.parseInt(row5[i][1])+Integer.parseInt(row1[rip_y-1][1]);
										row1[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb1.getModel().setValueAt(row1[i][1], i,1 );
										tb1.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
						
						}
						if(rip_x==3)
						{
					
							if(rip_y==1) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row[i][1])+Integer.parseInt(row2[rip_y-1][1]))<(Integer.parseInt(row2[i][1])))
									{
										val = Integer.parseInt(row[i][1])+Integer.parseInt(row2[rip_y-1][1]);
										row2[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb2.getModel().setValueAt(row2[i][1], i,1 );
										tb2.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==2) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row1[i][1])+Integer.parseInt(row2[rip_y-1][1]))<(Integer.parseInt(row2[i][1])))
									{
										val = Integer.parseInt(row1[i][1])+Integer.parseInt(row2[rip_y-1][1]);
										row2[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb2.getModel().setValueAt(row2[i][1], i,1 );
										tb2.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==4) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row3[i][1])+Integer.parseInt(row2[rip_y-1][1]))<(Integer.parseInt(row2[i][1])))
									{
										val = Integer.parseInt(row3[i][1])+Integer.parseInt(row2[rip_y-1][1]);
										row2[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb2.getModel().setValueAt(row2[i][1], i,1 );
										tb2.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==5) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row4[i][1])+Integer.parseInt(row2[rip_y-1][1]))<(Integer.parseInt(row2[i][1])))
									{
										val = Integer.parseInt(row4[i][1])+Integer.parseInt(row2[rip_y-1][1]);
										row2[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb2.getModel().setValueAt(row2[i][1], i,1 );
										tb2.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==6) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row5[i][1])+Integer.parseInt(row2[rip_y-1][1]))<(Integer.parseInt(row2[i][1])))
									{
										val = Integer.parseInt(row5[i][1])+Integer.parseInt(row2[rip_y-1][1]);
										row2[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb2.getModel().setValueAt(row2[i][1], i,1 );
										tb2.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
						}
						if(rip_x==4)
						{
					
							if(rip_y==1) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row[i][1])+Integer.parseInt(row3[rip_y-1][1]))<(Integer.parseInt(row3[i][1])))
									{
										val = Integer.parseInt(row[i][1])+Integer.parseInt(row3[rip_y-1][1]);
										row3[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb3.getModel().setValueAt(row3[i][1], i,1 );
										tb3.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==2) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row1[i][1])+Integer.parseInt(row3[rip_y-1][1]))<(Integer.parseInt(row3[i][1])))
									{
										val = Integer.parseInt(row1[i][1])+Integer.parseInt(row3[rip_y-1][1]);
										row3[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb3.getModel().setValueAt(row3[i][1], i,1 );
										tb3.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==3) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row2[i][1])+Integer.parseInt(row3[rip_y-1][1]))<(Integer.parseInt(row3[i][1])))
									{
										val = Integer.parseInt(row2[i][1])+Integer.parseInt(row3[rip_y-1][1]);
										row3[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb3.getModel().setValueAt(row3[i][1], i,1 );
										tb3.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==5) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row4[i][1])+Integer.parseInt(row3[rip_y-1][1]))<(Integer.parseInt(row3[i][1])))
									{
										val = Integer.parseInt(row4[i][1])+Integer.parseInt(row3[rip_y-1][1]);
										row3[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb3.getModel().setValueAt(row3[i][1], i,1 );
										tb3.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==6) 
							{
							   //input1.setText("hello");
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row5[i][1])+Integer.parseInt(row3[rip_y-1][1]))<(Integer.parseInt(row3[i][1])))
									{
//										System.out.println(row3[i][1]);
//										System.out.println(row5[i][1]);
										val = Integer.parseInt(row5[i][1])+Integer.parseInt(row3[rip_y-1][1]);
										/*System.out.println(val);*/
										row3[i][1]=String.valueOf(val);
									/*	System.out.println(row3[i][1]);*/
										tb3.getModel().setValueAt(row3[i][1], i,1 );
										tb3.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							
						}
						if(rip_x==5)
						{
					
							if(rip_y==1) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row[i][1])+Integer.parseInt(row4[rip_y-1][1]))<(Integer.parseInt(row4[i][1])))
									{
										val = Integer.parseInt(row[i][1])+Integer.parseInt(row4[rip_y-1][1]);
										row4[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb4.getModel().setValueAt(row4[i][1], i,1 );
										tb4.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==2) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row1[i][1])+Integer.parseInt(row4[rip_y-1][1]))<(Integer.parseInt(row4[i][1])))
									{
										val = Integer.parseInt(row1[i][1])+Integer.parseInt(row4[rip_y-1][1]);
										row4[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb4.getModel().setValueAt(row4[i][1], i,1 );
										tb4.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==3) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row2[i][1])+Integer.parseInt(row4[rip_y-1][1]))<(Integer.parseInt(row4[i][1])))
									{
										val = Integer.parseInt(row2[i][1])+Integer.parseInt(row4[rip_y-1][1]);
										row4[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb4.getModel().setValueAt(row4[i][1], i,1 );
										tb4.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==4) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row3[i][1])+Integer.parseInt(row4[rip_y-1][1]))<(Integer.parseInt(row4[i][1])))
									{
										val = Integer.parseInt(row3[i][1])+Integer.parseInt(row4[rip_y-1][1]);
										row4[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb4.getModel().setValueAt(row4[i][1], i,1 );
										tb4.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==6) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row5[i][1])+Integer.parseInt(row4[rip_y-1][1]))<(Integer.parseInt(row4[i][1])))
									{
										val = Integer.parseInt(row5[i][1])+Integer.parseInt(row4[rip_y-1][1]);
										row4[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb4.getModel().setValueAt(row4[i][1], i,1 );
										tb4.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
						}
						if(rip_x==6)
						{
					
							if(rip_y==1) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row[i][1])+Integer.parseInt(row5[rip_y-1][1]))<(Integer.parseInt(row5[i][1])))
									{
										val = Integer.parseInt(row[i][1])+Integer.parseInt(row5[rip_y-1][1]);
										row5[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb5.getModel().setValueAt(row5[i][1], i,1 );
										tb5.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==2) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row1[i][1])+Integer.parseInt(row5[rip_y-1][1]))<(Integer.parseInt(row5[i][1])))
									{
										val = Integer.parseInt(row1[i][1])+Integer.parseInt(row5[rip_y-1][1]);
										row5[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb5.getModel().setValueAt(row5[i][1], i,1 );
										tb5.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==3) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row2[i][1])+Integer.parseInt(row5[rip_y-1][1]))<(Integer.parseInt(row5[i][1])))
									{
										val = Integer.parseInt(row2[i][1])+Integer.parseInt(row5[rip_y-1][1]);
										row5[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb5.getModel().setValueAt(row5[i][1], i,1 );
										tb5.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==4) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row3[i][1])+Integer.parseInt(row5[rip_y-1][1]))<(Integer.parseInt(row5[i][1])))
									{
										val = Integer.parseInt(row3[i][1])+Integer.parseInt(row5[rip_y-1][1]);
										row5[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb5.getModel().setValueAt(row5[i][1], i,1 );
										tb5.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
							if(rip_y==5) 
							{
								for(i=0;i<5;i++)
								{
									if((i+1)==rip_x)
									{
										continue;
									}
									else
									{
									if((Integer.parseInt(row4[i][1])+Integer.parseInt(row5[rip_y-1][1]))<(Integer.parseInt(row5[i][1])))
									{
										val = Integer.parseInt(row4[i][1])+Integer.parseInt(row5[rip_y-1][1]);
										row5[i][1]=String.valueOf(val);
										//System.out.println(row[i][1]);
										tb5.getModel().setValueAt(row5[i][1], i,1 );
										tb5.getModel().setValueAt(String.valueOf(rip_y), i, 2);
									}
									}
								}
								
							}
						}
					}
				});
				fin.setBounds(100, 250, 150, 30);
				fin.addActionListener(new ActionListener() {          //Adding function to calculate the final RIP of the routing table
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						for(i=0;i<6;i++)
						{
							for(j=0;j<2;j++)
							{
								//System.out.println(row[i][j]);
								dup_row[0][i][j]=row[i][j];
								/*System.out.println(dup_row[0][i][j]);*/
							}
						}
						for(i=0;i<6;i++)
						{
							for(j=0;j<2;j++)
							{
								dup_row[1][i][j]=row1[i][j];
								/*System.out.println(dup_row[1][i][j]);*/
						}
						}
						for(i=0;i<6;i++)
						{
							for(j=0;j<2;j++)
							{
								dup_row[2][i][j]=row2[i][j];
								/*System.out.println(dup_row[2][i][j]);*/
							}
						}
						for(i=0;i<6;i++)
						{
							for(j=0;j<2;j++)
							{
								dup_row[3][i][j]=row3[i][j];
								/*System.out.println(dup_row[3][i][j]);*/
							}
						}
						for(i=0;i<6;i++)
						{
							for(j=0;j<2;j++)
							{
								dup_row[4][i][j]=row4[i][j];
								/*System.out.println(dup_row[4][i][j]);*/
							}
						}
						for(i=0;i<6;i++)
						{
							for(j=0;j<2;j++)
							{
								dup_row[5][i][j]=row5[i][j];
								//System.out.println(dup_row[5][i][j]);
							}
						}
						
						int val1=0;
						rip_x=1;	
						for(rip_y=1;rip_y<=6;rip_y++)
						{
							if(rip_y==rip_x)
							{
								continue;
							}
							else
							{
						for(i=0;i<6;i++)
						{
								
							if((i+1)==rip_x)
							{
								continue;
							}
							else
							{
								/*if(rip_y==6)
									{System.out.println("value:- "+dup_row[rip_y-1][i][1]+" "+dup_row[0][rip_y-1][1]+"compare to  :- "+dup_row[0][i][1]);}*/
							if((Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[0][rip_y-1][1]))<(Integer.parseInt(dup_row[0][i][1])))
							{
								
								
								val1 = Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[0][rip_y-1][1]);
								dup_row[0][i][1]=String.valueOf(val1);
								//System.out.println("value:- "+dup_row[0][i][1]);
								//System.out.println(row[i][1]);
								tb.getModel().setValueAt(dup_row[0][i][1], i,1 );
								tb.getModel().setValueAt(String.valueOf(rip_y), i, 2);
							}
							}
							}
						}
						}
							rip_x=2;
							for(rip_y=1;rip_y<=6;rip_y++)
							{
								if(rip_y==rip_x)
								{
									continue;
								}
								else
								{
								for(i=0;i<6;i++)
							{
								if((i+1)==rip_x)
								{
									continue;
								}
								else
								{
								if((Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[1][rip_y-1][1]))<(Integer.parseInt(dup_row[1][i][1])))
								{
									
									val1 = Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[1][rip_y-1][1]);
									dup_row[1][i][1]=String.valueOf(val1);
									//System.out.println(row[i][1]);
									tb1.getModel().setValueAt(dup_row[1][i][1], i,1 );
									tb1.getModel().setValueAt(String.valueOf(rip_y), i, 2);
								}
								}
							}
								}
							}
							rip_x=3;
							for(rip_y=1;rip_y<=6;rip_y++)
							{
								if(rip_y==rip_x)
								{
									continue;
								}
								else
								{
							for(i=0;i<6;i++)
							{
								if((i+1)==rip_x)
								{
									continue;
								}
								else
								{
								if((Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[2][rip_y-1][1]))<(Integer.parseInt(dup_row[2][i][1])))
								{
									
									val1 = Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[2][rip_y-1][1]);
									dup_row[2][i][1]=String.valueOf(val1);
									//System.out.println(row[i][1]);
									tb2.getModel().setValueAt(dup_row[2][i][1], i,1 );
									tb2.getModel().setValueAt(String.valueOf(rip_y), i, 2);
								}
								}
							}
								}
							}
							rip_x=4;
							for(rip_y=1;rip_y<=6;rip_y++)
							{
								if(rip_y==rip_x)
								{
									continue;
								}
								else
								{
							for(i=0;i<6;i++)
							{
								if((i+1)==rip_x)
								{
									continue;
								}
								else
								{
								if((Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[3][rip_y-1][1]))<(Integer.parseInt(dup_row[3][i][1])))
								{
									
									val1 = Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[3][rip_y-1][1]);
									dup_row[3][i][1]=String.valueOf(val1);
									//System.out.println(row[i][1]);
									tb3.getModel().setValueAt(dup_row[3][i][1], i,1 );
									tb3.getModel().setValueAt(String.valueOf(rip_y), i, 2);
								}
								}
							}
								}
							}
							rip_x=5;
							for(rip_y=1;rip_y<=6;rip_y++)
							{
							for(i=0;i<6;i++)
							{
								if(rip_y==rip_x)
								{
									continue;
								}
								else
								{
								if((i+1)==rip_x)
								{
									continue;
								}
								else
								{
								if((Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[4][rip_y-1][1]))<(Integer.parseInt(dup_row[4][i][1])))
								{
									
									val1 = Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[4][rip_y-1][1]);
									dup_row[4][i][1]=String.valueOf(val1);
									//System.out.println(row[i][1]);
									tb4.getModel().setValueAt(dup_row[4][i][1], i,1 );
									tb4.getModel().setValueAt(String.valueOf(rip_y), i, 2);
								}
								}
								}
							}
							}
							rip_x=6;
							for(rip_y=1;rip_y<=6;rip_y++)
							{
								if(rip_y==rip_x)
								{
									continue;
								}
								else
								{
							for(i=0;i<6;i++)
							{
								if((i+1)==rip_x)
								{
									continue;
								}
								else
								{
								if((Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[5][rip_y-1][1]))<(Integer.parseInt(dup_row[5][i][1])))
								{
								
									val1 = Integer.parseInt(dup_row[rip_y-1][i][1])+Integer.parseInt(dup_row[5][rip_y-1][1]);
									dup_row[5][i][1]=String.valueOf(val1);
									//System.out.println(row[i][1]);
									tb5.getModel().setValueAt(dup_row[5][i][1], i,1 );
									tb5.getModel().setValueAt(String.valueOf(rip_y), i, 2);
								}
								}
							}
								}
							}
					}
				});
				close.setBounds(100, 300, 150, 30);
				rip_cont.setLayout(null);
				close.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
                        tb.getModel().setValueAt(String.valueOf(999), 0, 1);
                        tb.getModel().setValueAt(String.valueOf(999), 1, 1);
                        tb.getModel().setValueAt(String.valueOf(999), 2, 1);
                        tb.getModel().setValueAt(String.valueOf(999), 3, 1);
                        tb.getModel().setValueAt(String.valueOf(999), 4, 1);
                        tb.getModel().setValueAt(String.valueOf(999), 5, 1);
                        tb1.getModel().setValueAt(String.valueOf(999), 0, 1);
                        tb1.getModel().setValueAt(String.valueOf(999), 1, 1);
                        tb1.getModel().setValueAt(String.valueOf(999), 2, 1);
                        tb1.getModel().setValueAt(String.valueOf(999), 3, 1);
                        tb1.getModel().setValueAt(String.valueOf(999), 4, 1);
                        tb1.getModel().setValueAt(String.valueOf(999), 5, 1);
                        tb2.getModel().setValueAt(String.valueOf(999), 0, 1);
                        tb2.getModel().setValueAt(String.valueOf(999), 1, 1);
                        tb2.getModel().setValueAt(String.valueOf(999), 2, 1);
                        tb2.getModel().setValueAt(String.valueOf(999), 3, 1);
                        tb2.getModel().setValueAt(String.valueOf(999), 4, 1);
                        tb2.getModel().setValueAt(String.valueOf(999), 5, 1);
                        tb3.getModel().setValueAt(String.valueOf(999), 0, 1);
                        tb3.getModel().setValueAt(String.valueOf(999), 1, 1);
                        tb3.getModel().setValueAt(String.valueOf(999), 2, 1);
                        tb3.getModel().setValueAt(String.valueOf(999), 3, 1);
                        tb3.getModel().setValueAt(String.valueOf(999), 4, 1);
                        tb3.getModel().setValueAt(String.valueOf(999), 5, 1);
                        tb4.getModel().setValueAt(String.valueOf(999), 0, 1);
                        tb4.getModel().setValueAt(String.valueOf(999), 1, 1);
                        tb4.getModel().setValueAt(String.valueOf(999), 2, 1);
                        tb4.getModel().setValueAt(String.valueOf(999), 3, 1);
                        tb4.getModel().setValueAt(String.valueOf(999), 4, 1);
                        tb4.getModel().setValueAt(String.valueOf(999), 5, 1);
                        tb5.getModel().setValueAt(String.valueOf(999), 0, 1);
                        tb5.getModel().setValueAt(String.valueOf(999), 1, 1);
                        tb5.getModel().setValueAt(String.valueOf(999), 2, 1);
                        tb5.getModel().setValueAt(String.valueOf(999), 3, 1);
                        tb5.getModel().setValueAt(String.valueOf(999), 4, 1);
                        tb5.getModel().setValueAt(String.valueOf(999), 5, 1);
                        tb.getModel().setValueAt(null, 0, 2); 
                        tb.getModel().setValueAt(null, 1, 2); 
                        tb.getModel().setValueAt(null, 2, 2); 
                        tb.getModel().setValueAt(null, 3, 2); 
                        tb.getModel().setValueAt(null, 4, 2); 
                        tb.getModel().setValueAt(null, 5, 2); 
                        tb1.getModel().setValueAt(null, 0, 2); 
                        tb1.getModel().setValueAt(null, 1, 2); 
                        tb1.getModel().setValueAt(null, 2, 2); 
                        tb1.getModel().setValueAt(null, 3, 2); 
                        tb1.getModel().setValueAt(null, 4, 2); 
                        tb1.getModel().setValueAt(null, 5, 2); 
                        tb2.getModel().setValueAt(null, 0, 2); 
                        tb2.getModel().setValueAt(null, 1, 2); 
                        tb2.getModel().setValueAt(null, 2, 2); 
                        tb2.getModel().setValueAt(null, 3, 2); 
                        tb2.getModel().setValueAt(null, 4, 2); 
                        tb2.getModel().setValueAt(null, 5, 2); 
                        tb3.getModel().setValueAt(null, 0, 2); 
                        tb3.getModel().setValueAt(null, 1, 2); 
                        tb3.getModel().setValueAt(null, 2, 2); 
                        tb3.getModel().setValueAt(null, 3, 2); 
                        tb3.getModel().setValueAt(null, 4, 2); 
                        tb3.getModel().setValueAt(null, 5, 2); 
                        tb4.getModel().setValueAt(null, 0, 2); 
                        tb4.getModel().setValueAt(null, 1, 2); 
                        tb4.getModel().setValueAt(null, 2, 2); 
                        tb4.getModel().setValueAt(null, 3, 2); 
                        tb4.getModel().setValueAt(null, 4, 2); 
                        tb4.getModel().setValueAt(null, 5, 2); 
                        tb5.getModel().setValueAt(null, 0, 2); 
                        tb5.getModel().setValueAt(null, 1, 2); 
                        tb5.getModel().setValueAt(null, 2, 2); 
                        tb5.getModel().setValueAt(null, 3, 2); 
                        tb5.getModel().setValueAt(null, 4, 2); 
                        tb5.getModel().setValueAt(null, 5, 2); 
                        p3.setVisible(false);
						rip_cont.dispose();
					
					}
				});
				//GridBagConstraints gbc = new GridBagConstraints();
			    rip_cont.setSize(400,500);
				rip_cont.setVisible(true);
				p3.setVisible(true);
				/*input1.setAlignmentX(CENTER_ALIGNMENT);
				input2.setAlignmentX(CENTER_ALIGNMENT);
				cal.setAlignmentX(CENTER_ALIGNMENT);
				fin.setAlignmentX(CENTER_ALIGNMENT);*/
				input1.setToolTipText("TARGET TABLE");
				input2.setToolTipText("REFRENCE TABLE");
				rip_cont.add(input1_label);
				rip_cont.add(input1);
				rip_cont.add(input2_label);
				rip_cont.add(input2);
				rip_cont.add(cal);
				rip_cont.add(fin);
				rip_cont.add(close);
				
			}
		});
    	
    	ospf.addActionListener(new ActionListener() {  //Adding new window for ospf protocol
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			 	JFrame ospf_cont = new JFrame();
				ospf_cont.setSize(400, 500);
				ospf_cont.setVisible(true);
			}
		});
    	
    	bgp.addActionListener(new ActionListener() {  //Adding new window for gbp protocol
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame bgp_cont = new JFrame();
				bgp_cont.setSize(400, 500);
				bgp_cont.setVisible(true);
				
			}
		});
         		
    }
     
    public static void main(String[] args) {
		new MainActivity();
	}
 
}
