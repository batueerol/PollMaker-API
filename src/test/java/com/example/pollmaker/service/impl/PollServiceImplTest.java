package com.example.pollmaker.service.impl;

import com.example.pollmaker.domain.Poll;
import com.example.pollmaker.mapper.PollMapper;
import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.repository.CustomPollRepository;
import com.example.pollmaker.repository.PollRepository;
import com.example.pollmaker.service.PollService;
import com.example.pollmaker.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PollServiceImplTest {

    private PollService pollService;

    @Mock
    PollMapper pollMapper;

    @Mock
    CustomPollRepository customPollRepository;

    @Mock
    PollRepository pollRepository;

    @BeforeEach
    void setUp() {
        pollService = new PollServiceImpl(pollMapper, customPollRepository, pollRepository);
    }

    @Test
    void createPoll() {
        CreatePollRequest createPollRequest = TestUtil.getCreatePollRequest();
        Poll poll = TestUtil.getPoll();
        PollDTO pollDTO = TestUtil.getPollDTO();

        Mockito.when(pollMapper.createPollRequestToPoll(ArgumentMatchers.any(CreatePollRequest.class))).thenReturn(poll);
        Mockito.when(pollRepository.insert(ArgumentMatchers.any(Poll.class))).thenReturn(poll);
        Mockito.when(pollMapper.pollToPollDto(ArgumentMatchers.any(Poll.class))).thenReturn(pollDTO);

        PollDTO result = pollService.createPoll(createPollRequest);

        Assertions.assertEquals(pollDTO.getTitle(), result.getTitle());
        Assertions.assertEquals(pollDTO.getOwnerName(), result.getOwnerName());
        Assertions.assertEquals(pollDTO.getOptions().get(0).getValue(), result.getOptions().get(0).getValue());
    }
}