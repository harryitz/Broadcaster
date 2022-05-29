package me.blockmagicdev.broadcaster.provider;

import cn.nukkit.utils.Config;
import me.blockmagicdev.broadcaster.MainClass;
import java.util.ArrayList;
import java.util.List;

public class Provider {

    protected Config config;

    public static List<String> MESSAGE_LIST;

    protected MainClass plugin;

    public Provider(MainClass plugin){
        this.plugin = plugin;
    }

    public void initConfig(){
        config = this.plugin.getConfig();
        try {
            Provider.MESSAGE_LIST = config.getStringList("messages");
        } catch (Exception exception) {
            Provider.MESSAGE_LIST = new ArrayList<>();
        }
    }

    public Integer getMessageInterval(){
        return (Integer) config.get("broadcaster-interval");
    }

    public String getPrefix(){
        return (String) config.get("prefix");
    }
}
