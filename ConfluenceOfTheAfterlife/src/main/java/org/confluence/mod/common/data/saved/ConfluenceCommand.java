package org.confluence.mod.common.data.saved;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Tuple;

import static org.confluence.mod.common.data.saved.ConfluenceData.STAR_PHASES_SIZE;

public class ConfluenceCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("confluence").requires(sourceStack -> sourceStack.hasPermission(2))
                .then(Commands.literal("starPhases")
                        .then(Commands.literal("get").then(Commands.argument("index", IntegerArgumentType.integer(0, STAR_PHASES_SIZE - 1)).executes(context -> {
                            int index = IntegerArgumentType.getInteger(context, "index");
                            Tuple<Float, Float> starPhase = ConfluenceData.get(context.getSource().getLevel()).getStarPhase(index);
                            if (starPhase == null) {
                                context.getSource().sendFailure(Component.literal("No such StarPhase!"));
                                return 0;
                            }
                            context.getSource().sendSystemMessage(Component.literal("StarPhase{index=" + index + ",radius=" + starPhase.getA() + ",angle=" + starPhase.getB() + "}"));
                            return 1;
                        })))
                        .then(Commands.literal("set").then(Commands.argument("index", IntegerArgumentType.integer(0, STAR_PHASES_SIZE - 1)).then(Commands.argument("radius", FloatArgumentType.floatArg()).then(Commands.argument("angle", FloatArgumentType.floatArg()).executes(context -> {
                            int index = IntegerArgumentType.getInteger(context, "index");
                            float radius = FloatArgumentType.getFloat(context, "radius");
                            float angle = FloatArgumentType.getFloat(context, "angle");
                            if (!ConfluenceData.get(context.getSource().getLevel()).setStarPhase(index, radius, angle)) {
                                context.getSource().sendFailure(Component.literal("Can not set StarPhase!"));
                                return 0;
                            }
                            return 1;
                        })))))
                )
//                .then(Commands.literal("gamePhase")
//                        .then(Commands.literal("get").executes(context -> {
//
//                        }))
//                        .then(Commands.literal("set").executes(context -> {
//
//                        }))
//                )
//                .then(Commands.literal("wind")
//                        .then(Commands.literal("get").executes(context -> {
//
//                        }))
//                        .then(Commands.literal("set").executes(context -> {
//
//                        }))
//                )
        );
    }
}
