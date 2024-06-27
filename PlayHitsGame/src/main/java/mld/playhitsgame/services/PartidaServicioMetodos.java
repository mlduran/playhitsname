/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mld.playhitsgame.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import mld.playhitsgame.DAO.PartidaDAO;
import mld.playhitsgame.exemplars.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidaServicioMetodos implements PartidaServicio{
    
    @Autowired
    PartidaDAO DAO;

    @Override
    public List<Partida> findAll() {
        return DAO.findAll();
    }
        
   
        
    @Override
    public Optional<Partida> findById(Long id) {
        return DAO.findById(id);
        
    }

    @Override
    public Partida savePartida(Partida partida) {
        return DAO.save(partida);
    }

    @Override
    public Partida updatePartida(Long id, Partida partida) {
        Partida obj = DAO.findById(id).get();
        
        if(Objects.nonNull(partida.getStatus())){
            obj.setStatus(partida.getStatus());
        }
        
        if(Objects.nonNull(partida.getGenero())){
            obj.setGenero(partida.getGenero());
        }
        
        if(Objects.nonNull(partida.getPais())){
            obj.setPais(partida.getPais());
        } 
        
        if(Objects.nonNull(partida.getContexto()) && !"".equalsIgnoreCase(partida.getContexto())){
            obj.setContexto(partida.getContexto());
        }
        

        if(Objects.nonNull(partida.getGrupo()) && !"".equalsIgnoreCase(partida.getGrupo())){
            obj.setGrupo(partida.getGrupo());
        }
        
        if(Objects.nonNull(partida.getGanador()) && !"".equalsIgnoreCase(partida.getGanador())){
            obj.setGanador(partida.getGanador());
        }
        
        obj.setFecha(partida.getFecha());
        obj.setAnyoInicial(partida.getAnyoInicial());
        obj.setAnyoFinal(partida.getAnyoFinal());
        obj.setRondaActual(partida.getRondaActual());
        
        return DAO.save(obj);
    }

    @Override
    public void deletePartida(Long id) {
        DAO.deleteById(id);
    }    

    public Optional<Partida> partidaUsuarioMaster(Long idUsuario) {
        return DAO.partidaUsuarioMaster(idUsuario);
    }

  
  
 
}