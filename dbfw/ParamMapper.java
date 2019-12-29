package com.nttdata.petstore.dbfw;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ParamMapper {

	void mapParams(PreparedStatement preStmt) throws DBFWException,
			SQLException;
}
