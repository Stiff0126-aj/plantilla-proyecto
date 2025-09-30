package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "Conductor")
public class Conductor {

    @Id
    @Column(name = "id_usuario")
    private Long idUsuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Getters y setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Constructores
    public Conductor() {}

    public Conductor(Long idUsuario, Usuario usuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
    }
}
