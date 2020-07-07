package jp.co.netprotections.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

@RestController
public class MemberJudgeController {
	@RequestMapping(value = "/judge", method = {RequestMethod.POST})
	public Map<String, ArrayList<MemberJudgeResponseDto>> judgeMember(@RequestBody String requestBody) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, ArrayList<MemberJudgeRequestDto>> requestedList = new HashMap<String, ArrayList<MemberJudgeRequestDto>>();
		try {
			requestedList = mapper.readValue(requestBody, new TypeReference<Map<String, ArrayList<MemberJudgeRequestDto>>>() { });
		} catch (IOException e) {
			e.printStackTrace();
		}
		return MemberJudgeService.judgeCandidates(requestedList);
	}
}
