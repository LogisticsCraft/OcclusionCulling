package com.logisticscraft.occlusionculling.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.logisticscraft.occlusionculling.OcclusionCullingInstance;
import com.logisticscraft.occlusionculling.util.DummyWorld;
import com.logisticscraft.occlusionculling.util.MultiArrayCache;
import com.logisticscraft.occlusionculling.util.RayUtil;
import com.logisticscraft.occlusionculling.util.Vec3d;

public class DiagonalLineTest {

    private int[] targets = new int[] { 10, -10, 0 };
    private int[] cameraPos = new int[] { 53, -34, 0 };

    @Test
    public void diagonalFuzzing() {
        for (int x = 0; x < targets.length; x++) {
            for (int y = 0; y < targets.length; y++) {
                for (int z = 0; z < targets.length; z++) {
                    int length = -1;
                    Vec3d block = new Vec3d(targets[x], targets[y], targets[z]);
                    for (int i = 0; i < 10; i++) {
                        DummyWorld world = new DummyWorld();
                        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world,
                                new MultiArrayCache(128, world), 0);
                        Vec3d camera = new Vec3d(0.1 * i, 0.1 * i, 0.1 * i);
                        if(!culling.isAABBVisible(block, world.getBlockMax(block), camera)) {
                            System.out.println(world.blockChecks);
                        }
                        if(!block.equals(new Vec3d(0, 0, 0))) {
                            assertFalse(world.blockChecks.isEmpty());
                            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
                        }else {
                            assertTrue(world.blockChecks.isEmpty());
                        }
                        if (length == -1) {
                            length = world.blockChecks.size();
                        } else {
                            assertEquals(length, world.blockChecks.size());
                        }
                    }
                }
            }
        }
    }

    @Test
    public void diagonalFuzzingDifferentPositions() {
        for (int x = 0; x < targets.length; x++) {
            for (int y = 0; y < targets.length; y++) {
                for (int z = 0; z < targets.length; z++) {
                    Vec3d block = new Vec3d(targets[x], targets[y], targets[z]);
                    Vec3d start = new Vec3d(cameraPos[x], cameraPos[y], cameraPos[z]);
                    for (int i = 0; i < 10; i++) {
                        Vec3d camera = new Vec3d(start.x + 0.1 * i, start.y + 0.1 * i, start.z + 0.1 * i);
                        DummyWorld world = new DummyWorld(camera);
                        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world,
                                new MultiArrayCache(128, world), 0);
                        if(!block.equals(new Vec3d(0, 0, 0)) && !camera.equals(new Vec3d(0, 0, 0))) {
                            assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
                            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
                        }else {
                            assertTrue(world.blockChecks.isEmpty());
                        }
                    }
                }
            }
        }
    }
    
}
