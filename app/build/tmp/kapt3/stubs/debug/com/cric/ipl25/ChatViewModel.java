package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/cric/ipl25/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_messages", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/cric/ipl25/ChatMessage;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "messages", "Landroidx/lifecycle/LiveData;", "getMessages", "()Landroidx/lifecycle/LiveData;", "listenForMessages", "", "sendMessage", "message", "updateReportCount", "chatId", "", "reportCount", "", "app_debug"})
public final class ChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.cric.ipl25.ChatMessage>> _messages = null;
    
    public ChatViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.cric.ipl25.ChatMessage>> getMessages() {
        return null;
    }
    
    private final void listenForMessages() {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    com.cric.ipl25.ChatMessage message) {
    }
    
    public final void updateReportCount(@org.jetbrains.annotations.NotNull()
    java.lang.String chatId, int reportCount) {
    }
}