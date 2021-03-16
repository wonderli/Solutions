import java.util.*;
class Codec {
    
    Map<String, String> shortToLongMap = new HashMap<>();
    String HOST = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = HOST + longUrl.hashCode();
        shortToLongMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
