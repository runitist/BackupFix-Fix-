package bokwon;

import bokwon.model.FileArchitectureReaderModel;
import bokwon.service.FileArchitectureReaderService;

public class FileArchitectureReaderMain {
	public static void main(String[] args) {
		// 1번 쓰레드 실행 모델 설정 시작////////////////////////////////////////////////////
		FileArchitectureReaderModel fm1 = new FileArchitectureReaderModel();

		fm1.setBACKPATH("D:\\ImgBackup");// 추출 루트디렉토리
		fm1.setBACKFILENAME("backup.back");// 추출 파일 이름
		fm1.setPICYEAR("201703");// 해당 사진의 연월.

		// 1,2 번은 15, 23컬럼
		// 3,4 번은 15, 16컬럼
		fm1.setEXCEPTCOL1(15);// 추출 제외할 이미지 컬럼
		fm1.setEXCEPTCOL2(16);// 추출 제외할 이미지 컬럼

		// 추출할 갯수 설정
		fm1.setEXTNUM(1000);// 추출 개수
		// 1번 쓰레드 실행 모델 설정 끝////////////////////////////////////////////////////

		Thread t1 = new Thread(new FileArchitectureReaderService(fm1));
		t1.start();

	}

}
