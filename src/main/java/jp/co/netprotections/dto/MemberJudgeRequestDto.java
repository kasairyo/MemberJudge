package jp.co.netprotections.dto;

import javax.validation.constraints.NotNull;

import jp.co.netprotections.constants.MemberJudgeConstants;
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
	@NotNull(message = MemberJudgeConstants.ERROR_NO_NAME)
	private String memberName;

	@NotNull(message = MemberJudgeConstants.ERROR_NO_EVENT_PLANNING)
	private int eventPlanning;

	@NotNull(message = MemberJudgeConstants.ERROR_NO_COGITATION)
	private int cogitation;

	@NotNull(message = MemberJudgeConstants.ERROR_NO_COODINATION)
	private int coodination;

	@NotNull(message = MemberJudgeConstants.ERROR_NO_PROGRAMMING_ABILITY)
	private int programmingAbility;

	@NotNull(message = MemberJudgeConstants.ERROR_NO_INFRASTRUCTURE_KNOWLEDGE)
	private int infrastructureKnowledge;
}
