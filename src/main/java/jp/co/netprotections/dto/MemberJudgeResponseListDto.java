package jp.co.netprotections.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * レスポンスに含まれる、候補者一覧のの評価結果情報をまとめたDTOクラス
 * @author r.kasai
 */
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
