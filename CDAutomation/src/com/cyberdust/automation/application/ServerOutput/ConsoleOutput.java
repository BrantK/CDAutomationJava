package com.cyberdust.automation.application.ServerOutput;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

public class ConsoleOutput extends OutputStream {
	private JTextPane textPane;
	
	public ConsoleOutput(JTextPane textPane) {
		this.textPane = textPane;
	}
	
	@Override
	public void write(int b) throws IOException {
		try {
			textPane.getStyledDocument().insertString(textPane.getDocument().getLength(), String.valueOf((char)b), null);
			textPane.setCaretPosition(textPane.getDocument().getLength());
		} catch (BadLocationException ignored) {}
	}
}

