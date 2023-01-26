package com.sebastianttr.dinamico.models

import com.sebastianttr.dinamico.R

val listOfCars =
    listOf<VehicleModel>(
    VehicleModel(
        0,
        "Ferrari",
        "360",
        R.drawable.ferrari_360,
        R.drawable.f360_own,
        R.drawable.f360_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "1999 – 2005 (Modena - 8800)\n" +
                                "2000 – 2005 (Spider - 7565)"
                    ),
                    VehicleStat(
                        "Model Years",
                        "2000-2005"
                    )
                )
            ),
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car(s)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2 door berlinetta " +
                                "2 door spider"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid engine, rear wheel drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3.6l V8 - 395 hp / 373 Nm"
                    ),
                    VehicleStat(
                        "Transmission",
                        "6 speed manual"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "LaFerrari, project name F150 is a limited production mid-engine mild hybrid sports car built by Italian automotive manufacturer Ferrari. LaFerrari means \"The Ferrari\" in Italian and some other Romance languages, in the sense that it is the \"definitive\" Ferrari."
            ),
            VehicleDescription(
                "Design",
                "Nine conceptual design studies were considered for the V12 hybrid flagship in 2011, reduced to five in April 2011 (three by Ferrari Centro Stile and two by Pininfarina). Of these, two full-size concepts were built: LaFerrari Concept Manta (internal designation: 2011 Model 2) and LaFerrari Concept Tensostruttura (internal designation 2011 Model 3). These were unveiled at the Ferrari Museum in Maranello, Italy and Ferrari World in Abu Dhabi. The final design of LaFerrari is similar to the Manta concept (Model 2). The Ferrari Centro Stile cars designed after LaFerrari have design elements reminiscent of the Tensostruttura concept (Model 3), e.g. the SF90 Stradale.\n"
            ),
            VehicleDescription(
                "Variants",
                "LaFerrari is based on findings from testing of the FXX development prototype and on research being conducted by the Millechili Project at the University of Modena. Association with the Millechili Project led to speculation during development that the car would weigh under 1,000 kg (2,205 lb), but a dry weight of around 1,255 kg (2,767 lb) was claimed. Only 499 units were produced, and each cost more than 1 million Euros. The car was unveiled at the 2013 Geneva Auto Show, followed by Auto Shanghai 2013, 2013 Tour Auto Optic 2000, 2013 Supercar Chronicle, Italian Chamber of Commerce in Japan."
            ),
            VehicleDescription(
                "Specifications",
                "LaFerrari is the first full hybrid produced by the Italian automotive marque, providing the highest power output of any Ferrari road car whilst decreasing fuel consumption by 40 percent. LaFerrari's internal combustion petrol engine is a longitudinally rear mid-mounted Ferrari F140 direct fuel injected 65° V12 engine with a displacement of 6,262 cc (6.3 L) generating a maximum power output of 800 PS (588 kW; 789 hp) at 9,000 rpm and 700 N⋅m (516 lb⋅ft) of torque at 6,750 rpm, supplemented by a 163 PS (120 kW; 161 hp) KERS unit (called HY-KERS), which provides short bursts of extra power. The KERS system adds extra power to the combustion engine's power output level for a total of 963 PS (708 kW; 950 hp) and a combined torque of 900 N⋅m (664 lb⋅ft). Ferrari claims CO2 emissions of 330 g/km. The engine's bore X stroke is 94 mm × 75.2 mm (3.70 in × 2.96 in) with a compression ratio of 13.5:1 and a specific power output of 94 kW (128 PS) per liter. It is mated to a 7-speed dual-clutch transmission."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was the LaFerrari released?", listOf("2012","2018","2013","2010"),3),
            VehicleQuiz(1,"What are the the variants that existed", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
            VehicleQuiz(2,"What was the max power output of the car?", listOf("950hp","900hp","650hp","1000hp"),1),
            VehicleQuiz(3,"The LaFerrari had a Top Speed of ___ km/h.", listOf("312","389","297","352"),4)
        )
    ),
    VehicleModel(
        1,
        "Ferrari",
        "SF90",
        R.drawable.ferrari_sf90,
        R.drawable.sf90_own,
        R.drawable.sf90_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "1999 – 2005 (Modena - 8800)\n" +
                                "2000 – 2005 (Spider - 7565)"
                    ),
                    VehicleStat(
                        "Model Years",
                        "2000-2005"
                    )
                )
            ),
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car(s)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2 door berlinetta " +
                                "2 door spider"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid engine, rear wheel drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3.6l V8 - 395 hp / 373 Nm"
                    ),
                    VehicleStat(
                        "Transmission",
                        "6 speed manual"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "LaFerrari, project name F150 is a limited production mid-engine mild hybrid sports car built by Italian automotive manufacturer Ferrari. LaFerrari means \"The Ferrari\" in Italian and some other Romance languages, in the sense that it is the \"definitive\" Ferrari."
            ),
            VehicleDescription(
                "Design",
                "Nine conceptual design studies were considered for the V12 hybrid flagship in 2011, reduced to five in April 2011 (three by Ferrari Centro Stile and two by Pininfarina). Of these, two full-size concepts were built: LaFerrari Concept Manta (internal designation: 2011 Model 2) and LaFerrari Concept Tensostruttura (internal designation 2011 Model 3). These were unveiled at the Ferrari Museum in Maranello, Italy and Ferrari World in Abu Dhabi. The final design of LaFerrari is similar to the Manta concept (Model 2). The Ferrari Centro Stile cars designed after LaFerrari have design elements reminiscent of the Tensostruttura concept (Model 3), e.g. the SF90 Stradale.\n"
            ),
            VehicleDescription(
                "Variants",
                "LaFerrari is based on findings from testing of the FXX development prototype and on research being conducted by the Millechili Project at the University of Modena. Association with the Millechili Project led to speculation during development that the car would weigh under 1,000 kg (2,205 lb), but a dry weight of around 1,255 kg (2,767 lb) was claimed. Only 499 units were produced, and each cost more than 1 million Euros. The car was unveiled at the 2013 Geneva Auto Show, followed by Auto Shanghai 2013, 2013 Tour Auto Optic 2000, 2013 Supercar Chronicle, Italian Chamber of Commerce in Japan."
            ),
            VehicleDescription(
                "Specifications",
                "LaFerrari is the first full hybrid produced by the Italian automotive marque, providing the highest power output of any Ferrari road car whilst decreasing fuel consumption by 40 percent. LaFerrari's internal combustion petrol engine is a longitudinally rear mid-mounted Ferrari F140 direct fuel injected 65° V12 engine with a displacement of 6,262 cc (6.3 L) generating a maximum power output of 800 PS (588 kW; 789 hp) at 9,000 rpm and 700 N⋅m (516 lb⋅ft) of torque at 6,750 rpm, supplemented by a 163 PS (120 kW; 161 hp) KERS unit (called HY-KERS), which provides short bursts of extra power. The KERS system adds extra power to the combustion engine's power output level for a total of 963 PS (708 kW; 950 hp) and a combined torque of 900 N⋅m (664 lb⋅ft). Ferrari claims CO2 emissions of 330 g/km. The engine's bore X stroke is 94 mm × 75.2 mm (3.70 in × 2.96 in) with a compression ratio of 13.5:1 and a specific power output of 94 kW (128 PS) per liter. It is mated to a 7-speed dual-clutch transmission."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was the LaFerrari released?", listOf("2012","2018","2013","2010"),3),
            VehicleQuiz(1,"What are the the variants that existed", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
            VehicleQuiz(2,"What was the max power output of the car?", listOf("950hp","900hp","650hp","1000hp"),1),
            VehicleQuiz(3,"The LaFerrari had a Top Speed of ___ km/h.", listOf("312","389","297","352"),4)
        )
    ),
    VehicleModel(
        2,
        "Ferrari",
        "296 GTB",
        R.drawable.ferrari_296gtb,
        R.drawable.f296_own,
        R.drawable.f296gtb_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "1999 – 2005 (Modena - 8800)\n" +
                                "2000 – 2005 (Spider - 7565)"
                    ),
                    VehicleStat(
                        "Model Years",
                        "2000-2005"
                    )
                )
            ),
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car(s)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2 door berlinetta " +
                                "2 door spider"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid engine, rear wheel drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3.6l V8 - 395 hp / 373 Nm"
                    ),
                    VehicleStat(
                        "Transmission",
                        "6 speed manual"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "LaFerrari, project name F150 is a limited production mid-engine mild hybrid sports car built by Italian automotive manufacturer Ferrari. LaFerrari means \"The Ferrari\" in Italian and some other Romance languages, in the sense that it is the \"definitive\" Ferrari."
            ),
            VehicleDescription(
                "Design",
                "Nine conceptual design studies were considered for the V12 hybrid flagship in 2011, reduced to five in April 2011 (three by Ferrari Centro Stile and two by Pininfarina). Of these, two full-size concepts were built: LaFerrari Concept Manta (internal designation: 2011 Model 2) and LaFerrari Concept Tensostruttura (internal designation 2011 Model 3). These were unveiled at the Ferrari Museum in Maranello, Italy and Ferrari World in Abu Dhabi. The final design of LaFerrari is similar to the Manta concept (Model 2). The Ferrari Centro Stile cars designed after LaFerrari have design elements reminiscent of the Tensostruttura concept (Model 3), e.g. the SF90 Stradale.\n"
            ),
            VehicleDescription(
                "Variants",
                "LaFerrari is based on findings from testing of the FXX development prototype and on research being conducted by the Millechili Project at the University of Modena. Association with the Millechili Project led to speculation during development that the car would weigh under 1,000 kg (2,205 lb), but a dry weight of around 1,255 kg (2,767 lb) was claimed. Only 499 units were produced, and each cost more than 1 million Euros. The car was unveiled at the 2013 Geneva Auto Show, followed by Auto Shanghai 2013, 2013 Tour Auto Optic 2000, 2013 Supercar Chronicle, Italian Chamber of Commerce in Japan."
            ),
            VehicleDescription(
                "Specifications",
                "LaFerrari is the first full hybrid produced by the Italian automotive marque, providing the highest power output of any Ferrari road car whilst decreasing fuel consumption by 40 percent. LaFerrari's internal combustion petrol engine is a longitudinally rear mid-mounted Ferrari F140 direct fuel injected 65° V12 engine with a displacement of 6,262 cc (6.3 L) generating a maximum power output of 800 PS (588 kW; 789 hp) at 9,000 rpm and 700 N⋅m (516 lb⋅ft) of torque at 6,750 rpm, supplemented by a 163 PS (120 kW; 161 hp) KERS unit (called HY-KERS), which provides short bursts of extra power. The KERS system adds extra power to the combustion engine's power output level for a total of 963 PS (708 kW; 950 hp) and a combined torque of 900 N⋅m (664 lb⋅ft). Ferrari claims CO2 emissions of 330 g/km. The engine's bore X stroke is 94 mm × 75.2 mm (3.70 in × 2.96 in) with a compression ratio of 13.5:1 and a specific power output of 94 kW (128 PS) per liter. It is mated to a 7-speed dual-clutch transmission."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was the LaFerrari released?", listOf("2012","2018","2013","2010"),3),
            VehicleQuiz(1,"What are the the variants that existed", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
            VehicleQuiz(2,"What was the max power output of the car?", listOf("950hp","900hp","650hp","1000hp"),1),
            VehicleQuiz(3,"The LaFerrari had a Top Speed of ___ km/h.", listOf("312","389","297","352"),4)
        )
    ),
    VehicleModel(
        3,
        "Ferrari",
        "F40",
        R.drawable.ferrari_f40,
        R.drawable.f40_own,
        R.drawable.f40_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "1999 – 2005 (Modena - 8800)\n" +
                                "2000 – 2005 (Spider - 7565)"
                    ),
                    VehicleStat(
                        "Model Years",
                        "2000-2005"
                    )
                )
            ),
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car(s)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2 door berlinetta " +
                                "2 door spider"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid engine, rear wheel drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3.6l V8 - 395 hp / 373 Nm"
                    ),
                    VehicleStat(
                        "Transmission",
                        "6 speed manual"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "LaFerrari, project name F150 is a limited production mid-engine mild hybrid sports car built by Italian automotive manufacturer Ferrari. LaFerrari means \"The Ferrari\" in Italian and some other Romance languages, in the sense that it is the \"definitive\" Ferrari."
            ),
            VehicleDescription(
                "Design",
                "Nine conceptual design studies were considered for the V12 hybrid flagship in 2011, reduced to five in April 2011 (three by Ferrari Centro Stile and two by Pininfarina). Of these, two full-size concepts were built: LaFerrari Concept Manta (internal designation: 2011 Model 2) and LaFerrari Concept Tensostruttura (internal designation 2011 Model 3). These were unveiled at the Ferrari Museum in Maranello, Italy and Ferrari World in Abu Dhabi. The final design of LaFerrari is similar to the Manta concept (Model 2). The Ferrari Centro Stile cars designed after LaFerrari have design elements reminiscent of the Tensostruttura concept (Model 3), e.g. the SF90 Stradale.\n"
            ),
            VehicleDescription(
                "Variants",
                "LaFerrari is based on findings from testing of the FXX development prototype and on research being conducted by the Millechili Project at the University of Modena. Association with the Millechili Project led to speculation during development that the car would weigh under 1,000 kg (2,205 lb), but a dry weight of around 1,255 kg (2,767 lb) was claimed. Only 499 units were produced, and each cost more than 1 million Euros. The car was unveiled at the 2013 Geneva Auto Show, followed by Auto Shanghai 2013, 2013 Tour Auto Optic 2000, 2013 Supercar Chronicle, Italian Chamber of Commerce in Japan."
            ),
            VehicleDescription(
                "Specifications",
                "LaFerrari is the first full hybrid produced by the Italian automotive marque, providing the highest power output of any Ferrari road car whilst decreasing fuel consumption by 40 percent. LaFerrari's internal combustion petrol engine is a longitudinally rear mid-mounted Ferrari F140 direct fuel injected 65° V12 engine with a displacement of 6,262 cc (6.3 L) generating a maximum power output of 800 PS (588 kW; 789 hp) at 9,000 rpm and 700 N⋅m (516 lb⋅ft) of torque at 6,750 rpm, supplemented by a 163 PS (120 kW; 161 hp) KERS unit (called HY-KERS), which provides short bursts of extra power. The KERS system adds extra power to the combustion engine's power output level for a total of 963 PS (708 kW; 950 hp) and a combined torque of 900 N⋅m (664 lb⋅ft). Ferrari claims CO2 emissions of 330 g/km. The engine's bore X stroke is 94 mm × 75.2 mm (3.70 in × 2.96 in) with a compression ratio of 13.5:1 and a specific power output of 94 kW (128 PS) per liter. It is mated to a 7-speed dual-clutch transmission."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was the LaFerrari released?", listOf("2012","2018","2013","2010"),3),
            VehicleQuiz(1,"What are the the variants that existed", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
            VehicleQuiz(2,"What was the max power output of the car?", listOf("950hp","900hp","650hp","1000hp"),1),
            VehicleQuiz(3,"The LaFerrari had a Top Speed of ___ km/h.", listOf("312","389","297","352"),4)
        )
    ),
    VehicleModel(
        4,
        "Ferrari",
        "F8 Tributo",
        R.drawable.ferrari_f8_tributo,
        R.drawable.f8_own,
        R.drawable.f8_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "1999 – 2005 (Modena - 8800)\n" +
                                "2000 – 2005 (Spider - 7565)"
                    ),
                    VehicleStat(
                        "Model Years",
                        "2000-2005"
                    )
                )
            ),
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car(s)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2 door berlinetta " +
                                "2 door spider"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid engine, rear wheel drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3.6l V8 - 395 hp / 373 Nm"
                    ),
                    VehicleStat(
                        "Transmission",
                        "6 speed manual"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "LaFerrari, project name F150 is a limited production mid-engine mild hybrid sports car built by Italian automotive manufacturer Ferrari. LaFerrari means \"The Ferrari\" in Italian and some other Romance languages, in the sense that it is the \"definitive\" Ferrari."
            ),
            VehicleDescription(
                "Design",
                "Nine conceptual design studies were considered for the V12 hybrid flagship in 2011, reduced to five in April 2011 (three by Ferrari Centro Stile and two by Pininfarina). Of these, two full-size concepts were built: LaFerrari Concept Manta (internal designation: 2011 Model 2) and LaFerrari Concept Tensostruttura (internal designation 2011 Model 3). These were unveiled at the Ferrari Museum in Maranello, Italy and Ferrari World in Abu Dhabi. The final design of LaFerrari is similar to the Manta concept (Model 2). The Ferrari Centro Stile cars designed after LaFerrari have design elements reminiscent of the Tensostruttura concept (Model 3), e.g. the SF90 Stradale.\n"
            ),
            VehicleDescription(
                "Variants",
                "LaFerrari is based on findings from testing of the FXX development prototype and on research being conducted by the Millechili Project at the University of Modena. Association with the Millechili Project led to speculation during development that the car would weigh under 1,000 kg (2,205 lb), but a dry weight of around 1,255 kg (2,767 lb) was claimed. Only 499 units were produced, and each cost more than 1 million Euros. The car was unveiled at the 2013 Geneva Auto Show, followed by Auto Shanghai 2013, 2013 Tour Auto Optic 2000, 2013 Supercar Chronicle, Italian Chamber of Commerce in Japan."
            ),
            VehicleDescription(
                "Specifications",
                "LaFerrari is the first full hybrid produced by the Italian automotive marque, providing the highest power output of any Ferrari road car whilst decreasing fuel consumption by 40 percent. LaFerrari's internal combustion petrol engine is a longitudinally rear mid-mounted Ferrari F140 direct fuel injected 65° V12 engine with a displacement of 6,262 cc (6.3 L) generating a maximum power output of 800 PS (588 kW; 789 hp) at 9,000 rpm and 700 N⋅m (516 lb⋅ft) of torque at 6,750 rpm, supplemented by a 163 PS (120 kW; 161 hp) KERS unit (called HY-KERS), which provides short bursts of extra power. The KERS system adds extra power to the combustion engine's power output level for a total of 963 PS (708 kW; 950 hp) and a combined torque of 900 N⋅m (664 lb⋅ft). Ferrari claims CO2 emissions of 330 g/km. The engine's bore X stroke is 94 mm × 75.2 mm (3.70 in × 2.96 in) with a compression ratio of 13.5:1 and a specific power output of 94 kW (128 PS) per liter. It is mated to a 7-speed dual-clutch transmission."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was the LaFerrari released?", listOf("2012","2018","2013","2010"),3),
            VehicleQuiz(1,"What are the the variants that existed", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
            VehicleQuiz(2,"What was the max power output of the car?", listOf("950hp","900hp","650hp","1000hp"),1),
            VehicleQuiz(3,"The LaFerrari had a Top Speed of ___ km/h.", listOf("312","389","297","352"),4)
        )
    ),
)
