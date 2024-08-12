package com.kh.dndncare.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dndncare.board.model.vo.Board;
import com.kh.dndncare.board.model.vo.PageInfo;
import com.kh.dndncare.board.model.vo.Reply;
import com.kh.dndncare.matching.model.vo.CareReview;
import com.kh.dndncare.matching.model.vo.MatMatptInfo;
import com.kh.dndncare.matching.model.vo.MatPtInfo;
import com.kh.dndncare.matching.model.vo.MatMatptInfoPt;
import com.kh.dndncare.matching.model.vo.Matching;
import com.kh.dndncare.matching.model.vo.RequestMatPt;
import com.kh.dndncare.member.model.dao.MemberMapper;

import com.kh.dndncare.member.model.vo.CalendarEvent;

import com.kh.dndncare.member.model.vo.CareGiver;
import com.kh.dndncare.matching.model.vo.Matching;
import com.kh.dndncare.member.model.vo.Member;
import com.kh.dndncare.member.model.vo.Patient;
import com.kh.dndncare.sms.SmsService;

import net.nurigo.sdk.message.response.SingleMessageSentResponse;

@Service
public class MemberServiceImpl implements MemberService {
	
	private final SmsService smsService;
	
    public MemberServiceImpl(SmsService smsService) {
        this.smsService = smsService;
    }
	
	@Autowired
	private MemberMapper mMapper;
	
	@Override
	public Member login(Member m) {
		return mMapper.login(m);
	}
	
	
	//// 멤버 테이블만 있고 환자/ 간병인 테이블에 insert됮 않은 경우 멤버 테이블 삭제
	@Override
	public int noInfomemberdle() {
		return mMapper.noInfomemberdle();
	}

	//아이디 중복체크
	@Override
	public int idCheck(String id) {

		return mMapper.idCheck(id);
	}
	
	//닉네임 중복 체크
	@Override
	public int nickNameCheck(String nickName) {
		return mMapper.nickNameCheck(nickName);
	}

	
	


	@Override
	public ArrayList<CalendarEvent> caregiverCalendarEvent(Member loginUser) {
		return mMapper.caregiverCalendarEvent(loginUser);
	}
	
	public ArrayList<Member> selectAllMember() {
		return mMapper.selectAllMember();
	}

	//member테이블 insert(회원가입)
	public int enroll(Member m) {
		return mMapper.enroll(m);
	}

	//간병인 테이블 insert(회원가입 -간병인)
	@Override
	public int enrollCareGiver(CareGiver cg) {
		return  mMapper.enrollCareGiver(cg);
	}

	//member_info insert (회원가입)
	@Override
	public int enrollInfoCategory(Object ob) {
		return mMapper.enrollInfoCategory(ob);
	}

	
	///환자 테이블 insert (환자 회원가입)
	@Override
	public int enrollPatient(Patient pt) {
		return  mMapper.enrollPatient(pt);
	}
	

	@Override
	public Member findIdResult(Member member) {
		return mMapper.findIdResult(member);
	}

