package jp.co.netprotections.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestListDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.dto.MemberJudgeResponseListDto;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;

@Service
public class MemberJudgeService {
	public static MemberJudgeResponseListDto judgeCandidates(MemberJudgeRequestListDto requestedList) {
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
					errorList.add("隊員名が入力されていません。");
				} else {
					candidateResult.setMemberName(candidate.getMemberName());
				}
				// スコアのバリデーションチェック
				errorList.addAll(MemberJudgeServiceImpl.validateScore(candidate));
				candidateResult.setErrorList(errorList);
				//スコアの評価
				if (errorList.isEmpty()) {
					if (MemberJudgeServiceImpl.isWellEventPlanning(candidate)
						&& MemberJudgeServiceImpl.isWellCogitation(candidate)
						&& MemberJudgeServiceImpl.isWellCoodination(candidate)
						&& MemberJudgeServiceImpl.isOverPassingScore(candidate, 10)) {
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
		// 隊員情報が入力されているかどうかのバリデーションチェック
		} else {
			MemberJudgeResponseDto error = new MemberJudgeResponseDto();
			error.setEnlistedPropriety(false);
			ArrayList<String> errorList = new ArrayList<String>();
			errorList.add("隊員情報が1件も入力されていません。");
			error.setErrorList(errorList);
			ArrayList<MemberJudgeResponseDto> errorResponse = new ArrayList<MemberJudgeResponseDto>();
			errorResponse.add(error);
			MemberJudgeResponseListDto resultResponse = new MemberJudgeResponseListDto();
			resultResponse.setJudgedCandidatesResultList(errorResponse);
			return resultResponse;
		}
	}
}
