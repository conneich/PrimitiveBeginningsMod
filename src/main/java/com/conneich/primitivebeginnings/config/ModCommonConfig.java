package com.conneich.primitivebeginnings.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public final class ModCommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.BooleanValue REMOVE_WOOD_TOOLS;
    public static ForgeConfigSpec.BooleanValue REMOVE_STONE_TOOLS;

    public static void loadConfig(ForgeConfigSpec spec, Path path)
    {
        final CommentedFileConfig config = CommentedFileConfig.builder(path).sync().autosave()
                .writingMode(WritingMode.REPLACE).build();
        config.load();
        spec.setConfig(config);
    }

    static {
        BUILDER.push("Tool Functionality Flags");

        REMOVE_WOOD_TOOLS = BUILDER.comment("Remove the wood tool functionality?").define("Remove Wooden Tool Functionality", true);
        REMOVE_STONE_TOOLS = BUILDER.comment("Remove the stone tool functionality?").define("Remove Stone Tool Functionality", true);

        SPEC = BUILDER.build();
    }
}
