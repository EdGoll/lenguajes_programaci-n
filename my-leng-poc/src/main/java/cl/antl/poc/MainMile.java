
package cl.antl.poc;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import cl.antl.poc.lexerparser.SimpleLexer;
import cl.antl.poc.lexerparser.SimpleParser;
import cl.antl.poc.lexerparser.mile.MileLexer;
import cl.antl.poc.lexerparser.mile.MileParser;


public class MainMile {
	
	private static final String EXTENSION = "mile";

	public static void main(String[] args) throws IOException {
		String program = args.length > 1 ? args[1] : "test/test." + EXTENSION;
		System.out.println("Interpreting file " + program);

		MileLexer lexer = new MileLexer(new ANTLRFileStream(program));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MileParser parser = new MileParser(tokens);

		MileParser.ProgramContext tree = parser.program();

		MileCustomVisitor visitor = new MileCustomVisitor();
		visitor.visit(tree);

		System.out.println("Interpretation finished");

	}

}
