package com.example.HouseRules.model;

import java.time.LocalDate;
import java.util.HashMap;

public class SessionManager {
    private int nextID;
    public class SessionInfo {
        public int userId;
        public LocalDate date;

        public SessionInfo(int userId) {
            this.date = LocalDate.now();
            this.userId = userId;
        }
    }

    private HashMap<Integer, SessionInfo> allSessions;

    public SessionManager() {
        this.allSessions = new HashMap<>();
        this.nextID = 0;
    }

    public Integer createSession(int userId) {
        SessionInfo info = new SessionInfo(userId);
        int sessionID = nextID++;
        allSessions.put(sessionID, info);
        return sessionID;
    }

    public boolean sessionIsValid(int sessionId) {
        SessionInfo info = this.allSessions.get(sessionId);

        return (info != null) && (info.date.equals(LocalDate.now()));
    }

    public void clearExpiredSessions() {
        HashMap<Integer, SessionInfo> validSessions = new HashMap<>();

        for (Integer key: allSessions.keySet()) {
            if (sessionIsValid(key)) {
                validSessions.put(key, allSessions.get(key));
            }
        }

        this.allSessions = validSessions;
    }
}