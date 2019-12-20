package com.project.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.www.vo.GalleryVO;

public class FileDAO {

	@Autowired
	SqlSessionTemplate sqlSeesion;

//������ ���� ���� ó�� �Լ� 
	public int addgallery(GalleryVO gVO) {
		return sqlSeesion.insert("mSQL.addgallery", gVO);

	}
//������ ���� ����Ʈ ���� ó�� �Լ�

	public List<GalleryVO> gallerylist() {
		List<GalleryVO> list = sqlSeesion.selectList("mSQL.gallerylist");
		return list;

	}
//������ ���� ���� ó�� ���� �Լ�

	public int galleryconfig(GalleryVO gVO) {
		return sqlSeesion.update("mSQL.galleryconf", gVO);
	}
//������ ���� �󼼺��� ���� ó�� �Լ�
public GalleryVO gallerycontent(GalleryVO gVO) {	
	return sqlSeesion.selectOne("mSQL.gallerycontent", gVO);
	
}
//������ ���� ���� ���� ó�� �Լ� 

public int gallerydelect(GalleryVO gVO) {

	return sqlSeesion.update("mSQL.delete", gVO);
	
	 
	
}
}