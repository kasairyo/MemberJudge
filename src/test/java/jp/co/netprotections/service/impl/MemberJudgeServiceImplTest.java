package jp.co.netprotections.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import jp.co.netprotections.dto.MemberJudgeRequestDto;

public class MemberJudgeServiceImplTest {

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
