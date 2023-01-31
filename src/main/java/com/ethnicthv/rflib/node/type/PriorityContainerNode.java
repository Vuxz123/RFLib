package com.ethnicthv.rflib.node.type;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PriorityContainerNode extends ContainerNode {

    public PriorityContainerNode(String header) {
        super(header);
        this.TYPE = Type.PRIORITYCONTAINERNODE;
    }

    public PriorityContainerNode(String header, AbstractNode parent) {
        super(header, parent);
        this.TYPE = Type.PRIORITYCONTAINERNODE;
    }

    @Override
    public List<AbstractNode> getChild() {
        return super.getChild();
    }

    @Override
    public void addChild(AbstractNode child) {
        super.addChild(child);
    }

    @Override
    public void removeChild(AbstractNode child) {
        super.removeChild(child);
    }

    @Override
    public void fromStringRF(String input) {

    }

    @Override
    public String toStringRF() {
        return null;
    }

    /**
     * The bigger, the higher.
     */
    public enum Priority {
        FIVE(5), FOUR(4), ONE(1), THREE(3), TWO(2);

        int i;

        Priority(int i) {
            this.i = i;
        }
    }

    private class PairNode extends AbstractNode implements Comparable<PairNode> {
        private static final Type PAIR = new Type("pair-test", "sn");

        protected Priority key;

        protected AbstractNode value;

        protected PairNode(Priority key, AbstractNode value) {
            super(PAIR, null);
            this.key = key;
            this.value = value;
        }

        @Override
        public void fromStringRF(String input) {

        }

        @Override
        public String getHeader() {
            return this.value.getHeader();
        }

        @Override
        public String toStringRF() {
            return key.name();
        }

        @Override
        public int compareTo(@NotNull PriorityContainerNode.PairNode o) {
            return this.key.compareTo(o.key);
        }
    }
}
