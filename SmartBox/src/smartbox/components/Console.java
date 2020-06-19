package smartbox.components;

import java.io.*;
import smartbox.*;

public class Console extends Component implements App{

	protected BufferedReader stdin;
	protected PrintWriter stdout;
	protected PrintWriter stderr;

	public CommandProcessor processor;

	public Console() {
		stdout = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(System.out)), true);
		stderr = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(System.err)), true);
		stdin = new BufferedReader(
				new InputStreamReader(System.in));
	}

	public void repl() {
		while(true) {
			try {
				stdout.print("-> ");
				stdout.flush();
				String request = stdin.readLine();
				if (request == null) continue;
				if (request.equals("quit")) break;
				String response = processor.execute(request);
				stdout.println("result: " + response);
			} catch(Exception e) {
				stderr.println(e.getMessage());
				//break;
			}
		}
		stdout.println("bye");
	}

	public void main() throws Exception {
		repl();
	}
}