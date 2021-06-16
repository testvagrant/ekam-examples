package com.testvagrant.ekamTemplate.db.clients;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface Accounts {
    @SqlQuery("SELECT username from accounts WHERE user_id = :userId")
    String getAccountName(@Bind("userId") Integer userId);
}
