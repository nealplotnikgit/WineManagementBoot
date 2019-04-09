package com.plotnik.winecellar.management.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.plotnik.winecellar.management.model.Wine;

public class WineRowMapper implements RowMapper<Wine> {

	@Override
	public Wine mapRow(ResultSet rs,int row) throws SQLException {
		Wine result = new Wine();
		result.setUpc(rs.getBigDecimal("upc").longValue());
		//TODO add other columns
		return result;
		

	}

}
