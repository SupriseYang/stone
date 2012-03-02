package stone;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
	public static String regexPat
							= "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
							+ "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
	
	private Pattern pattern = Pattern.compile(regexPat);
	private ArrayList<Token> queue = new ArrayList<Token>();
	private boolean hasMore;
	private LineNumberReader reader;
	
	public Lexer(Reader r) {
		hasMore = true;
		reader = new LineNumberReader();
	}
	public Token read() throws ParseException {
		if (fillQeueue(0)) {
			return queue.remove(0);
		}	
	}
	public Token peak(int i) throws ParseException {
		if (fillQueue(i)) {
			return queue.get(i);
		}
		else
		{
			return Token.EOF;
		}
	}
	public boolean fillQueue(int i) throws ParseException {
		while (i >= queue.size()) {
			if(hasMore) {
				readLine();
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	public void readLine() throws ParseException {
		String line;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			throw new ParseException(e);
		}
		if(line == null) {
			hasMore = false;
			return;
		}
		int lineNo = reader.getLineNumber();
		Matcher matcher = pattern.matcher(line);
		matcher.useTransparentBounds(true).useAnchoringBounds(false);
		int pos = 0;
		int endPos = line.length();
		while (pos < endPos) {
			matcher.region(pos, endPos);
		}
	}
}
