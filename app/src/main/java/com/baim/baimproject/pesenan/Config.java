package com.baim.baimproject.pesenan;

/**
 * Created by baim on 02/12/2016.
 */public class Config {

    //Alamat URL tempat kita meletakkan script PHP di PC Server
    // Link untuk INSERT Data
    public static final String URL_ADD="http://kitabaimloh.esy.es/pesenan/create.php";
    public static final String URL_GET_ALL = "http://kitabaimloh.esy.es/pesenan/read.php";
    // Filed yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel Mahasiswa
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_PORSI = "porsi";
    public static final String KEY_EMP_HARGA = "harga";

    // Tags Format JSON
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_PORSI = "porsi";
    public static final String TAG_HARGA= "harga";
    public static final String EMP_ID = "emp_id";
}