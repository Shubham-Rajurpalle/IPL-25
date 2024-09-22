package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/cric/ipl25/ChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/cric/ipl25/ChatAdapter$ChatViewHolder;", "reportListener", "Lcom/cric/ipl25/ChatAdapter$ReportListener;", "messages", "", "Lcom/cric/ipl25/ChatMessage;", "(Lcom/cric/ipl25/ChatAdapter$ReportListener;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMessages", "newMessages", "ChatViewHolder", "ReportListener", "app_debug"})
public final class ChatAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.cric.ipl25.ChatAdapter.ChatViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.cric.ipl25.ChatAdapter.ReportListener reportListener = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.cric.ipl25.ChatMessage> messages;
    
    public ChatAdapter(@org.jetbrains.annotations.NotNull()
    com.cric.ipl25.ChatAdapter.ReportListener reportListener, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cric.ipl25.ChatMessage> messages) {
        super();
    }
    
    public final void setMessages(@org.jetbrains.annotations.NotNull()
    java.util.List<com.cric.ipl25.ChatMessage> newMessages) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.cric.ipl25.ChatAdapter.ChatViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.cric.ipl25.ChatAdapter.ChatViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/cric/ipl25/ChatAdapter$ChatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "listener", "Lcom/cric/ipl25/ChatAdapter$ReportListener;", "(Landroid/view/View;Lcom/cric/ipl25/ChatAdapter$ReportListener;)V", "cardView", "Landroidx/cardview/widget/CardView;", "messageTextView", "Landroid/widget/TextView;", "reportBtn", "Landroid/widget/ImageView;", "teamNameTextView", "timeTextView", "bind", "", "chatMessage", "Lcom/cric/ipl25/ChatMessage;", "getTeamColor", "", "teamId", "", "app_debug"})
    public static final class ChatViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.cric.ipl25.ChatAdapter.ReportListener listener = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView teamNameTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView messageTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView timeTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.cardview.widget.CardView cardView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView reportBtn = null;
        
        public ChatViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.cric.ipl25.ChatAdapter.ReportListener listener) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.cric.ipl25.ChatMessage chatMessage) {
        }
        
        private final int getTeamColor(java.lang.String teamId) {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/cric/ipl25/ChatAdapter$ReportListener;", "", "onReportConfirming", "", "chatMessage", "", "reportCount", "", "app_debug"})
    public static abstract interface ReportListener {
        
        public abstract void onReportConfirming(@org.jetbrains.annotations.NotNull()
        java.lang.String chatMessage, int reportCount);
    }
}