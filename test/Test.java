
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 98530
 */
public class Test {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray json = new JsonArray();
        json.add("1");
        json.add("2");
        System.out.println(gson.toJson(json));
    }
}
