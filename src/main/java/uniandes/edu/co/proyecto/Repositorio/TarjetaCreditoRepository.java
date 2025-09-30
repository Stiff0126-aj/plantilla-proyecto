package uniandes.edu.co.proyecto.Repositorio;


import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TarjetaCredito;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long> {
    
    @Query(value = "SELECT * FROM Tarjeta_credito", nativeQuery = true)
    Collection<TarjetaCredito> darTarjetas();

    @Query(value = "SELECT * FROM Tarjeta_credito WHERE id = :id", nativeQuery = true)
    TarjetaCredito darTarjetaPorId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Tarjeta_credito WHERE id = :id", nativeQuery = true)
    void eliminarTarjeta(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Tarjeta_credito SET numero = :numero, propietario = :propietario, fecha_vencimiento = :fecha, codigo_seguridad = :codigo WHERE id = :id", nativeQuery = true)
    void actualizarTarjeta(@Param("id") Long id,
                           @Param("numero") String numero,
                           @Param("propietario") String propietario,
                           @Param("fecha") Date fecha,
                           @Param("codigo") String codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Tarjeta_credito (id, numero, propietario, fecha_vencimiento, codigo_seguridad) VALUES (:id, :numero, :propietario, :fecha, :codigo)", nativeQuery = true)
    void insertarTarjeta(@Param("id") Long id,
                         @Param("numero") String numero,
                         @Param("propietario") String propietario,
                         @Param("fecha") Date fecha,
                         @Param("codigo") String codigo);
}
