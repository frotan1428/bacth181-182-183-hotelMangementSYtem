package com.tpe.hms.service;

import com.tpe.hms.model.Guest;

public interface GuestService {

    //step  22 c : save Guest

    Guest saveGuest();

    //step 23 c : find Guest By Id

    void findGuestByID(Long id);




}
