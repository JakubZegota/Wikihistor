package com.wikihistor.mapping.mappers;

public interface IMapEntities<TDTO, TENTITY> {
    TENTITY mapToEntity(TDTO dto);

    TENTITY mapToEntity(TDTO dto, TENTITY tentity);

    TDTO mapToDTO(TENTITY tentity);

    TDTO mapToDTO(TENTITY tentity, TDTO dto);
}
