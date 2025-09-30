package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Llegada")
public class Llegada {
    @Id
    private Long idPunto;

    @OneToOne
    @JoinColumn(name = "id_punto")
    private Punto punto;
    
    public Llegada() {
    ;}

    public Llegada(Long idPunto, Punto punto) {
        this.idPunto = idPunto;
        this.punto = punto;
    }
     // Getters y Setters
    public Long getIdPunto() {
        return idPunto;
    }
    public void setIdPunto(Long idPunto) {
        this.idPunto = idPunto;
    }

    public Punto getPunto() {
        return punto;
    }
    public void setPunto(Punto punto) {
        this.punto = punto;
    }
}
