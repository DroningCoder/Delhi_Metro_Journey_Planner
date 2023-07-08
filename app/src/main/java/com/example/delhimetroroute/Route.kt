package com.example.delhimetroroute

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.PriorityQueue

class RouteAndFair : AppCompatActivity() {

    fun make_map(stationToNumber : MutableMap<String,Int>, numberToStation : MutableMap<Int,String>, stationToLine : MutableMap<String,Char>) {

        var stationList = arrayListOf<String>(

            "SHAHEED STHAL(NEW BUS ADDA)",
            "HINDON RIVER",
            "ARTHALA",
            "MOHAN NAGAR",
            "SHYAM PARK",
            "MAJOR MOHIT SHARMA RAJENDRA NAGAR",
            "RAJ BAGH",
            "SHAHEED NAGAR",
            "DILSHAD GARDEN",
            "JHILMIL",
            "MANSAROVAR PARK",
            "SHAHDARA",
            "WELCOME",
            "SEELAMPUR",
            "SHASTRI PARK",
            "KASHMERE GATE",
            "TIS HAZARI",
            "PULBANGASH",
            "PRATAP NAGAR",
            "SHASTRI NAGAR",
            "INDERLOK",
            "KANHAIYA NAGAR",
            "KESHAV PURAM",
            "NETAJI SUBHASH PLACE",
            "KOHAT ENCLAVE",
            "PITAMPURA",
            "ROHINI EAST",
            "ROHINI WEST",
            "RITHALA",
            "SAMAYPUR BADLI",
            "ROHINI SECTOR - 18, 19",
            "HAIDERPUR BADLI MOR",
            "JAHANGIRPURI",
            "ADARSH NAGAR",
            "AZADPUR",
            "MODEL TOWN",
            "GURU TEG BAHADUR NAGAR",
            "VISWAVIDYALAYA",
            "VIDHAN SABHA",
            "CIVIL LINES",
            "CHANDNI CHOWK",
            "CHAWRI BAZAR",
            "NEW DELHI",
            "RAJIV CHOWK",
            "PATEL CHOWK",
            "CENTRAL SECRETARIAT",
            "UDYOG BHAWAN",
            "LOK KALYAN MARG",
            "JORBAGH",
            "DILLI HAAT - INA",
            "AIIMS",
            "GREEN PARK",
            "HAUZ KHAS",
            "MALVIYA NAGAR",
            "SAKET",
            "QUTAB MINAR",
            "CHHATARPUR",
            "SULTANPUR",
            "GHITORNI",
            "ARJAN GARH",
            "GURU DRONACHARYA",
            "SIKANDERPUR",
            "MG ROAD",
            "IFFCO CHOWK",
            "HUDA CITY CENTRE",
            "DWARKA SECTOR - 21",
            "DWARKA SECTOR - 8",
            "DWARKA SECTOR - 9",
            "DWARKA SECTOR - 10",
            "DWARKA SECTOR - 11",
            "DWARKA SECTOR - 12",
            "DWARKA SECTOR - 13",
            "DWARKA SECTOR - 14",
            "DWARKA",
            "DWARKA MOR",
            "NAWADA",
            "UTTAM NAGAR WEST",
            "UTTAM NAGAR EAST",
            "JANAK PURI WEST",
            "JANAK PURI EAST",
            "TILAK NAGAR",
            "SUBHASH NAGAR",
            "TAGORE GARDEN",
            "RAJOURI GARDEN",
            "RAMESH NAGAR",
            "MOTI NAGAR",
            "KIRTI NAGAR",
            "SHADIPUR",
            "PATEL NAGAR",
            "RAJENDRA PLACE",
            "KAROL BAGH",
            "JHANDEWALAN",
            "RK ASHRAM MARG",
            "BARAKHAMBA ROAD",
            "MANDI HOUSE",
            "SUPREME COURT",
            "INDRAPRASTHA",
            "YAMUNA BANK",
            "AKSHARDHAM",
            "MAYUR VIHAR -I",
            "MAYUR VIHAR EXTENSION",
            "NEW ASHOK NAGAR",
            "NOIDA SECTOR-15",
            "NOIDA SECTOR-16",
            "NOIDA SECTOR-18",
            "BOTANICAL GARDEN",
            "GOLF COURSE",
            "NOIDA CITY CENTRE",
            "SECTOR - 34 NOIDA",
            "SECTOR - 52 NOIDA",
            "SECTOR - 61 NOIDA",
            "SECTOR - 59 NOIDA",
            "SECTOR - 62 NOIDA",
            "NOIDA ELECTRONIC CITY",
            "LAXMI NAGAR",
            "NIRMAN VIHAR",
            "PREET VIHAR",
            "KARKARDUMA",
            "ANAND VIHAR ISBT",
            "KAUSHAMBI",
            "VAISHALI",
            "SATGURU RAM SINGH MARG",
            "ASHOK PARK MAIN",
            "PUNJABI BAGH",
            "SHIVAJI PARK",
            "MADIPUR",
            "PASCHIM VIHAR EAST",
            "PASCHIM VIHAR WEST",
            "PEERAGARHI",
            "UDYOG NAGAR",
            "MAHARAJA SURAJMAL STADIUM",
            "NANGLOI",
            "NANGLOI RAILWAY STATION",
            "RAJDHANI PARK",
            "MUNDKA",
            "MUNDKA INDUSTRIAL AREA (MIA)",
            "GHEVRA METRO STATION",
            "TIKRI KALAN",
            "TIKRI BORDER",
            "PANDIT SHREE RAM SHARMA",
            "BAHADURGARH CITY",
            "BRIGADIER HOSHIAR SINGH",
            "LAL QUILA",
            "JAMA MASJID",
            "DELHI GATE",
            "ITO",
            "JANPATH",
            "KHAN MARKET",
            "JLN STADIUM",
            "JANGPURA",
            "LAJPAT NAGAR",
            "MOOLCHAND",
            "KAILASH COLONY",
            "NEHRU PLACE",
            "KALKAJI MANDIR",
            "GOVINDPURI",
            "HARKESH NAGAR OKHLA",
            "JASOLA APOLLO",
            "SARITA VIHAR",
            "MOHAN ESTATE",
            "TUGHLAKABAD STATION",
            "BADARPUR BORDER",
            "SARAI",
            "NHPC CHOWK",
            "MEWALA MAHARAJPUR",
            "SECTOR-28",
            "BADKAL MOR",
            "OLD FARIDABAD",
            "NEELAM CHOWK AJRONDA",
            "BATA CHOWK",
            "ESCORTS MUJESAR",
            "SANT SURDAS",
            "RAJA NAHAR SINGH (BALLABHGARH)",
            "MAJLIS PARK",
            "SHALIMAR BAGH",
            "SHAKURPUR",
            "PUNJABI BAGH WEST",
            "ESI-BASAIDARAPUR",
            "MAYAPURI",
            "NARAINA VIHAR",
            "DELHI CANTT.",
            "DURGABAI DESHMUKH SOUTH CAMPUS",
            "SIR M. VISHWESHWARAIAH MOTI BAGH",
            "BHIKAJI CAMA PLACE",
            "SAROJINI NAGAR",
            "SOUTH EXTENSION",
            "VINOBAPURI",
            "ASHRAM",
            "SARAI KALE KHAN - NIZAMUDDIN",
            "MAYUR VIHAR POCKET-1",
            "TRILOKPURI-SANJAY LAKE",
            "EAST VINOD NAGAR-MAYUR VIHAR -II",
            "MANDAWALI - WEST VINOD NAGAR",
            "I.P. EXTENSION",
            "KARKARDUMA COURT",
            "KRISHNA NAGAR",
            "EAST AZAD NAGAR",
            "JAFRABAD",
            "MAUJPUR-BABARPUR",
            "GOKULPURI",
            "JOHRI ENCLAVE",
            "SHIV VIHAR",
            "DABRI MOR - JANAKPURI SOUTH",
            "DASHRATHPURI",
            "PALAM",
            "SADAR BAZAR CANTONMENT",
            "TERMINAL 1-IGI AIRPORT",
            "SHANKAR VIHAR",
            "VASANT VIHAR",
            "MUNIRKA",
            "R.K.PURAM",
            "IIT",
            "PANCHSHEEL PARK",
            "CHIRAG DELHI",
            "GREATER KAILASH",
            "NEHRU ENCLAVE",
            "OKHLA NSIC",
            "SUKHDEV VIHAR",
            "JAMIA MILIA ISLAMIYA",
            "OKHLA VIHAR",
            "JASOLA VIHAR SHAHEEN BAGH",
            "KALINDI KUNJ",
            "OKHLA BIRD SANCTUARY",
            "NANGLI",
            "NAJAFGARH",
            "DHANSA BUS STAND",
            "SHIVAJI STADIUM",
            "DHAULA KUAN",
            "DELHI AEROCITY",
            "AIRPORT (T-3)",
            "SECTOR 55, 56",
            "SECTOR - 54 CHOWK",
            "SECTOR - 53, 54",
            "SECTOR - 42, 43",
            "PHASE - 1",
            "PHASE - 2",
            "BELVEDERE TOWERS",
            "CYBER CITY",
            "MOULSARI AVENUE",
            "PHASE - 3",
            "SECTOR 51",
            "SECTOR 76",
            "SECTOR 101",
            "SECTOR 81",
            "NSEZ",
            "SECTOR 83",
            "SECTOR 137",
            "SECTOR 142",
            "SECTOR 143",
            "SECTOR 144",
            "SECTOR 145",
            "SECTOR 146",
            "SECTOR 147",
            "SECTOR 148",
            "KNOWLEDGE PARK II",
            "PARI CHOWK",
            "ALPHA 1",
            "DELTA 1",
            "GNIDA OFFICE",
            "DEPOT STATION",
        )

        for(i in 0 until 260){
            stationToNumber[stationList[i]] = i
            numberToStation[i] = stationList[i]
        }

        for(i in 0..28){
            stationToLine[stationList[i]] = 'R'
        }

        for(i in 29..64){
            stationToLine[stationList[i]] = 'Y'
        }

        for(i in 65..120){
            stationToLine[stationList[i]] = 'B'
        }

        for(i in 121..141){
            stationToLine[stationList[i]] = 'G'
        }

        for(i in 142..172){
            stationToLine[stationList[i]] = 'V'
        }

        for(i in 173..201){
            stationToLine[stationList[i]] = 'P'
        }

        for(i in 202..222){
            stationToLine[stationList[i]] = 'M'
        }

        for(i in 223..225){
            stationToLine[stationList[i]] = 'S'
        }

        for(i in 226..229){
            stationToLine[stationList[i]] = 'O'
        }

        for(i in 230..239){
            stationToLine[stationList[i]] = 'C'
        }

        for(i in 240..259){
            stationToLine[stationList[i]] = 'A'
        }
    }

