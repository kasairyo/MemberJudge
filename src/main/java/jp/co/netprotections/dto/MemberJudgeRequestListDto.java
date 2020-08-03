package jp.co.netprotections.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * リクエスト情報に含まれる、候補者一覧の情報をまとめたDTOクラス
 * @author r.kasai
 */
@Component
public class MemberJudgeRequestListDto {
	private List<MemberJudgeRequestDto> memberCandidatesList;

	public List<MemberJudgeRequestDto> getMemberCandidatesList() {
		return memberCandidatesList;
	}

	public void setMemberCandidatesList(List<MemberJudgeRequestDto> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}
}
