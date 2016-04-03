package appewtc.masterung.lenarnasyncetaskokclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    private String strUrlJSON = "http://tr.ddnsthailand.com/motion.php";
    private String tag = "2April";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connected();


    }   // Main Method

    private void connected() {


            new AsyncTask<Void, Void, String>() {

                @Override
                protected String doInBackground(Void... voids) {

                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request.Builder builder = new Request.Builder();
                    Request request = builder.url("http://swiftcodingthai.com/19Mar/php_get_food_master.php").build();

                    try {

                        Response response = okHttpClient.newCall(request).execute();

                        if (response.isSuccessful()) {
                            return response.body().string();
                        } else {
                            return "Not Success";
                        }


                    } catch (Exception e) {
                        return "error ==> " + e.toString();
                    }


                }   // doInBack

                @Override
                protected void onPostExecute(String string) {
                    super.onPostExecute(string);
                    Log.d("test", "string ==> " + string);
                }   // onPost
            }.execute();



    }   // connected


}   // Main Class
