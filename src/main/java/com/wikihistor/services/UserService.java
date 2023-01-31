package com.wikihistor.services;

import com.wikihistor.mapping.WikiuserDTO;
import com.wikihistor.mapping.WikiuserMapper;
import com.wikihistor.models.Wikiuser;
import com.wikihistor.repositories.WikiuserRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@RequiredArgsConstructor
public class UserService {
    @NonNull
    private final WikiuserRepository wikiuserRepository;
    private final WikiuserMapper wikiuserMapper = new WikiuserMapper();

    public void saveUser(Wikiuser wikiuser){
        this.wikiuserRepository.save(wikiuser);
    }

    public List<WikiuserDTO> getUsersDTO(){
        return wikiuserRepository.findAll().stream().map(wikiuserMapper::mapToDTO).toList();
    }



}
