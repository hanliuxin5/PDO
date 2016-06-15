package com.pdc.lychee.planetdefenseoffice.z_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.pdc.lychee.planetdefenseoffice.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @Bind(R.id.test_tc)
    TextView testTc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);
        ButterKnife.bind(this);
        testTc.setText(R.string.string_test);
        String jsonStr = "{\n" +
                "\n" +
                "    \"links\": {\n" +
                "        \"next\": \"https://api.nasa.gov/neo/rest/v1/feed?start_date=2014-05-31&end_date=2014-06-02&api_key=DEMO_KEY\",\n" +
                "        \"prev\": \"https://api.nasa.gov/neo/rest/v1/feed?start_date=2014-05-27&end_date=2014-05-29&api_key=DEMO_KEY\",\n" +
                "        \"self\": \"https://api.nasa.gov/neo/rest/v1/feed?start_date=2014-05-29&end_date=2014-05-31&api_key=DEMO_KEY\"\n" +
                "    },\n" +
                "    \"element_count\": 20,\n" +
                "    \"near_earth_objects\": {\n" +
                "        \"2014-05-29\": [\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3673544?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3673544\",\n" +
                "                \"name\": \"(2014 LV14)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3673544\",\n" +
                "                \"absolute_magnitude_h\": 24.0,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0421264611,\n" +
                "                        \"estimated_diameter_max\": 0.0941976306\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 42.1264610556,\n" +
                "                        \"estimated_diameter_max\": 94.1976305719\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0261761612,\n" +
                "                        \"estimated_diameter_max\": 0.0585316759\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 138.2101784897,\n" +
                "                        \"estimated_diameter_max\": 309.0473542854\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"5.5765971619\",\n" +
                "                            \"kilometers_per_hour\": \"20075.7497826976\",\n" +
                "                            \"miles_per_hour\": \"12474.2901913656\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.1578284902\",\n" +
                "                            \"lunar\": \"61.3952827454\",\n" +
                "                            \"kilometers\": \"23610806\",\n" +
                "                            \"miles\": \"14671075\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3738917?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3738917\",\n" +
                "                \"name\": \"(2015 YH1)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3738917\",\n" +
                "                \"absolute_magnitude_h\": 25.2,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0242412481,\n" +
                "                        \"estimated_diameter_max\": 0.0542050786\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 24.2412481101,\n" +
                "                        \"estimated_diameter_max\": 54.2050786336\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0150628086,\n" +
                "                        \"estimated_diameter_max\": 0.0336814639\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 79.5316564495,\n" +
                "                        \"estimated_diameter_max\": 177.8381901842\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"22.4149365199\",\n" +
                "                            \"kilometers_per_hour\": \"80693.7714716022\",\n" +
                "                            \"miles_per_hour\": \"50139.9715013408\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.3809903178\",\n" +
                "                            \"lunar\": \"148.2052307129\",\n" +
                "                            \"kilometers\": \"56995344\",\n" +
                "                            \"miles\": \"35415264\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/2190166?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"2190166\",\n" +
                "                \"name\": \"190166 (2005 UP156)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2190166\",\n" +
                "                \"absolute_magnitude_h\": 17.1,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 1.0105434154,\n" +
                "                        \"estimated_diameter_max\": 2.2596437711\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 1010.5434154201,\n" +
                "                        \"estimated_diameter_max\": 2259.643771094\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.6279223726,\n" +
                "                        \"estimated_diameter_max\": 1.4040771097\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 3315.4312590467,\n" +
                "                        \"estimated_diameter_max\": 7413.5296699562\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"16.4106240166\",\n" +
                "                            \"kilometers_per_hour\": \"59078.2464596851\",\n" +
                "                            \"miles_per_hour\": \"36708.924862686\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.4686875876\",\n" +
                "                            \"lunar\": \"182.3194732666\",\n" +
                "                            \"kilometers\": \"70114664\",\n" +
                "                            \"miles\": \"43567232\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/2365014?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"2365014\",\n" +
                "                \"name\": \"365014 (2008 OX2)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2365014\",\n" +
                "                \"absolute_magnitude_h\": 20.2,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.2424124811,\n" +
                "                        \"estimated_diameter_max\": 0.5420507863\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 242.4124811008,\n" +
                "                        \"estimated_diameter_max\": 542.0507863358\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.1506280858,\n" +
                "                        \"estimated_diameter_max\": 0.3368146392\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 795.3165644948,\n" +
                "                        \"estimated_diameter_max\": 1778.3819018419\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"27.58922188\",\n" +
                "                            \"kilometers_per_hour\": \"99321.198768108\",\n" +
                "                            \"miles_per_hour\": \"61714.3304234391\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.2916541541\",\n" +
                "                            \"lunar\": \"113.4534606934\",\n" +
                "                            \"kilometers\": \"43630840\",\n" +
                "                            \"miles\": \"27110946\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3655745?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3655745\",\n" +
                "                \"name\": \"(2014 AD16)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3655745\",\n" +
                "                \"absolute_magnitude_h\": 27.4,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0088014652,\n" +
                "                        \"estimated_diameter_max\": 0.0196806745\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 8.801465209,\n" +
                "                        \"estimated_diameter_max\": 19.6806745089\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0054689752,\n" +
                "                        \"estimated_diameter_max\": 0.0122290004\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 28.8761991163,\n" +
                "                        \"estimated_diameter_max\": 64.5691441559\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"4.613164079\",\n" +
                "                            \"kilometers_per_hour\": \"16607.3906843269\",\n" +
                "                            \"miles_per_hour\": \"10319.1867282697\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.4137795999\",\n" +
                "                            \"lunar\": \"160.9602661133\",\n" +
                "                            \"kilometers\": \"61900544\",\n" +
                "                            \"miles\": \"38463216\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3672674?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3672674\",\n" +
                "                \"name\": \"(2014 KF46)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3672674\",\n" +
                "                \"absolute_magnitude_h\": 26.5,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0133215567,\n" +
                "                        \"estimated_diameter_max\": 0.0297879063\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 13.3215566698,\n" +
                "                        \"estimated_diameter_max\": 29.7879062798\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.008277629,\n" +
                "                        \"estimated_diameter_max\": 0.0185093411\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 43.7058959846,\n" +
                "                        \"estimated_diameter_max\": 97.7293544391\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"17.0748720925\",\n" +
                "                            \"kilometers_per_hour\": \"61469.539533157\",\n" +
                "                            \"miles_per_hour\": \"38194.7813838108\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.0040815761\",\n" +
                "                            \"lunar\": \"1.5877331495\",\n" +
                "                            \"kilometers\": \"610595.125\",\n" +
                "                            \"miles\": \"379406.21875\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3674830?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3674830\",\n" +
                "                \"name\": \"(2014 MS67)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3674830\",\n" +
                "                \"absolute_magnitude_h\": 21.2,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.1529519353,\n" +
                "                        \"estimated_diameter_max\": 0.3420109247\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 152.9519353442,\n" +
                "                        \"estimated_diameter_max\": 342.0109247198\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.095039897,\n" +
                "                        \"estimated_diameter_max\": 0.2125156703\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 501.8108275547,\n" +
                "                        \"estimated_diameter_max\": 1122.0831222578\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"12.8921532234\",\n" +
                "                            \"kilometers_per_hour\": \"46411.7516041748\",\n" +
                "                            \"miles_per_hour\": \"28838.457545383\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.343736539\",\n" +
                "                            \"lunar\": \"133.7135162354\",\n" +
                "                            \"kilometers\": \"51422252\",\n" +
                "                            \"miles\": \"31952306\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3738912?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3738912\",\n" +
                "                \"name\": \"(2015 YB1)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3738912\",\n" +
                "                \"absolute_magnitude_h\": 21.5,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.1332155667,\n" +
                "                        \"estimated_diameter_max\": 0.2978790628\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 133.2155666981,\n" +
                "                        \"estimated_diameter_max\": 297.8790627982\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0827762899,\n" +
                "                        \"estimated_diameter_max\": 0.1850934111\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 437.0589598459,\n" +
                "                        \"estimated_diameter_max\": 977.2935443908\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-29\",\n" +
                "                        \"epoch_date_close_approach\": 1401346800000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"18.7199270487\",\n" +
                "                            \"kilometers_per_hour\": \"67391.737375383\",\n" +
                "                            \"miles_per_hour\": \"41874.6048152762\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.3748108623\",\n" +
                "                            \"lunar\": \"145.8014373779\",\n" +
                "                            \"kilometers\": \"56070908\",\n" +
                "                            \"miles\": \"34840848\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            }\n" +
                "        ],\n" +
                "        \"2014-05-30\": [\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3655566?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3655566\",\n" +
                "                \"name\": \"(2013 YM70)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3655566\",\n" +
                "                \"absolute_magnitude_h\": 20.5,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.2111324448,\n" +
                "                        \"estimated_diameter_max\": 0.4721064988\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 211.1324447897,\n" +
                "                        \"estimated_diameter_max\": 472.1064988055\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.1311915784,\n" +
                "                        \"estimated_diameter_max\": 0.2933532873\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 692.6917701639,\n" +
                "                        \"estimated_diameter_max\": 1548.9058855411\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-30\",\n" +
                "                        \"epoch_date_close_approach\": 1401433200000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"9.0452135585\",\n" +
                "                            \"kilometers_per_hour\": \"32562.7688105178\",\n" +
                "                            \"miles_per_hour\": \"20233.2382089576\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.3692037114\",\n" +
                "                            \"lunar\": \"143.6202392578\",\n" +
                "                            \"kilometers\": \"55232092\",\n" +
                "                            \"miles\": \"34319628\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3656919?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3656919\",\n" +
                "                \"name\": \"(2014 BG3)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3656919\",\n" +
                "                \"absolute_magnitude_h\": 21.1,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.160160338,\n" +
                "                        \"estimated_diameter_max\": 0.358129403\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 160.1603379786,\n" +
                "                        \"estimated_diameter_max\": 358.1294030194\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0995189894,\n" +
                "                        \"estimated_diameter_max\": 0.2225312253\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 525.4604432536,\n" +
                "                        \"estimated_diameter_max\": 1174.9652706022\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-30\",\n" +
                "                        \"epoch_date_close_approach\": 1401433200000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"13.8474687793\",\n" +
                "                            \"kilometers_per_hour\": \"49850.8876055419\",\n" +
                "                            \"miles_per_hour\": \"30975.4029124546\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.3370765313\",\n" +
                "                            \"lunar\": \"131.1227722168\",\n" +
                "                            \"kilometers\": \"50425932\",\n" +
                "                            \"miles\": \"31333222\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3744695?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3744695\",\n" +
                "                \"name\": \"(2016 DJ)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3744695\",\n" +
                "                \"absolute_magnitude_h\": 25.6,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0201629919,\n" +
                "                        \"estimated_diameter_max\": 0.0450858206\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 20.1629919443,\n" +
                "                        \"estimated_diameter_max\": 45.0858206172\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0125286985,\n" +
                "                        \"estimated_diameter_max\": 0.0280150214\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 66.1515504905,\n" +
                "                        \"estimated_diameter_max\": 147.9193637137\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-30\",\n" +
                "                        \"epoch_date_close_approach\": 1401433200000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"4.2125132124\",\n" +
                "                            \"kilometers_per_hour\": \"15165.0475647348\",\n" +
                "                            \"miles_per_hour\": \"9422.9708048765\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.1873447715\",\n" +
                "                            \"lunar\": \"72.8771209717\",\n" +
                "                            \"kilometers\": \"28026380\",\n" +
                "                            \"miles\": \"17414784\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3753623?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3753623\",\n" +
                "                \"name\": \"(2016 LB)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3753623\",\n" +
                "                \"absolute_magnitude_h\": 22.763,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0744654771,\n" +
                "                        \"estimated_diameter_max\": 0.1665098689\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 74.4654771399,\n" +
                "                        \"estimated_diameter_max\": 166.5098688619\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.046270688,\n" +
                "                        \"estimated_diameter_max\": 0.1034644037\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 244.3093160198,\n" +
                "                        \"estimated_diameter_max\": 546.2922381568\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-30\",\n" +
                "                        \"epoch_date_close_approach\": 1401433200000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"16.1368170899\",\n" +
                "                            \"kilometers_per_hour\": \"58092.5415237106\",\n" +
                "                            \"miles_per_hour\": \"36096.4461484412\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.175847617\",\n" +
                "                            \"lunar\": \"68.4047241211\",\n" +
                "                            \"kilometers\": \"26306430\",\n" +
                "                            \"miles\": \"16346058\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            }\n" +
                "        ],\n" +
                "        \"2014-05-31\": [\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3673724?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3673724\",\n" +
                "                \"name\": \"(2014 LF25)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3673724\",\n" +
                "                \"absolute_magnitude_h\": 24.1,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.040230458,\n" +
                "                        \"estimated_diameter_max\": 0.0899580388\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 40.2304579834,\n" +
                "                        \"estimated_diameter_max\": 89.9580388169\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0249980399,\n" +
                "                        \"estimated_diameter_max\": 0.0558973165\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 131.9896957704,\n" +
                "                        \"estimated_diameter_max\": 295.1379320721\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"11.6756156092\",\n" +
                "                            \"kilometers_per_hour\": \"42032.2161930026\",\n" +
                "                            \"miles_per_hour\": \"26117.1845561466\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.037846198\",\n" +
                "                            \"lunar\": \"14.7221708298\",\n" +
                "                            \"kilometers\": \"5661710.5\",\n" +
                "                            \"miles\": \"3518023.75\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/2162181?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"2162181\",\n" +
                "                \"name\": \"162181 (1999 LF6)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2162181\",\n" +
                "                \"absolute_magnitude_h\": 18.2,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.6089126221,\n" +
                "                        \"estimated_diameter_max\": 1.3615700154\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 608.9126221057,\n" +
                "                        \"estimated_diameter_max\": 1361.5700153859\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.3783606449,\n" +
                "                        \"estimated_diameter_max\": 0.846040122\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 1997.7448871092,\n" +
                "                        \"estimated_diameter_max\": 4467.0933692788\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"9.3102885172\",\n" +
                "                            \"kilometers_per_hour\": \"33517.0386617886\",\n" +
                "                            \"miles_per_hour\": \"20826.1843840431\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.4596706672\",\n" +
                "                            \"lunar\": \"178.8118896484\",\n" +
                "                            \"kilometers\": \"68765752\",\n" +
                "                            \"miles\": \"42729056\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3170237?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3170237\",\n" +
                "                \"name\": \"(2003 YH111)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3170237\",\n" +
                "                \"absolute_magnitude_h\": 24.5,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0334622374,\n" +
                "                        \"estimated_diameter_max\": 0.0748238376\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 33.4622374455,\n" +
                "                        \"estimated_diameter_max\": 74.8238376074\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0207924639,\n" +
                "                        \"estimated_diameter_max\": 0.0464933628\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 109.7842471007,\n" +
                "                        \"estimated_diameter_max\": 245.4850393757\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"10.8290545594\",\n" +
                "                            \"kilometers_per_hour\": \"38984.5964140092\",\n" +
                "                            \"miles_per_hour\": \"24223.512144027\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.1060276605\",\n" +
                "                            \"lunar\": \"41.2447624207\",\n" +
                "                            \"kilometers\": \"15861513\",\n" +
                "                            \"miles\": \"9855887\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3519453?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3519453\",\n" +
                "                \"name\": \"(2010 JA)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3519453\",\n" +
                "                \"absolute_magnitude_h\": 27.0,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0105816886,\n" +
                "                        \"estimated_diameter_max\": 0.023661375\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 10.5816885933,\n" +
                "                        \"estimated_diameter_max\": 23.6613750114\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0065751544,\n" +
                "                        \"estimated_diameter_max\": 0.0147024923\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 34.7168272045,\n" +
                "                        \"estimated_diameter_max\": 77.6291855923\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"6.1171108654\",\n" +
                "                            \"kilometers_per_hour\": \"22021.5991156158\",\n" +
                "                            \"miles_per_hour\": \"13683.3652949225\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.1076350632\",\n" +
                "                            \"lunar\": \"41.8700408936\",\n" +
                "                            \"kilometers\": \"16101977\",\n" +
                "                            \"miles\": \"10005305\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3647027?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3647027\",\n" +
                "                \"name\": \"(2013 RE6)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3647027\",\n" +
                "                \"absolute_magnitude_h\": 21.4,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.1394938229,\n" +
                "                        \"estimated_diameter_max\": 0.3119176705\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 139.4938229344,\n" +
                "                        \"estimated_diameter_max\": 311.9176705226\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0866774163,\n" +
                "                        \"estimated_diameter_max\": 0.1938165949\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 457.6569140361,\n" +
                "                        \"estimated_diameter_max\": 1023.3519701574\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"7.9048102242\",\n" +
                "                            \"kilometers_per_hour\": \"28457.3168071999\",\n" +
                "                            \"miles_per_hour\": \"17682.2699905626\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.167272326\",\n" +
                "                            \"lunar\": \"65.068939209\",\n" +
                "                            \"kilometers\": \"25023584\",\n" +
                "                            \"miles\": \"15548935\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3669017?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3669017\",\n" +
                "                \"name\": \"(2014 HG4)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3669017\",\n" +
                "                \"absolute_magnitude_h\": 19.8,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.2914439045,\n" +
                "                        \"estimated_diameter_max\": 0.6516883822\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 291.4439045349,\n" +
                "                        \"estimated_diameter_max\": 651.6883821679\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.1810947904,\n" +
                "                        \"estimated_diameter_max\": 0.4049402617\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 956.1808197541,\n" +
                "                        \"estimated_diameter_max\": 2138.0853117517\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"17.4611281026\",\n" +
                "                            \"kilometers_per_hour\": \"62860.0611693326\",\n" +
                "                            \"miles_per_hour\": \"39058.7974526889\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.2188133573\",\n" +
                "                            \"lunar\": \"85.1184005737\",\n" +
                "                            \"kilometers\": \"32734012\",\n" +
                "                            \"miles\": \"20339972\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3736245?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3736245\",\n" +
                "                \"name\": \"(2015 XX129)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3736245\",\n" +
                "                \"absolute_magnitude_h\": 26.6,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0127219879,\n" +
                "                        \"estimated_diameter_max\": 0.0284472297\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 12.7219878539,\n" +
                "                        \"estimated_diameter_max\": 28.4472296503\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0079050743,\n" +
                "                        \"estimated_diameter_max\": 0.0176762835\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 41.7388066307,\n" +
                "                        \"estimated_diameter_max\": 93.330808926\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"13.6941336768\",\n" +
                "                            \"kilometers_per_hour\": \"49298.8812364184\",\n" +
                "                            \"miles_per_hour\": \"30632.4076215957\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.4143552232\",\n" +
                "                            \"lunar\": \"161.184173584\",\n" +
                "                            \"kilometers\": \"61986660\",\n" +
                "                            \"miles\": \"38516724\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"links\": {\n" +
                "                    \"self\": \"https://api.nasa.gov/neo/rest/v1/neo/3752900?api_key=DEMO_KEY\"\n" +
                "                },\n" +
                "                \"neo_reference_id\": \"3752900\",\n" +
                "                \"name\": \"(2016 JJ12)\",\n" +
                "                \"nasa_jpl_url\": \"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3752900\",\n" +
                "                \"absolute_magnitude_h\": 25.727,\n" +
                "                \"estimated_diameter\": {\n" +
                "                    \"kilometers\": {\n" +
                "                        \"estimated_diameter_min\": 0.0190175679,\n" +
                "                        \"estimated_diameter_max\": 0.0425245747\n" +
                "                    },\n" +
                "                    \"meters\": {\n" +
                "                        \"estimated_diameter_min\": 19.0175679473,\n" +
                "                        \"estimated_diameter_max\": 42.5245746968\n" +
                "                    },\n" +
                "                    \"miles\": {\n" +
                "                        \"estimated_diameter_min\": 0.0118169652,\n" +
                "                        \"estimated_diameter_max\": 0.0264235375\n" +
                "                    },\n" +
                "                    \"feet\": {\n" +
                "                        \"estimated_diameter_min\": 62.3935976241,\n" +
                "                        \"estimated_diameter_max\": 139.5163256482\n" +
                "                    }\n" +
                "                },\n" +
                "                \"is_potentially_hazardous_asteroid\": false,\n" +
                "                \"close_approach_data\": [\n" +
                "                    {\n" +
                "                        \"close_approach_date\": \"2014-05-31\",\n" +
                "                        \"epoch_date_close_approach\": 1401519600000,\n" +
                "                        \"relative_velocity\": {\n" +
                "                            \"kilometers_per_second\": \"12.2090626536\",\n" +
                "                            \"kilometers_per_hour\": \"43952.6255528995\",\n" +
                "                            \"miles_per_hour\": \"27310.4522498003\"\n" +
                "                        },\n" +
                "                        \"miss_distance\": {\n" +
                "                            \"astronomical\": \"0.3190660585\",\n" +
                "                            \"lunar\": \"124.1166915894\",\n" +
                "                            \"kilometers\": \"47731600\",\n" +
                "                            \"miles\": \"29659042\"\n" +
                "                        },\n" +
                "                        \"orbiting_body\": \"Earth\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"orbital_data\": null\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "\n" +
                "}";
        Gson gson = new Gson();
        TestBean testBean = gson.fromJson(jsonStr, TestBean.class);
        Log.i("lychee", testBean.getNearEarthObjects().get("2014-05-29").get(0).getNeoReferenceId());
    }
}
