package com.vanillahack;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaHackClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("vanillahack-client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("VanillaHack client initialized!");
    }
}
