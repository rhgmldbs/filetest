package com.project.www.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.www.dao.FileDAO;
import com.project.www.service.FileService;
import com.project.www.vo.GalleryVO;

@Controller
@RequestMapping("/board/")
public class Board {

@Autowired
FileDAO fDAO;
@Autowired
FileService fileSrvc;

@RequestMapping("uploading.van")
public void uploadingform(ModelAndView mv) {
	mv.setViewName("board/uploading");

}

@RequestMapping("gallery.van")
public ModelAndView galleryproc(ModelAndView mv, GalleryVO vo, HttpSession session, RedirectView rv) {

	fileSrvc.setDAO(fDAO);
	vo =fileSrvc.Galleryup(session, vo);

	fDAO.addgallery(vo);
	rv.setUrl("/www/board/gallerylist.van");
	mv.setView(rv);

	return mv;
}

@RequestMapping("gallerylist.van")
public ModelAndView gallerylist(ModelAndView mv, HttpSession session) {
	List<GalleryVO> list = fDAO.gallerylist();
	session.setAttribute("SID", "kk");
	mv.addObject("LIST", list);
	mv.setViewName("board/gallery");

	return mv;
}

  @RequestMapping("galleryconfig.van") //갤러리 수정 
  public ModelAndView galleryconfig(ModelAndView mv, GalleryVO gVO, HttpSession session, RedirectView rv) {

	  	
	  fileSrvc.setDAO(fDAO);
	  		
	  		
	  gVO= fileSrvc.Galleryup(session, gVO);
	   fDAO.galleryconfig(gVO);
	  		rv.setUrl("/www/board/gallerylist.van");
	  		
	  		mv.setView(rv);

  return mv; 
  
  }
 
 @RequestMapping("gallerycontent.van") //갤러리 상세보기 
 public ModelAndView gallerycontent(ModelAndView mv, GalleryVO gVO){
	 

	 GalleryVO vo =fDAO.gallerycontent(gVO);
	
	 mv.addObject("vo",vo);
	 mv.setViewName("/board/gallerycontent");
	 
	 return mv;
	 
 }
 
 @RequestMapping("gallerydelete.van") //갤러리 삭제 
 public ModelAndView gallerydelete(ModelAndView mv, GalleryVO gVO, RedirectView rv) {
	 System.out.println(gVO.getGno());
	 
	 fDAO.gallerydelect(gVO);
	 rv.setUrl("/www/board/gallerylist.van");
	 mv.setView(rv);
	 
	 return mv;
 }

 
}
