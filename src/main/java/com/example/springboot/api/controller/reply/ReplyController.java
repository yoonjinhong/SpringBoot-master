package com.example.springboot.api.controller.reply;

import com.example.springboot.api.service.reply.ReplyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {
	private final ReplyService replyService;
}