	@Override
	public boolean sendSms(String phoneNumber, String text) {
	    try {
	        SingleMessageSentResponse response = smsService.sendSms(phoneNumber, "01077651258", text);
	        return response.getStatusCode().equals("2000");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public ArrayList<Matching> calendarEvent(Member loginUser) {
		// TODO Auto-generated method stub 이거 뭐여
		return null;
	}

	@Override
	public Patient selectPatient(int memberNo) {
		return mMapper.selectPatient(memberNo);
	}
	public HashMap<String, String> getCaregiverInfo(int memberNo) {
		return mMapper.getCaregiverInfo(memberNo);
	}

	@Override
	public ArrayList<HashMap<String, String>> getCaregiverExp(int memberNo) {
		return mMapper.getCaregiverExp(memberNo);
	}

	@Override
	public ArrayList<Patient> selectPatientList(String caregiverCity) {
		return mMapper.selectPatientList(caregiverCity);
	}

	@Override
	public ArrayList<HashMap<String, String>> getPatientExp(ArrayList<Integer> pNoList) {
		return mMapper.getPatientExp(pNoList);
	}

	@Override
	public ArrayList<Patient> choicePatientList(ArrayList<Integer> choiceNoList) {
		return mMapper.choicePatientList(choiceNoList);
	}

	


	@Override
	public List<Integer> selectInfoCategory(int memberNo) {
		return mMapper.selectInfoCategory(memberNo);
	}


	public int updatePassword(HashMap<String, String> changeInfo) {
		return mMapper.updatePassword(changeInfo);
	}

	@Override
	public List<Integer> selectMemberInfo(int memberNo) {
		return null;
		/* return mMapper.selectMemberInfo(memberNo); */
	}

	@Override
	public int deleteWantInfo(int memberNo) {
		return mMapper.deleteWantInfo(memberNo);
	}

	@Override
	public int insertWantInfo(HashMap<String, Integer> info) {
		return mMapper.insertWantInfo(info);
	}

	@Override
	public ArrayList<HashMap<String, String>> selectWantInfo(int memberNo) {
		return mMapper.selectWantInfo(memberNo);
	}

	@Override
	public int updatePatient(Patient p) {
		return mMapper.updatePatient(p);
	}

	@Override
	public int insertMemberInfo(HashMap<String, Integer> info) {
		return mMapper.insertMemberInfo(info);
	}

	@Override
	public int deleteMemberInfo(int memberNo) {
		return mMapper.deleteMemberInfo(memberNo);
	}

	@Override
	public int updateMember(Member m) {
		return mMapper.updateMember(m);
	}

	@Override
	public CareGiver selectCareGiver(int memberNo) {
		return mMapper.selectCareGiver(memberNo);
	}

	@Override
	public int updateCareGiver(CareGiver cg) {
		return mMapper.updateCareGiver(cg);
	}

	@Override
	public int updateMemberVer2(Member m) {
		return mMapper.updateMemberVer2(m);
	}
	
	public ArrayList<Board> mySelectBoardList(PageInfo pi,int mNo) {
		int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return mMapper.mySelectBoardList(mNo, rowBounds);
	}

	@Override
	public int getBoardListCount(int mNo) {
		return mMapper.getBoardListCount(mNo);
	}

	@Override
	public int boardLikeCount(int boardNo) {
		return mMapper.boardLikeCount(boardNo);
	}

	@Override
	public int getReplyListCount(int mNo) {
		return mMapper.getReplyListCount(mNo);
	}

	@Override
	public ArrayList<Reply> mySelectReplyList(PageInfo replyPi, int mNo) {
		int offset = (replyPi.getCurrentPage() - 1)*replyPi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, replyPi.getBoardLimit());
		return mMapper.mySelectReplyList(mNo, rowBounds);
	}

	@Override
	public int replyLikeCount(int replyNo) {
		return mMapper.replyLikeCount(replyNo);
	}

	@Override
	public int getLikeListCount(int mNo) {
		return mMapper.getLikeListCount(mNo);
	}

	@Override
	public ArrayList<Board> mySelectLikeList(PageInfo likePi, int mNo) {
		int offset = (likePi.getCurrentPage() - 1)*likePi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, likePi.getBoardLimit());
		return mMapper.mySelectLikeList(mNo, rowBounds);
	}

	@Override
	public int likeLikeCount(int boardNo) {
		return mMapper.likeLikeCount(boardNo);
	}
	@Override
	public ArrayList<MatMatptInfo> selectMatList(int memberNo) {
		return mMapper.selectMatList(memberNo);
	}
	
	//MatMatptInfoPt get - 환자매칭 모든 정보
	@Override
	public ArrayList<MatMatptInfoPt> getMatMatptInfoPt() {
		return mMapper.getMatMatptInfoPt();
	}
	
	//loginUser(간병인)에게 매칭을 신청한 대상 이름 불러오기
	@Override
	public ArrayList<RequestMatPt> getRequestMatPt(int memberNo) {
		return mMapper.getRequestMatPt(memberNo);
	}
		
	@Override
	public ArrayList<CareGiver> selectCareGiverList() {
		return mMapper.selectCareGiverList();

	}

	@Override
	public Member selectSocialLogin(String code) {
		return mMapper.selectSocialLogin(code);
	}
	public ArrayList<CareReview> reviewList(int ptNo) {
		return mMapper.reviewList(ptNo);
	}

	@Override
	public ArrayList<CareReview> selectReviewList(int reviewNo) {
		return mMapper.selectReviewList(reviewNo);
	}

	@Override
	public int getPtNo(int memberNo) {
		return mMapper.getPtNo(memberNo);
	}

}
