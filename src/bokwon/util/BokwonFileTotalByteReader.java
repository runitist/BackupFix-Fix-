package bokwon.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import bokwon.model.BokwonModel;

public class BokwonFileTotalByteReader implements Runnable {
	// �����ϴ� ������ �ǽð����� �о���̸� ������ ī��Ʈ�ϴ� ������
	// ����� ���μ��� �о���̴� ���̶� �����ϴ� �������� �ӵ��� �ɰ��Ѵ�.

	private BokwonModel bm;

	// ���� �������� �о���� �� ����. static���� �� �����庰 ������ �����Ѵ�.
	public static long totalLine = 0;// �ܺο����� �� ������ �����ؼ� ���� ������� �� ���μ��� �ǽð����� ���� �ȴ�.

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
		final BufferedReader BR;// ��� ���� ������ ������ ���� ����
		final String BACKPATH = bm.getBACKPATH();// ��������� ��ġ�� ��.
		final String PICYEAR = bm.getPICYEAR(); // �ش� ������ ����. �� : 201701
		final String BACKFILENAME = bm.getBACKFILENAME();// ��� ���� �̸�

		// ���Ͽ��� �о� ���δ�.
		BR = new BufferedReader(
				new InputStreamReader(new FileInputStream(BACKPATH + "\\" + PICYEAR + "\\" + BACKFILENAME), "euc-kr"));// ����
																														// ��ü
																														// �ʱ�ȭ

		while (BR.readLine() != null) {
			// ���� ���� �о totalLine�� 1�� �ø�.
			totalLine++;
		}
		BR.close();
	}
}
