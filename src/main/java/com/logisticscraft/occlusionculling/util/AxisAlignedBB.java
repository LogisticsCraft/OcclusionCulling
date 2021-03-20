package com.logisticscraft.occlusionculling.util;

public class AxisAlignedBB {

    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;

    public AxisAlignedBB(double minX, double minY, double minZ, double maxX,
                         double maxY, double maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public Vec3d getAABBMiddle(Vec3d blockLoc) {
        return new Vec3d(minX + (maxX - minX) / 2d,
            minY + (maxY - minY) / 2d,
            minZ + (maxZ - minZ) / 2d).add(blockLoc);
    }

    public Vec3d getMinVector() {
        return new Vec3d(minX, minY, minZ);
    }

    public Vec3d getMaxVector() {
        return new Vec3d(maxX, maxY, maxZ);
    }

    public double getWidth() {
        return maxX - minX;
    }

    public double getHeight() {
        return maxY - minY;
    }

    public double getDepth() {
        return maxZ - minZ;
    }

    @Override
    public String toString() {
        return minX + ":" + minY + ":" + minZ + "_" + maxX + ":" + maxY + ":"
            + maxZ;
    }

}
