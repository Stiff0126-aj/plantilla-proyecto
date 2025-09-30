package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transporte_pasajeros")
public class TransportePasajeros {
    @Id
    private Long idServicio;

    private String clasificacion;

    @OneToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;


    public TransportePasajeros() {
    }

    public TransportePasajeros(Long idServicio, String clasificacion, Servicio servicio) {
        this.idServicio = idServicio;
        this.clasificacion = clasificacion;
        this.servicio = servicio;
    }

     // Getters y Setters
    public Long getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}