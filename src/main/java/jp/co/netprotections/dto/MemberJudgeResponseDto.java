package jp.co.netprotections.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * レスポンスに含まれる、候補者個人の評価結果情報をまとめたDTOクラス
 * @author r.kasai
 */
@Component
public class MemberJudgeResponseDto {
	private String memberName;
	private boolean enlistedPropriety;
	private ArrayList<String> errorList;

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

	public ArrayList<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(ArrayList<String> errorList) {
		this.errorList = errorList;
	}
}
