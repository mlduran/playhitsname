/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mld.playhitsgame.exemplars;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 *
 * @author miguel
 */


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rondas")
public class Ronda{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int numero;
    private boolean completada;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Partida partida;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cancion cancion;
    
    @OneToMany(mappedBy = "ronda", fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

    public boolean estaCompletada(){
        
        return this.isCompletada();
        
    }
    

    
    
}


