package jp.co.netprotections.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemberJudgeResponseListDto {
	public List<MemberJudgeResponseDto> getJudgedCandidatesResultList() {
		return judgedCandidatesResultList;
	}

	public void setJudgedCandidatesResultList(List<MemberJudgeResponseDto> judgedCandidatesResultList) {
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}

	private List<MemberJudgeResponseDto> judgedCandidatesResultList;

}
