package me.trent.yaml;

import me.trent.Framework;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomFile {

    private File file;
    private YamlConfiguration fileConfig;

    public CustomFile(File file){
        this.file = file;
        this.fileConfig = YamlConfiguration.loadConfiguration(file);
    }

    public void setup(boolean loadFromProject, String inFolder){
        if (!getFile().exists()){
            if (loadFromProject){
                if (!inFolder.equalsIgnoreCase("")){
                    Framework.getFramework().getPlugin().saveResource(inFolder+"/"+file.getName(), false);
                }else{
                    Framework.getFramework().getPlugin().saveResource(file.getName(), false);
                }
            }else{
                try{
                    getFile().createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        loadFile();
    }

    public void loadFile() {
        this.fileConfig = YamlConfiguration.loadConfiguration(file);
    }

    public void saveFile(){
        try{
            getFileConfig().save(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileConfig(YamlConfiguration fileConfig) {
        this.fileConfig = fileConfig;
    }

    public YamlConfiguration getFileConfig() {
        return fileConfig;
    }
}
