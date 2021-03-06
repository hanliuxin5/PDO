package com.pdc.lychee.planetdefenseoffice.z_test;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by lychee on 2016/6/13.
 */
public class TestBean {

    /**
     * next : https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-08&end_date=2015-09-09&api_key=DEMO_KEY
     * prev : https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-06&end_date=2015-09-07&api_key=DEMO_KEY
     * self : https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY
     */

    @com.google.gson.annotations.SerializedName("links")
    private LinksEntity links;
    /**
     * links : {"next":"https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-08&end_date=2015-09-09&api_key=DEMO_KEY","prev":"https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-06&end_date=2015-09-07&api_key=DEMO_KEY","self":"https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY"}
     * element_count : 17
     * near_earth_objects : {"2015-09-08":[{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3726710?api_key=DEMO_KEY"},"neo_reference_id":"3726710","name":"(2015 RC)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3726710","absolute_magnitude_h":24.3,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0366906138,"estimated_diameter_max":0.0820427065},"meters":{"estimated_diameter_min":36.6906137531,"estimated_diameter_max":82.0427064882},"miles":{"estimated_diameter_min":0.0227984834,"estimated_diameter_max":0.0509789586},"feet":{"estimated_diameter_min":120.3760332259,"estimated_diameter_max":269.1689931548}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"19.4701053405","kilometers_per_hour":"70092.3792259649","miles_per_hour":"43552.6786362669"},"miss_distance":{"astronomical":"0.0269024393","lunar":"10.46504879","kilometers":"4024547.75","miles":"2500738"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3730577?api_key=DEMO_KEY"},"neo_reference_id":"3730577","name":"(2015 TX237)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3730577","absolute_magnitude_h":23.3,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.058150704,"estimated_diameter_max":0.130028927},"meters":{"estimated_diameter_min":58.1507039646,"estimated_diameter_max":130.0289270043},"miles":{"estimated_diameter_min":0.0361331611,"estimated_diameter_max":0.0807962044},"feet":{"estimated_diameter_min":190.7831555951,"estimated_diameter_max":426.6041048727}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"6.5730424387","kilometers_per_hour":"23662.9527794577","miles_per_hour":"14703.2386312136"},"miss_distance":{"astronomical":"0.0795210946","lunar":"30.9337062836","kilometers":"11896187","miles":"7391948"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/2465633?api_key=DEMO_KEY"},"neo_reference_id":"2465633","name":"465633 (2009 JR5)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2465633","absolute_magnitude_h":20.3,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.2315021222,"estimated_diameter_max":0.5176544822},"meters":{"estimated_diameter_min":231.5021222103,"estimated_diameter_max":517.6544821978},"miles":{"estimated_diameter_min":0.1438487052,"estimated_diameter_max":0.3216554833},"feet":{"estimated_diameter_min":759.5214226325,"estimated_diameter_max":1698.3415313737}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"18.1279766789","kilometers_per_hour":"65260.7160439558","miles_per_hour":"40550.4710329791"},"miss_distance":{"astronomical":"0.3027491578","lunar":"117.7694244385","kilometers":"45290628","miles":"28142292"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3359445?api_key=DEMO_KEY"},"neo_reference_id":"3359445","name":"(2006 WO1)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3359445","absolute_magnitude_h":19.2,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.3841978911,"estimated_diameter_max":0.8590926012},"meters":{"estimated_diameter_min":384.1978910643,"estimated_diameter_max":859.0926012318},"miles":{"estimated_diameter_min":0.2387294278,"estimated_diameter_max":0.5338152287},"feet":{"estimated_diameter_min":1260.4918089193,"estimated_diameter_max":2818.5453698252}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"3.8099244366","kilometers_per_hour":"13715.7279717078","miles_per_hour":"8522.4199721981"},"miss_distance":{"astronomical":"0.3460122415","lunar":"134.5987548828","kilometers":"51762692","miles":"32163846"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3426410?api_key=DEMO_KEY"},"neo_reference_id":"3426410","name":"(2008 QV11)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3426410","absolute_magnitude_h":21,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.1677084622,"estimated_diameter_max":0.3750075218},"meters":{"estimated_diameter_min":167.7084621628,"estimated_diameter_max":375.0075217981},"miles":{"estimated_diameter_min":0.1042091748,"estimated_diameter_max":0.2330187988},"feet":{"estimated_diameter_min":550.2246310023,"estimated_diameter_max":1230.3396778159}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"19.7497935696","kilometers_per_hour":"71099.2568504714","miles_per_hour":"44178.3132357832"},"miss_distance":{"astronomical":"0.2591242186","lunar":"100.7993240356","kilometers":"38764432","miles":"24087102"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3553060?api_key=DEMO_KEY"},"neo_reference_id":"3553060","name":"(2010 XT10)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3553060","absolute_magnitude_h":26.5,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0133215567,"estimated_diameter_max":0.0297879063},"meters":{"estimated_diameter_min":13.3215566698,"estimated_diameter_max":29.7879062798},"miles":{"estimated_diameter_min":0.008277629,"estimated_diameter_max":0.0185093411},"feet":{"estimated_diameter_min":43.7058959846,"estimated_diameter_max":97.7293544391}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"19.1334815449","kilometers_per_hour":"68880.5335618125","miles_per_hour":"42799.684867894"},"miss_distance":{"astronomical":"0.4910762066","lunar":"191.0286407471","kilometers":"73463952","miles":"45648384"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3727181?api_key=DEMO_KEY"},"neo_reference_id":"3727181","name":"(2015 RO36)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3727181","absolute_magnitude_h":22.9,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0699125232,"estimated_diameter_max":0.1563291544},"meters":{"estimated_diameter_min":69.9125232246,"estimated_diameter_max":156.3291544087},"miles":{"estimated_diameter_min":0.0434416145,"estimated_diameter_max":0.097138403},"feet":{"estimated_diameter_min":229.3718026961,"estimated_diameter_max":512.8909429502}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"15.8061798736","kilometers_per_hour":"56902.2475449715","miles_per_hour":"35356.843759263"},"miss_distance":{"astronomical":"0.0540420175","lunar":"21.0223445892","kilometers":"8084571","miles":"5023519.5"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3727639?api_key=DEMO_KEY"},"neo_reference_id":"3727639","name":"(2015 RN83)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3727639","absolute_magnitude_h":21.7,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.1214940408,"estimated_diameter_max":0.2716689341},"meters":{"estimated_diameter_min":121.4940407996,"estimated_diameter_max":271.6689340891},"miles":{"estimated_diameter_min":0.0754928736,"estimated_diameter_max":0.1688071972},"feet":{"estimated_diameter_min":398.6025088171,"estimated_diameter_max":891.3023057169}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"12.081222691","kilometers_per_hour":"43492.4016876407","miles_per_hour":"27024.4870375232"},"miss_distance":{"astronomical":"0.1684210302","lunar":"65.5157775879","kilometers":"25195428","miles":"15655713"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3731587?api_key=DEMO_KEY"},"neo_reference_id":"3731587","name":"(2015 UG)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3731587","absolute_magnitude_h":22.7,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0766575574,"estimated_diameter_max":0.1714115092},"meters":{"estimated_diameter_min":76.6575573531,"estimated_diameter_max":171.4115092306},"miles":{"estimated_diameter_min":0.0476327831,"estimated_diameter_max":0.1065101409},"feet":{"estimated_diameter_min":251.5011804664,"estimated_diameter_max":562.3737359442}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"11.9559276783","kilometers_per_hour":"43041.3396419916","miles_per_hour":"26744.2146236586"},"miss_distance":{"astronomical":"0.1132340881","lunar":"44.0480613708","kilometers":"16939578","miles":"10525766"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3747356?api_key=DEMO_KEY"},"neo_reference_id":"3747356","name":"(2016 EK158)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3747356","absolute_magnitude_h":20.4,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.2210828104,"estimated_diameter_max":0.4943561926},"meters":{"estimated_diameter_min":221.0828103591,"estimated_diameter_max":494.3561926196},"miles":{"estimated_diameter_min":0.137374447,"estimated_diameter_max":0.3071786018},"feet":{"estimated_diameter_min":725.3373275385,"estimated_diameter_max":1621.9035709942}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-08","epoch_date_close_approach":1441695600000,"relative_velocity":{"kilometers_per_second":"16.9599403426","kilometers_per_hour":"61055.7852335321","miles_per_hour":"37937.6905524689"},"miss_distance":{"astronomical":"0.280500381","lunar":"109.1146469116","kilometers":"41962260","miles":"26074140"},"orbiting_body":"Earth"}],"orbital_data":null}],"2015-09-07":[{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3726788?api_key=DEMO_KEY"},"neo_reference_id":"3726788","name":"(2015 RG2)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3726788","absolute_magnitude_h":26.7,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0121494041,"estimated_diameter_max":0.0271668934},"meters":{"estimated_diameter_min":12.14940408,"estimated_diameter_max":27.1668934089},"miles":{"estimated_diameter_min":0.0075492874,"estimated_diameter_max":0.0168807197},"feet":{"estimated_diameter_min":39.8602508817,"estimated_diameter_max":89.1302305717}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-07","epoch_date_close_approach":1441609200000,"relative_velocity":{"kilometers_per_second":"8.0894284334","kilometers_per_hour":"29121.942360303","miles_per_hour":"18095.2424627116"},"miss_distance":{"astronomical":"0.016383252","lunar":"6.3730845451","kilometers":"2450899.5","miles":"1522918.375"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3727036?api_key=DEMO_KEY"},"neo_reference_id":"3727036","name":"(2015 RL35)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3727036","absolute_magnitude_h":26.3,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0146067964,"estimated_diameter_max":0.0326617897},"meters":{"estimated_diameter_min":14.6067964271,"estimated_diameter_max":32.6617897446},"miles":{"estimated_diameter_min":0.0090762397,"estimated_diameter_max":0.020295089},"feet":{"estimated_diameter_min":47.92256199,"estimated_diameter_max":107.1581062656}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-07","epoch_date_close_approach":1441609200000,"relative_velocity":{"kilometers_per_second":"3.5174544049","kilometers_per_hour":"12662.8358576702","miles_per_hour":"7868.1937583396"},"miss_distance":{"astronomical":"0.0692566522","lunar":"26.9408397675","kilometers":"10360648","miles":"6437808.5"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3727662?api_key=DEMO_KEY"},"neo_reference_id":"3727662","name":"(2015 RX83)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3727662","absolute_magnitude_h":22.9,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0699125232,"estimated_diameter_max":0.1563291544},"meters":{"estimated_diameter_min":69.9125232246,"estimated_diameter_max":156.3291544087},"miles":{"estimated_diameter_min":0.0434416145,"estimated_diameter_max":0.097138403},"feet":{"estimated_diameter_min":229.3718026961,"estimated_diameter_max":512.8909429502}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-07","epoch_date_close_approach":1441609200000,"relative_velocity":{"kilometers_per_second":"2.6952545467","kilometers_per_hour":"9702.9163682419","miles_per_hour":"6029.014895589"},"miss_distance":{"astronomical":"0.2895620437","lunar":"112.6396331787","kilometers":"43317864","miles":"26916474"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3727663?api_key=DEMO_KEY"},"neo_reference_id":"3727663","name":"(2015 RY83)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3727663","absolute_magnitude_h":24.2,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0384197891,"estimated_diameter_max":0.0859092601},"meters":{"estimated_diameter_min":38.4197891064,"estimated_diameter_max":85.9092601232},"miles":{"estimated_diameter_min":0.0238729428,"estimated_diameter_max":0.0533815229},"feet":{"estimated_diameter_min":126.0491808919,"estimated_diameter_max":281.8545369825}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-07","epoch_date_close_approach":1441609200000,"relative_velocity":{"kilometers_per_second":"6.9784590071","kilometers_per_hour":"25122.4524256356","miles_per_hour":"15610.114953029"},"miss_distance":{"astronomical":"0.0764733268","lunar":"29.7481231689","kilometers":"11440247","miles":"7108640"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/2440012?api_key=DEMO_KEY"},"neo_reference_id":"2440012","name":"440012 (2002 LE27)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2440012","absolute_magnitude_h":19.3,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.3669061375,"estimated_diameter_max":0.8204270649},"meters":{"estimated_diameter_min":366.9061375314,"estimated_diameter_max":820.4270648822},"miles":{"estimated_diameter_min":0.2279848336,"estimated_diameter_max":0.5097895857},"feet":{"estimated_diameter_min":1203.7603322587,"estimated_diameter_max":2691.6899315481}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-07","epoch_date_close_approach":1441609200000,"relative_velocity":{"kilometers_per_second":"1.1630925075","kilometers_per_hour":"4187.1330269455","miles_per_hour":"2601.7216299929"},"miss_distance":{"astronomical":"0.4981688399","lunar":"193.7876739502","kilometers":"74525000","miles":"46307684"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3713989?api_key=DEMO_KEY"},"neo_reference_id":"3713989","name":"(2015 FC35)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3713989","absolute_magnitude_h":21.9,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.1108038821,"estimated_diameter_max":0.2477650126},"meters":{"estimated_diameter_min":110.8038821264,"estimated_diameter_max":247.7650126055},"miles":{"estimated_diameter_min":0.068850319,"estimated_diameter_max":0.1539539936},"feet":{"estimated_diameter_min":363.5298086356,"estimated_diameter_max":812.8773639568}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-07","epoch_date_close_approach":1441609200000,"relative_velocity":{"kilometers_per_second":"8.7635508921","kilometers_per_hour":"31548.7832116855","miles_per_hour":"19603.1869906165"},"miss_distance":{"astronomical":"0.3213755752","lunar":"125.0150985718","kilometers":"48077104","miles":"29873726"},"orbiting_body":"Earth"}],"orbital_data":null},{"links":{"self":"https://api.nasa.gov/neo/rest/v1/neo/3727179?api_key=DEMO_KEY"},"neo_reference_id":"3727179","name":"(2015 RH36)","nasa_jpl_url":"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3727179","absolute_magnitude_h":23.6,"estimated_diameter":{"kilometers":{"estimated_diameter_min":0.0506471459,"estimated_diameter_max":0.1132504611},"meters":{"estimated_diameter_min":50.6471458835,"estimated_diameter_max":113.2504610618},"miles":{"estimated_diameter_min":0.0314706677,"estimated_diameter_max":0.0703705522},"feet":{"estimated_diameter_min":166.1651821003,"estimated_diameter_max":371.5566426699}},"is_potentially_hazardous_asteroid":false,"close_approach_data":[{"close_approach_date":"2015-09-07","epoch_date_close_approach":1441609200000,"relative_velocity":{"kilometers_per_second":"7.2717237532","kilometers_per_hour":"26178.2055116873","miles_per_hour":"16266.118863637"},"miss_distance":{"astronomical":"0.1093373919","lunar":"42.532245636","kilometers":"16356641","miles":"10163545"},"orbiting_body":"Earth"}],"orbital_data":null}]}
     */

    @com.google.gson.annotations.SerializedName("element_count")
    private int elementCount;
    @com.google.gson.annotations.SerializedName("near_earth_objects")
    private Map<String, List<NearEarthObjectsEntity>> nearEarthObjects;

    public LinksEntity getLinks() {
        return links;
    }

    public void setLinks(LinksEntity links) {
        this.links = links;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public Map<String, List<NearEarthObjectsEntity>> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(Map<String, List<NearEarthObjectsEntity>> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }


    public static class LinksEntity {
        @com.google.gson.annotations.SerializedName("next")
        private String next;
        @com.google.gson.annotations.SerializedName("prev")
        private String prev;
        @com.google.gson.annotations.SerializedName("self")
        private String self;

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }
    }

    public static class NearEarthObjectsEntity {
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
}
