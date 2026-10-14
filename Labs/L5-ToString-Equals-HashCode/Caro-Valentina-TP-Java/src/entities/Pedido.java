package entities;

import java.time.LocalDate;
import enums.Estado;
import enums.FormaPago;
import java.time.LocalDateTime;
import java.util.ArrayList;
import interfaces.Calculable;
import java.util.HashSet;
import java.util.Set;

public class Pedido extends Base implements Calculable{
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Set<DetallePedido> detalles = new HashSet<>();;
    private Usuario usuario;
    
    public Pedido() {
    }

    public Pedido(LocalDate fecha, Estado estado, FormaPago formaPago, Usuario usuario, Long id, boolean eliminado, LocalDateTime createdAt) {
        super(id, eliminado, createdAt);
        this.fecha = fecha;
        this.estado = estado;
        this.total = 0.0; 
        this.formaPago = formaPago;
        this.detalles = new HashSet<>(); 
        this.usuario = usuario;
    }

    public LocalDate getFecha() {return fecha; } 
    public Estado getEstado() { return estado; } 
    public double getTotal() { return total; } 
    public FormaPago getFormaDePago() { return formaPago; } 
    public Set<DetallePedido> getDetalles() { return detalles; }
    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; } 
    public void setEstado(Estado estado) { this.estado = estado; } 
    public void setTotal(Double total) { this.total = total; } 
    public void setFormaPago(FormaPago formaPago) { this.formaPago = formaPago; } 
    public void setDetalles(Set<DetallePedido> detalles) { this.detalles = detalles; }
    
    @Override
    public void calcularTotal() {
        this.total = 0.0; // reiniciar para no duplicar sumas anteriores
        for (DetallePedido detalle : detalles) {
            this.total += detalle.getSubtotal(); 
        }
    }
    
    public void addDetallePedido(int cantidad, Producto p) {
        DetallePedido nuevoDetalle = new DetallePedido(cantidad, p, null, false, LocalDateTime.now()); 
        this.detalles.add(nuevoDetalle);
        calcularTotal(); 
    }
    
    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().getId().equals(producto.getId())){
                return detalle;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido aEliminar = findDetallePedidoByProducto(producto);
        if (aEliminar != null) {
            this.detalles.remove(aEliminar);
            calcularTotal(); //actualiza el total después de borrar
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return java.util.Objects.equals(fecha, pedido.fecha) && java.util.Objects.equals(total, pedido.total);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fecha, total);
    }

    @Override
    public String toString() {
        return "Pedido [" + "fecha=" + fecha + ", estado=" + estado + ", total=$" + total + 
               ", formaPago=" + formaPago + "\n  Detalles=" + detalles + ']';
    }
}