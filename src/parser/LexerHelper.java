package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		try {
			str = str.substring(1, str.length() - 1); // sin comillas simples

			if(str.equals("\\n")) { // caso \n
				return '\n';
			} else if(str.equals("\\t")) { // caso \t
				return '\t';
			} else if(str.startsWith("\\")) { // caso \126 (codigo ascii)
				return (char) Integer.parseInt(str.substring(1));
			} else if(str.length() == 1) { // caso x
				return str.charAt(0);
			}
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return ' ';
	}

}
