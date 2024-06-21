/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mld.playhitsgame.DAO;


import java.util.Optional;
import mld.playhitsgame.exemplars.Partida;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author miguel
 */

public interface PartidaDAO extends JpaRepository<Partida, Long>{
    
    
    @Override
    Optional<Partida> findById(Long id);
    
    
}