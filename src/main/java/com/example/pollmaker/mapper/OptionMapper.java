package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Option;
import com.example.pollmaker.model.dto.OptionDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.pollmaker.utils.Util.isNull;

@Component
public class OptionMapper {
//list string to list object dönüştüren lambda fonks
    public List<Option> StringToOption(List<String> options){
        if(isNull(options)){
            return null;
        }

        List<Option> optionList = new ArrayList<>();

        options.forEach(option -> optionList.add(Option.builder()
                                    .value(option)
                                    .voteCount(0)
                                    .build()));

        return optionList;
    }

    public List<OptionDTO> optionToOptionDTO(List<Option> options){

        List<OptionDTO> optionDTOList = new ArrayList<>();
        options.forEach(option -> optionDTOList.add(OptionDTO.builder()
                                                            .id(option.getId())
                                                            .value(option.getValue())
                                                            .build()));

        return optionDTOList;
    }


}
