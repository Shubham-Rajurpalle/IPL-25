package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/cric/ipl25/meme;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/cric/ipl25/reportFragment$ConfirmationListener;", "()V", "TAG", "", "binding", "Lcom/crick/ipl25/databinding/ActivityMemeBinding;", "mInterstitialAd", "Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "memeAdapter", "Lcom/cric/ipl25/MemeAdapter;", "memeList", "", "Lcom/cric/ipl25/Meme_data;", "viewModel", "Lcom/cric/ipl25/MemeViewModel;", "getViewModel", "()Lcom/cric/ipl25/MemeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onConfirmReport", "", "memeId", "reportCount", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class meme extends androidx.appcompat.app.AppCompatActivity implements com.cric.ipl25.reportFragment.ConfirmationListener {
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialAd;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "MemeActivity";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.crick.ipl25.databinding.ActivityMemeBinding binding;
    private com.cric.ipl25.MemeAdapter memeAdapter;
    private java.util.List<com.cric.ipl25.Meme_data> memeList;
    
    public meme() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cric.ipl25.MemeViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onConfirmReport(@org.jetbrains.annotations.NotNull()
    java.lang.String memeId, int reportCount) {
    }
}