package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TransporteMercancia;

public interface TransporteMercanciaRepository extends JpaRepository<TransporteMercancia, Long> {
    @Query(value = "SELECT * FROM Transporte_mercancia", nativeQuery = true)
    Collection<TransporteMercancia> darTransportesMercancia();

    @Query(value = "SELECT * FROM Transporte_mercancia WHERE id_servicio = :id", nativeQuery = true)
    TransporteMercancia darTransporteMercanciaPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Transporte_mercancia WHERE id_servicio = :id", nativeQuery = true)
    void eliminarTransporteMercancia(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Transporte_mercancia SET numElementos = :numElementos WHERE id_servicio = :id", nativeQuery = true)
    void actualizarTransporteMercancia(@Param("id") Long id,
                                       @Param("numElementos") int numElementos);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Transporte_mercancia (id_servicio, numElementos) VALUES (:id, :numElementos)", nativeQuery = true)
    void insertarTransporteMercancia(@Param("id") Long id,
                                     @Param("numElementos") int numElementos);
}
