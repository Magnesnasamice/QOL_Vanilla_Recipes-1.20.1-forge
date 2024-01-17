package net.magnesnasamice.qol_vr.datagen;

import net.magnesnasamice.qol_vr.QOL_VR;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, QOL_VR.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        simpleItem(ModItems.PAPYRUS);
//        simpleItem(ModItems.PAPYRUS_SEEDS);
//        simpleItem(ModItems.PAPYRUS_STEM);
//        simpleItem(ModItems.SOAKED_PAPYRUS_STEM);
//        simpleItem(ModItems.INCOMPLETE_SOAKED_PAPYRUS_STEM);
//        simpleItem(ModItems.SQUEEZED_PAPYRUS_STEM);
//        simpleItem(ModItems.PAPYRUS_SCROLL);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(QOL_VR.MODID, "item/"+item.getId().getPath()));
    }
}
