package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    private Long id;

    private String nombre;
    private String pais;
    private String region;


    public Ciudad() 
    {;}

    public Ciudad(Long id, String nombre, String pais, String region) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.region = region;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
}
