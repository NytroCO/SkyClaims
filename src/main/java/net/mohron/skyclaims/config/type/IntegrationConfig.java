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

import net.mohron.skyclaims.config.type.integration.GriefDefenderConfig;
import net.mohron.skyclaims.config.type.integration.NucleusConfig;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class IntegrationConfig {

  @Setting(value = "Grief-Prevention")
  private GriefDefenderConfig griefDefenderConfig = new GriefDefenderConfig();

  @Setting(value = "Nucleus")
  private NucleusConfig nucleus = new NucleusConfig();

  public GriefDefenderConfig getGriefDefender() {
    return griefDefenderConfig;
  }

  public NucleusConfig getNucleus() {
    return nucleus;
  }
}
