package view.graphics;

import org.jetbrains.annotations.NotNull;

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

    private static double scale = 1;

    public static final int continentStroke = 20;
    public static final int territoryStroke = 3;

    public static void setScale(double newScale) {
        scale = newScale;
    }

    public static double getScale() {
        return scale;
    }

    public static Shape transformShape(@NotNull Path2D.Double path) {
        AffineTransform transform = new AffineTransform();
        transform.scale(scale, scale);
        return path.createTransformedShape(transform);
    }

    public static Shape createNorthAmericaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(34, 48);
        path.lineTo(50, 31);
        path.lineTo(65, 24);
        path.lineTo(95, 24);
        path.lineTo(105, 32);
        path.lineTo(120, 31);
        path.lineTo(132, 38);
        path.lineTo(150, 33);
        path.lineTo(154, 27);
        path.lineTo(173, 27);
        path.lineTo(204, 44);
        path.lineTo(227, 38);
        path.lineTo(248, 38);
        path.lineTo(256, 33);
        path.lineTo(271, 12);
        path.lineTo(278, 8);
        path.lineTo(286, 8);
        path.lineTo(282, 20);
        path.lineTo(271, 26);
        path.lineTo(272, 33);
        path.lineTo(282, 36);
        path.lineTo(299, 36);
        path.lineTo(296, 46);
        path.lineTo(285, 51);
        path.lineTo(276, 59);
        path.lineTo(266, 59);
        path.lineTo(239, 79);
        path.lineTo(234, 97);
        path.lineTo(246, 107);
        path.lineTo(260, 103);
        path.lineTo(272, 102);
        path.lineTo(276, 112);
        path.lineTo(266, 118);
        path.lineTo(268, 126);
        path.lineTo(263, 130);
        path.lineTo(272, 138);
        path.lineTo(282, 123);
        path.lineTo(282, 120);
        path.lineTo(290, 114);
        path.lineTo(296, 103);
        path.lineTo(293, 93);
        path.lineTo(306, 86);
        path.lineTo(304, 75);
        path.lineTo(319, 77);
        path.lineTo(330, 90);
        path.lineTo(332, 99);
        path.lineTo(342, 91);
        path.lineTo(348, 91);
        path.lineTo(352, 103);
        path.lineTo(350, 110);
        path.lineTo(370, 118);
        path.lineTo(367, 121);
        path.lineTo(371, 123);
        path.lineTo(367, 131);
        path.lineTo(356, 135);
        path.lineTo(345, 145);
        path.lineTo(333, 147);
        path.lineTo(327, 145);
        path.lineTo(313, 153);
        path.lineTo(327, 157);
        path.lineTo(338, 168);
        path.lineTo(334, 179);
        path.lineTo(325, 182);
        path.lineTo(322, 189);
        path.lineTo(312, 194);
        path.lineTo(306, 193);
        path.lineTo(295, 203);
        path.lineTo(292, 203);
        path.lineTo(286, 209);
        path.lineTo(267, 216);
        path.lineTo(265, 227);
        path.lineTo(246, 243);
        path.lineTo(239, 252);
        path.lineTo(230, 278);
        path.lineTo(223, 275);
        path.lineTo(225, 265);
        path.lineTo(217, 255);
        path.lineTo(194, 251);
        path.lineTo(156, 257);
        path.lineTo(150, 267);
        path.lineTo(134, 275);
        path.lineTo(132, 289);
        path.lineTo(143, 300);
        path.lineTo(154, 298);
        path.lineTo(158, 291);
        path.lineTo(175, 291);
        path.lineTo(160, 305);
        path.lineTo(163, 310);
        path.lineTo(150, 332);
        path.lineTo(154, 338);
        path.lineTo(149, 358);
        path.lineTo(140, 360);
        path.lineTo(129, 352);
        path.lineTo(116, 319);
        path.lineTo(91, 308);
        path.lineTo(79, 291);
        path.lineTo(72, 273);
        path.lineTo(76, 260);
        path.lineTo(74, 244);
        path.lineTo(80, 232);
        path.lineTo(76, 213);
        path.lineTo(83, 188);
        path.lineTo(101, 159);
        path.lineTo(104, 148);
        path.lineTo(95, 118);
        path.lineTo(85, 94);
        path.lineTo(76, 85);
        path.lineTo(52, 86);
        path.lineTo(38, 96);
        path.lineTo(34, 85);
        path.lineTo(21, 74);
        path.lineTo(12, 63);
        path.lineTo(21, 59);
        path.lineTo(28, 48);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createAlaska() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(24, 24);
        path.lineTo(40, 7);
        path.lineTo(55, 1);
        path.lineTo(85, 1);
        path.lineTo(95, 8);
        path.lineTo(85, 51);
        path.lineTo(92, 54);
        path.lineTo(97, 63);
        path.lineTo(95, 84);
        path.lineTo(85, 94);
        path.lineTo(75, 70);
        path.lineTo(66, 61);
        path.lineTo(42, 63);
        path.lineTo(28, 72);
        path.lineTo(24, 61);
        path.lineTo(11, 51);
        path.lineTo(2, 51);
        path.lineTo(11, 39);
        path.lineTo(18, 36);
        path.lineTo(24, 24);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createNorthwest() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(173, 52);
        path.lineTo(146, 72);
        path.lineTo(116, 70);
        path.lineTo(9, 70);
        path.lineTo(2, 67);
        path.lineTo(12, 24);
        path.lineTo(26, 23);
        path.lineTo(39, 31);
        path.lineTo(57, 26);
        path.lineTo(61, 20);
        path.lineTo(80, 20);
        path.lineTo(111, 37);
        path.lineTo(134, 31);
        path.lineTo(155, 26);
        path.lineTo(163, 26);
        path.lineTo(177, 4);
        path.lineTo(184, 1);
        path.lineTo(193, 1);
        path.lineTo(188, 13);
        path.lineTo(177, 18);
        path.lineTo(179, 26);
        path.lineTo(188, 28);
        path.lineTo(206, 28);
        path.lineTo(203, 38);
        path.lineTo(192, 43);
        path.lineTo(183, 52);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createAlberta() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(11, 60);
        path.lineTo(2, 42);
        path.lineTo(12, 32);
        path.lineTo(14, 11);
        path.lineTo(9, 2);
        path.lineTo(116, 4);
        path.lineTo(94, 73);
        path.lineTo(11, 73);
        path.lineTo(11, 60);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createCentralAmerica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(3, 14);
        path.lineTo(9, 2);
        path.lineTo(24, 9);
        path.lineTo(35, 20);
        path.lineTo(57, 24);
        path.lineTo(71, 24);
        path.lineTo(63, 44);
        path.lineTo(61, 59);
        path.lineTo(72, 70);
        path.lineTo(83, 68);
        path.lineTo(87, 60);
        path.lineTo(103, 60);
        path.lineTo(89, 74);
        path.lineTo(92, 79);
        path.lineTo(79, 101);
        path.lineTo(83, 108);
        path.lineTo(78, 128);
        path.lineTo(69, 129);
        path.lineTo(58, 122);
        path.lineTo(45, 88);
        path.lineTo(20, 78);
        path.lineTo(20, 66);
        path.lineTo(8, 60);
        path.lineTo(1, 43);
        path.lineTo(5, 30);
        path.lineTo(3, 14);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createEasternAmerica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(21, 89);
        path.lineTo(11, 107);
        path.lineTo(3, 127);
        path.lineTo(19, 120);
        path.lineTo(25, 109);
        path.lineTo(63, 104);
        path.lineTo(86, 108);
        path.lineTo(93, 118);
        path.lineTo(91, 127);
        path.lineTo(99, 131);
        path.lineTo(108, 127);
        path.lineTo(115, 105);
        path.lineTo(134, 79);
        path.lineTo(136, 69);
        path.lineTo(155, 61);
        path.lineTo(161, 55);
        path.lineTo(163, 45);
        path.lineTo(175, 46);
        path.lineTo(181, 42);
        path.lineTo(194, 35);
        path.lineTo(187, 22);
        path.lineTo(179, 18);
        path.lineTo(172, 22);
        path.lineTo(145, 25);
        path.lineTo(112, 32);
        path.lineTo(108, 13);
        path.lineTo(90, 1);
        path.lineTo(79, 53);
        path.lineTo(44, 58);
        path.lineTo(26, 73);
        path.lineTo(21, 89);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createQuebec() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(66, 104);
        path.lineTo(57, 108);
        path.lineTo(50, 95);
        path.lineTo(42, 91);
        path.lineTo(35, 95);
        path.lineTo(8, 98);
        path.lineTo(12, 89);
        path.lineTo(2, 83);
        path.lineTo(4, 64);
        path.lineTo(13, 49);
        path.lineTo(22, 40);
        path.lineTo(28, 28);
        path.lineTo(25, 19);
        path.lineTo(38, 11);
        path.lineTo(35, 1);
        path.lineTo(51, 3);
        path.lineTo(61, 16);
        path.lineTo(63, 24);
        path.lineTo(74, 17);
        path.lineTo(80, 28);
        path.lineTo(81, 36);
        path.lineTo(102, 43);
        path.lineTo(99, 46);
        path.lineTo(103, 49);
        path.lineTo(99, 57);
        path.lineTo(87, 60);
        path.lineTo(76, 71);
        path.lineTo(65, 73);
        path.lineTo(59, 71);
        path.lineTo(45, 79);
        path.lineTo(59, 82);
        path.lineTo(70, 94);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createWesternAmerica() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(26, 12);
        path.lineTo(29, 1);
        path.lineTo(135, 1);
        path.lineTo(116, 53);
        path.lineTo(100, 58);
        path.lineTo(82, 73);
        path.lineTo(77, 89);
        path.lineTo(67, 107);
        path.lineTo(53, 107);
        path.lineTo(31, 103);
        path.lineTo(20, 92);
        path.lineTo(5, 85);
        path.lineTo(1, 77);
        path.lineTo(7, 40);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createOntario() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(78, 52);
        path.lineTo(87, 60);
        path.lineTo(85, 79);
        path.lineTo(95, 85);
        path.lineTo(91, 94);
        path.lineTo(58, 101);
        path.lineTo(54, 82);
        path.lineTo(36, 70);
        path.lineTo(25, 70);
        path.lineTo(2, 1);
        path.lineTo(24, 1);
        path.lineTo(54, 19);
        path.lineTo(61, 28);
        path.lineTo(74, 24);
        path.lineTo(87, 23);
        path.lineTo(91, 33);
        path.lineTo(81, 39);
        path.lineTo(83, 47);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createGreenland() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(68, 10);
        path.lineTo(51, 23);
        path.lineTo(33, 23);
        path.lineTo(22, 27);
        path.lineTo(9, 37);
        path.lineTo(2, 43);
        path.lineTo(6, 51);
        path.lineTo(22, 52);
        path.lineTo(31, 50);
        path.lineTo(39, 56);
        path.lineTo(40, 59);
        path.lineTo(47, 66);
        path.lineTo(42, 77);
        path.lineTo(53, 82);
        path.lineTo(44, 91);
        path.lineTo(50, 108);
        path.lineTo(64, 130);
        path.lineTo(72, 127);
        path.lineTo(80, 116);
        path.lineTo(116, 85);
        path.lineTo(120, 80);
        path.lineTo(132, 77);
        path.lineTo(136, 71);
        path.lineTo(142, 58);
        path.lineTo(154, 50);
        path.lineTo(148, 33);
        path.lineTo(150, 25);
        path.lineTo(158, 22);
        path.lineTo(150, 14);
        path.lineTo(132, 10);
        path.lineTo(130, 5);
        path.lineTo(97, 1);
        path.lineTo(68, 10);
        path.closePath();
        return transformShape(path);
    }

    public static Shape createGreenlandOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(79, 17);
        path.lineTo(62, 0);
        path.lineTo(44, 30);
        path.lineTo(33, 34);
        path.lineTo(20, 44);
        path.lineTo(20, 50);
        path.lineTo(13, 55);
        path.lineTo(17, 59);
        path.lineTo(33, 60);
        path.lineTo(42, 58);
        path.lineTo(50, 63);
        path.lineTo(51, 67);
        path.lineTo(58, 73);
        path.lineTo(53, 84);
        path.lineTo(64, 89);
        path.lineTo(55, 98);
        path.lineTo(55, 116);
        path.lineTo(61, 116);
        path.lineTo(75, 137);
        path.lineTo(83, 134);
        path.lineTo(91, 123);
        path.lineTo(91, 106);
        path.lineTo(127, 92);
        path.lineTo(131, 87);
        path.lineTo(143, 84);
        path.lineTo(147, 78);
        path.lineTo(153, 78);
        path.lineTo(156, 65);
        path.lineTo(165, 58);
        path.lineTo(165, 48);
        path.lineTo(159, 40);
        path.lineTo(161, 33);
        path.lineTo(169, 30);
        path.lineTo(161, 22);
        path.lineTo(143, 17);
        path.lineTo(141, 12);
        path.lineTo(108, 9);
        path.closePath();
        return transformShape(path);
    }

    public final Shape shapeNorthAmericaOutline = createNorthAmericaOutline();
    public final Shape shapeAlaska = createAlaska();
    public final Shape shapeNorthwest = createNorthwest();
    public final Shape shapeAlberta = createAlberta();
    public final Shape shapeOntario = createOntario();
    public final Shape shapeQuebec = createQuebec();
    public final Shape shapeGreenland = createGreenland();
    public final Shape shapeGreenlandOutline = createGreenlandOutline();
    public final Shape shapeWesternAmerica = createWesternAmerica();
    public final Shape shapeEasternAmerica = createEasternAmerica();
    public final Shape shapeCentralAmerica = createCentralAmerica();

}
