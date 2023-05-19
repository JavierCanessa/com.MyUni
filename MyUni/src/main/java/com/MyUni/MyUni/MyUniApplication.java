package com.MyUni.MyUni;

import com.MyUni.MyUni.Dao.ClienteDAO;
import com.MyUni.MyUni.Entidades.Cliente;
import com.MyUni.MyUni.Entidades.Proceso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyUniApplication implements CommandLineRunner {

    @Autowired
    ClienteDAO cdao;

    public static void main(String[] args) {
        SpringApplication.run(MyUniApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("********** Bienvenido a MyUni **********");

        /*Creamos lista de procesos*/
//        List<Proceso> plista1 = new ArrayList<>();
//        plista1.add(Proceso.Precaria);
//        plista1.add(Proceso.Cita_DNI);
//        plista1.add(Proceso.Material_Estudio_CBC_Area_de_Salud);
//        plista1.add(Proceso.Convalidación_Titulo_Secundario); 
//        plista1.add(Proceso.Pago_Boletas);
//        plista1.add(Proceso.Recepción_Aeropuerto);
//        plista1.add(Proceso.Reserva_Alojamiento);
//
//        Cliente c = new Cliente();
//        c.setFoto("fotoCoti.jpg");
//        c.setNombres("Constanza");
//        c.setApellidos("Zorzi");
//        c.setCiudad("Concordia");
//        c.setFechaNacimiento("02/06/1994");
//        c.setCelular(1588789666);
//        c.setEmail("Cotizz@gmail.com");
//        c.setPasaporte(586888971);
//        c.setProcesos(plista1);
//         cdao.save(c);
//        System.out.println("Cliente que se guardo: " + c.toString());
//        List<Proceso> plista1 = new ArrayList<>();
//        plista1.add(Proceso.Precaria);
//        plista1.add(Proceso.Cita_DNI);
//        plista1.add(Proceso.Material_Estudio_CBC_Area_de_Salud);
//        plista1.add(Proceso.Convalidación_Titulo_Secundario);
//        plista1.add(Proceso.Pago_Boletas);
//        plista1.add(Proceso.Recepción_Aeropuerto);
//        plista1.add(Proceso.Reserva_Alojamiento);
//        plista1.add(Proceso.Busqueda_Laboral);
//
//        Cliente c = new Cliente();
//        c.setFoto("fotoCLaudia.jpg");
//        c.setNombres("Claudia");
//        c.setApellidos("Cando");
//        c.setCiudad("Pasaje");
//        c.setFechaNacimiento("02/06/1994");
//        c.setCelular(165418696);
//        c.setEmail("Clamelia2@hotmail.com");
//        c.setPasaporte(58698971);
//        c.setProcesos(plista1);
//        cdao.save(c);


       // System.out.println( cdao.findById(799949785).orElse(null).getProcesos() );
        //System.out.println(cdao.findAll());
    }

}