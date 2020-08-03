package jp.co.netprotections.service;

import jp.co.netprotections.dto.MemberJudgeRequestListDto;
import jp.co.netprotections.dto.MemberJudgeResponseListDto;

public interface MemberJudgeService {
	public MemberJudgeResponseListDto judgeCandidates(MemberJudgeRequestListDto requestedList) ;
}
