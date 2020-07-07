package jp.co.netprotections.dto;

public class MemberJudgeResponseDto {
	private String memberName;
	private boolean enlistedPropriety;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public boolean isEnlistedPropriety() {
		return enlistedPropriety;
	}

	public void setEnlistedPropriety(boolean enlistedPropriety) {
		this.enlistedPropriety = enlistedPropriety;
	}
}
