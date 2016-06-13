package com.pdc.lychee.planetdefenseoffice.z_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lychee on 2016/6/13.
 */
public class TestBean2 {

    /**
     * self : https://api.nasa.gov/neo/rest/v1/neo/3726710?api_key=DEMO_KEY
     */

    @SerializedName("links")
    private LinksEntity links;
    /**
     * links : {"self":"https://api.nasa.gov/neo/rest/v1/neo/3726710?api_key=DEMO_KEY"}
     * neo_reference_id : 3726710
     * name : (2015 RC)
     * nasa_jpl_url : http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3726710
     * absolute_magnitude_h : 24.3
     * estimated_diameter : {"kilometers":{"estimated_diameter_min":0.0366906138,"estimated_diameter_max":0.0820427065},"meters":{"estimated_diameter_min":36.6906137531,"estimated_diameter_max":82.0427064882},"miles":{"estimated_diameter_min":0.0227984834,"estimated_diameter_max":0.0509789586},"feet":{"estimated_diameter_min":120.3760332259,"estimated_diameter_max":269.1689931548}}
     * is_potentially_hazardous_asteroid : false
     * close_approach_data : [{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"19.4701053405","kilometers_per_hour":"70092.3792259649","miles_per_hour":"43552.6786362669"},"miss_distance":{"astronomical":"0.0269024393","lunar":"10.46504879","kilometers":"4024547.75","miles":"2500738"},"orbiting_body":"Earth"}]
     * orbital_data : null
     */

    @SerializedName("neo_reference_id")
    private String neoReferenceId;
    @SerializedName("name")
    private String name;
    @SerializedName("nasa_jpl_url")
    private String nasaJplUrl;
    @SerializedName("absolute_magnitude_h")
    private double absoluteMagnitudeH;
    /**
     * kilometers : {"estimated_diameter_min":0.0366906138,"estimated_diameter_max":0.0820427065}
     * meters : {"estimated_diameter_min":36.6906137531,"estimated_diameter_max":82.0427064882}
     * miles : {"estimated_diameter_min":0.0227984834,"estimated_diameter_max":0.0509789586}
     * feet : {"estimated_diameter_min":120.3760332259,"estimated_diameter_max":269.1689931548}
     */

