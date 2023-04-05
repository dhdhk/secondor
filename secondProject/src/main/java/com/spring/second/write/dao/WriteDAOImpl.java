package com.spring.second.write.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.second.board.dto.BoardDTO;
import com.spring.second.write.dto.ImageDTO;

@Repository
public class WriteDAOImpl implements WriteDAO{
	@Autowired
	SqlSession sqlSession;
	@Autowired
	BoardDTO boardDTO;
	
	@Override
	public void insertNewArticle(Map<String, Object> articleMap) throws DataAccessException{
		// TODO Auto-generated method stub
		
		sqlSession.insert("mapper.writeArticle.insertNewArticle",articleMap);
		if(articleMap.get("pr_img1")==null) {
			
		}else if(articleMap.get("pr_img2")==null) {
			sqlSession.update("mapper.writeArticle.insertNewimg1", articleMap);
		}else if(articleMap.get("pr_img3")==null) {
			sqlSession.update("mapper.writeArticle.insertNewimg2", articleMap);
		}else {
			sqlSession.update("mapper.writeArticle.insertNewimg3", articleMap);
		}
	}

	public int selectNewRegNum() throws DataAccessException{
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("mapper.writeArticle.selectNewRegNum");
	}

	@Override
	public void insertNewImage(Map<String, Object> articleMap) throws DataAccessException{
		// TODO Auto-generated method stub
		List<ImageDTO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int regNum=(Integer)articleMap.get("regNum");
		int imageFileNo=selectNewImageFileNo();
		for(ImageDTO imageDTO:imageFileList) {
			imageDTO.setImageFileNo(++imageFileNo);
			imageDTO.setRegNum(regNum);
		}
		sqlSession.insert("mapper.writeImage.insertNewImage", imageFileList);
	}

	private int selectNewImageFileNo() throws DataAccessException{
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("mapper.writeImage.selectNewImageFileNo");
	}

}
