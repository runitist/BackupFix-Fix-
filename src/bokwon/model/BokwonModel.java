package bokwon.model;

public class BokwonModel {
	// ���� �ø��� VO ��

	private String BACKPATH; // ��� ������ ��ġ�� ���丮 1
	private String PICYEAR;// ��������� ��ġ�� ���丮 2
	private String BACKFILENAME;// ������� ��
	private String AESCode;// AESŰ

	// 1,2 ���� 15, 23�÷�
	// 3,4 ���� 15, 16�÷�
	private int IMG_REG_COL;// reg �̹��� �÷�
	private int IMG_LIVE_COL;// live �̹��� �÷�

	// 1,2 ���� 11, 17�÷�
	// 3,4 ���� 11, 18�÷�
	private int IMG_EXIST;// �̹����� �ִ��� Ȯ���ϴ� �÷�
	private int IMG_SUCCESS;// ��Ī ���� ���� �÷�

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
