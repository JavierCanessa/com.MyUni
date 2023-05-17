/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositorioInterfaz;

import Entidades.Cliente;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author tocho
 */


public interface I_ClienteDAO {
    void guardar (Cliente cliente);
    void eliminar (Cliente Cliente);
    
    List<Cliente> getlikeDesc( String desc );
    
    Cliente getCliente( int codCliente );
    
    List <Cliente>getAll();
    default List <Cliente> g ( Cliente c ){
        return getAll().stream().collect(Collectors.toList());
    }
    
    default Cliente getById( int codCliente ){
        return getAll()
                .stream()
                .filter(c -> c.getCod() == codCliente)
                .findFirst()
                .orElse(    new Cliente()  );
                
    }
}
