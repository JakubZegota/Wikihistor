package com.wikihistor.mapping;

public interface IMapEntities <TDTO, TENTITY>{
    TENTITY mapToEntity(TDTO dto); //creates an Entity object from DTO object data
    TENTITY mapToEntity(TDTO dto, TENTITY tentity); //maps DTO->Entity on already existing objects

    TDTO mapToDTO(TENTITY tentity); //creates an DTO object from Entity object data
    TDTO mapToDTO(TENTITY tentity, TDTO dto); //maps Entity->DTO on already existing objects
}
