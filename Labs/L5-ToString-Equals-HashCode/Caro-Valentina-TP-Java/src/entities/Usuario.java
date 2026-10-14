package entities;

import enums.Rol;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Usuario extends Base{
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;
    private Set<Pedido> pedidos = new HashSet<>();
    
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String mail, String celular, String contraseña, Rol rol, Set<Pedido> pedidos, Long id, boolean eliminado, LocalDateTime createdAt) {
        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contraseña = contraseña;
        this.rol = rol;
        this.pedidos = pedidos;
    }

    public String getNombre() { return nombre; } 
    public String getApellido() { return apellido; } 
    public String getMail() { return mail; } 
    public String getCelular() { return celular; }
    public Rol getRol() { return rol; } 
    public Set<Pedido> getPedidos() { return pedidos; }

    public void setNombre(String nombre) { this.nombre = nombre; } 
    public void setApellido(String apellido) { this.apellido = apellido; } 
    public void setMail(String mail) { this.mail = mail; } 
    public void setCelular(String celular) { this.celular = celular; } 
    public void setContraseña(String contraseña) { this.contraseña = contraseña; } 
    public void setRol(Rol rol) { this.rol = rol; } 
    
    public void agregarPedido(Pedido p){
        if (p != null) {
            pedidos.add(p);
            if (p.getUsuario() != this) {
                p.setUsuario(this); 
            }
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return java.util.Objects.equals(mail, usuario.mail); // El mail define la identidad
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(mail);
    }

    @Override
    public String toString() {
        // Omitimos imprimir 'pedidos' y 'contraseña' directamente para evitar recursión y por seguridad
        return "Usuario [" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + 
               ", mail='" + mail + '\'' + ", rol=" + rol + ']';
    }
}