    fun make_adj(adj : MutableList<MutableList<IntArray>>){

        for(i in 0 until 263){
            adj.add(mutableListOf())
        }

        // RED LINE

        adj[0].add(intArrayOf(1,2,0))
        adj[1].add(intArrayOf(0,2,0))
        adj[1].add(intArrayOf(2,2,0))
        adj[2].add(intArrayOf(1,2,0))
        adj[2].add(intArrayOf(3,2,0))
        adj[3].add(intArrayOf(2,2,0))
        adj[3].add(intArrayOf(4,2,0))
        adj[4].add(intArrayOf(3,2,0))
        adj[4].add(intArrayOf(5,2,0))
        adj[5].add(intArrayOf(4,2,0))
        adj[5].add(intArrayOf(6,2,0))
        adj[6].add(intArrayOf(5,2,0))
        adj[6].add(intArrayOf(7,2,0))
        adj[7].add(intArrayOf(6,2,0))
        adj[7].add(intArrayOf(8,2,0))
        adj[8].add(intArrayOf(7,2,0))
        adj[8].add(intArrayOf(9,2,0))
        adj[9].add(intArrayOf(8,2,0))
        adj[9].add(intArrayOf(10,2,0))
        adj[10].add(intArrayOf(9,2,0))
        adj[10].add(intArrayOf(11,2,0))
        adj[11].add(intArrayOf(10,2,0))
        adj[11].add(intArrayOf(12,2,0))
        adj[12].add(intArrayOf(11,2,0))
        adj[12].add(intArrayOf(13,2,0))
        adj[13].add(intArrayOf(12,2,0))
        adj[13].add(intArrayOf(14,2,0))
        adj[14].add(intArrayOf(13,2,0))
        adj[14].add(intArrayOf(15,2,0))
        adj[15].add(intArrayOf(14,2,0))
        adj[15].add(intArrayOf(16,2,0))
        adj[16].add(intArrayOf(15,2,0))
        adj[16].add(intArrayOf(17,2,0))
        adj[17].add(intArrayOf(16,2,0))
        adj[17].add(intArrayOf(18,2,0))
        adj[22].add(intArrayOf(21,2,0))
        adj[22].add(intArrayOf(23,2,0))
        adj[23].add(intArrayOf(22,2,0))
        adj[23].add(intArrayOf(24,2,0))
        adj[24].add(intArrayOf(23,2,0))
        adj[24].add(intArrayOf(25,2,0))
        adj[25].add(intArrayOf(24,2,0))
        adj[25].add(intArrayOf(26,2,0))
        adj[26].add(intArrayOf(25,2,0))
        adj[26].add(intArrayOf(27,2,0))
        adj[27].add(intArrayOf(26,2,0))
        adj[27].add(intArrayOf(28,2,0))
        adj[28].add(intArrayOf(27,2,0))

        //YELLOW LINE

        adj[29].add(intArrayOf(30,2,1))
        adj[30].add(intArrayOf(29,2,1))
        adj[30].add(intArrayOf(31,2,1))
        adj[31].add(intArrayOf(30,2,1))
        adj[31].add(intArrayOf(32,2,1))
        adj[32].add(intArrayOf(31,2,1))
        adj[32].add(intArrayOf(33,2,1))
        adj[33].add(intArrayOf(32,2,1))
        adj[33].add(intArrayOf(34,2,1))
        adj[34].add(intArrayOf(33,2,1))
        adj[34].add(intArrayOf(35,2,1))
        adj[35].add(intArrayOf(34,2,1))
        adj[35].add(intArrayOf(36,2,1))
        adj[36].add(intArrayOf(35,2,1))
        adj[36].add(intArrayOf(37,2,1))
        adj[37].add(intArrayOf(36,2,1))
        adj[37].add(intArrayOf(38,2,1))
        adj[38].add(intArrayOf(37,2,1))
        adj[38].add(intArrayOf(39,2,1))
        adj[39].add(intArrayOf(38,2,1))
        adj[39].add(intArrayOf(15,2,1))
        adj[15].add(intArrayOf(39,2,1))
        adj[40].add(intArrayOf(15,2,1))
        adj[15].add(intArrayOf(40,2,1))
        adj[40].add(intArrayOf(41,2,1))
        adj[41].add(intArrayOf(40,2,1))
        adj[41].add(intArrayOf(42,2,1))
        adj[42].add(intArrayOf(41,2,1))
        adj[42].add(intArrayOf(43,2,1))
        adj[43].add(intArrayOf(42,2,1))
        adj[43].add(intArrayOf(44,2,1))
        adj[44].add(intArrayOf(43,2,1))
        adj[44].add(intArrayOf(45,2,1))
        adj[45].add(intArrayOf(44,2,1))
        adj[45].add(intArrayOf(46,2,1))
        adj[46].add(intArrayOf(45,2,1))
        adj[46].add(intArrayOf(47,2,1))
        adj[47].add(intArrayOf(46,2,1))
        adj[47].add(intArrayOf(48,2,1))
        adj[48].add(intArrayOf(47,2,1))
        adj[48].add(intArrayOf(49,2,1))
        adj[49].add(intArrayOf(48,2,1))
        adj[49].add(intArrayOf(50,2,1))
        adj[50].add(intArrayOf(49,2,1))
        adj[50].add(intArrayOf(51,2,1))
        adj[51].add(intArrayOf(50,2,1))
        adj[51].add(intArrayOf(52,2,1))
        adj[52].add(intArrayOf(51,2,1))
        adj[52].add(intArrayOf(53,2,1))
        adj[53].add(intArrayOf(52,2,1))
        adj[53].add(intArrayOf(54,2,1))
        adj[54].add(intArrayOf(53,2,1))
        adj[54].add(intArrayOf(55,2,1))
        adj[55].add(intArrayOf(54,2,1))
        adj[55].add(intArrayOf(56,2,1))
        adj[56].add(intArrayOf(55,2,1))
        adj[56].add(intArrayOf(57,2,1))
        adj[57].add(intArrayOf(56,2,1))
        adj[57].add(intArrayOf(58,2,1))
        adj[58].add(intArrayOf(57,2,1))
        adj[58].add(intArrayOf(59,2,1))
        adj[59].add(intArrayOf(58,2,1))
        adj[59].add(intArrayOf(60,2,1))
        adj[60].add(intArrayOf(59,2,1))
        adj[60].add(intArrayOf(61,2,1))
        adj[61].add(intArrayOf(60,2,1))
        adj[61].add(intArrayOf(62,2,1))
        adj[62].add(intArrayOf(61,2,1))
        adj[62].add(intArrayOf(63,2,1))
        adj[63].add(intArrayOf(62,2,1))
        adj[63].add(intArrayOf(64,2,1))
        adj[64].add(intArrayOf(63,2,1))

        //BLUE LINE

        adj[65].add(intArrayOf(66,2,2))
        adj[66].add(intArrayOf(65,2,2))
        adj[66].add(intArrayOf(67,2,2))
        adj[67].add(intArrayOf(66,2,2))
        adj[67].add(intArrayOf(68,2,2))
        adj[68].add(intArrayOf(67,2,2))
        adj[68].add(intArrayOf(69,2,2))
        adj[69].add(intArrayOf(68,2,2))
        adj[69].add(intArrayOf(70,2,2))
        adj[70].add(intArrayOf(69,2,2))
        adj[70].add(intArrayOf(71,2,2))
        adj[71].add(intArrayOf(70,2,2))
        adj[71].add(intArrayOf(72,2,2))
        adj[72].add(intArrayOf(71,2,2))
        adj[72].add(intArrayOf(73,2,2))
        adj[73].add(intArrayOf(72,2,2))
        adj[73].add(intArrayOf(74,2,2))
        adj[74].add(intArrayOf(73,2,2))
        adj[74].add(intArrayOf(75,2,2))
        adj[75].add(intArrayOf(74,2,2))
        adj[75].add(intArrayOf(76,2,2))
        adj[76].add(intArrayOf(75,2,2))
        adj[76].add(intArrayOf(77,2,2))
        adj[77].add(intArrayOf(76,2,2))
        adj[77].add(intArrayOf(78,2,2))
        adj[78].add(intArrayOf(77,2,2))
        adj[78].add(intArrayOf(79,2,2))
        adj[79].add(intArrayOf(78,2,2))
        adj[79].add(intArrayOf(80,2,2))
        adj[80].add(intArrayOf(79,2,2))
        adj[80].add(intArrayOf(81,2,2))
        adj[81].add(intArrayOf(80,2,2))
        adj[81].add(intArrayOf(82,2,2))
        adj[82].add(intArrayOf(81,2,2))
        adj[82].add(intArrayOf(83,2,2))
        adj[83].add(intArrayOf(82,2,2))
        adj[83].add(intArrayOf(84,2,2))
        adj[84].add(intArrayOf(83,2,2))
        adj[84].add(intArrayOf(85,2,2))
        adj[85].add(intArrayOf(84,2,2))
        adj[85].add(intArrayOf(86,2,2))
        adj[86].add(intArrayOf(85,2,2))
        adj[86].add(intArrayOf(87,2,2))
        adj[87].add(intArrayOf(86,2,2))
        adj[87].add(intArrayOf(88,2,2))
        adj[88].add(intArrayOf(87,2,2))
        adj[88].add(intArrayOf(89,2,2))
        adj[89].add(intArrayOf(88,2,2))
        adj[89].add(intArrayOf(90,2,2))
        adj[90].add(intArrayOf(89,2,2))
        adj[90].add(intArrayOf(91,2,2))
        adj[91].add(intArrayOf(90,2,2))
        adj[91].add(intArrayOf(92,2,2))
        adj[92].add(intArrayOf(91,2,2))
        adj[92].add(intArrayOf(43,2,2))
        adj[43].add(intArrayOf(92,2,2))
        adj[93].add(intArrayOf(43,2,2))
        adj[43].add(intArrayOf(93,2,2))
        adj[93].add(intArrayOf(94,2,2))
        adj[94].add(intArrayOf(93,2,2))
        adj[94].add(intArrayOf(95,2,2))
        adj[95].add(intArrayOf(94,2,2))
        adj[95].add(intArrayOf(96,2,2))
        adj[96].add(intArrayOf(95,2,2))
        adj[96].add(intArrayOf(97,2,2))
        adj[97].add(intArrayOf(96,2,2))
        adj[97].add(intArrayOf(114,2,2))
        adj[114].add(intArrayOf(97,2,2))
        adj[114].add(intArrayOf(115,2,2))
        adj[115].add(intArrayOf(114,2,2))
        adj[115].add(intArrayOf(116,2,2))
        adj[116].add(intArrayOf(115,2,2))
        adj[116].add(intArrayOf(117,2,2))
        adj[117].add(intArrayOf(116,2,2))
        adj[117].add(intArrayOf(118,2,2))
        adj[118].add(intArrayOf(117,2,2))
        adj[118].add(intArrayOf(119,2,2))
        adj[119].add(intArrayOf(118,2,2))
        adj[119].add(intArrayOf(120,2,2))
        adj[120].add(intArrayOf(119,2,2))
        adj[97].add(intArrayOf(98,2,2))
        adj[98].add(intArrayOf(97,2,2))
        adj[98].add(intArrayOf(99,2,2))
        adj[99].add(intArrayOf(98,2,2))
        adj[99].add(intArrayOf(100,2,2))
        adj[100].add(intArrayOf(99,2,2))
        adj[100].add(intArrayOf(101,2,2))
        adj[101].add(intArrayOf(100,2,2))
        adj[101].add(intArrayOf(102,2,2))
        adj[102].add(intArrayOf(101,2,2))
        adj[102].add(intArrayOf(103,2,2))
        adj[103].add(intArrayOf(102,2,2))
        adj[103].add(intArrayOf(104,2,2))
        adj[104].add(intArrayOf(103,2,2))
        adj[104].add(intArrayOf(105,2,2))
        adj[105].add(intArrayOf(104,2,2))
        adj[105].add(intArrayOf(106,2,2))
        adj[106].add(intArrayOf(105,2,2))
        adj[106].add(intArrayOf(107,2,2))
        adj[107].add(intArrayOf(106,2,2))
        adj[107].add(intArrayOf(108,2,2))
        adj[108].add(intArrayOf(107,2,2))
        adj[108].add(intArrayOf(109,2,2))
        adj[109].add(intArrayOf(108,2,2))
        adj[109].add(intArrayOf(110,2,2))
        adj[110].add(intArrayOf(109,2,2))
        adj[110].add(intArrayOf(111,2,2))
        adj[111].add(intArrayOf(110,2,2))
        adj[111].add(intArrayOf(112,2,2))
        adj[112].add(intArrayOf(111,2,2))
        adj[112].add(intArrayOf(113,2,2))
        adj[113].add(intArrayOf(112,2,2))

        //GREEN LINE

        adj[86].add(intArrayOf(121,2,3))
        adj[121].add(intArrayOf(86,2,3))
        adj[121].add(intArrayOf(122,2,3))
        adj[122].add(intArrayOf(121,2,3))
        adj[122].add(intArrayOf(123,2,3))
        adj[122].add(intArrayOf(20,2,3))
        adj[20].add(intArrayOf(122,2,3))
        adj[123].add(intArrayOf(122,2,3))
        adj[123].add(intArrayOf(124,2,3))
        adj[124].add(intArrayOf(123,2,3))
        adj[124].add(intArrayOf(125,2,3))
        adj[125].add(intArrayOf(124,2,3))
        adj[125].add(intArrayOf(126,2,3))
        adj[126].add(intArrayOf(125,2,3))
        adj[126].add(intArrayOf(127,2,3))
        adj[127].add(intArrayOf(126,2,3))
        adj[127].add(intArrayOf(128,2,3))
        adj[128].add(intArrayOf(127,2,3))
        adj[128].add(intArrayOf(129,2,3))
        adj[129].add(intArrayOf(128,2,3))
        adj[129].add(intArrayOf(130,2,3))
        adj[130].add(intArrayOf(129,2,3))
        adj[130].add(intArrayOf(131,2,3))
        adj[131].add(intArrayOf(130,2,3))
        adj[131].add(intArrayOf(132,2,3))
        adj[132].add(intArrayOf(131,2,3))
        adj[132].add(intArrayOf(133,2,3))
        adj[133].add(intArrayOf(132,2,3))
        adj[133].add(intArrayOf(134,2,3))
        adj[134].add(intArrayOf(133,2,3))
        adj[134].add(intArrayOf(135,2,3))
        adj[135].add(intArrayOf(134,2,3))
        adj[135].add(intArrayOf(136,2,3))
        adj[136].add(intArrayOf(135,2,3))
        adj[136].add(intArrayOf(137,2,3))
        adj[137].add(intArrayOf(136,2,3))
        adj[137].add(intArrayOf(138,2,3))
        adj[138].add(intArrayOf(137,2,3))
        adj[138].add(intArrayOf(139,2,3))
        adj[139].add(intArrayOf(138,2,3))
        adj[139].add(intArrayOf(140,2,3))
        adj[140].add(intArrayOf(139,2,3))
        adj[140].add(intArrayOf(141,2,3))
        adj[141].add(intArrayOf(140,2,3))

        //VIOLET LINE

        adj[142].add(intArrayOf(15,2,4))
        adj[15].add(intArrayOf(142,2,4))
        adj[142].add(intArrayOf(143,2,4))
        adj[143].add(intArrayOf(142,2,4))
        adj[143].add(intArrayOf(144,2,4))
        adj[144].add(intArrayOf(143,2,4))
        adj[144].add(intArrayOf(145,2,4))
        adj[145].add(intArrayOf(144,2,4))
        adj[145].add(intArrayOf(94,2,4))
        adj[94].add(intArrayOf(145,2,4))
        adj[146].add(intArrayOf(94,2,4))
        adj[94].add(intArrayOf(146,2,4))
        adj[146].add(intArrayOf(45,2,4))
        adj[45].add(intArrayOf(146,2,4))
        adj[147].add(intArrayOf(45,2,4))
        adj[45].add(intArrayOf(147,2,4))
        adj[147].add(intArrayOf(148,2,4))
        adj[148].add(intArrayOf(147,2,4))
        adj[148].add(intArrayOf(149,2,4))
        adj[149].add(intArrayOf(148,2,4))
        adj[149].add(intArrayOf(150,2,4))
        adj[150].add(intArrayOf(149,2,4))
        adj[150].add(intArrayOf(151,2,4))
        adj[151].add(intArrayOf(150,2,4))
        adj[151].add(intArrayOf(152,2,4))
        adj[152].add(intArrayOf(151,2,4))
        adj[152].add(intArrayOf(153,2,4))
        adj[153].add(intArrayOf(152,2,4))
        adj[153].add(intArrayOf(154,2,4))
        adj[154].add(intArrayOf(153,2,4))
        adj[154].add(intArrayOf(155,2,4))
        adj[155].add(intArrayOf(154,2,4))
        adj[155].add(intArrayOf(156,2,4))
        adj[156].add(intArrayOf(155,2,4))
        adj[156].add(intArrayOf(157,2,4))
        adj[157].add(intArrayOf(156,2,4))
        adj[157].add(intArrayOf(158,2,4))
        adj[158].add(intArrayOf(157,2,4))
        adj[158].add(intArrayOf(159,2,4))
        adj[159].add(intArrayOf(158,2,4))
        adj[159].add(intArrayOf(160,2,4))
        adj[160].add(intArrayOf(159,2,4))
        adj[160].add(intArrayOf(161,2,4))
        adj[161].add(intArrayOf(160,2,4))
        adj[161].add(intArrayOf(162,2,4))
        adj[162].add(intArrayOf(161,2,4))
        adj[162].add(intArrayOf(163,2,4))
        adj[163].add(intArrayOf(162,2,4))
        adj[163].add(intArrayOf(164,2,4))
        adj[164].add(intArrayOf(163,2,4))
        adj[164].add(intArrayOf(165,2,4))
        adj[165].add(intArrayOf(164,2,4))
        adj[165].add(intArrayOf(166,2,4))
        adj[166].add(intArrayOf(165,2,4))
        adj[166].add(intArrayOf(167,2,4))
        adj[167].add(intArrayOf(166,2,4))
        adj[167].add(intArrayOf(168,2,4))
        adj[168].add(intArrayOf(167,2,4))
        adj[168].add(intArrayOf(169,2,4))
        adj[169].add(intArrayOf(168,2,4))
        adj[169].add(intArrayOf(170,2,4))
        adj[170].add(intArrayOf(169,2,4))
        adj[170].add(intArrayOf(171,2,4))
        adj[171].add(intArrayOf(170,2,4))
        adj[171].add(intArrayOf(172,2,4))
        adj[172].add(intArrayOf(171,2,4))

        //PINK LINE

        adj[173].add(intArrayOf(34,2,5))
        adj[34].add(intArrayOf(173,2,5))
        adj[34].add(intArrayOf(174,2,5))
        adj[174].add(intArrayOf(34,2,5))
        adj[23].add(intArrayOf(174,2,5))
        adj[174].add(intArrayOf(23,2,5))
        adj[23].add(intArrayOf(175,2,5))
        adj[175].add(intArrayOf(23,2,5))
        adj[175].add(intArrayOf(176,2,5))
        adj[176].add(intArrayOf(175,2,5))
        adj[176].add(intArrayOf(177,2,5))
        adj[177].add(intArrayOf(176,2,5))
        adj[177].add(intArrayOf(83,2,5))
        adj[83].add(intArrayOf(177,2,5))
        adj[178].add(intArrayOf(83,2,5))
        adj[83].add(intArrayOf(178,2,5))
        adj[178].add(intArrayOf(179,2,5))
        adj[179].add(intArrayOf(178,2,5))
        adj[179].add(intArrayOf(180,2,5))
        adj[180].add(intArrayOf(179,2,5))
        adj[180].add(intArrayOf(181,2,5))
        adj[181].add(intArrayOf(180,2,5))
        adj[181].add(intArrayOf(182,2,5))
        adj[182].add(intArrayOf(181,2,5))
        adj[182].add(intArrayOf(183,2,5))
        adj[183].add(intArrayOf(182,2,5))
        adj[183].add(intArrayOf(184,2,5))
        adj[184].add(intArrayOf(183,2,5))
        adj[184].add(intArrayOf(49,2,5))
        adj[49].add(intArrayOf(184,2,5))
        adj[49].add(intArrayOf(185,2,5))
        adj[185].add(intArrayOf(49,2,5))
        adj[185].add(intArrayOf(150,2,5))
        adj[150].add(intArrayOf(185,2,5))
        adj[186].add(intArrayOf(150,2,5))
        adj[150].add(intArrayOf(186,2,5))
        adj[186].add(intArrayOf(187,2,5))
        adj[187].add(intArrayOf(186,2,5))
        adj[187].add(intArrayOf(188,2,5))
        adj[188].add(intArrayOf(187,2,5))
        adj[188].add(intArrayOf(99,2,5))
        adj[99].add(intArrayOf(188,2,5))
        adj[99].add(intArrayOf(189,2,5))
        adj[189].add(intArrayOf(99,2,5))
        adj[189].add(intArrayOf(190,2,5))
        adj[190].add(intArrayOf(189,2,5))
        adj[190].add(intArrayOf(191,2,5))
        adj[191].add(intArrayOf(190,2,5))
        adj[191].add(intArrayOf(192,2,5))
        adj[192].add(intArrayOf(191,2,5))
        adj[192].add(intArrayOf(193,2,5))
        adj[193].add(intArrayOf(192,2,5))
        adj[193].add(intArrayOf(118,2,5))
        adj[118].add(intArrayOf(193,2,5))
        adj[118].add(intArrayOf(117,2,5))
        adj[194].add(intArrayOf(117,2,5))
        adj[117].add(intArrayOf(194,2,5))
        adj[117].add(intArrayOf(194,2,5))
        adj[194].add(intArrayOf(195,2,5))
        adj[195].add(intArrayOf(194,2,5))
        adj[195].add(intArrayOf(196,2,5))
        adj[196].add(intArrayOf(195,2,5))
        adj[196].add(intArrayOf(12,2,5))
        adj[12].add(intArrayOf(196,2,5))
        adj[12].add(intArrayOf(197,2,5))
        adj[197].add(intArrayOf(12,2,5))
        adj[197].add(intArrayOf(198,2,5))
        adj[198].add(intArrayOf(197,2,5))
        adj[198].add(intArrayOf(199,2,5))
        adj[199].add(intArrayOf(198,2,5))
        adj[199].add(intArrayOf(200,2,5))
        adj[200].add(intArrayOf(199,2,5))
        adj[200].add(intArrayOf(201,2,5))
        adj[201].add(intArrayOf(200,2,5))

        //MAGENTA LINE

        adj[78].add(intArrayOf(202,2,6))
        adj[202].add(intArrayOf(78,2,6))
        adj[202].add(intArrayOf(203,2,6))
        adj[203].add(intArrayOf(202,2,6))
        adj[203].add(intArrayOf(204,2,6))
        adj[204].add(intArrayOf(203,2,6))
        adj[204].add(intArrayOf(205,2,6))
        adj[205].add(intArrayOf(204,2,6))
        adj[205].add(intArrayOf(206,2,6))
        adj[206].add(intArrayOf(205,2,6))
        adj[206].add(intArrayOf(207,2,6))
        adj[207].add(intArrayOf(206,2,6))
        adj[207].add(intArrayOf(208,2,6))
        adj[208].add(intArrayOf(207,2,6))
        adj[208].add(intArrayOf(209,2,6))
        adj[209].add(intArrayOf(208,2,6))
        adj[209].add(intArrayOf(210,2,6))
        adj[210].add(intArrayOf(209,2,6))
        adj[210].add(intArrayOf(211,2,6))
        adj[211].add(intArrayOf(210,2,6))
        adj[211].add(intArrayOf(52,2,6))
        adj[52].add(intArrayOf(211,2,6))
        adj[52].add(intArrayOf(212,2,6))
        adj[212].add(intArrayOf(52,2,6))
        adj[212].add(intArrayOf(213,2,6))
        adj[213].add(intArrayOf(212,2,6))
        adj[213].add(intArrayOf(214,2,6))
        adj[214].add(intArrayOf(213,2,6))
        adj[214].add(intArrayOf(215,2,6))
        adj[215].add(intArrayOf(214,2,6))
        adj[215].add(intArrayOf(154,2,6))
        adj[154].add(intArrayOf(215,2,6))
        adj[154].add(intArrayOf(216,2,6))
        adj[216].add(intArrayOf(154,2,6))
        adj[216].add(intArrayOf(217,2,6))
        adj[217].add(intArrayOf(216,2,6))
        adj[217].add(intArrayOf(218,2,6))
        adj[218].add(intArrayOf(217,2,6))
        adj[218].add(intArrayOf(219,2,6))
        adj[219].add(intArrayOf(218,2,6))
        adj[219].add(intArrayOf(220,2,6))
        adj[220].add(intArrayOf(219,2,6))
        adj[220].add(intArrayOf(221,2,6))
        adj[221].add(intArrayOf(220,2,6))
        adj[221].add(intArrayOf(222,2,6))
        adj[222].add(intArrayOf(221,2,6))
        adj[222].add(intArrayOf(105,2,6))
        adj[105].add(intArrayOf(222,2,6))

        //ORANGE LINE

        adj[42].add(intArrayOf(226,3,7))
        adj[226].add(intArrayOf(42,3,7))
        adj[226].add(intArrayOf(227,6,7))
        adj[227].add(intArrayOf(226,6,7))
        adj[227].add(intArrayOf(181,0,7))
        adj[181].add(intArrayOf(227,0,7))
        adj[227].add(intArrayOf(228,6,7))
        adj[228].add(intArrayOf(227,6,7))
        adj[228].add(intArrayOf(229,4,7))
        adj[229].add(intArrayOf(228,4,7))
        adj[229].add(intArrayOf(65,3,7))
        adj[65].add(intArrayOf(229,3,7))

        //RAPID METRO

        adj[230].add(intArrayOf(231,2,8))
        adj[231].add(intArrayOf(230,2,8))
        adj[231].add(intArrayOf(232,2,8))
        adj[232].add(intArrayOf(231,2,8))
        adj[232].add(intArrayOf(233,2,8))
        adj[233].add(intArrayOf(232,2,8))
        adj[233].add(intArrayOf(234,2,8))
        adj[234].add(intArrayOf(233,2,8))
        adj[234].add(intArrayOf(61,2,8))
        adj[61].add(intArrayOf(234,2,8))
        adj[61].add(intArrayOf(235,2,8))
        adj[235].add(intArrayOf(61,2,8))
        adj[235].add(intArrayOf(236,2,8))
        adj[236].add(intArrayOf(237,2,8))
        adj[237].add(intArrayOf(238,2,8))
        adj[238].add(intArrayOf(239,2,8))
        adj[239].add(intArrayOf(235,2,8))

        //AQUA LINE

        adj[109].add(intArrayOf(240,2,9))
        adj[240].add(intArrayOf(109,2,9))
        adj[240].add(intArrayOf(241,2,9))
        adj[241].add(intArrayOf(240,2,9))
        adj[241].add(intArrayOf(242,2,9))
        adj[242].add(intArrayOf(241,2,9))
        adj[242].add(intArrayOf(243,2,9))
        adj[243].add(intArrayOf(242,2,9))
        adj[243].add(intArrayOf(244,2,9))
        adj[244].add(intArrayOf(243,2,9))
        adj[244].add(intArrayOf(245,2,9))
        adj[245].add(intArrayOf(244,2,9))
        adj[245].add(intArrayOf(246,2,9))
        adj[246].add(intArrayOf(245,2,9))
        adj[246].add(intArrayOf(247,2,9))
        adj[247].add(intArrayOf(246,2,9))
        adj[247].add(intArrayOf(248,2,9))
        adj[248].add(intArrayOf(247,2,9))
        adj[248].add(intArrayOf(249,2,9))
        adj[249].add(intArrayOf(248,2,9))
        adj[249].add(intArrayOf(250,2,9))
        adj[250].add(intArrayOf(249,2,9))
        adj[250].add(intArrayOf(251,2,9))
        adj[251].add(intArrayOf(250,2,9))
        adj[251].add(intArrayOf(252,2,9))
        adj[252].add(intArrayOf(251,2,9))
        adj[252].add(intArrayOf(253,2,9))
        adj[253].add(intArrayOf(252,2,9))
        adj[253].add(intArrayOf(254,2,9))
        adj[254].add(intArrayOf(253,2,9))
        adj[254].add(intArrayOf(255,2,9))
        adj[255].add(intArrayOf(254,2,9))
        adj[255].add(intArrayOf(256,2,9))
        adj[256].add(intArrayOf(255,2,9))
        adj[256].add(intArrayOf(257,2,9))
        adj[257].add(intArrayOf(256,2,9))
        adj[257].add(intArrayOf(258,2,9))
        adj[258].add(intArrayOf(257,2,9))
        adj[258].add(intArrayOf(259,2,9))
        adj[259].add(intArrayOf(258,2,9))

        //GREY LINE

        adj[73].add(intArrayOf(223,2,10))
        adj[223].add(intArrayOf(73,2,10))
        adj[224].add(intArrayOf(223,2,10))
        adj[224].add(intArrayOf(225,2,10))
        adj[225].add(intArrayOf(224,2,10))

    }

