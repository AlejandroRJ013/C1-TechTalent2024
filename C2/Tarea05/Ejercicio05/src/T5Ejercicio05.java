import javax.swing.JOptionPane;

public class T5Ejercicio05 {

	public static void main(String[] args) {
		String num = JOptionPane.showInputDialog("Introduce un número");
		int numero = Integer.parseInt(num);

		if (numero%2==0) {
			JOptionPane.showMessageDialog(null, "Su número es divisible exacto entre 2 \n"
			+numero+" / 2 = "+numero/2+", residuo: "+numero%2+".");
		} else {
			JOptionPane.showMessageDialog(null, "Su número no es un divisible exacto entre 2 \n"
			+numero+" / 2 = "+numero/2+", residuo: "+numero%2+".");
		}
	}

}