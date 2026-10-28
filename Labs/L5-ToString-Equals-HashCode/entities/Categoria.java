package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Categoria extends Base {
    private String nombre;
    private String descripcion;
    private Set<Producto> productos = new HashSet<>();
    
    public Categoria() {
    }

    public Categoria(String nombre, String descripcion, ArrayList<Producto> productos, Long id, boolean eliminado, LocalDateTime createdAt) {
        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = new HashSet<Producto>();
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void agregarProducto(Producto p){
        if (p != null) {
            productos.add(p);
            if (p.getCategoria() != this) {
                p.setCategoria(this);
            }
        }
    }
    
   @Override
    public String toString() {
        return String.format(
            "Categoria [nombre: %s | descripcion: %s | productos: %s]", 
            nombre, 
            descripcion, 
            productos
        );
    }

}
