package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Option;
import com.example.pollmaker.model.dto.OptionDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.pollmaker.utils.Util.isNull;

@Component
public class OptionMapper {

    public List<Option> StringToOption(List<String> options){
        if(isNull(options)){
            return null;
        }

        List<Option> optionList = new ArrayList<>();
        Option newOption;
        for (String option: options) {
            newOption = Option.builder()
                    .value(option)
                    .voteCount(0)
                    .build();

            optionList.add(newOption);
        }

        return optionList;
    }

    public List<OptionDTO> optionToOptionDTO(List<Option> options){

        OptionDTO optionDTO;
        List<OptionDTO> optionDTOList = new ArrayList<>();
        for (Option option: options) {
            optionDTO = OptionDTO.builder()
                    .id(option.getId())
                    .value(option.getValue())
                    .build();
            optionDTOList.add(optionDTO);
        }


        return optionDTOList;
    }


}
