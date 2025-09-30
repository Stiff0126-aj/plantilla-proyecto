package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TransportePasajeros;

public interface TransportePasajerosRepository extends JpaRepository<TransportePasajeros, Long> {
     @Query(value = "SELECT * FROM Transporte_pasajeros", nativeQuery = true)
    Collection<TransportePasajeros> darTransportesPasajeros();

    @Query(value = "SELECT * FROM Transporte_pasajeros WHERE id_servicio = :id", nativeQuery = true)
    TransportePasajeros darTransportePasajerosPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Transporte_pasajeros WHERE id_servicio = :id", nativeQuery = true)
    void eliminarTransportePasajeros(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Transporte_pasajeros SET clasificacion = :clasificacion WHERE id_servicio = :id", nativeQuery = true)
    void actualizarTransportePasajeros(@Param("id") Long id,
                                       @Param("clasificacion") String clasificacion);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Transporte_pasajeros (id_servicio, clasificacion) VALUES (:id, :clasificacion)", nativeQuery = true)
    void insertarTransportePasajeros(@Param("id") Long id,
                                     @Param("clasificacion") String clasificacion);
}
