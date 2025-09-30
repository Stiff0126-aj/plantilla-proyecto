package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    private Long id;

    private String placa;
    private String tipo;
    private String marca;
    private int modelo;
    private String color;

    @Column(name = "ciudad_expedicion")
    private String ciudadExpedicion;

    private int capacidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario_conductor", referencedColumnName = "id_usuario")
    private Conductor conductor;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String placa, String tipo, String marca, int modelo,
                    String color, String ciudadExpedicion, int capacidad, Conductor conductor) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ciudadExpedicion = ciudadExpedicion;
        this.capacidad = capacidad;
        this.conductor = conductor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getCiudadExpedicion() {
        return ciudadExpedicion;
    }
    public void setCiudadExpedicion(String ciudadExpedicion) {
        this.ciudadExpedicion = ciudadExpedicion;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Conductor getConductor() {
        return conductor;
    }
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
