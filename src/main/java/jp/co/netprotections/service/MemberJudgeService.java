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
				errorList.addAll(MemberJudgeServiceImpl.validateScores(candidate));
				candidateResult.setErrorList(errorList);
				// スコアの評価
				if (errorList.isEmpty()) {
					if (MemberJudgeServiceImpl.judgeScores(candidate)) {
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
			errorList.add("隊員情報が1件も入力されていません。");
			errorCandidate.setErrorList(errorList);
			errorResponse.add(errorCandidate);
			resultResponse.setJudgedCandidatesResultList(errorResponse);
			return resultResponse;
		}
	}
}
