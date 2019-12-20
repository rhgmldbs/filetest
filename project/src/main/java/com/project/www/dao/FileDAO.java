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

//갤러리 파일 전담 처리 함수 
	public int addgallery(GalleryVO gVO) {
		return sqlSeesion.insert("mSQL.addgallery", gVO);

	}
//갤러리 파일 리스트 전담 처리 함수

	public List<GalleryVO> gallerylist() {
		List<GalleryVO> list = sqlSeesion.selectList("mSQL.gallerylist");
		return list;

	}
//갤러리 파일 수정 처리 전담 함수

	public int galleryconfig(GalleryVO gVO) {
		return sqlSeesion.update("mSQL.galleryconf", gVO);
	}
//갤러리 파일 상세보기 전담 처리 함수
public GalleryVO gallerycontent(GalleryVO gVO) {	
	return sqlSeesion.selectOne("mSQL.gallerycontent", gVO);
	
}
//갤러리 파일 삭제 전담 처리 함수 

public int gallerydelect(GalleryVO gVO) {

	return sqlSeesion.update("mSQL.delete", gVO);
	
	 
	
}
}