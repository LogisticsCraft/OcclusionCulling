package com.logisticscraft.occlusionculling.util;

import java.util.List;

public class JsonOutput {
    
    public JsonOutput(Vec3d aabbmin, Vec3d aabbmax, double aabbExtend, Vec3d cameraPos, List<DataAccess> blockChecks) {
        super();
        this.aabbmin = aabbmin;
        this.aabbmax = aabbmax;
        this.aabbExtend = aabbExtend;
        this.cameraPos = cameraPos;
        this.blockChecks = blockChecks;
    }
    
    public Vec3d aabbmin;
    public Vec3d aabbmax;
    public double aabbExtend;
    public Vec3d cameraPos;
    public List<DataAccess> blockChecks;
    
}
