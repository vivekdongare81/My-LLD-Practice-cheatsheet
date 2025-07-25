package com.lld.social_networking;

import java.sql.Timestamp;

public class Like {
    private final User user;
    private final Timestamp timestamp;

    public Like(User user) {
        this.user = user;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
