package net.magnesnasamice.qol_vr.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
//        // papyrus crop
//        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
//                .hasBlockStateProperties(ModBlocks.PAPYRUS_CROP.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PapyrusCropBlock.AGE, 7));
//        // if i want to also drop loot on other age
////                .or(LootItemBlockStatePropertyCondition
////                        .hasBlockStateProperties(ModBlocks.PAPYRUS_CROP.get())
////                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PapyrusCropBlock.AGE, 6)));
//        this.add(ModBlocks.PAPYRUS_CROP.get(), createCropDrops(ModBlocks.PAPYRUS_CROP.get(), ModItems.PAPYRUS.get(),
//                ModItems.PAPYRUS_SEEDS.get(), lootitemcondition$builder));
    }

//    @Override
//    protected Iterable<Block> getKnownBlocks() {
//        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
//    }
}
