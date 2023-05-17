/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositorioInterfaz;

import Connectors.Connectors;
import Entidades.Cliente;
import Entidades.Procesos;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tocho
 */
public class ClienteDAO implements I_ClienteDAO {

    private Connectors connectors;

    public ClienteDAO(Connectors connectors) {

    }

    @Override
    public void guardar(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        try {
            PreparedStatement ps = new Connectors().getConnection().prepareStatement(
                    "insert into clientes ( \n"
                    + "cod, \n"
                    + "foto,\n"
                    + "nombres,\n"
                    + "apellidos,\n"
                    + "ciudad,\n"
                    + "fechaNacimiento,\n"
                    + "celular,\n"
                    + "email,\n"
                    + "pasaporte,\n"
                    + "procesos \n"
                    + ") \n"
                    + "values (?,?,?,?,?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            {
                ps.setInt(1, cliente.getCod());
                ps.setString(2, cliente.getFoto());
                ps.setString(3, cliente.getNombres());
                ps.setString(4, cliente.getApellidos());
                ps.setString(5, cliente.getCiudad());
                ps.setString(6, cliente.getFechaNacimiento());
                ps.setLong(7, cliente.getCelular());
                ps.setString(8, cliente.getEmail());
                ps.setLong(9, cliente.getPasaporte());
                ps.setString(10, cliente.getProcesos().toString());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        try (PreparedStatement ps = new Connectors().getConnection().prepareStatement(
                "delete from listaclientes where cod = ? ")) {
            ps.setInt(1, cliente.getCod());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> getlikeDesc(String desc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente getCliente(int codCliente) {
        Cliente cliente = null;
        try (ResultSet rs = new Connectors().getConnection().createStatement().executeQuery(
                "select cod,foto,nombres,apellidos,ciudad,fechaNacimiento,"
                        + "celular,email,pasaporte,procesos"
                        + "from listaclientes where cod = " + "'"+codCliente+"'")) {
            if (rs.next()) {
                List<Procesos> procesosList = new ArrayList<>();
                cliente = new Cliente(
                        rs.getInt("cod"),
                        rs.getString("foto"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("ciudad"),
                        rs.getString("fechaNacimiento"),
                        rs.getLong("celular"),
                        rs.getString("email"),
                        rs.getLong("pasaporte"),
                        procesosList
            
            );
            }
            System.out.println("No se encontro nada, estoy en el DAO el cliente con codigo : " + codCliente);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public List<Cliente> getAll() {

        ArrayList<Cliente> clienteArray = new ArrayList<>();
        Cliente cliente = null;
        try (ResultSet rs = new Connectors().getConnection().createStatement().executeQuery(
                "select * from listaclientes ")) {
            while (rs.next()) {
                List<Procesos> procesosList = new ArrayList<>();
                Cliente c1 = new Cliente(
                        rs.getInt("cod"),
                        rs.getString("foto"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("ciudad"),
                        rs.getString("fechaNacimiento"),
                        rs.getLong("celular"),
                        rs.getString("email"),
                        rs.getLong("pasaporte"),
                        procesosList
                );
                clienteArray.add(c1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clienteArray;

    }

}
