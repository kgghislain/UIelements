import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;

public class Button extends JButton {

	private String title; // libele du bouton
	private Color fontColor; // Couleur de fond du bouton 
	private Color textColor; // couleur de texte du bouton
	private Color borderColor; // couleur de bordure du bouton
	private static final int CHAR_SIZE = 10; // largeur et hauteur d'un caractère.

	// LES CONSTRUCTEURS
	public Button(String title, Color fontColor, Color textColor, Color borderColor) {
		super();
		this.title = title;
		this.fontColor = fontColor;
		this.textColor = textColor;
		this.borderColor = borderColor;

		this.setSize(100, 50);
	}
	public Button(String title, Color fontColor, Color textColor) { this(title, fontColor, textColor, Color.BLACK); }
	public Button(String title, Color fontColor) { this(title, fontColor, Color.WHITE); }
	public Button(String title) { this(title, Color.GRAY); }
	public Button() { this("", Color.GRAY); }

	// Methode pour dessiner l'affichage du bouton.
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(fontColor); // On fixe la couleur de fond.
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); // On remplis le fond.

		g.setColor(textColor); // On fixe la couleur de texte.
		int titleSize = title.length(); // On recupere le nombre de caracteres du libele du bouton.
		int x = (this.getWidth() - titleSize*CHAR_SIZE)/2; // On calcul l'abscisse du texte
		int y = (this.getHeight() - CHAR_SIZE)/2; // On calcule l'ordonnee du texte
		g.drawString(title, x, y); // On ecrit le texte. 

		g.setColor(this.borderColor); // On fixe la couleur de fond
		for(int i=0; i<4; i++) { // On dessine 4 carres tout autour des bordures du bouton.
			g.drawRect(i, i, this.getWidth()-2*i, this.getHeight()-2*i); // dessin d'un carre.
		}
	}
}