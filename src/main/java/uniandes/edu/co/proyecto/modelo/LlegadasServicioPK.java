package uniandes.edu.co.proyecto.modelo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

// PK compuesta de LlegadasServicio
@Embeddable
public class LlegadasServicioPK implements java.io.Serializable {
    private Long idServicio;
    private Long idLlegada;

    
    public LlegadasServicioPK() {
    }

    public LlegadasServicioPK(Long idServicio, Long idLlegada) {
        this.idServicio = idServicio;
        this.idLlegada = idLlegada;
    }

     // Getters y Setters
    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdLlegada() {
        return idLlegada;
    }

    public void setIdLlegada(Long idLlegada) {
        this.idLlegada = idLlegada;
    }
    // equals() y hashCode() -> Obligatorios en claves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LlegadasServicioPK)) return false;
        LlegadasServicioPK that = (LlegadasServicioPK) o;
        return Objects.equals(idServicio, that.idServicio) &&
               Objects.equals(idLlegada, that.idLlegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio, idLlegada);
    }
}