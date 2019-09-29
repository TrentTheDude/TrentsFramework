package me.trent.command.commands;

import me.trent.command.CommandBase;
import org.bukkit.command.CommandSender;

public class testBase extends CommandBase {

    public testBase(String name, String description, String permissionRole, String usageMessage, String... aliases){
        super(name, description, permissionRole, usageMessage, aliases);
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String... args) {

        if (!super.execute(sender, alias, args)) return false; // no permission for this command...

        //todo; add some default 0 argument code ...

        sender.sendMessage("BASE: testBase.java, running the base command's code... must not have found subCommand");



        return true;
    }
}