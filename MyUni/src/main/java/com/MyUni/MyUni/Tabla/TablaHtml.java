/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MyUni.MyUni.Tabla;

import com.MyUni.MyUni.Dao.ClienteDAO;
import com.MyUni.MyUni.Entidades.Cliente;
import com.MyUni.MyUni.Entidades.Proceso;
import java.lang.reflect.Field;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tocho
 */

public class TablaHtml {

    public String generarTabla(List<Cliente> clientes) {
        StringBuilder tabla = new StringBuilder();
        tabla.append("<table class=\"table\">\n");
        tabla.append("<thead class=\"thead-dark\">");
        tabla.append("<tr>");
        tabla.append("<th scope=\"col\">Código</th>");
        tabla.append("<th scope=\"col\">Foto</th>");
        tabla.append("<th scope=\"col\">Nombres</th>");
        tabla.append("<th scope=\"col\">Apellidos</th>");
        tabla.append("<th scope=\"col\">Ciudad</th>");
        tabla.append("<th scope=\"col\">Fecha de Nacimiento</th>");
        tabla.append("<th scope=\"col\">Celular</th>");
        tabla.append("<th scope=\"col\">Email</th>");
        tabla.append("<th scope=\"col\">Pasaporte</th>");
        tabla.append("<th scope=\"col\">Procesos</th>");
        tabla.append("<th scope=\"col\">LINKS</th>");
        tabla.append("</tr>");
        tabla.append("</thead>\n");

        for (Cliente cliente : clientes) {
            tabla.append("<tr>");
            tabla.append("<td>").append(cliente.getId()).append("</td>");
            tabla.append("<td>").append(cliente.getFoto()).append("</td>");
            tabla.append("<td>").append(cliente.getNombres()).append("</td>");
            tabla.append("<td>").append(cliente.getApellidos()).append("</td>");
            tabla.append("<td>").append(cliente.getCiudad()).append("</td>");
            tabla.append("<td>").append(cliente.getFechaNacimiento()).append("</td>");
            tabla.append("<td>").append(cliente.getCelular()).append("</td>");
            tabla.append("<td>").append(cliente.getEmail()).append("</td>");
            tabla.append("<td>").append(cliente.getPasaporte()).append("</td>");

            tabla.append("<td>");
            tabla.append("<select>");
            for (Proceso proceso : cliente.getProcesos()) {
                tabla.append("<option>").append(proceso).append("</option>");
            }
            tabla.append("</select>");
            tabla.append("</td>");

            tabla.append("<td>LINKS</td>");
            tabla.append("</tr>\n");
        }

        tabla.append("</table>\n");
        return tabla.toString();
    }

}
