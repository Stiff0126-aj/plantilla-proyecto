package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Punto")
public class Punto {
    @Id
    private Long id;

    private String nombreReferencia;
    private String direccion;
    private Double latitud;
    private Double longitud;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;


    public Punto() {
    }

    public Punto(Long id, String nombreReferencia, String direccion, Double latitud, Double longitud, Ciudad ciudad) {
        this.id = id;
        this.nombreReferencia = nombreReferencia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreReferencia() {
        return nombreReferencia;
    }
    public void setNombreReferencia(String nombreReferencia) {
        this.nombreReferencia = nombreReferencia;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
