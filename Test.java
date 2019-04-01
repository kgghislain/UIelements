import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.Color;

public class Test {
	public static void main(String[] args) {
		// Creation de la fenetre.
		JFrame fenetre = new JFrame("Fenetre de test");

		// Creation de composants.
		Button button1 = new Button("Bouton sans couleur ");
		Button button2 = new Button("Bouton rouge", Color.RED);
		Button button3 = new Button("Bouton bleu", Color.BLUE, Color.WHITE);
		Button button4 = new Button("Bouton vert", Color.GREEN, Color.BLACK, Color.YELLOW);
		TextArea textArea = new TextArea("Vide");

		// ajout des composants a la fenetre.
		fenetre.setLayout(new GridLayout(5, 1));
		fenetre.getContentPane().add(textArea);
		fenetre.getContentPane().add(button1);
		fenetre.getContentPane().add(button2);
		fenetre.getContentPane().add(button3);
		fenetre.getContentPane().add(button4);

		// Caractéristiques de la fenetre.
		fenetre.setResizable(false);
		fenetre.setSize(500, 500);
		fenetre.setVisible(true);
	}
}