package cl.isisur.frutossecos.Clases;

public class Clientes {
    private String idCliente;
    private String nombre;
    private String apellido;

    public Clientes()
    {
        this.idCliente="";
        this.nombre="";
        this.apellido="";
    }

    public Clientes( String idCliente, String nombre, String apellido )
    {
        this.idCliente=idCliente;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public String getCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void getApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
