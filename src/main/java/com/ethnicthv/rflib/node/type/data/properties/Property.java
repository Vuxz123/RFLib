package com.ethnicthv.rflib.node.type.data.properties;

import java.util.Objects;

public class Property {
    public static final BUILDER BUILDER = new BUILDER();
    private boolean isHasContainer = false;
    private boolean isContainerImutable = false;
    private String name = null;

    private Property() {
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Property)) return false;
        return ((Property) obj).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHasContainer, name);
    }

    public static class BUILDER {
        private Property inbuild;

        private BUILDER() {
            inbuild = new Property();
        }

        /**
         * @param mutable make the container imutable if false;
         * @return
         */
        public BUILDER containable(boolean mutable) {
            inbuild.isHasContainer = true;
            inbuild.isContainerImutable = !mutable;
            return this;
        }

        public BUILDER name(String name) {
            inbuild.name = name;
            return this;
        }

        public Property create() {
            Property rt = this.inbuild;
            this.inbuild = new Property();
            return rt;
        }
    }
}
