package cc.unilock.mahoutetra.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import se.mickelus.tetra.items.modular.impl.ModularBladedItem;
import se.mickelus.tetra.items.modular.impl.ModularDoubleHeadedItem;
import se.mickelus.tetra.items.modular.impl.ModularSingleHeadedItem;
import stepsword.mahoutsukai.item.spells.projection.WeaponProjectile.WeaponProjectileBow;

@Mixin(value = WeaponProjectileBow.class, remap = false)
public class WeaponProjectileBowMixin {
    @Inject(method = "isArrow(Lnet/minecraft/item/ItemStack;)Z", at = @At("RETURN"), cancellable = true)
    private void isArrow(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Item tmpi = stack.getItem();
        if (tmpi instanceof ModularBladedItem || tmpi instanceof ModularSingleHeadedItem || tmpi instanceof ModularDoubleHeadedItem) {
            cir.setReturnValue(true);
        }
    }
}
