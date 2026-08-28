package com.vanillahack.client.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RenderService {
    @Getter
    private static final RenderService instance = new RenderService();

    private float scale = 1.0f;
}
