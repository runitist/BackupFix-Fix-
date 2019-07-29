package bokwon.model;

public class FileArchitectureReaderModel {
	// FileArchitectureReader에 대한 VO 객체

	private String BACKPATH;
	private String PICYEAR; // 해당 사진의 연월.
	private String BACKFILENAME;

	// 1,2 번은 15, 23컬럼
	// 3,4 번은 15, 16컬럼
	private int EXCEPTCOL1;

	public String getBACKPATH() {
		return BACKPATH;
	}

	public void setBACKPATH(String bACKPATH) {
		BACKPATH = bACKPATH;
	}

	public String getBACKFILENAME() {
		return BACKFILENAME;
	}

	public void setBACKFILENAME(String bACKFILENAME) {
		BACKFILENAME = bACKFILENAME;
	}

	private int EXCEPTCOL2;

	// 추출할 갯수 설정
	private int EXTNUM;

	public String getPICYEAR() {
		return PICYEAR;
	}

	public void setPICYEAR(String pICYEAR) {
		PICYEAR = pICYEAR;
	}

	public int getEXCEPTCOL1() {
		return EXCEPTCOL1;
	}

	public void setEXCEPTCOL1(int eXCEPTCOL1) {
		EXCEPTCOL1 = eXCEPTCOL1;
	}

	public int getEXCEPTCOL2() {
		return EXCEPTCOL2;
	}

	public void setEXCEPTCOL2(int eXCEPTCOL2) {
		EXCEPTCOL2 = eXCEPTCOL2;
	}

	public int getEXTNUM() {
		return EXTNUM;
	}

	public void setEXTNUM(int eXTNUM) {
		EXTNUM = eXTNUM;
	}

}
