package entities;

import java.time.LocalDateTime;

public class Producto extends Base{
    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private boolean disponible;
    private Categoria categoria;
    
    public Producto() {
    }

    public Producto(String nombre, double precio, String descripcion, int stock, String imagen, Categoria categoria, Long id, boolean eliminado, LocalDateTime createdAt) {
        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.categoria = categoria;
        this.disponible = (stock > 0);
    }
    
    public Producto(String nombre, double precio, int stock, Categoria categoria, Long id, boolean eliminado, LocalDateTime createdAt){
        this(nombre, precio, "Sin descripción", stock, "default.png", categoria, id, eliminado, createdAt );
    }
    

    public boolean isDisponible() { // define automaticamente si el producto esta disponible segun el stock
        this.disponible = (this.stock > 0); // si stock es mayor a 0 retorna true
        return this.disponible; 
    }
    
    public String getNombre() { return nombre; } 
    public double getPrecio() { return precio; } 
    public String getDescripcion() { return descripcion; } 
    public int getStock() { return stock; } 
    public String getImagen() { return imagen; } 
    public Categoria getCategoria() { return categoria; } 

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setImagen(String imagen) { this.imagen = imagen; } 
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setNombre(String nombre) { this.nombre = nombre; } 
    public void setPrecio(Double precio) { this.precio = precio; } 
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    public void setStock(int stock) { 
        this.stock = stock; 
        this.disponible = (stock > 0); // actualiza el estado para mantener la coherencia
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return java.util.Objects.equals(nombre, producto.nombre); // Igualdad basada en el nombre
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Producto [" + "nombre='" + nombre + '\'' + ", precio=$" + precio + 
               ", stock=" + stock + ", disponible=" + disponible + ']';
    }
}
