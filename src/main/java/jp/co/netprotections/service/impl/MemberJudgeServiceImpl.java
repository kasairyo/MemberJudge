package jp.co.netprotections.service.impl;

import jp.co.netprotections.dto.MemberJudgeRequestDto;

public class MemberJudgeServiceImpl {
	// 入力されているスコアが正常の範囲(0-5)ならtrueを返す
	public static boolean isRightScore(MemberJudgeRequestDto candidate) {
		if (candidate.getEventPlanning() >= 0
			&& candidate.getEventPlanning() <= 5
			&& candidate.getCogitation() >= 0
			&& candidate.getCogitation() <= 5
			&& candidate.getCoodination() >= 0
			&& candidate.getCoodination() <= 5
			&& candidate.getProgrammingAbility() >= 0
			&& candidate.getProgrammingAbility() <= 5
			&& candidate.getInfrastructureKnowledge() >= 0
			&& candidate.getInfrastructureKnowledge() <= 5
			) {
			return true;
		} else {
			return false;
		}
	}

	// イベント企画力が1以下ならfalse、それ以外ならtrueを返す
	public static boolean isWellEventPlanning(MemberJudgeRequestDto candidate) {
		if (candidate.getEventPlanning() <= 1) {
			return false;
		} else {
			return true;
		}
	}

	// 思考力が1以下ならfalse、それ以外ならtrueを返す
	public static boolean isWellCogitation(MemberJudgeRequestDto candidate) {
		if (candidate.getCogitation() <= 1) {
			return false;
		} else {
			return true;
		}
	}

	// 調整力が1以下ならfalse、それ以外ならtrueを返す
	public static boolean isWellCoodination(MemberJudgeRequestDto candidate) {
		if (candidate.getCoodination() <= 1) {
			return false;
		} else {
			return true;
		}
	}

	// 候補者の合計得点を算出する
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
