
package gui;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class StreamCapturer extends OutputStream {


	private StringBuilder buffer;
	private String prefix;
	private ErrorField textArea;
	private PrintStream old;

	public StreamCapturer(ErrorField e, PrintStream o) {

		this.buffer = new StringBuilder(128);
		this.old = o;
		this.textArea = e;
	}

	@Override
	public void write(int b) throws IOException {

		char c = (char) b;

		String value = Character.toString(c);
		this.buffer.append(value);

		if (value.equals("\n")) {

			this.textArea.appendText(this.buffer.toString());
			this.buffer.delete(0, this.buffer.length());
		}

		this.old.print(c);
	}


}