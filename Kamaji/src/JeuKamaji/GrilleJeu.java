package JeuKamaji;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class GrilleJeu extends JPanel implements  ActionListener {
		 
	private int clicked ;
    public  ArrayList<JButton>Unselect;
    public  ArrayList<JButton>Selected;
    public  ArrayList<JButton>Arriere;
   
    
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
	JButton Verification = new JButton("Verification");
	JButton retour = new JButton("Retour");
	
	ArrayList<JButton> ALLBTN= new ArrayList<JButton>(); 



public GrilleJeu() {	
	
	Unselect = new ArrayList<JButton>();
	Selected = new ArrayList<JButton>();
	Arriere = new ArrayList<JButton>();
	ALLBTN= new ArrayList<JButton>();
	 
	clicked=0;
	obj.setBounds(40,40,300,300);
	obj.setTitle("Jeu Kamaji");
	obj.setResizable(false);
	obj.setLocationRelativeTo(null);
	obj.setVisible(true);
	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//La case du milieu
	
	case13.setForeground(Color.BLUE);
	
	
	
	
// Ajout des cases au Panel et de l'actionListener
	
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
	
	
	// 2	 eme JPanel avec les bouttons (Verification et retour)
	
	JPanel panel2 = new JPanel();
	panel2.add(Verification);
	Verification.addActionListener(this);
	
	panel2.add(retour);
	retour.addActionListener(this);

	
	obj.add(panel,BorderLayout.NORTH);
	obj.add(panel2,BorderLayout.SOUTH);
	
	panel.setBackground(Color.gray);
	
	obj.pack();

	// Table qui contient tout les cases de la grilles sauf les cases avec la valeur 1
	
	ALLBTN.add(case1);ALLBTN.add(case2);ALLBTN.add(case3);ALLBTN.add(case4);ALLBTN.add(case5);ALLBTN.add(case6);ALLBTN.add(case7);ALLBTN.add(case10);ALLBTN.add(case11);ALLBTN.add(case12);ALLBTN.add(case14);ALLBTN.add(case15);ALLBTN.add(case16);ALLBTN.add(case17);ALLBTN.add(case18);ALLBTN.add(case19);ALLBTN.add(case20);ALLBTN.add(case21);ALLBTN.add(case22);ALLBTN.add(case24);ALLBTN.add(case25);

	}
	
	/* verification case  executer apres click verification */
 	
	public  void  actionPerformed(ActionEvent e){		
		
		Object  source = e.getSource();	
		
		
		if (source==case1) {
			case1.setForeground(Color.ORANGE);
			clicked= Integer.parseInt(case1.getText());
			if (Integer.parseInt(case1.getText()) == 1) {
				case1.setForeground(Color.blue);
				
					}
			else {
				case1.setForeground(Color.ORANGE);}
				
				Unselect.add(case1);
		}
		
		if  (source==case2) {
			if (Integer.parseInt(case2.getText()) == 1) {
				case2.setForeground(Color.blue);
			}
			else {
		    case2.setForeground(Color.ORANGE);}
			
		    clicked+=Integer.parseInt(case2.getText());
			Unselect.add(case2);
		}
					
		 if  (source==case3) {
			 if (Integer.parseInt(case3.getText()) == 1) {
					case3.setForeground(Color.blue);
					}
				else {
			   case3.setForeground(Color.ORANGE);}
			clicked+=Integer.parseInt(case3.getText());
			Unselect.add(case3);
		 }
		 
		 if  (source==case4) {
			 if (Integer.parseInt(case4.getText()) == 1) {
					case4.setForeground(Color.blue);
					}
				else {
			   case4.setForeground(Color.ORANGE);}
		 clicked+=Integer.parseInt(case4.getText());
			Unselect.add(case4);
		 }
		 
		if  (source==case5) {
			if (Integer.parseInt(case5.getText()) == 1) {
			
				case5.setForeground(Color.blue);}
			else {
			 case5.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case5.getText());
			Unselect.add(case5);
		}
		
		if  (source==case6) {
			if (Integer.parseInt(case6.getText()) == 1) {
				case6.setForeground(Color.blue);}
			else {
			case6.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case6.getText());
			Unselect.add(case6);
		}
		
		if  (source==case7) {
			if (Integer.parseInt(case7.getText()) == 1) {
				case7.setForeground(Color.blue);
				}
			else {
		   case7.setForeground(Color.ORANGE);}
		 clicked+=Integer.parseInt(case7.getText());
			Unselect.add(case7);
		}
		
		if  (source==case8) {
			if (Integer.parseInt(case8.getText()) == 1) {
				case8.setForeground(Color.blue);
				}
			else {
		    case8.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case8.getText());
			Unselect.add(case8);
		}
		
		if  (source==case9) {
			if (Integer.parseInt(case9.getText()) == 1) {
				case9.setForeground(Color.blue);
				}
			else {
		    case9.setForeground(Color.ORANGE);}	
			clicked+=Integer.parseInt(case9.getText());

			Unselect.add(case9);
		}
		
		if  (source==case10) {
			if (Integer.parseInt(case10.getText()) == 1) {
				case10.setForeground(Color.blue);
				}
			else {
		   case10.setForeground(Color.ORANGE);}		
			
			clicked+=Integer.parseInt(case10.getText());
			Unselect.add(case10);
		}
		
		if  (source==case11) {
			if (Integer.parseInt(case11.getText()) == 1) {
				case11.setForeground(Color.blue);
				}
			else {
		   case11.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case11.getText());
			Unselect.add(case11);
		}
		
		if  (source==case12) {
			if (Integer.parseInt(case12.getText()) == 1) {
				case12.setForeground(Color.blue);
				}
			else {
		   case12.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case12.getText());
			Unselect.add(case12);
		}
		
		if  (source==case14) {
			if (Integer.parseInt(case14.getText()) == 1) {
				case14.setForeground(Color.blue);
				}
			else {
		   case14.setForeground(Color.ORANGE);}		
			clicked+=Integer.parseInt(case14.getText());
			Unselect.add(case14);
		}
		
		if  (source==case15) {
			if (Integer.parseInt(case15.getText()) == 1) {
				case15.setForeground(Color.blue);
				}
			else {
		   case15.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case15.getText());
			Unselect.add(case15);
		}
		
		 if  (source==case16) {
			 if (Integer.parseInt(case16.getText()) == 1) {
					case16.setForeground(Color.blue);
					}
				else {
			   case16.setForeground(Color.ORANGE);}		 
			 clicked+=Integer.parseInt(case16.getText());
			Unselect.add(case16);
		 }
		 
		if  (source==case17) {
			if (Integer.parseInt(case17.getText()) == 1) {
				case17.setForeground(Color.blue);
				}
			else {
		   case17.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case17.getText());
			Unselect.add(case17);
		}
		
		 if  (source==case18) {
			 if (Integer.parseInt(case18.getText()) == 1) {
					case18.setForeground(Color.blue);
					}
				else {
			   case18.setForeground(Color.ORANGE);}		 
			 clicked+=Integer.parseInt(case18.getText());
			Unselect.add(case18);
			
		 }
		if  (source==case19) {
			if (Integer.parseInt(case19.getText()) == 1) {
				case19.setForeground(Color.blue);
				}
			else {
		   case19.setForeground(Color.ORANGE);}		
			clicked+=Integer.parseInt(case19.getText());
			Unselect.add(case19);

		}
		 if  (source==case20) {
			 if (Integer.parseInt(case20.getText()) == 1) {
					case20.setForeground(Color.blue);
					}
				else {
			   case20.setForeground(Color.ORANGE);}		
			 clicked+=Integer.parseInt(case20.getText());
			Unselect.add(case20);

		 }
		if  (source==case21) {
			if (Integer.parseInt(case21.getText()) == 1) {
				case21.setForeground(Color.blue);
				}
			else {
		   case21.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case21.getText());
			Unselect.add(case21);

		}
		if  (source==case22) {
			if (Integer.parseInt(case22.getText()) == 1) {
				case22.setForeground(Color.blue);
				}
			else {
		   case22.setForeground(Color.ORANGE);}		
			clicked+=Integer.parseInt(case22.getText());
			Unselect.add(case22);

		}
		if  (source==case23) {
			if (Integer.parseInt(case23.getText()) == 1) {
				case23.setForeground(Color.blue);
				}
			else {
		   case23.setForeground(Color.ORANGE);}		
			clicked+=Integer.parseInt(case23.getText());
		 Unselect.add(case23);

		}
		if  (source==case24){
			if (Integer.parseInt(case24.getText()) == 1) {
				case24.setForeground(Color.blue);
				}
			else {
		   case24.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case24.getText());
			Unselect.add(case24);

		}
		if  (source==case25) {
			if (Integer.parseInt(case25.getText()) == 1) {
				case25.setForeground(Color.blue);
				}
			else {
		   case25.setForeground(Color.ORANGE);}		 
			clicked+=Integer.parseInt(case25.getText());
			Unselect.add(case25);
		}	
		
		if (source==retour) {
			retourArriere();
		}
		if (source==Verification) {
			ClickVerification();
						
}					
		}
			
	public void ClickVerification(){
		Arriere.clear();

		if (clicked !=5) {
		JOptionPane.showMessageDialog(this,
	    "La somme des cases choisies est differente de 5",
	    "Inane error",
	    JOptionPane.ERROR_MESSAGE);				
		
		for (JButton button : Unselect)
		    button.setForeground(Color.black);
		}
		else { 	
			if (clicked == 5) {
				JOptionPane.showMessageDialog(this,
						"bien joué !");} 
	      
			
			// Garder les bouttons (1) active
			
			for (JButton button : Unselect) {
					if (Integer.parseInt(button.getText()) != 1) {					
							button.setEnabled(false); 															
					}
					else {					
					button.setEnabled(true); 
					}
			}
		}
			clicked=0;
			Arriere.addAll(Unselect);
			Unselect.clear();
		
		if (ALLCHECKED()==true) {
				JOptionPane.showMessageDialog(this,
					" Bravo. Vous avez réussi à résoudre la grille !");} 		
	
	}
	
	// TEST FINAL ALL checked
	
	public  boolean ALLCHECKED() { 
		int nbr =0;
		for (JButton btn : ALLBTN) {
			if (Integer.parseInt(btn.getText()) != 1) {
			if (btn.isEnabled()==false) {
				nbr=nbr+1;	
			}						
		}}
			if (nbr==ALLBTN.size()) {
			return true;
			}
			else {
				return false;
			}		
	}
	
	// Button retour

	public void retourArriere() {	
		
		for (JButton button : Arriere)
			button.setEnabled(true);

		for (JButton button : Arriere)
			button.setForeground(Color.BLACK);		
			Arriere.clear();
	}

	
	
	
	

}	


















		

	

		

















   
	

		




