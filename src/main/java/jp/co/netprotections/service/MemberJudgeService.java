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
		for (int i = 0; i < candidatesList.size(); i++) {
			MemberJudgeRequestDto candidate = candidatesList.get(i);
			MemberJudgeResponseDto candidateResult = new MemberJudgeResponseDto();
			candidateResult.setMemberName(candidate.getMemberName());
			if (MemberJudgeServiceImpl.isRightScore(candidate)
				&& MemberJudgeServiceImpl.isWellEventPlanning(candidate)
				&& MemberJudgeServiceImpl.isWellCogitation(candidate)
				&& MemberJudgeServiceImpl.isWellCoodination(candidate)
				&& MemberJudgeServiceImpl.isOverPassingScore(candidate, 10)) {
				candidateResult.setEnlistedPropriety(true);
				judgedCandidatesResultList.add(candidateResult);
			} else {
				candidateResult.setEnlistedPropriety(false);
				judgedCandidatesResultList.add(candidateResult);
			}
		}
		MemberJudgeResponseListDto resultResponse = new MemberJudgeResponseListDto();
		resultResponse.setJudgedCandidatesResultList(judgedCandidatesResultList);
		return resultResponse;
	}





	/* バリデーション用の部品。
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException error) {
		return error.getMessage();
	}
	*/

	/* 候補者情報のバリデーションチェックと評価のメソッドを作ってみたが、Errorsの扱いがわからずスタック。＠ExceptionHandlerを使うっぽい
	 * 参照）https://qiita.com/NagaokaKenichi/items/2f199134a881a776b717
	 * 参照）https://kuwalab.hatenablog.jp/entry/2014/02/02/SpringMVCJSON
	 * 参照）https://bit.ly/3iW0yo6
	 * 参照）http://namihira.hatenablog.com/entry/20150913/1442136070
	 * 参照）https://terasolunaorg.github.io/guideline/5.2.1.RELEASE/ja/ArchitectureInDetail/WebServiceDetail/REST.html　←まだ読んでないけど、参考になりそう（けど重め）
	public static MemberJudgeResponseDto judgeCandidate(@Valid MemberJudgeRequestDto candidate, Errors errors) {
		MemberJudgeResponseDto candidateResult = new MemberJudgeResponseDto();
		candidateResult.setMemberName(candidate.getMemberName());
		if (errors.hasErrors()) {
			candidateResult.setEnlistedPropriety(false);
			ArrayList<String> errorList = new ArrayList<String>();
			for (ObjectError oe : errors.getAllErrors()) {
		       errorList.add(oe.getDefaultMessage());
		    }
			candidateResult.setErrorList(errorList);
			return candidateResult;
		} else if (MemberJudgeService.isWellEventPlanning(candidate)
			&& MemberJudgeService.isWellCogitation(candidate)
			&& MemberJudgeService.isWellCoodination(candidate)
			&& MemberJudgeService.isOverPassingScore(candidate, 10)) {
			candidateResult.setEnlistedPropriety(true);
			return candidateResult;
		} else {
			candidateResult.setEnlistedPropriety(false);
			return candidateResult;
		}
	}
	*/
}
