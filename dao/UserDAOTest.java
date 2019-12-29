package com.nttdata.petstore.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDAOTest {

	@Test
	

		public void testValidateUser() throws PetStoreDAOException {
			UserDAO dao1 = new UserDAO();
			boolean isTrue;
			isTrue = dao1.validateUser("2KL", "pass");
			assertEquals(true, isTrue);
	}

	

}
