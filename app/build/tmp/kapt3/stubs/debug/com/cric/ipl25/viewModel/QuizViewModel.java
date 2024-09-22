package com.cric.ipl25.viewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/cric/ipl25/viewModel/QuizViewModel;", "Landroidx/lifecycle/ViewModel;", "questionsApi", "Lcom/cric/ipl25/retrofit/questionsApi;", "(Lcom/cric/ipl25/retrofit/questionsApi;)V", "questionLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/cric/ipl25/questionList;", "getQuestionLiveData", "()Landroidx/lifecycle/LiveData;", "setQuestionLiveData", "(Landroidx/lifecycle/LiveData;)V", "quizRepository", "Lcom/cric/ipl25/repository/quizRepository;", "getQuestionFromLiveData", "app_debug"})
public final class QuizViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.cric.ipl25.retrofit.questionsApi questionsApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cric.ipl25.repository.quizRepository quizRepository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<com.cric.ipl25.questionList> questionLiveData;
    
    public QuizViewModel(@org.jetbrains.annotations.NotNull()
    com.cric.ipl25.retrofit.questionsApi questionsApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.cric.ipl25.questionList> getQuestionLiveData() {
        return null;
    }
    
    public final void setQuestionLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<com.cric.ipl25.questionList> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.cric.ipl25.questionList> getQuestionFromLiveData() {
        return null;
    }
}