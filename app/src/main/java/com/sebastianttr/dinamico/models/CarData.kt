package com.sebastianttr.dinamico.models

import com.sebastianttr.dinamico.R

val listOfCars =
    listOf<VehicleModel>(
    VehicleModel(
        0,
        "Ferrari",
        "360",
        R.drawable.ferrari_360,
        R.drawable.ferrari_360_own,
        R.drawable.ferrari_360_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "1999–2004\n" +
                                "8,800 (Modena)\n" +
                                "7,565 (Spider)\n" +
                                "1,288 (Challenge Stradale)"
                    ),
                    VehicleStat(
                        "Model Years",
                        "2000-2005"
                    )
                )
            ),
            VehicleInfo("Body",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car (S)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2-door berlinetta\n2-door spider"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid-engine\nRear-wheel drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3.6 L Tipo F131 V8"
                    ),
                    VehicleStat(
                        "Transmission",
                        "6 speed manual\n6-speed F1 Graziano automated manual"
                    )
                )
            ),
            VehicleInfo("Chronology",
                listOf(
                    VehicleStat(
                        "Predecessor",
                        "Ferrari F355"
                    ),
                    VehicleStat(
                        "Successor",
                        "Ferrari F430"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "Ferrari partnered with Alcoa to produce an entirely new all-aluminium space-frame chassis that was 40% stiffer than its predecessor's which had utilized steel. The design was 28% lighter despite a 10% increase in overall dimensions. Along with a lightweight frame the new Pininfarina body styling deviated from traditions of the previous decade's sharp angles and flip-up headlights. The new V8 engine utilises a 3.6-litre capacity, a flat-plane crankshaft, and titanium connecting rods. The engine generates a power output of 400 PS (294 kW; 395 hp). According to Ferrari, weight was reduced by 60 kg (130 lb) and the 0 to 100 km/h (62 mph) acceleration time improved from 4.7 to 4.5 seconds.\n" +
                        "\n" +
                        "The first model to be produced was the 360 Modena, followed later by the 360 Spider and a special edition, the Challenge Stradale. The Challenge Stradale was the high-performance road-legal version of the 360 produced by the factory, featuring carbon ceramic brakes (from the Enzo), track-tuned suspension, aerodynamic gains, weight reduction, power improvements and revised gearbox software among its track-focused brief. There were 8,800 Modenas and 7,565 Spiders produced worldwide. There were 4,199 built for the US market—1,810 Modenas (coupes) and 2,389 Spiders (convertibles). Of those numbers, there were only 469 Modenas and 670 Spiders that were produced with a gated 6-speed manual transmission as opposed to the \"F1\" single-clutch automated manual transmission."
            ),
            VehicleDescription(
                "Design",
                "In addition to this were the low-volume factory race cars and a one-off Barchetta variant. The race cars were all derived from the 360 Modena and for the first time produced as a separate model in their own right (compared to being a retrofit kit in previous years). While the Barchetta was based on the Spider variant. The first race car was the 360 Modena Challenge, used in a one-make series; the factory-built racing cars were prepared by the official tuner, Michelotto, who also developed the 360 N-GT. The N-GT was a 360 Challenge car evolved even further to compete in the FIA N-GT racing class alongside other marques such as Porsche."
            ),
            VehicleDescription(
                "Variants",
                "Modena\n" +
                        "\n" +
                        "The first model of the 360 to be produced was the Modena, named after the town of Modena, the birthplace of Enzo Ferrari. Transmission choice ranges from 6-speed manual transmission, or the electrohydraulic-actuated \"F1\" automated manual transmission with a gearbox built by Graziano Trasmissioni.\n" +
                        "The 360 Modena went into production in 1999 and remained in production until 2005 when it was replaced by the F430. The Modena was followed two years later by the 360 Spider, Ferrari's 20th road-going convertible which at launch overtook sales of the Modena. Other than weight, the Spider's specifications matched those of the Modena almost exactly.\n" +
                        "\n" +
                        "Spider\n" +
                        "\n" +
                        "The Ferrari 360 Spider was unveiled at the 2000 Geneva Motor Show.\n" +
                        "The 360 was designed with a convertible variant in mind; since removing the roof of a coupe reduces the torsional rigidity, the 360 was built for strength in other areas. Ferrari designers strengthened the sills, stiffened the front of the floorpan and redesigned the windscreen frame. The rear bulkhead had to be stiffened to cut out engine noise from the cabin. The convertible's necessary dynamic rigidity is provided by additional side reinforcements and a cross brace in front of the engine. Passenger safety is ensured by a strengthened windscreen frame and roll bars.\n" +
                        "The 360 Spider displays a curvilinear waistline. The fairings imply the start of a roof, and stable roll bars are embedded in these elevations. Due to use of light aluminium construction throughout, the Spider weighs in only 60 kg (130 lb) heavier than the coupé.\n" +
                        "\n" +
                        "Barchetta\n" +
                        "\n" +
                        "The Ferrari 360 Barchetta (serial number 120020) is a one-off based on the Ferrari 360 Spider which was commissioned by Gianni Agnelli in 2000 as a wedding present for the then Fiat chairman and president of Ferrari, Luca Cordero di Montezemolo. The car bears heavy resemblance to its donor with the only differences being the removal of the soft top system and roll bars, different engine cover and the addition of a visor in place of a windshield for better airflow over the car. Performance of the car remains the same as its donor and the car features Argento Nurburgring exterior paint with red pinstriping. The interior is black leather with cream fabric and features fabric seats with matching stitching, the words 360 Barchetta embroidered on the dashboard and a paddle-shift gearbox.\n" +
                        "\n" +
                        "Challenge Stradale\n" +
                        "\n" +
                        "Inspired by the 360 Modena Challenge racing car series, the Challenge Stradale is the track-focused iteration of the 360 Modena. The focus in development of the car was primarily on improving its track performance credentials by concentrating on handling, braking and weight reduction characteristics, which are essential in pure racing cars. Ferrari engineers designed the car from the outset with a goal of 20% track day use in mind and 80% road use. With only a small 25 PS (18 kW; 25 hp) improvement in engine power from the Modena (and boasting an improved power-to-weight ratio), the Challenge Stradale accelerates from 0 to 100 km/h (62 mph) in 4.1 seconds according to Ferrari. Systematic improvements were achieved to the setup and feel of the whole car; throttle response from the digital throttle was ratcheted up and feedback through the steering wheel was enhanced. Ceramic brakes borrowed from the Enzo, some lower weight parts and a FHP handling pack, enabled the Challenge Stradale to claim a 3.5 second improvement per lap of its Fiorano Circuit compared to the Modena.\n" +
                        "In total, the Challenge Stradale is up to 110 kg (240 lb) lighter than the standard Modena if all the lightweight options are specified such as deleted radio, lexan (plexiglass) door windows and Alcantara fabric (instead of the leather option). As much as 74 kg (163 lb) was saved by lightening the bumpers, stripping the interior of its sound deadening and carbon mirrors and making the optional Modena carbon seats standard. Resin Transfer Moulding was utilised for the bumpers and skirts, a carry over from the Challenge cars which resulted in lighter bumpers than those on the Modena. The engine and transmission weight was lightened by 11 kg (24 lb) through the use of a smaller, lighter weight sports exhaust back box and valved exit pipes. The Challenge Stradale also got Brembo carbon ceramic brakes as standard (which later became standard fitment on the F430) which shaved 16 kg (35 lb) off the curb weight and improved handling by reducing unsprung weight and completely eliminating brake fade. Cars fitted with the centre console stereo option, sub speaker box behind the seats and glass side windows re-gained approximately 30 kg (66 lb) over the best selected options."
            ),
            VehicleDescription(
                "Specifications",
                "The Ferrari 360 Modena is a two-seater coupe powered by a 3.6L V8 mid-engine that puts out 400 hp at 8,500 rpm and 275 lb-ft of torque at 4,750 rpm. That engine is paired with either a six-speed manual or F1 automated manual gearbox with paddle shifters, reaching a top speed of 183 mph. The 360 offers two different driving settings: Normal and Sport.\n" +
                        "\n" +
                        "The Normal setting focuses on stability in relation to the road conditions, reducing power to the wheels with the assistance of the engine management system or ABS braking to maximize traction.\n" +
                        "\n" +
                        "The Sport setting places greater emphasis on the driver’s input. The continuously adjusting dampers (CDC) monitor steering angle, road speed, braking, and acceleration in order to optimize the driving setting."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was this car model released?", listOf("2006","2002","1998","1999"),4),
            VehicleQuiz(1,"Which of these body styles existed for this model?", listOf("Berlinetta & Spider","Coupe & Spider","SUV","Coupe"),1),
            VehicleQuiz(2,"What was the power output of the car?", listOf("420hp","690hp","400hp","320hp"),3),
            VehicleQuiz(3,"What was the top speed (km/h) of this model? ", listOf("294","299","315","252"),1),
            VehicleQuiz(4,"Which engine did this model have?", listOf("6.3 L V12","4.0 L W8","3.6 L V8","2.4 L TFSI"),3),
            VehicleQuiz(5,"How many driving settings does this model offer?", listOf("1","2","3","0"),2)
        )
    ),
    VehicleModel(
        1,
        "Ferrari",
        "SF90 Stradale",
        R.drawable.ferrari_sf90,
        R.drawable.ferarri_sf90_own,
        R.drawable.ferrari_sf90_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "2019 - present"
                    )
                )
            ),
            VehicleInfo("Body",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car (S)"
                    ),
                    VehicleStat(
                        "Body",
                        "2-door berlinetta\n2-door hard-top convertible"
                    ),
                    VehicleStat(
                        "Layout",
                        "Mid-engine, all-wheel-drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "4L twin-turbocharged V8"
                    ),
                    VehicleStat(
                        "Electric motor",
                        "3 electric motors"
                    ),
                    VehicleStat(
                        "Power output",
                        "Engine: 780 PS (574 kW; 769 hp)\n" +
                                "Electric motors: 220 PS (162 kW; 217 hp)\n" +
                                "Combined: 1,000 PS (735 kW; 986 hp)"
                    ),
                    VehicleStat(
                        "Transmission",
                        "8-speed Magna 8DCL900 dual-clutch"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "The Ferrari SF90 Stradale (Type F173) is a mid-engine PHEV (Plug-in Hybrid Electric Vehicle) sports car produced by the Italian automobile manufacturer Ferrari. The car shares its name with the SF90 Formula One car with SF90 standing for the 90th anniversary of the Scuderia Ferrari racing team and \"Stradale\" meaning \"made for the road\"."
            ),
            VehicleDescription(
                "Design",
                "The manufacturer claims that the SF90 Stradale can generate 390 kg (860 lb) of downforce at 250 km/h (155 mph) due to new findings in aero and thermal dynamics.\n" +
                    "SF90 Stradale front end.\n" +
                    "\n" +
                    "The main feature of the design is the twin-part rear wing which is an application of the drag reduction system (DRS) used in Formula One. A fixed element in the wing incorporates the rear light, the mobile parts of the wing (called \"shut off Gurney\" by the manufacturer) integrate into the body by using electric actuators in order to maximise downforce. The SF90 Stradale uses an evolution of Ferrari's vortex generators mounted at the front of the car.\n" +
                    "\n" +
                    "The car employs a cab-forward design in order to utilise the new aerodynamic parts of the car more effectively and in order to incorporate radiators or the cooling requirements of the hybrid system of the car. The design is a close collaboration between Ferrari Styling Centre and Ferrari engineers.\n" +
                    "SF90 Stradale rear end\n" +
                    "\n" +
                    "The rear-end of the car carries over many iconic Ferrari Styling elements such as the flying buttresses. The engine cover has been kept as low as possible in order to maximise airflow. According to the car's lead designer, Flavio Manzoni, the car's design lies in between that of a spaceship and of a race car. The rear side-profile harkens back to the 1960s 330 P3/4."
            ),
            VehicleDescription(
                "Variants",
                "SF90 Spider\n" +
                    "\n" +
                    "The SF90 Spider is an open-top variant of the SF90 Stradale equipped with a retractable hardtop. It is the first Ferrari plug-in hybrid car offered as an open-top variant. It is also the most powerful non-limited convertible car in the world, having a combined power of 1,000 PS. The previous record was held by the Ferrari 812 GTS. Performance is very similar to the closed-body variant and on par with LaFerrari Aperta.\n" +
                    "\n" +
                    "Assetto Fiorano\n" +
                    "\n" +
                    "The Assetto Fiorano is a racing modification pack for the SF90 Stradale or Spider. It uses racing-derived Multimatic shocks and lightweight carbon fibre parts embedded in the door panels and underbody. The Assetto Fiorano also employs a lightweight titanium exhaust system. These measures save 30 kg (66 lb) compared to the standard SF90 Stradale."
            ),
            VehicleDescription(
                "Specifications",
                "Battery and driving modes\n" +
                        "\n" +
                        "The car has a 7.9 kWh lithium-ion battery for regenerative braking, giving the car 26 km (16 mi) of electric range. The car comes with four driving modes depending on road conditions. The modes are changed by the eManettino knob present on the steering wheel.\n" +
                        "\n" +
                        "The eDrive mode runs the car only on the electric motors. The Hybrid mode runs the car on both the internal combustion engine and the electric motors and is the car's default mode. In this mode, the car's onboard computer (called control logic) also turns off the engine if the conditions are ideal in order to save fuel while allowing the driver to start the engine again. The Performance mode keeps the engine running in order to charge the batteries and keeps the car responsive in order for optimum performance. The Qualify mode uses the powertrain to its full potential.\n" +
                        "\n" +
                        "The control logic system makes use of three primary areas: the high-voltage controls of the car (including the batteries), the RAC-e (Rotation Axis Control-electric) torque vectoring system, and the MGUK along with the engine and gearbox.\n" +
                        "\n" +
                        "Powertrain\n" +
                        "\n" +
                        "The SF90 Stradale is equipped with three electric motors, adding a combined output of 220 PS (162 kW; 217 bhp) to a twin-turbocharged V8 engine rated at a power output of 780 PS (574 kW; 769 hp) at 7,500 rpm. The car is rated at a total output of 1,000 PS (735 kW; 986 hp) at 8,000 rpm and a maximum torque of 800 N⋅m (590 lb⋅ft) at 6,000 rpm.\n" +
                        "\n" +
                        "The front wheels are powered by two electric motors (one for each wheel), providing torque vectoring. They also function as the reversing gear, as the main transmission (eight-speed dual-clutch) does not have a reversing gear.\n" +
                        "\n" +
                        "Transmission\n" +
                        "\n" +
                        "The engine of the SF90 Stradale is mated to a new 8-speed dual-clutch transmission. The new transmission is 10 kg (22 lb) lighter and more compact than the existing 7-speed transmission used by the other offerings of the manufacturer partly due to the absence of a dedicated reverse gear since reversing is provided by the electric motors mounted on the front axle. The new transmission also has a 30% faster shift time (200 milliseconds).\n" +
                        "\n" +
                        "Handling\n" +
                        "\n" +
                        "The SF90 Stradale employs eSSC (electric Side Slip Control) which controls the torque distribution to all four wheels of the car. The eSSC is combined with eTC (electric Tractional Control), a new brake-by-wire system which combines the traditional hydraulic braking system and electric motors to provide optimal regenerative braking and torque vectoring.\n" +
                        "\n" +
                        "Chassis\n" +
                        "\n" +
                        "The car's all-new chassis combines aluminium and carbon fibre to improve structural rigidity and provide a suitable platform for the car's hybrid system. The car has a total dry weight of 1,570 kg (3,461 lb) after combining the 270 kg (595 lb) weight of the electric system.\n" +
                        "\n" +
                        "Performance\n" +
                        "\n" +
                        "Ferrari states that the SF90 Stradale is capable of accelerating from a standstill to 100 km/h (62 mph) in 2.5 seconds, 0–200 km/h (124 mph) in 6.7 seconds and can attain a top speed of 340 km/h (211 mph). It is the fastest Ferrari road car on their Fiorano Circuit as of 2020, seven tenths of a second faster than the LaFerrari."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was this car model released?", listOf("2020","2018","2023","2019"),4),
            VehicleQuiz(1,"Which of these body styles existed for this model?", listOf("Sedan","Coupe & Aperta","Berlinetta","SUV"),3),
            VehicleQuiz(2,"What was the power output of the car?", listOf("950hp","900hp","650hp","1000hp"),4),
            VehicleQuiz(3,"What was the top speed (km/h) of this model? ", listOf("312","389","340","352"),3),
            VehicleQuiz(4,"Which engine did this model have?", listOf("6.3 L V12","6.5 L W12","1.9 TDI","4.0 L V8"),4),
            VehicleQuiz(5,"How many electric motors did it have?", listOf("2","1","3","0"),3)
        )
    ),
    VehicleModel(
        2,
        "Ferrari",
        "296 GTB",
        R.drawable.ferrari_296gtb,
        R.drawable.ferrari_296gtb_own,
        R.drawable.ferrari_296gtb_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "2022 - present"
                    )
                )
            ),
            VehicleInfo("Body",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car (S)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2 door berlinetta\n2-door hard-top convertible"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid-engine\nRear-wheel-drive"
                    ),
                    VehicleStat(
                        "Related",
                        "Ferrari SF90 Stradale"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3 L Tipo F163 twin-turbocharged V6"
                    ),
                    VehicleStat(
                        "Electric motor",
                        "2x YASA MGU-K"
                    ),
                    VehicleStat(
                        "Power output",
                        "Engine: 663 PS (488 kW; 654 hp)\n" +
                                "Electric motors: 167 PS (123 kW; 165 hp)\n" +
                                "Combined: 830 PS (610 kW; 819 hp)"
                    ),
                    VehicleStat(
                        "Transmission",
                        "8-speed dual-clutch"
                    )
                )
            ),
            VehicleInfo("Chronology",
                listOf(
                    VehicleStat(
                        "Predecessor",
                        "Ferrari Dino & 246"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "The 296 GTB was presented as the first \"real Ferrari with six cylinders\" on 24 June 2021. Previously, such models were offered as the Dino until 1974. The sports car is scheduled to go on sale in 2022. The 296 in the model name stands for the displacement and the number of cylinders, the GTB stands for Gran Turismo Berlinetta."
            ),
            VehicleDescription(
                "Design",
                "Inside, the 296 is an exercise in elegant minimalism, except for the steering wheel. Its excessive controls create an ergonomic nightmare. Otherwise, the dashboard features an entirely digital interface that is derived from the SF90. The GTB's seats and various interior surfaces are covered with Italian leather that showcases the coupe's luxurious side. The center console contains a push-button shifter inspired by the gated manual Ferrari gearboxes of old. There's a small compartment for storing the GTB's ignition key on the center console, too. A head-up display is also discreetly integrated into the top of the dash. The interior of the GTS is said to be nearly identical to that of the GTB save for reworked seats and flaps designed to minimize buffeting when the top’s down."
            ),
            VehicleDescription(
                "Variants",
                "Assetto Fiorano\n" +
                        "\n" +
                        "The Assetto Fiorano is the track-oriented version of the 296 GTB.\n" +
                        "\n" +
                        "GTS\n" +
                        "\n" +
                        "The 296 GTS is an open-top variant of the 296 GTB with a folding hardtop. The top takes 14 seconds for operation and can be operated with speeds up to 45 km/h (28 mph). The GTS weighs 70 kg (154 lb) more than the GTB due to chassis reinforcing components but maintains equal performance."
            ),
            VehicleDescription(
                "Specifications",
                "The 296 GTB is powered by a 2,992 cc (3.0 L) twin-turbo 120° V6 engine that has a maximum output of 488 kW (654 hp; 663 PS) at 8,000 rpm, in combination with a 123 kW (165 hp; 167 PS) electric motor. The system output is given as 610 kW (818 hp; 829 PS). A high-voltage accumulator positioned under the floor with an energy capacity of 7.45 kWh (26.8 MJ) enables an electrical range of 25 km (16 mi). The sports car accelerates to 100 km/h (62 mph) in 2.9 seconds, the top speed is specified as over 330 km/h (205 mph)."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was this car model released?", listOf("2012","2022","2013","2010"),2),
            VehicleQuiz(1,"How many cylinders does this model have?", listOf("6","8","4","12"),1),
            VehicleQuiz(2,"What was the power output of the car?", listOf("950hp","819hp","650hp","1000hp"),2),
            VehicleQuiz(3,"What was the top speed (km/h) of this model? ", listOf("312","389","297","330"),4),
            VehicleQuiz(4,"Which engine did this model have?", listOf("6.3 L V12","6.5 L W12","3 L V6","4.0 L V8"),3),
            VehicleQuiz(5,"How many electric motors did it have?", listOf("2","1","3","0"),1)
        )
    ),
    VehicleModel(
        3,
        "Ferrari",
        "F40",
        R.drawable.ferrari_f40,
        R.drawable.ferrari_f40_own,
        R.drawable.ferrari_f40_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "1987 - 1992 (1315 cars)"
                    )
                )
            ),
            VehicleInfo("Body",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car (S)"
                    ),
                    VehicleStat(
                        "Body",
                        "2 door berlinetta"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid-engine\nRear-wheel drive"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "2.9 L twin-turbocharged Tipo F120A/F120D V8"
                    ),
                    VehicleStat(
                        "Transmission",
                        "5-peed manual"
                    )
                )
            ),
            VehicleInfo("Chronology",
                listOf(
                    VehicleStat(
                        "Predecessor",
                        "Ferrari 288 GTO"
                    ),
                    VehicleStat(
                        "Successor",
                        "Ferrari F50"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "The Ferrari F40 (tipo F120) is a mid-engine, rear-wheel drive sports car engineered by Nicola Materazzi with styling by Pininfarina. It was built from 1987 until 1992, with the LM and GTE race car versions continuing production until 1994 and 1996 respectively. As the successor to the 288 GTO (also engineered by Materazzi), it was designed to celebrate Ferrari's 40th anniversary and was the last Ferrari automobile personally approved by Enzo Ferrari. At the time it was Ferrari's fastest, most powerful, and most expensive car for sale.\n" +
                        "\n" +
                        "The car debuted with a planned production total of 400 units and a factory suggested retail price of approximately US\$400,000 (fivefold the price of its predecessor, the 288 GTO) in 1987 (\$950,000 today). One of those that belonged to the Formula One driver Nigel Mansell was sold for the then record of £1 million in 1990, a record that stood into the 2010s. A total of 1,315 cars were manufactured.\n" +
                        "\n" +
                        "Origin\n" +
                        "\n" +
                        "As early as 1984, Materazzi had proposed to Enzo Ferrari the idea of using the Group B 4-litre category (2.857-litre if turbocharged) to prove the performance of new road cars which with increased power could no longer safely display their performance on the road in the hands of regular buyers. Since Enzo Ferrari no longer had control over the production part of the business, Materazzi had to obtain permission from General Manager Eugenio Alzati. Permission was granted but only at the condition that work would take place outside of the Monday to Friday work week. A very small team thus developed the GTO Evoluzione on Saturdays to compete in the same class entered by the Porsche 959 in FIA Group B.\n" +
                        "\n" +
                        "However, when the FIA brought an end to the Group B category for the 1986 season, Enzo Ferrari was left with five 288 GTO Evoluzione development cars, and no series to enter them into the competition. These were left for enthusiasts who might consider purchasing one until a validation driver convinced Enzo Ferrari that Materazzi could keep the base car concept alive and make it roadworthy. Enzo's desire to leave a legacy in his final sports car allowed the Evoluzione program to be further developed to produce a car exclusively for road use. In particular, Ferrari had been impressed with the development of recent cars which claimed back much of the performance deficit inflicted by ever more restrictive emissions regulations. In response to the quite simple, but very expensive car with relatively little out of the ordinary being called a \"cynical money-making exercise\" aimed at speculators, a figure from the Ferrari marketing department was quoted as saying \"We wanted it to be very fast, sporting in the extreme and Spartan,\" \"Customers had been saying our cars were becoming too plush and comfortable.\" \"The F40 is for the most enthusiastic of our owners who want nothing but sheer performance. It isn't a laboratory for the future, as the 959 is. It is not Star Wars. And it wasn't created because Porsche built the 959. It would have happened anyway.\" In fact the reasons for the car's rawness and simplicity are very much linked to Materazzi's racing background (starting from the Stratos Gr.4, the Gr.5 Silhouette, then the Osella F2 and F1 cars, the 126C and eventually the 288 GTO)."
            ),
            VehicleDescription(
                "Design",
                "The body of the F40 was designed by Pietro Camardella under the supervision of, soon to retire, Aldo Brovarone of studio Pininfarina. Nicola Materazzi meanwhile worked on evolutions of the engine, gearbox and other mechanical parts of the car to make them roadworthy. Many of these were well validated in the 288 GTO Evoluzione, from which the F40 takes many styling cues. From the beginning of the project on 10 June 1986, Enzo Ferrari asked for the car to be completed in a very short space of time (11 months) and be presented in the summer of 1987. For this reason, he gave Materazzi permission to choose all the engineers on the team. Some of the development of the car, such as the bodywork was carried out at external companies like Michelotto Automobili (in Padua) which had experience in rally and race preparation (Stratos, GTO Evo, subsequently 333SP, 348, 355, 360, 430, 458).\n" +
                        "\n" +
                        "The body was an entirely new design by Pininfarina featuring panels made of Kevlar, carbon fibre, and aluminium for strength and low weight, and intense aerodynamic testing employed. Weight was further minimised through the use of a polycarbonate plastic windshield and windows. The cars did have moderate air conditioning but had no sound system, door handles, glove box, leather trim, carpets, or door panels. The first 50 cars produced had sliding Lexan windows, while later cars were fitted with wind-down windows.\n" +
                        "All cars technically left the factory in \"Rosso Corsa\" colour and left-hand drive. At least seven cars were modified and delivered to the Sultan of Brunei in right-hand drive. The Sultan employed Pininfarina's prototype manager Paolo Garella to make modifications to the cars (colour, power, interior comforts)."
            ),
            VehicleDescription(
                "Variants",
                "LM\n" +
                        "\n" +
                        "The racing cars were prepared by Michelotto (based in Padua) the Ferrari specialist who had already carried out work on the GTO Evoluzione and on parts of the road-going version of the F40.\n" +
                        "\n" +
                        "3 chassis were prepared and 2 were used in races, with serial numbers 79890 and 79891. The third chassis, with serial number 88521, was intended to be raced and was a spare car that stayed at Michelotto but was never raced.\n" +
                        "\n" +
                        "The car saw competition as early as 1989 when it debuted in the Laguna Seca Raceway round of the IMSA, appearing in the GTO category, with an LM evolution model driven by Jean Alesi, finishing third to the two faster spaceframe four wheel drive Audi 90s and beating a host of other factory-backed spaceframe specials that dominated the races. In the following race, it had to retire after 18 laps. The next IMSA season, driven by a host of guest drivers such as Jean-Pierre Jabouille, Jacques Laffite and Hurley Haywood, three second-places and one third-place were the best results.\n" +
                        "\n" +
                        "Although the F40 would not return to IMSA in 1991, it would later be a popular choice by privateers to compete in numerous domestic GT series including JGTC.\n" +
                        "\n" +
                        "In 1994, the car made its debut in international competitions, with one car campaigned in the BPR Global GT Series by Strandell, winning at the 4 Hours of Vallelunga.\n" +
                        "\n" +
                        "In 1995, the number of F40s climbed to four, developed independently by Pilot-Aldix Racing (F40 LM) and Strandell (F40 GTE, racing under the Ferrari Club Italia banner), winning the 4 Hours of Anderstorp. No longer competitive against the newly entered McLaren F1 GTR, the Ferrari F40 returned for another year in 1996, managing to repeat the previous year's Anderstorp win, and from then on it was no longer seen in GT racing. In total 19 cars were produced.\n" +
                        "\n" +
                        "Competizione\n" +
                        "\n" +
                        "The F40 Competizione is a non-sponsored, more powerful version of the F40 LM, which was the result of consumer requests following the order of a French importer who wanted to enter one in the 24 Hours of Le Mans. 10 examples were built, all at customer request, the first two being called F40 LM's, and the remaining 8 being F40 Competizione, as Ferrari felt that the LM tag was too restrictive.\n" +
                        "\n" +
                        "The F40 Competizione is rated at 700 PS; 691 hp (515 kW) at 8,100 rpm from its upgraded twin-turbocharged V8 engine. The car can reportedly achieve a top speed of about 367 km/h (228 mph).\n" +
                        "Chassis number 80782 was originally purchased as a road car and imported into the Netherlands in 1989 by the official Ferrari importer, Kroymans BV. Work was then done by Peter van Erp of Cavallino Tuning, Kroymans' racing division to convert it into \"Competizione\" specification, with new shock absorbers, new instrumentation, brakes, bodywork, and a new paint job. The car was consistently promoted through the Ferrari Challenge, and modifications in 1995 were made to maintain the car's competitiveness. Modifications were made by British tuning house G-Tex in collaboration with Michelotto and included air jacks, an upgraded roll hoop, and upgrades to the engine which increased its power output to over 700 bhp (710 PS; 522 kW). After the car was sold to its most recent owner, it had a decorative makeover which consisted of a repaint in Grigio Nardo and blue fabric seats."
            ),
            VehicleDescription(
                "Specifications",
                "Power came from an enlarged, high-revving 2,936 cc (2.9 L; 179.2 cu in) version of the 288 GTO's IHI four-stroke 90 degrees twin turbocharged and intercooled V8 engine generating a peak power output of 478 PS (471 hp; 352 kW) at 7,000 rpm and 577 N⋅m (426 lb⋅ft) of torque at 4,000 rpm as stated by the manufacturer. Gearing, torque curves and actual power output differed among the cars. The F40 did without a catalytic converter until 1990, when US regulations made them a requirement for emissions control reasons. The flanking exhaust pipes guide exhaust gases from each bank of cylinders while the central pipe guides gases released from the wastegate of the turbochargers.\n" +
                        "\n" +
                        "The suspension setup was similar to the GTO's double wishbone setup, though many parts were upgraded and settings were changed; the unusually low ground clearance prompted Ferrari to include the ability to raise the vehicle's ground clearance when necessary for later cars via hydraulic lift chambers in the front dampers.\n" +
                        "\n" +
                        "Cooling was important as the forced induction engine generated a great deal of heat. As a consequence, the car was somewhat like an open-wheel racing car with a body. It had a partial undertray to smooth airflow beneath the radiator, front section, and the cabin, and a second one with diffusers behind the engine, but the engine bay was not sealed. It has a drag coefficient of Cd=0.34.\n" +
                        "\n" +
                        "The first independent measurements yielded 0-100 km/h (62 mph) in 4.7 seconds and a top speed of 321 km/h (199 mph) onto the French Sport Auto September 1988 cover.\n" +
                        "\n" +
                        "The next opportunity to reach the claimed top speed was a shootout at Nardò Ring organized by Auto, Motor und Sport. Ferrari sent two cars but neither could reach more than 321 km/h (199 mph), beaten by the Porsche 959 S, which attained a top speed of 339 km/h (211 mph), and the Ruf CTR, which attained a top speed of 342 km/h (213 mph). Both were limited production cars with only 29 built, so while the F40 never was the world's fastest sports car as self-appraised by Ferrari, it could still claim the title of the fastest production car with over 500 units built until the arrival of the Lamborghini Diablo (depending on how the term \"production car\" is defined). Road & Track measured a top speed of 315 km/h (196 mph) for both the European and US spec cars while Car and Driver measured a top speed of 317 km/h (197 mph)."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was this car model released?", listOf("2001","1992","1980","1987"),4),
            VehicleQuiz(1,"How many cylinders does this model have?", listOf("6","8","4","12"),2),
            VehicleQuiz(2,"What was the power output of the car?", listOf("420hp","600hp","550hp","471hp"),4),
            VehicleQuiz(3,"What was the top speed (km/h) of this model? ", listOf("367","389","297","352"),1),
            VehicleQuiz(4,"Which engine did this model have?", listOf("6.3 L V12","6.5 L W12","2.9 L V8","4.0 L V8"),3),
            VehicleQuiz(5,"What is its predecessor?", listOf("Ferrari 288 GTO","Ferrari F50","Ferrari F30","Ferrari Enzo"),1)
        )
    ),
    VehicleModel(
        4,
        "Ferrari",
        "F8",
        R.drawable.ferrari_f8,
        R.drawable.ferrari_f8_own,
        R.drawable.ferrari_f8_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "2019 - present"
                    )
                )
            ),
            VehicleInfo("Body",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car (S)"
                    ),
                    VehicleStat(
                        "Body",
                        "2-door berlinetta\n2-door hard-top convertible"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid-engine\nRear-wheel-drive"
                    ),
                    VehicleStat(
                        "Related",
                        "Ferrari SF90 Stradale"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "3.9 L F154 CD twin-turbo V8"
                    ),
                    VehicleStat(
                        "Transmission",
                        "7-speed dual-clutch"
                    )
                )
            ),
            VehicleInfo("Chronology",
                listOf(
                    VehicleStat(
                        "Predecessor",
                        "Ferrari 488"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "The Ferrari F8 (Type F142MFL) is a mid-engine sports car produced by the Italian automobile manufacturer Ferrari. The car is the replacement to the Ferrari 488, with exterior and performance changes. It was unveiled at the 2019 Geneva Motor Show."
            ),
            VehicleDescription(
                "Design",
                    "The front of the car is characterised by the S-Duct (originally featured on the 488 Pista) around which the entire front end of the car has been redesigned, with additional air intakes above the headlights. The front is completed by side aerodynamic intakes which are integrated into the shape of the bumper and feature two aerodynamic side splitters in black. The radiator packs are tilted towards the rear, using a flat undertray to channel the hot air and minimise the thermal interaction with the flows inside the wheel arch, derived from the 488 challenge. The car also features quad taillamps, a feature that was last seen in the V8 lineage on the F430. At the rear, it sports a louvered clear engine cover made from lightweight Lexan which pays homage to the F40 and a wrap-around rear spoiler inspired by the 308 GTB, with additional air intakes on both sides.\n" +
                    "\n" +
                    "Interior\n" +
                    "\n" +
                    "The interior has received updates as well: the dashboard, instrument housing, and door panels are new. The two-tone colour scheme seen on the 488 has also been replaced. An 8.5 inch passenger touchscreen display is also standard as a part of the HMI (Human Machine Interface). The dash now incorporates an aluminium sail panel supporting the central satellite navigation system and continuing into the dash itself."
            ),
            VehicleDescription(
                "Variants",
                "F8 Spider\n" +
                        "\n" +
                        "The F8 Spider is an open-top variant of the F8 Tributo with a folding hardtop as seen on its predecessors. The top takes 14 seconds for operation and can be operated with speeds up to 45 km/h (28 mph). The F8 Spider features large air intakes on its rear haunches, moved rearward compared to the ones in the 488 Spider for improved airflow to the engine.\n" +
                        "The Spider's drivetrain is shared with the Tributo. The engine has a lighter crankshaft, flywheel, and connecting rods and weighs nearly 18 kg (40 lb) less than the engine in the 488 Spider. Performance figures include acceleration from 0–100 km/h (62 mph) in 2.9 seconds and from 0–200 km/h (124 mph) in 8.2 seconds. Top speed is unchanged from the coupé at 340 km/h (211 mph). Dry weight of the Spider is 1,400 kg (3,086 lb). The boot capacity allows for 200 litres (7.1 cu ft) of luggage space.\n" +
                        "\n" +
                        "SP48 Unica\n" +
                        "\n" +
                        "The SP48 Unica enhances a new unique design like its name in a mechanics derived from the F8 Tributo including its mid-mounted 710 bhp twin-turbo V8. The redesign of the bodywork features an angular front end and a bold, windowless rear with a wraparound light bar."
            ),
            VehicleDescription(
                "Specifications",
                "The F8 Tributo uses the same engine from the 488 Pista, a 3.9 L twin-turbocharged V8 engine with a power output of 720 PS (530 kW; 710 hp) at 8000 rpm and 770 N⋅m (568 lb⋅ft) of torque at 3250 rpm, making it the most powerful V8-powered Ferrari produced to date. Specific intake plenums and manifolds with optimised fluid-dynamics improve the combustion efficiency of the engine, thanks to the reduction of the temperature of the air in the cylinder, which also helps boost power. The exhaust layout and the Inconel manifolds have been completely modified up to the terminals. The F8 Tributo also uses turbo rev sensors, developed in the 488 Challenge, to maximise the efficiency of the turbochargers based on the demand for power from the pedal. The transmission is a 7-speed dual clutch automatic unit with improved gear ratios.\n" +
                        "\n" +
                        "Several new software features are installed on the F8 which are controlled via the manettino dial on the steering wheel. The car is equipped with Ferrari's latest Side Slip Angle Control traction- and stability-control program. Additionally, the Ferrari Dynamic Enhancer, an electronic program for managing drifts, can now be used in the Race drive mode. Claimed manufacturer performance for the F8 Tributo is 0–100 km/h (0–62 mph) in 2.9 seconds, 0–200 km/h (0–124 mph) in 7.6 seconds, with a top speed of 340 km/h (211 mph). Ferrari also stated that the Tributo's downforce has been increased by 15 percent as compared to the 488 GTB. Road & Track tested a US-spec Ferrari F8 Tributo model and achieved an 11.3-second quarter-mile time with a 132.8 mph (214 km/h) trap speed, which equates to 0–100 km/h in the mid-3 range and 0–200 km/h in the low-10 range."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was this car model released?", listOf("2019","2018","2020","2021"),1),
            VehicleQuiz(1,"Which of these body styles existed for this model?", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
            VehicleQuiz(2,"What was the power output of the car?", listOf("950hp","900hp","650hp","710hp"),4),
            VehicleQuiz(3,"What was the top speed (km/h) of this model? ", listOf("312","340","297","352"),2),
            VehicleQuiz(4,"Which engine did this model have?", listOf("6.3 L V12","6.5 L W12","3.9 L V8","5.7 L V8"),3),
            VehicleQuiz(5,"What is its predecessor?", listOf("Ferrari SF90","Ferrari LaFerrari","Ferrari 488","Ferrari 458"),3)
        )
    ),
    VehicleModel(
        5,
        "Ferrari",
        "Monza SP2",
        R.drawable.ferrari_monzasp2,
        R.drawable.ferrari_monzasp2_own,
        R.drawable.ferrari_monzasp2_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "2019 - present"
                    )
                )
            ),
            VehicleInfo("Body",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car (S)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2-door speedster"
                    ),
                    VehicleStat(
                        "Layout",
                        "Front-engine\nRear-wheel-drive"
                    ),
                    VehicleStat(
                        "Related",
                        "Ferrari 812 Superfast"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "6.5 L F140 GC V12"
                    ),
                    VehicleStat(
                        "Transmission",
                        "7-speed dual clutch"
                    )
                )
            )
        ),
        listOf(
            VehicleDescription(
                "History",
                "The Ferrari Monza SP1 and SP2 are limited production sports cars produced by Italian automobile manufacturer Ferrari, introduced in 2018 for the 2019 model year. The cars mark the start of a new lineage of models called the \"Icona\" series, a program aimed at creating special cars inspired by classic Ferrari models, all to be produced in limited series. The first cars of the new lineage are the Monza SP1 and SP2, whose designs are inspired by the 750 Monza, 250 Testarossa and 166 MM."
            ),
            VehicleDescription(
                "Design",
                "The SP1 and SP2 feature low slung, carbon fibre speedster bodywork inspired by early, post-war Ferrari race cars such as the 166 MM, as well as the 250 Testarossa and 750 Monza. The SP1 is a single-seater, with the driver's position situated to one side of the car, while the SP2 has two seats separated by a center section. Both of the cars feature small scissor doors and don't have windshields, instead relying on a patented system Ferrari calls the \"Virtual Windshield\", which is supposed to deviate airflow away from the driver. In 2020, Ferrari Styling Centre was awarded the Compasso d’Oro industrial design award for the Monza SP1. Award was received by Flavio Manzoni and Jane Reeve."
            ),
            VehicleDescription(
                "Variants",
                "The SP1 and SP2 nomenclature refers to the number of seats for each model. 499 units are expected to be produced[3] at a price of €1.58 million before options."
            ),
            VehicleDescription(
                "Specifications",
                "Engine\n" +
                        "\n" +
                        "Both the SP1 and SP2 are powered by a variant of the naturally aspirated 6,496 cc (6.5 L; 396.4 cu in) F140 GA V12 found in the 812 Superfast. The engine has been tuned to generate 7.4 kW (10 hp; 10 PS) more than the engine in the 812, for a total of 596 kW (799 hp; 810 PS) at 8,500 rpm and 719 N⋅m (530 lbf⋅ft) of torque at 7,000 rpm, making them at the time, the most powerful factory Ferrari V12 road cars ever produced until the release of the 812 Competizione and Competizione A in 2021 featuring an upgraded F140 V12 producing 820 hp (830 PS).\n" +
                        "\n" +
                        "Chassis\n" +
                        "\n" +
                        "The chassis is loosely based on the 812 and both the SP1 and SP2 cars feature carbon fibre composite bodywork. The SP1 weighs 1,500 kg (3,306 lb), while the two-seat SP2 is 20 kg (45 lb) heavier at 1,520 kg (3,351 lb). The strength of the composite bodywork allows for the inclusion of a large clamshell hood.\n" +
                        "\n" +
                        "Performance\n" +
                        "\n" +
                        "Manufacturer claimed performance figures for both of the cars include a 0–97 km/h (0–60 mph) acceleration time of 2.9 seconds, 0–200 km/h (0–124 mph) acceleration time of 7.9 seconds and a top speed that exceeds 299 km/h (186 mph)."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was this car model released?", listOf("2012","2018","2019","2020"),3),
            VehicleQuiz(1,"What car is related with?", listOf("Ferrari 812 Superfast","Ferrari 458","Ferrari 360","Ferrari 250 GTO"),1),
            VehicleQuiz(2,"What was the power output of the car?", listOf("950hp","810hp","850hp","1000hp"),2),
            VehicleQuiz(3,"How many doors does this model have?", listOf("2","1","4","5"),1),
            VehicleQuiz(4,"After which car was the design of this model inspired?", listOf("250 Testarossa","599 GTO","FXX-K EVO","Purosangue"),1),
            VehicleQuiz(5,"How many electric motors did it have?", listOf("2","1","3","0"),2)
        )
    ),
    VehicleModel(
        5,
        "Ferrari",
        "LaFerrari",
        R.drawable.ferrari_laferrari,
        R.drawable.ferrari_laferrari_own,
        R.drawable.ferrari_laferrari_cover,
        listOf(
            VehicleInfo("Overview",
                listOf(
                    VehicleStat(
                        "Production",
                        "2013 – 2016 (Coupé, 500 cars)\n2016 – 2018 (Aperta, 210 cars)"
                    ),
                    VehicleStat(
                        "Model Years",
                        "2013 – 2016 (Coupé)\n2016 – 2018 (Aperta)"
                    )
                )
            ),
            VehicleInfo("Body",
                listOf(
                    VehicleStat(
                        "Class",
                        "Sports Car (S)"
                    ),
                    VehicleStat(
                        "Body Style",
                        "2-door Coupé\n2-door targa top (Aperta)"
                    ),
                    VehicleStat(
                        "Layout",
                        "Rear mid-engine\nRear-wheel drive"
                    ),
                    VehicleStat(
                        "Doors",
                        "Butterfly (Coupé)\nSwan (Aperta)"
                    ),
                    VehicleStat(
                        "Related cars",
                        "Ferrari FXX-K\nFerrari Daytona SP3"
                    )
                )
            ),
            VehicleInfo("Powertrain",
                listOf(
                    VehicleStat(
                        "Engine",
                        "6.3 L F140 FE V12"
                    ),
                    VehicleStat(
                        "Electric motor",
                        "1 electric motor, KERS"
                    ),
                    VehicleStat(
                        "Power output",
                        "708 kW (950 hp; 963 PS)"
                    ),
                    VehicleStat(
                        "Transmission",
                        "7-speed dual-clutch automatic"
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
                "Nine conceptual design studies were considered for the V12 hybrid flagship in 2011, reduced to five in April 2011 (three by Ferrari Centro Stile and two by Pininfarina). Of these, two full-size concepts were built: LaFerrari Concept Manta (internal designation: 2011 Model 2) and LaFerrari Concept Tensostruttura (internal designation 2011 Model 3). These were unveiled at the Ferrari Museum in Maranello, Italy and Ferrari World in Abu Dhabi. The final design of LaFerrari is similar to the Manta concept (Model 2). The Ferrari Centro Stile cars designed after LaFerrari have design elements reminiscent of the Tensostruttura concept (Model 3), e.g. the SF90 Stradale.\n" +
                        "\n" +
                        "The design of the V12 flagship received no input from Pininfarina, making it the first Ferrari since the Bertone-styled 1973 Dino 308 GT4 not to have Pininfarina bodywork or another styling. This decision is a rare exception to the collaboration between Ferrari and Pininfarina that began in 1951. However, Ferrari has stated that there are no plans to end business relations with Pininfarina.\n" +
                        "\n" +
                        "The steering wheel has integrated controls and paddle-shifters directly fixed to the steering column, a solution that allows better use in all conditions. The \"bridge\" which exists between the two seats, designed like a suspended wing, is home to other instruments linked to the dual-clutch gearbox. The instrumentation consists of a 12.3-inch (310 mm) TFT display with the option to choose between two layouts and can host data from the telemetry system."
            ),
            VehicleDescription(
                "Variants",
                "LaFerrari (2013 - 2016)\n" +
                        "\n" +
                        "LaFerrari is based on findings from testing of the FXX development prototype and on research being conducted by the Millechili Project at the University of Modena. Association with the Millechili Project led to speculation during development that the car would weigh under 1,000 kg (2,205 lb), but a dry weight of around 1,255 kg (2,767 lb) was claimed. Only 499 units were produced, and each cost more than 1 million Euros. The car was unveiled at the 2013 Geneva Auto Show, followed by Auto Shanghai 2013, 2013 Tour Auto Optic 2000, 2013 Supercar Chronicle, Italian Chamber of Commerce in Japan.\n" +
                        "\n" +
                        "\n" +
                        "LaFerrari Aperta (2016 - 2018)\n" +
                        "\n" +
                        "LaFerrari Aperta is the open-top version of LaFerrari. Initially, 200 cars were sold with an additional nine reserved for use during the Ferrari 70th Anniversary celebrations. One more unit was later sold by auction. The Aperta comes with a removable carbon-fiber hardtop and a removable canvas soft top. Other changes include more efficient powertrain's control electronics, re-angled radiators to direct airflow out along the underbody rather than over the bonnet, a longer front air dam to help increase downforce, an L-shaped flap on the upper corner of each windscreen pillar to reduce compression on the rear of the cabin in the absence of a roof, different door opening angles with different wheel arches and a new carbon-fiber insert allowing the doors to rotate. The car was unveiled at the 2016 Paris Motor Show. Like past open-top Ferrari models, it uses the Aperta label to denote its removable roof. According to Ferrari, all 200 units were already pre-sold to customers via invitation."
            ),
            VehicleDescription(
                "Specifications",
                "LaFerrari is the first full hybrid produced by the Italian automotive marque, providing the highest power output of any Ferrari road car whilst decreasing fuel consumption by 40 percent. LaFerrari's internal combustion petrol engine is a longitudinally rear mid-mounted Ferrari F140 direct fuel injected 65° V12 engine with a displacement of 6,262 cc (6.3 L) generating a maximum power output of 800 PS (588 kW; 789 hp) at 9,000 rpm and 700 N⋅m (516 lb⋅ft) of torque at 6,750 rpm, supplemented by a 163 PS (120 kW; 161 hp) KERS unit (called HY-KERS), which provides short bursts of extra power. The KERS system adds extra power to the combustion engine's power output level for a total of 963 PS (708 kW; 950 hp) and a combined torque of 900 N⋅m (664 lb⋅ft). Ferrari claims CO2 emissions of 330 g/km. The engine's bore X stroke is 94 mm × 75.2 mm (3.70 in × 2.96 in) with a compression ratio of 13.5:1 and a specific power output of 94 kW (128 PS) per liter. It is mated to a 7-speed dual-clutch transmission.\n" +
                        "\n" +
                        "The car is equipped with carbon-ceramic Brembo brake discs at the front (398 mm) and rear (380 mm). The car is equipped with Pirelli P Zero Corsa tires measuring 265/30 R 19 (front) and 345/30 R 20 (rear) respectively. The car uses a carbon fiber monocoque structure designed by Ferrari's F1 technical director Rory Byrne, with a claimed 27 percent more torsional rigidity and 22 percent more beam stiffness than its predecessor. It has a double wishbone suspension in the front and a multi-link suspension in the rear. LaFerrari has several electronic controls including an electronic stability control, high-performance ABS/EBD (anti-lock braking system/electronic brake distribution), EF1-Trac F1 electronic traction control integrated with the hybrid system, E-Diff 3 third-generation electronic differential, SCM-E Frs magnetorheological damping with twin solenoids (Al-Ni tube), and active aerodynamics, which are controlled by 21 of LaFerrari's onboard computers, to enable maximum performance. The body computer system is developed by Magneti Marelli Automotive Lighting.\n" +
                        "\n" +
                        "Ferrari states that the car has a top speed of 352 km/h (218 mph). In terms of acceleration, it can go 0–100 km/h (0–62 mph) in 2.6 seconds, 0–200 km/h (0–124 mph) in under 6.9 seconds, and 0–300 km/h (0–186 mph) in 15 seconds were announced by Ferrari. However, the 0-300 figure was later debunked by multiple sources. Its verified 0-300 time is 21.99 seconds. Ferrari also claims that the car has lapped its Fiorano Test Circuit in 1:19.70."
            ),
        ),
        listOf(
            VehicleQuiz(0,"When was this car model released?", listOf("2012","2018","2013","2010"),3),
            VehicleQuiz(1,"Which of these body styles existed for this model?", listOf("Sedan","Coupe & Aperta","Coupe","SUV"),2),
            VehicleQuiz(2,"What was the power output of the car?", listOf("950hp","900hp","650hp","1000hp"),1),
            VehicleQuiz(3,"What was the top speed (km/h) of this model? ", listOf("312","389","297","352"),4),
            VehicleQuiz(4,"Which engine did this model have?", listOf("6.3 L V12","6.5 L W12","1.9 TDI","4.0 L V8"),1),
            VehicleQuiz(5,"How many electric motors did it have?", listOf("2","1","3","0"),2)
        )
    ),
)