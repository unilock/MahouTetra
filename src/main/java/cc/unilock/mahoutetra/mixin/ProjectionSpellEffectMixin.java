package cc.unilock.mahoutetra.mixin;

import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import se.mickelus.tetra.items.modular.impl.ModularBladedItem;
import se.mickelus.tetra.items.modular.impl.ModularDoubleHeadedItem;
import se.mickelus.tetra.items.modular.impl.ModularSingleHeadedItem;
import se.mickelus.tetra.items.modular.impl.bow.ModularBowItem;
import se.mickelus.tetra.items.modular.impl.crossbow.ModularCrossbowItem;
import se.mickelus.tetra.items.modular.impl.shield.ModularShieldItem;
import stepsword.mahoutsukai.config.MTConfig;
import stepsword.mahoutsukai.effects.projection.ProjectionSpellEffect;
import stepsword.mahoutsukai.util.EffectUtil;

import static stepsword.mahoutsukai.effects.projection.ProjectionSpellEffect.disallowed;

@Mixin(value = ProjectionSpellEffect.class, remap = false)
public class ProjectionSpellEffectMixin {
    /**
     * @author unilock
     * @reason don't tell stepsword!
     */
    @Overwrite
    public static boolean canProject(ItemStack stack) {
        Item tmpi = stack.getItem();
        boolean ret = tmpi instanceof BowItem
                || tmpi instanceof SwordItem
                || tmpi instanceof AxeItem
                || tmpi instanceof HoeItem
                || tmpi instanceof ShovelItem
                || tmpi instanceof PickaxeItem
                || tmpi instanceof ShieldItem
                || tmpi instanceof ShearsItem
                || tmpi instanceof FishingRodItem
                || tmpi instanceof TridentItem
                || tmpi instanceof CrossbowItem
                || tmpi instanceof ModularBladedItem
                || tmpi instanceof ModularSingleHeadedItem
                || tmpi instanceof ModularDoubleHeadedItem
                || tmpi instanceof ModularBowItem
                || tmpi instanceof ModularCrossbowItem
                || tmpi instanceof ModularShieldItem;
        return ret && !disallowed(tmpi) && stack.isDamageable() || EffectUtil.inItemBlacklist(tmpi, MTConfig.PROJECTION_EXPLICIT_WHITELIST);
    }
}
