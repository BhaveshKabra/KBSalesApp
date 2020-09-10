package org.bhavesh.kbsales;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class KbSalesAppApplicationTest {

	@Autowired
	ApplicationContext appcontext;
	
	@Test
	void contextLoads() {
		assertNotNull(appcontext.getBean(KbSalesAppApplication.class));
	}

}
