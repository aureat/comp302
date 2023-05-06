package ui.graphics;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class MapGraphics {

    private static class MapGraphicsContainer {
        private static final MapGraphics instance = new MapGraphics();
    }

    public static MapGraphics getInstance() {
        return MapGraphicsContainer.instance;
    }

    private MapGraphics() {
        // ...
    }

    private static double scale = 1;

    public static final int continentStroke = 14;
    public static final int territoryStroke = 3;

    public static void setScale(double newScale) {
        scale = newScale;
    }

    public static double getScale() {
        return scale;
    }

    public static Shape transformShape(Path2D.Double path) {
        AffineTransform transform = new AffineTransform();
        transform.scale(scale, scale);
        return path.createTransformedShape(transform);
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

    public static Shape createAlaska() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public static Shape createNorthwest() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public static Shape createAlberta() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public static Shape createCentralAmerica() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public static Shape createEasternAmerica() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public static Shape createQuebec() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public static Shape createWesternAmerica() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public static Shape createOntario() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public final Shape shapeNorthAmericaOutline = createNorthAmericaOutline();
    public final Shape shapeGreenlandOutline = createGreenlandOutline();
    public final Shape shapeSouthAmericaOutline = createSouthAmericaOutline();
    public final Shape shapeEuropeOutline = createEuropeOutline();
    public final Shape shapeBritainOutline = createBritainOutline();
    public final Shape shapeIcelandOutline = createIcelandOutline();
    public final Shape shapeAsiaOutline = createAsiaOutline();
    public final Shape shapeJapanOutline = createJapanOutline();
    public final Shape shapeAfricaOutline = createAfricaOutline();
    public final Shape shapeMadagascarOutline = createMadagascarOutline();
    public final Shape shapeOceaniaOutline = createOceaniaOutline();
    public final Shape shapeIndonesiaOutline = createIndonesiaOutline();
    public final Shape shapeNewGuineaOutline = createNewGuineaOutline();

}
