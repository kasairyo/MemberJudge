package jp.co.netprotections.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.netprotections.dto.MemberJudgeRequestDto;

@Component
public class MemberJudgeServiceImpl {
	// スコアが不正な場合、エラーメッセージを返す
	@Autowired
	public static ArrayList<String> validateScore(MemberJudgeRequestDto candidate) {
		ArrayList<String> errorList = new ArrayList<String>();
		if (candidate.getEventPlanning() < 0
			|| candidate.getEventPlanning() > 5) {
			errorList.add("eventPlanningは0~5の整数値を入力してください。");
		}
		if(candidate.getCogitation() < 0
			|| candidate.getCogitation() > 5) {
			errorList.add("cogitationは0~5の整数値を入力してください。");
		}
		if(candidate.getCoodination() < 0
			|| candidate.getCoodination() > 5) {
			errorList.add("coodinationは0~5の整数値を入力してください。");
		}
		if(candidate.getProgrammingAbility() < 0
			|| candidate.getProgrammingAbility() > 5) {
			errorList.add("programmingAbilityは0~5の整数値を入力してください。");
		}
		if(candidate.getInfrastructureKnowledge() < 0
			|| candidate.getInfrastructureKnowledge() > 5) {
			errorList.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		}
		return errorList;
	}

	// イベント企画力が1以下ならfalse、それ以外ならtrueを返す
	@Autowired
	public static boolean isWellEventPlanning(MemberJudgeRequestDto candidate) {
		if (candidate.getEventPlanning() <= 1) {
			return false;
		} else {
			return true;
		}
	}

	// 思考力が1以下ならfalse、それ以外ならtrueを返す
	@Autowired
	public static boolean isWellCogitation(MemberJudgeRequestDto candidate) {
		if (candidate.getCogitation() <= 1) {
			return false;
		} else {
			return true;
		}
	}

	// 調整力が1以下ならfalse、それ以外ならtrueを返す
	@Autowired
	public static boolean isWellCoodination(MemberJudgeRequestDto candidate) {
		if (candidate.getCoodination() <= 1) {
			return false;
		} else {
			return true;
		}
	}

	// 候補者の合計得点を算出する
	@Autowired
	public static boolean isOverPassingScore(MemberJudgeRequestDto candidate, int passingScore) {
		int totalScore = 0;
		totalScore += candidate.getEventPlanning();
		totalScore += candidate.getCogitation();
		totalScore += candidate.getCoodination();
		totalScore += candidate.getProgrammingAbility();
		totalScore += candidate.getInfrastructureKnowledge();
		if (totalScore > passingScore) {
			return true;
		} else {
			return false;
		}
	}
}