    fun makeInterChangeMap(interchanges : MutableMap<Int,Int>){

        for(i in 0 until 260){
            interchanges[i]=0
        }

        interchanges[12]=5
        interchanges[15]=6
        interchanges[20]=5
        interchanges[23]=10
        interchanges[34]=10
        interchanges[42]=10
        interchanges[43]=5
        interchanges[45]=5
        interchanges[49]=10
        interchanges[52]=10
        interchanges[61]=10
        interchanges[78]=5
        interchanges[83]=10
        interchanges[86]=5
        interchanges[94]=5
        interchanges[99]=5
        interchanges[105]=5
        interchanges[117]=5
        interchanges[118]=5
        interchanges[65]=3
        interchanges[227]=12
        interchanges[181]=12
        interchanges[150]=5
        interchanges[154]=10
        interchanges[227]=13
        interchanges[109]=10
        interchanges[73]=4
    }


    fun shortestPathDijkstra(src : Int, dest : Int, adj : MutableList<MutableList<IntArray>>
                             ,numberToStation : MutableMap<Int,String>,interchanges: MutableMap<Int, Int>) : MutableList<String>{

        var distance = mutableListOf<Int>()
        var parent = mutableListOf<Int>()

        for(i in 0 until 260){
            distance.add(Int.MAX_VALUE)
            parent.add(-1)
        }

        distance[src] = 0

        val compare : Comparator<Pair<Int,Pair<Int,Int>>> = compareBy { it.first }
        var pq = PriorityQueue<Pair<Int,Pair<Int,Int>>>(compare)

        pq.add(Pair(0,Pair(src,-1)))

        while(!pq.isEmpty()){

            var f = pq.first()
            var node = f.second.first
            var dist = f.first
            var line = f.second.second
            var newDist = 0
            pq.remove(f)

            //break as soon as shortest path to destination is found

            if(node == dest){
                break
            }

            for(i in 0 until adj[node].size){

                var changeLine = 0

                if(line != adj[node][i][2]){
                    newDist = distance[node]+adj[node][i][1] + interchanges[node]!!
                    changeLine = 1
                }

                else newDist = distance[node]+adj[node][i][1]

                if(newDist < distance[adj[node][i][0]]){

                    distance[adj[node][i][0]] = newDist
                    parent[adj[node][i][0]] = node
                    if(changeLine == 0)pq.add(Pair(newDist, Pair(adj[node][i][0], line)))
                    else pq.add(Pair(newDist, Pair(adj[node][i][0], adj[node][i][2])))
                }
            }
        }

        var route = mutableListOf<String>()

        var i = dest
        numberToStation[dest]?.let { route.add(it) }

        while(i != src){
            route.add(numberToStation[parent[i]]!!)
            i=parent[i]
        }
        route.reverse()

        return route
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route)

