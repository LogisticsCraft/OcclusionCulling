package com.logisticscraft.occlusionculling.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.logisticscraft.occlusionculling.cache.ArrayOcclusionCache;

public class ArrayOcclusionCacheTest {

    @Test
    public void testResetClearsWrittenEntries() {
        int reach = 8;
        int size = reach * 2;
        ArrayOcclusionCache cache = new ArrayOcclusionCache(reach);
        for (int i = 0; i < 500; i++) {
            cache.setVisible(i % size, (i / size) % size, 3);
        }
        cache.setVisible(1, 2, 3);
        cache.setHidden(4, 5, 6);
        cache.getState(7, 8, 9);
        cache.setLastVisible();
        cache.getState(10, 11, 12);
        cache.setLastHidden();
        cache.setHidden(1, 2, 3);
        assertEquals(3, cache.getState(1, 2, 3));
        assertEquals(2, cache.getState(4, 5, 6));
        assertEquals(1, cache.getState(7, 8, 9));
        assertEquals(2, cache.getState(10, 11, 12));
        cache.resetCache();
        assertAllZero(cache, reach);
        cache.setVisible(4, 5, 6);
        assertEquals(1, cache.getState(4, 5, 6));
    }

    @Test
    public void testResetClearsManyWrittenEntries() {
        int reach = 32;
        int size = reach * 2;
        ArrayOcclusionCache cache = new ArrayOcclusionCache(reach);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int z = 0; z < size; z++) {
                    cache.setHidden(x, y, z);
                }
            }
        }
        assertEquals(2, cache.getState(size - 1, size - 1, size - 1));
        cache.resetCache();
        assertAllZero(cache, reach);
        cache.setVisible(1, 1, 1);
        cache.resetCache();
        assertAllZero(cache, reach);
    }

    private static void assertAllZero(ArrayOcclusionCache cache, int reach) {
        int size = reach * 2;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int z = 0; z < size; z++) {
                    assertEquals(0, cache.getState(x, y, z));
                }
            }
        }
    }

}
