
public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new OperacionInvalidaException(
                    "El precio de \"" + nombre + "\" no puede ser negativo: " + precio);
        }
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new OperacionInvalidaException(
                    "El stock de \"" + nombre + "\" no puede quedar negativo: " + stock);
        }
        this.stock = stock;
    }

    public void vender(int unidades) {
        if (unidades <= 0) {
            throw new OperacionInvalidaException("La cantidad a vender debe ser mayor que cero.");
        }
        if (unidades > stock) {
            throw new OperacionInvalidaException(
                    "Stock insuficiente de \"" + nombre + "\": hay " + stock
                            + " y se intentaron vender " + unidades + ".");
        }
        stock -= unidades;
    }

    public void reabastecer(int unidades) {
        if (unidades <= 0) {
            throw new OperacionInvalidaException("La cantidad a reabastecer debe ser mayor que cero.");
        }
        stock += unidades;
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new OperacionInvalidaException(
                    "El porcentaje de descuento debe estar entre 0 y 100, llegó: " + porcentaje);
        }
        precio -= precio * (porcentaje / 100.0);
    }

    public boolean hayStock() {
        return stock > 0;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " - $" + precio + " - stock: " + stock;
    }
}
