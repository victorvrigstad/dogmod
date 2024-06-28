package net.victor.dogmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent GRAPE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100), 1.0f).build();
    public static final FoodComponent GREEN_BELL_PEPPER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodComponent RED_BELL_PEPPER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodComponent YELLOW_BELL_PEPPER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodComponent CORN = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
}
