package com.wikihistor.repositories;

import com.wikihistor.models.Wikiuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiuserRepository extends JpaRepository<Wikiuser,String> {

}
