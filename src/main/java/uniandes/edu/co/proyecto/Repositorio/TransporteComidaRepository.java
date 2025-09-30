package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TransporteComida;

public interface TransporteComidaRepository extends JpaRepository<TransporteComida, Long> {
    @Query(value = "SELECT * FROM Transporte_comida", nativeQuery = true)
    Collection<TransporteComida> darTransportesComida();

    @Query(value = "SELECT * FROM Transporte_comida WHERE id_servicio = :id", nativeQuery = true)
    TransporteComida darTransporteComidaPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Transporte_comida WHERE id_servicio = :id", nativeQuery = true)
    void eliminarTransporteComida(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Transporte_comida SET orden = :orden, restaurante = :restaurante WHERE id_servicio = :id", nativeQuery = true)
    void actualizarTransporteComida(@Param("id") Long id,
                                    @Param("orden") String orden,
                                    @Param("restaurante") String restaurante);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Transporte_comida (id_servicio, orden, restaurante) VALUES (:id, :orden, :restaurante)", nativeQuery = true)
    void insertarTransporteComida(@Param("id") Long id,
                                  @Param("orden") String orden,
                                  @Param("restaurante") String restaurante);
}
