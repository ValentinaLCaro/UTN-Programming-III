package caro.valentina.tp.java;

import entities.*;
import enums.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Categoria cat1 = new Categoria(); cat1.setNombre("Electrónica");
        Categoria cat2 = new Categoria(); cat2.setNombre("Hogar");
        Categoria cat3 = new Categoria(); cat3.setNombre("Deportes");

        Set<Producto> catalogoProductos = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            Producto p = new Producto();
            p.setNombre("Producto " + i);
            p.setPrecio(1000.0 * i);
            p.setStock(10 + i);
            p.setDisponible(true);
            catalogoProductos.add(p);
        }
        
        Producto prodA = catalogoProductos.stream().filter(p -> p.getNombre().equals("Producto 1")).findFirst().get();
        Producto prodB = catalogoProductos.stream().filter(p -> p.getNombre().equals("Producto 2")).findFirst().get();

        Usuario u1 = new Usuario(); 
        u1.setNombre("Juan"); u1.setApellido("Pérez"); u1.setMail("juan@mail.com"); u1.setRol(Rol.USUARIO);
        
        Usuario u2 = new Usuario(); 
        u2.setNombre("Ana"); u2.setApellido("Gómez"); u2.setMail("ana@mail.com"); u2.setRol(Rol.ADMIN);

        Pedido ped1 = new Pedido(); ped1.setFecha(LocalDate.now()); ped1.setEstado(Estado.PENDIENTE); ped1.setFormaPago(FormaPago.TARJETA);
        ped1.addDetallePedido(2, prodA);
        ped1.addDetallePedido(1, prodB);
        u1.getPedidos().add(ped1); 

        Pedido ped2 = new Pedido(); ped2.setFecha(LocalDate.now()); ped2.setEstado(Estado.CONFIRMADO); ped2.setFormaPago(FormaPago.EFECTIVO);
        ped2.addDetallePedido(1, prodA);
        ped2.addDetallePedido(3, prodB);
        u1.getPedidos().add(ped2); 

        Pedido ped3 = new Pedido(); ped3.setFecha(LocalDate.now()); ped3.setEstado(Estado.TERMINADO); ped3.setFormaPago(FormaPago.TRANSFERENCIA);
        ped3.addDetallePedido(5, prodB);
        ped3.addDetallePedido(2, prodA);
        u2.getPedidos().add(ped3); 

        System.out.println("====== PUNTO 4: RESULTADOS POR CONSOLA ======\n");
        
        System.out.println("--- Un Producto ---");
        System.out.println(prodA.toString());
        
        System.out.println("\n--- Listado de Productos Cargados ---");
        for (Producto prod : catalogoProductos) {
            System.out.println(prod.toString());
        }

        System.out.println("\n--- Pedidos del usuario con más pedidos ---");
        Usuario usuarioTop = (u1.getPedidos().size() > u2.getPedidos().size()) ? u1 : u2;
        System.out.println("Usuario: " + usuarioTop.getNombre() + " " + usuarioTop.getApellido() + " (Total pedidos: " + usuarioTop.getPedidos().size() + ")");
        for (Pedido pedido : usuarioTop.getPedidos()) {
            System.out.println(pedido.toString());
        }

        System.out.println("\n====== PUNTO 5: COMPARACIÓN EQUALS ======");
        System.out.println("Creando nuevo producto con el mismo nombre ('Producto 1')...");
        
        Producto productoNuevo = new Producto();
        productoNuevo.setNombre("Producto 1"); 
        productoNuevo.setPrecio(9999.0); 
        
        System.out.println("Producto Nuevo: " + productoNuevo.toString());
        
        boolean existeEnColeccion = catalogoProductos.contains(productoNuevo);
        System.out.println("¿El Set detecta que este producto ya existe basándose en equals()? : " + existeEnColeccion);
        
        if (existeEnColeccion) {
            System.out.println("-> ÉXITO: Como sobrescribimos equals() y hashCode() para comparar por 'nombre', el Set reconoce que 'Producto 1' ya está guardado, aunque sea una instancia de memoria distinta.");
        }
    }
}
