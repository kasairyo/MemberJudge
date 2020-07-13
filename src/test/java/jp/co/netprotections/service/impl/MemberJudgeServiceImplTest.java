package jp.co.netprotections.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import jp.co.netprotections.dto.MemberJudgeRequestDto;

public class MemberJudgeServiceImplTest {

	@Test
	public void validateScoreTestNoError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestNoError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestEventPlanningError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(-1);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestEventPlanningError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(6);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("eventPlanningは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestCogitationError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(-1);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("cogitationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestCogitationError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(6);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("cogitationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestCoodinationError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(-1);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("coodinationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestCoodinationError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(6);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("coodinationは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestProgrammingAbilityError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(-1);
		candidate.setInfrastructureKnowledge(0);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestProgrammingAbilityError02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(6);
		candidate.setInfrastructureKnowledge(5);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("programmingAbilityは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestInfrastructureKnowledgeError01() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(0);
		candidate.setCogitation(0);
		candidate.setCoodination(0);
		candidate.setProgrammingAbility(0);
		candidate.setInfrastructureKnowledge(-1);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestInfrastructureKnowledgerror02() {
		MemberJudgeRequestDto candidate = new MemberJudgeRequestDto();
		candidate.setEventPlanning(5);
		candidate.setCogitation(5);
		candidate.setCoodination(5);
		candidate.setProgrammingAbility(5);
		candidate.setInfrastructureKnowledge(6);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("infrastructureKnowledgeは0~5の整数値を入力してください。");
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestMultipleError01() {
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
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
	}

	@Test
	public void validateScoreTestMultipleError02() {
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
		assertEquals(expected, MemberJudgeServiceImpl.validateScore(candidate));
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
