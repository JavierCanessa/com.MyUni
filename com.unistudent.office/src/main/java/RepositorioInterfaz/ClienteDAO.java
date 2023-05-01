/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositorioInterfaz;

import Entidades.Cliente;


/**
 *
 * @author tocho
 */


public interface ClienteDAO {
    void guardar (Cliente cliente);
    void eliminar (Cliente cliente);
}
