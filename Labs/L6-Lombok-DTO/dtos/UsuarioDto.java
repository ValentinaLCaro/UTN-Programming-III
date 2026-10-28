package utn.dtos;

import utn.entities.Usuario;

public record UsuarioDto(
        String nombre,
        String apellido,
        String mail,
        String celular
) {
    public static UsuarioDto fromEntity(Usuario usuario) {
        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getMail(),
                usuario.getCelular()
        );
    }
}