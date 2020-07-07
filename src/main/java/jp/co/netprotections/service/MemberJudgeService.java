package jp.co.netprotections.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;

@Service
public class MemberJudgeService {
	// すべてのロジックを統合し、Controllerから呼び出すメソッド
	public static Map<String, ArrayList<MemberJudgeResponseDto>> judgeCandidates(Map<String, ArrayList<MemberJudgeRequestDto>> requestedList) {
		ArrayList<MemberJudgeRequestDto> candidatesList = requestedList.get("memberCandidatesList");
		ArrayList<MemberJudgeResponseDto> judgedCandidatesResultList = new ArrayList<MemberJudgeResponseDto>();
		for (int i = 0; i < candidatesList.size(); i++) {
			MemberJudgeRequestDto candidate = candidatesList.get(i);
			MemberJudgeResponseDto candidateResult = new MemberJudgeResponseDto();
			candidateResult.setMemberName(candidate.getMemberName());
			//バリデーションロジック

			// 評価ロジック
			if (MemberJudgeService.isRightScore(candidate)
				&& MemberJudgeService.isWellEventPlanning(candidate)
				&& MemberJudgeService.isWellCogitation(candidate)
				&& MemberJudgeService.isWellCoodination(candidate)
				&& MemberJudgeService.sumPoints(candidate) > 10) {
				candidateResult.setEnlistedPropriety(true);
				judgedCandidatesResultList.add(candidateResult);
			} else {
				candidateResult.setEnlistedPropriety(false);
				judgedCandidatesResultList.add(candidateResult);
			}
		}
		Map<String, ArrayList<MemberJudgeResponseDto>> mappedJudgedCandidatesResultList = new HashMap<String, ArrayList<MemberJudgeResponseDto>>();
		mappedJudgedCandidatesResultList.put("judgedCandidatesResultList", judgedCandidatesResultList);
		return mappedJudgedCandidatesResultList;
	}

	// 入力されているスコアが正常の範囲(0-5)ならtrueを返す
	public static boolean isRightScore(MemberJudgeRequestDto candidate) {
		if (candidate.getEventPlanning() < 0
			|| candidate.getEventPlanning() > 5
			|| candidate.getCogitation() < 0
			|| candidate.getCogitation() > 5
			|| candidate.getCoodination() < 0
			|| candidate.getCoodination() > 5
			|| candidate.getProgrammingAbility() < 0
			|| candidate.getProgrammingAbility() > 5
			|| candidate.getInfrastructureKnowledge() < 0
			|| candidate.getInfrastructureKnowledge() > 5
			) {
			return false;
		} else {
			return true;
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
	public static int sumPoints(MemberJudgeRequestDto candidate) {
		int totalPoints = 0;
		totalPoints += candidate.getEventPlanning();
		totalPoints += candidate.getCogitation();
		totalPoints += candidate.getCoodination();
		totalPoints += candidate.getProgrammingAbility();
		totalPoints += candidate.getInfrastructureKnowledge();
		return totalPoints;
	}
}
