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
	public static Map<String, ArrayList<MemberJudgeResponseDto>> judgeCandidates(Map<String, ArrayList<MemberJudgeRequestDto>> candidatesList) {
		ArrayList<MemberJudgeResponseDto> judgedCandidatesResultList = new ArrayList<MemberJudgeResponseDto>();
		ArrayList<MemberJudgeRequestDto> candidates = MemberJudgeService.extractCandidates(candidatesList);
		for (int i = 0; i < candidates.size(); i++) {
			MemberJudgeRequestDto candidate = candidates.get(i);
			MemberJudgeResponseDto candidateResult = new MemberJudgeResponseDto();
			candidateResult.setMemberName(candidate.getMemberName());
			if (MemberJudgeService.isWellEventPlanning(candidate)
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

	// Mapでネストされているリクエストから中身を展開
	public static ArrayList<MemberJudgeRequestDto> extractCandidates(Map<String, ArrayList<MemberJudgeRequestDto>> map) {
		return map.get("memberCandidatesList");
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
