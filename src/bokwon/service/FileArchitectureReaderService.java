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
		// ������ϳ� ������ �˾ƺ������� ����.
		// �ش� ������ �а�, �÷����� ������ architecture.txt ���Ϸ� �������.
		// �ش� �ؽ�Ʈ ������ �а� �÷� �м��� ����.

		// ���� ���� ����
		// ����////////////////////////////////////////////////////////////////////////
		final String BACKPATH = fm.getBACKPATH();
		final String PICYEAR = fm.getPICYEAR(); // �ش� ������ ����.
		final String BACKFILENAME = fm.getBACKFILENAME();

		// ���� ������ �÷�
		// 1,2 ���� 15, 23�÷�
		// 3,4 ���� 15, 16�÷�
		final int EXCEPTCOL1 = fm.getEXCEPTCOL1();
		final int EXCEPTCOL2 = fm.getEXCEPTCOL2();

		// ������ ���� ����
		final int EXTNUM = fm.getEXTNUM();
		// ���� ���� ����
		// ��////////////////////////////////////////////////////////////////////////

		final String FILEPATH = BACKPATH + "\\" + PICYEAR + "\\" + BACKFILENAME; // �о���� ��뷮 ������ ��ġ.
		final String DOCPATH = BACKPATH + "\\" + PICYEAR; // jpg�� ����� ��ġ

		// ���Ͽ��� �о� ���δ�.
		final BufferedReader BR = new BufferedReader(new InputStreamReader(new FileInputStream(FILEPATH), "euc-kr"));// ���
																														// ����

		String line = null;// ��� ���� �� �� �� ��Ʈ��
		String[] sarr;// line ��Ʈ���� tab�� �������� �迭ȭ
		final String DOCNAME = DOCPATH + "\\" + PICYEAR + "_architecture.txt"; // �̹��� ���� �̸�

		final File DOCFILE = new File(DOCNAME);
		final BufferedWriter BW = new BufferedWriter(new FileWriter(DOCFILE, true));
		final PrintWriter PW = new PrintWriter(BW, true);
		int index = 0;

		while ((line = BR.readLine()) != null) {
			System.out.println(index);

			if (index >= EXTNUM) {// ������ ���� ����
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