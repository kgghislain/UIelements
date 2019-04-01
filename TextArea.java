import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

import java.awt.Color;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class TextArea extends JTextPane{

	private Thread colorUpdater;

	public TextArea(String text) {
		super();
		this.setText(text);
		//this.setLineWrap​(true);
		this.setSelectedTextColor(Color.YELLOW);
		this.setSelectionColor(Color.GREEN);
		this.setForeground(Color.BLUE);

		// CARET
		this.getCaret().setBlinkRate(30);
		this.setCaretColor(Color.RED);

		/*this.colorUpdater = new Thread(new Runnable() {
			public void run() { // mise a jour des couleurs du texte.

			}
		})

		this.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
				TextArea.this.colorUpdater.start();
			}
			public void focusLost(FocusEvent e) {
				TextArea.this.colorUpdater.wait();
			}
		});*/
	}
	public TextArea() {
		this("");
	}
}