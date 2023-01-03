package com.example.pollmaker.controller;


import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.service.PollService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/poll")
@Api(description = "Poll Controller for CRUD transactions")
public class PollController {

    private final PollService pollService;

    @PostMapping("/create")
    @ApiOperation(value = "Create Poll",notes = "This methods creates Poll Entity", httpMethod = "POST")
    public ResponseEntity<PollDTO> createPoll(@RequestBody CreatePollRequest createPollRequest){
        PollDTO pollDTO = pollService.createPoll(createPollRequest);

        return new ResponseEntity(pollDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{pollId}")
    @ApiOperation(value = "Update Poll", notes = "This methods updates Poll", httpMethod = "PUT")
    public ResponseEntity<PollDTO> updatePoll(@PathVariable String pollId, @RequestBody CreatePollRequest createPollRequest){
        PollDTO pollDTO = pollService.updatePoll(pollId, createPollRequest);

        return new ResponseEntity(pollDTO, HttpStatus.OK);
    }

   /* @GetMapping("/polls")
    public ResponseEntity<List<PollDTO>> getPolls(){
         return new ResponseEntity(pollService.getPolls(), HttpStatus.OK);
    }*/

}
