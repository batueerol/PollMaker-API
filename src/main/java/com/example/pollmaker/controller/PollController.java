package com.example.pollmaker.controller;


import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/poll")
public class PollController {

    private final PollService pollService;

    @PostMapping("/create")
    public ResponseEntity<PollDTO> createPoll(@RequestBody CreatePollRequest createPollRequest){
        PollDTO pollDTO = pollService.createPoll(createPollRequest);

        return new ResponseEntity(pollDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{pollId}")
    public ResponseEntity<PollDTO> updatePoll(@PathVariable String pollId, @RequestBody CreatePollRequest createPollRequest){
        PollDTO pollDTO = pollService.updatePoll(pollId, createPollRequest);

        return new ResponseEntity(pollDTO, HttpStatus.OK);
    }

   /* @GetMapping("/polls")
    public ResponseEntity<List<PollDTO>> getPolls(){
         return new ResponseEntity(pollService.getPolls(), HttpStatus.OK);
    }*/

}
