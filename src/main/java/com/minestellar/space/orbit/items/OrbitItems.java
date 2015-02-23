/**
 * Copyright (c) 22/Feb/2015 Davide Cossu & Matthew Albrecht.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses>.
 */

package com.minestellar.space.orbit.items;

import net.minecraft.item.Item;

import com.minestellar.space.orbit.MinestellarOrbit;

public class OrbitItems {
	public static void init() {
		initItems();
		registerItems();
		oreDictRegistration();
		registerHarvestLevels();
		registerFluidContainer();
	}

	public static Item orbitBasicItems;
	public static Item orbitPortalTrigger;

	private static void initItems() {
		OrbitItems.orbitBasicItems = new ItemBasicOrbit();
		OrbitItems.orbitPortalTrigger = new ItemPortalTrigger("orbit_trigger");
	}

	private static void registerItems() {
		MinestellarOrbit.registerItem(orbitBasicItems);
		MinestellarOrbit.registerItem(orbitPortalTrigger);
	}

	private static void oreDictRegistration() {
	}

	private static void registerHarvestLevels() {
	}

	private static void registerFluidContainer() {
	}
}
