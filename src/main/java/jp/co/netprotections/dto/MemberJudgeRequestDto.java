package jp.co.netprotections.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MemberJudgeRequestDto {
	@NotNull(message = "候補者名を入力してください。")
	private String memberName;

	@NotNull(message = "イベント企画力を入力してください")
	@Min(value = 0, message = "イベント企画力の点数が0を下回っています。0〜5で入力してください。")
	@Max(value = 5, message = "イベント企画力の点数が5を上回っています。0〜5で入力してください。")
	private int eventPlanning;

	@NotNull(message = "思考力を入力してください。")
	@Min(value = 0, message = "思考力の点数が0を下回っています。0〜5で入力してください。")
	@Max(value = 5, message = "思考力の点数が5を上回っています。0〜5で入力してください。")
	private int cogitation;

	@NotNull(message = "調整力を入力してください。")
	@Min(value = 0, message = "調整力の点数が0を下回っています。0〜5で入力してください。")
	@Max(value = 5, message = "調整力の点数が5を上回っています。0〜5で入力してください。")
	private int coodination;

	@NotNull(message = "プログラム製造力を入力してください。")
	@Min(value = 0, message = "プログラム製造力の点数が0を下回っています。0〜5で入力してください。")
	@Max(value = 5, message = "プログラム製造力の点数が5を上回っています。0〜5で入力してください。")
	private int programmingAbility;

	@NotNull(message = "基盤理解を入力してください。")
	@Min(value = 0, message = "基盤理解の点数が0を下回っています。0〜5で入力してください。")
	@Max(value = 5, message = "基盤理解の点数が5を上回っています。0〜5で入力してください。")
	private int infrastructureKnowledge;

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getEventPlanning() {
		return eventPlanning;
	}
	public void setEventPlanning(int eventPlanning) {
		this.eventPlanning = eventPlanning;
	}
	public int getCogitation() {
		return cogitation;
	}
	public void setCogitation(int cogitation) {
		this.cogitation = cogitation;
	}
	public int getCoodination() {
		return coodination;
	}
	public void setCoodination(int coodination) {
		this.coodination = coodination;
	}
	public int getProgrammingAbility() {
		return programmingAbility;
	}
	public void setProgrammingAbility(int programmingAbility) {
		this.programmingAbility = programmingAbility;
	}
	public int getInfrastructureKnowledge() {
		return infrastructureKnowledge;
	}
	public void setInfrastructureKnowledge(int infrastructureKnowledge) {
		this.infrastructureKnowledge = infrastructureKnowledge;
	}
}
