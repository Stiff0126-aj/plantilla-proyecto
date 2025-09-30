package uniandes.edu.co.proyecto.controller;

import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.Repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.modelo.Servicio;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioRepository servicioRepository;

    public ServicioController(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    // RF8: Solicitar servicio
    @PostMapping
    public Servicio solicitarServicio(@RequestBody Servicio servicio) {
        Long conductorId = servicioRepository.asignarConductor();
        // Asignar conductor aquí (ejemplo simplificado)
        servicioRepository.save(servicio);
        return servicio;
    }

    // RF9: Finalizar servicio
    @PutMapping("/{id}/finalizar")
    public String finalizarServicio(@PathVariable Long id) {
        servicioRepository.cerrarServicio(id, new java.sql.Timestamp(System.currentTimeMillis()), 20000.0);
        return "Servicio finalizado";
    }
}
