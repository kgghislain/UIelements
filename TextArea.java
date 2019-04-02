import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;

import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import javax.swing.text.BadLocationException;


import java.awt.Color;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class TextArea extends JTextPane {

	private Style instructionStyle;
	private Style argumentStyle;
	private Style addressingModeStyle;
	private Style standardStyle;

	private StyledDocument doc;

	private Style[] styles;
	private String[] keyWords;

	public TextArea(String text, Color[] colors, String[] keyWords) {
		super();

		// On fixe les attributs passes en parametre.
		this.setText(text);
		this.keyWords = keyWords;
		this.styles = new Style[colors.length];
		for(int l=0; l<colors.length; l++) { // On creer des Styles à partir des couleurs fournies.
			this.styles[l] = this.addStyle("style "+l, null);
			StyleConstants.setForeground(this.styles[l], colors[l]);
		}

		// On recupere le Document du TextArea.
		doc = this.getStyledDocument();

		// On fixe les couleurs pour :
		this.setSelectedTextColor(Color.YELLOW); // le texte selectionne.
		this.setSelectionColor(Color.GREEN); // la zone selectionne.
		this.setForeground(Color.BLACK); // coleur du texte.
		this.getCaret().setBlinkRate(3); // le scintillement du caret.
		this.setCaretColor(Color.RED); // le caret.

		this.doc = this.getStyledDocument();
		doc.addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent event) { }
			public void insertUpdate(DocumentEvent event) {

				for(int i=0; i<doc.getLength(); i++) {
					Element paragraph = doc.getParagraphElement(i);
					int start = paragraph.getStartOffset();
					int end = paragraph.getEndOffset();
					int[] indexKeyWords = new int[TextArea.this.keyWords.length];
					String paragraphText = "";
					try {
						paragraphText = doc.getText(start, end-start);
						for(int k=0; k<TextArea.this.keyWords.length; k++) {
							indexKeyWords[k] = paragraphText.indexOf(keyWords[k]);
						}
					} catch (Exception e){}

					for(int j=0; j<indexKeyWords.length; j++) {
						int[] j_Aux = new int[1];
						if(indexKeyWords[j]>=0){
								SwingUtilities.invokeLater(new Runnable(){
				                public void run(){
				                        doc.setCharacterAttributes(indexKeyWords[j_Aux[0]]+start, 3, TextArea.this.styles[j_Aux[0]], true);
				                }
				            });
						}
					}
				}
			}
			public void removeUpdate(DocumentEvent event) { }
		});
	}
	public TextArea() {
		this("", null, null);
	}
}