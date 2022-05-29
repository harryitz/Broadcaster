package me.blockmagicdev.broadcaster;

import cn.nukkit.plugin.PluginBase;
import me.blockmagicdev.broadcaster.provider.Provider;
import me.blockmagicdev.broadcaster.task.BroadcastScheduler;

public class MainClass extends PluginBase {

    protected Provider provider;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.provider = new Provider(this);
        this.provider.initConfig();
        this.getServer().getInstance().getScheduler().scheduleRepeatingTask(this, new BroadcastScheduler(this), 20 * this.getProvider().getMessageInterval());
    }

    public Provider getProvider(){
        return this.provider;
    }
}
