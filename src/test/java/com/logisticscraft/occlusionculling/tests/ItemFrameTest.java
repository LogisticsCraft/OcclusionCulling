package com.logisticscraft.occlusionculling.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logisticscraft.occlusionculling.OcclusionCullingInstance;
import com.logisticscraft.occlusionculling.util.DummyWorld;
import com.logisticscraft.occlusionculling.util.JsonOutput;
import com.logisticscraft.occlusionculling.util.MultiArrayCache;
import com.logisticscraft.occlusionculling.util.Vec3d;

public class ItemFrameTest {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Test
    public void testInPositiveX() {
        DummyWorld world = new DummyWorld();
        OcclusionCullingInstance culling = new OcclusionCullingInstance(128, world, new MultiArrayCache(128, world), 0.5);
        Vec3d block = new Vec3d(10.1, 0.1, 0);
        Vec3d camera = new Vec3d(0.5, 0.5, 0.5);
        assertTrue(culling.isAABBVisible(block, new Vec3d(10.9, 0.9, 0.1), camera));
        //System.out.println(world.blockChecks.toString().replace("], ", "], \n"));
       // System.out.println(gson.toJson(new JsonOutput(block, new Vec3d(10.9, 0.9, 0.1), 0.5, camera, world.blockChecks)));
    }
    
}
