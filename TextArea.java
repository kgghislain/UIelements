import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class TextArea extends JTextPane {

	private Style instructionStyle;
	private Style argumentStyle;
	private Style addressingModeStyle;
	private Style standardStyle;

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
		
		this.instructionStyle = this.addStyle("code 1", null);  // On y rajoute un style (qui est retourné par la methode).
		StyleConstants.setForeground(this.instructionStyle, Color.ORANGE);
		this.argumentStyle = this.addStyle("code 1", null);  // On y rajoute un style (qui est retourné par la methode).
		StyleConstants.setForeground(this.argumentStyle, Color.BLUE);
		this.addressingModeStyle = this.addStyle("code 1", null);  // On y rajoute un style (qui est retourné par la methode).
		StyleConstants.setForeground(this.addressingModeStyle, Color.GREEN);
		this.standardStyle = this.addStyle("code 1", null);  // On y rajoute un style (qui est retourné par la methode).
		StyleConstants.setForeground(this.standardStyle, Color.BLACK);

		this.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				System.out.println("ffffffffffffffffff");
				TextArea.this.setDocument(getColoredDoc());
			}
			public void focusLost(FocusEvent event) {
				System.out.println("tttttttttttttttttt");
				TextArea.this.setDocument(getColoredDoc());
			}
		});
	}
	public TextArea() {
		this("");
	}

	private StyledDocument getColoredDoc() {
		StyledDocument res = (new JTextPane()).getStyledDocument();
		StyledDocument doc = this.getStyledDocument();
		try {
			String text = doc.getText(0, doc.getLength());
			String[] mots = text.split(" ");
			for(int i =0; i<mots.length; i++) {
				Style style;
				if(mots[i].equals("MOV")) {
					style = TextArea.this.instructionStyle;
				}
				else {
					style = TextArea.this.standardStyle;
				}
				res.insertString(res.getLength(), " "+mots[i], style);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
}