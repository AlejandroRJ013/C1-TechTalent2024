public class T5Ejercicio01 {

    public static void main(String[] args) {
        int val11=4523, val21=741;
        String val1="\033[34m"+val11+"\u001B[0m", val2="\033[32m"+val21+"\u001B[0m";
       
        if (val11>val21) {
            System.out.println("La variable val1: "+val1+" es mayor que val2: "+val2);
        } else {
            System.out.println("La variable val2: "+val2+" es mayor que val1: "+val1);
        }
    }
}