        //receiving source and destination from main activity

        val src = intent.extras!!.getString("src_key")
        val dest = intent.extras!!.getString("dest_key")

        //create stationToNumber, numberToStation and stationToLine maps

        val stationToNumber = mutableMapOf<String,Int>()
        val numberToStation = mutableMapOf<Int,String>()
        val stationToLine = mutableMapOf<String,Char>()

        make_map(stationToNumber, numberToStation, stationToLine)

        val fromText = findViewById<TextView>(R.id.from_text)
        fromText.setText(src)

        val toText = findViewById<TextView>(R.id.to_text)
        toText.setText(dest)

        val interchangeAvTime = mutableMapOf<Int,Int>()
        makeInterChangeMap(interchangeAvTime)

        //creating adj of type list of list of list of integers

        var adj = mutableListOf<MutableList<IntArray>>()

        make_adj(adj)

        val s = stationToNumber[src]
        val d = stationToNumber[dest]

        //calling Dijkstra

        val shortestRoute = shortestPathDijkstra(s!!,d!!,adj,numberToStation,interchangeAvTime)

        val noOfStationsText = findViewById<TextView>(R.id.no)
        noOfStationsText.setText(shortestRoute.size.toString())

        //creating list of MyData class items for custom list view

        val listData = mutableListOf<MyData>()

