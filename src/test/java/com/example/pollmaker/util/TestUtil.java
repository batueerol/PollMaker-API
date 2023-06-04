package com.example.pollmaker.util;

import com.example.pollmaker.domain.Option;
import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.model.dto.OptionDTO;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static CreatePollRequest getCreatePollRequest(){
        List<String> options = new ArrayList<>();
        options.add("TestOption1");

        return CreatePollRequest.builder()
                .title("Test Title")
                .options(options)
                .build();
    }

    public static List<String> getOptionListForStringToOptionTest() {
        List<String> optionStringTypeList = new ArrayList<>();
        optionStringTypeList.add("TestOption1");
        return optionStringTypeList;
    }

    public static Poll getPoll() {
        List<Option> options = getOptionList();

        Poll poll = Poll.builder()
                .id("id")
                .title("Test Title")
                .options(options)
                .ownerName("admin")
                .createdAt(LocalDateTime.now())
                .build();
        return poll;
    }

    public static List<Option> getOptionList() {
        List<Option> options = new ArrayList<>();
        Option option = Option.builder()
                .id("id")
                .value("TestOption1")
                .voteCount(0)
                .build();
        options.add(option);
        return options;
    }

    public static List<OptionDTO> getOptionDTOList() {
        List<OptionDTO> optionDTOList = new ArrayList<>();
        OptionDTO optionDTO = OptionDTO.builder()
                .id("id")
                .value("TestOption1")
                .build();
        optionDTOList.add(optionDTO);
        return optionDTOList;
    }

    public static PollDTO getPollDTO() {
        List<OptionDTO> optionsDTOList = getOptionDTOList();
        PollDTO pollDTO = PollDTO.builder()
                .title("Test Title")
                .options(optionsDTOList)
                .ownerName("admin")
                .build();
        return pollDTO;
    }
}
