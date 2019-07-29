package bokwon.model;

public class BokwonModel {
	// 복원 시리즈 VO 모델

	private String BACKPATH; // 백업 파일이 위치한 디렉토리 1
	private String PICYEAR;// 백업파일이 위치한 디렉토리 2
	private String BACKFILENAME;// 백업파일 명
	private String AESCode;// AES키

	// 1,2 번은 15, 23컬럼
	// 3,4 번은 15, 16컬럼
	private int IMG_REG_COL;// reg 이미지 컬럼
	private int IMG_LIVE_COL;// live 이미지 컬럼

	// 1,2 번은 11, 17컬럼
	// 3,4 번은 11, 18컬럼
	private int IMG_EXIST;// 이미지가 있는지 확인하는 컬럼
	private int IMG_SUCCESS;// 매칭 성공 여부 컬럼

	public String getBACKPATH() {
		return BACKPATH;
	}

	public void setBACKPATH(String bACKPATH) {
		BACKPATH = bACKPATH;
	}

	public String getPICYEAR() {
		return PICYEAR;
	}

	public void setPICYEAR(String pICYEAR) {
		PICYEAR = pICYEAR;
	}

	public String getBACKFILENAME() {
		return BACKFILENAME;
	}

	public void setBACKFILENAME(String bACKFILENAME) {
		BACKFILENAME = bACKFILENAME;
	}

	public String getAESCode() {
		return AESCode;
	}

	public void setAESCode(String aESCode) {
		AESCode = aESCode;
	}

	public int getIMG_REG_COL() {
		return IMG_REG_COL;
	}

	public void setIMG_REG_COL(int iMG_REG_COL) {
		IMG_REG_COL = iMG_REG_COL;
	}

	public int getIMG_LIVE_COL() {
		return IMG_LIVE_COL;
	}

	public void setIMG_LIVE_COL(int iMG_LIVE_COL) {
		IMG_LIVE_COL = iMG_LIVE_COL;
	}

	public int getIMG_EXIST() {
		return IMG_EXIST;
	}

	public void setIMG_EXIST(int iMG_EXIST) {
		IMG_EXIST = iMG_EXIST;
	}

	public int getIMG_SUCCESS() {
		return IMG_SUCCESS;
	}

	public void setIMG_SUCCESS(int iMG_SUCCESS) {
		IMG_SUCCESS = iMG_SUCCESS;
	}

}
