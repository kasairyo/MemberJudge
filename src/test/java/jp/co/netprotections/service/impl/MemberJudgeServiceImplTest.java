package jp.co.netprotections.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestListDto;

public class MemberJudgeServiceImplTest {
	@Test
	public void judgeCandidatesTestTrue01() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(true, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestTrue02() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(2);
		candidate.setCogitation(2);
		candidate.setCoodination(2);
		candidate.setProgrammingAbility(2);
		candidate.setInfrastructureKnowledge(3);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(true, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestTrue03() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate1 = new MemberJudgeRequestDto();
		candidate1.setMemberName("Test1");
		candidate1.setEventPlanning(2);
		candidate1.setCogitation(2);
		candidate1.setCoodination(2);
		candidate1.setProgrammingAbility(2);
		candidate1.setInfrastructureKnowledge(3);
		candidatesList.add(candidate1);
		MemberJudgeRequestDto candidate2 = new MemberJudgeRequestDto();
		candidate2.setMemberName("Test2");
		candidate2.setEventPlanning(5);
		candidate2.setCogitation(5);
		candidate2.setCoodination(5);
		candidate2.setProgrammingAbility(5);
		candidate2.setInfrastructureKnowledge(5);
		candidatesList.add(candidate2);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test2", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(1).getMemberName());
		assertEquals(true, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(1).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestFalse01() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(2);
		candidate.setCogitation(2);
		candidate.setCoodination(2);
		candidate.setProgrammingAbility(2);
		candidate.setInfrastructureKnowledge(2);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestFalse02() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(1);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestFalse03() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(5);
		candidate.setCogitation(1);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestFalse04() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(1);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestFalse05() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(6);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestFalse06() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(-1);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	// こちらのテストでは失敗するが、Postman上では同一条件にてテストをパスすることが確認できた
	@Test
	public void judgeCandidatesTestFalse07() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setMemberName("Test");
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidatesList.add(candidate);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}

	@Test
	public void judgeCandidatesTestFalse08() {
		MemberJudgeRequestListDto request = new MemberJudgeRequestListDto();
		ArrayList<MemberJudgeRequestDto> candidatesList = new ArrayList<MemberJudgeRequestDto>();
		MemberJudgeRequestDto candidate1 = new MemberJudgeRequestDto();
		candidate1.setMemberName("Test1");
		candidate1.setEventPlanning(2);
		candidate1.setCogitation(2);
		candidate1.setCoodination(2);
		candidate1.setProgrammingAbility(2);
		candidate1.setInfrastructureKnowledge(3);
		candidatesList.add(candidate1);
		MemberJudgeRequestDto candidate2 = new MemberJudgeRequestDto();
		candidate2.setMemberName("Test2");
		candidate2.setEventPlanning(0);
		candidate2.setCogitation(5);
		candidate2.setCoodination(5);
		candidate2.setProgrammingAbility(5);
		candidate2.setInfrastructureKnowledge(5);
		candidatesList.add(candidate2);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test2", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(1).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(1).isEnlistedPropriety());
	}

	@Test
	public void validateScoresTestNoError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestNoError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestEventPlanningError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(-1);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestEventPlanningError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(6);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCogitationError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(-1);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("cogitationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCogitationError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(6);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("cogitationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCoodinationError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(-1);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("coodinationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCoodinationError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(6);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("coodinationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestProgrammingAbilityError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(-1);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestProgrammingAbilityError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(6);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestInfrastructureKnowledgeError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(-1);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestInfrastructureKnowledgerror02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(6);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestMultipleError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(-1);
		candidate.setCogitation(-1);
		candidate.setCoodination(-1);
		candidate.setProgrammingAbility(-1);
		candidate.setInfrastructureKnowledge(-1);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		expected.add("cogitationは0~5の整数値を入力してください。");
		expected.add("coodinationは0~5の整数値を入力してください。");
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestMultipleError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(6);
		candidate.setCogitation(6);
		candidate.setCoodination(6);
		candidate.setProgrammingAbility(6);
		candidate.setInfrastructureKnowledge(6);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		expected.add("cogitationは0~5の整数値を入力してください。");
		expected.add("coodinationは0~5の整数値を入力してください。");
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void isWellEventPlanningTestTrue() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(2);
		candidate.setCogitation(3);
		candidate.setCoodination(3);
		candidate.setProgrammingAbility(3);
		candidate.setInfrastructureKnowledge(3);
		assertEquals(true, MemberJudgeServiceImpl.isWellEventPlanning(candidate));
	}

	@Test
	public void isWellEventPlanningTestFalse() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(1);
		candidate.setCogitation(3);
		candidate.setCoodination(3);
		candidate.setProgrammingAbility(3);
		candidate.setInfrastructureKnowledge(3);
		assertEquals(false, MemberJudgeServiceImpl.isWellEventPlanning(candidate));
	}

	@Test
	public void isWellCogitationTestTrue() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(3);
		candidate.setCogitation(2);
		candidate.setCoodination(3);
		candidate.setProgrammingAbility(3);
		candidate.setInfrastructureKnowledge(3);
		assertEquals(true, MemberJudgeServiceImpl.isWellCogitation(candidate));
	}

	@Test
	public void isWellCogitationTestFalse() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(3);
		candidate.setCogitation(1);
		candidate.setCoodination(3);
		candidate.setProgrammingAbility(3);
		candidate.setInfrastructureKnowledge(3);
		assertEquals(false, MemberJudgeServiceImpl.isWellCogitation(candidate));
	}

	@Test
	public void isWellCoodinationTestTrue() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(3);
		candidate.setCogitation(3);
		candidate.setCoodination(2);
		candidate.setProgrammingAbility(3);
		candidate.setInfrastructureKnowledge(3);
		assertEquals(true, MemberJudgeServiceImpl.isWellCoodination(candidate));
	}

	@Test
	public void isWellCoodinationTestFalse() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(3);
		candidate.setCogitation(3);
		candidate.setCoodination(1);
		candidate.setProgrammingAbility(3);
		candidate.setInfrastructureKnowledge(3);
		assertEquals(false, MemberJudgeServiceImpl.isWellCoodination(candidate));
	}

	@Test
	public void isOverPassingScoreTestTrue() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(2);
		candidate.setCogitation(2);
		candidate.setCoodination(2);
		candidate.setProgrammingAbility(2);
		candidate.setInfrastructureKnowledge(3);
		assertEquals(true, MemberJudgeServiceImpl.isOverPassingScore(candidate, 10));
	}

	@Test
	public void isOverPassingScoreTestFalse() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		assertEquals(false, MemberJudgeServiceImpl.isOverPassingScore(candidate, 10));
	}
}
