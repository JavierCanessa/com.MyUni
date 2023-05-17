package Tests;

import Connectors.Connectors;
import Entidades.Cliente;
import Entidades.Procesos;
import RepositorioInterfaz.ClienteDAO;
import RepositorioInterfaz.I_ClienteDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRepositorios {
//I_EmpresasRepository a = new EmpresasRepository( new Connectors() );

    public static void main(String[] args) {
        // TODO code application logic here
        I_ClienteDAO cdao = new ClienteDAO(new Connectors());
        List<Procesos> procesosc1 = new ArrayList<>();
        procesosc1.add(Procesos.Precaria);
        procesosc1.add(Procesos.Compra_Pasajes_Aereos);
        procesosc1.add(Procesos.Pago_Boletas);
        procesosc1.add(Procesos.Recepción_Aeropuerto);

        Cliente c1 = new Cliente("Foto.jpg", "Javier", "Canessa", "Machala", "02/10/1993",
                1174558788, "jcanessa@gmail.com", 578877777,
                procesosc1);

        System.out.print("----------Este es el comienzo de la App Unistudent MyUni---------- \n");

        //System.out.print("Lista de Procesos: " + c1.getProcesos());
        cdao.guardar(c1);
        //cdao.getCliente(605258816);
        //System.out.println(cdao.getAll());
    }
}
