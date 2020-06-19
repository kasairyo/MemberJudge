package jp.co.netprotections.dto;

public class MemberJudgeResponseDto {
	private String memberName;
	private boolean enlistedPropriety;

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setEnlistedPropriety(boolean enlistedPropriety) {
		this.enlistedPropriety = enlistedPropriety;
	}

	public String getMemberName() {
		return memberName;
	}

	public boolean isEnlistedPropriety() {
		return enlistedPropriety;
	}
}