        for(i in 0 until shortestRoute.size){

            if(shortestRoute[i] == "KASHMERE GATE")listData.add(MyData(R.drawable.redyellowviolet, shortestRoute[i]))
            else if(shortestRoute[i] == "WELCOME")listData.add(MyData(R.drawable.redpink, shortestRoute[i]))
            else if(shortestRoute[i] == "INDERLOK")listData.add(MyData(R.drawable.redgreen, shortestRoute[i]))
            else if(shortestRoute[i] == "NETAJI SUBHASH PLACE")listData.add(MyData(R.drawable.redpink, shortestRoute[i]))
            else if(shortestRoute[i] == "AZADPUR")listData.add(MyData(R.drawable.yellowpink, shortestRoute[i]))
            else if(shortestRoute[i] == "NEW DELHI")listData.add(MyData(R.drawable.yelloworange, shortestRoute[i]))
            else if(shortestRoute[i] == "RAJIV CHOWK")listData.add(MyData(R.drawable.blueyellow, shortestRoute[i]))
            else if(shortestRoute[i] == "CENTRAL SECRETARIAT")listData.add(MyData(R.drawable.violetyellow, shortestRoute[i]))
            else if(shortestRoute[i] == "DILLI HAAT - INA")listData.add(MyData(R.drawable.yellowpink, shortestRoute[i]))
            else if(shortestRoute[i] == "HAUZ KHAS")listData.add(MyData(R.drawable.magentayellow, shortestRoute[i]))
            else if(shortestRoute[i] == "SIKANDERPUR")listData.add(MyData(R.drawable.yellowrapid, shortestRoute[i]))
            else if(shortestRoute[i] == "DWARKA SECTOR - 21")listData.add(MyData(R.drawable.blueorange, shortestRoute[i]))
            else if(shortestRoute[i] == "JANAK PURI WEST")listData.add(MyData(R.drawable.bluemagenta, shortestRoute[i]))
            else if(shortestRoute[i] == "RAJOURI GARDEN")listData.add(MyData(R.drawable.bluepink, shortestRoute[i]))
            else if(shortestRoute[i] == "KIRTI NAGAR")listData.add(MyData(R.drawable.bluegreen, shortestRoute[i]))
            else if(shortestRoute[i] == "MANDI HOUSE")listData.add(MyData(R.drawable.blueviolet, shortestRoute[i]))
            else if(shortestRoute[i] == "KARKARDUMA")listData.add(MyData(R.drawable.bluepink, shortestRoute[i]))
            else if(shortestRoute[i] == "ANAND VIHAR ISBT")listData.add(MyData(R.drawable.bluepink, shortestRoute[i]))
            else if(shortestRoute[i] == "LAJPAT NAGAR")listData.add(MyData(R.drawable.violetpink, shortestRoute[i]))
            else if(shortestRoute[i] == "KALKAJI MANDIR")listData.add(MyData(R.drawable.violetpink, shortestRoute[i]))
            else if(shortestRoute[i] == "BOTANICAL GARDEN")listData.add(MyData(R.drawable.bluemagenta, shortestRoute[i]))
            else if(shortestRoute[i] == "SECTOR 51")listData.add(MyData(R.drawable.blueaqua, shortestRoute[i]))
            else if(shortestRoute[i] == "MAYUR VIHAR -I")listData.add(MyData(R.drawable.bluepink, shortestRoute[i]))
            else if(shortestRoute[i] == "MAYUR VIHAR -I")listData.add(MyData(R.drawable.bluepink, shortestRoute[i]))

            else if(stationToLine[shortestRoute[i]] == 'R')listData.add(MyData(R.drawable.red, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'B')listData.add(MyData(R.drawable.blue, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'G')listData.add(MyData(R.drawable.green, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'V')listData.add(MyData(R.drawable.violet, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'M')listData.add(MyData(R.drawable.magenta, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'O')listData.add(MyData(R.drawable.orange, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'Y')listData.add(MyData(R.drawable.yellow, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'S')listData.add(MyData(R.drawable.grey, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'A')listData.add(MyData(R.drawable.aqua, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'C')listData.add(MyData(R.drawable.rapid, shortestRoute[i]))
            else if(stationToLine[shortestRoute[i]] == 'P')listData.add(MyData(R.drawable.pink, shortestRoute[i]))
        }

        val mylist = findViewById<ListView>(R.id.mylistview)
        mylist.adapter = MyCustomAdapter(this, listData)
    }
}

