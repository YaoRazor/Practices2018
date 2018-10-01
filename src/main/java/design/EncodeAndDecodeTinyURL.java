package design;

import java.util.HashMap;
import java.util.Random;

public class EncodeAndDecodeTinyURL {

    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String key;
        do{
          key = getKey();
        } while (map.containsKey(key));

        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;

    }


    private String getKey() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }

        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
