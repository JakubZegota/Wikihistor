package com.wikihistor.repositories;

import com.wikihistor.models.Wikiuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WikiuserRepository extends JpaRepository<Wikiuser,String> {
    Optional<Wikiuser> findWikiuserByLoginAndPassword(String login, String password);
}
