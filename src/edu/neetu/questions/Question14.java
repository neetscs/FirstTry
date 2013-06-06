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
 * Date: 6/6/13
 * Time: 11:02 AM
 */
public class Question14 {
    private static String CONSUMER_KEY = "v3zlUTGZCobjxvr8sdGJlQ";
    private static String CONSUMER_SECRET = "nCuaDGOFzeAdeaemX97FPq2bOj9QnQYxBjEVJPAZE";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter search keywords: ");

        String searchKeyWord = scanner.nextLine();
        Query newQuery = constructQueryFor(searchKeyWord);
        ArrayList<Tweets> tweetsForQuery = getTweetsFor(newQuery);
        displayTweets(tweetsForQuery);
    }

    private static void displayTweets(ArrayList<Tweets> tweetsForQuery) {
        int i = 1;
        System.out.println("Here are your results: ");
        for (Tweets tweets : tweetsForQuery) {
            System.out.println(i + ". " + "#"  + tweets.getUserName() + " " + tweets.getTweet());
            i++;
        }
    }

    public static Query constructQueryFor(String searchTerm){
        Query newQuery = null;
        if (searchTerm.contains(" ")){
           newQuery = new Query(searchTerm.replaceAll(" ", "%20"));
        }
        if(searchTerm.contains("#")){
            newQuery = new Query(searchTerm.replace("#","%23"));
        }
        if (searchTerm.contains("\"")){
            newQuery = new Query(searchTerm.replaceAll(" ", "%22"));
        }
        return newQuery;
    }

    public static ArrayList<Tweets> getTweetsFor(Query query) throws IOException {
        String urlString = "https://api.twitter.com/1.1/search/tweets.json?q=".concat(query.getQueryString());
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        conn.addRequestProperty("Authorization", getAuthHeaderValue());
        InputStream inputStream = conn.getInputStream();

        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String jsonString = scanner.next();
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsonString);

        int length = jsonObject.getJSONArray("statuses").size();
        int counter = 0;
        ArrayList<Tweets> tweets = new ArrayList<>();
        while (counter < length) {
            String userName = jsonObject.getJSONArray("statuses").getJSONObject(counter).getJSONObject("user").getString("screen_name");
            String tweet = jsonObject.getJSONArray("statuses").getJSONObject(counter).getString("text");
            tweets.add(new Tweets(userName, tweet));
            counter++;
        }
        return tweets;
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


    private static class Query{
        private String queryString;

        public Query(String newQuery){
            queryString = newQuery;
        }
        public String getQueryString() {
            return queryString;
        }
    }

    private static class Tweets {
        private String userName;
        private String tweet;

        public Tweets(String newUserName, String newTweet){
            userName = newUserName;
            tweet = newTweet;
        }
        public String getTweet() {
            return tweet;
        }
        public String getUserName() {
            return userName;
        }
    }
}

