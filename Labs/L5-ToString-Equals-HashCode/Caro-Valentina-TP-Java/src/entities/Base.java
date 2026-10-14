package entities;

import java.time.LocalDateTime;

public abstract class Base {
    private static Long contadorId = 0L; // contador de id para asignarlos automaticamente
    
    private Long id;
    private boolean eliminado;
    private LocalDateTime createdAt;
    
    public Base() {
    }

    public Base(Long id, boolean eliminado, LocalDateTime createdAt) {
        contadorId ++;
        this.id = contadorId;
        this.eliminado = eliminado;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public boolean isEliminado() { return eliminado; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public abstract String toString();
}
