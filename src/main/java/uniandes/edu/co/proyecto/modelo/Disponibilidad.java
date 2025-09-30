package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Disponibilidad")
public class Disponibilidad {

    @Id
    private Long id;

    private String dia;

    @Column(name = "franjas_actividad")
    private String franjasActividad;

    // Relación con Conductor
    @ManyToOne
    @JoinColumn(name = "id_usuario_conductor", referencedColumnName = "id_usuario", nullable = false)
    private Conductor conductor;

    public Disponibilidad() {
    }

    public Disponibilidad(Long id, String dia, String franjasActividad, Conductor conductor) {
        this.id = id;
        this.dia = dia;
        this.franjasActividad = franjasActividad;
        this.conductor = conductor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFranjasActividad() {
        return franjasActividad;
    }
    public void setFranjasActividad(String franjasActividad) {
        this.franjasActividad = franjasActividad;
    }

    public Conductor getConductor() {
        return conductor;
    }
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
