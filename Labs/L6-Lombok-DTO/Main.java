package utn;

import utn.dtos.UsuarioDto;
import utn.entities.Categoria;
import utn.entities.Pedido;
import utn.entities.Producto;
import utn.entities.Usuario;
import utn.enums.Estado;
import utn.enums.FormaPago;
import utn.enums.Rol;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // Instanciar 3 Categorías
        Categoria cat1 = Categoria.builder().nombre("Electrónica").descripcion("Dispositivos electrónicos").build();
        Categoria cat2 = Categoria.builder().nombre("Hogar").descripcion("Artículos para el hogar").build();
        Categoria cat3 = Categoria.builder().nombre("Deportes").descripcion("Equipamiento deportivo").build();

        // Instanciar 10 Productos
        Set<Producto> productos = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Producto.builder()
                        .nombre("Producto " + i)
                        .precio(100.0 * i)
                        .descripcion("Descripción del producto " + i)
                        .stock(50)
                        .disponible(true)
                        .build())
                .collect(Collectors.toSet());

        Producto p1 = productos.stream().filter(p -> p.getNombre().equals("Producto 1")).findFirst().orElse(null);
        Producto p2 = productos.stream().filter(p -> p.getNombre().equals("Producto 2")).findFirst().orElse(null);
        Producto p3 = productos.stream().filter(p -> p.getNombre().equals("Producto 3")).findFirst().orElse(null);

        // Instanciar 2 Usuarios
        Usuario u1 = Usuario.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .mail("juan@test.com")
                .celular("123456789")
                .contraseña("1234")
                .rol(Rol.USUARIO)
                .pedidos(new HashSet<>())
                .build();

        Usuario u2 = Usuario.builder()
                .nombre("Ana")
                .apellido("Gómez")
                .mail("ana@test.com")
                .celular("987654321")
                .contraseña("5678")
                .rol(Rol.ADMIN)
                .pedidos(new HashSet<>())
                .build();

        // Instanciar 3 Pedidos (al menos 2 detalles por pedido)
        Pedido ped1 = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(Estado.PENDIENTE)
                .formaPago(FormaPago.TARJETA)
                .detalles(new HashSet<>())
                .build();
        ped1.addDetallePedido(2, p1);
        ped1.addDetallePedido(1, p2);
        u1.getPedidos().add(ped1);

        Pedido ped2 = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(Estado.CONFIRMADO)
                .formaPago(FormaPago.EFECTIVO)
                .detalles(new HashSet<>())
                .build();
        ped2.addDetallePedido(3, p2);
        ped2.addDetallePedido(1, p3);
        u1.getPedidos().add(ped2);

        Pedido ped3 = Pedido.builder()
                .fecha(LocalDate.now())
                .estado(Estado.TERMINADO)
                .formaPago(FormaPago.TRANSFERENCIA)
                .detalles(new HashSet<>())
                .build();
        ped3.addDetallePedido(1, p1);
        ped3.addDetallePedido(4, p3);
        u2.getPedidos().add(ped3);

        // Mostrar por consola
        System.out.println("--- 1 Producto ---");
        System.out.println(p1);

        System.out.println("\n--- Listado de Productos ---");
        productos.forEach(System.out::println);

        System.out.println("\n--- Pedidos del usuario con más pedidos ---");
        Usuario usuarioConMasPedidos = u1.getPedidos().size() > u2.getPedidos().size() ? u1 : u2;
        System.out.println("Usuario: " + usuarioConMasPedidos.getNombre());
        usuarioConMasPedidos.getPedidos().forEach(System.out::println);

        // Comparación de Equals
        System.out.println("\n--- Comparación Equals ---");
        Producto productoNuevo = Producto.builder()
                .nombre("Producto 1") // Mismo nombre que p1
                .precio(999.9)
                .descripcion("Nueva descripción")
                .build();

        System.out.println("Producto a comparar: " + productoNuevo);
        boolean existe = productos.contains(productoNuevo);
        System.out.println("¿El producto existe en la colección (según equals)? " + existe);

        // Prueba DTO
        System.out.println("\n--- UsuarioDTO ---");
        UsuarioDto dto = UsuarioDto.fromEntity(u1);
        System.out.println(dto);
    }
}