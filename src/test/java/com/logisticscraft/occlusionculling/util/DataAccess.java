package com.logisticscraft.occlusionculling.util;

public class DataAccess extends Vec3d {

    public final AccessType accesstype;
    
    public DataAccess(AccessType type, double x, double y, double z) {
        super(x, y, z);
        this.accesstype = type;
    }

    @Override
    public String toString() {
        return "DataAccess[" + accesstype + ", x=" + x + ", y=" + y + ", z=" + z + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((accesstype == null) ? 0 : accesstype.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataAccess other = (DataAccess) obj;
        if (accesstype != other.accesstype)
            return false;
        return true;
    }


    public static enum AccessType{
        WORLDGET, CACHEGET, CACHEWRITE
    }
}
