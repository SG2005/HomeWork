package com.geekhub.homework5.task2;


public enum FileType {

    AUDIO {
        @Override
        public String[] getExtensions() {
            return new String[]{".mp3", ".wav", ".wm"};
        }
    },
    VIDEO {
        @Override
        public String[] getExtensions() {
            return new String[]{".avi", ".mp4", ".flv"};
        }
    },
    IMAGE {
        @Override
        public String[] getExtensions() {
            return new String[]{".jpeg", ".jpg", ".gif", ".tiff", ".png"};
        }
    };

    public abstract String[] getExtensions();
}


