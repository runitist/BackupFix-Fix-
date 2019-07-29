package bokwon;

import bokwon.model.FileArchitectureReaderModel;
import bokwon.service.FileArchitectureReaderService;

public class FileArchitectureReaderMain {
	public static void main(String[] args) {
		// 1�� ������ ���� �� ���� ����////////////////////////////////////////////////////
		FileArchitectureReaderModel fm1 = new FileArchitectureReaderModel();

		fm1.setBACKPATH("D:\\ImgBackup");// ���� ��Ʈ���丮
		fm1.setBACKFILENAME("backup.back");// ���� ���� �̸�
		fm1.setPICYEAR("201703");// �ش� ������ ����.

		// 1,2 ���� 15, 23�÷�
		// 3,4 ���� 15, 16�÷�
		fm1.setEXCEPTCOL1(15);// ���� ������ �̹��� �÷�
		fm1.setEXCEPTCOL2(16);// ���� ������ �̹��� �÷�

		// ������ ���� ����
		fm1.setEXTNUM(1000);// ���� ����
		// 1�� ������ ���� �� ���� ��////////////////////////////////////////////////////

		Thread t1 = new Thread(new FileArchitectureReaderService(fm1));
		t1.start();

	}

}
