package com.pdc.lychee.planetdefenseoffice.a_javabean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lychee on 2016/9/19.
 */
public class MarsImgsBean {

    /**
     * id : 103389
     * sol : 1000
     * camera : {"id":16,"name":"NAVCAM","rover_id":6,"full_name":"Navigation Camera"}
     * img_src : http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/ncam/NLB_486264973EDR_S0481570NCAM00546M_.JPG
     * earth_date : 2015-05-30
     * rover : {"id":5,"name":"Curiosity","landing_date":"2012-08-06","max_sol":1464,"max_date":"2016-09-18","total_photos":277920,"cameras":[{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]}
     */

    @SerializedName("photos")
    private List<PhotosEntity> photos;

    public List<PhotosEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosEntity> photos) {
        this.photos = photos;
    }

    public static class PhotosEntity {
        @SerializedName("id")
        private int id;
        @SerializedName("sol")
        private int sol;
        /**
         * id : 16
         * name : NAVCAM
         * rover_id : 6
         * full_name : Navigation Camera
         */

        @SerializedName("camera")
        private CameraEntity camera;
        @SerializedName("img_src")
        private String imgSrc;
        @SerializedName("earth_date")
        private String earthDate;
        /**
         * id : 5
         * name : Curiosity
         * landing_date : 2012-08-06
         * max_sol : 1464
         * max_date : 2016-09-18
         * total_photos : 277920
         * cameras : [{"name":"FHAZ","full_name":"Front Hazard Avoidance Camera"},{"name":"NAVCAM","full_name":"Navigation Camera"},{"name":"MAST","full_name":"Mast Camera"},{"name":"CHEMCAM","full_name":"Chemistry and Camera Complex"},{"name":"MAHLI","full_name":"Mars Hand Lens Imager"},{"name":"MARDI","full_name":"Mars Descent Imager"},{"name":"RHAZ","full_name":"Rear Hazard Avoidance Camera"}]
         */

        @SerializedName("rover")
        private RoverEntity rover;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSol() {
            return sol;
        }

        public void setSol(int sol) {
            this.sol = sol;
        }

        public CameraEntity getCamera() {
            return camera;
        }

        public void setCamera(CameraEntity camera) {
            this.camera = camera;
        }

        public String getImgSrc() {
            return imgSrc;
        }

        public void setImgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
        }

        public String getEarthDate() {
            return earthDate;
        }

        public void setEarthDate(String earthDate) {
            this.earthDate = earthDate;
        }

        public RoverEntity getRover() {
            return rover;
        }

        public void setRover(RoverEntity rover) {
            this.rover = rover;
        }

        public static class CameraEntity {
            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("rover_id")
            private int roverId;
            @SerializedName("full_name")
            private String fullName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRoverId() {
                return roverId;
            }

            public void setRoverId(int roverId) {
                this.roverId = roverId;
            }

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }
        }

        public static class RoverEntity {
            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("landing_date")
            private String landingDate;
            @SerializedName("max_sol")
            private int maxSol;
            @SerializedName("max_date")
            private String maxDate;
            @SerializedName("total_photos")
            private int totalPhotos;
            /**
             * name : FHAZ
             * full_name : Front Hazard Avoidance Camera
             */

            @SerializedName("cameras")
            private List<CamerasEntity> cameras;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLandingDate() {
                return landingDate;
            }

            public void setLandingDate(String landingDate) {
                this.landingDate = landingDate;
            }

            public int getMaxSol() {
                return maxSol;
            }

            public void setMaxSol(int maxSol) {
                this.maxSol = maxSol;
            }

            public String getMaxDate() {
                return maxDate;
            }

            public void setMaxDate(String maxDate) {
                this.maxDate = maxDate;
            }

            public int getTotalPhotos() {
                return totalPhotos;
            }

            public void setTotalPhotos(int totalPhotos) {
                this.totalPhotos = totalPhotos;
            }

            public List<CamerasEntity> getCameras() {
                return cameras;
            }

            public void setCameras(List<CamerasEntity> cameras) {
                this.cameras = cameras;
            }

            public static class CamerasEntity {
                @SerializedName("name")
                private String name;
                @SerializedName("full_name")
                private String fullName;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFullName() {
                    return fullName;
                }

                public void setFullName(String fullName) {
                    this.fullName = fullName;
                }
            }
        }
    }
}
