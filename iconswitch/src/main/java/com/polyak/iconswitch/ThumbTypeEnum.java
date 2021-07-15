package com.polyak.iconswitch;

public enum ThumbTypeEnum {
        CIRCLE {
            @Override
            public ThumbTypeEnum thumbType() {
                return CIRCLE;
            }
        },
        SQUARE {
            @Override
            public ThumbTypeEnum thumbType() {
                return SQUARE;
            }
        };

        public abstract ThumbTypeEnum thumbType();
    }