    @SerializedName("estimated_diameter")
    private EstimatedDiameterEntity estimatedDiameter;
    @SerializedName("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;
    @SerializedName("orbital_data")
    private Object orbitalData;
    /**
     * close_approach_date : 2015-09-08
     * epoch_date_close_approach : 1441695600000
     * relative_velocity : {"kilometers_per_second":"19.4701053405","kilometers_per_hour":"70092.3792259649","miles_per_hour":"43552.6786362669"}
     * miss_distance : {"astronomical":"0.0269024393","lunar":"10.46504879","kilometers":"4024547.75","miles":"2500738"}
     * orbiting_body : Earth
     */

    @SerializedName("close_approach_data")
    private List<CloseApproachDataEntity> closeApproachData;

    public LinksEntity getLinks() {
        return links;
    }

    public void setLinks(LinksEntity links) {
        this.links = links;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        this.neoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public EstimatedDiameterEntity getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public void setEstimatedDiameter(EstimatedDiameterEntity estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }

    public boolean isIsPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setIsPotentiallyHazardousAsteroid(boolean isPotentiallyHazardousAsteroid) {
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
    }

    public Object getOrbitalData() {
        return orbitalData;
    }

    public void setOrbitalData(Object orbitalData) {
        this.orbitalData = orbitalData;
    }

    public List<CloseApproachDataEntity> getCloseApproachData() {
        return closeApproachData;
    }

    public void setCloseApproachData(List<CloseApproachDataEntity> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    public static class LinksEntity {
        @SerializedName("self")
        private String self;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }
    }

    public static class EstimatedDiameterEntity {
        /**
         * estimated_diameter_min : 0.0366906138
         * estimated_diameter_max : 0.0820427065
         */

        @SerializedName("kilometers")
        private KilometersEntity kilometers;
        /**
         * estimated_diameter_min : 36.6906137531
         * estimated_diameter_max : 82.0427064882
         */

        @SerializedName("meters")
        private MetersEntity meters;
        /**
         * estimated_diameter_min : 0.0227984834
         * estimated_diameter_max : 0.0509789586
         */

        @SerializedName("miles")
        private MilesEntity miles;
        /**
         * estimated_diameter_min : 120.3760332259
         * estimated_diameter_max : 269.1689931548
         */

        @SerializedName("feet")
        private FeetEntity feet;

        public KilometersEntity getKilometers() {
            return kilometers;
        }

        public void setKilometers(KilometersEntity kilometers) {
            this.kilometers = kilometers;
        }

        public MetersEntity getMeters() {
            return meters;
        }

        public void setMeters(MetersEntity meters) {
            this.meters = meters;
        }

        public MilesEntity getMiles() {
            return miles;
        }

        public void setMiles(MilesEntity miles) {
            this.miles = miles;
        }

        public FeetEntity getFeet() {
            return feet;
        }

        public void setFeet(FeetEntity feet) {
            this.feet = feet;
        }

        public static class KilometersEntity {
            @SerializedName("estimated_diameter_min")
            private double estimatedDiameterMin;
            @SerializedName("estimated_diameter_max")
            private double estimatedDiameterMax;

            public double getEstimatedDiameterMin() {
                return estimatedDiameterMin;
            }

            public void setEstimatedDiameterMin(double estimatedDiameterMin) {
                this.estimatedDiameterMin = estimatedDiameterMin;
            }

            public double getEstimatedDiameterMax() {
                return estimatedDiameterMax;
            }

            public void setEstimatedDiameterMax(double estimatedDiameterMax) {
                this.estimatedDiameterMax = estimatedDiameterMax;
            }
        }

        public static class MetersEntity {
            @SerializedName("estimated_diameter_min")
            private double estimatedDiameterMin;
            @SerializedName("estimated_diameter_max")
            private double estimatedDiameterMax;

            public double getEstimatedDiameterMin() {
                return estimatedDiameterMin;
            }

            public void setEstimatedDiameterMin(double estimatedDiameterMin) {
                this.estimatedDiameterMin = estimatedDiameterMin;
            }

            public double getEstimatedDiameterMax() {
                return estimatedDiameterMax;
            }

            public void setEstimatedDiameterMax(double estimatedDiameterMax) {
                this.estimatedDiameterMax = estimatedDiameterMax;
            }
        }

        public static class MilesEntity {
            @SerializedName("estimated_diameter_min")
            private double estimatedDiameterMin;
            @SerializedName("estimated_diameter_max")
            private double estimatedDiameterMax;

            public double getEstimatedDiameterMin() {
                return estimatedDiameterMin;
            }

            public void setEstimatedDiameterMin(double estimatedDiameterMin) {
                this.estimatedDiameterMin = estimatedDiameterMin;
            }

            public double getEstimatedDiameterMax() {
                return estimatedDiameterMax;
            }

            public void setEstimatedDiameterMax(double estimatedDiameterMax) {
                this.estimatedDiameterMax = estimatedDiameterMax;
            }
        }

        public static class FeetEntity {
            @SerializedName("estimated_diameter_min")
            private double estimatedDiameterMin;
            @SerializedName("estimated_diameter_max")
            private double estimatedDiameterMax;

            public double getEstimatedDiameterMin() {
                return estimatedDiameterMin;
            }

            public void setEstimatedDiameterMin(double estimatedDiameterMin) {
                this.estimatedDiameterMin = estimatedDiameterMin;
            }

            public double getEstimatedDiameterMax() {
                return estimatedDiameterMax;
            }

            public void setEstimatedDiameterMax(double estimatedDiameterMax) {
                this.estimatedDiameterMax = estimatedDiameterMax;
            }
        }
    }

    public static class CloseApproachDataEntity {
        @SerializedName("close_approach_date")
        private String closeApproachDate;
        @SerializedName("epoch_date_close_approach")
        private long epochDateCloseApproach;
        /**
         * kilometers_per_second : 19.4701053405
         * kilometers_per_hour : 70092.3792259649
         * miles_per_hour : 43552.6786362669
         */

        @SerializedName("relative_velocity")
        private RelativeVelocityEntity relativeVelocity;
        /**
         * astronomical : 0.0269024393
         * lunar : 10.46504879
         * kilometers : 4024547.75
         * miles : 2500738
         */

        @SerializedName("miss_distance")
        private MissDistanceEntity missDistance;
        @SerializedName("orbiting_body")
        private String orbitingBody;

        public String getCloseApproachDate() {
            return closeApproachDate;
        }

        public void setCloseApproachDate(String closeApproachDate) {
            this.closeApproachDate = closeApproachDate;
        }

        public long getEpochDateCloseApproach() {
            return epochDateCloseApproach;
        }

        public void setEpochDateCloseApproach(long epochDateCloseApproach) {
            this.epochDateCloseApproach = epochDateCloseApproach;
        }

        public RelativeVelocityEntity getRelativeVelocity() {
            return relativeVelocity;
        }

        public void setRelativeVelocity(RelativeVelocityEntity relativeVelocity) {
            this.relativeVelocity = relativeVelocity;
        }

        public MissDistanceEntity getMissDistance() {
            return missDistance;
        }

        public void setMissDistance(MissDistanceEntity missDistance) {
            this.missDistance = missDistance;
        }

        public String getOrbitingBody() {
            return orbitingBody;
        }

        public void setOrbitingBody(String orbitingBody) {
            this.orbitingBody = orbitingBody;
        }

        public static class RelativeVelocityEntity {
            @SerializedName("kilometers_per_second")
            private String kilometersPerSecond;
            @SerializedName("kilometers_per_hour")
            private String kilometersPerHour;
            @SerializedName("miles_per_hour")
            private String milesPerHour;

            public String getKilometersPerSecond() {
                return kilometersPerSecond;
            }

            public void setKilometersPerSecond(String kilometersPerSecond) {
                this.kilometersPerSecond = kilometersPerSecond;
            }

            public String getKilometersPerHour() {
                return kilometersPerHour;
            }

            public void setKilometersPerHour(String kilometersPerHour) {
                this.kilometersPerHour = kilometersPerHour;
            }

            public String getMilesPerHour() {
                return milesPerHour;
            }

            public void setMilesPerHour(String milesPerHour) {
                this.milesPerHour = milesPerHour;
            }
        }

        public static class MissDistanceEntity {
            @SerializedName("astronomical")
            private String astronomical;
            @SerializedName("lunar")
            private String lunar;
            @SerializedName("kilometers")
            private String kilometers;
            @SerializedName("miles")
            private String miles;

            public String getAstronomical() {
                return astronomical;
            }

            public void setAstronomical(String astronomical) {
                this.astronomical = astronomical;
            }

            public String getLunar() {
                return lunar;
            }

            public void setLunar(String lunar) {
                this.lunar = lunar;
            }

            public String getKilometers() {
                return kilometers;
            }

            public void setKilometers(String kilometers) {
                this.kilometers = kilometers;
            }

            public String getMiles() {
                return miles;
            }

            public void setMiles(String miles) {
                this.miles = miles;
            }
        }
    }
}
