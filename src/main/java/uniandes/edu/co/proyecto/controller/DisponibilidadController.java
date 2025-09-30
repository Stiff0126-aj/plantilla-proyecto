package uniandes.edu.co.proyecto.controller;

import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.Repositorio.DisponibilidadRepository;
import uniandes.edu.co.proyecto.modelo.Disponibilidad;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadController {
    
    
    private final DisponibilidadRepository disponibilidadRepository;

    public DisponibilidadController(DisponibilidadRepository disponibilidadRepository) {
        this.disponibilidadRepository = disponibilidadRepository;
    }

    @PostMapping
    public String registrarDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        int existe = disponibilidadRepository.validarDisponibilidad(
            disponibilidad.getConductor().getIdUsuario(),
            disponibilidad.getDia(),
            "08:00",
            "18:00"
        );
        if (existe > 0) {
            return "Error: disponibilidad se superpone con otra existente";
        }
        disponibilidadRepository.save(disponibilidad);
        return "Disponibilidad registrada";
    }
}
