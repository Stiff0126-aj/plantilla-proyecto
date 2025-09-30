package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Llegadas_servicio")
public class LlegadasServicio {
    @EmbeddedId
    private LlegadasServicioPK id;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    @ManyToOne
    @MapsId("idLlegada")
    @JoinColumn(name = "id_llegada")
    private Llegada llegada;

    public LlegadasServicio() {
    }

    public LlegadasServicio(LlegadasServicioPK id, Servicio servicio, Llegada llegada) {
        this.id = id;
        this.servicio = servicio;
        this.llegada = llegada;
    }
    
    // Getters y Setters
    public LlegadasServicioPK getId() {
        return id;
    }
    public void setId(LlegadasServicioPK id) {
        this.id = id;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Llegada getLlegada() {
        return llegada;
    }
    public void setLlegada(Llegada llegada) {
        this.llegada = llegada;
    }
}