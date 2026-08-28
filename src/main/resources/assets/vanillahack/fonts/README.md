This directory stores slaughterware font atlases.

Current assets are MSDF/MTSDF atlas pairs:

- `sf_pro/*.json` + `*.png`
- `product_sans/*.json` + `*.png`
- `other/icons*.json` + `*.png`

The Java registry for these assets is `slaughterware.recode.hack.api.render.font.FontManager`.
Rendering currently falls back to Minecraft's `Font`; the atlas metadata is registered so the next renderer step can implement a real MSDF text pass without changing UI code.
