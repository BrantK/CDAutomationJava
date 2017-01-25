package com.cyberdust.automation.application.ServerOutput;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ConsoleErrorOutput extends OutputStream {
	
	private StyleContext context = new StyleContext();
	private JTextPane textPane;
	
	public ConsoleErrorOutput(JTextPane textPane) {
		this.textPane = textPane;
	}
	
	@Override
	public void write(int b) throws IOException {
		Style style = context.addStyle("errorOutput", null);
		StyleConstants.setForeground(style, Color.RED);
		try {
			textPane.getStyledDocument().insertString(textPane.getDocument().getLength(), String.valueOf((char)b), style);
			textPane.setCaretPosition(textPane.getDocument().getLength());
		} catch (BadLocationException ignored) {}
	}
}

