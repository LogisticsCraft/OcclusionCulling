package com.logisticscraft.occlusionculling.util;

public class Vec3d {

    public static final Vec3d ZERO = new Vec3d(0.0, 0.0, 0.0);

    public double x;
    public double y;
    public double z;

    public Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vec3d reverseSubtract(Vec3d other) {
        return new Vec3d(other.x - x, other.y - y, other.z - z);
    }

    public Vec3d reverseSubtractMutable(Vec3d other) {
        x = other.x - x;
        y = other.y - y;
        z = other.z - z;
        return this;
    }

    public double dotProduct(Vec3d other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vec3d crossProduct(Vec3d other) {
        return new Vec3d(y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x);
    }

    public Vec3d crossProductMutable(Vec3d other) {
        x = y * other.z - z * other.y;
        y = z * other.x - x * other.z;
        z = x * other.y - y * other.x;
        return this;
    }

    public Vec3d subtract(Vec3d other) {
        return subtract(other.x, other.y, other.z);
    }

    public Vec3d subtractMutable(Vec3d other) {
        return subtractMutable(other.x, other.y, other.z);
    }

    public Vec3d subtract(double x, double y, double z) {
        return add(-x, -y, -z);
    }

    public Vec3d subtractMutable(double x, double y, double z) {
        return addMutable(-x, -y, -z);
    }

    public Vec3d add(Vec3d other) {
        return add(other.x, other.y, other.z);
    }

    public Vec3d addMutable(Vec3d other) {
        return add(other.x, other.y, other.z);
    }

    public Vec3d add(double x, double y, double z) {
        return new Vec3d(this.x + x, this.y + y, this.z + z);
    }

    public Vec3d addMutable(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public double squaredDistanceTo(Vec3d other) {
        double deltaX = other.x - x;
        double deltaY = other.y - y;
        double deltaZ = other.z - z;
        return (deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ);
    }

    public double squaredDistanceTo(double x, double y, double z) {
        double deltaX = x - this.x;
        double deltaY = y - this.y;
        double deltaZ = z - this.z;
        return (deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ);
    }

    public Vec3d multiply(double multiplier) {
        return multiply(multiplier, multiplier, multiplier);
    }

    public Vec3d multiplyMutable(double multiplier) {
        return multiplyMutable(multiplier, multiplier, multiplier);
    }

    public Vec3d multiply(Vec3d other) {
        return multiply(other.x, other.y, other.z);
    }

    public Vec3d multiplyMutable(Vec3d other) {
        return multiplyMutable(other.x, other.y, other.z);
    }

    public Vec3d multiply(double x, double y, double z) {
        return new Vec3d(this.x * x, this.y * y,
            this.z * z);
    }

    public Vec3d multiplyMutable(double x, double y, double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public double lengthSquared() {
        return (x * x) + (y * y) + (z * z);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vec3d)) {
            return false;
        }
        Vec3d vec3d = (Vec3d) other;
        if (Double.compare(vec3d.x, x) != 0) {
            return false;
        }
        if (Double.compare(vec3d.y, y) != 0) {
            return false;
        }
        return Double.compare(vec3d.z, z) == 0;
    }

    @Override
    public int hashCode() {
        long l = Double.doubleToLongBits(x);
        int i = (int) (l ^ l >>> 32);
        l = Double.doubleToLongBits(y);
        i = 31 * i + (int) (l ^ l >>> 32);
        l = Double.doubleToLongBits(z);
        i = 31 * i + (int) (l ^ l >>> 32);
        return i;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

}
