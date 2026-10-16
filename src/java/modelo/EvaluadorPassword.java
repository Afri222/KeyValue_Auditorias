package modelo;

/**
 *
 * @author afric
 */
public class EvaluadorPassword {
    
    final static int CRITERIOS = 5; // Long, mayus, minus, simb, nums.
    
    public EvaluadorPassword() {    }
    
    public static boolean[] validarContraseña(String cad){
        boolean[] v = new boolean[CRITERIOS];
        
        if (cad != null && !cad.isEmpty() && cad.length() >= 10) {
            v[0] = true;
        } else {
            return v;
            
        }
        for(int i=1; i<cad.length(); i++){
            if (!v[1] && Character.isDigit(cad.charAt(i)))
                v[1] = true;
            if (!v[2] && Character.isUpperCase(cad.charAt(i))) 
                v[2] = true;
            if (!v[3] && Character.isLowerCase(cad.charAt(i)))
                v[3] = true;
            if (!v[4] && cad.matches(".*[^a-zA-Z0-9].*"))
                v[4] = true;
            if (v[0] && v[1] && v[2] && v[3] && v[4])
                break;
        }
        return v;
    }
    
    public static String diagnostico(boolean[] v) {
        double c = 0;
        String d = "Contraseña: ";
        // System.out.println();
        for (int i=0; i<v.length; i++) {
            if (v[i])
                c++;
            System.out.println("V[" + i + "]: " + v[i]);
        }
        
        d += (c/CRITERIOS * 100) + "% segura.";
        // System.out.println("Cont: " + c + "; calc: " + (c/CRITERIOS * 100));
        return d;
    }
    
    public static double nivelFortaleza(boolean[] v) {
        double c = 0;
        
        for (int i=0; i<v.length; i++) {
            if (v[i])
                c++;
        }
        
        return c/CRITERIOS * 100;
    }
    
    public static String ofrecerContraseña() {
        String posiblepw = "";
        
        for(int i=0; i<10; i++){
            double j = Math.random() * 86; // 127 total -> 32 primeros NO aptos
            j += 33;
            posiblepw += (char) j;
            // Comprobar q cumpe tds los requisitos
        }
        
        return posiblepw;
    }
    
}
/* EvaluadorPassword.java: Lógica que analiza la clave según longitud,
presencia de mayúsculas, minúsculas, números y símbolos especiales,
devolviendo una puntuación y diagnóstico. */

/*
public class PasswordGenerator {
 
	public static String NUMEROS = "0123456789";
 
	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
 
	public static String ESPECIALES = "ñÑ";
 
	//
	public static String getPinNumber() {
		return getPassword(NUMEROS, 4);
	}
 
	public static String getPassword() {
		return getPassword(8);
	}
 
	public static String getPassword(int length) {
		return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
	}
 
	public static String getPassword(String key, int length) {
		String pswd = "";
 
		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}
 
		return pswd;
	}
}
*/
/*
 PasswordGenerator.getPassword(
		PasswordGenerator.MINUSCULAS+
		PasswordGenerator.MAYUSCULAS+
		PasswordGenerator.ESPECIALES,10);
    
*/