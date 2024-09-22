
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lapi_scoreInterface;", "", "getData", "Lretrofit2/Response;", "Lcom/cric/ipl25/data_to_show_ipl;", "matchId", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface api_scoreInterface {
    
    @retrofit2.http.GET(value = "match_info?apikey=656cfa71-1ad3-4a35-b41c-6da66a4a5b9b&offset=0")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getData(@retrofit2.http.Query(value = "id")
    @org.jetbrains.annotations.Nullable()
    java.lang.Object matchId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.cric.ipl25.data_to_show_ipl>> $completion);
}