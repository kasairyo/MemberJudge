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

@RestController
public class MemberJudgeController {
	@RequestMapping(value = "/judge", method = {RequestMethod.POST})
	public Map<String, ArrayList<MemberJudgeRequestDto>> judgeMember(@RequestBody String candidates) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, ArrayList<MemberJudgeRequestDto>> resultList = new HashMap<String, ArrayList<MemberJudgeRequestDto>>();
		try { resultList = mapper.readValue(candidates, new TypeReference<Map<String, ArrayList<MemberJudgeRequestDto>>>() { });
		} catch (IOException e) {
		}
		return resultList;
	}
	@RequestMapping(value = "/judge", method = {RequestMethod.GET})
	public String test() {
		return "test";
	}
}
