package com.example.pollmaker.controller;


import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/poll")
public class PollController {

    private final PollService pollService;

    @PostMapping("/create-poll")
    public ResponseEntity<PollDTO> createPoll(@RequestBody CreatePollRequest createPollRequest){
        PollDTO pollDTO = pollService.createPoll(createPollRequest);
        return new ResponseEntity(pollDTO, HttpStatus.OK);
    }
}
