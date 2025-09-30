package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientePK implements Serializable {

    private Long idUsuario;
    private Long idTarjetaCredito;
    public ClientePK() {
    }

    // Constructor con atributos
    public ClientePK(Long idUsuario, Long idTarjetaCredito) {
        this.idUsuario = idUsuario;
        this.idTarjetaCredito = idTarjetaCredito;
    }
    
    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    public void setIdTarjetaCredito(Long idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientePK)) return false;
        ClientePK that = (ClientePK) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
               Objects.equals(idTarjetaCredito, that.idTarjetaCredito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idTarjetaCredito);
    }
}
