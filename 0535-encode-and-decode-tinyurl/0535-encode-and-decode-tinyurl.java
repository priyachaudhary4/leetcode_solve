import java.util.HashMap;

public class Codec {

    HashMap<Integer, String> map = new HashMap<>();
    int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        map.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.lastIndexOf("/");
        int key = Integer.parseInt(shortUrl.substring(index + 1));
        return map.get(key);
    }
}