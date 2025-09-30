package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import jakarta.persistence.*;



@Entity
@Table(name = "Servicio")
public class Servicio {
    @Id
    private Long id;

    @Column(name = "distancia_kilometros")
    private Double distanciaKilometros;

    @Column(name = "tarifa_kilometro")
    private Double tarifaKilometro;

    private Double precio;

  
    @Column(name = "hora_inicio")
    private Date horaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora_finalizacion")
    private Date horaFinalizacion;

    @OneToOne
    @JoinColumn(name = "salida")
    private Punto salida;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "id_usuario_cliente", referencedColumnName = "id_usuario"),
        @JoinColumn(name = "id_tarjeta_cliente", referencedColumnName = "id_tarjeta_credito")
    })
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario_conductor", referencedColumnName = "id_usuario")
    private Conductor conductor;

    public Servicio() {
    }

    public Servicio(Long id, Double distanciaKilometros, Double tarifaKilometro, Double precio,
                    Date horaInicio, Date horaFinalizacion, Punto salida,
                    Cliente cliente, Conductor conductor) {
        this.id = id;
        this.distanciaKilometros = distanciaKilometros;
        this.tarifaKilometro = tarifaKilometro;
        this.precio = precio;
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
        this.salida = salida;
        this.cliente = cliente;
        this.conductor = conductor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getDistanciaKilometros() {
        return distanciaKilometros;
    }
    public void setDistanciaKilometros(Double distanciaKilometros) {
        this.distanciaKilometros = distanciaKilometros;
    }

    public Double getTarifaKilometro() {
        return tarifaKilometro;
    }
    public void setTarifaKilometro(Double tarifaKilometro) {
        this.tarifaKilometro = tarifaKilometro;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinalizacion() {
        return horaFinalizacion;
    }
    public void setHoraFinalizacion(Date horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public Punto getSalida() {
        return salida;
    }
    public void setSalida(Punto salida) {
        this.salida = salida;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conductor getConductor() {
        return conductor;
    }
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
