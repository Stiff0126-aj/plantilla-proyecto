package uniandes.edu.co.proyecto.controller;

import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.Repositorio.ConductorRepository;
import uniandes.edu.co.proyecto.modelo.Conductor;

@RestController
@RequestMapping("/conductores")
public class ConductorController {

    private final ConductorRepository conductorRepository;

    public ConductorController(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    @PostMapping
    public Conductor registrarConductor(@RequestBody Conductor conductor) {
        return conductorRepository.save(conductor);
    }
}
