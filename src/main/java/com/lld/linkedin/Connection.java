package com.lld.linkedin;

import java.util.Date;

public class Connection {
	private final User sender;
	private final Date connectionDate;

    public Connection(User sender, Date connectionDate) {
        this.sender = sender;
        this.connectionDate = connectionDate;
    }

    public User getUser() {
        return sender;
    }

    public Date getConnectionDate() {
        return connectionDate;
    }
}
