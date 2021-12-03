package tn.esprit.spring;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;

import tn.esprit.spring.services.TimesheetServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimesheetTest {

	public TimesheetTest() {
		super();
	}
	
    @Autowired
    private TimesheetServiceImpl timesheetService;
    

    private final static Logger logger = LogManager.getLogger(TimesheetTest.class);
    
    @Test
    public void testAjouterMission() {
    	logger.info("Creation d'une mission");
		logger.debug("ajout mission a commencé .");
       Mission mission = new Mission();
       mission.setName("mission1");
       mission.setDescription("MissionImposible");
     timesheetService.ajouterMission(mission);
     assertEquals("mission1", mission.getName());
        
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method execution time: " + elapsedTime + " milliseconds.");
        logger.info("Mission est ajoutée");
    }
    
  
   
	
	@Test
	public void testgetAllEmployeByMission(){
		logger.info("dans testgetAllEmployeByMission ");
		logger.debug("testgetAllEmployeByMission a commencé .");
		List<Employe> employees = timesheetService.getAllEmployeByMission(1);
		assertTrue(employees.size()<10);
		long start = System.currentTimeMillis();
	     long elapsedTime = System.currentTimeMillis() - start;
	     logger.info("Method execution time: " + elapsedTime + " milliseconds.");
	     logger.info("Timesheet est ajoutée");
		
	}
    
}


