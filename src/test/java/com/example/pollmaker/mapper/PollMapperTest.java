package com.example.pollmaker.mapper;

import com.example.pollmaker.domain.Option;
import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PollMapperTest {

    private PollMapper pollMapper;

    @Mock
    OptionMapper optionMapper;

    @BeforeEach
    void setUp(){
        pollMapper = new PollMapper(optionMapper);
    }

    @Test
    void createPollRequestToPoll_WhenCreatePollRequestIsNull_ReturnNull() {
        Poll result = pollMapper.CreatePollRequestToPoll(null);
        Assertions.assertNull(result);
    }

    @Test
    void createPollRequestToPoll_WhenCreatePollRequestIsValid_ReturnPoll() {
        CreatePollRequest createPollRequest = TestUtil.getCreatePollRequest();
        List<Option> options = new ArrayList<>();
        options.add(Option.builder().value(createPollRequest.getOptions().get(0)).build());

        Mockito.when(optionMapper.StringToOption(ArgumentMatchers.any(List.class))).thenReturn(options);
        Poll result = pollMapper.CreatePollRequestToPoll(createPollRequest);

        Assertions.assertEquals("admin", result.getOwnerName());
        Assertions.assertEquals(createPollRequest.getTitle(), result.getTitle());
        Assertions.assertEquals(createPollRequest.getOptions().size(), result.getOptions().size());
        Assertions.assertEquals(createPollRequest.getOptions().get(0), result.getOptions().get(0).getValue());
    }

    @Test
    void pollToPollDto() {
    }
}