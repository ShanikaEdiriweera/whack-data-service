package org.whack.service;

/**
 * Created by dimuth on 11/15/16.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jdk.nashorn.api.scripting.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataHandler {

    public static JSONObject readRLFunnel() {

        String csvFile = "Data/RL-funnel.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        JSONObject pageObj= new JSONObject();
        JSONArray page = new JSONArray();


        try {
            int i=1;
            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine();

            String[] headers=line.split(",");



            while (i<149){

                // use comma as separator
                line=br.readLine();
                String[] data = line.split(cvsSplitBy);
                JSONObject lineobj = new JSONObject();
                for(int x=0;x<headers.length;x++){
                    System.out.println(headers[x]);
                    System.out.println(data[x]);

                    lineobj.put(headers[x],data[x]);

                }

                page.put(lineobj);
                i++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        pageObj.put("page",page);
        return pageObj;

    }

}