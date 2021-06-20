package com.logisticscraft.occlusionculling.util;

import java.util.Arrays;

import com.logisticscraft.occlusionculling.cache.OcclusionCache;
import com.logisticscraft.occlusionculling.util.DataAccess.AccessType;

/**
 * Slower 3d array cache that is mostly for testing because it's slower compared
 * to the other cache.
 * 
 * @author tr7zw
 *
 */
public class MultiArrayCache implements OcclusionCache {

    private final int reach;
    private final int reachX2;
    private final byte[][][] cache;
    private int lastX, lastY, lastZ;
    private DummyWorld world;

    public MultiArrayCache(int reach, DummyWorld world) {
        this.reach = reach;
        this.reachX2 = reach * 2;
        this.cache = new byte[reachX2][reachX2][reachX2];
        this.world = world;
    }

    @Override
    public void resetCache() {
        for (int x = 0; x < reachX2; x++) {
            for (int y = 0; y < reachX2; y++) {
                Arrays.fill(cache[x][y], (byte) 0);
            }
        }
    }

    @Override
    public void setVisible(int x, int y, int z) {
        cache[x][y][z] = 1;
        world.blockChecks.add(new DataAccess(AccessType.CACHEWRITE, x-reach, y-reach, z-reach));
    }

    @Override
    public void setHidden(int x, int y, int z) {
        cache[x][y][z] = 2;
        world.blockChecks.add(new DataAccess(AccessType.CACHEWRITE, x-reach, y-reach, z-reach));
    }

    @Override
    public int getState(int x, int y, int z) {
        lastX = x;
        lastY = y;
        lastZ = z;
        world.blockChecks.add(new DataAccess(AccessType.CACHEGET, x-reach, y-reach, z-reach));
        return cache[x][y][z];
    }

    @Override
    public void setLastVisible() {
        cache[lastX][lastY][lastZ] = 1;
        world.blockChecks.add(new DataAccess(AccessType.CACHEWRITE, lastX-reach, lastY-reach, lastZ-reach));
    }

    @Override
    public void setLastHidden() {
        cache[lastX][lastY][lastZ] = 2;
        world.blockChecks.add(new DataAccess(AccessType.CACHEWRITE, lastX-reach, lastY-reach, lastZ-reach));
    }

}
