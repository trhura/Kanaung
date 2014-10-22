package org.gdgyangon.kanaung;

/**
 * Created by trhura on 10/22/14.
 */
public class Converter {
// Zawgyi<>Unicode converter python module
// Based on rules from Parabaik Myanmar Text Converter
// Copyright (C) 2014 Ngwe Tun (Solveware Solution)
// Copyright (C) 2014 Ye Mon Kyaw

// This file is part of Paytan.

// Paytan is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// Paytan is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with Foobar.  If not, see <http://www.gnu.org/licenses/>.

    public static String zg12uni51(String input_text) {
        String output_text = input_text;
        output_text = output_text.replaceAll("\\u106a", "\u1009");
        output_text = output_text.replaceAll("\\u1025(?=[\\u1039\\u102c])", "\u1009");
        output_text = output_text.replaceAll("\\u1025\\u102e", "\u1026");
        output_text = output_text.replaceAll("\\u106b", "\u100a");
        output_text = output_text.replaceAll("\\u1090", "\u101b");
        output_text = output_text.replaceAll("\\u1040", "\u1040");
        output_text = output_text.replaceAll("\\u108f", "\u1014");
        output_text = output_text.replaceAll("\\u1012", "\u1012");
        output_text = output_text.replaceAll("\\u1013", "\u1013");
        output_text = output_text.replaceAll("[\\u103d\\u1087]", "\u103d");
        output_text = output_text.replaceAll("\\u103c", "\u103d");
        output_text = output_text.replaceAll("[\\u103b\\u107e\\u107f\\u1080\\u1081\\u1082\\u1083\\u1084]", "\u103c");
        output_text = output_text.replaceAll("[\\u103a\\u107d]", "\u103b");
        output_text = output_text.replaceAll("\\u103d\\u103b", "\u103b\u103d");
        output_text = output_text.replaceAll("\\u108a", "\u103d\u103d");
        output_text = output_text.replaceAll("\\u103d\\u103d", "\u103d\u103d");
        output_text = output_text.replaceAll("((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u1064", "\u1064$1$2$3");
        output_text = output_text.replaceAll("((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u108b", "\u1064$1$2$3\u102d");
        output_text = output_text.replaceAll("((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u108c", "\u1064$1$2$3\u102e");
        output_text = output_text.replaceAll("((?:\\u1031)?)((?:\\u103c)?)([\\u1000-\\u1021])\\u108d", "\u1064$1$2$3\u1036");
        output_text = output_text.replaceAll("\\u105a", "\u102b\u103a");
        output_text = output_text.replaceAll("\\u108e", "\u102d\u1036");
        output_text = output_text.replaceAll("\\u1033", "\u102f");
        output_text = output_text.replaceAll("\\u1034", "\u1030");
        output_text = output_text.replaceAll("\\u1088", "\u103d\u102f");
        output_text = output_text.replaceAll("\\u1089", "\u103d\u1030");
        output_text = output_text.replaceAll("\\u1039", "\u103a");
        output_text = output_text.replaceAll("[\\u1094\\u1095]", "\u1037");
        output_text = output_text.replaceAll("([\\u1000-\\u1021])([\\u102c\\u102d\\u102e\\u1032\\u1036]){1,2}([\\u1060\\u1061\\u1062\\u1063\\u1065\\u1066\\u1067\\u1068\\u1069\\u1070\\u1071\\u1072\\u1073\\u1074\\u1075\\u1076\\u1077\\u1078\\u1079\\u107a\\u107b\\u107c\\u1085])", "$1$3$2");
        output_text = output_text.replaceAll("\\u1064", "\u1004\u103a\u1039");
        output_text = output_text.replaceAll("\\u104e", "\u104e\u1004\u103a\u1038");
        output_text = output_text.replaceAll("\\u1086", "\u103f");
        output_text = output_text.replaceAll("\\u1060", "\u1039\u1000");
        output_text = output_text.replaceAll("\\u1061", "\u1039\u1001");
        output_text = output_text.replaceAll("\\u1062", "\u1039\u1002");
        output_text = output_text.replaceAll("\\u1063", "\u1039\u1003");
        output_text = output_text.replaceAll("\\u1065", "\u1039\u1005");
        output_text = output_text.replaceAll("[\\u1066\\u1067]", "\u1039\u1006");
        output_text = output_text.replaceAll("\\u1068", "\u1039\u1007");
        output_text = output_text.replaceAll("\\u1069", "\u1039\u1008");
        output_text = output_text.replaceAll("\\u106c", "\u1039\u100b");
        output_text = output_text.replaceAll("\\u1070", "\u1039\u100f");
        output_text = output_text.replaceAll("[\\u1071\\u1072]", "\u1039\u1010");
        output_text = output_text.replaceAll("[\\u1073\\u1074]", "\u1039\u1011");
        output_text = output_text.replaceAll("\\u1075", "\u1039\u1012");
        output_text = output_text.replaceAll("\\u1076", "\u1039\u1013");
        output_text = output_text.replaceAll("\\u1077", "\u1039\u1014");
        output_text = output_text.replaceAll("\\u1078", "\u1039\u1015");
        output_text = output_text.replaceAll("\\u1079", "\u1039\u1016");
        output_text = output_text.replaceAll("\\u107a", "\u1039\u1017");
        output_text = output_text.replaceAll("\\u107b", "\u1039\u1018");
        output_text = output_text.replaceAll("\\u107c", "\u1039\u1019");
        output_text = output_text.replaceAll("\\u1085", "\u1039\u101c");
        output_text = output_text.replaceAll("\\u106d", "\u1039\u100c");
        output_text = output_text.replaceAll("\\u1091", "\u100f\u1039\u100d");
        output_text = output_text.replaceAll("\\u1092", "\u100b\u1039\u100c");
        output_text = output_text.replaceAll("\\u1097", "\u100b\u1039\u100b");
        output_text = output_text.replaceAll("\\u106f", "\u100e\u1039\u100d");
        output_text = output_text.replaceAll("\\u106e", "\u100d\u1039\u100d");
        output_text = output_text.replaceAll("(\\u103c)([\\u1000-\\u1021])((?:\\u1039[\\u1000-\\u1021])?)", "$2$3$1");
        output_text = output_text.replaceAll("(\\u103d)(\\u103d)([\\u103b\\u103c])", "$3$2$1");
        output_text = output_text.replaceAll("(\\u103d)([\\u103b\\u103c])", "$2$1");
        output_text = output_text.replaceAll("(\\u103d)([\\u103b\\u103c])", "$2$1");
        //output_text = output_text.replaceAll("(?<=([\\u1000-\\u101c\\u101e-\\u102a\\u102c\\u102e-\\u103d\\u104c-\\u109f]))(\\u1040)(?=\\s)?", "\u101d");
        //output_text = output_text.replaceAll("(?<=(\\u101d))(\\u1040)(?=\\s)?", "\u101d");
        //output_text = output_text.replaceAll("(?<=([\\u1000-\\u101c\\u101e-\\u102a\\u102c\\u102e-\\u103d\\u104c-\\u109f\\s]))(\\u1047)", "\u101b");
        output_text = output_text.replaceAll("(\\u1047)(?=[\\u1000-\\u101c\\u101e-\\u102a\\u102c\\u102e-\\u103d\\u104c-\\u109f\\s])", "\u101b");
        output_text = output_text.replaceAll("((?:\\u1031)?)([\\u1000-\\u1021])((?:\\u1039[\\u1000-\\u1021])?)((?:[\\u102d\\u102e\\u1032])?)([\\u1036\\u1037\\u1038]{0,2})([\\u103b-\\u103d]{0,3})((?:[\\u102f\\u1030])?)([\\u1036\\u1037\\u1038]{0,2})((?:[\\u102d\\u102e\\u1032])?)", "$2$3$6$1$4$9$7$5$8");
        output_text = output_text.replaceAll("\\u1036\\u102f", "\u102f\u1036");
        output_text = output_text.replaceAll("(\\u103a)(\\u1037)", "$2$1");
        return output_text;
    }


}
