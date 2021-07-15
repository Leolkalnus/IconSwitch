package com.polyak.iconswitch;

public enum BgTypeEnum {
    INNER {
        @Override
        public BgTypeEnum bgType() {
            return INNER;
        }
    },
    OUTER {
        @Override
        public BgTypeEnum bgType() {
            return OUTER;
        }
    };

    public abstract BgTypeEnum bgType();
}