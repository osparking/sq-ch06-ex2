package services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import model.Comment;
import util.MyUtil;

@Service
public class CommentService {
	Logger logger = Logger.getLogger(CommentService.class.getName());
	
	public String publishComment(Comment comment) {
		logger.addHandler(MyUtil.handler);
		logger.setUseParentHandlers(false);
		logger.info("출판한 코맨트: " + comment.getText());
		return "성공";
	}

}
