package bienseguros;

/**
 *
 * @author 
 */
public class PlanSeguro {
    
    String codigo;
    String nombre;
    String descripcion;
    float valorVenta;
    float comisionVendedor;

    /***
     * Constructor con parametros
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param valorVenta
     * @param comisionVendedor 
     */
    public PlanSeguro(String codigo, String nombre, String descripcion, float valorVenta, float comisionVendedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorVenta = valorVenta;
        this.comisionVendedor = comisionVendedor;
    }

    /***
     * getters y setters de esta clase
     * @return 
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(float valorVenta) {
        this.valorVenta = valorVenta;
    }

    public float getComisionVendedor() {
        return comisionVendedor;
    }

    public void setComisionVendedor(float comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }
    
    
    
}
