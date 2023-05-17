/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidad.tabla;

import Connectors.Connectors;
import Entidades.Cliente;
import RepositorioInterfaz.ClienteDAO;
import java.util.List;

/**
 *
 * @author tocho
 */
public class TablaHtml {

    public String generarTabla() {
        ClienteDAO cdao = new ClienteDAO(new Connectors());
        List<Cliente> clientes = cdao.getAll();

        StringBuilder tabla = new StringBuilder();
        tabla.append("<table class=\"table\">\n");
        tabla.append("<thead class=`thead-dark`>"
                + "<tr>"
                + "<th scope=\"col\" >Código</th>"
                + "<th scope=\"col\" >Foto</th>"
                + "<th scope=\"col\" >Nombres</th>"
                + "<th scope=\"col\" >Apellidos</th>"
                + "<th scope=\"col\" >Ciudad</th>"
                + "<th scope=\"col\" >Fecha de Nacimiento</th>"
                + "<th scope=\"col\" >Celular</th>"
                + "<th scope=\"col\" >Email</th>"
                + "<th scope=\"col\">Pasaporte</th>"
                + "<th scope=\"col\">Procesos</th>"
                + "<th scope=\"col\">LINKS</th>"
                + "</tr>"
                + "</thead>\n");

        for (Cliente cliente : clientes) {
            tabla.append("<tr>");
            tabla.append("<td>").append(cliente.getCod()).append("</td>");
            tabla.append("<td>").append(cliente.getFoto()).append("</td>");
            tabla.append("<td>").append(cliente.getNombres()).append("</td>");
            tabla.append("<td>").append(cliente.getApellidos()).append("</td>");
            tabla.append("<td>").append(cliente.getCiudad()).append("</td>");
            tabla.append("<td>").append(cliente.getFechaNacimiento()).append("</td>");
            tabla.append("<td>").append(cliente.getCelular()).append("</td>");
            tabla.append("<td>").append(cliente.getEmail()).append("</td>");
            tabla.append("<td>").append(cliente.getPasaporte()).append("</td>");
            tabla.append("<td>").append(cliente.getProcesos()).append("</td>");
            tabla.append("</tr>\n");
        }

        tabla.append("</table>\n");
        return tabla.toString();
    }

}
