package utn.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DetallePedido {
    private int cantidad;
    private Double subtotal;
    private Producto producto;
}
