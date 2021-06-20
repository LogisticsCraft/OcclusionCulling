package com.logisticscraft.occlusionculling.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.logisticscraft.occlusionculling.util.DataAccess.AccessType;

public class RayUtil {

    public static boolean isCompleteRay(Vec3d block, Vec3d camera, List<DataAccess> access, boolean singleBlock) {
        for(int i = 0; i < access.size(); i++) {
            if(access.get(i).accesstype == AccessType.WORLDGET) {
                assertTrue(access.get(i-1).accesstype == AccessType.CACHEGET);
                assertTrue(access.get(i+1).accesstype == AccessType.CACHEWRITE);
                assertEquals(access.get(i-1).x, access.get(i).x, 0.001);
                assertEquals(access.get(i-1).y, access.get(i).y, 0.001);
                assertEquals(access.get(i-1).z, access.get(i).z, 0.001);
                assertEquals(access.get(i+1).x, access.get(i).x, 0.001);
                assertEquals(access.get(i+1).y, access.get(i).y, 0.001);
                assertEquals(access.get(i+1).z, access.get(i).z, 0.001);
            }
        }
        if(singleBlock)
            assertEquals(new DataAccess(AccessType.CACHEWRITE, block.x-Math.floor(camera.x), block.y-Math.floor(camera.y), block.z-Math.floor(camera.z)), access.get(access.size()-1));
        return true;
    }
    
}
