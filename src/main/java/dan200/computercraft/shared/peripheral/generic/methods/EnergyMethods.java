/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2020. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */

package dan200.computercraft.shared.peripheral.generic.methods;

import com.google.auto.service.AutoService;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.core.asm.GenericSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.versions.forge.ForgeVersion;

import javax.annotation.Nonnull;

/**
 * Methods for interacting with blocks using Forge's energy storage system.
 *
 * This works with energy storage blocks, as well as generators and machines which consume energy.
 *
 * <blockquote>
 * <strong>Note:</strong> Due to limitations with Forge's energy API, it is not possible to measure throughput (i.e. RF
 * used/generated per tick).
 * </blockquote>
 *
 * @cc.module energy_storage
 */
@AutoService( GenericSource.class )
public class EnergyMethods implements GenericSource
{
    @Nonnull
    @Override
    public ResourceLocation id()
    {
        return new ResourceLocation( ForgeVersion.MOD_ID, "energy" );
    }

    /**
     * Get the energy of this block.
     *
     * @param energy The current energy storage.
     * @return The energy stored in this block, in FE.
     */
    @LuaFunction( mainThread = true )
    public static int getEnergy( IEnergyStorage energy )
    {
        return energy.getEnergyStored();
    }

    /**
     * Get the maximum amount of energy this block can store.
     *
     * @param energy The current energy storage.
     * @return The energy capacity of this block.
     */
    @LuaFunction( mainThread = true )
    public static int getEnergyCapacity( IEnergyStorage energy )
    {
        return energy.getMaxEnergyStored();
    }
}
