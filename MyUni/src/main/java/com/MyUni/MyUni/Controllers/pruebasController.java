/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MyUni.MyUni.Controllers;

import com.MyUni.MyUni.Dao.ClienteDAO;
import com.MyUni.MyUni.Entidades.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 *
 * @author tocho
 */
@Controller
public class pruebasController {

    @Autowired
    private ClienteDAO clienteDAO;

    @RequestMapping("/pruebas")
    public String ingresoAdmin(Model model) {
        List<Cliente> clientes = clienteDAO.findAll();
        model.addAttribute("clienteDAO", clienteDAO); // Agrega el objeto clienteDAO al modelo
        model.addAttribute("clientes", clientes);
        return "pruebas";
    }

}
