package fr.univ.amu.Mahdi;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class GrilleJeu extends JPanel implements  ActionListener {
	
	private LesGrilles LesGrilleJeu = new LesGrilles();
	private ChoixGrille Choix = new ChoixGrille();
	int ChoixDeLaGrille = Choix.choix;
	
	private int clicked ;
    public  ArrayList<JButton>Unselect;
    public  ArrayList<JButton>Selected;
    public  ArrayList<JButton>Arriere;    
	public ArrayList<JButton> ALLBTN;
	public JLabel lbl;
	
	ArrayList<JButton>GRILLE5=new ArrayList<JButton>();
	ArrayList<JButton>GRILLE7=new ArrayList<JButton>();
	ArrayList<JButton>GRILLE8=new ArrayList<JButton>();
	public JButton RetourChoix;
	public int TestVerif;

	JFrame obj;
	JButton Verification = new JButton("Verification");
	JButton retour = new JButton("Retour");
	
	String choix;
	
	public GrilleJeu(int test) {		

	RetourChoix = new JButton("Choix grille");
	Unselect = new ArrayList<JButton>();
	Selected = new ArrayList<JButton>();
	Arriere = new ArrayList<JButton>();
	ALLBTN= new ArrayList<JButton>();

	GRILLE5.addAll(LesGrilleJeu.getGrille5());
	GRILLE7.addAll(LesGrilleJeu.getGrille7());
	GRILLE8.addAll(LesGrilleJeu.getGrille8());


	JFrame obj = new JFrame();

	clicked=0;
	obj.setBounds(40,40,300,300);
	obj.setTitle("Jeu Kamaji");
	obj.setResizable(false);
	obj.setLocationRelativeTo(null);
	obj.setVisible(true);
	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	JPanel panel2 = new JPanel();

	panel2.add(RetourChoix);
	RetourChoix.addActionListener(this);
	panel2.add(Verification);
	Verification.addActionListener(this);
	panel2.add(retour);
	retour.addActionListener(this);
	obj.add(panel2,BorderLayout.SOUTH);

	 if (test == 5) {
	 ALLBTN.addAll(GRILLE5);
	 TestVerif=5;
		JPanel panel = new JPanel(new GridLayout(5,5));
		for(JButton btn : ALLBTN) {
			 if (btn.getText()=="5") {
				 btn.setForeground(Color.BLUE);		 
			 }
			panel.add(btn);
			btn.addActionListener(this);

		}
	
		obj.add(panel,BorderLayout.NORTH);	
		panel.setBackground(Color.gray);
		obj.pack();

		 }
	 
	 if (test == 7) {
		 ALLBTN.addAll(GRILLE7);
		 TestVerif=7;
			JPanel panel = new JPanel(new GridLayout(7,7));
			for(JButton btn : ALLBTN) {
				if (btn.getText()=="7") {
					 btn.setForeground(Color.BLUE);		 
				 }
				panel.add(btn);
				btn.addActionListener(this);
			}
		
			obj.add(panel,BorderLayout.NORTH);	
			panel.setBackground(Color.gray);
			obj.pack();
		 
			 }
	 
	 if (test == 8) {
		 ALLBTN.addAll(GRILLE8);
		 TestVerif=8;
		 	JPanel panel = new JPanel(new GridLayout(8,8));
			for(JButton btn : ALLBTN) {
				if (btn.getText()=="8") {
					 btn.setForeground(Color.BLUE);		 
				 }
				panel.add(btn);
				btn.addActionListener(this);
			}
		
			obj.add(panel,BorderLayout.NORTH);	
			panel.setBackground(Color.gray);
			obj.pack();
		 
			 }
	}
	//case13.setForeground(Color.BLUE);
	
		//if (Choix.choix=="5") {	
		//	System.out.println(ChoixDeLaGrille);
		//}
	
	public  void  actionPerformed(ActionEvent e){		
	
	Object  source = e.getSource();		
	for (JButton btn : ALLBTN) {		
		if (source==btn) {
				btn.setForeground(Color.ORANGE);
				clicked+= Integer.parseInt(btn.getText());
				if (Integer.parseInt(btn.getText()) == 1) {
				btn.setForeground(Color.blue);
				}
				Unselect.add(btn);
			}
		}			
		
		if (source==retour) {
			retourArriere();
		}
		if (source==Verification) {
			ClickVerification();
		}			
		if (source==RetourChoix) {
			
			ChoixGrille c = new ChoixGrille();
			 obj.dispose();
			 obj.setVisible(false);			
			 c.setVisible(true);			

		}
		}
			
public void ClickVerification(){
			
		
		if (clicked !=TestVerif) {
			JOptionPane.showMessageDialog(this,"La somme des cases choisies est differente de 5","Inane error",JOptionPane.ERROR_MESSAGE);					
			for (JButton button : Unselect)
				button.setForeground(Color.black);
		}
		else { 	
			if (clicked == TestVerif) {
				JOptionPane.showMessageDialog(this,"bien joué !");
				clicked=0;
			} 
	      			
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
				
		int i, j;
		int k = Arriere.size()-1;
		int resultat =0;
		for (i=Arriere.size()-1;i>=0;i--){
		resultat+= Integer.parseInt(Arriere.get(i).getText());
		if (resultat==5) {	
			for(j = i; j <= k; j++) {
			Arriere.get(i).setEnabled(true);
			Arriere.get(i).setForeground(Color.BLACK);		

			Arriere.remove(i);
			}
		
		}
			
		}
		
	
	}
}	









		

	

		

















   
	

		




