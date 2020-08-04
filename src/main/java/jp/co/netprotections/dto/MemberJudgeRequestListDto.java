package jp.co.netprotections.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;

/**
 * リクエスト情報に含まれる、候補者一覧の情報をまとめたDTOクラス
 * @author r.kasai
 */
public class MemberJudgeRequestListDto {
	@Getter
	@NotNull(message = "候補者リストがありません。所定の形式でリストを入力してください。")
	private List<MemberJudgeRequestDto> memberCandidatesList;

	public void setMemberCandidatesList(List<MemberJudgeRequestDto> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}
}
