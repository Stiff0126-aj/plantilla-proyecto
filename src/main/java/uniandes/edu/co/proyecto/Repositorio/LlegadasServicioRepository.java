package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.LlegadasServicio;
import uniandes.edu.co.proyecto.modelo.LlegadasServicioPK;

public interface LlegadasServicioRepository extends JpaRepository<LlegadasServicio, LlegadasServicioPK>  {
    
    @Query(value = "SELECT * FROM Llegadas_servicio", nativeQuery = true)
    Collection<LlegadasServicio> darLlegadasServicio();

    @Query(value = "SELECT * FROM Llegadas_servicio WHERE id_servicio = :idServicio AND id_llegada = :idLlegada", nativeQuery = true)
    LlegadasServicio darLlegadasServicioPorId(@Param("idServicio") Long idServicio,
                                              @Param("idLlegada") Long idLlegada);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Llegadas_servicio WHERE id_servicio = :idServicio AND id_llegada = :idLlegada", nativeQuery = true)
    void eliminarLlegadasServicio(@Param("idServicio") Long idServicio,
                                  @Param("idLlegada") Long idLlegada);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Llegadas_servicio SET id_servicio = :idServicioNuevo, id_llegada = :idLlegadaNuevo WHERE id_servicio = :idServicio AND id_llegada = :idLlegada", nativeQuery = true)
    void actualizarLlegadasServicio(@Param("idServicio") Long idServicio,
                                    @Param("idLlegada") Long idLlegada,
                                    @Param("idServicioNuevo") Long idServicioNuevo,
                                    @Param("idLlegadaNuevo") Long idLlegadaNuevo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Llegadas_servicio (id_servicio, id_llegada) VALUES (:idServicio, :idLlegada)", nativeQuery = true)
    void insertarLlegadasServicio(@Param("idServicio") Long idServicio,
                                  @Param("idLlegada") Long idLlegada);
}
