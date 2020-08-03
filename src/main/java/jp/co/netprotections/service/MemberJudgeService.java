package jp.co.netprotections.service;

import jp.co.netprotections.dto.MemberJudgeRequestListDto;
import jp.co.netprotections.dto.MemberJudgeResponseListDto;

/**
 * サービス層のインターフェイスクラス
 * @author r.kasai
 */
public interface MemberJudgeService {
	public MemberJudgeResponseListDto judgeCandidates(MemberJudgeRequestListDto requestedList) ;
}
