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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
        
//        List<Proceso> plista1 = new ArrayList<>() ;
//        plista1.add(Proceso.Precaria);
//        plista1.add(Proceso.Cita_DNI);
//        plista1.add(Proceso.Material_Estudio_CBC_Area_de_Salud);
//        plista1.add(Proceso.Convalidación_Titulo_Secundario); 
//        plista1.add(Proceso.Pago_Boletas);
//        
//        Cliente c = new Cliente();
//        c.setFoto("fotoTocho.jpg");
//        c.setNombres("Tocho");
//        c.setApellidos("Canessa");
//        c.setCiudad("Machala");
//        c.setFechaNacimiento("02/10/1993");
//        c.setCelular(1122538411);
//        c.setEmail("jcanessa@gmail.com");
//        c.setPasaporte(0705005700);
//        c.setProcesos(plista1);
        
//        System.out.println("Cliente que se guardo: " + c.toString());
//        cdao.save(c);

       // System.out.println("Desde Base de Datos : " + cdao.findAll());

        
       System.out.println(cdao.findById(1914026983).toString());
    }

}
