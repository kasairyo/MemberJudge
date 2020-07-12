package jp.co.netprotections.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestListDto;

public class MemberJudgeServiceTest {
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(true, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(true, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
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
		assertEquals("Test2", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(1).getMemberName());
		assertEquals(true, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(1).isEnlistedPropriety());
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}






















	/////////////////値がnullの時の扱いがうまくいっていない！！！/////////////////
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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
	}





















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
		assertEquals("Test", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(0).isEnlistedPropriety());
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
		assertEquals("Test2", MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(1).getMemberName());
		assertEquals(false, MemberJudgeService.judgeCandidates(request).getJudgedCandidatesResultList().get(1).isEnlistedPropriety());
	}
}
