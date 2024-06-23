/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mld.playhitsgame.services;

import java.util.List;
import java.util.Optional;
import mld.playhitsgame.exemplars.Usuario;
import mld.playhitsgame.projections.ampliada.UsuarioAmpliadaView;



/**
 *
 * @author miguel
 */
public interface UsuarioServicio {
    
    List<Usuario> findAll();   
  
    List<UsuarioAmpliadaView> findBy();
    
    Optional<Usuario> usuarioLogin(String usuario, String contrasenya);
    List<Usuario> usuariosGrupo(String grupo);
    
    //Optional<Cancion> findCancionById(Long id); //si retorna solo 1 reg, sino poner list
    Optional<Usuario> findById(Long id);
    
    Usuario saveUsuario(Usuario usuario);    
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
    
    
}
