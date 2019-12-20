package com.project.www.service;

import java.io.File;

import javax.servlet.http.HttpSession;

import com.project.www.util.FileUtil;
import com.project.www.vo.GalleryVO;
import com.project.www.dao.*;

public class FileService {

	   FileDAO fDAO;
	   
	   public void setDAO(FileDAO fDAO) {
	      this.fDAO = fDAO;
	   };
	// ������ ������Ʈ
		public GalleryVO Galleryup(HttpSession session, GalleryVO gVO) {

			// �� �Լ��� ������ ���ε� �ϱ� ���ؼ� ��Ʈ�ѷ����� ���ε��� ������ ������ �޾ƿ;� �Ѵ�.
			// �� ������ MultipartFile �̶�� Ÿ������ ������ �� ���̰�
			// �ű⼭ ������ ����ؾ� �Ѵ�.

			// �����̸��� ����� ����
			String saveName = "";
			long len = 0;
			int cnt = 0;
			String spath = session.getServletContext().getRealPath("resources/upload");
			/* spath ��� ��� �κ� */
			System.out.println("spath : " + spath);

			String rePath = spath.substring(0, spath.indexOf("\\.metadata"));
			rePath = rePath + "\\project\\src\\main\\webapp\\resources\\upload";
			/* repath ������ �κ� */
			System.out.println("repath : " + rePath);
			System.out.println("");

			/* Ŭ���̾�Ʈ�� ���ε��� �����̸��� �˾Ƴ���. */
			String oriName = gVO.getsFile().getOriginalFilename();

			if (oriName == null || oriName.length() == 0) {
				return gVO;
			}

			// �� ������ ����ȴٴ� �ǹ̴� ���ε��� ������ �����Ѵٴ� �̾߱� �̴�.
			// Ȥ�� ���ε��� �����ϰ� �ߺ��Ǵ� �̸��� ������ �̹� �����ϴ��� �˻��ؼ�
			// �ִ� ���� �ٸ��̸����� ������ �ؾ� �Ѵ�.

			String tmp = FileUtil.rename(spath, oriName);

			// ������ �̸��� �������Ƿ� �غ�� ������ ����� ���´�.
			saveName = tmp;

			// ���� ���ε�� ������ �츮�� �������� ��ο� �����Ѵ�.
			// �� �̸��� ���� �����ͺ��̽��� ����� �� ����ؾ� �Ѵ�.
			// ���� �̸��� ����� ���� �ʿ䰡 �����.

			try {
				File file = new File(spath, saveName);
				gVO.getsFile().transferTo(file);
				System.out.println("### dao ���� ���ε� ���� !!! ###");

				len = gVO.getsFile().getSize();

				file = new File(rePath, saveName);
				gVO.getsFile().transferTo(file);
				System.out.println("### ���� ���ε� ����2 !!! ###");

			} catch (Exception e) {
				e.printStackTrace();
			}

			gVO.setOriName(oriName);
			gVO.setSaveName(saveName);
			gVO.setLen(len);
			gVO.setDir(gVO.getDir());
			

		/* fDAO.addgallery(gVO); */

			System.out.println("gvo+"+gVO);
			return gVO;

		}
	
}
