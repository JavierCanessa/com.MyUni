package com.unistudent.unistudentoficina;

import DAO.ClienteDAO;
import Entidades.Cliente;
import Entidades.Procesos;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("DAO")
public class UnistudentoficinaApplication implements CommandLineRunner{
    
    @Autowired
    ClienteDAO cdao;


    public static void main(String[] args) {
        SpringApplication.run(UnistudentoficinaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        Cliente c1 = new Cliente("Foto1", "Javier Freddy", "Canessa Mautong", "Machala", "02/10/1993", 1122538411, "asdasdasd@asddfasd.com", 0705005700,
                Arrays.asList(Procesos.enumProcesos.Grupo_de_Whatsapp,
                        Procesos.enumProcesos.Cita_DNI));

        System.out.println("-----------Unistudent Spring----------");
        System.out.println(c1.toString());
        
        //cdao.save(c1);
    }

}
