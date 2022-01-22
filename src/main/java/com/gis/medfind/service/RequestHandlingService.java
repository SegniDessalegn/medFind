package com.gis.medfind.service;

import java.util.List;

import com.gis.medfind.entity.Request;

public interface RequestHandlingService {

    public List<Request> getAllRequests();

    public void newRequest(Request rq);

    public void acceptRequest(Request rq);

    public void rejectRequest(Long rq);
    
}
