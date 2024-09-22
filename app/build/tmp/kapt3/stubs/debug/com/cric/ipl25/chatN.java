package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/cric/ipl25/chatN;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/cric/ipl25/ChatAdapter$ReportListener;", "Lcom/cric/ipl25/reportFragmentChat$ReportConfirmationListener;", "()V", "TAG", "", "chatAdapter", "Lcom/cric/ipl25/ChatAdapter;", "mInterstitialAd", "Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "teamId", "teamName", "viewModel", "Lcom/cric/ipl25/ChatViewModel;", "getViewModel", "()Lcom/cric/ipl25/ChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTeamColor", "", "loadInterstitialAd", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onReportConfirmed", "chatId", "reportCount", "onReportConfirming", "chatMessage", "setupBackButton", "setupSendButton", "setupTeamData", "app_debug"})
public final class chatN extends androidx.appcompat.app.AppCompatActivity implements com.cric.ipl25.ChatAdapter.ReportListener, com.cric.ipl25.reportFragmentChat.ReportConfirmationListener {
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialAd;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "chat_activity";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.cric.ipl25.ChatAdapter chatAdapter;
    private java.lang.String teamId;
    private java.lang.String teamName;
    
    public chatN() {
        super();
    }
    
    private final com.cric.ipl25.ChatViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onReportConfirming(@org.jetbrains.annotations.NotNull()
    java.lang.String chatMessage, int reportCount) {
    }
    
    @java.lang.Override()
    public void onReportConfirmed(@org.jetbrains.annotations.NotNull()
    java.lang.String chatId, int reportCount) {
    }
    
    private final void setupTeamData() {
    }
    
    private final int getTeamColor(java.lang.String teamId) {
        return 0;
    }
    
    private final void setupSendButton() {
    }
    
    private final void setupBackButton() {
    }
    
    public final void loadInterstitialAd() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}