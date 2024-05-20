public class ejercicio02 {
    public static void main(String[] args) {
        try {
            System.out.println("\033[32mIniciación del programa.\u001b[0m");
            throw new CustomEx("\033[35mExcepción personalizada\u001b[0m");
        } catch (CustomEx e) {
            System.out.println("\033[33mTipo de excepción capturada:\u001b[0m [ " + e.getMessage() + " ]");
        } finally {
            System.out.println("\033[31mFinal programa.\u001b[0m");
        }
    }
}


