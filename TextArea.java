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

import java.util.Scanner;

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
		this.standardStyle = this.addStyle("standard style", null);
		StyleConstants.setForeground(this.standardStyle, Color.BLACK);

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
				TextArea.this.setForeground(Color.BLACK);
				SwingUtilities.invokeLater(new Runnable(){
	                public void run(){
	                        doc.setCharacterAttributes(0, doc.getLength(), TextArea.this.standardStyle, true);
	                }
	            });

				String text = "";
				System.out.println("\n\nLECTURE\n");
				try {
					text = doc.getText(0, doc.getLength());
					Scanner scan = new Scanner(text);
					int[] indexCurrentWord = new int[1];
					indexCurrentWord[0] = 0;
					SwingUtilities.invokeLater(new Runnable(){
		                public void run(){
					        while(scan.hasNext()) {
								String word = scan.next();
								System.out.println("Current Word: "+word+" index: "+indexCurrentWord[0]);
								boolean notKeyWord = true;
								for(int j=0; j<TextArea.this.keyWords.length; j++) {
									int[] j_Aux = new int[1];
									j_Aux[0] = j;
									if(word.equals(TextArea.this.keyWords[j_Aux[0]])) {										
				                		System.out.printf("Caractères %s ||  index: %d | taille: %d | style; %s\n", word, indexCurrentWord[0],
				                        	TextArea.this.keyWords[j_Aux[0]].length(),
				                        	TextArea.this.styles[j_Aux[0]].getName());
				                        doc.setCharacterAttributes(
				                        	indexCurrentWord[0],
				                        	TextArea.this.keyWords[j_Aux[0]].length(),
				                        	TextArea.this.styles[j_Aux[0]],
				                        	true
				                        );
				               		}
						            
						            notKeyWord = false;
								}
								indexCurrentWord[0] += word.length()+1;
							}
						}
					});
				} catch (Exception e){}
			}
			
			public void removeUpdate(DocumentEvent event) { }

		});
	}
	public TextArea() {
		this("", null, null);
	}
}