package hackspace.com.libertrash;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JLex on 25/11/17.
 */

public interface FirebaseService {

    @GET("reporte/.json?Auth=M4hBXIVFYSn6NHeyo8NYniN2oFGOiExK15vpFqDm")
    Call<List<Reporte>> listaReporte();//@Query("Auth") String auth
}
