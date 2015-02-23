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

package com.minestellar.api.core;

import net.minecraft.block.Block;

public class BlockMetaPair {
	private final Block block;
	private final byte metadata;

	public BlockMetaPair(Block block, byte metadata) {
		this.block = block;
		this.metadata = metadata;
	}

	public Block getBlock() {
		return this.block;
	}

	public byte getMetadata() {
		return this.metadata;
	}
}
