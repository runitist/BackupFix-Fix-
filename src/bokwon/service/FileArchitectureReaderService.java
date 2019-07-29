package bokwon.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import bokwon.model.FileArchitectureReaderModel;

public class FileArchitectureReaderService implements Runnable {

	private final FileArchitectureReaderModel fm;

	public FileArchitectureReaderService(FileArchitectureReaderModel fm) {
		this.fm = fm;
	}

	@Override
	public void run() {
		try {
			FileArcRead(fm);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void FileArcRead(FileArchitectureReaderModel fm) throws Exception {
		// 백업파일내 구조를 알아보기위한 로직.
		// 해당 파일을 읽고, 컬럼별로 나눠서 architecture.txt 파일로 출력해줌.
		// 해당 텍스트 파일을 읽고 컬럼 분석이 가능.

		// 유저 변경 사항
		// 시작////////////////////////////////////////////////////////////////////////
		final String BACKPATH = fm.getBACKPATH();
		final String PICYEAR = fm.getPICYEAR(); // 해당 사진의 연월.
		final String BACKFILENAME = fm.getBACKFILENAME();

		// 추출 제외할 컬럼
		// 1,2 번은 15, 23컬럼
		// 3,4 번은 15, 16컬럼
		final int EXCEPTCOL1 = fm.getEXCEPTCOL1();
		final int EXCEPTCOL2 = fm.getEXCEPTCOL2();

		// 추출할 갯수 설정
		final int EXTNUM = fm.getEXTNUM();
		// 유저 변경 사항
		// 끝////////////////////////////////////////////////////////////////////////

		final String FILEPATH = BACKPATH + "\\" + PICYEAR + "\\" + BACKFILENAME; // 읽어들일 대용량 파일의 위치.
		final String DOCPATH = BACKPATH + "\\" + PICYEAR; // jpg를 출력할 위치

		// 파일에서 읽어 들인다.
		final BufferedReader BR = new BufferedReader(new InputStreamReader(new FileInputStream(FILEPATH), "euc-kr"));// 백업
																														// 파일

		String line = null;// 백업 파일 내 한 행 스트링
		String[] sarr;// line 스트링을 tab을 기준으로 배열화
		final String DOCNAME = DOCPATH + "\\" + PICYEAR + "_architecture.txt"; // 이미지 파일 이름

		final File DOCFILE = new File(DOCNAME);
		final BufferedWriter BW = new BufferedWriter(new FileWriter(DOCFILE, true));
		final PrintWriter PW = new PrintWriter(BW, true);
		int index = 0;

		while ((line = BR.readLine()) != null) {
			System.out.println(index);

			if (index >= EXTNUM) {// 추출할 갯수 설정
				break;
			}

			sarr = line.split("\t");
			for (int i = 0; i < sarr.length; i++) {
				if (i != EXCEPTCOL1 && i != EXCEPTCOL2) {
					PW.write(i + " : " + sarr[i] + "\n");
				} else {
					PW.write(i + " : (Image)\n");
				}
			}
			PW.write("\n//////////////////////////////////////////////////////////////////\n");
			index++;
		}

		PW.close();
		BR.close();
	}

}