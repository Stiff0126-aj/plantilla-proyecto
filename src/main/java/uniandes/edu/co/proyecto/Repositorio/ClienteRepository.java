package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.ClientePK;

public interface ClienteRepository extends JpaRepository<Cliente, ClientePK> {
    
    @Query(value = "SELECT * FROM Cliente", nativeQuery = true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM Cliente WHERE id_usuario = :idUsuario AND id_tarjeta_credito = :idTarjeta", nativeQuery = true)
    Cliente darClientePorId(@Param("idUsuario") Long idUsuario,
                            @Param("idTarjeta") Long idTarjeta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Cliente WHERE id_usuario = :idUsuario AND id_tarjeta_credito = :idTarjeta", nativeQuery = true)
    void eliminarCliente(@Param("idUsuario") Long idUsuario,
                         @Param("idTarjeta") Long idTarjeta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Cliente SET id_tarjeta_credito = :idTarjetaNuevo WHERE id_usuario = :idUsuario AND id_tarjeta_credito = :idTarjeta", nativeQuery = true)
    void actualizarCliente(@Param("idUsuario") Long idUsuario,
                           @Param("idTarjeta") Long idTarjeta,
                           @Param("idTarjetaNuevo") Long idTarjetaNuevo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cliente (id_usuario, id_tarjeta_credito) VALUES (:idUsuario, :idTarjeta)", nativeQuery = true)
    void insertarCliente(@Param("idUsuario") Long idUsuario,
                         @Param("idTarjeta") Long idTarjeta);
}
