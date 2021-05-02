package com.logisticscraft.occlusionculling.cache;

import java.util.Arrays;

/**
 * Slower 3d array cache that is mostly for testing because it's slower compared
 * to the other cache.
 * 
 * @author tr7zw
 *
 */
public class MultiArrayCache implements OcclusionCache {

    private final int reachX2;
    private final byte[][][] cache;
    private int lastX, lastY, lastZ;

    public MultiArrayCache(int reach) {
        this.reachX2 = reach * 2;
        this.cache = new byte[reachX2][reachX2][reachX2];
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
    }

    @Override
    public void setHidden(int x, int y, int z) {
        cache[x][y][z] = 2;
    }

    @Override
    public int getState(int x, int y, int z) {
        lastX = x;
        lastY = y;
        lastZ = z;
        return cache[x][y][z];
    }

    @Override
    public void setLastVisible() {
        cache[lastX][lastY][lastZ] = 1;
    }

    @Override
    public void setLastHidden() {
        cache[lastX][lastY][lastZ] = 2;
    }

}
