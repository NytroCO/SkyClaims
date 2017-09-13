/*
 * SkyClaims - A Skyblock plugin made for Sponge
 * Copyright (C) 2017 Mohron
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SkyClaims is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SkyClaims.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.mohron.skyclaims.config.type;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.ArrayList;
import java.util.List;

@ConfigSerializable
public class MiscConfig {

    @Setting(value = "Island-on-Join", comment = "Automatically create an island for a player on join.")
    private boolean islandOnJoin = false;
    @Setting(value = "Teleport-on-Creation", comment = "Automatically teleport the owner to their island on creation.")
    private boolean teleportOnCreate = true;
    @Setting(value = "Create-Commands", comment = "Commands to run on island creation and reset. Use @p in place of the player's name.")
    private List<String> createCommands = new ArrayList<>();
    @Setting(value = "Reset-Commands", comment = "Commands to run on island resets only. Use @p in place of the player's name.")
    private List<String> resetCommands = new ArrayList<>();

    public boolean createIslandOnJoin() {
        return islandOnJoin;
    }

    public boolean isTeleportOnCreate() {
        return teleportOnCreate;
    }

    public List<String> getCreateCommands() {
        return createCommands;
    }

    public List<String> getResetCommands() {
        return resetCommands;
    }
}