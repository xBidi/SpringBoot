/* Autogenerated file. Do not edit manually. */

package com.diegotobalina.framework.customizable.entities.example.domain;

import com.diegotobalina.framework.core.crud.StaffitMapper;
import com.diegotobalina.framework.customizable.entities.example.infrastructure.controller.dto.input.ExampleInputDTO;
import com.diegotobalina.framework.customizable.entities.example.infrastructure.controller.dto.output.BaseExampleOutputDTO;
import com.diegotobalina.framework.customizable.entities.example.infrastructure.controller.dto.output.ExampleOutputDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ExampleMapper extends StaffitMapper<Example, ExampleInputDTO, BaseExampleOutputDTO, ExampleOutputDTO> {
    default Example getEntityInstance() {
        return new Example();
    }

    default BaseExampleOutputDTO getBaseOutputDTOInstance() {
        return new BaseExampleOutputDTO();
    }

    default ExampleOutputDTO getOutputDTOInstance() {
        return new ExampleOutputDTO();
    }
}
