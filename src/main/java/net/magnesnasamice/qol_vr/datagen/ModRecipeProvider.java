package net.magnesnasamice.qol_vr.datagen;

import net.magnesnasamice.qol_vr.QOL_VR;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // advanced
        registerBedRecolorRecipes(consumer);
        registerWoolToStringRecipes(consumer);
        registerIceUnpackingRecipes(consumer);
        registerBundleCraftingRecipes(consumer);
        registerDropperToDispenserRecipes(consumer);

        // basic
        registerRottenFleshToLeatherRecipes(consumer);
        registerRabbitFootToRabbitHideRecipes(consumer);
        registerPoisonousPotatoCookingRecipes(consumer);
    }



    private void registerBedRecolorRecipes(Consumer<FinishedRecipe> consumer) {
        final List<Item> BEDS = List.of(
                Items.WHITE_BED,
                Items.LIGHT_GRAY_BED,
                Items.GRAY_BED,
                Items.BLACK_BED,
                Items.BROWN_BED,
                Items.RED_BED,
                Items.ORANGE_BED,
                Items.YELLOW_BED,
                Items.LIME_BED,
                Items.GREEN_BED,
                Items.CYAN_BED,
                Items.LIGHT_BLUE_BED,
                Items.BLUE_BED,
                Items.PURPLE_BED,
                Items.MAGENTA_BED,
                Items.PINK_BED
        );

        final List<Item> DYES = List.of(
                Items.WHITE_DYE,
                Items.LIGHT_GRAY_DYE,
                Items.GRAY_DYE,
                Items.BLACK_DYE,
                Items.BROWN_DYE,
                Items.RED_DYE,
                Items.ORANGE_DYE,
                Items.YELLOW_DYE,
                Items.LIME_DYE,
                Items.GREEN_DYE,
                Items.CYAN_DYE,
                Items.LIGHT_BLUE_DYE,
                Items.BLUE_DYE,
                Items.PURPLE_DYE,
                Items.MAGENTA_DYE,
                Items.PINK_DYE
        );

        for (Item bed : BEDS) {
            Item dye = DYES.get(BEDS.indexOf(bed));


            List<Item> correct_beds = new ArrayList<>(List.copyOf(BEDS));
            correct_beds.remove(Items.WHITE_BED);
            correct_beds.remove(bed);
            /*
                remove bed that we're trying to get recipe for
                (we don't want brown_bed + brown_dye = brown_bed)
                and white_bed (to not override vanilla recipes)
            */

            for (Item correctBed : correct_beds) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, bed)
                        .requires(correctBed)
                        .requires(dye)
                        .unlockedBy(getHasName(bed), has(ItemTags.BEDS))
                        .save(consumer, QOL_VR.MODID + ":" + getItemName(bed) + "_from_" + getItemName(correctBed));
            }
        }
    }
    private void registerWoolToStringRecipes(Consumer<FinishedRecipe> consumer) {
        final List<Item> WOOLS = List.of(
                Items.WHITE_WOOL,
                Items.LIGHT_GRAY_WOOL,
                Items.GRAY_WOOL,
                Items.BLACK_WOOL,
                Items.BROWN_WOOL,
                Items.RED_WOOL,
                Items.ORANGE_WOOL,
                Items.YELLOW_WOOL,
                Items.LIME_WOOL,
                Items.GREEN_WOOL,
                Items.CYAN_WOOL,
                Items.LIGHT_BLUE_WOOL,
                Items.BLUE_WOOL,
                Items.PURPLE_WOOL,
                Items.MAGENTA_WOOL,
                Items.PINK_WOOL
        );

        for (Item wool : WOOLS) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING, 4)
                    .requires(wool)
                    .unlockedBy(getHasName(wool), has(ItemTags.WOOL))
                    .save(consumer, QOL_VR.MODID + ":string_from_" + getItemName(wool));
        }
    }
    private void registerIceUnpackingRecipes(Consumer<FinishedRecipe> consumer) {
        // blue ice -> packed ice x9
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.PACKED_ICE, 9)
                .requires(Items.BLUE_ICE)
                .unlockedBy(getHasName(Items.ICE), has(Items.ICE))
                .unlockedBy(getHasName(Items.PACKED_ICE), has(Items.PACKED_ICE))
                .unlockedBy(getHasName(Items.BLUE_ICE), has(Items.BLUE_ICE))
                .save(consumer, QOL_VR.MODID + ":blue_ice_unpacking");
        // packed ice -> ice x9
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.ICE, 9)
                .requires(Items.PACKED_ICE)
                .unlockedBy(getHasName(Items.ICE), has(Items.ICE))
                .unlockedBy(getHasName(Items.PACKED_ICE), has(Items.PACKED_ICE))
                .unlockedBy(getHasName(Items.BLUE_ICE), has(Items.BLUE_ICE))
                .save(consumer, QOL_VR.MODID + ":packed_ice_unpacking");
    }
    private void registerBundleCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        // crafting bundle with rabbit hide
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUNDLE)
                .pattern("SHS")
                .pattern("H H")
                .pattern("HHH")
                .define('S', Items.STRING)
                .define('H', Items.RABBIT_HIDE)
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                .save(consumer,  QOL_VR.MODID+":"+"bundle_from_rabbit_hide");
        // crafting bundle with leather
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BUNDLE)
                .pattern("SLS")
                .pattern("L L")
                .pattern("LLL")
                .define('S', Items.STRING)
                .define('L', Items.LEATHER)
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .unlockedBy(getHasName(Items.RABBIT_HIDE), has(Items.RABBIT_HIDE))
                .save(consumer, QOL_VR.MODID+":"+"bundle_from_leather");
    }
    private void registerDropperToDispenserRecipes(Consumer<FinishedRecipe> consumer) {
        // dropper + bow -> dispenser
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, Items.DISPENSER)
                .requires(Items.DROPPER)
                .requires(Items.BOW)
                .unlockedBy(getHasName(Items.DISPENSER), has(Items.DISPENSER))
                .unlockedBy(getHasName(Items.DROPPER), has(Items.DROPPER))
                .save(consumer, QOL_VR.MODID+":"+"dispenser_from_dropper");
        // dispenser -> dropper
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, Items.DROPPER)
                .requires(Items.DISPENSER)
                .unlockedBy(getHasName(Items.DISPENSER), has(Items.DISPENSER))
                .unlockedBy(getHasName(Items.DROPPER), has(Items.DROPPER))
                .save(consumer, QOL_VR.MODID+":"+"dropper_from_dispenser");
    }



    // BASIC
    private void registerRottenFleshToLeatherRecipes(Consumer<FinishedRecipe> consumer) {
        final List<ItemLike> INGREDIENTS = List.of(Items.ROTTEN_FLESH);
        customRecipe(consumer, RecipeSerializer.SMOKING_RECIPE, INGREDIENTS, RecipeCategory.MISC, Items.LEATHER, .25F, 100, "rftl", QOL_VR.MODID + ":leather_from_smoking_rotten_flesh");
        customRecipe(consumer, RecipeSerializer.SMELTING_RECIPE, INGREDIENTS, RecipeCategory.MISC, Items.LEATHER, .25F, 200, "rftl", QOL_VR.MODID + ":leather_from_smelting_rotten_flesh");
    }
    private void registerPoisonousPotatoCookingRecipes(Consumer<FinishedRecipe> consumer) {
        final List<ItemLike> INGREDIENTS = List.of(Items.POISONOUS_POTATO);
        customRecipe(consumer, RecipeSerializer.SMOKING_RECIPE, INGREDIENTS, RecipeCategory.MISC, Items.BAKED_POTATO, .25F, 100, "potato_new", QOL_VR.MODID + ":baked_potato_from_smoking_poisonous_potato");
        customRecipe(consumer, RecipeSerializer.SMELTING_RECIPE, INGREDIENTS, RecipeCategory.MISC, Items.BAKED_POTATO, .25F, 200, "potato_new", QOL_VR.MODID + ":baked_potato_from_smelting_poisonous_potato");
    }
    private void registerRabbitFootToRabbitHideRecipes(Consumer<FinishedRecipe> consumer) {
        final List<ItemLike> INGREDIENTS = List.of(Items.RABBIT_FOOT);
        customRecipe(consumer, RecipeSerializer.SMOKING_RECIPE, INGREDIENTS, RecipeCategory.MISC, Items.RABBIT_HIDE, .25F, 100, "rabbit_new", QOL_VR.MODID + ":rabbit_hide_from_smoking_rabbit_foot");
        customRecipe(consumer, RecipeSerializer.SMELTING_RECIPE, INGREDIENTS, RecipeCategory.MISC, Items.RABBIT_HIDE, .25F, 200, "rabbit_new", QOL_VR.MODID + ":rabbit_hide_from_smelting_rabbit_foot");
    }



    //////////
    // util //
    //////////
    protected static void customRecipe(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> cookingSerializer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float exp, int smokingTime, String group, String recipeName) {
        for(ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(itemlike), category, result, exp, smokingTime, cookingSerializer)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(consumer, recipeName);
        }
    }
}
