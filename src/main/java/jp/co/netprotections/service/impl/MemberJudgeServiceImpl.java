package jp.co.netprotections.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.netprotections.constants.MemberJudgeConstants;
import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestListDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.dto.MemberJudgeResponseListDto;
import jp.co.netprotections.service.MemberJudgeService;

/**
 * サービス層の実装クラス
 * @author r.kasai
 */
@Service
public class MemberJudgeServiceImpl implements MemberJudgeService {
	@Override
	public MemberJudgeResponseListDto judgeCandidates(MemberJudgeRequestListDto requestedList) {
		List<MemberJudgeRequestDto> candidatesList = requestedList.getMemberCandidatesList();
		List<MemberJudgeResponseDto> judgedCandidatesResultList = new ArrayList<MemberJudgeResponseDto>();
		if (candidatesList.size() != 0) {
			for (int i = 0; i < candidatesList.size(); i++) {
				MemberJudgeRequestDto candidate = candidatesList.get(i);
				MemberJudgeResponseDto candidateResult = new MemberJudgeResponseDto();
				ArrayList<String> errorList = new ArrayList<String>();
				// 隊員名のバリデーションチェック
				if (candidate.getMemberName().isEmpty()) {
					candidateResult.setMemberName(null);
					errorList.add(MemberJudgeConstants.ERROR_NO_NAME);
				} else {
					candidateResult.setMemberName(candidate.getMemberName());
				}
				// スコアのバリデーションチェック
				errorList.addAll(validateScores(candidate));
				candidateResult.setErrorList(errorList);
				// スコアの評価
				if (errorList.isEmpty()) {
					if (judgeScores(candidate)) {
						candidateResult.setEnlistedPropriety(true);
					} else {
						candidateResult.setEnlistedPropriety(false);
					}
				}
				judgedCandidatesResultList.add(candidateResult);
			}
			MemberJudgeResponseListDto resultResponse = new MemberJudgeResponseListDto();
			resultResponse.setJudgedCandidatesResultList(judgedCandidatesResultList);
			return resultResponse;
		} else {
			// 隊員情報が1件以上入力されているかどうかのバリデーションチェック
			MemberJudgeResponseDto errorCandidate = new MemberJudgeResponseDto();
			ArrayList<String> errorList = new ArrayList<String>();
			ArrayList<MemberJudgeResponseDto> errorResponse = new ArrayList<MemberJudgeResponseDto>();
			MemberJudgeResponseListDto resultResponse = new MemberJudgeResponseListDto();
			errorCandidate.setEnlistedPropriety(false);
			errorList.add(MemberJudgeConstants.ERROR_NO_CANDIDATE);
			errorCandidate.setErrorList(errorList);
			errorResponse.add(errorCandidate);
			resultResponse.setJudgedCandidatesResultList(errorResponse);
			return resultResponse;
		}
	}

	// スコアが不正な場合、エラーメッセージを返す
	public static ArrayList<String> validateScores(MemberJudgeRequestDto candidate) {
		ArrayList<String> errorList = new ArrayList<String>();
		if (candidate.getEventPlanning() < 0
			|| candidate.getEventPlanning() > 5) {
			errorList.add(MemberJudgeConstants.ERROR_EVENT_PLANNING_OUT_OF_RANGE);
		}
		if(candidate.getCogitation() < 0
			|| candidate.getCogitation() > 5) {
			errorList.add(MemberJudgeConstants.ERROR_COGITATION_OUT_OF_RANGE);
		}
		if(candidate.getCoodination() < 0
			|| candidate.getCoodination() > 5) {
			errorList.add(MemberJudgeConstants.ERROR_COODINATION_OUT_OF_RANGE);
		}
		if(candidate.getProgrammingAbility() < 0
			|| candidate.getProgrammingAbility() > 5) {
			errorList.add(MemberJudgeConstants.ERROR_PROGRAMMING_ABILITY_OUT_OF_RANGE);
		}
		if(candidate.getInfrastructureKnowledge() < 0
			|| candidate.getInfrastructureKnowledge() > 5) {
			errorList.add(MemberJudgeConstants.ERROR_INFRASTRUCTURE_KNOWLEDGE_OUT_OF_RANGE);
		}
		return errorList;
	}

	// スコア評価をまとめて呼び出すメソッド
	public static boolean judgeScores(MemberJudgeRequestDto candidate) {
		if (isWellEventPlanning(candidate)
			&& isWellCogitation(candidate)
			&& isWellCoodination(candidate)
			&& isOverPassingScore(candidate, 10)) {
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
