package net.mohron.skyclaims.util;

import me.ryanhamshire.griefprevention.DataStore;
import me.ryanhamshire.griefprevention.claim.Claim;
import me.ryanhamshire.griefprevention.claim.CreateClaimResult;
import net.mohron.skyclaims.SkyClaims;
import net.mohron.skyclaims.config.GlobalConfig;
import net.mohron.skyclaims.island.Island;

import java.util.UUID;

public class IslandUtil {
	private static final SkyClaims PLUGIN = SkyClaims.getInstance();
	private static final DataStore GRIEF_PREVENTION_DATA = PLUGIN.getGriefPrevention().dataStore;
	private static final int MAX_ISLAND_SIZE = 512; // 32 x 32 chunks
	private static GlobalConfig config = PLUGIN.getConfig();
	private static final int MAX_REGIONS = ConfigUtil.get(config.maxRegions, 256);
	private static int x; // x value of the current region
	private static int z; // y value of the current region

	static {
		// Initialize with stored values before using defaults
		x = 1;
		z = 1;
	}

	public static Island createIsland(UUID owner) {
		Claim claim = createIslandClaim().claim;
		return new Island(owner, claim);
	}

	public static boolean hasIsland(UUID owner) {
		return SkyClaims.islands.containsKey(owner);
	}

	public static void saveIsland(Island island) {
		SkyClaims.islands.put(island.getOwner(), island);
	}

	public static Island getIsland(UUID owner) {
		if (!hasIsland(owner)) saveIsland(IslandUtil.createIsland(owner));
		return SkyClaims.islands.get(owner);
	}

	public static void resetIsland(UUID owner) {
		clearIsland(owner);
		buildIsland(getIsland(owner));
	}

	private static CreateClaimResult createIslandClaim() {
		CreateClaimResult createClaimResult;
		createClaimResult = GRIEF_PREVENTION_DATA.createClaim(
				ConfigUtil.getWorld(),
				x * 512,
				x * 512 + MAX_ISLAND_SIZE,
				1,
				255,
				z * 512,
				z * 512  + MAX_ISLAND_SIZE,
				UUID.randomUUID(),
				null,
				Claim.Type.ADMIN,
				false,
				null
		);

		if (z > MAX_REGIONS) {
			z = 0;
			x++;
		}

		return createClaimResult;
	}

	public static void buildIsland(Island island) {
		//TODO Build an "island" in the center of the owners island using a schematic
		int x = island.getCenter().getBlockX();
		int y = ConfigUtil.get(PLUGIN.getConfig().defaultHeight, 64);
		int z = island.getCenter().getBlockZ();


		for (int i = -1; i < 1; i++) {
			for (int j = -1; j < 1; j++) {
				//place some dirt
			}
		}


		island.toggleIsReady();
	}

	private static void clearIsland(UUID owner) {
		//TODO Clear island, inventory, enderchest, and supported private mod inventories ie. mod ender chests
	}

	private static int getXOffset(int i) {
		return (i == 1 || i == 3) ? 0 : MAX_ISLAND_SIZE;
	}

	private static int getYOffset(int i) {
		return (i == 0 || i == 1) ? 0 : MAX_ISLAND_SIZE;
	}
}