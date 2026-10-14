package entities;

import java.time.LocalDateTime;

public class DetallePedido extends Base {
    private int cantidad;
    private Double subtotal; 
    private Producto producto;

    public DetallePedido(int cantidad, Producto producto, Long id, boolean eliminado, LocalDateTime createdAt) {
        super(id, eliminado, createdAt);
        this.cantidad = cantidad;
        this.producto = producto;
        calcularSubtotal();
    }

    public int getCantidad() { return cantidad; } 
    public Double getSubtotal() { return subtotal; } 
    public Producto getProducto() { return producto; }

    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; } 
    public void setProducto(Producto producto) { this.producto = producto; }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal(); // se recalcula automáticamente al cambiar la cantidad
    }
    
    public Double calcularSubtotal(){
        if (producto != null) {
            subtotal = producto.getPrecio() * cantidad;
        } else {
            subtotal = 0.0;
        }
        return subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePedido that = (DetallePedido) o;
        return java.util.Objects.equals(producto, that.producto) && java.util.Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(producto, cantidad);
    }

    @Override
    public String toString() {
        return "DetallePedido [" + "cantidad=" + cantidad + ", subtotal=$" + subtotal + ", producto=" + (producto != null ? producto.getNombre() : "null") + ']';
    }
}
