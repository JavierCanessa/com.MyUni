/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MyUni.MyUni.Controller;

import com.MyUni.MyUni.Dao.ClienteDAO;
import com.MyUni.MyUni.Entidades.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tocho
 */
@RestController
@RequestMapping(path="/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteDAO cdao;
    
    @GetMapping( "/all" )
    public List<Cliente> all(){
        return cdao.findAll();
    }
    
    @GetMapping("busqueda/{id}")
    public Optional<Cliente> busquedaId( @PathVariable int id ){
        return cdao.findById(id);
    }
    
    @GetMapping("eliminar/{id}")
    public String eliminar( @PathVariable int id ){
        cdao.deleteById(id);
        return "id : " + id + " " + "eliminado";
    }
    
}
