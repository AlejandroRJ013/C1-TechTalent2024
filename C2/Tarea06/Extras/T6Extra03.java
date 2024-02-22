import javax.swing.JOptionPane;

public class T6Extra03 {
    public static void main(String[] args) {
    String substring = ("abc");
    String palabra = JOptionPane.showInputDialog("Ingrese la palabra que comprobará que no tenga abc antes o atrás: ");
    String minus = palabra.toLowerCase();
    char[] caracteres = minus.toCharArray();
    char[] abc = substring.toCharArray();
    boolean contieneabc = false;
    boolean principioofinal = false;
    String prin = String.valueOf(caracteres[0]);
    String fin = String.valueOf(caracteres[caracteres.length-1]);

    if (prin.equals(String.valueOf(abc[0])) || fin.equals(String.valueOf(abc[2]))) {
        principioofinal = true;
    } else {
        int i = 0;
        for (char letra : caracteres) {    
            if (letra == abc[0]) {
                letra = caracteres[i+1];
                i++;
                if (letra == abc[1]) {
                    letra = caracteres[i+1];
                    i++;
                    if (letra == abc[2]) {
                        contieneabc = true;
                    }
                }
            }
            i++;
        }
    }
    
    if (principioofinal) {
        JOptionPane.showMessageDialog(null, "La palabra indicada contiene <abc> al principio o al final:"+ palabra);
    } else if (contieneabc) {
        JOptionPane.showMessageDialog(null, "La palabra indicada contiene <abc> en mitad de la palabra: "+palabra);
    } else {
        JOptionPane.showMessageDialog(null, "La palabra indicada no contiene <abc>");
    }
    }
}
