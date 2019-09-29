package me.trent.command.commands.subCommands;

import me.trent.Framework;
import me.trent.command.CommandBase;
import me.trent.command.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class testSub extends SubCommand {

    public testSub(CommandBase commandBase, String name, String description, String permission, String usageMessage, String... aliases){
        this.setup(commandBase, name, description, permission, usageMessage, aliases);
    }

    @Override
    public boolean execute(CommandSender sender, List<String> args) {

        if (!super.execute(sender, args)) return false; // no permission for this command...


        if (args.size() == 0) {
            //send the default ping info...
            if (sender instanceof Player) {
                Player p = (Player)sender;
                sender.sendMessage(Framework.getFramework().color("&aMy Ping: &b" + Framework.getFramework().getPing(p)));
            }else{
                sender.sendMessage(Framework.getFramework().color("&cThis command is only for Console..."));
            }
        }else if (args.size() == 1){
            //look for player from first arg
            Player target = Bukkit.getPlayerExact(args.get(0));
            if (target != null && target.isOnline()){
                sender.sendMessage(Framework.getFramework().color("&a"+target.getName()+"'s Ping: &b"+Framework.getFramework().getPing(target)));
            }else{
                //no player
                sender.sendMessage(Framework.getFramework().color("&cCould not find player...")); }
        }else{
            //send usage
            sender.sendMessage(Framework.getFramework().color(getUsageMessage()));
        }

        return false;
    }
}
