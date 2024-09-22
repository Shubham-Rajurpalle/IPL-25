package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u001aJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001fR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006$"}, d2 = {"Lcom/cric/ipl25/MemeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_error", "Landroidx/lifecycle/MutableLiveData;", "", "_memes", "", "Lcom/cric/ipl25/Meme_data;", "actionListener", "Lcom/cric/ipl25/MemeViewModel$MemeActionListener;", "getActionListener", "()Lcom/cric/ipl25/MemeViewModel$MemeActionListener;", "setActionListener", "(Lcom/cric/ipl25/MemeViewModel$MemeActionListener;)V", "error", "Landroidx/lifecycle/LiveData;", "getError", "()Landroidx/lifecycle/LiveData;", "setError", "(Landroidx/lifecycle/LiveData;)V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "memes", "getMemes", "deleteMeme", "", "memeId", "loadMemes", "reportConfirm", "reportCount", "", "reportMeme", "updateLikesCount", "likesCount", "MemeActionListener", "app_debug"})
public final class MemeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.cric.ipl25.Meme_data>> _memes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.lang.String> error;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.Nullable()
    private com.cric.ipl25.MemeViewModel.MemeActionListener actionListener;
    
    public MemeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.cric.ipl25.Meme_data>> getMemes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getError() {
        return null;
    }
    
    public final void setError(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.lang.String> p0) {
    }
    
    public final void loadMemes() {
    }
    
    public final void updateLikesCount(@org.jetbrains.annotations.NotNull()
    java.lang.String memeId, int likesCount) {
    }
    
    public final void deleteMeme(@org.jetbrains.annotations.NotNull()
    java.lang.String memeId) {
    }
    
    public final void reportMeme(@org.jetbrains.annotations.NotNull()
    java.lang.String memeId, int reportCount) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cric.ipl25.MemeViewModel.MemeActionListener getActionListener() {
        return null;
    }
    
    public final void setActionListener(@org.jetbrains.annotations.Nullable()
    com.cric.ipl25.MemeViewModel.MemeActionListener p0) {
    }
    
    public final void reportConfirm(@org.jetbrains.annotations.NotNull()
    java.lang.String memeId, int reportCount) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/cric/ipl25/MemeViewModel$MemeActionListener;", "", "showReportConfirmation", "", "memeId", "", "reportCount", "", "app_debug"})
    public static abstract interface MemeActionListener {
        
        public abstract void showReportConfirmation(@org.jetbrains.annotations.NotNull()
        java.lang.String memeId, int reportCount);
    }
}