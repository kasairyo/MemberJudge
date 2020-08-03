package jp.co.netprotections.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.MemberJudgeRequestListDto;
import jp.co.netprotections.dto.MemberJudgeResponseListDto;
import jp.co.netprotections.service.MemberJudgeService;

@RestController
public class MemberJudgeController {
	@Autowired
	private MemberJudgeService memberJudgeService;

	@RequestMapping(value = "/judge", method = {RequestMethod.POST})
	public MemberJudgeResponseListDto judgeMember(@RequestBody @Valid MemberJudgeRequestListDto requestedList) {
		return memberJudgeService.judgeCandidates(requestedList);
	}
}
