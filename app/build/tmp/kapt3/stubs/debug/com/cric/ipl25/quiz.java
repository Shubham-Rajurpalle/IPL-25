package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u0010/\u001a\u000200H\u0002J\u0012\u00104\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020.H\u0014J\b\u00108\u001a\u00020.H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\'\u001a\u00020(X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006:"}, d2 = {"Lcom/cric/ipl25/quiz;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "fragmentAdapter", "Lcom/cric/ipl25/fragmentAdapter;", "getFragmentAdapter", "()Lcom/cric/ipl25/fragmentAdapter;", "setFragmentAdapter", "(Lcom/cric/ipl25/fragmentAdapter;)V", "handler", "Landroid/os/Handler;", "lottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getLottieAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setLottieAnimationView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "quizArrayList", "Ljava/util/ArrayList;", "Lcom/cric/ipl25/question;", "Lkotlin/collections/ArrayList;", "getQuizArrayList", "()Ljava/util/ArrayList;", "setQuizArrayList", "(Ljava/util/ArrayList;)V", "toast", "Landroid/widget/Toast;", "getToast", "()Landroid/widget/Toast;", "setToast", "(Landroid/widget/Toast;)V", "toastRunnable", "Ljava/lang/Runnable;", "viewModel", "Lcom/cric/ipl25/viewModel/QuizViewModel;", "getViewModel", "()Lcom/cric/ipl25/viewModel/QuizViewModel;", "setViewModel", "(Lcom/cric/ipl25/viewModel/QuizViewModel;)V", "fetchBaseUrlAndInitRetrofit", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "initializeRetrofit", "baseUrl", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showToast", "Companion", "app_debug"})
public final class quiz extends androidx.appcompat.app.AppCompatActivity {
    public com.cric.ipl25.viewModel.QuizViewModel viewModel;
    public com.cric.ipl25.fragmentAdapter fragmentAdapter;
    public java.util.ArrayList<com.cric.ipl25.question> quizArrayList;
    private int count = 0;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Toast toast;
    public com.airbnb.lottie.LottieAnimationView lottieAnimationView;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable toastRunnable = null;
    private static int result = 0;
    private static int totalquestions = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.cric.ipl25.quiz.Companion Companion = null;
    
    public quiz() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cric.ipl25.viewModel.QuizViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.cric.ipl25.viewModel.QuizViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cric.ipl25.fragmentAdapter getFragmentAdapter() {
        return null;
    }
    
    public final void setFragmentAdapter(@org.jetbrains.annotations.NotNull()
    com.cric.ipl25.fragmentAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.cric.ipl25.question> getQuizArrayList() {
        return null;
    }
    
    public final void setQuizArrayList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.cric.ipl25.question> p0) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Toast getToast() {
        return null;
    }
    
    public final void setToast(@org.jetbrains.annotations.Nullable()
    android.widget.Toast p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.airbnb.lottie.LottieAnimationView getLottieAnimationView() {
        return null;
    }
    
    public final void setLottieAnimationView(@org.jetbrains.annotations.NotNull()
    com.airbnb.lottie.LottieAnimationView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void fetchBaseUrlAndInitRetrofit(androidx.viewpager2.widget.ViewPager2 viewPager2) {
    }
    
    private final void initializeRetrofit(java.lang.String baseUrl, androidx.viewpager2.widget.ViewPager2 viewPager2) {
    }
    
    private final void showToast() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/cric/ipl25/quiz$Companion;", "", "()V", "result", "", "getResult", "()I", "setResult", "(I)V", "totalquestions", "getTotalquestions", "setTotalquestions", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getResult() {
            return 0;
        }
        
        public final void setResult(int p0) {
        }
        
        public final int getTotalquestions() {
            return 0;
        }
        
        public final void setTotalquestions(int p0) {
        }
    }
}