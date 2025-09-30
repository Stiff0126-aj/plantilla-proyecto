package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    private Long id;

    private int calificacion;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_asignado")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "servicio_asignado")
    private Servicio servicio;

    public Comentario() {
    ;}

    public Comentario(Long id, int calificacion, String descripcion, Usuario usuario, Servicio servicio) {
        this.id = id;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.servicio = servicio;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
