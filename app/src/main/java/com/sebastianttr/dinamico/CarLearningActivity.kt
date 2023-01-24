package com.sebastianttr.dinamico

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sebastianttr.dinamico.composable.*
import com.sebastianttr.dinamico.layouts.dpToPx
import com.sebastianttr.dinamico.ui.theme.AccentLight
import com.sebastianttr.dinamico.ui.theme.AccentStrong
import com.sebastianttr.dinamico.ui.theme.DinamicoTheme
import com.sebastianttr.dinamico.ui.theme.Montserrat

class CarLearningActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()

            val context = LocalContext.current

            systemUiController.setStatusBarColor(
                color = Color(0xFFFBAB18)
            )
            DinamicoTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            modifier = Modifier
                                .padding(0.dp)
                                .height(80.dp)
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color(0xFFFBAB18),
                                            Color(0xFFFEDE00)
                                        ),
                                        startY = 0.dp.dpToPx(),
                                        endY = 80.dp.dpToPx()
                                    )
                                )
                                .zIndex(2f),
                            title = {
                                Text(
                                    "Learning",
                                    modifier = Modifier.padding(start = 8.dp),
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Black
                                )
                            },
                            backgroundColor = Color.Transparent,
                            actions = {
                                IconButton(
                                    modifier = Modifier.padding(end = 16.dp),
                                    onClick = {
                                        finish()
                                    }
                                ) {
                                    Image(
                                        modifier = Modifier.rotate(90f),
                                        painter = painterResource(id = R.drawable.ic_arrow_down_up),
                                        contentDescription = "arrow_up_down"
                                    )
                                }
                            },
                            elevation = 0.dp
                        )
                        Box(
                            modifier =
                            Modifier
                                .offset(y = 80.dp)
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(
                                    Color(0xFF8E7C00)
                                )
                        )
                    }
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF111224),
                                        Color(0xFF25284F)
                                    ),
                                    startY = 300.dp.dpToPx(),
                                    endY = (LocalConfiguration.current.screenHeightDp.dp + 300.dp).dpToPx()
                                )
                            )
                            .fillMaxHeight()
                    ) {
                        item { IntroductionHeader() }
                        item {
                            Column(
                                modifier = Modifier.padding(horizontal = 16.dp)
                            ) {
                                Text(
                                    text = "Key information",
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 22.sp,
                                        color = Color.White
                                    )
                                )
                                SBorderedColumn {
                                    SBorderedColumnItemTitle(text = "Overview")
                                    SBorderedColumnDescriptionItem(key = "Production", value = "2013 – 2016 (Coupé, 500 cars)\n" +
                                            "2016 – 2018 (Aperta, 210 cars)")
                                    SBorderedColumnDescriptionItem(key = "Model years", value = "2013 – 2016 (Coupé)\n2016 – 2018 (Aperta)")
                                    SBorderedColumnItemDivider()
                                    SBorderedColumnItemTitle(text = "Body and chassis")
                                    SBorderedColumnDescriptionItem(key = "Class", value = "Sports Car (S)")
                                    SBorderedColumnDescriptionItem(key = "Body style", value = "2-door Coupé\n" +
                                            "2-door targa top (Aperta)")
                                    SBorderedColumnDescriptionItem(key = "Layout", value = "Rear mid-engine, rear-wheel-drive")
                                }

                                ParagraphDivider(32.dp)
                                Paragraph(title = "History", content = "LaFerrari, project name F150 is a limited production mid-engine mild hybrid sports car built by Italian automotive manufacturer Ferrari. LaFerrari means \"The Ferrari\" in Italian and some other Romance languages, in the sense that it is the \"definitive\" Ferrari.")

                                ParagraphDivider(32.dp)
                                Paragraph(title = "Design", content = "Nine conceptual design studies were considered for the V12 hybrid flagship in 2011, reduced to five in April 2011 (three by Ferrari Centro Stile and two by Pininfarina). Of these, two full-size concepts were built: LaFerrari Concept Manta (internal designation: 2011 Model 2) and LaFerrari Concept Tensostruttura (internal designation 2011 Model 3). These were unveiled at the Ferrari Museum in Maranello, Italy and Ferrari World in Abu Dhabi. The final design of LaFerrari is similar to the Manta concept (Model 2). The Ferrari Centro Stile cars designed after LaFerrari have design elements reminiscent of the Tensostruttura concept (Model 3), e.g. the SF90 Stradale.\n" +
                                        "\n" +
                                        "The design of the V12 flagship received no input from Pininfarina, making it the first Ferrari since the Bertone-styled 1973 Dino 308 GT4 not to have Pininfarina bodywork or another styling. This decision is a rare exception to the collaboration between Ferrari and Pininfarina that began in 1951. However, Ferrari has stated that there are no plans to end business relations with Pininfarina.\n" +
                                        "\n" +
                                        "The steering wheel has integrated controls and paddle-shifters directly fixed to the steering column, a solution that allows better use in all conditions. The \"bridge\" which exists between the two seats, designed like a suspended wing, is home to other instruments linked to the dual-clutch gearbox. The instrumentation consists of a 12.3-inch (310 mm) TFT display with the option to choose between two layouts and can host data from the telemetry system.\n")

                                ParagraphDivider(32.dp)
                                Paragraph(title = "Variants", content = "LaFerrari (2013 - 2016)\n" +
                                        "\n" +
                                        "LaFerrari is based on findings from testing of the FXX development prototype and on research being conducted by the Millechili Project at the University of Modena. Association with the Millechili Project led to speculation during development that the car would weigh under 1,000 kg (2,205 lb), but a dry weight of around 1,255 kg (2,767 lb) was claimed. Only 499 units were produced, and each cost more than 1 million Euros. The car was unveiled at the 2013 Geneva Auto Show, followed by Auto Shanghai 2013, 2013 Tour Auto Optic 2000, 2013 Supercar Chronicle, Italian Chamber of Commerce in Japan.\n \n" +
                                        "\n" +
                                        "LaFerrari Aperta (2016 - 2018)\n" +
                                        "\n" +
                                        "LaFerrari Aperta is the open-top version of LaFerrari. Initially, 200 cars were sold with an additional nine reserved for use during the Ferrari 70th Anniversary celebrations. One more unit was later sold by auction. The Aperta comes with a removable carbon-fiber hardtop and a removable canvas soft top. Other changes include more efficient powertrain's control electronics, re-angled radiators to direct airflow out along the underbody rather than over the bonnet, a longer front air dam to help increase downforce, an L-shaped flap on the upper corner of each windscreen pillar to reduce compression on the rear of the cabin in the absence of a roof, different door opening angles with different wheel arches and a new carbon-fiber insert allowing the doors to rotate. The car was unveiled at the 2016 Paris Motor Show. Like past open-top Ferrari models, it uses the Aperta label to denote its removable roof. According to Ferrari, all 200 units were already pre-sold to customers via invitation.\n")

                                ParagraphDivider(32.dp)
                                Paragraph(title = "Specifications", content = "LaFerrari is the first full hybrid produced by the Italian automotive marque, providing the highest power output of any Ferrari road car whilst decreasing fuel consumption by 40 percent. LaFerrari's internal combustion petrol engine is a longitudinally rear mid-mounted Ferrari F140 direct fuel injected 65° V12 engine with a displacement of 6,262 cc (6.3 L) generating a maximum power output of 800 PS (588 kW; 789 hp) at 9,000 rpm and 700 N⋅m (516 lb⋅ft) of torque at 6,750 rpm, supplemented by a 163 PS (120 kW; 161 hp) KERS unit (called HY-KERS), which provides short bursts of extra power. The KERS system adds extra power to the combustion engine's power output level for a total of 963 PS (708 kW; 950 hp) and a combined torque of 900 N⋅m (664 lb⋅ft). Ferrari claims CO2 emissions of 330 g/km. The engine's bore X stroke is 94 mm × 75.2 mm (3.70 in × 2.96 in) with a compression ratio of 13.5:1 and a specific power output of 94 kW (128 PS) per liter. It is mated to a 7-speed dual-clutch transmission.\n" +
                                        "\n" +
                                        "The car is equipped with carbon-ceramic Brembo brake discs at the front (398 mm) and rear (380 mm). The car is equipped with Pirelli P Zero Corsa tires measuring 265/30 R 19 (front) and 345/30 R 20 (rear) respectively. The car uses a carbon fiber monocoque structure designed by Ferrari's F1 technical director Rory Byrne, with a claimed 27 percent more torsional rigidity and 22 percent more beam stiffness than its predecessor. It has a double wishbone suspension in the front and a multi-link suspension in the rear. LaFerrari has several electronic controls including an electronic stability control, high-performance ABS/EBD (anti-lock braking system/electronic brake distribution), EF1-Trac F1 electronic traction control integrated with the hybrid system, E-Diff 3 third-generation electronic differential, SCM-E Frs magnetorheological damping with twin solenoids (Al-Ni tube), and active aerodynamics, which are controlled by 21 of LaFerrari's onboard computers, to enable maximum performance. The body computer system is developed by Magneti Marelli Automotive Lighting.\n" +
                                        "\n" +
                                        "Ferrari states that the car has a top speed of 352 km/h (218 mph). In terms of acceleration, it can go 0–100 km/h (0–62 mph) in 2.6 seconds, 0–200 km/h (0–124 mph) in under 6.9 seconds, and 0–300 km/h (0–186 mph) in 15 seconds were announced by Ferrari. However, the 0-300 figure was later debunked by multiple sources. Its verified 0-300 time is 21.99 seconds. Ferrari also claims that the car has lapped its Fiorano Test Circuit in 1:19.70.\n")
                            }
                        }
                        item {
                            Column(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    modifier = Modifier
                                        .padding(vertical = 40.dp)
                                        .height(36.dp)
                                        .fillMaxWidth(),
                                    painter = painterResource(id = R.drawable.checker), 
                                    contentDescription = "checker"
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.CenterHorizontally)
                                        .padding(vertical = 10.dp),
                                    text = "Are you ready to test yourself and obtain this car?",
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        color = Color.White,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 26.sp,
                                        textAlign = TextAlign.Center
                                    )
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.CenterHorizontally)
                                        .padding(vertical = 16.dp),
                                    text = "Don’t make mistakes or you’ll fail!",
                                    style = TextStyle(
                                        fontFamily = Montserrat,
                                        color = AccentStrong,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center,
                                    )
                                )
                                Box(modifier = Modifier.padding(top = 120.dp, bottom = 24.dp)){
                                    SButton(
                                        text = "TAKE TEST",
                                        colors = listOf(
                                            Color(0xFFFBA818),
                                            Color(0xFFFEDE00)
                                        ),
                                        onClick = {
                                            // Go to the right quiz.
                                        }
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun IntroductionHeader(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) { // Top Image with car text
        val painter = painterResource(R.drawable.la_ferrari)

        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painter,
            contentScale = ContentScale.FillWidth,
            contentDescription = "car_picture"
        )
        Box(
            modifier = Modifier
                .height(3.dp)
                .fillMaxWidth()
                .background(AccentLight)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-26).dp),
            text = "Ferrari LaFerrari",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                color = Color.White,
                shadow = Shadow(
                    color = Color(0xFF000000),
                    blurRadius = 16f
                ),
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun Paragraph(
    title: String,
    content: String
){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        text = title,
        style = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            color = Color.White
        )
    )
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = content,
        style = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )
    )
}

@Composable
fun ParagraphDivider(
    size: Dp
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(size))
}



