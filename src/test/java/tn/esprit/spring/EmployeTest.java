package tn.esprit.spring;


import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeTest {
	
	public EmployeTest() {
		super();
	
	}


	    @Autowired
	    private EmployeServiceImpl employeService;

	    @Autowired
	    EntrepriseServiceImpl entrepriseService;
    private final  Logger l = LogManager.getLogger(EmployeTest.class);
    
    @Test
    public void ajoutEmploye() {
        Employe employe = new Employe();
        employe.setNom("nakachi");
        employe.setPrenom("malek");
        employe.setEmail("malek.nakachi@esprit.tn");
        employe.setPassword("malek123");
        employe.setRole(Role.CHEF_DEPARTEMENT);
        employe.setActif(true);
        employeService.ajouterEmploye(employe);
        
        l.info("l'employé est ajouté");
    }
    @Test
    public void getNombreEmploye() {
        int nombre = employeService.getNombreEmployeJPQL();
        
        l.info("nombre de employee"+nombre);
    }

    @Test
    public void deleteEmploye() {
    	Employe employe = new Employe("naka", "molka", "molka@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
     
        employeService.deleteEmployeById(employe.getId());
       
        l.info("L'employé est supprimé");
    }


  
}
