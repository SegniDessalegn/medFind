package com.gis.medfind.service;

import com.gis.medfind.entity.Request;

public interface RequestHandlingService {

    public void newRequest(Request rq);

    public void acceptRequest(Request rq);

    public void rejectRequest(Long rq);
    
}
