package bokwon;

import bokwon.model.BokwonModel;
import bokwon.service.BokwonService;
import bokwon.util.BokwonFileTotalByteReader;

public class BokwonMain {
	// ���񽺴� �����带 �����Ű�� ���� Ŭ����
	// ���� ������ 1��, �б� ������ 1����, �׿��� ���� ������ ��� ����.
	// �б� �����忡�� ī������ ���μ��� ���� �����忡�� ����ϴ� ����.
	public static void main(String[] args) {

		// 1�� ������ ���� �� ���� ����////////////////////////////////////////////////////
		BokwonModel bm1 = new BokwonModel();
		bm1.setBACKPATH("D:\\ImgBackup");// ��� ������ ��ġ�� ���丮 1
		bm1.setPICYEAR("201701");// ��������� ��ġ�� ���丮 2
		bm1.setBACKFILENAME("backup.back");// ������� ��
		bm1.setAESCode("s8LiEwT3if89Yq3i90hIo3HepqPfOhVd");// AESŰ

		// 1,2 ���� 23, 15�÷�
		// 3,4 ���� 15, 16�÷�
		bm1.setIMG_REG_COL(23);// reg �̹��� �÷�
		bm1.setIMG_LIVE_COL(15);// live �̹��� �÷�

		// 1,2 ���� 11, 17�÷�
		// 3,4 ���� 11, 18�÷�
		bm1.setIMG_EXIST(11);// �̹����� �ִ��� Ȯ���ϴ� �÷�
		bm1.setIMG_SUCCESS(17);// ��Ī ���� ���� �÷�
		// 1�� ������ ���� �� ���� ��////////////////////////////////////////////////////

		// Line �ִ� ���� ���ϴ� ������. �̸� �о���̰� ���� ������ �����Ѵ�.
		Thread tpercent = new Thread(new BokwonFileTotalByteReader(bm1));
		tpercent.start();// ���� �ѷ� ���ϴ� ������ ����

		// ������ �̹����� �����ϴ� ������
		Thread t1 = new Thread(new BokwonService(bm1));
		t1.start();// ���� ������ ����

	}
}
