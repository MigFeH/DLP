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

	// TODO: Implement the lexemeToChar and lexemeToReal methods
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
			if(str.length() == 3) {
				// caso 1: 'x'
				return str.charAt(1);
			} else {
				// caso 2 y 3: tienen mas de longitud 3
				char[] caracteres = str.toCharArray();

				if(caracteres[1] == '\\') {
					if(Character.isDigit(caracteres[2])) {
						// caso 2: '\92' (solo tiene numeros)
						return (char) str;
					} else if(Character.)
				}
					// case 3: charAt(...)
			}
			return Character.parseCharacter(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

}
