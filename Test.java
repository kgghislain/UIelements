import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Color;

public class Test {
	public static void main(String[] args) {
		// Creation de la fenetre.
		JFrame fenetre = new JFrame("Fenetre de test");

		// Creation de la zone de texte
		Color[] colors = new Color[5];
		String[] keyWords = new String[5];
		colors[0] = Color.RED;
		keyWords[0] = "MOV ";
		colors[1] = Color.RED;
		keyWords[1] = "JMP ";
		colors[2] = Color.RED;
		keyWords[2] = "ADD ";
		colors[3] = Color.YELLOW;
		keyWords[3] = " @";
		colors[4] = Color.YELLOW;
		keyWords[4] = " #";

		TextArea textArea = new TextArea("", colors, keyWords);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(textArea);

		// Creation des boutons.
		Button button1 = new Button("Bouton sans couleur ");
		Button button2 = new Button("Bouton rouge", Color.RED);
		Button button3 = new Button("Bouton bleu", Color.BLUE, Color.WHITE);
		Button button4 = new Button("Bouton vert", Color.GREEN, Color.BLACK, Color.YELLOW);

		// ajout des composants a la fenetre.
		fenetre.setLayout(new GridLayout(5, 1));
		fenetre.getContentPane().add(scrollPane);
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