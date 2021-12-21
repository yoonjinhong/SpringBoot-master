package com.example.springboot.api.service.reply;

import com.example.springboot.api.mapper.reply.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {
	private final ReplyMapper replyMapper;
}
