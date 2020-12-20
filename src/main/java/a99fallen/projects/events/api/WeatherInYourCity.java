package a99fallen.projects.events.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherInYourCity {
    public int getTemperature(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://community-open-weather-map.p.rapidapi.com/weather?q=" + city + "%2Cpl&lat=0&lon=0&callback=test&id=2172797&lang=null&units=%22metric%22%20or%20%22imperial%22&mode=xml%2C%20html")
                .get()
                .addHeader("x-rapidapi-key", "3e0feb1594msh49fd558a8c1b3e1p1b4746jsn4dc710587d4d")
                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .build();


        Response response = client.newCall(request).execute();
        String bodyString = response.body().string();
        double temp = getTemp(bodyString);
        double celsius = temp - 273.15;
        return (int) Math.round(celsius);
    }

    private double getTemp(String bodyString) {
        int start = bodyString.indexOf("temp\":");
        int end = bodyString.indexOf(",\"feels_like\"");
        String temp = bodyString.substring(start + 6, end);
        return Double.parseDouble(temp);
    }
}
