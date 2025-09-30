package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Disponibilidad;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {
    //RF5 Y RF6
    @Query(value = """
    SELECT COUNT(*) 
    FROM Disponibilidad d
    WHERE d.id_conductor = :idConductor
      AND d.dia = :dia
      AND ((:horaInicio BETWEEN d.hora_inicio AND d.hora_fin)
        OR (:horaFin BETWEEN d.hora_inicio AND d.hora_fin)
        OR (d.hora_inicio BETWEEN :horaInicio AND :horaFin))
    """, nativeQuery = true)
    int validarDisponibilidad(@Param("idConductor") Long idConductor,
                          @Param("dia") String dia,
                          @Param("horaInicio") String horaInicio,
                          @Param("horaFin") String horaFin);



    @Query(value = "SELECT * FROM Disponibilidad", nativeQuery = true)
    Collection<Disponibilidad> darDisponibilidades();

    @Query(value = "SELECT * FROM Disponibilidad WHERE id = :id", nativeQuery = true)
    Disponibilidad darDisponibilidadPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Disponibilidad WHERE id = :id", nativeQuery = true)
    void eliminarDisponibilidad(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Disponibilidad " +
                   "SET dia = :dia, franjas_actividad = :franjas, id_usuario_conductor = :idConductor " +
                   "WHERE id = :id", nativeQuery = true)
    void actualizarDisponibilidad(@Param("id") Long id,
                                  @Param("dia") String dia,
                                  @Param("franjas") String franjas,
                                  @Param("idConductor") Long idConductor);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Disponibilidad (id, dia, franjas_actividad, id_usuario_conductor) " +
                   "VALUES (:id, :dia, :franjas, :idConductor)", nativeQuery = true)
    void insertarDisponibilidad(@Param("id") Long id,
                                @Param("dia") String dia,
                                @Param("franjas") String franjas,
                                @Param("idConductor") Long idConductor);
}
