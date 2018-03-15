package JeuKamaji;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Kamaji2 extends JPanel implements  ActionListener {
	 
	private int clicked ;
	private int numclick;
    public  ArrayList<JButton>Unselect;
   
    public ArrayList<JButton>Grille;
  
	JFrame obj = new JFrame();

	// Exemple de grille  :
	/*
	for(int i=0; i<9; i++) {
	JButton bouton = new JButton(""+i);
	Grille.add(bouton);
}
*/
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
	
	
	
	public Kamaji2() {	
		
		Unselect = new ArrayList<JButton>();
		clicked=0;
		numclick=0;
		obj.setBounds(10,10,700,600);
		obj.setTitle("Jeu Kamaji");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		Grille = new ArrayList<JButton>();

		
		Grille.add(case1);
		Grille.add(case2);
		Grille.add(case3);
		Grille.add(case4);
		Grille.add(case5);
		Grille.add(case6);
		Grille.add(case7);
		Grille.add(case8);
		Grille.add(case9);
		Grille.add(case10);
		Grille.add(case11);
		Grille.add(case12);
		Grille.add(case13);
		Grille.add(case14);
		Grille.add(case15);
		Grille.add(case16);
		Grille.add(case17);
		Grille.add(case18);
		Grille.add(case19);
		Grille.add(case20);
		Grille.add(case21);
		Grille.add(case22);
		Grille.add(case23);
		Grille.add(case24);
		
		case13.setForeground(Color.BLUE);				
		@SuppressWarnings("unused")
		
		JPanel panel = new JPanel(new GridLayout(5,5));

		// Boucle Componement 
		
		for (Component i; Grille.size();i++) {
		
			panel.add(i);
			
			//<Jbutton>i.addActionListener(this);
			
			
		}

		
		}
	



}