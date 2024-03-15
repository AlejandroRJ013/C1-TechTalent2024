public class articulosApp {
    public class articulos {

        //	ATRIBUTOS
        String nombre;
        double precioBruto;
        int cantidad;

        String producto;
        int cantidadProducto;
        boolean masProductos;
        boolean esencal;

        //CONTRUSCTORES
        public articulos() {
            this.producto = "##";
            this.cantidadProducto = 0;
        }
        
        public articulos(String producto, int cantidadProducto, boolean masProductos, boolean esencal) {
            this.nombre = producto;
            this.precioBruto = precioBruto;
            this.cantidad = cantidadProducto;
        }
        
        public articulos(String nombre, double precioBruto, int cantidad) {
            this.nombre = nombre;
            this.precioBruto = precioBruto;
            this.cantidad = cantidad;
        }

        public articulos(String nombre, int cantidad, double precioBruto) {
            this.nombre = nombre;
            this.precioBruto = precioBruto;
            this.cantidad = cantidad;
        }
        
        public articulos(double precioBruto, int cantidad, String nombre) {
            this.nombre = nombre;
            this.precioBruto = precioBruto;
            this.cantidad = cantidad;
        }
        
        public articulos(double precioBruto, String nombre, int cantidad) {
            this.nombre = nombre;
            this.precioBruto = precioBruto;
            this.cantidad = cantidad;
        }

        public articulos(int cantidad, String nombre, double precioBruto) {
            this.nombre = nombre;
            this.precioBruto = precioBruto;
            this.cantidad = cantidad;
        }
    
        public articulos(int cantidad, double precioBruto, String nombre) {
            this.nombre = nombre;
            this.precioBruto = precioBruto;
            this.cantidad = cantidad;
        }

        if (masArticulos.isSelected()) {
            masProductos = true;
        }
        if (articuloEsencial.isSelected()) {
            esencal = true;
        }
    }
}