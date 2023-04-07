package ui.map;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class MapGraphics {

    private static double scale = 1;

    public static void setScale(double newScale) {
        scale = newScale;
    }

    public static double getScale() {
        return scale;
    }

    public static Shape createNorthAmericaOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(62.5, 81.5);
        path.lineTo(83, 60);
        path.lineTo(102, 52);
        path.lineTo(140, 52);
        path.lineTo(153.5, 61.5);
        path.lineTo(171.5, 60);
        path.lineTo(188, 69.5);
        path.lineTo(210, 63.5);
        path.lineTo(215.5, 56);
        path.lineTo(240, 56);
        path.lineTo(278.5, 77.5);
        path.lineTo(308.5, 69.5);
        path.lineTo(335, 69.5);
        path.lineTo(345, 63.5);
        path.lineTo(345, 54);
        path.lineTo(363.5, 36);
        path.lineTo(372.5, 31.5);
        path.lineTo(383.5, 31.5);
        path.lineTo(377.5, 46.5);
        path.lineTo(363.5, 54);
        path.lineTo(365, 63.5);
        path.lineTo(377.5, 66.5);
        path.lineTo(399.5, 66.5);
        path.lineTo(395.5, 79.5);
        path.lineTo(381.5, 85.5);
        path.lineTo(371, 96.5);
        path.lineTo(358, 96.5);
        path.lineTo(323.5, 122);
        path.lineTo(317, 144.5);
        path.lineTo(332, 156.5);
        path.lineTo(349.5, 152);
        path.lineTo(365, 150.5);
        path.lineTo(371, 163);
        path.lineTo(358, 171);
        path.lineTo(360, 181);
        path.lineTo(354.5, 186.5);
        path.lineTo(365, 197);
        path.lineTo(377.5, 178);
        path.lineTo(377.5, 173);
        path.lineTo(388.5, 166);
        path.lineTo(395.5, 152);
        path.lineTo(392.5, 139.5);
        path.lineTo(409, 130);
        path.lineTo(405.5, 117);
        path.lineTo(425.5, 119);
        path.lineTo(438.5, 135.5);
        path.lineTo(441, 146.5);
        path.lineTo(454.5, 137);
        path.lineTo(462, 152);
        path.lineTo(466.5, 152);
        path.lineTo(464, 161);
        path.lineTo(489.5, 171);
        path.lineTo(486.5, 174.5);
        path.lineTo(491, 178);
        path.lineTo(486.5, 188);
        path.lineTo(471.5, 192.5);
        path.lineTo(471.5, 197);
        path.lineTo(457.5, 206);
        path.lineTo(443, 208.5);
        path.lineTo(435.5, 206);
        path.lineTo(417.5, 216);
        path.lineTo(435.5, 220.5);
        path.lineTo(449.5, 235);
        path.lineTo(444.5, 248);
        path.lineTo(433, 252.5);
        path.lineTo(428.5, 261.5);
        path.lineTo(416, 267.5);
        path.lineTo(409, 266);
        path.lineTo(394, 266);
        path.lineTo(391, 278.5);
        path.lineTo(383.5, 286.5);
        path.lineTo(359, 296);
        path.lineTo(356, 309.5);
        path.lineTo(332, 330.5);
        path.lineTo(332, 342);
        path.lineTo(324, 370.5);
        path.lineTo(312, 375);
        path.lineTo(302.5, 370.5);
        path.lineTo(305, 358.5);
        path.lineTo(296, 345.5);
        path.lineTo(266.5, 340.5);
        path.lineTo(218, 347.5);
        path.lineTo(210.5, 360.5);
        path.lineTo(189.5, 370.5);
        path.lineTo(187.5, 388.5);
        path.lineTo(201, 403);
        path.lineTo(215.5, 400.5);
        path.lineTo(221, 390.5);
        path.lineTo(241.5, 390.5);
        path.lineTo(223.5, 408.5);
        path.lineTo(227, 415);
        path.lineTo(210.5, 443);
        path.lineTo(215.5, 451);
        path.lineTo(209, 476.5);
        path.lineTo(197.5, 478.5);
        path.lineTo(183.5, 469);
        path.lineTo(167, 426);
        path.lineTo(135.5, 413);
        path.lineTo(135.5, 397.5);
        path.lineTo(120, 390.5);
        path.lineTo(111, 368.5);
        path.lineTo(116.5, 352);
        path.lineTo(114, 331.5);
        path.lineTo(121.5, 316);
        path.lineTo(121.5, 306.5);
        path.lineTo(116.5, 292);
        path.lineTo(124.5, 259.5);
        path.lineTo(148.5, 223.5);
        path.lineTo(151.5, 209.5);
        path.lineTo(140, 170.5);
        path.lineTo(128, 140.5);
        path.lineTo(116.5, 129);
        path.lineTo(86, 131);
        path.lineTo(68, 142.5);
        path.lineTo(62.5, 129);
        path.closePath();
        AffineTransform transform = new AffineTransform();
        transform.scale(scale, scale);
        return path.createTransformedShape(transform);
    }

    public static Shape createGreenlandOutline() {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(121.5, 35.5);
        path.lineTo(99.5, 35.5);
        path.lineTo(77, 52.5);
        path.lineTo(63, 57);
        path.lineTo(45.5, 70);
        path.lineTo(45.5, 78);
        path.lineTo(37.5, 83.5);
        path.lineTo(42.5, 88.5);
        path.lineTo(63, 89.5);
        path.lineTo(73.5, 87);
        path.lineTo(84, 94);
        path.lineTo(85.5, 98.5);
        path.lineTo(94.5, 106.5);
        path.lineTo(88.5, 120.5);
        path.lineTo(102.5, 127);
        path.lineTo(90.5, 138.5);
        path.lineTo(90.5, 161);
        path.lineTo(97.5, 161);
        path.lineTo(116.5, 188.5);
        path.lineTo(126.5, 184.5);
        path.lineTo(136.5, 170.5);
        path.lineTo(136.5, 149);
        path.lineTo(181.5, 131);
        path.lineTo(187, 124.5);
        path.lineTo(202.5, 120.5);
        path.lineTo(207.5, 113.5);
        path.lineTo(214.5, 113.5);
        path.lineTo(219, 96.5);
        path.lineTo(230, 87);
        path.lineTo(230, 74.5);
        path.lineTo(223, 65);
        path.lineTo(225, 55.5);
        path.lineTo(236, 51.5);
        path.lineTo(225, 41.5);
        path.lineTo(202.5, 35.5);
        path.lineTo(200, 29);
        path.lineTo(158, 25);
        path.closePath();
        AffineTransform transform = new AffineTransform();
        transform.scale(scale, scale);
        return path.createTransformedShape(transform);
    }

    public static Shape createGreenland() {

    }

}
