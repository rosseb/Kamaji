/*package JeuKamaji;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GrilleJeu extends JPanel implements  ActionListener {
	private int clicked ;
	private int numclick;
	JFrame obj = new JFrame();
	 
	JButton case1 = new JButton("3");	 
	JButton case2 = new JButton("3");
	JButton case3 = new JButton("2");
	JButton case4 = new JButton("2");
	JButton case5 = new JButton("4");
	JButton case6 = new JButton("3"); 
	JButton case7 = new JButton("2");
	JButton case8 = new JButton("1");
	JButton case9 = new JButton("1");
	JButton case10 = new JButton("3");
	JButton case11 = new JButton("3");
	JButton case12 = new JButton("2");
	JButton case13 = new JButton("5");
	JButton case14 = new JButton("2");
	JButton case15 = new JButton("4");
	JButton case16 = new JButton("3");
	JButton case17 = new JButton("2");
	JButton case18 = new JButton("2");
	JButton case19 = new JButton("4");
	JButton case20 = new JButton("2");
	JButton case21 = new JButton("2");
	JButton case22 = new JButton("4");
	JButton case23 = new JButton("1");
	JButton case24 = new JButton("3");
	JButton case25 = new JButton("3");
	
	
public GrilleJeu() {	
	
	
	 clicked=0;
	 numclick=0;
	obj.setBounds(10,10,700,600);
	obj.setTitle("Jeu Kamaji");
	obj.setResizable(false);
	obj.setVisible(true);
	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	case13.setForeground(Color.BLUE);
	
			
	JPanel panel = new JPanel(new GridLayout(5,5));

	panel.add(case1);
	case1.addActionListener(this);
	
	panel.add(case2);
	case2.addActionListener(this);
	
	panel.add(case3);
	case3.addActionListener(this);
	
	panel.add(case4);
	case4.addActionListener(this);
	
	panel.add(case5);
	case5.addActionListener(this);
	
	panel.add(case6);
	case6.addActionListener(this);
	
	panel.add(case7);
	case7.addActionListener(this);
	
	panel.add(case8);
	case8.addActionListener(this);
	
	panel.add(case9);
	case9.addActionListener(this);
	
	panel.add(case10);
	case10.addActionListener(this);
	
	panel.add(case11);
	case11.addActionListener(this);
	
	panel.add(case12);
	case12.addActionListener(this);
	
	panel.add(case13);
	case13.addActionListener(this);
	
	panel.add(case14);
	case14.addActionListener(this);
	
	panel.add(case15);
	case15.addActionListener(this);
	
	panel.add(case16);
	case16.addActionListener(this);
	
	panel.add(case17);
	case17.addActionListener(this);
	
	panel.add(case18);
	case18.addActionListener(this);
	
	panel.add(case19);
	case19.addActionListener(this);
	
	panel.add(case20);
	case20.addActionListener(this);
	
	panel.add(case21);
	case21.addActionListener(this);
	
	panel.add(case22);
	case22.addActionListener(this);
	
	panel.add(case23);
	case23.addActionListener(this);
	
	panel.add(case24);
	case24.addActionListener(this);

	panel.add(case25);
	case25.addActionListener(this);
	
	obj.add(panel,BorderLayout.NORTH);
	obj.pack();
}
	
	public  void  actionPerformed(ActionEvent e)
    {
		
		
        Object  source=e.getSource();
        
		if (source==case1) {
			case1.setForeground(Color.ORANGE);
			clicked= Integer.parseInt(case1.getText());
			numclick+=1;
			
			}
		
		if  (source==case2) {
		   case2.setForeground(Color.ORANGE);
		   clicked+=Integer.parseInt(case2.getText());
			numclick+=1;

	}
		
		
			
		 if  (source==case3) {
			   case3.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case3.getText());
			numclick+=1;
			
		

		 }
		 if  (source==case4) {
			   case4.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case4.getText());
			numclick+=1;


		 }
		if  (source==case5) {
			   case5.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case5.getText());
		 numclick+=1;
		

		}
		if  (source==case6) {
			   case6.setForeground(Color.ORANGE);		
		 clicked+=Integer.parseInt(case6.getText());
		 numclick+=1;
			


		}
		if  (source==case7) {
			   case7.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case7.getText());
		 numclick+=1;
			

		}
		if  (source==case8) {
			   case8.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case8.getText());
		 numclick+=1;
			

		}
		if  (source==case9) {
			   case9.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case9.getText());
		 numclick+=1;

		}
		if  (source==case10) {
			   case10.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case10.getText());
		 numclick+=1;

		}
		if  (source==case11) {
			   case11.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case11.getText());
		 numclick+=1;

		}
		if  (source==case12) {
			   case12.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case12.getText());
		 numclick+=1;

		}
		if  (source==case14) {
			   case14.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case14.getText());
		 numclick+=1;

		}
		if  (source==case15) {
			   case15.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case15.getText());
		 numclick+=1;

		}
		 if  (source==case16) {
			   case16.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case16.getText());
		 numclick+=1;

		 }
		if  (source==case17) {
			   case17.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case17.getText());
		 numclick+=1;

    }
		 if  (source==case18) {
			   case18.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case18.getText());
		 numclick+=1;

		 }
		if  (source==case19) {
			   case19.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case19.getText());
		 numclick+=1;

		}
		 if  (source==case20) {
			   case20.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case20.getText());
		 numclick+=1;

		 }
		if  (source==case21) {
			   case21.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case21.getText());
		 numclick+=1;

		}
		if  (source==case22) {
			   case22.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case22.getText());
		 numclick+=1;

		}
		if  (source==case23) {
			   case23.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case23.getText());
		 numclick+=1;

		}
		if  (source==case24){
			   case24.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case24.getText());
		 numclick+=1;

		}
		if  (source==case25) {
			   case25.setForeground(Color.ORANGE);
		 clicked+=Integer.parseInt(case25.getText());
		 numclick+=1;

		}
	
	 if (numclick == 3) {
		if (clicked !=5) {
			JOptionPane.showMessageDialog(this,
				    "La somme des cases choisies est differente de 5",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);}
			
		else{
			
			if(clicked == 5) {
				JOptionPane.showMessageDialog(this,
					    "bien joué",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE); }
	
	}
	 if (numclick > 3) {
		JOptionPane.showMessageDialog(this,
			    "Vous pouvez pas choisir plus que 3 case !");
			    
		
			
		}}};
		
		
		}
		

	

	
*/

