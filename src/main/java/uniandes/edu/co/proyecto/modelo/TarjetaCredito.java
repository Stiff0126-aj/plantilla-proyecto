package uniandes.edu.co.proyecto.modelo;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tarjeta_credito")
public class TarjetaCredito {
    @Id
    private Long id;

    private String numero;
    private String propietario;

   
    private Date fechaVencimiento;

    private String codigoSeguridad;

    public TarjetaCredito() {
    }

    public TarjetaCredito(Long id, String numero, String propietario, Date fechaVencimiento, String codigoSeguridad) {
        this.id = id;
        this.numero = numero;
        this.propietario = propietario;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
}
