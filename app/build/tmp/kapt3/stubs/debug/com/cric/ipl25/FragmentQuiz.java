package com.cric.ipl25;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/cric/ipl25/FragmentQuiz;", "Landroidx/fragment/app/Fragment;", "quizArray", "Lcom/cric/ipl25/question;", "questionId", "", "(Lcom/cric/ipl25/question;I)V", "binding", "Lcom/crick/ipl25/databinding/FragmentQuizBinding;", "sharedPreferences", "Landroid/content/SharedPreferences;", "enableRadioGroup", "", "isEnabled", "", "highlightCorrectAnswer", "isQuestionAnswerable", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "restoreSelectedOption", "saveAnswer", "selectedOption", "", "saveAnswerTimestamp", "showToast", "isCorrect", "app_debug"})
public final class FragmentQuiz extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.cric.ipl25.question quizArray = null;
    private final int questionId = 0;
    private com.crick.ipl25.databinding.FragmentQuizBinding binding;
    private android.content.SharedPreferences sharedPreferences;
    
    public FragmentQuiz(@org.jetbrains.annotations.NotNull()
    com.cric.ipl25.question quizArray, int questionId) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void enableRadioGroup(boolean isEnabled) {
    }
    
    private final void saveAnswerTimestamp(int questionId) {
    }
    
    private final void saveAnswer(java.lang.String selectedOption) {
    }
    
    private final boolean isQuestionAnswerable(int questionId) {
        return false;
    }
    
    private final void restoreSelectedOption() {
    }
    
    private final void highlightCorrectAnswer() {
    }
    
    private final void showToast(boolean isCorrect) {
    }
}