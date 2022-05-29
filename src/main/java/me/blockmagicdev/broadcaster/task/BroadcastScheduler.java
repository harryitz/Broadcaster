package me.blockmagicdev.broadcaster.task;

import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.scheduler.Task;
import me.blockmagicdev.broadcaster.MainClass;
import java.util.HashSet;
import java.util.Set;

public class BroadcastScheduler extends Task{

    protected MainClass plugin;

    private final Set<CommandSender> recipients = new HashSet<>();

    private int messagesSize = -1;

    public BroadcastScheduler(MainClass plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public void onRun(int i) {
        messagesSize += 1;
        String prefix = this.plugin.getProvider().getPrefix();
        String message = prefix + this.plugin.getProvider().MESSAGE_LIST.get(messagesSize);
        if (messagesSize == this.plugin.getProvider().MESSAGE_LIST.size() - 1) {
            messagesSize = -1;
        }
        Server.getInstance().broadcastMessage(message);
    }
}
