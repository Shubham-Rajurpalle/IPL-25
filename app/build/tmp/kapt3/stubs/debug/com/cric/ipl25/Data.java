package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00af\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u001aJ\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010H\u00c6\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\u0005H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0005H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0005H\u00c6\u0003J\u00d9\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020HH\u00d6\u0001J\t\u0010I\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001e\u00a8\u0006J"}, d2 = {"Lcom/cric/ipl25/Data;", "", "bbbEnabled", "", "date", "", "dateTimeGMT", "fantasyEnabled", "hasSquad", "id", "matchEnded", "matchStarted", "matchType", "matchWinner", "name", "score", "", "Lcom/cric/ipl25/Score;", "series_id", "status", "teamInfo", "Lcom/cric/ipl25/TeamInfo;", "teams", "tossChoice", "tossWinner", "venue", "(ZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBbbEnabled", "()Z", "getDate", "()Ljava/lang/String;", "getDateTimeGMT", "getFantasyEnabled", "getHasSquad", "getId", "getMatchEnded", "getMatchStarted", "getMatchType", "getMatchWinner", "getName", "getScore", "()Ljava/util/List;", "getSeries_id", "getStatus", "getTeamInfo", "getTeams", "getTossChoice", "getTossWinner", "getVenue", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class Data {
    private final boolean bbbEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String date = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dateTimeGMT = null;
    private final boolean fantasyEnabled = false;
    private final boolean hasSquad = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    private final boolean matchEnded = false;
    private final boolean matchStarted = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String matchType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String matchWinner = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.cric.ipl25.Score> score = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String series_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.cric.ipl25.TeamInfo> teamInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> teams = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tossChoice = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tossWinner = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String venue = null;
    
    public Data(boolean bbbEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String dateTimeGMT, boolean fantasyEnabled, boolean hasSquad, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean matchEnded, boolean matchStarted, @org.jetbrains.annotations.NotNull()
    java.lang.String matchType, @org.jetbrains.annotations.NotNull()
    java.lang.String matchWinner, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cric.ipl25.Score> score, @org.jetbrains.annotations.NotNull()
    java.lang.String series_id, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cric.ipl25.TeamInfo> teamInfo, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> teams, @org.jetbrains.annotations.NotNull()
    java.lang.String tossChoice, @org.jetbrains.annotations.NotNull()
    java.lang.String tossWinner, @org.jetbrains.annotations.NotNull()
    java.lang.String venue) {
        super();
    }
    
    public final boolean getBbbEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateTimeGMT() {
        return null;
    }
    
    public final boolean getFantasyEnabled() {
        return false;
    }
    
    public final boolean getHasSquad() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final boolean getMatchEnded() {
        return false;
    }
    
    public final boolean getMatchStarted() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMatchType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMatchWinner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cric.ipl25.Score> getScore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeries_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cric.ipl25.TeamInfo> getTeamInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTeams() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTossChoice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTossWinner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVenue() {
        return null;
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cric.ipl25.Score> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cric.ipl25.TeamInfo> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cric.ipl25.Data copy(boolean bbbEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String dateTimeGMT, boolean fantasyEnabled, boolean hasSquad, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean matchEnded, boolean matchStarted, @org.jetbrains.annotations.NotNull()
    java.lang.String matchType, @org.jetbrains.annotations.NotNull()
    java.lang.String matchWinner, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cric.ipl25.Score> score, @org.jetbrains.annotations.NotNull()
    java.lang.String series_id, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cric.ipl25.TeamInfo> teamInfo, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> teams, @org.jetbrains.annotations.NotNull()
    java.lang.String tossChoice, @org.jetbrains.annotations.NotNull()
    java.lang.String tossWinner, @org.jetbrains.annotations.NotNull()
    java.lang.String venue) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}