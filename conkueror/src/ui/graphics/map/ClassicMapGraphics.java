package ui.graphics.map;

import util.CoreUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class ClassicMapGraphics {

    public static Shape transformShape(Path2D.Double path) {
        double scale = MapGraphicsDefault.getScale();
        AffineTransform transform = new AffineTransform();
        transform.scale(scale, scale);
        return path.createTransformedShape(transform);
    }

    public enum TerritoryShape {

        Alaska (createAlaska(), 7, 50),
        Greenland (createGreenland(), 272, 7),
        Northwest (createNorthwest(), 78, 36),
        Alberta (createAlberta(), 78, 93),
        Ontario (createOntario(), 156, 97),
        Quebec (createQuebec(), 227, 93),
        WesternAmerica (createWesternAmerica(), 62, 156),
        EasternAmerica (createEasternAmerica(), 111, 156),
        CentralAmerica (createCentralAmerica(), 58, 227),
        Venezuela (createVenezuela(), 113, 317),
        Peru (createPeru(), 100, 368),
        Brazil (createBrazil(), 132, 351),
        Argentina (createArgentina(), 95, 461),
        Indonesia (createIndonesia(), 779, 411),
        NewGuinea (createNewGuinea(), 943, 408),
        EasternAustralia (createEasternAustralia(), 942, 496),
        WesternAustralia (createWesternAustralia(), 873, 516),
        NorthAfrica (createNorthAfrica(), 363, 298),
        Egypt (createEgypt(), 480, 318),
        EastAfrica (createEastAfrica(), 533, 376),
        Congo (createCongo(), 466, 425),
        SouthAfrica (createSouthAfrica(), 466, 504),
        Madagascar (createMadagascar(), 630, 517),
        Russia (createRussia(), 650, 4),
        Mongolia (createMongolia(), 635, 145),
        Japan (createJapan(), 937, 134),
        China (createChina(), 730, 155),
        India (createIndia(), 688, 235),
        SouthernEurope (createSouthernEurope(), 452, 210),
        Anatolia (createAnatolia(), 495, 192),
        MiddleEast (createMiddleEast(), 537, 245),
        Siam (createSiam(), 808, 289),
        GreatBritain (createGreatBritain(), 346, 123),
        Iceland (createIceland(), 392, 75),
        Scandinavia (createScandinavia(), 465, 55),
        NorthernEurope (createNorthernEurope(), 452, 144),
        WesternEurope (createWesternEurope(), 372, 196),
        EasternEurope (createEasternEurope(), 527, 55),
        Persia (createPersia(), 589, 187);

        private final String name;
        private final Shape shape;
        private final int x;
        private final int y;

        TerritoryShape(Shape shape, int x, int y) {
            name = CoreUtils.separateOnCapital(this);
            this.shape = shape;
            this.x = x;
            this.y = y;
        }

        public String getName() {
            return name;
        }

        public Shape getShape() {
            return shape;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    public enum OutlineShape {

        NorthAmerica (createNorthAmericaOutline(), 1, 38),
        Greenland (createGreenlandOutline(), 266, 5),
        SouthAmerica (createSouthAmericaOutline(), 95, 315),
        Britain (createBritainOutline(), 345, 118),
        Iceland (createIcelandOutline(), 392, 80),
        Europe (createEuropeOutline(), 372, 61),
        Asia (createAsiaOutline(), 534, 10),
        Japan (createJapanOutline(), 934, 140),
        Africa (createAfricaOutline(), 358, 297),
        Madagascar (createMadagascarOutline(), 626, 512),
        Indonesia (createIndonesiaOutline(), 775, 412),
        NewGuinea (createNewGuineaOutline(), 939, 408),
        Oceania (createOceaniaOutline(), 868, 497);

        private final Shape shape;
        private final int x;
        private final int y;

        OutlineShape (Shape shape, int x, int y) {
            this.shape = shape;
            this.x = x;
            this.y = y;
        }

        public Shape getShape() {
            return shape;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    public static Shape createSouthAmericaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(48.5974, 30.0937);
        path.lineTo(48.5974, 22.7059);
        path.lineTo(75.7979, 13.3032);
        path.lineTo(80.4992, 9.60935);
        path.lineTo(89.566, 8.26611);
        path.lineTo(109.043, 16.9971);
        path.lineTo(119.453, 14.9823);
        path.lineTo(142.288, 31.7727);
        path.lineTo(163.108, 36.1382);
        path.lineTo(171.839, 42.8544);
        path.lineTo(181.913, 63.3387);
        path.lineTo(195.346, 67.7042);
        path.lineTo(198.368, 72.0697);
        path.lineTo(211.464, 72.0697);
        path.lineTo(233.292, 83.1514);
        path.lineTo(237.658, 101.621);
        path.lineTo(230.606, 109.009);
        path.lineTo(221.203, 111.023);
        path.lineTo(213.479, 122.441);
        path.lineTo(208.442, 151.32);
        path.lineTo(202.398, 152.664);
        path.lineTo(186.615, 175.163);
        path.lineTo(163.108, 179.864);
        path.lineTo(151.355, 208.744);
        path.lineTo(142.624, 216.131);
        path.lineTo(133.221, 230.235);
        path.lineTo(125.162, 238.631);
        path.lineTo(110.386, 245.683);
        path.lineTo(107.364, 253.742);
        path.lineTo(99.9761, 260.458);
        path.lineTo(79.8276, 264.152);
        path.lineTo(65.3878, 293.032);
        path.lineTo(52.6271, 306.128);
        path.lineTo(50.9481, 344.41);
        path.lineTo(64.0446, 357.843);
        path.lineTo(64.0446, 363.551);
        path.lineTo(74.4547, 363.551);
        path.lineTo(74.4547, 369.26);
        path.lineTo(54.3062, 375.305);
        path.lineTo(20.0537, 344.41);
        path.lineTo(7.9646, 314.188);
        path.lineTo(21.3969, 278.592);
        path.lineTo(22.7402, 258.108);
        path.lineTo(30.128, 252.063);
        path.lineTo(34.8293, 213.781);
        path.lineTo(42.5529, 197.662);
        path.lineTo(42.5529, 185.237);
        path.lineTo(51.6197, 152.664);
        path.lineTo(45.5751, 152.664);
        path.lineTo(44.2319, 143.933);
        path.lineTo(25.7624, 128.821);
        path.lineTo(22.7402, 115.725);
        path.lineTo(15.6882, 107.665);
        path.lineTo(12.6659, 94.2331);
        path.lineTo(17.3672, 82.144);
        path.lineTo(15.6882, 75.4278);
        path.lineTo(25.7624, 59.6448);
        path.lineTo(30.7996, 56.2867);
        path.lineTo(32.4786, 45.205);
        path.lineTo(48.5974, 30.0937);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createGreenlandOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(68, 14);
        path.lineTo(53, 14);
        path.lineTo(38, 26);
        path.lineTo(29, 29);
        path.lineTo(17, 37);
        path.lineTo(17, 43);
        path.lineTo(11, 46);
        path.lineTo(15, 50);
        path.lineTo(29, 50);
        path.lineTo(36, 49);
        path.lineTo(43, 53);
        path.lineTo(44, 57);
        path.lineTo(50, 62);
        path.lineTo(46, 71);
        path.lineTo(55, 76);
        path.lineTo(47, 83);
        path.lineTo(47, 98);
        path.lineTo(52, 98);
        path.lineTo(64, 117);
        path.lineTo(71, 114);
        path.lineTo(78, 105);
        path.lineTo(78, 90);
        path.lineTo(108, 78);
        path.lineTo(112, 74);
        path.lineTo(122, 71);
        path.lineTo(126, 67);
        path.lineTo(130, 67);
        path.lineTo(133, 55);
        path.lineTo(141, 49);
        path.lineTo(141, 40);
        path.lineTo(136, 34);
        path.lineTo(137, 28);
        path.lineTo(145, 25);
        path.lineTo(137, 18);
        path.lineTo(122, 14);
        path.lineTo(121, 10);
        path.lineTo(92, 7);
        path.lineTo(68, 14);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createNorthAmericaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(29, 41);
        path.lineTo(42, 27);
        path.lineTo(55, 21);
        path.lineTo(81, 21);
        path.lineTo(90, 28);
        path.lineTo(102, 27);
        path.lineTo(113, 33);
        path.lineTo(128, 29);
        path.lineTo(131, 24);
        path.lineTo(148, 24);
        path.lineTo(174, 39);
        path.lineTo(194, 33);
        path.lineTo(212, 33);
        path.lineTo(218, 29);
        path.lineTo(218, 23);
        path.lineTo(231, 11);
        path.lineTo(237, 8);
        path.lineTo(244, 8);
        path.lineTo(240, 18);
        path.lineTo(231, 23);
        path.lineTo(232, 29);
        path.lineTo(240, 31);
        path.lineTo(255, 31);
        path.lineTo(252, 40);
        path.lineTo(243, 44);
        path.lineTo(236, 51);
        path.lineTo(227, 51);
        path.lineTo(204, 68);
        path.lineTo(200, 84);
        path.lineTo(210, 92);
        path.lineTo(221, 89);
        path.lineTo(232, 88);
        path.lineTo(236, 96);
        path.lineTo(227, 101);
        path.lineTo(228, 108);
        path.lineTo(225, 112);
        path.lineTo(232, 119);
        path.lineTo(240, 106);
        path.lineTo(240, 103);
        path.lineTo(248, 98);
        path.lineTo(252, 89);
        path.lineTo(250, 80);
        path.lineTo(261, 74);
        path.lineTo(259, 65);
        path.lineTo(272, 66);
        path.lineTo(281, 78);
        path.lineTo(283, 85);
        path.lineTo(292, 79);
        path.lineTo(297, 79);
        path.lineTo(300, 89);
        path.lineTo(298, 95);
        path.lineTo(315, 101);
        path.lineTo(313, 104);
        path.lineTo(316, 106);
        path.lineTo(313, 113);
        path.lineTo(303, 116);
        path.lineTo(303, 119);
        path.lineTo(294, 125);
        path.lineTo(284, 127);
        path.lineTo(279, 125);
        path.lineTo(267, 132);
        path.lineTo(279, 135);
        path.lineTo(289, 144);
        path.lineTo(285, 153);
        path.lineTo(277, 156);
        path.lineTo(274, 162);
        path.lineTo(266, 166);
        path.lineTo(261, 165);
        path.lineTo(251, 165);
        path.lineTo(249, 174);
        path.lineTo(244, 179);
        path.lineTo(228, 185);
        path.lineTo(226, 194);
        path.lineTo(210, 209);
        path.lineTo(210, 216);
        path.lineTo(204, 235);
        path.lineTo(196, 238);
        path.lineTo(190, 235);
        path.lineTo(191, 227);
        path.lineTo(185, 219);
        path.lineTo(166, 215);
        path.lineTo(133, 220);
        path.lineTo(128, 229);
        path.lineTo(114, 235);
        path.lineTo(113, 247);
        path.lineTo(122, 257);
        path.lineTo(131, 256);
        path.lineTo(135, 249);
        path.lineTo(149, 249);
        path.lineTo(137, 261);
        path.lineTo(139, 265);
        path.lineTo(128, 284);
        path.lineTo(131, 289);
        path.lineTo(127, 307);
        path.lineTo(119, 308);
        path.lineTo(110, 302);
        path.lineTo(99, 273);
        path.lineTo(78, 264);
        path.lineTo(78, 254);
        path.lineTo(67, 249);
        path.lineTo(61, 234);
        path.lineTo(65, 223);
        path.lineTo(63, 209);
        path.lineTo(68, 199);
        path.lineTo(68, 192);
        path.lineTo(65, 183);
        path.lineTo(70, 161);
        path.lineTo(86, 137);
        path.lineTo(88, 127);
        path.lineTo(88, 116);
        path.lineTo(81, 101);
        path.lineTo(73, 81);
        path.lineTo(65, 73);
        path.lineTo(44, 75);
        path.lineTo(32, 82);
        path.lineTo(29, 73);
        path.lineTo(18, 73);
        path.lineTo(10, 64);
        path.lineTo(18, 54);
        path.lineTo(24, 51);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createEuropeOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(271, 13);
        path.lineTo(281, 16);
        path.lineTo(287, 31);
        path.lineTo(297, 37);
        path.lineTo(297, 49);
        path.lineTo(301, 70);
        path.lineTo(310, 74);
        path.lineTo(313, 85);
        path.lineTo(313, 96);
        path.lineTo(303, 107);
        path.lineTo(289, 113);
        path.lineTo(272, 109);
        path.lineTo(259, 131);
        path.lineTo(259, 149);
        path.lineTo(264, 153);
        path.lineTo(266, 165);
        path.lineTo(276, 176);
        path.lineTo(276, 184);
        path.lineTo(271, 191);
        path.lineTo(256, 198);
        path.lineTo(240, 191);
        path.lineTo(239, 188);
        path.lineTo(230, 182);
        path.lineTo(220, 192);
        path.lineTo(213, 192);
        path.lineTo(203, 200);
        path.lineTo(185, 202);
        path.lineTo(184, 212);
        path.lineTo(172, 230);
        path.lineTo(166, 235);
        path.lineTo(168, 238);
        path.lineTo(169, 244);
        path.lineTo(166, 248);
        path.lineTo(163, 248);
        path.lineTo(153, 244);
        path.lineTo(151, 239);
        path.lineTo(150, 230);
        path.lineTo(149, 228);
        path.lineTo(150, 226);
        path.lineTo(142, 216);
        path.lineTo(142, 212);
        path.lineTo(130, 202);
        path.lineTo(122, 205);
        path.lineTo(135, 220);
        path.lineTo(134, 230);
        path.lineTo(129, 227);
        path.lineTo(129, 234);
        path.lineTo(116, 242);
        path.lineTo(112, 233);
        path.lineTo(116, 227);
        path.lineTo(104, 215);
        path.lineTo(101, 208);
        path.lineTo(98, 208);
        path.lineTo(90, 214);
        path.lineTo(82, 211);
        path.lineTo(75, 223);
        path.lineTo(71, 223);
        path.lineTo(72, 238);
        path.lineTo(62, 256);
        path.lineTo(54, 254);
        path.lineTo(38, 263);
        path.lineTo(15, 258);
        path.lineTo(8, 243);
        path.lineTo(17, 223);
        path.lineTo(14, 213);
        path.lineTo(20, 201);
        path.lineTo(31, 203);
        path.lineTo(44, 202);
        path.lineTo(49, 188);
        path.lineTo(32, 174);
        path.lineTo(48, 167);
        path.lineTo(54, 169);
        path.lineTo(58, 163);
        path.lineTo(73, 163);
        path.lineTo(73, 160);
        path.lineTo(82, 148);
        path.lineTo(87, 150);
        path.lineTo(92, 132);
        path.lineTo(101, 132);
        path.lineTo(110, 115);
        path.lineTo(110, 109);
        path.lineTo(104, 103);
        path.lineTo(123, 96);
        path.lineTo(132, 103);
        path.lineTo(157, 100);
        path.lineTo(164, 102);
        path.lineTo(162, 94);
        path.lineTo(170, 83);
        path.lineTo(174, 80);
        path.lineTo(187, 73);
        path.lineTo(183, 72);
        path.lineTo(168, 75);
        path.lineTo(165, 59);
        path.lineTo(162, 56);
        path.lineTo(158, 60);
        path.lineTo(163, 74);
        path.lineTo(158, 88);
        path.lineTo(150, 91);
        path.lineTo(145, 98);
        path.lineTo(128, 96);
        path.lineTo(124, 93);
        path.lineTo(116, 93);
        path.lineTo(108, 77);
        path.lineTo(107, 72);
        path.lineTo(101, 67);
        path.lineTo(119, 46);
        path.lineTo(134, 43);
        path.lineTo(143, 24);
        path.lineTo(176, 7);
        path.lineTo(198, 7);
        path.lineTo(224, 7);
        path.lineTo(237, 18);
        path.lineTo(230, 24);
        path.lineTo(214, 29);
        path.lineTo(214, 37);
        path.lineTo(224, 43);
        path.lineTo(248, 16);
        path.lineTo(261, 16);
        path.lineTo(271, 13);
        path.closePath();
        return transformShape(path);
    }
    public static Shape createIceland() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(18, 10);
        path.lineTo(25, 7);
        path.lineTo(30, 12);
        path.lineTo(34, 4);
        path.lineTo(44, 8);
        path.lineTo(59, 1);
        path.lineTo(73, 11);
        path.lineTo(73, 29);
        path.lineTo(57, 38);
        path.lineTo(45, 38);
        path.lineTo(32, 51);
        path.lineTo(21, 43);
        path.lineTo(7, 43);
        path.lineTo(9, 37);
        path.lineTo(1, 31);
        path.lineTo(4, 17);
        path.lineTo(10, 10);
        path.lineTo(18, 10);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createBritainOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(46, 86);
        path.lineTo(30, 87);
        path.lineTo(32, 75);
        path.lineTo(22, 75);
        path.lineTo(16, 79);
        path.lineTo(7, 76);
        path.lineTo(7, 68);
        path.lineTo(16, 62);
        path.lineTo(13, 61);
        path.lineTo(14, 50);
        path.lineTo(25, 44);
        path.lineTo(33, 47);
        path.lineTo(41, 54);
        path.lineTo(45, 49);
        path.lineTo(43, 44);
        path.lineTo(38, 39);
        path.lineTo(32, 22);
        path.lineTo(42, 15);
        path.lineTo(46, 8);
        path.lineTo(59, 11);
        path.lineTo(67, 21);
        path.lineTo(64, 33);
        path.lineTo(78, 44);
        path.lineTo(80, 54);
        path.lineTo(85, 54);
        path.lineTo(94, 58);
        path.lineTo(90, 68);
        path.lineTo(85, 71);
        path.lineTo(77, 83);
        path.lineTo(49, 86);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createIcelandOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(25, 18);
        path.lineTo(33, 15);
        path.lineTo(37, 21);
        path.lineTo(41, 13);
        path.lineTo(52, 17);
        path.lineTo(67, 9);
        path.lineTo(80, 19);
        path.lineTo(80, 38);
        path.lineTo(64, 47);
        path.lineTo(53, 47);
        path.lineTo(40, 59);
        path.lineTo(29, 52);
        path.lineTo(15, 52);
        path.lineTo(17, 46);
        path.lineTo(9, 40);
        path.lineTo(12, 25);
        path.lineTo(18, 18);
        path.lineTo(25, 18);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createAsiaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(423, 110);
        path.lineTo(416, 139);
        path.lineTo(401, 129);
        path.lineTo(393, 110);
        path.lineTo(398, 96);
        path.lineTo(384, 86);
        path.lineTo(377, 93);
        path.lineTo(384, 100);
        path.lineTo(375, 103);
        path.lineTo(354, 96);
        path.lineTo(352, 115);
        path.lineTo(370, 117);
        path.lineTo(382, 124);
        path.lineTo(388, 152);
        path.lineTo(372, 193);
        path.lineTo(388, 207);
        path.lineTo(388, 225);
        path.lineTo(380, 225);
        path.lineTo(377, 214);
        path.lineTo(370, 216);
        path.lineTo(358, 208);
        path.lineTo(361, 227);
        path.lineTo(383, 259);
        path.lineTo(379, 288);
        path.lineTo(353, 326);
        path.lineTo(344, 314);
        path.lineTo(336, 314);
        path.lineTo(336, 328);
        path.lineTo(358, 344);
        path.lineTo(368, 363);
        path.lineTo(364, 378);
        path.lineTo(348, 394);
        path.lineTo(332, 369);
        path.lineTo(319, 369);
        path.lineTo(331, 399);
        path.lineTo(323, 409);
        path.lineTo(311, 398);
        path.lineTo(302, 369);
        path.lineTo(287, 366);
        path.lineTo(278, 323);
        path.lineTo(273, 323);
        path.lineTo(262, 330);
        path.lineTo(250, 366);
        path.lineTo(255, 382);
        path.lineTo(238, 402);
        path.lineTo(209, 360);
        path.lineTo(205, 347);
        path.lineTo(197, 339);
        path.lineTo(197, 328);
        path.lineTo(175, 316);
        path.lineTo(164, 328);
        path.lineTo(149, 326);
        path.lineTo(132, 312);
        path.lineTo(125, 318);
        path.lineTo(136, 328);
        path.lineTo(143, 342);
        path.lineTo(158, 336);
        path.lineTo(171, 352);
        path.lineTo(157, 390);
        path.lineTo(126, 403);
        path.lineTo(109, 395);
        path.lineTo(106, 385);
        path.lineTo(78, 371);
        path.lineTo(51, 320);
        path.lineTo(57, 316);
        path.lineTo(56, 293);
        path.lineTo(51, 297);
        path.lineTo(22, 298);
        path.lineTo(15, 292);
        path.lineTo(7, 277);
        path.lineTo(21, 252);
        path.lineTo(29, 255);
        path.lineTo(38, 253);
        path.lineTo(45, 247);
        path.lineTo(62, 257);
        path.lineTo(74, 252);
        path.lineTo(84, 251);
        path.lineTo(89, 257);
        path.lineTo(108, 248);
        path.lineTo(127, 257);
        path.lineTo(132, 253);
        path.lineTo(135, 242);
        path.lineTo(124, 235);
        path.lineTo(124, 223);
        path.lineTo(112, 210);
        path.lineTo(109, 199);
        path.lineTo(103, 186);
        path.lineTo(109, 166);
        path.lineTo(124, 158);
        path.lineTo(140, 159);
        path.lineTo(143, 152);
        path.lineTo(151, 148);
        path.lineTo(155, 131);
        path.lineTo(148, 116);
        path.lineTo(140, 112);
        path.lineTo(138, 99);
        path.lineTo(151, 89);
        path.lineTo(124, 75);
        path.lineTo(120, 55);
        path.lineTo(138, 34);
        path.lineTo(158, 37);
        path.lineTo(154, 49);
        path.lineTo(163, 64);
        path.lineTo(175, 67);
        path.lineTo(175, 60);
        path.lineTo(167, 55);
        path.lineTo(167, 44);
        path.lineTo(172, 43);
        path.lineTo(171, 37);
        path.lineTo(179, 26);
        path.lineTo(189, 15);
        path.lineTo(232, 7);
        path.lineTo(241, 15);
        path.lineTo(253, 18);
        path.lineTo(253, 23);
        path.lineTo(272, 23);
        path.lineTo(278, 18);
        path.lineTo(290, 22);
        path.lineTo(292, 28);
        path.lineTo(305, 31);
        path.lineTo(326, 26);
        path.lineTo(342, 28);
        path.lineTo(349, 36);
        path.lineTo(358, 31);
        path.lineTo(384, 38);
        path.lineTo(393, 33);
        path.lineTo(447, 47);
        path.lineTo(455, 68);
        path.lineTo(447, 74);
        path.lineTo(436, 76);
        path.lineTo(426, 93);
        path.lineTo(414, 93);
        path.lineTo(414, 100);
        path.lineTo(423, 110);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createJapanOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(29, 21);
        path.lineTo(29, 11);
        path.lineTo(44, 13);
        path.lineTo(56, 9);
        path.lineTo(63, 19);
        path.lineTo(53, 25);
        path.lineTo(49, 35);
        path.lineTo(56, 42);
        path.lineTo(58, 61);
        path.lineTo(63, 67);
        path.lineTo(61, 78);
        path.lineTo(44, 85);
        path.lineTo(46, 91);
        path.lineTo(38, 96);
        path.lineTo(29, 96);
        path.lineTo(31, 106);
        path.lineTo(17, 115);
        path.lineTo(9, 103);
        path.lineTo(13, 98);
        path.lineTo(10, 89);
        path.lineTo(19, 75);
        path.lineTo(27, 75);
        path.lineTo(24, 57);
        path.lineTo(36, 55);
        path.lineTo(29, 46);
        path.lineTo(29, 37);
        path.lineTo(24, 25);
        path.lineTo(29, 21);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createAfricaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(47, 23);
        path.lineTo(65, 18);
        path.lineTo(72, 22);
        path.lineTo(109, 7);
        path.lineTo(125, 7);
        path.lineTo(141, 27);
        path.lineTo(149, 29);
        path.lineTo(160, 36);
        path.lineTo(182, 30);
        path.lineTo(192, 38);
        path.lineTo(225, 41);
        path.lineTo(234, 55);
        path.lineTo(232, 65);
        path.lineTo(241, 72);
        path.lineTo(241, 85);
        path.lineTo(271, 126);
        path.lineTo(271, 135);
        path.lineTo(303, 140);
        path.lineTo(296, 174);
        path.lineTo(267, 212);
        path.lineTo(259, 216);
        path.lineTo(253, 233);
        path.lineTo(260, 242);
        path.lineTo(263, 272);
        path.lineTo(247, 295);
        path.lineTo(240, 301);
        path.lineTo(240, 319);
        path.lineTo(223, 341);
        path.lineTo(217, 352);
        path.lineTo(188, 372);
        path.lineTo(151, 388);
        path.lineTo(137, 372);
        path.lineTo(135, 336);
        path.lineTo(131, 332);
        path.lineTo(129, 308);
        path.lineTo(112, 279);
        path.lineTo(124, 256);
        path.lineTo(122, 236);
        path.lineTo(128, 229);
        path.lineTo(126, 219);
        path.lineTo(112, 199);
        path.lineTo(117, 173);
        path.lineTo(107, 171);
        path.lineTo(100, 165);
        path.lineTo(84, 165);
        path.lineTo(75, 168);
        path.lineTo(50, 168);
        path.lineTo(10, 119);
        path.lineTo(21, 108);
        path.lineTo(22, 89);
        path.lineTo(19, 82);
        path.lineTo(49, 29);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createMadagascarOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(16, 75);
        path.lineTo(18, 64);
        path.lineTo(48, 55);
        path.lineTo(71, 16);
        path.lineTo(82, 42);
        path.lineTo(74, 53);
        path.lineTo(76, 58);
        path.lineTo(67, 100);
        path.lineTo(54, 116);
        path.lineTo(48, 137);
        path.lineTo(20, 151);
        path.lineTo(8, 111);
        path.lineTo(16, 105);
        path.lineTo(18, 90);
        path.lineTo(16, 75);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createOceaniaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(45.0534, 65.7389);
        path.lineTo(58.5438, 46.3259);
        path.lineTo(67.4277, 42.0485);
        path.lineTo(76.9696, 28.2291);
        path.lineTo(96.0536, 11.7774);
        path.lineTo(107.57, 7.5);
        path.lineTo(123.363, 8.4871);
        path.lineTo(133.892, 20.0033);
        path.lineTo(153.305, 24.9388);
        path.lineTo(170.086, 23.2936);
        path.lineTo(179.957, 31.5194);
        path.lineTo(186.538, 57.8421);
        path.lineTo(195.093, 61.1324);
        path.lineTo(220.757, 103.249);
        path.lineTo(220.757, 148.984);
        path.lineTo(213.189, 157.868);
        path.lineTo(208.583, 193.075);
        path.lineTo(195.093, 203.275);
        path.lineTo(163.505, 203.275);
        path.lineTo(146.067, 187.152);
        path.lineTo(144.092, 175.307);
        path.lineTo(137.841, 168.397);
        path.lineTo(130.931, 168.397);
        path.lineTo(121.389, 153.92);
        path.lineTo(105.596, 148.984);
        path.lineTo(88.4858, 157.868);
        path.lineTo(90.131, 168.397);
        path.lineTo(37.1566, 183.862);
        path.lineTo(21.363, 168.397);
        path.lineTo(15.7694, 137.139);
        path.lineTo(8.20166, 113.449);
        path.lineTo(13.7952, 100.616);
        path.lineTo(11.163, 78.5712);
        path.lineTo(31.563, 63.7647);
        path.lineTo(45.0534, 65.7389);
        path.closePath();
        return transformShape(path);
    }
    public static Shape createIndia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(1, 41);
        path.lineTo(6, 26);
        path.lineTo(25, 17);
        path.lineTo(44, 12);
        path.lineTo(49, 5);
        path.lineTo(58, 1);
        path.lineTo(69, 8);
        path.lineTo(73, 23);
        path.lineTo(73, 30);
        path.lineTo(89, 42);
        path.lineTo(102, 44);
        path.lineTo(123, 52);
        path.lineTo(133, 60);
        path.lineTo(121, 87);
        path.lineTo(117, 87);
        path.lineTo(106, 94);
        path.lineTo(93, 130);
        path.lineTo(97, 147);
        path.lineTo(82, 165);
        path.lineTo(53, 123);
        path.lineTo(49, 111);
        path.lineTo(40, 103);
        path.lineTo(40, 91);
        path.lineTo(18, 80);
        path.lineTo(17, 64);
        path.lineTo(1, 41);
        path.closePath();
        return transformShape(path);
    }
    public static Shape createIndonesia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(2, 33);
        path.lineTo(6, 13);
        path.lineTo(27, 18);
        path.lineTo(58, 38);
        path.lineTo(60, 54);
        path.lineTo(68, 63);
        path.lineTo(75, 78);
        path.lineTo(65, 94);
        path.lineTo(51, 94);
        path.lineTo(36, 68);
        path.lineTo(23, 56);
        path.lineTo(21, 48);
        path.lineTo(2, 33);
        path.closePath();
        path.moveTo(112, 4);
        path.lineTo(97, 1);
        path.lineTo(85, 10);
        path.lineTo(88, 18);
        path.lineTo(78, 26);
        path.lineTo(67, 31);
        path.lineTo(67, 48);
        path.lineTo(74, 62);
        path.lineTo(83, 74);
        path.lineTo(100, 74);
        path.lineTo(107, 68);
        path.lineTo(110, 57);
        path.lineTo(107, 48);
        path.lineTo(109, 31);
        path.lineTo(118, 19);
        path.lineTo(112, 4);
        path.closePath();
        path.moveTo(141, 49);
        path.lineTo(149, 32);
        path.lineTo(135, 27);
        path.lineTo(129, 37);
        path.lineTo(113, 42);
        path.lineTo(115, 55);
        path.lineTo(111, 69);
        path.lineTo(121, 82);
        path.lineTo(135, 87);
        path.lineTo(141, 64);
        path.lineTo(141, 49);
        path.closePath();
        path.moveTo(77, 103);
        path.lineTo(91, 87);
        path.lineTo(112, 87);
        path.lineTo(134, 101);
        path.lineTo(132, 113);
        path.lineTo(112, 113);
        path.lineTo(101, 124);
        path.lineTo(88, 122);
        path.lineTo(79, 113);
        path.lineTo(77, 103);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createIndonesiaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(8, 39);
        path.lineTo(12, 20);
        path.lineTo(33, 24);
        path.lineTo(64, 44);
        path.lineTo(66, 60);
        path.lineTo(74, 70);
        path.lineTo(81, 85);
        path.lineTo(71, 100);
        path.lineTo(57, 100);
        path.lineTo(42, 75);
        path.lineTo(29, 62);
        path.lineTo(27, 54);
        path.lineTo(8, 39);
        path.moveTo(118, 10);
        path.lineTo(103, 7);
        path.lineTo(91, 17);
        path.lineTo(94, 24);
        path.lineTo(84, 33);
        path.lineTo(70, 37);
        path.lineTo(72, 59);
        path.lineTo(77, 69);
        path.lineTo(93, 82);
        path.lineTo(107, 82);
        path.lineTo(115, 74);
        path.lineTo(118, 64);
        path.lineTo(113, 54);
        path.lineTo(115, 37);
        path.lineTo(124, 25);
        path.lineTo(118, 10);
        path.moveTo(147, 55);
        path.lineTo(155, 39);
        path.lineTo(141, 33);
        path.lineTo(135, 43);
        path.lineTo(119, 48);
        path.lineTo(121, 61);
        path.lineTo(117, 75);
        path.lineTo(127, 88);
        path.lineTo(141, 93);
        path.lineTo(147, 71);
        path.lineTo(147, 55);
        path.moveTo(82, 110);
        path.lineTo(97, 93);
        path.lineTo(118, 93);
        path.lineTo(139, 107);
        path.lineTo(137, 120);
        path.lineTo(118, 120);
        path.lineTo(106, 131);
        path.lineTo(93, 129);
        path.lineTo(84, 120);
        path.lineTo(82, 110);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createNewGuineaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(8, 23);
        path.lineTo(12, 10);
        path.lineTo(36, 12);
        path.lineTo(51, 7);
        path.lineTo(70, 14);
        path.lineTo(76, 26);
        path.lineTo(96, 31);
        path.lineTo(96, 41);
        path.lineTo(109, 47);
        path.lineTo(117, 67);
        path.lineTo(115, 83);
        path.lineTo(93, 83);
        path.lineTo(68, 77);
        path.lineTo(60, 79);
        path.lineTo(40, 67);
        path.lineTo(38, 52);
        path.lineTo(10, 43);
        path.lineTo(12, 33);
        path.lineTo(8, 23);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createEasternEurope() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(110, 7);
        path.lineTo(122, 9);
        path.lineTo(126, 24);
        path.lineTo(137, 31);
        path.lineTo(136, 42);
        path.lineTo(140, 64);
        path.lineTo(149, 68);
        path.lineTo(155, 80);
        path.lineTo(152, 94);
        path.lineTo(144, 101);
        path.lineTo(142, 107);
        path.lineTo(109, 110);
        path.lineTo(98, 124);
        path.lineTo(98, 143);
        path.lineTo(87, 138);
        path.lineTo(81, 133);
        path.lineTo(63, 138);
        path.lineTo(55, 140);
        path.lineTo(44, 138);
        path.lineTo(34, 144);
        path.lineTo(28, 150);
        path.lineTo(8, 150);
        path.lineTo(9, 140);
        path.lineTo(26, 128);
        path.lineTo(16, 105);
        path.lineTo(3, 96);
        path.lineTo(1, 88);
        path.lineTo(9, 77);
        path.lineTo(13, 74);
        path.lineTo(26, 67);
        path.lineTo(37, 51);
        path.lineTo(28, 22);
        path.lineTo(37, 1);
        path.lineTo(63, 1);
        path.lineTo(76, 12);
        path.lineTo(69, 18);
        path.lineTo(53, 22);
        path.lineTo(53, 31);
        path.lineTo(63, 36);
        path.lineTo(87, 9);
        path.lineTo(100, 9);
        path.lineTo(110, 7);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createAlaska() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(20, 21);
        path.lineTo(34, 6);
        path.lineTo(46, 1);
        path.lineTo(72, 1);
        path.lineTo(81, 7);
        path.lineTo(72, 43);
        path.lineTo(79, 46);
        path.lineTo(82, 54);
        path.lineTo(81, 72);
        path.lineTo(72, 80);
        path.lineTo(64, 60);
        path.lineTo(56, 52);
        path.lineTo(36, 54);
        path.lineTo(24, 62);
        path.lineTo(20, 52);
        path.lineTo(9, 52);
        path.lineTo(1, 43);
        path.lineTo(9, 34);
        path.lineTo(15, 31);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createNorthwest() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(147, 45);
        path.lineTo(124, 62);
        path.lineTo(99, 60);
        path.lineTo(8, 60);
        path.lineTo(1, 57);
        path.lineTo(10, 21);
        path.lineTo(22, 20);
        path.lineTo(33, 27);
        path.lineTo(48, 22);
        path.lineTo(52, 17);
        path.lineTo(68, 17);
        path.lineTo(94, 32);
        path.lineTo(114, 27);
        path.lineTo(132, 27);
        path.lineTo(139, 22);
        path.lineTo(139, 16);
        path.lineTo(151, 4);
        path.lineTo(157, 1);
        path.lineTo(165, 1);
        path.lineTo(160, 11);
        path.lineTo(151, 16);
        path.lineTo(152, 22);
        path.lineTo(160, 25);
        path.lineTo(175, 25);
        path.lineTo(173, 33);
        path.lineTo(163, 37);
        path.lineTo(156, 45);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createAlberta() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(9, 50);
        path.lineTo(1, 35);
        path.lineTo(10, 27);
        path.lineTo(11, 9);
        path.lineTo(8, 1);
        path.lineTo(99, 3);
        path.lineTo(80, 62);
        path.lineTo(9, 62);
        path.lineTo(9, 50);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createArgentina() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(36, 34);
        path.lineTo(45, 1);
        path.lineTo(54, 6);
        path.lineTo(59, 14);
        path.lineTo(87, 20);
        path.lineTo(110, 38);
        path.lineTo(124, 38);
        path.lineTo(120, 54);
        path.lineTo(120, 72);
        path.lineTo(127, 79);
        path.lineTo(119, 87);
        path.lineTo(104, 94);
        path.lineTo(101, 102);
        path.lineTo(93, 109);
        path.lineTo(73, 113);
        path.lineTo(59, 142);
        path.lineTo(46, 155);
        path.lineTo(44, 193);
        path.lineTo(58, 206);
        path.lineTo(58, 212);
        path.lineTo(68, 212);
        path.lineTo(68, 218);
        path.lineTo(48, 224);
        path.lineTo(14, 193);
        path.lineTo(1, 163);
        path.lineTo(15, 127);
        path.lineTo(16, 107);
        path.lineTo(24, 101);
        path.lineTo(28, 62);
        path.lineTo(36, 46);
        path.lineTo(36, 34);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createCongo() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(15, 87);
        path.lineTo(1, 67);
        path.lineTo(4, 49);
        path.lineTo(26, 46);
        path.lineTo(34, 49);
        path.lineTo(41, 43);
        path.lineTo(45, 27);
        path.lineTo(63, 13);
        path.lineTo(70, 2);
        path.lineTo(74, 11);
        path.lineTo(85, 17);
        path.lineTo(97, 32);
        path.lineTo(112, 39);
        path.lineTo(116, 46);
        path.lineTo(96, 81);
        path.lineTo(97, 100);
        path.lineTo(90, 104);
        path.lineTo(90, 112);
        path.lineTo(79, 117);
        path.lineTo(65, 112);
        path.lineTo(58, 97);
        path.lineTo(26, 81);
        path.lineTo(15, 87);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createCentralAmerica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(4, 11);
        path.lineTo(9, 1);
        path.lineTo(21, 7);
        path.lineTo(31, 17);
        path.lineTo(50, 21);
        path.lineTo(61, 21);
        path.lineTo(54, 38);
        path.lineTo(53, 50);
        path.lineTo(62, 60);
        path.lineTo(72, 58);
        path.lineTo(75, 51);
        path.lineTo(89, 51);
        path.lineTo(77, 63);
        path.lineTo(79, 68);
        path.lineTo(68, 86);
        path.lineTo(72, 92);
        path.lineTo(67, 109);
        path.lineTo(60, 110);
        path.lineTo(50, 104);
        path.lineTo(39, 75);
        path.lineTo(18, 66);
        path.lineTo(18, 56);
        path.lineTo(8, 51);
        path.lineTo(2, 36);
        path.lineTo(5, 25);
        path.lineTo(4, 11);
        path.closePath();
        return transformShape(path);
    }
    public static Shape createChina() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(48, 13);
        path.lineTo(36, 13);
        path.lineTo(23, 20);
        path.lineTo(21, 32);
        path.lineTo(14, 34);
        path.lineTo(19, 51);
        path.lineTo(11, 63);
        path.lineTo(3, 67);
        path.lineTo(2, 76);
        path.lineTo(7, 85);
        path.lineTo(16, 81);
        path.lineTo(27, 88);
        path.lineTo(31, 103);
        path.lineTo(31, 110);
        path.lineTo(47, 122);
        path.lineTo(60, 124);
        path.lineTo(81, 132);
        path.lineTo(91, 140);
        path.lineTo(98, 135);
        path.lineTo(112, 146);
        path.lineTo(132, 144);
        path.lineTo(144, 153);
        path.lineTo(145, 158);
        path.lineTo(154, 170);
        path.lineTo(180, 132);
        path.lineTo(184, 103);
        path.lineTo(162, 71);
        path.lineTo(159, 52);
        path.lineTo(172, 60);
        path.lineTo(178, 58);
        path.lineTo(181, 69);
        path.lineTo(189, 69);
        path.lineTo(189, 50);
        path.lineTo(173, 36);
        path.lineTo(171, 24);
        path.lineTo(159, 4);
        path.lineTo(151, 4);
        path.lineTo(144, 1);
        path.lineTo(130, 1);
        path.lineTo(125, 8);
        path.lineTo(112, 8);
        path.lineTo(74, 1);
        path.lineTo(64, 4);
        path.lineTo(67, 22);
        path.lineTo(62, 32);
        path.lineTo(51, 28);
        path.lineTo(48, 13);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createEastAfrica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(75, 149);
        path.lineTo(82, 157);
        path.lineTo(58, 168);
        path.lineTo(46, 163);
        path.lineTo(37, 150);
        path.lineTo(30, 148);
        path.lineTo(29, 129);
        path.lineTo(49, 94);
        path.lineTo(45, 87);
        path.lineTo(30, 80);
        path.lineTo(18, 65);
        path.lineTo(7, 59);
        path.lineTo(3, 50);
        path.lineTo(1, 42);
        path.lineTo(5, 35);
        path.lineTo(5, 12);
        path.lineTo(13, 1);
        path.lineTo(63, 1);
        path.lineTo(92, 42);
        path.lineTo(92, 51);
        path.lineTo(124, 56);
        path.lineTo(118, 90);
        path.lineTo(88, 127);
        path.lineTo(81, 132);
        path.lineTo(75, 149);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createEasternAustralia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(120, 186);
        path.lineTo(112, 196);
        path.lineTo(89, 196);
        path.lineTo(88, 164);
        path.lineTo(95, 158);
        path.lineTo(78, 94);
        path.lineTo(25, 90);
        path.lineTo(19, 27);
        path.lineTo(2, 21);
        path.lineTo(21, 5);
        path.lineTo(33, 1);
        path.lineTo(48, 2);
        path.lineTo(59, 13);
        path.lineTo(78, 18);
        path.lineTo(95, 16);
        path.lineTo(105, 25);
        path.lineTo(112, 51);
        path.lineTo(120, 54);
        path.lineTo(146, 96);
        path.lineTo(146, 142);
        path.lineTo(138, 151);
        path.lineTo(134, 186);
        path.lineTo(120, 186);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createEasternAmerica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(18, 76);
        path.lineTo(9, 92);
        path.lineTo(2, 109);
        path.lineTo(16, 102);
        path.lineTo(21, 93);
        path.lineTo(54, 89);
        path.lineTo(74, 92);
        path.lineTo(80, 101);
        path.lineTo(78, 109);
        path.lineTo(85, 112);
        path.lineTo(93, 109);
        path.lineTo(98, 90);
        path.lineTo(98, 82);
        path.lineTo(114, 68);
        path.lineTo(116, 59);
        path.lineTo(133, 52);
        path.lineTo(138, 47);
        path.lineTo(140, 38);
        path.lineTo(150, 38);
        path.lineTo(154, 40);
        path.lineTo(163, 35);
        path.lineTo(166, 29);
        path.lineTo(159, 19);
        path.lineTo(153, 15);
        path.lineTo(147, 19);
        path.lineTo(124, 21);
        path.lineTo(96, 27);
        path.lineTo(92, 11);
        path.lineTo(77, 1);
        path.lineTo(67, 1);
        path.lineTo(52, 45);
        path.lineTo(37, 49);
        path.lineTo(22, 62);
        path.lineTo(18, 76);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createEgypt() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(107, 39);
        path.lineTo(116, 46);
        path.lineTo(116, 59);
        path.lineTo(66, 59);
        path.lineTo(58, 70);
        path.lineTo(49, 68);
        path.lineTo(41, 57);
        path.lineTo(10, 52);
        path.lineTo(1, 26);
        path.lineTo(6, 20);
        path.lineTo(6, 13);
        path.lineTo(15, 1);
        path.lineTo(24, 2);
        path.lineTo(35, 9);
        path.lineTo(57, 4);
        path.lineTo(66, 11);
        path.lineTo(99, 15);
        path.lineTo(108, 28);
        path.lineTo(107, 39);
        path.closePath();
        return transformShape(path);
    }
    public static Shape createJapan() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(22, 13);
        path.lineTo(22, 3);
        path.lineTo(36, 5);
        path.lineTo(48, 1);
        path.lineTo(55, 11);
        path.lineTo(45, 18);
        path.lineTo(42, 27);
        path.lineTo(48, 34);
        path.lineTo(50, 53);
        path.lineTo(55, 59);
        path.lineTo(53, 71);
        path.lineTo(36, 77);
        path.lineTo(38, 83);
        path.lineTo(31, 88);
        path.lineTo(22, 88);
        path.lineTo(23, 98);
        path.lineTo(9, 107);
        path.lineTo(1, 95);
        path.lineTo(6, 90);
        path.lineTo(3, 81);
        path.lineTo(11, 68);
        path.lineTo(19, 68);
        path.lineTo(16, 49);
        path.lineTo(28, 47);
        path.lineTo(22, 38);
        path.lineTo(22, 29);
        path.lineTo(16, 18);
        path.lineTo(22, 13);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createMadagascar() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(9, 61);
        path.lineTo(12, 50);
        path.lineTo(42, 42);
        path.lineTo(64, 2);
        path.lineTo(76, 28);
        path.lineTo(67, 39);
        path.lineTo(69, 44);
        path.lineTo(61, 86);
        path.lineTo(48, 102);
        path.lineTo(42, 123);
        path.lineTo(13, 137);
        path.lineTo(1, 97);
        path.lineTo(9, 92);
        path.lineTo(12, 76);
        path.lineTo(9, 61);
        path.closePath();
        return transformShape(path);
    }
    public static Shape createMiddleEast() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(121, 11);
        path.lineTo(126, 7);
        path.lineTo(146, 8);
        path.lineTo(157, 16);
        path.lineTo(152, 31);
        path.lineTo(168, 54);
        path.lineTo(169, 70);
        path.lineTo(158, 81);
        path.lineTo(143, 80);
        path.lineTo(126, 66);
        path.lineTo(119, 71);
        path.lineTo(130, 81);
        path.lineTo(138, 96);
        path.lineTo(152, 90);
        path.lineTo(165, 106);
        path.lineTo(151, 144);
        path.lineTo(120, 157);
        path.lineTo(103, 149);
        path.lineTo(100, 139);
        path.lineTo(72, 125);
        path.lineTo(45, 74);
        path.lineTo(52, 69);
        path.lineTo(50, 47);
        path.lineTo(45, 51);
        path.lineTo(17, 52);
        path.lineTo(9, 46);
        path.lineTo(1, 31);
        path.lineTo(15, 5);
        path.lineTo(23, 9);
        path.lineTo(32, 7);
        path.lineTo(40, 1);
        path.lineTo(56, 11);
        path.lineTo(68, 5);
        path.lineTo(78, 4);
        path.lineTo(83, 11);
        path.lineTo(102, 2);
        path.lineTo(121, 11);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createGreatBritain() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(39, 7);
        path.lineTo(43, 1);
        path.lineTo(56, 3);
        path.lineTo(60, 12);
        path.lineTo(56, 26);
        path.lineTo(74, 34);
        path.lineTo(76, 50);
        path.lineTo(83, 50);
        path.lineTo(90, 54);
        path.lineTo(88, 61);
        path.lineTo(82, 63);
        path.lineTo(76, 76);
        path.lineTo(48, 76);
        path.lineTo(43, 79);
        path.lineTo(28, 79);
        path.lineTo(38, 65);
        path.lineTo(35, 60);
        path.lineTo(41, 57);
        path.lineTo(46, 48);
        path.lineTo(41, 34);
        path.lineTo(35, 28);
        path.lineTo(30, 12);
        path.lineTo(39, 7);
        path.closePath();
        path.moveTo(32, 47);
        path.lineTo(25, 38);
        path.lineTo(19, 39);
        path.lineTo(6, 44);
        path.lineTo(6, 53);
        path.lineTo(11, 56);
        path.lineTo(1, 63);
        path.lineTo(2, 68);
        path.lineTo(8, 70);
        path.lineTo(18, 64);
        path.lineTo(26, 64);
        path.lineTo(29, 57);
        path.lineTo(27, 50);
        path.lineTo(32, 47);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createGreenland() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(58, 8);
        path.lineTo(43, 8);
        path.lineTo(28, 19);
        path.lineTo(19, 22);
        path.lineTo(7, 31);
        path.lineTo(7, 36);
        path.lineTo(1, 40);
        path.lineTo(5, 43);
        path.lineTo(19, 44);
        path.lineTo(26, 42);
        path.lineTo(33, 47);
        path.lineTo(34, 50);
        path.lineTo(40, 56);
        path.lineTo(36, 65);
        path.lineTo(45, 69);
        path.lineTo(37, 77);
        path.lineTo(37, 92);
        path.lineTo(42, 92);
        path.lineTo(54, 111);
        path.lineTo(61, 108);
        path.lineTo(68, 99);
        path.lineTo(68, 84);
        path.lineTo(98, 72);
        path.lineTo(102, 68);
        path.lineTo(112, 65);
        path.lineTo(116, 60);
        path.lineTo(120, 60);
        path.lineTo(123, 49);
        path.lineTo(131, 42);
        path.lineTo(131, 34);
        path.lineTo(126, 28);
        path.lineTo(127, 21);
        path.lineTo(135, 19);
        path.lineTo(127, 12);
        path.lineTo(112, 8);
        path.lineTo(111, 3);
        path.lineTo(82, 1);
        path.lineTo(58, 8);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createNewGuinea() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(0, 17);
        path.lineTo(5, 3);
        path.lineTo(28, 5);
        path.lineTo(43, 1);
        path.lineTo(63, 7);
        path.lineTo(69, 19);
        path.lineTo(88, 24);
        path.lineTo(88, 34);
        path.lineTo(102, 40);
        path.lineTo(109, 61);
        path.lineTo(107, 76);
        path.lineTo(86, 76);
        path.lineTo(61, 70);
        path.lineTo(53, 72);
        path.lineTo(33, 61);
        path.lineTo(30, 45);
        path.lineTo(3, 37);
        path.lineTo(5, 26);
        path.lineTo(0, 17);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createMongolia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(71, 14);
        path.lineTo(47, 1);
        path.lineTo(41, 8);
        path.lineTo(39, 17);
        path.lineTo(20, 19);
        path.lineTo(5, 29);
        path.lineTo(1, 46);
        path.lineTo(5, 52);
        path.lineTo(8, 64);
        path.lineTo(20, 77);
        path.lineTo(20, 88);
        path.lineTo(32, 96);
        path.lineTo(28, 107);
        path.lineTo(48, 108);
        path.lineTo(59, 116);
        path.lineTo(78, 107);
        path.lineTo(97, 102);
        path.lineTo(102, 95);
        path.lineTo(97, 86);
        path.lineTo(98, 77);
        path.lineTo(106, 73);
        path.lineTo(114, 61);
        path.lineTo(109, 44);
        path.lineTo(116, 42);
        path.lineTo(118, 30);
        path.lineTo(131, 23);
        path.lineTo(120, 6);
        path.lineTo(71, 14);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createQuebec() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(56, 89);
        path.lineTo(49, 92);
        path.lineTo(42, 82);
        path.lineTo(36, 78);
        path.lineTo(30, 82);
        path.lineTo(7, 84);
        path.lineTo(10, 76);
        path.lineTo(1, 71);
        path.lineTo(3, 55);
        path.lineTo(11, 42);
        path.lineTo(11, 39);
        path.lineTo(19, 34);
        path.lineTo(24, 25);
        path.lineTo(22, 17);
        path.lineTo(33, 10);
        path.lineTo(30, 1);
        path.lineTo(44, 3);
        path.lineTo(52, 14);
        path.lineTo(54, 21);
        path.lineTo(63, 15);
        path.lineTo(68, 15);
        path.lineTo(71, 25);
        path.lineTo(70, 31);
        path.lineTo(87, 38);
        path.lineTo(85, 40);
        path.lineTo(88, 42);
        path.lineTo(85, 49);
        path.lineTo(75, 52);
        path.lineTo(75, 55);
        path.lineTo(65, 61);
        path.lineTo(55, 63);
        path.lineTo(50, 61);
        path.lineTo(38, 68);
        path.lineTo(50, 71);
        path.lineTo(60, 81);
        path.lineTo(56, 89);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createWesternAmerica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(23, 10);
        path.lineTo(25, 1);
        path.lineTo(115, 1);
        path.lineTo(100, 45);
        path.lineTo(85, 49);
        path.lineTo(70, 62);
        path.lineTo(66, 76);
        path.lineTo(57, 92);
        path.lineTo(46, 92);
        path.lineTo(27, 88);
        path.lineTo(17, 79);
        path.lineTo(5, 72);
        path.lineTo(5, 66);
        path.lineTo(1, 56);
        path.lineTo(7, 34);
        path.lineTo(23, 10);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createOntario() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(67, 44);
        path.lineTo(74, 51);
        path.lineTo(72, 67);
        path.lineTo(81, 72);
        path.lineTo(78, 80);
        path.lineTo(50, 86);
        path.lineTo(46, 70);
        path.lineTo(31, 60);
        path.lineTo(21, 60);
        path.lineTo(2, 60);
        path.lineTo(21, 1);
        path.lineTo(46, 1);
        path.lineTo(42, 16);
        path.lineTo(52, 24);
        path.lineTo(64, 21);
        path.lineTo(74, 20);
        path.lineTo(78, 28);
        path.lineTo(69, 34);
        path.lineTo(71, 40);
        path.lineTo(67, 44);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createBrazil() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(99, 175);
        path.lineTo(90, 189);
        path.lineTo(83, 182);
        path.lineTo(83, 164);
        path.lineTo(87, 148);
        path.lineTo(79, 114);
        path.lineTo(64, 84);
        path.lineTo(57, 84);
        path.lineTo(36, 69);
        path.lineTo(23, 74);
        path.lineTo(2, 60);
        path.lineTo(1, 52);
        path.lineTo(8, 39);
        path.lineTo(15, 37);
        path.lineTo(27, 32);
        path.lineTo(29, 23);
        path.lineTo(37, 15);
        path.lineTo(63, 12);
        path.lineTo(82, 12);
        path.lineTo(96, 13);
        path.lineTo(115, 11);
        path.lineTo(128, 1);
        path.lineTo(138, 22);
        path.lineTo(152, 26);
        path.lineTo(155, 31);
        path.lineTo(168, 31);
        path.lineTo(190, 42);
        path.lineTo(194, 60);
        path.lineTo(187, 67);
        path.lineTo(178, 69);
        path.lineTo(170, 81);
        path.lineTo(165, 110);
        path.lineTo(159, 111);
        path.lineTo(143, 134);
        path.lineTo(120, 138);
        path.lineTo(108, 167);
        path.lineTo(99, 175);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createPersia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(16, 54);
        path.lineTo(7, 48);
        path.lineTo(1, 35);
        path.lineTo(5, 21);
        path.lineTo(1, 6);
        path.lineTo(19, 1);
        path.lineTo(25, 6);
        path.lineTo(36, 11);
        path.lineTo(41, 15);
        path.lineTo(44, 32);
        path.lineTo(54, 43);
        path.lineTo(54, 50);
        path.lineTo(49, 59);
        path.lineTo(33, 66);
        path.lineTo(14, 58);
        path.lineTo(16, 54);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createNorthAfrica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(158, 77);
        path.lineTo(166, 88);
        path.lineTo(175, 90);
        path.lineTo(175, 113);
        path.lineTo(171, 120);
        path.lineTo(173, 128);
        path.lineTo(166, 139);
        path.lineTo(148, 153);
        path.lineTo(144, 169);
        path.lineTo(137, 175);
        path.lineTo(129, 172);
        path.lineTo(107, 175);
        path.lineTo(108, 167);
        path.lineTo(98, 165);
        path.lineTo(92, 159);
        path.lineTo(76, 159);
        path.lineTo(66, 162);
        path.lineTo(42, 113);
        path.lineTo(12, 102);
        path.lineTo(14, 82);
        path.lineTo(10, 75);
        path.lineTo(41, 23);
        path.lineTo(39, 17);
        path.lineTo(56, 12);
        path.lineTo(63, 16);
        path.lineTo(101, 1);
        path.lineTo(117, 1);
        path.lineTo(132, 21);
        path.lineTo(123, 33);
        path.lineTo(123, 40);
        path.lineTo(118, 46);
        path.lineTo(127, 72);
        path.lineTo(158, 77);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createNorthernEurope() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(71, 6);
        path.lineTo(78, 8);
        path.lineTo(91, 17);
        path.lineTo(101, 40);
        path.lineTo(84, 52);
        path.lineTo(83, 62);
        path.lineTo(73, 74);
        path.lineTo(63, 72);
        path.lineTo(53, 70);
        path.lineTo(49, 72);
        path.lineTo(40, 68);
        path.lineTo(27, 70);
        path.lineTo(8, 69);
        path.lineTo(1, 55);
        path.lineTo(6, 38);
        path.lineTo(15, 21);
        path.lineTo(24, 15);
        path.lineTo(18, 9);
        path.lineTo(37, 2);
        path.lineTo(46, 9);
        path.lineTo(71, 6);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createPeru() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(4, 17);
        path.lineTo(14, 1);
        path.lineTo(24, 9);
        path.lineTo(45, 14);
        path.lineTo(47, 20);
        path.lineTo(40, 22);
        path.lineTo(33, 35);
        path.lineTo(34, 43);
        path.lineTo(55, 57);
        path.lineTo(68, 52);
        path.lineTo(89, 67);
        path.lineTo(96, 97);
        path.lineTo(119, 131);
        path.lineTo(105, 113);
        path.lineTo(82, 107);
        path.lineTo(54, 99);
        path.lineTo(49, 94);
        path.lineTo(40, 94);
        path.lineTo(34, 85);
        path.lineTo(14, 70);
        path.lineTo(11, 57);
        path.lineTo(4, 49);
        path.lineTo(1, 36);
        path.lineTo(6, 24);
        path.lineTo(4, 17);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createRussia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(304, 105);
        path.lineTo(298, 134);
        path.lineTo(282, 124);
        path.lineTo(275, 105);
        path.lineTo(279, 91);
        path.lineTo(266, 82);
        path.lineTo(259, 88);
        path.lineTo(266, 95);
        path.lineTo(257, 98);
        path.lineTo(235, 91);
        path.lineTo(233, 111);
        path.lineTo(252, 112);
        path.lineTo(264, 120);
        path.lineTo(270, 148);
        path.lineTo(251, 175);
        path.lineTo(240, 155);
        path.lineTo(231, 153);
        path.lineTo(224, 153);
        path.lineTo(210, 160);
        path.lineTo(206, 160);
        path.lineTo(193, 160);
        path.lineTo(155, 153);
        path.lineTo(145, 155);
        path.lineTo(147, 174);
        path.lineTo(142, 184);
        path.lineTo(131, 180);
        path.lineTo(129, 165);
        path.lineTo(117, 165);
        path.lineTo(105, 148);
        path.lineTo(57, 155);
        path.lineTo(33, 143);
        path.lineTo(37, 126);
        path.lineTo(30, 111);
        path.lineTo(22, 108);
        path.lineTo(20, 94);
        path.lineTo(33, 85);
        path.lineTo(6, 71);
        path.lineTo(2, 50);
        path.lineTo(20, 30);
        path.lineTo(34, 34);
        path.lineTo(36, 45);
        path.lineTo(44, 59);
        path.lineTo(57, 62);
        path.lineTo(57, 55);
        path.lineTo(48, 50);
        path.lineTo(48, 39);
        path.lineTo(54, 38);
        path.lineTo(52, 33);
        path.lineTo(61, 22);
        path.lineTo(71, 10);
        path.lineTo(114, 2);
        path.lineTo(123, 10);
        path.lineTo(135, 13);
        path.lineTo(135, 19);
        path.lineTo(154, 19);
        path.lineTo(160, 13);
        path.lineTo(172, 17);
        path.lineTo(174, 23);
        path.lineTo(187, 27);
        path.lineTo(208, 21);
        path.lineTo(224, 23);
        path.lineTo(231, 32);
        path.lineTo(240, 27);
        path.lineTo(266, 34);
        path.lineTo(275, 28);
        path.lineTo(329, 42);
        path.lineTo(337, 63);
        path.lineTo(329, 70);
        path.lineTo(318, 72);
        path.lineTo(308, 88);
        path.lineTo(296, 88);
        path.lineTo(296, 95);
        path.lineTo(304, 105);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createScandinavia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(44, 18);
        path.lineTo(77, 1);
        path.lineTo(99, 1);
        path.lineTo(91, 22);
        path.lineTo(99, 51);
        path.lineTo(88, 67);
        path.lineTo(84, 65);
        path.lineTo(69, 69);
        path.lineTo(66, 53);
        path.lineTo(63, 50);
        path.lineTo(59, 54);
        path.lineTo(64, 68);
        path.lineTo(59, 82);
        path.lineTo(51, 85);
        path.lineTo(46, 92);
        path.lineTo(29, 90);
        path.lineTo(25, 87);
        path.lineTo(17, 87);
        path.lineTo(9, 71);
        path.lineTo(8, 65);
        path.lineTo(2, 60);
        path.lineTo(20, 40);
        path.lineTo(35, 36);
        path.lineTo(44, 18);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createSiam() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(10, 76);
        path.lineTo(1, 33);
        path.lineTo(13, 6);
        path.lineTo(20, 1);
        path.lineTo(34, 12);
        path.lineTo(54, 10);
        path.lineTo(66, 19);
        path.lineTo(67, 24);
        path.lineTo(60, 37);
        path.lineTo(81, 54);
        path.lineTo(92, 73);
        path.lineTo(87, 88);
        path.lineTo(71, 103);
        path.lineTo(56, 79);
        path.lineTo(42, 79);
        path.lineTo(54, 109);
        path.lineTo(47, 119);
        path.lineTo(35, 107);
        path.lineTo(25, 79);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createSouthAfrica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(16, 17);
        path.lineTo(15, 7);
        path.lineTo(26, 1);
        path.lineTo(58, 17);
        path.lineTo(65, 32);
        path.lineTo(79, 37);
        path.lineTo(90, 32);
        path.lineTo(97, 20);
        path.lineTo(104, 22);
        path.lineTo(113, 35);
        path.lineTo(125, 40);
        path.lineTo(149, 29);
        path.lineTo(152, 60);
        path.lineTo(136, 82);
        path.lineTo(129, 89);
        path.lineTo(112, 129);
        path.lineTo(106, 140);
        path.lineTo(77, 160);
        path.lineTo(39, 176);
        path.lineTo(26, 160);
        path.lineTo(24, 124);
        path.lineTo(20, 120);
        path.lineTo(18, 96);
        path.lineTo(1, 66);
        path.lineTo(13, 44);
        path.lineTo(10, 24);
        path.lineTo(16, 17);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createSouthernEurope() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(15, 47);
        path.lineTo(12, 47);
        path.lineTo(1, 24);
        path.lineTo(8, 2);
        path.lineTo(27, 3);
        path.lineTo(40, 1);
        path.lineTo(49, 5);
        path.lineTo(53, 3);
        path.lineTo(63, 5);
        path.lineTo(60, 19);
        path.lineTo(50, 27);
        path.lineTo(44, 41);
        path.lineTo(36, 44);
        path.lineTo(49, 59);
        path.lineTo(48, 69);
        path.lineTo(43, 66);
        path.lineTo(43, 73);
        path.lineTo(30, 81);
        path.lineTo(26, 72);
        path.lineTo(30, 65);
        path.lineTo(18, 53);
        path.lineTo(15, 47);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createAnatolia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(13, 69);
        path.lineTo(1, 59);
        path.lineTo(7, 45);
        path.lineTo(17, 37);
        path.lineTo(20, 23);
        path.lineTo(30, 25);
        path.lineTo(40, 13);
        path.lineTo(60, 13);
        path.lineTo(66, 7);
        path.lineTo(76, 1);
        path.lineTo(87, 3);
        path.lineTo(95, 1);
        path.lineTo(99, 16);
        path.lineTo(95, 30);
        path.lineTo(101, 43);
        path.lineTo(92, 50);
        path.lineTo(82, 49);
        path.lineTo(74, 57);
        path.lineTo(56, 59);
        path.lineTo(55, 69);
        path.lineTo(43, 87);
        path.lineTo(37, 92);
        path.lineTo(33, 99);
        path.lineTo(39, 105);
        path.lineTo(40, 110);
        path.lineTo(33, 112);
        path.lineTo(34, 109);
        path.lineTo(27, 107);
        path.lineTo(22, 100);
        path.lineTo(22, 96);
        path.lineTo(21, 87);
        path.lineTo(20, 85);
        path.lineTo(21, 82);
        path.lineTo(13, 73);
        path.lineTo(13, 69);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createVenezuela() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(24, 23);
        path.lineTo(24, 16);
        path.lineTo(52, 6);
        path.lineTo(56, 3);
        path.lineTo(66, 1);
        path.lineTo(85, 10);
        path.lineTo(95, 8);
        path.lineTo(118, 25);
        path.lineTo(139, 29);
        path.lineTo(148, 36);
        path.lineTo(134, 45);
        path.lineTo(115, 48);
        path.lineTo(101, 46);
        path.lineTo(82, 46);
        path.lineTo(56, 49);
        path.lineTo(49, 58);
        path.lineTo(46, 67);
        path.lineTo(34, 71);
        path.lineTo(33, 65);
        path.lineTo(12, 61);
        path.lineTo(2, 53);
        path.lineTo(7, 49);
        path.lineTo(8, 38);
        path.lineTo(24, 23);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createWesternAustralia() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(38, 39);
        path.lineTo(52, 20);
        path.lineTo(61, 15);
        path.lineTo(70, 1);
        path.lineTo(87, 7);
        path.lineTo(93, 70);
        path.lineTo(146, 74);
        path.lineTo(163, 138);
        path.lineTo(156, 144);
        path.lineTo(157, 176);
        path.lineTo(139, 160);
        path.lineTo(137, 148);
        path.lineTo(131, 142);
        path.lineTo(124, 142);
        path.lineTo(114, 127);
        path.lineTo(99, 122);
        path.lineTo(82, 131);
        path.lineTo(83, 142);
        path.lineTo(30, 157);
        path.lineTo(14, 142);
        path.lineTo(9, 110);
        path.lineTo(1, 87);
        path.lineTo(7, 74);
        path.lineTo(4, 52);
        path.lineTo(25, 37);
        path.lineTo(38, 39);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createWesternEurope() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(76, 2);
        path.lineTo(81, 3);
        path.lineTo(88, 17);
        path.lineTo(81, 39);
        path.lineTo(92, 62);
        path.lineTo(84, 68);
        path.lineTo(76, 65);
        path.lineTo(69, 77);
        path.lineTo(65, 92);
        path.lineTo(56, 110);
        path.lineTo(48, 108);
        path.lineTo(32, 117);
        path.lineTo(9, 112);
        path.lineTo(2, 96);
        path.lineTo(11, 77);
        path.lineTo(8, 67);
        path.lineTo(14, 55);
        path.lineTo(25, 57);
        path.lineTo(38, 56);
        path.lineTo(43, 42);
        path.lineTo(26, 28);
        path.lineTo(42, 20);
        path.lineTo(48, 22);
        path.lineTo(52, 16);
        path.lineTo(67, 14);
        path.lineTo(76, 2);
        path.closePath();
        return transformShape(path);
    }

}