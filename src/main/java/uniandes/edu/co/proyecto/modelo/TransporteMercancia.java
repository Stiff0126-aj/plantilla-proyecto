package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transporte_mercancia")
public class TransporteMercancia {
    @Id
    private Long idServicio;

    private int numElementos;

    @OneToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;


    public TransporteMercancia() {
    }

    public TransporteMercancia(Long idServicio, int numElementos, Servicio servicio) {
        this.idServicio = idServicio;
        this.numElementos = numElementos;
        this.servicio = servicio;
    }


    // Getters y Setters
    public Long getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public int getNumElementos() {
        return numElementos;
    }
    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
