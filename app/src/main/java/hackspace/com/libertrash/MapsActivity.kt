package hackspace.com.libertrash

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MapsActivity : FragmentActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null
    private val baseUrl = "https://libertrash.firebaseio.com/"
    private val auth = "M4hBXIVFYSn6NHeyo8NYniN2oFGOiExK15vpFqDm"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val firebaseService = retrofit.create(FirebaseService::class.java)

        val lista = firebaseService.listaReporte()
        lista.enqueue(object : Callback<List<Reporte>>{

            override fun onFailure(call: Call<List<Reporte>>?, t: Throwable?) {
                Log.i("reportes-> ","malillo")
            }

            override fun onResponse(call: Call<List<Reporte>>, response: Response<List<Reporte>>) {
                if (response.isSuccessful){
                    val listaReporte : List<Reporte>? =response.body()
                    for (reporte:Reporte in listaReporte!!)
                        Log.i("reporte-> ",reporte.idReporte)
                }
            }
        })
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
