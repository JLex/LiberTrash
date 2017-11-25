package hackspace.com.libertrash

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by JLex on 25/11/17.
 */
class Reporte(
        @SerializedName("idReporte")
        @Expose
        var idReporte:String,
        @SerializedName("calificacion")
        @Expose
        var calificacion:String,
        @SerializedName("descripcion")
        @Expose
              var descripcion:String,
        @SerializedName("direccion")
        @Expose
              var direccion:String,
        @SerializedName("estado")
        @Expose
              var estado:Boolean,
        @SerializedName("fecha")
        @Expose
              var fecha:String,
        @SerializedName("imagen")
        @Expose
              var imagen:String,
        @SerializedName("latitud")
        @Expose
        var latitud:Double,
        @SerializedName("logitud")
        @Expose
        var logitud:Double,
        @SerializedName("referencia")
        @Expose
        var referencia:String,
        @SerializedName("usuario")
        @Expose
        var usuario:String)