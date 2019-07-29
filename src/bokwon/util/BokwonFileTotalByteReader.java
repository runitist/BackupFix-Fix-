package bokwon.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import bokwon.model.BokwonModel;

public class BokwonFileTotalByteReader implements Runnable {
	// 추출하는 파일을 실시간으로 읽어들이며 라인을 카운트하는 쓰레드
	// 기능이 라인수만 읽어들이는 것이라 추출하는 쓰레드의 속도를 능가한다.

	private BokwonModel bm;

	// 버퍼 라인으로 읽어들인 총 라인. static으로 각 쓰레드별 변수를 공유한다.
	public static long totalLine = 0;// 외부에서는 이 변수에 접근해서 현재 계산중인 총 라인수를 실시간으로 얻어가면 된다.

	public BokwonFileTotalByteReader(BokwonModel bm) {
		this.bm = bm;
	}

	@Override
	public void run() {
		try {
			getTotalLine(bm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getTotalLine(BokwonModel bm) throws Exception {
		final BufferedReader BR;// 백업 파일 정보를 가져올 버퍼 리더
		final String BACKPATH = bm.getBACKPATH();// 백업파일이 위치한 곳.
		final String PICYEAR = bm.getPICYEAR(); // 해당 사진의 연월. 예 : 201701
		final String BACKFILENAME = bm.getBACKFILENAME();// 백업 파일 이름

		// 파일에서 읽어 들인다.
		BR = new BufferedReader(
				new InputStreamReader(new FileInputStream(BACKPATH + "\\" + PICYEAR + "\\" + BACKFILENAME), "euc-kr"));// 리딩
																														// 객체
																														// 초기화

		while (BR.readLine() != null) {
			// 한줄 한줄 읽어서 totalLine을 1씩 늘림.
			totalLine++;
		}
		BR.close();
	}
}
