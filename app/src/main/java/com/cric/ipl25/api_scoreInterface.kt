import com.cric.ipl25.data_to_show_ipl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface api_scoreInterface {
    @GET("match_info?apikey=656cfa71-1ad3-4a35-b41c-6da66a4a5b9b&offset=0")
    suspend fun getData(@Query("id") matchId: Any?): Response<data_to_show_ipl>
}
