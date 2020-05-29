package com.briller.Mapper;

import com.briller.Model.general;
import com.briller.Model.generalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * This is Mapper class related to map struct concept which map's the dto and the original class.
 */

@Mapper
public interface generalMapper {
    generalMapper i=Mappers.getMapper(generalMapper.class);
    generalDTO generaltoGeneralDTO(general g);
}
