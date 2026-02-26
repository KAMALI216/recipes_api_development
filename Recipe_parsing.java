import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Recipe_Parsing {

    public static void main(String[] args) {

        String jsonFile = "C:\\Users\\kamali\\Downloads\\US_recipes_null.json";

        String dbUrl = "jdbc:mysql://localhost:3306/recipes_db";
        String user = "root";
        String password = "Kamali@216";

        try {

            
            Connection conn = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("Database connected successfully!");

            
            FileReader reader = new FileReader(jsonFile);
            JSONTokener tokener = new JSONTokener(reader);

            
            JSONObject root = new JSONObject(tokener);

            
            String sql = "INSERT INTO recipes " +
                    "(title, cuisine, rating, prep_time, cook_time, total_time, description, nutrients, serves) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            
            for (String key : root.keySet()) {

                JSONObject recipe = root.getJSONObject(key);

                String title = recipe.optString("title");
                String cuisine = recipe.optString("cuisine");
                float rating = (float) recipe.optDouble("rating", 0.0);
                int prep_time = recipe.optInt("prep_time", 0);
                int cook_time = recipe.optInt("cook_time", 0);
                int total_time = recipe.optInt("total_time", prep_time + cook_time);
                String description = recipe.optString("description");
                String serves = recipe.optString("serves");

                JSONObject nutrientsObj = recipe.optJSONObject("nutrients");
                String nutrients = nutrientsObj != null ? nutrientsObj.toString() : "{}";

                ps.setString(1, title);
                ps.setString(2, cuisine);
                ps.setFloat(3, rating);
                ps.setInt(4, prep_time);
                ps.setInt(5, cook_time);
                ps.setInt(6, total_time);
                ps.setString(7, description);
                ps.setString(8, nutrients);
                ps.setString(9, serves);

                ps.executeUpdate();
            }

            System.out.println("Recipe data inserted successfully!");

            conn.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}