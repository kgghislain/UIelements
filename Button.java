import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;

public class Button extends JButton {

	private String title;
	private Color fontColor;
	private Color textColor;
	private Color borderColor;
	private static final int CHAR_SIZE = 10; // largeur et hauteur d'un caractère.

	public Button(String title, Color fontColor, Color textColor, Color borderColor) {
		super();
		this.title = title;
		this.fontColor = fontColor;
		this.textColor = textColor;
		this.borderColor = borderColor;

		this.setSize(100, 50);
	}
	public Button(String title, Color fontColor, Color textColor) {
		this(title, fontColor, textColor, Color.BLACK);
	}
	public Button(String title, Color fontColor) {
		this(title, fontColor, Color.WHITE);
	}
	public Button(String title) {
		this(title, Color.GRAY);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(fontColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(textColor);
		int titleSize = title.length();
		int x = (this.getWidth() - titleSize*CHAR_SIZE)/2;
		int y = (this.getHeight() - CHAR_SIZE)/2;
		g.drawString(title, x, y);

		g.setColor(this.borderColor);
		for(int i=0; i<4; i++) {
			g.drawRect(i, i, this.getWidth()-2*i, this.getHeight()-2*i);
		}
	}
}