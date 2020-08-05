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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(2)
			.cogitation(2)
			.coodination(2)
			.programmingAbility(2)
			.infrastructureKnowledge(3)
			.build();
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
		MemberJudgeRequestDto candidate1 = MemberJudgeRequestDto.builder()
			.memberName("Test1")
			.eventPlanning(2)
			.cogitation(2)
			.coodination(2)
			.programmingAbility(2)
			.infrastructureKnowledge(3)
			.build();
		candidatesList.add(candidate1);
		MemberJudgeRequestDto candidate2 = MemberJudgeRequestDto.builder()
			.memberName("Test2")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(2)
			.cogitation(2)
			.coodination(2)
			.programmingAbility(2)
			.infrastructureKnowledge(2)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(1)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(1)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(1)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(6)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(-1)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.build();
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
		MemberJudgeRequestDto candidate1 = MemberJudgeRequestDto.builder()
			.memberName("Test1")
			.eventPlanning(2)
			.cogitation(2)
			.coodination(2)
			.programmingAbility(2)
			.infrastructureKnowledge(3)
			.build();
		candidatesList.add(candidate1);
		MemberJudgeRequestDto candidate2 = MemberJudgeRequestDto.builder()
			.memberName("Test2")
			.eventPlanning(0)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
		candidatesList.add(candidate2);
		request.setMemberCandidatesList(candidatesList);
		MemberJudgeServiceImpl memberJudgeServiceImpl = new MemberJudgeServiceImpl();
		assertEquals("Test2", memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(1).getMemberName());
		assertEquals(false, memberJudgeServiceImpl.judgeCandidates(request).getJudgedCandidatesResultList().get(1).isEnlistedPropriety());
	}

	@Test
	public void validateScoresTestNoError01() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(0)
			.cogitation(0)
			.coodination(0)
			.programmingAbility(0)
			.infrastructureKnowledge(0)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestNoError02() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestEventPlanningError01() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(-1)
			.cogitation(0)
			.coodination(0)
			.programmingAbility(0)
			.infrastructureKnowledge(0)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestEventPlanningError02() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(6)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCogitationError01() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(0)
			.cogitation(-1)
			.coodination(0)
			.programmingAbility(0)
			.infrastructureKnowledge(0)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("cogitationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCogitationError02() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(6)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("cogitationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCoodinationError01() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(0)
			.cogitation(0)
			.coodination(-1)
			.programmingAbility(0)
			.infrastructureKnowledge(0)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("coodinationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestCoodinationError02() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(6)
			.programmingAbility(5)
			.infrastructureKnowledge(5)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("coodinationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestProgrammingAbilityError01() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(0)
			.cogitation(0)
			.coodination(0)
			.programmingAbility(-1)
			.infrastructureKnowledge(0)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestProgrammingAbilityError02() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(6)
			.infrastructureKnowledge(5)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestInfrastructureKnowledgeError01() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(0)
			.cogitation(0)
			.coodination(0)
			.programmingAbility(0)
			.infrastructureKnowledge(-1)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestInfrastructureKnowledgerror02() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(5)
			.programmingAbility(5)
			.infrastructureKnowledge(6)
			.build();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScores(candidate));
	}

	@Test
	public void validateScoresTestMultipleError01() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(-1)
			.cogitation(-1)
			.coodination(-1)
			.programmingAbility(-1)
			.infrastructureKnowledge(-1)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(6)
			.cogitation(6)
			.coodination(6)
			.programmingAbility(6)
			.infrastructureKnowledge(6)
			.build();
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
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(2)
			.cogitation(3)
			.coodination(3)
			.programmingAbility(3)
			.infrastructureKnowledge(3)
			.build();
		assertEquals(true, MemberJudgeServiceImpl.isWellEventPlanning(candidate));
	}

	@Test
	public void isWellEventPlanningTestFalse() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(1)
			.cogitation(3)
			.coodination(3)
			.programmingAbility(3)
			.infrastructureKnowledge(3)
			.build();
		assertEquals(false, MemberJudgeServiceImpl.isWellEventPlanning(candidate));
	}

	@Test
	public void isWellCogitationTestTrue() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(3)
			.cogitation(2)
			.coodination(3)
			.programmingAbility(3)
			.infrastructureKnowledge(3)
			.build();
		assertEquals(true, MemberJudgeServiceImpl.isWellCogitation(candidate));
	}

	@Test
	public void isWellCogitationTestFalse() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(3)
			.cogitation(1)
			.coodination(3)
			.programmingAbility(3)
			.infrastructureKnowledge(3)
			.build();
		assertEquals(false, MemberJudgeServiceImpl.isWellCogitation(candidate));
	}

	@Test
	public void isWellCoodinationTestTrue() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(3)
			.cogitation(3)
			.coodination(2)
			.programmingAbility(3)
			.infrastructureKnowledge(3)
			.build();
		assertEquals(true, MemberJudgeServiceImpl.isWellCoodination(candidate));
	}

	@Test
	public void isWellCoodinationTestFalse() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(3)
			.cogitation(3)
			.coodination(1)
			.programmingAbility(3)
			.infrastructureKnowledge(3)
			.build();
		assertEquals(false, MemberJudgeServiceImpl.isWellCoodination(candidate));
	}

	@Test
	public void isOverPassingScoreTestTrue() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(2)
			.cogitation(2)
			.coodination(2)
			.programmingAbility(2)
			.infrastructureKnowledge(3)
			.build();
		assertEquals(true, MemberJudgeServiceImpl.isOverPassingScore(candidate, 10));
	}

	@Test
	public void isOverPassingScoreTestFalse() {
		MemberJudgeRequestDto candidate = MemberJudgeRequestDto.builder()
			.memberName("Test")
			.eventPlanning(5)
			.cogitation(5)
			.coodination(0)
			.programmingAbility(0)
			.infrastructureKnowledge(0)
			.build();
		assertEquals(false, MemberJudgeServiceImpl.isOverPassingScore(candidate, 10));
	}
}
