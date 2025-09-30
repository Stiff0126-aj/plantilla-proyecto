package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transporte_comida")
public class TransporteComida {
    @Id
    private Long idServicio;

    private String orden;
    private String restaurante;

    @OneToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;


    public TransporteComida() {
    }

    public TransporteComida(Long idServicio, String orden, String restaurante, Servicio servicio) {
        this.idServicio = idServicio;
        this.orden = orden;
        this.restaurante = restaurante;
        this.servicio = servicio;
    }

    // Getters y Setters
    public Long getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getOrden() {
        return orden;
    }
    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
