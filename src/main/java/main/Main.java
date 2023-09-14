package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import model.Comment;
import services.CommentService;

public class Main {

	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var service = ctx.getBean(CommentService.class);

		var cmt = new Comment();
		cmt.setText("오늘은 화요일");
		cmt.setAuthor("관리인");

		service.publishComment(cmt);
	}

}
