package com.example.pollmaker.controller;



import com.example.pollmaker.model.dto.PollDTO;
import com.example.pollmaker.model.poll.CreatePollRequest;
import com.example.pollmaker.model.poll.VoteRequest;
import com.example.pollmaker.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@AllArgsConstructor
@RestController
@RequestMapping("/api/poll")
public class PollController {

    private final PollService pollService;

    @PostMapping("/create")
    public ResponseEntity<PollDTO> createPoll(@RequestBody CreatePollRequest createPollRequest){
        PollDTO pollDTO = pollService.createPoll(createPollRequest);

        return ResponseEntity.ok(pollDTO);
                //new ResponseEntity(pollDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{pollId}")
    public ResponseEntity<PollDTO> updatePoll(@PathVariable String pollId, @RequestBody CreatePollRequest createPollRequest){
        PollDTO pollDTO = pollService.updatePoll(pollId, createPollRequest);

        return new ResponseEntity<>(pollDTO, HttpStatus.OK);
    }

    @PutMapping("/vote/{pollId}")
    public ResponseEntity<PollDTO> vote(@PathVariable String pollId, @RequestBody VoteRequest voteRequest){
        return ResponseEntity.ok(pollService.vote(pollId, voteRequest));
    }

   @GetMapping("/get/polls")
    public ResponseEntity<Page<PollDTO>> getPolls(Pageable pageable){
         return ResponseEntity.ok(pollService.getPolls(pageable));
    }

    @GetMapping("/get/{pollId}")
    public ResponseEntity<PollDTO> getOnePoll(@PathVariable String pollId){
        return ResponseEntity.ok(pollService.getOnePoll(pollId));
    }
}
