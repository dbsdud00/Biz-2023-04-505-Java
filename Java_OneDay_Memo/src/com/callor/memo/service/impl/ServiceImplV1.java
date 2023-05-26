package com.callor.memo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.memo.config.DBConnection;
import com.callor.memo.config.Line;
import com.callor.memo.mapper.MemoDao;
import com.callor.memo.models.MemoDto;
import com.callor.memo.service.Service;

public class ServiceImplV1 implements Service {

	SqlSession sqlSession;
	MemoDao mDao;
	Scanner scan;

	public ServiceImplV1() {
		sqlSession = DBConnection.getFactory().openSession(true);
		mDao = sqlSession.getMapper(MemoDao.class);
		scan = new Scanner(System.in);
	}

	protected void printMemoList(List<MemoDto> mList, String title) {
		System.out.println(Line.dLine(70));
		System.out.println(title);
		System.out.println(Line.sLine(70));
		System.out.println("번호\t작성자\t\t작성일자\t제목");
		System.out.println(Line.sLine(70));
		for (MemoDto mDto : mList) {
			System.out.printf("%3d\t", mDto.m_seq);
			System.out.printf("%s\t\t", mDto.m_writer);
			System.out.printf("%s\t", mDto.m_date);
			System.out.printf("%s\n", mDto.m_subject);

		}
		System.out.println(Line.dLine(70));
	}

	@Override
	public void LoadMemo() {
		List<MemoDto> mList = mDao.selectAll();
		String title = "전체 메모 리스트";
		printMemoList(mList, title);

	}

	@Override
	public MemoDto ReadMemo() {
		MemoDto dto;
		LoadMemo();
		System.out.println("확인하실 메모의 번호를 입력해 주세요. (종료하시려면 -1을 입력해 주세요)");
		while (true) {
			System.out.print("번호 입력 >> ");
			int seq = 0;
			try {
				seq = Integer.valueOf(scan.nextLine());
				if (seq == -1) return null;
			} catch (Exception e) {
				System.out.println("번호는 정수형으로 입력해 주세요");
			}
			dto = mDao.findBySeq(seq);
			System.out.println(Line.dLine(70));
			System.out.println(dto.m_subject);
			System.out.println(Line.sLine(70));
			System.out.printf("작성자 : %s \t\t\t\t\t%s\n",dto.m_writer, dto.m_date);
			System.out.println(Line.dLine(70));
			String[] strs = dto.m_content.split("");
			for (int i = 0; i < strs.length; i++) {
				System.out.print(strs[i]);
				if ((i+1) % 40 == 0) System.out.println();
			}
			
			System.out.println();
			//System.out.println(dto.m_content);
			
			System.out.println(Line.dLine(70));
			break;
		}
		return dto;
		
	}

	@Override
	public void NewMemo() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		String todayString = todayFormat.format(date);
		System.out.println("새로운 메모를 생성합니다.");
		MemoDto mDto = new MemoDto();
		mDto.m_date = todayString;
		
		while(true) {
			System.out.println("작성자를 입력해 주세요.");
			System.out.println(">> ");
			mDto.m_writer = scan.nextLine();
			if (mDto.m_writer == null) {
				System.out.println("작성자는 비울 수 없습니다. 다시 입력해 주세요");
				continue;
			}
			break;
		}
		
		System.out.println("제목을 입력해 주세요");
		System.out.println(">> ");
		mDto.m_subject = scan.nextLine();
		
		System.out.println("메모 입력을 시작합니다.");
		mDto.m_content = scan.nextLine();
		
		System.out.println("메모 입력을 종료합니다.");
		while(true) {
			System.out.print("저장하시겠습니까?(Y/N) >> ");
			String YN = scan.nextLine();
			if (YN.equals("Y")) mDao.insert(mDto);
			else if (YN.equals("N")) System.out.println("저장에 실패하였습니다.");
			else {
				System.out.println("Y 또는 N 으로 입력해 주세요.");
				continue;
			}
			break;
		}
		
	}

	@Override
	public void UpdateMemo() {
		
		System.out.println("메모 수정을 실행합니다.");
		MemoDto mDto = ReadMemo();
		if (mDto == null) {
			System.out.println("종료합니다.");
			return;
		}
		System.out.println("수정하실 내용을 선택해 주세요");
		System.out.println("1. 작성자 수정");
		System.out.println("2. 제목 수정");
		System.out.println("3. 내용 수정");
		System.out.print("4. 종료 \n>> ");
		int intChoice = 0;
		while(true) {
			String choice = scan.nextLine();
			try {
				intChoice = Integer.valueOf(choice);
				
				if (intChoice < 1 || intChoice >4) {
					System.out.println("1 ~ 4 사이로 다시 입력해 주세요");
					continue;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수로 입력해 주세요");
				continue;
			}
			
			break;
		}


		if (intChoice == 4) { 
			System.out.println("메모수정을 종료합니다.");
			return;
		}
		System.out.print("수정하실 내용을 입력해 주세요.\n>> ");
		String update = scan.nextLine();
		if (intChoice == 1) mDto.m_writer = update;
		else if (intChoice == 2) mDto.m_subject = update;
		else if (intChoice == 3) mDto.m_content = update;
		
		if (mDao.update(mDto) < 0) {
			System.out.println("수정에 실패하였습니다.");
			return ;
		}

		System.out.println("수정이 완료되었습니다.");

		
	}
	

	
	@Override
	public void DeleteMemo() {
		System.out.println("메모 삭제 시스템");
		MemoDto mDto = ReadMemo();
		while(true) {
			System.out.print("정말로 삭제하시겠습니까?(Y/N) >> ");
			String YN = scan.nextLine();
			if(YN.equals("Y")) {
				mDao.delete(mDto.m_seq);
				System.out.println("메모가 삭제되었습니다.");
			} else if(YN.equals("N")) {
				System.out.println("메모가 삭제되지 않았습니다.");
			} else {
				System.out.println("다시 입력해 주세요.");
				continue;
			}
			break;
		}
	}

}
