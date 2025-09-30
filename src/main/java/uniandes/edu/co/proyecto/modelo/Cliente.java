package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @EmbeddedId
    private ClientePK id;

    // Relación con Usuario
    @OneToOne
    @MapsId("idUsuario") 
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Relación con TarjetaCredito
    @OneToOne
    @MapsId("idTarjetaCredito") 
    @JoinColumn(name = "id_tarjeta_credito")
    private TarjetaCredito tarjeta;


    public Cliente() {
    }

    // Constructor con atributos
    public Cliente(ClientePK id, Usuario usuario, TarjetaCredito tarjeta) {
        this.id = id;
        this.usuario = usuario;
        this.tarjeta = tarjeta;
    }

    public ClientePK getId() {
        return id;
    }

    public void setId(ClientePK id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
}
