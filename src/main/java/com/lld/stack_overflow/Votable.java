package com.lld.stack_overflow;

import java.util.List;

interface Votable {
	void addVote(User user, VoteType type);
	int getVotes();
}
