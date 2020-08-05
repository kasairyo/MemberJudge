package jp.co.netprotections.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *リクエストに含まれる、候補者個人の情報をまとめたDTOクラス
 * @author r.kasai
 */
@Getter
@Setter
@Builder
public class MemberJudgeRequestDto {
	private String memberName;

	private int eventPlanning;

	private int cogitation;

	private int coodination;

	private int programmingAbility;

	private int infrastructureKnowledge;
}
