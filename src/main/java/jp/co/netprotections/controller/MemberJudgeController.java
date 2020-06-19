package jp.co.netprotections.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberJudgeController {
	@RequestMapping(value = "/judge", method = {RequestMethod.POST})
	public String judgeMember(@RequestBody String json) {
		return json;
	}
	@RequestMapping(value = "/judge", method = {RequestMethod.GET})
	public String test() {
		return "test";
	}
}
