package bokwon;

import bokwon.model.BokwonModel;
import bokwon.service.BokwonService;
import bokwon.util.BokwonFileTotalByteReader;

public class BokwonMain {
	// 서비스단 쓰레드를 실행시키는 메인 클래스
	// 추출 쓰레드 1개, 읽기 쓰레드 1개로, 그외의 다중 쓰레드 사용 금지.
	// 읽기 쓰레드에서 카운팅한 라인수를 추출 쓰레드에서 사용하는 형식.
	public static void main(String[] args) {

		// 1번 쓰레드 실행 모델 설정 시작////////////////////////////////////////////////////
		BokwonModel bm1 = new BokwonModel();
		bm1.setBACKPATH("D:\\ImgBackup");// 백업 파일이 위치한 디렉토리 1
		bm1.setPICYEAR("201701");// 백업파일이 위치한 디렉토리 2
		bm1.setBACKFILENAME("backup.back");// 백업파일 명
		bm1.setAESCode("s8LiEwT3if89Yq3i90hIo3HepqPfOhVd");// AES키

		// 1,2 번은 23, 15컬럼
		// 3,4 번은 15, 16컬럼
		bm1.setIMG_REG_COL(23);// reg 이미지 컬럼
		bm1.setIMG_LIVE_COL(15);// live 이미지 컬럼

		// 1,2 번은 11, 17컬럼
		// 3,4 번은 11, 18컬럼
		bm1.setIMG_EXIST(11);// 이미지가 있는지 확인하는 컬럼
		bm1.setIMG_SUCCESS(17);// 매칭 성공 여부 컬럼
		// 1번 쓰레드 실행 모델 설정 끝////////////////////////////////////////////////////

		// Line 최대 행을 구하는 쓰레드. 미리 읽어들이고 싶은 파일을 설정한다.
		Thread tpercent = new Thread(new BokwonFileTotalByteReader(bm1));
		tpercent.start();// 파일 총량 구하는 쓰레드 시작

		// 실제로 이미지를 추출하는 쓰레드
		Thread t1 = new Thread(new BokwonService(bm1));
		t1.start();// 추출 쓰레드 시작

	}
}
