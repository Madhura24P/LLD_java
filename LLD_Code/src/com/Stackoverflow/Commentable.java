package com.Stackoverflow;

import java.util.List;

public interface Commentable {
	
	void addComment(Comment c);
	List<Comment> getComments();

}
