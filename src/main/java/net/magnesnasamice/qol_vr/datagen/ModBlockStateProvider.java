package net.magnesnasamice.qol_vr.datagen;

import net.magnesnasamice.qol_vr.QOL_VR;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, QOL_VR.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
