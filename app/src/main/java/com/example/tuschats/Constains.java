package com.example.tuschats;

import java.util.HashMap;

public class Constains {
    public static final String REMOTE_MSG_AUTHORIZATION="Authorization";
    public static final String REMOTE_MSG_CONTENT_TYPE="Content-Type";

    public static final String REMOTE_MSG_TYPE="type";
    public static final String REMOTE_MSG_INVITATION="invitation";
    public static final String REMOTE_MSG_MEETING_TYPE="meetingType";
    public static final String REMOTE_MSG_INVITER_TOKEN="inviterToken";
    public static final String REMOTE_MSG_DATA="data";
    public static final String REMOTE_MSG_REGISTRATION_IDS="registration_ids";
    public static HashMap<String,String>getRemoteMessageHeaders(){
        HashMap<String,String>headers=new HashMap<>();
        headers.put(Constains.REMOTE_MSG_AUTHORIZATION,
                "key=AAAADSpshL8:APA91bH_oSJjGB3EevA3_EReGBG0w9eX4sHntivQKwhpoFYtSYUHg9ReY0gtXlw0E6inSDoGT-BUrMJgcdgct02N3_oiZXJNl1UaICUKm77gC06XZ6UUlrMW5gPjUp-1iQjeo7AO_Uyj"
        );
        headers.put(Constains.REMOTE_MSG_CONTENT_TYPE,"application/json");
        return headers;
    }
}
