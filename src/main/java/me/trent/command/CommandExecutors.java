package me.trent.command;


import me.trent.command.commands.subCommands.testSub;
import me.trent.command.commands.testBase;

public class CommandExecutors {


    public void registerDefaultCommands() {
        CommandBase testBase = new testBase("test", "test command", "", "Do /test ping <player>", "t", "tt");

        SubCommand pingSUB = new testSub(testBase, "ping", "test command, sub command is 'ping'", "", "&cTry /ping <player>", "p");
    }

}