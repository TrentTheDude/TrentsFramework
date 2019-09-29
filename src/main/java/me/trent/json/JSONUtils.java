package me.trent.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONUtils {

    public Map<String, String> getMapCompoundValue(File jsonFile, String[] parents, String key){
        JSONParser parser = new JSONParser();
        JSONObject nextObject = null;
        try{
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject firstObject = (JSONObject) obj;

            for (String parent : parents){
                nextObject = (JSONObject)firstObject.get(parent);
            }
            if (nextObject != null){
                return (Map<String, String>) nextObject.get(key);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getStringCompoundValue(File jsonFile, String[] parents, String key){
        JSONParser parser = new JSONParser();
        JSONObject nextObject = null;
        try{
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject firstObject = (JSONObject) obj;

            for (String parent : parents){
                nextObject = (JSONObject)firstObject.get(parent);
            }
            if (nextObject != null){
                return (String)nextObject.get(key);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public double getDoubleCompoundValue(File jsonFile, String[] parents, String key){
        JSONParser parser = new JSONParser();
        JSONObject nextObject = null;
        try{
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject firstObject = (JSONObject) obj;

            for (String parent : parents){
                nextObject = (JSONObject)firstObject.get(parent);
            }
            if (nextObject != null){
                return (Double) nextObject.get(key);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public long getLongCompoundValue(File jsonFile, String[] parents, String key){
        JSONParser parser = new JSONParser();
        JSONObject nextObject = null;
        try{
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject firstObject = (JSONObject) obj;

            for (String parent : parents){
                nextObject = (JSONObject)firstObject.get(parent);
            }
            if (nextObject != null){
                return (Long) nextObject.get(key);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public String getStringValue(File jsonFile, String key){
        String val = null;
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
            val = (String) jsonObject.get(key);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return val;
    }

    public double getDoubleValue(File jsonFile, String key){
        double val = 0;
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
            val = (Double) jsonObject.get(key);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return val;
    }
}
