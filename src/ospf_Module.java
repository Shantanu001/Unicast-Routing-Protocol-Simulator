
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class ospf_Module {
	//initialising variables
			int ospf_source;
			JButton cal_Ospf;
			JButton close_Ospf ;
			JTextField input1_Ospf; 
			JLabel label1_Ospf;
			MainActivity main_obj = new MainActivity();
			String ospf_col[] = {"Source","Destination","Neighbour"};
	ospf_Module()
	{
		
		
		//Creating Frame for ospf handler
		JFrame ospf_cont = new JFrame();
		ospf_cont.setSize(400,400);
		
		//Creating Jcomponents for ospf handler
		label1_Ospf = new JLabel("Enter the source");
	    input1_Ospf = new JTextField();
		cal_Ospf  = new JButton ("CALCULATE");
		close_Ospf  = new JButton ("CLOSE");
		
				
		
		//Setting the layout for the Ospf Frame
		//JPanel panel1_Ospf = new JPanel();
		label1_Ospf.setBounds(150, 50, 100, 30);
		ospf_cont.add(label1_Ospf);
		input1_Ospf.setBounds(150, 100, 100, 30);
		ospf_cont.add(input1_Ospf);
		cal_Ospf.setBounds(125, 200, 150, 30);
		ospf_cont.add(close_Ospf);
		close_Ospf.setBounds(125, 250, 150, 30);
		ospf_cont.add(cal_Ospf);
		ospf_cont.setLayout(null);
		ospf_cont.setVisible(true);
		
	    //adding function to calulate button
		cal_Ospf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		     		ospf_source = Integer.parseInt(input1_Ospf.getText());
		   
		     	
		     		
			}
		});
	}
     
	public static void main(String args[])
	{
	      ospf_Module obj = new ospf_Module();
	      MainActivity main_obj = new MainActivity();
	}
}
