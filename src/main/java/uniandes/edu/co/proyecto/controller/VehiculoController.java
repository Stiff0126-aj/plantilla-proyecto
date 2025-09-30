package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.Repositorio.VehiculoRepository;
import uniandes.edu.co.proyecto.modelo.Vehiculo;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @PostMapping
    public Vehiculo registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @GetMapping
    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }
}
