package com.tacz.guns.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.tacz.guns.command.sub.DebugCommand;
import com.tacz.guns.command.sub.DummyAmmoCommand;
import com.tacz.guns.command.sub.OverwriteCommand;
import com.tacz.guns.command.sub.ReloadCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class RootCommand {
    private static final String ROOT_NAME = "tacz";

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal(ROOT_NAME)
                .requires((source -> source.hasPermission(2)));
        root.then(ReloadCommand.get());
        root.then(OverwriteCommand.get());
        root.then(DummyAmmoCommand.get());
        root.then(DebugCommand.get());
        dispatcher.register(root);
    }
}
