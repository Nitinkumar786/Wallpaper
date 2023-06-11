package com.example.wallpaperapp;

import com.google.gson.annotations.SerializedName;

public class ImageDimension {

        @SerializedName("medium")
        private String medium;
        @SerializedName("large")
        private String large;

        public ImageDimension(String medium, String large) {
            this.medium = medium;
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
    }


