package com.biswa.daos;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biswa.entities.*;

@Repository
public interface CountryDao extends CrudRepository<Country, Integer> {
	@Query(value = "SELECT * FROM Country", nativeQuery = true)
	Collection<Country> findAllActiveUsersNative();
}
