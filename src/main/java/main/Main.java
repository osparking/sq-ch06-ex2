package main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import model.Comment;
import services.CommentService;
import util.MyUtil;

public class Main {
	private static Logger logger = MyUtil.logger(Main.class.getName());
	
	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var service = ctx.getBean(CommentService.class);

		var cmt = new Comment();
		cmt.setText("오늘은 화요일");
		cmt.setAuthor("관리인");

		String result = service.publishComment(cmt);
		logger.info("코맨트 출판 결과: " + result);
	}

}
