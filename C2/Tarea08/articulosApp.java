public class articulosApp {

    // ATRIBUTOS
    String producto;
    int cantidadProducto;
    double precio;

    // CONTRUSCTORES
    public articulosApp() {
        this.producto = "##";
        this.cantidadProducto = 0;
        this.precio = 0.0;
    }

    public articulosApp(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public articulosApp(int cantidadProducto, String producto) {
        this.cantidadProducto = cantidadProducto;
        this.producto = producto;
    }

    public articulosApp(int cantidadProducto, double precio) {
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
    }

    public articulosApp(int cantidadProducto, String producto, double precio) {
        this.cantidadProducto = cantidadProducto;
        this.producto = producto;
        this.precio = precio;
    }

    public articulosApp(int cantidadProducto, double precio, String producto) {
        this.cantidadProducto = cantidadProducto;
        this.producto = producto;
        this.precio = precio;
    }

    public articulosApp(String producto) {
        this.producto = producto;
    }

    public articulosApp(String producto, int cantidadProducto) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
    }

    public articulosApp(String producto, double precio) {
        this.producto = producto;
        this.precio = precio;
    }

    public articulosApp(String producto, int cantidadProducto, double precio) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
    }

    public articulosApp(String producto, double precio, int cantidadProducto) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
    }

    public articulosApp(double precio) {
        this.precio = precio;
    }

    public articulosApp(double precio, int cantidadProducto) {
        this.precio = precio;
        this.cantidadProducto = cantidadProducto;
    }

    public articulosApp(double precio, String producto) {
        this.precio = precio;
        this.producto = producto;
    }

    public articulosApp(double precio, int cantidadProducto, String producto) {
        this.precio = precio;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
    }

    public articulosApp(double precio, String producto, int cantidadProducto) {
        this.precio = precio;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
    }

    // METODOS
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidadProducto;
    }

    public void setCantidad(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTodos(String producto, int cantidadProducto, double precio) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "producto='" + producto + '\'' +
                "precio='" + precio + '\'' +
                ", cantidad=" + cantidadProducto + '\'' +
                '}';
    }
}