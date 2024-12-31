// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import org.json.JSONArray;
// import org.json.JSONObject;

// public class Main {
//     public static void main(String[] args) {
//         String apiUrl = "https://newsapi.org/v2/everything?q=science&apiKey=YOUR_API_KEY";
//         try {
//             URL url = new URL(apiUrl);
//             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//             conn.setRequestMethod("GET");
//             BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//             String inputLine;
//             StringBuilder content = new StringBuilder();
//             while ((inputLine = in.readLine()) != null) {
//                 content.append(inputLine);
//             }
//             in.close();
//             conn.disconnect();
//             parseAndDisplayNews(content.toString());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private static void parseAndDisplayNews(String jsonResponse) {
//         JSONObject jsonObject = new JSONObject(jsonResponse);
//         JSONArray articles = jsonObject.getJSONArray("articles");
//         for (int i = 0; i < articles.length(); i++) {
//             JSONObject article = articles.getJSONObject(i);
//             String title = article.getString("title");
//             String description = article.getString("description");
//             String url = article.getString("url");
//             System.out.println("Title: " + title);
//             System.out.println("Description: " + description);
//             System.out.println("URL: " + url);
//             System.out.println();
//         }
//     }
// }

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import org.json.JSONArray;
// import org.json.JSONObject;
// import org.apache.jena.rdf.model.Model;
// import org.apache.jena.rdf.model.ModelFactory;
// import org.apache.jena.rdf.model.Resource;
// import org.apache.jena.vocabulary.RDF;
// import org.apache.jena.vocabulary.RDFS;

// public class Main {
//     public static void main(String[] args) {
//         String apiUrl = "https://newsapi.org/v2/everything?q=science&apiKey=YOUR_API_KEY";
//         try {
//             URL url = new URL(apiUrl);
//             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//             conn.setRequestMethod("GET");
//             BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//             String inputLine;
//             StringBuilder content = new StringBuilder();
//             while ((inputLine = in.readLine()) != null) {
//                 content.append(inputLine);
//             }
//             in.close();
//             conn.disconnect();
//             parseAndDisplayNews(content.toString());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     private static void parseAndDisplayNews(String jsonResponse) {
//         JSONObject jsonObject = new JSONObject(jsonResponse);
//         JSONArray articles = jsonObject.getJSONArray("articles");
//         Model model = ModelFactory.createDefaultModel();
//         String ns = "http://example.org/news/";

//         for (int i = 0; i < articles.length(); i++) {
//             JSONObject article = articles.getJSONObject(i);
//             String title = article.getString("title");
//             String description = article.getString("description");
//             String url = article.getString("url");

//             Resource articleResource = model.createResource(ns + "article" + i)
//                     .addProperty(RDF.type, "Article")
//                     .addProperty(RDFS.label, title)
//                     .addProperty(model.createProperty(ns + "description"), description)
//                     .addProperty(model.createProperty(ns + "url"), url);

//             System.out.println("Title: " + title);
//             System.out.println("Description: " + description);
//             System.out.println("URL: " + url);
//             System.out.println();
//         }

//         // Write the RDF model to the console
//         model.write(System.out, "TURTLE");
//     }
// }
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        String apiKey = "YOUR_BING_SEARCH_API_KEY";
        String query = "latest scientific discoveries";
        String apiUrl = "https://api.bing.microsoft.com/v7.0/search?q=" + query + "&count=10&offset=0&mkt=en-US&safesearch=Moderate";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Ocp-Apim-Subscription-Key", apiKey);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            String jsonResponse = content.toString();
            JSONArray results = parseAndProcessData(jsonResponse);
            startWebServer(results);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONArray parseAndProcessData(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray webPages = jsonObject.getJSONObject("webPages").getJSONArray("value");
        JSONArray results = new JSONArray();

        for (int i = 0; i < webPages.length(); i++) {
            JSONObject page = webPages.getJSONObject(i);
            String name = page.getString("name");
            String url = page.getString("url");
            String snippet = page.getString("snippet");

            JSONObject result = new JSONObject();
            result.put("name", name);
            result.put("url", url);
            result.put("snippet", snippet);
            results.put(result);
        }

        return results;
    }

    private static void startWebServer(JSONArray results) {
        Spark.port(4567);
        Spark.get("/", (req, res) -> {
            StringBuilder html = new StringBuilder();
            html.append("<html><body>");
            html.append("<h1>Latest Scientific Discoveries</h1>");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                html.append("<div>");
                html.append("<h2>").append(result.getString("name")).append("</h2>");
                html.append("<p>").append(result.getString("snippet")).append("</p>");
                html.append("<a href='").append(result.getString("url")).append("'>Read more</a>");
                html.append("</div>");
            }
            html.append("</body></html>");
            return html.toString();
        });
    }
}