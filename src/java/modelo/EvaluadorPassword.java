package modelo;

/**
 *
 * @author afric
 */
public class EvaluadorPassword {
    private RegistroPassword rpw;

    public EvaluadorPassword(RegistroPassword rpw) {
        if (rpw != null)
            this.rpw = rpw;
    }
    
    public double analizarContraseña(String pw) {
        double pts = 0;
        boolean[] v = validarContraseña(pw);
        
        if (pw == null || pw.isEmpty())
            return -1;
        if (pw.length() >= 10)
            pts ++;
        if (v[0] && v[1] && v[2] && v[3])
            pts = 10;
        return pts;
    }
    
    public boolean[] validarContraseña(String cad){
        final int criterios = 4;
        boolean[] v = new boolean[criterios];
        
        if (cad == null || cad.isEmpty()) {
            boolean[] b = v;
            
            for (int i=0; i<b.length; i++) {
                b[i] = false;
            }
            return b;
        }
        
        for (int i=0; i<criterios; i++) {
            v[i] = false;
        }
        for(int i=0; i<v.length; i++){
            if (!v[0] && Character.isDigit(cad.charAt(i)))
                v[0] = true;
            if (!v[1] && Character.isUpperCase(cad.charAt(i))) 
                v[1] = true;
            if (!v[2] && Character.isLowerCase(cad.charAt(i)))
                v[2] = true;
            if (!v[3] && cad.matches(".*[^a-zA-Z0-9].*"))
                v[3] = true;
        }
        
        return v;
    }
    
    public String ofrecerContraseña() {
        String posiblepw = "";
        
        
        
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