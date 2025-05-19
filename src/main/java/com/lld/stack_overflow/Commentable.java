package com.lld.stack_overflow;

import java.util.List;

interface Commentable {
	void addComment(Comment comment);
	List<Comment>getComments();
}
