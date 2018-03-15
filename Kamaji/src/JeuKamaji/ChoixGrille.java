package JeuKamaji;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChoixGrille extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JFrame grille = new JFrame();
	
	JLabel LBL1= new JLabel("Veuillez choisir une grille :");

	JLabel Grille5= new JLabel("Grille (5/5) :");
	JButton Grille1= new JButton("5/5");
	
	JLabel Grille7= new JLabel("Grille (7/7) :");
	JButton Grille2= new JButton("7/7");
	
	JLabel Grille8= new JLabel("Grille (8/8) :");
	JButton Grille3= new JButton("8/8");


public ChoixGrille() {
	
	grille.setBounds(40,40,300,300);
	grille.setTitle("Jeu Kamaji");
	grille.setResizable(false);
	grille.setLocationRelativeTo(null);
	grille.setVisible(true);
	grille.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    grille.setPreferredSize(new Dimension(300,200));

    JPanel PN1 = new JPanel();
	PN1.add(LBL1);

    	  
	JPanel PN = new JPanel(new GridLayout(3,2));
	PN.add(Grille5);
	PN.add(Grille1);
	Grille1.addActionListener(this);

	PN.add(Grille7);
	PN.add(Grille2);
	Grille2.addActionListener(this);

	PN.add(Grille8);
	PN.add(Grille3);
	Grille3.addActionListener(this);

	
	grille.add(PN1,BorderLayout.NORTH);  
	grille.add(PN,BorderLayout.SOUTH);  
	
	PN.setBackground(Color.PINK);


	grille.pack();

}
	
public  void  actionPerformed(ActionEvent e){			
	Object  source = e.getSource();	
	 
	if (source==Grille1) {
		
		GrilleJeu s = new GrilleJeu();
		 s.setVisible(true);
		 grille.dispose();
	
	}
	
	if (source==Grille2) {
		
		
	}
	
	if (source==Grille3) {
		
	
	}
	
	
	
	
	
	
}











}
