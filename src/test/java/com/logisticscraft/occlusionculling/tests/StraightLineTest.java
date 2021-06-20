package com.logisticscraft.occlusionculling.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.logisticscraft.occlusionculling.OcclusionCullingInstance;
import com.logisticscraft.occlusionculling.util.DummyWorld;
import com.logisticscraft.occlusionculling.util.MultiArrayCache;
import com.logisticscraft.occlusionculling.util.RayUtil;
import com.logisticscraft.occlusionculling.util.Vec3d;

public class StraightLineTest {

    @Test
    public void testInPositiveX() {
        DummyWorld world = new DummyWorld();
        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world), 0);
        Vec3d block = new Vec3d(10, 0, 0);
        Vec3d camera = new Vec3d(0.5, 0.5, 0.5);
        assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
        assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
    }

    @Test
    public void testInPositiveXFuzzing() {
        int length = -1;
        Vec3d block = new Vec3d(10, 0, 0);
        for (int i = 0; i < 10; i++) {
            DummyWorld world = new DummyWorld();
            OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world),
                    0);
            Vec3d camera = new Vec3d(0.1*i, 0.1*i, 0.1*i);
            assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
            if (length == -1) {
                length = world.blockChecks.size();
            } else {
                assertEquals(length, world.blockChecks.size());
            }
        }
    }

    @Test
    public void testInPositiveY() {
        DummyWorld world = new DummyWorld();
        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world), 0);
        Vec3d block = new Vec3d(0, 10, 0);
        Vec3d camera = new Vec3d(0.5, 0.5, 0.5);
        assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
        assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
    }

    @Test
    public void testInPositiveYFuzzing() {
        int length = -1;
        Vec3d block = new Vec3d(0, 10, 0);
        for (int i = 0; i < 10; i++) {
            DummyWorld world = new DummyWorld();
            OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world),
                    0);
            Vec3d camera = new Vec3d(0.1*i, 0.1*i, 0.1*i);
            assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
            if (length == -1) {
                length = world.blockChecks.size();
            } else {
                assertEquals(length, world.blockChecks.size());
            }
        }
    }
    
    @Test
    public void testInPositiveZ() {
        DummyWorld world = new DummyWorld();
        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world), 0);
        Vec3d block = new Vec3d(0, 0, 10);
        Vec3d camera = new Vec3d(0.5, 0.5, 0.5);
        assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
        assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
    }

    @Test
    public void testInPositiveZFuzzing() {
        int length = -1;
        Vec3d block = new Vec3d(0, 0, 10);
        for (int i = 0; i < 10; i++) {
            DummyWorld world = new DummyWorld();
            OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world),
                    0);
            Vec3d camera = new Vec3d(0.1*i, 0.1*i, 0.1*i);
            assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
            if (length == -1) {
                length = world.blockChecks.size();
            } else {
                assertEquals(length, world.blockChecks.size());
            }
        }
    }
    
    @Test
    public void testInNegativeX() {
        DummyWorld world = new DummyWorld();
        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world), 0);
        Vec3d block = new Vec3d(-10, 0, 0);
        Vec3d camera = new Vec3d(0.5, 0.5, 0.5);
        assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
        assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
    }

    @Test
    public void testInNegativeXFuzzing() {
        int length = -1;
        Vec3d block = new Vec3d(-10, 0, 0);
        for (int i = 0; i < 10; i++) {
            DummyWorld world = new DummyWorld();
            OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world),
                    0);
            Vec3d camera = new Vec3d(0.1*i, 0.1*i, 0.1*i);
            assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
            if (length == -1) {
                length = world.blockChecks.size();
            } else {
                assertEquals(length, world.blockChecks.size());
            }
        }
    }

    @Test
    public void testInNegativeY() {
        DummyWorld world = new DummyWorld();
        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world), 0);
        Vec3d block = new Vec3d(0, -10, 0);
        Vec3d camera = new Vec3d(0.5, 0.5, 0.5);
        assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
        assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
    }

    @Test
    public void testInNegativeYFuzzing() {
        int length = -1;
        Vec3d block = new Vec3d(0, -10, 0);
        for (int i = 0; i < 10; i++) {
            DummyWorld world = new DummyWorld();
            OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world),
                    0);
            Vec3d camera = new Vec3d(0.1*i, 0.1*i, 0.1*i);
            assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
            if (length == -1) {
                length = world.blockChecks.size();
            } else {
                assertEquals(length, world.blockChecks.size());
            }
        }
    }
    
    @Test
    public void testInNegativeZ() {
        DummyWorld world = new DummyWorld();
        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world), 0);
        Vec3d block = new Vec3d(0, 0, -10);
        Vec3d camera = new Vec3d(0.5, 0.5, 0.5);
        assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
        assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
    }

    @Test
    public void testInNegativeZFuzzing() {
        int length = -1;
        Vec3d block = new Vec3d(0, 0, -10);
        for (int i = 0; i < 10; i++) {
            DummyWorld world = new DummyWorld();
            OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world),
                    0);
            Vec3d camera = new Vec3d(0.1*i, 0.1*i, 0.1*i);
            assertTrue(culling.isAABBVisible(block, world.getBlockMax(block), camera));
            assertTrue(RayUtil.isCompleteRay(block, camera, world.blockChecks, true));
            if (length == -1) {
                length = world.blockChecks.size();
            } else {
                assertEquals(length, world.blockChecks.size());
            }
        }
    }

    
}
