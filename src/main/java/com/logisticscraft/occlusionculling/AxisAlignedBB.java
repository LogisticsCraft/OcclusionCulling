package com.logisticscraft.occlusionculling;

public class AxisAlignedBB {

    public double minx;
    public double miny;
    public double minz;
    public double maxx;
    public double maxy;
    public double maxz;

    public AxisAlignedBB(double minx, double miny, double minz, double maxx, double maxy, double maxz) {
        this.minx = minx;
        this.miny = miny;
        this.minz = minz;
        this.maxx = maxx;
        this.maxy = maxy;
        this.maxz = maxz;
    }

    public Vec3d getAABBMiddle(Vec3d blockLoc) {
        return new Vec3d(minx + (maxx - minx) / 2d, miny + (maxy - miny) / 2d, minz + (maxz - minz) / 2d).add(blockLoc);
    }

    public Vec3d getMinVec3d() {
        return new Vec3d(minx, miny, minz);
    }

    public Vec3d getMaxVec3d() {
        return new Vec3d(maxx, maxy, maxz);
    }

    public double getWidth() {
        return maxx - minx;
    }

    public double getHeight() {
        return maxy - miny;
    }

    public double getDepth() {
        return maxz - minz;
    }

    @Override
    public String toString() {
        return minx + ":" + miny + ":" + minz + "_" + maxx + ":" + maxy + ":" + maxz;
    }

}
