package edu.neetu.questions;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import sun.misc.BASE64Encoder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/5/13
 * Time: 2:48 PM
 */
public class Question13 {
    private static String CONSUMER_KEY = "v3zlUTGZCobjxvr8sdGJlQ";
    private static String CONSUMER_SECRET = "nCuaDGOFzeAdeaemX97FPq2bOj9QnQYxBjEVJPAZE";
    private static double COLUMN_COUNT = 5d;

    public static void main(String[] args) throws IOException {
        ArrayList<Place> placesFromTwitter = getPlacesFromTwitter();

        while (true) {
            Place chosenPlace = choosePlace(placesFromTwitter);
            ArrayList<Trend> trendsForPlace = getTrendsFor(chosenPlace);
            displayTrends(trendsForPlace);

            System.out.println("Press Enter to continue...");
            System.in.read();
        }
    }

    private static void displayTrends(ArrayList<Trend> trendsForPlace) {
        int i = 1;
        for (Trend trend : trendsForPlace) {
            System.out.println(i + ". " + trend.getTrendName());
            i++;
        }
    }

    private static Place choosePlace(ArrayList<Place> placesFromTwitter) {
        double numPerColumn = Math.ceil(placesFromTwitter.size() / COLUMN_COUNT);
        for (int i = 0; i < numPerColumn; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                int idx = (int)(j * numPerColumn) + i;
                if (idx < placesFromTwitter.size()) {
                    Place place = placesFromTwitter.get(idx);
                    System.out.print(String.format("%03d. %-25s    ", idx + 1, place.getPlaceName()));
                }
                if (j == COLUMN_COUNT - 1) {
                    System.out.println();
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        int locationID;

        while (true) {
            System.out.print("Enter location_id (q to quit): ");
            String token = scanner.next();

            try {
                locationID = new Integer(token);
                if (locationID < 1 || locationID > placesFromTwitter.size()) {
                    System.out.println("Please enter a number from 1 to " + placesFromTwitter.size() + ".");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                if ("q".equalsIgnoreCase(token)) {
                    System.exit(0);
                } else {
                    System.out.println("That is not a valid response.");
                }
            }
        }


        return placesFromTwitter.get(locationID - 1);
    }

    public static ArrayList<Place> getPlacesFromTwitter() throws IOException {

        String urlString = "https://api.twitter.com/1.1/trends/available.json";
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        conn.addRequestProperty("Authorization", getAuthHeaderValue());
        InputStream inputStream = conn.getInputStream();

        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String jsonString = scanner.next();

        JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsonString);

        int length = jsonArray.size(), counter = 0;
        ArrayList<Place> places = new ArrayList<>();
        while (counter < length) {
            JSONObject jsonObject = jsonArray.getJSONObject(counter);
            String placeName = jsonObject.getString("name");
            int placeWoeid = jsonObject.getInt("woeid");
            places.add(new Place(placeName, placeWoeid));
            counter++;
        }

        return places;
    }

    private static String getAuthHeaderValue() throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String keyToEncode = CONSUMER_KEY + ":" + CONSUMER_SECRET;
        String base64EncodedSecret = encoder.encode(keyToEncode.getBytes()).replaceAll("\n", "");

        URL url = new URL("https://api.twitter.com/oauth2/token");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.addRequestProperty("Authorization", "Basic " + base64EncodedSecret);
        urlConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream ());
        wr.writeBytes("grant_type=client_credentials");
        wr.flush();
        wr.close();

        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String jsonString = scanner.next();
        JSONObject json = (JSONObject)JSONSerializer.toJSON(jsonString);

        String accessToken = json.getString("access_token");
        return "Bearer " + accessToken;
    }


    public static ArrayList<Trend> getTrendsFor(Place place) throws IOException {
        String urlString = "https://api.twitter.com/1.1/trends/place.json?id=" + place.getWoeid();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("Authorization", getAuthHeaderValue());
        InputStream inputStream = conn.getInputStream();
        ArrayList<Trend> trendResult = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String jsonString = scanner.next();

        JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(jsonString);

        JSONArray trends = jsonArray.getJSONObject(0).getJSONArray("trends");

        int size = trends.size();
        int start = 0;
        while (start < size){
            String trendName = trends.getJSONObject(start).getString("name");
            Trend trend = new Trend(trendName);
            trendResult.add(trend);
            start++;
        }
        return trendResult;
    }

    private static class Place{

        private String placeName;
        private int woeid;

        public Place(String newPlace, int newWoeid){
            placeName = newPlace;
            woeid = newWoeid;
        }
        public String getPlaceName() {
            return placeName;
        }

        public int getWoeid() {
            return woeid;
        }
    }

    private static class Trend{

        public String getTrendName() {
            return trendName;
        }

        private String trendName;

        public Trend(String newTrend){
            trendName = newTrend;
        }

    }
}
