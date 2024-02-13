public class EjerExtra2 {
    public static void main(String[] args) {

        for (int tabla = 1; tabla <= 9; tabla++) {
            System.out.print("Tabla del " + tabla + ": \n");
            for (int producto = 0; producto <= 10; producto++) {
                System.out.print(tabla + "*" + producto + " = " + (tabla * producto) + "   ");
                if (producto == 10) {
                    System.out.print("\n" + "\n");
                }
            }
        }
    }
}