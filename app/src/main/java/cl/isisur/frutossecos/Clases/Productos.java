package cl.isisur.frutossecos.Clases;

public class Productos {
    private String idProducto;
    private String nombre;
    private String estado;

    public Productos()
    {
        this.idProducto="";
        this.nombre="";
        this.estado="";
    }

    public Productos( String idProducto, String nombre, String estado )
    {
        this.idProducto=idProducto;
        this.nombre=nombre;
        this.estado=estado;
    }

    public String getIdAutor() {
        return idProducto;
    }

    public void setIdAutor(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idAutor='" + idProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
