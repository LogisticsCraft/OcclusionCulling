package com.logisticscraft.occlusionculling.util;

import java.util.ArrayList;
import java.util.List;

import com.logisticscraft.occlusionculling.DataProvider;
import com.logisticscraft.occlusionculling.util.DataAccess.AccessType;

public class DummyWorld implements DataProvider {
    
    public List<DataAccess> blockChecks = new ArrayList<>();
    private Vec3d camera;

    public DummyWorld() {
        this(new Vec3d(0, 0, 0));
    }
    
    public DummyWorld(Vec3d camera) {
        super();
        this.camera = camera;
    }

    @Override
    public boolean prepareChunk(int chunkX, int chunkZ) {
        return true;
    }

    @Override
    public boolean isOpaqueFullCube(int x, int y, int z) {
        blockChecks.add(new DataAccess(AccessType.WORLDGET, x - Math.floor(camera.x), y-Math.floor(camera.y), z - Math.floor(camera.z)));
        return false;
    }

    public Vec3d getBlockMax(Vec3d pos) {
        return new Vec3d(pos.getX()+0.9d, pos.getY()+0.9d, pos.getZ()+0.9d);
    }
    
}
