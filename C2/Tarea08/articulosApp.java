public class articulosApp {
    public class articulos {

        //	ATRIBUTOS
        String producto;
        int cantidadProducto;

        //CONTRUSCTORES
        public articulos() {
            this.producto = "##";
            this.cantidadProducto = 0;
        }
        
        public articulos(String producto, int cantidadProducto) {
            this.producto = producto;
            this.cantidadProducto = cantidadProducto;

        }
    }
}