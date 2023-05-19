/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MyUni.MyUni.Dao;

import com.MyUni.MyUni.Entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tocho
 */
public interface ClienteDAO  extends JpaRepository<Cliente, Integer> {
    
}
