package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query(value = "SELECT * FROM Vehiculo", nativeQuery = true)
    Collection<Vehiculo> darVehiculos();

    @Query(value = "SELECT * FROM Vehiculo WHERE id = :id", nativeQuery = true)
    Vehiculo darVehiculoPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Vehiculo WHERE id = :id", nativeQuery = true)
    void eliminarVehiculo(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Vehiculo " +
                   "SET placa = :placa, tipo = :tipo, marca = :marca, modelo = :modelo, " +
                   "color = :color, ciudad_expedicion = :ciudadExpedicion, capacidad = :capacidad, " +
                   "id_usuario_conductor = :idUsuarioConductor " +
                   "WHERE id = :id", nativeQuery = true)
    void actualizarVehiculo(@Param("id") Long id,
                            @Param("placa") String placa,
                            @Param("tipo") String tipo,
                            @Param("marca") String marca,
                            @Param("modelo") int modelo,
                            @Param("color") String color,
                            @Param("ciudadExpedicion") String ciudadExpedicion,
                            @Param("capacidad") int capacidad,
                            @Param("idUsuarioConductor") Long idUsuarioConductor);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Vehiculo (id, placa, tipo, marca, modelo, color, ciudad_expedicion, capacidad, id_usuario_conductor) " +
                   "VALUES (:id, :placa, :tipo, :marca, :modelo, :color, :ciudadExpedicion, :capacidad, :idUsuarioConductor)",
           nativeQuery = true)
    void insertarVehiculo(@Param("id") Long id,
                          @Param("placa") String placa,
                          @Param("tipo") String tipo,
                          @Param("marca") String marca,
                          @Param("modelo") int modelo,
                          @Param("color") String color,
                          @Param("ciudadExpedicion") String ciudadExpedicion,
                          @Param("capacidad") int capacidad,
                          @Param("idUsuarioConductor") Long idUsuarioConductor);
}
