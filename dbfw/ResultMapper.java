package com.nttdata.petstore.dbfw;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper {

	Object mapRow(ResultSet resSet) throws DBFWException, SQLException;
}
