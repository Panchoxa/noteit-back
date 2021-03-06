package com.creatorschool.noteit.api;

import com.creatorschool.noteit.api.viewmodel.FeedbackViewModel;
import com.creatorschool.noteit.mail.FeedbackSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/api/feedback")
public class FeedbackController {
    private FeedbackSender feedbackSender;
    public FeedbackController(FeedbackSender feedbackSender){
        this.feedbackSender = feedbackSender;
    }
    @PostMapping
    public void sendFeedback(@RequestBody FeedbackViewModel feedbackViewModel){
        log.info("Sending the feedback...");
        this.feedbackSender.sendFeedback(
                feedbackViewModel.getEmail(),
                feedbackViewModel.getName(),
                feedbackViewModel.getFeedback()
        );
    }
}
